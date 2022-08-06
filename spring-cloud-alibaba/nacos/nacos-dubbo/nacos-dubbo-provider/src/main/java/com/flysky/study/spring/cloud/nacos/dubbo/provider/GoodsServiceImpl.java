package com.flysky.study.spring.cloud.nacos.dubbo.provider;

import com.flysky.study.spring.cloud.alibaba.naco.dubbo.GoodsDetailDTO;
import com.flysky.study.spring.cloud.alibaba.naco.dubbo.GoodsService;
import org.apache.dubbo.common.extension.ExtensionLoader;
import org.apache.dubbo.common.threadpool.manager.DefaultExecutorRepository;
import org.apache.dubbo.common.threadpool.manager.ExecutorRepository;
import org.apache.dubbo.config.annotation.DubboService;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

@DubboService
public class GoodsServiceImpl implements GoodsService {

    @Override
    public GoodsDetailDTO findGoodsById(Long id) {
        System.out.println("查询数据");
        GoodsDetailDTO goods = new GoodsDetailDTO();
        goods.setGoodsNo(String.valueOf(id));
        goods.setGoodsName("手机");
        goods.setInventory(2);
        goods.setPrice(new BigDecimal("3000"));
        System.out.println("getDubboThreadPoolInfo()=="+getDubboThreadPoolInfo());
        return goods;
    }


    /**
     * 获取Dubbo的线程池
     * @return
     */
    public static ThreadPoolExecutor getDubboThreadPoolInfo(){
        //dubbo线程池数量监控
        try {
            ExtensionLoader<ExecutorRepository> executorRepositoryExtensionLoader = ExtensionLoader.getExtensionLoader(ExecutorRepository.class);
            DefaultExecutorRepository defaultExecutorRepository = (DefaultExecutorRepository) executorRepositoryExtensionLoader.getDefaultExtension();
            Field dataField = defaultExecutorRepository.getClass().getDeclaredField("data");
            dataField.setAccessible(true);
            ConcurrentMap<String, ConcurrentMap<Integer, ExecutorService>> data = (ConcurrentMap<String, ConcurrentMap<Integer, ExecutorService>>) dataField.get(defaultExecutorRepository);
            ConcurrentMap<Integer, ExecutorService> executorServiceConcurrentMap = data.get("java.util.concurrent.ExecutorService");
            //获取到默认的线程池模型
            ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executorServiceConcurrentMap.get(20880);
            return threadPoolExecutor;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
