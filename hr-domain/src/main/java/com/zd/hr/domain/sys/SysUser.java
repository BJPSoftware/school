package com.zd.hr.domain.sys;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

import com.zd.core.support.ExtJSBaseParameter;

/**
 * 
 * Hello world!
 *
 */
// 注解，说明这是实体类
@Entity
@Table(name = "HR_SYS_USER")
public class SysUser extends ExtJSBaseParameter {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @GeneratedValue(generator = "uuid")
    @Column(name = "USER_ID")
    private String userId;

    // 用户名，32长度，不能为空
    @Column(name = "USER_NAME", length = 32, nullable = false)
    private String userName;

    // 用户密码，32长度，不能为空
    @Column(name = "USER_PWD", length = 32, nullable = false)
    private String userPwd;

    // 用户姓名，32长度，不能为空
    @Column(name = "USER_CH", length = 32, nullable = true)
    private String userCh;

    @Column(name = "CREATE_TIME", nullable = false, columnDefinition = "datetime", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime = new Date();

    @Column(name = "UPDATE_TIME", nullable = false, columnDefinition = "datetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime = new Date();

    // 构造函数
    public SysUser() {
        super();
    }

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

    // @JsonSerialize(using = DateTimeSerializer.class)
    public Date getCreatTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    private void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
