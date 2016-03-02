package com.zd.hr.domain.sys;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.hibernate.annotations.GenericGenerator;

import com.zd.core.annotation.FieldInfo;
import com.zd.core.domain.BaseEntity;
import com.zd.core.util.DateTimeSerializer;

/**
 * 系统用户实体类
 * @author luoyibo
 *
 */
@Entity
@Table(name = "HR_SYS_USER")
public class SysUser extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @GeneratedValue(generator = "uuid")
    @FieldInfo(name="主键",type="ID")
    @Column(name = "USER_ID")
    private String userId;

    @FieldInfo(name="用户名")
    @Column(name = "USER_NAME", length = 32)
    private String userName;

    @FieldInfo(name="用户密码")
    @Column(name = "USER_PWD", length = 128)
    private String userPwd;

    @FieldInfo(name="用户姓名")
    @Column(name = "USER_CH", length = 32)
    private String userCh;
    
    @FieldInfo(name="用户状态")
    @Column(name="USER_STATU", columnDefinition="int")
    private Integer userStatu; 
    
    @FieldInfo(name="最后登录时间")
    @Column(name="LAST_LOGIN", columnDefinition = "datetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLogin; 
    
    @FieldInfo(name="部门ID")
    @Column (name="DEPT_ID")
    private String deptId;
    
    @FieldInfo(name="部门名称")
    @Column (name="DEPT_Name")
    private String deptName;    

    @FieldInfo(name="部门代码")
    @Column(name="DEPT_CODE")
    private String deptCode;
    
    @FieldInfo(name="下次自动登录")
    @Transient
    private boolean rememberMe; // 下次自动登录
    
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getUserCh() {
        return userCh;
    }

    public void setUserCh(String userCh) {
        this.userCh = userCh;
    }
    
    public int getUserStatu() {
        return userStatu;
    }

    public void setUserStatu(Integer userStatu) {
        this.userStatu = userStatu;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    @JsonSerialize(using=DateTimeSerializer.class)
    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public boolean isRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(boolean rememberMe) {
        this.rememberMe = rememberMe;
    }
}
