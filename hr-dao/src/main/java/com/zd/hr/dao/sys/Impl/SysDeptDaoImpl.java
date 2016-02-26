package com.zd.hr.dao.sys.Impl;

import org.springframework.stereotype.Repository;

import com.zd.core.dao.BaseDaoImpl;
import com.zd.hr.dao.sys.SysDeptDao;
import com.zd.hr.domain.sys.SysDept;

@Repository
public class SysDeptDaoImpl extends BaseDaoImpl<SysDept> implements SysDeptDao {

    public SysDeptDaoImpl() {
        // TODO Auto-generated constructor stub
        super(SysDept.class);
    }

}
