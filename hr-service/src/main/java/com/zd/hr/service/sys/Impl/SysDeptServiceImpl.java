package com.zd.hr.service.sys.Impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zd.core.service.BaseServiceImpl;
import com.zd.hr.dao.sys.SysDeptDao;
import com.zd.hr.domain.sys.SysDept;
import com.zd.hr.service.sys.SysDeptService;


@Service
public class SysDeptServiceImpl extends BaseServiceImpl<SysDept> implements SysDeptService{

    @Resource
    public void setSysLogDao(SysDeptDao sysLogDao) {
        this.dao = sysLogDao;
    }
}
