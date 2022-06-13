public class Test {
    public static void main(String[] args) {
        ThreadLocal<Object> local = new ThreadLocal<>();
        local.set("hello word");
        System.out.println("start---");
        System.load("/Library/Java/JavaVirtualMachines/jdk1.8.0_181.jdk/Contents/Home/jre/lib/libattach.dylib");
        System.out.println("end---");
    }
}
