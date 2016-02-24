package com.zd.hr.dao.sys.Impl;

import org.springframework.stereotype.Repository;

import com.zd.core.dao.BaseDaoImpl;
import com.zd.hr.dao.sys.SysLogDao;
import com.zd.hr.domain.sys.SysLog;

@Repository
public class SysLogDaoImpl extends BaseDaoImpl<SysLog> implements SysLogDao {

    public SysLogDaoImpl() {
        // TODO Auto-generated constructor stub
        super(SysLog.class);
    }

}
