package com.zd.hr.controller.sys;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.DoubleAdder;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.jdbc.core.DisposableSqlTypeValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mysql.fabric.xmlrpc.base.Data;
import com.zd.core.constant.StringVeriable;
import com.zd.core.controller.BaseController;
import com.zd.core.domain.BaseEntity;
import com.zd.core.support.ListView;
import com.zd.core.support.QueryResult;
import com.zd.core.util.JsonBuilder;
import com.zd.core.util.ModelUtil;
import com.zd.core.util.StringUtils;
import com.zd.hr.domain.sys.SysDept;
import com.zd.hr.domain.sys.SysUser;
import com.zd.hr.service.sys.SysDeptService;
import com.zd.hr.service.sys.SysUserService;

@Controller
@RequestMapping("/sysuser")
public class SysUserController extends BaseController<SysUser> {

    @Resource
    private SysUserService sysUserService;
    
    @Resource
    private SysDeptService sysDeptService;

    @RequestMapping(value = { "/deptuserlist" }, method = { org.springframework.web.bind.annotation.RequestMethod.GET,
            org.springframework.web.bind.annotation.RequestMethod.POST })
    public void deptUserList(@ModelAttribute SysUser entity, HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String strData = "";
        StringBuffer hql = new StringBuffer("from " + entity.getClass().getSimpleName() + " where 1=1");
        StringBuffer countHql = new StringBuffer(
                "select count(*) from " + entity.getClass().getSimpleName() + " where 1=1");
        String whereSql = entity.getWhereSql();
        String parentSql = entity.getParentSql();
        String querySql = entity.getQuerySql();
        String orderSql = entity.getOrderSql();
        int start = entity.getStart();
        int limit = entity.getLimit();
        hql.append(whereSql);
        hql.append(parentSql);
        hql.append(querySql);
        hql.append(orderSql);
        countHql.append(whereSql);
        countHql.append(querySql);
        countHql.append(parentSql);
        List<SysUser> lists = sysUserService.queryByHql(hql.toString(), start, limit);
        Integer count = sysUserService.getCount(countHql.toString());
        strData = JsonBuilder.getInstance().buildObjListToJson(new Long(count), lists, true);
        writeJSON(response, strData);
    }

    @RequestMapping("/doadd")
    public void doAdd(SysUser sysUserModel, HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        String userName = sysUserModel.getUserName();
        //判断用户名不能重复
        if(sysUserService.IsFieldExist("userName", userName, "-1")){
          writeJSON(response, JsonBuilder.getInstance().returnFailureJson("'系统已存在此登录账号！'"));
          return;            
        }
        //生成默认的orderindex
        Integer orderIndex = sysUserService.getDefaultOrderIndex(sysUserModel);
        
        SysUser sysUser = new SysUser();
        sysUser.setUserName(sysUserModel.getUserName());
        sysUser.setUserCh(sysUserModel.getUserCh());
        sysUser.setUserPwd(new Sha256Hash(sysUserModel.getUserPwd()).toHex());
        sysUser.setCreateUser("超级管理员");
        sysUser.setModifyUser("超级管理员");
        sysUser.setOrderIndex(orderIndex);
        sysUser.setUserStatu(sysUserModel.getUserStatu());
        sysUser.setDeptId(sysUserModel.getDeptId());
        sysUser.setDeptCode(sysUserModel.getDeptCode());
        sysUser.setDeptName(sysUserModel.getDeptName());
        
        sysUserModel = sysUserService.merge(sysUser);
        writeJSON(response,JsonBuilder.getInstance().returnSuccessJson(JsonBuilder.getInstance().toJson(sysUserModel)));
    }

    @RequestMapping("/doupdate")
    public void doUpdate(SysUser sysUserModel, HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        String userName = sysUserModel.getUserName();
        String userId = sysUserModel.getUserId();
        
        //判断用户名不能重复
        if(sysUserService.IsFieldExist("userName", userName, userId)){
          writeJSON(response, JsonBuilder.getInstance().returnFailureJson("'系统已存在此登录账号！'"));
          return;            
        }
        SysUser sysUser = sysUserService.get(userId);
        
        sysUser.setUserName(sysUserModel.getUserName());
        sysUser.setUserCh(sysUserModel.getUserCh());
        sysUser.setCreateUser("超级管理员");
        sysUser.setModifyUser("超级管理员");
        sysUser.setUserStatu(sysUserModel.getUserStatu());
        sysUser.setUpdateTime(new Date());
        
        sysUserModel = sysUserService.merge(sysUser);
        writeJSON(response,JsonBuilder.getInstance().returnSuccessJson(JsonBuilder.getInstance().toJson(sysUserModel)));
    }
    
    @RequestMapping("/dosave")
    public void doSave(SysUser sysUserModel, HttpServletRequest request, HttpServletResponse response)
            throws IOException {
      
        String strData = request.getParameter("strData");
        String[] updateSqls=JsonBuilder.getInstance().jsonSqlToString(strData);

        sysUserService.executeBatchHql(updateSqls);
        writeJSON(response, JsonBuilder.getInstance().returnSuccessJson("'" + updateSqls.length+"条记录被更新'"));
    }

    @RequestMapping("/dodelete")
    public void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String delIds = request.getParameter("ids");
        if (StringUtils.isEmpty(delIds)) {
            writeJSON(response, JsonBuilder.getInstance().returnSuccessJson("'没有传入删除主键'"));
            return;
        } else {
            boolean flag = sysUserService.logicDelOrRestore(delIds,StringVeriable.ISDELETE);
            if (flag) {
                writeJSON(response, JsonBuilder.getInstance().returnSuccessJson("'删除成功'"));
            } else {
                writeJSON(response, JsonBuilder.getInstance().returnFailureJson("'删除失败'"));
            }
        }
    }
    @RequestMapping("/dorestore")
    public void doRestore(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String delIds = request.getParameter("ids");
        if (StringUtils.isEmpty(delIds)) {
            writeJSON(response, JsonBuilder.getInstance().returnSuccessJson("'没有传入还原主键'"));
            return;
        } else {
            String[] ids = request.getParameter("ids").split(",");
            boolean flag = sysUserService.logicDelOrRestore(delIds,StringVeriable.ISNOTDELETE);
            if (flag) {
                writeJSON(response, JsonBuilder.getInstance().returnSuccessJson("'还原成功'"));
            } else {
                writeJSON(response, JsonBuilder.getInstance().returnFailureJson("'还原失败'"));
            }
        }
    }
    @Override
    public SysUser getModel() {
        // TODO Auto-generated method stub

        return null;
    }
}
