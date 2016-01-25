/**
 * 
 */
package com.zd.hr.dao.sys.Impl;

import org.springframework.stereotype.Repository;

import com.zd.core.dao.BaseDaoImpl;
import com.zd.hr.dao.sys.SysUserDao;
import com.zd.hr.domain.sys.SysUser;

/**
 * @author luoyibo
 *
 */
@Repository
//public class SysUserDaoImpl extends BaseDao<SysUser> implements SysUserDao
public class SysUserDaoImpl extends BaseDaoImpl<SysUser> implements SysUserDao {
    public SysUserDaoImpl(){
        super(SysUser.class);
    }
}
