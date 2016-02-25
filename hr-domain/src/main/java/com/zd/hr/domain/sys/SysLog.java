package com.zd.hr.domain.sys;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.zd.core.annotation.FieldInfo;
import com.zd.core.domain.BaseEntity;

/**
 * <p>Project: Credo's Base</p>
 * <p>Description: 系统日志实体类</p>
 * <p>Copyright (c) 2016 YmpcSoft.All Rights Reserved.</p>
 * @author <a href="autumnal_wind@yeah.net">LuoYiBo</a>
 */
@Entity
@Table(name="HR_SYS_LOG")
public class SysLog extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @GeneratedValue(generator = "uuid")
    @FieldInfo(name="主键")
    @Column(name = "LOG_ID")
    private String logId;
    
    @FieldInfo(name="日志IP")
    @Column(name="LOG_IP")
    private String logIp;
    
    @FieldInfo(name="日志类型")
    @Column(name="LOG_TYPE")
    private String logTYpe;

    public String getLogId() {
        return logId;
    }

    public void setLogId(String logId) {
        this.logId = logId;
    }

    public String getLogIp() {
        return logIp;
    }

    public void setLogIp(String logIp) {
        this.logIp = logIp;
    }

    public String getLogTYpe() {
        return logTYpe;
    }

    public void setLogTYpe(String logTYpe) {
        this.logTYpe = logTYpe;
    }
}
