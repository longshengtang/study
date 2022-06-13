package com.flysky.study.bytecode.bytebuddy.agent;

import net.bytebuddy.agent.ByteBuddyAgent;

import java.io.File;
import java.lang.management.ManagementFactory;
import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Collection;
import java.util.Iterator;

/**
 * 模拟"libattach.so already loaded in another classloader"错误，以及解决方法<br>
 * 为了模拟不同类加载器加载相同的attach库，需要确保classpath不能包含tools.jar文件路径<br>
 */
public class JdkAttach {
    public JdkAttach() {
    }

    public void loadAgent() throws Exception {
        Object virtualMachineInstance = null;
        Class<?> virtualMachineType = null;
        try {
            ClassLoader toolsClassLoader = getToolsClassLoader();
            virtualMachineType = toolsClassLoader.loadClass("com.sun.tools.attach.VirtualMachine");

            String processId = getProcessId();
            virtualMachineInstance = virtualMachineType
                    .getMethod("attach", String.class)
                    .invoke(null, processId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (virtualMachineType != null && virtualMachineInstance != null) {
                virtualMachineType.getMethod("detach").invoke(virtualMachineInstance);
                System.out.println("detach调用完成");
            }
        }
    }

    public String getProcessId() {
        String runtimeName = ManagementFactory.getRuntimeMXBean().getName();
        int processIdIndex = runtimeName.indexOf('@');
        if (processIdIndex == -1) {
            throw new IllegalStateException("Cannot extract process id from runtime management bean");
        } else {
            return runtimeName.substring(0, processIdIndex);
        }
    }

    private ClassLoader getToolsClassLoader() throws MalformedURLException {
        String javaHome = System.getProperty("java.home");
//        File toolsJarFile = new File(javaHome, "../lib/tools.jar");
        File toolsJarFile = new File(javaHome, "../lib/tools.jar");

        if (!toolsJarFile.isFile()) {
            throw new IllegalStateException("文件不存在：" + toolsJarFile.getAbsolutePath());
        }
        URL url = toolsJarFile.toURI().toURL();
        //构建一个parent为ClassLoader.getSystemClassLoader()加载器，因此如果classpath中包含tools.jar，最终加载attach的类加载器就会相同
        URLClassLoader classLoader = new URLClassLoader(new URL[]{url});
        return classLoader;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("=============================================================================");
        System.out.println("------需要确保classpath不能包含tools.jar文件路径：");
        System.out.println("------1、idea运行默认会将tools.jar添加到classpath中，因此需要使用java命令来排除干扰");
        System.out.println("------2、也不要将tools.jar路径添加到CLASSPATH环境变量中");
        System.out.println("=============================================================================");

//        new JdkAttach().loadAgent();
//        solve(args.length > 0 ? args[0] : "");
        ByteBuddyAgent.install();//此方法最终也会使用parent为ClassLoader.getSystemClassLoader()加载器来加载
        solve(args.length > 0 ? args[0] : "");
        ByteBuddyAgent.install();//此方法最终也会使用parent为ClassLoader.getSystemClassLoader()加载器来加载
    }

    private static void solve(String way) {
        String javaClassPath = System.getProperty("java.class.path");
        if (javaClassPath.contains("tools.jar")) {
            System.err.println("java.class.path包含tools.jar文件,请排查：" + javaClassPath);
        }

        if ("way=gc".equals(way)) {
            invokeSystemGc();
        } else if ("way=remove".equals(way)) {
            removeAttachName();
        }
    }


    /**
     * 解决文案一：触发gc
     */
    private static void invokeSystemGc() {
        System.out.println("调用System.gc()");
        System.gc();
    }

    /**
     * 解决文案二：通过反射移除java.lang.ClassLoader#loadedLibraryNames里面的包含attach名称的值
     */
    private static void removeAttachName() {
        String name = System.mapLibraryName("attach");
        try {
            Field loadedLibraryNames = ClassLoader.class.getDeclaredField("loadedLibraryNames");
            loadedLibraryNames.setAccessible(true);
            Collection<String> libnames = (Collection<String>) loadedLibraryNames.get(null);
            Iterator<String> iterator = libnames.iterator();
            while (iterator.hasNext()) {
                String libname = iterator.next();
                if (libname.endsWith(name)) {
                    System.out.println("移除" + libname + "，解除jvm加载lib的限定：同一个lib只能被同一个ClassLoader类加载器加载");
                    iterator.remove();
                    return;
                }
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
