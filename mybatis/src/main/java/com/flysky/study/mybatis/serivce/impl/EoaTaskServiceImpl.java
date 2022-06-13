package com.flysky.study.mybatis.serivce.impl;

import com.flysky.study.mybatis.dao.EoaTaskDao;
import com.flysky.study.mybatis.model.EoaTask;
import com.flysky.study.mybatis.serivce.EoaTaskService;
import com.flysky.study.mybatis.serivce.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class EoaTaskServiceImpl implements EoaTaskService {
    @Override
    public List<EoaTask> list() {
        return eoaTaskDao.list();
    }

    @Transactional
    @Override
    public void saveTwoRows() {
//        <eoa_task id="2" task_name="任务名称" task_detail_list="任务详情" status="1" created_by="flysky" created_date="2020-06-20 18:11:10" />
        for (int i = 1; i < 3; i++) {
            EoaTask eoaTask = new EoaTask().setCreatedBy("flysky")
                    .setCreatedDate(new Date())
                    .setStatus(1)
                    .setTaskName("任务名称"+i)
                    .setTaskDetailList("任务详情"+i)
                    ;
            eoaTaskDao.save(eoaTask);
        }
    }

    @Override
    public void save(EoaTask eoaTask) {
        eoaTaskDao.save(eoaTask);
    }

    @Transactional
    @Override
    public void propagationRequiredInnerExceptionCaughtByOuterMethod() {
        try {
            userService.innerThrowException();
        } catch (Exception e) {
        }
    }

    @Autowired
    private SysUserService userService;


    @Autowired
    private EoaTaskDao eoaTaskDao;
}
