package com.zd.hr.service.sys.Impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zd.core.service.BaseServiceImpl;
import com.zd.hr.dao.sys.SysLogDao;
import com.zd.hr.domain.sys.SysLog;
import com.zd.hr.service.sys.SysLogService;

@Service
public class SysLogServiceImpl extends BaseServiceImpl<SysLog> implements SysLogService{

    @Resource
    public void setSysLogDao(SysLogDao sysLogDao) {
        this.dao = sysLogDao;
    }

}
