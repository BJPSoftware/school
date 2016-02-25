package com.zd.core.domain;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import com.zd.core.annotation.FieldInfo;

/**
 * 业务基本实体
 * @author zhangshuaipeng
 *
 */
@MappedSuperclass
public class BaseExtendEntity extends BaseEntity {

    private static final long serialVersionUID = 1L;
    
    @FieldInfo(name="备用字段1")
    @Column(name="EXT_FIELD01",length=1000)
    private String extField01;
    
    @FieldInfo(name="备用字段2")
    @Column(name="EXT_FIELD02",length=1000)
    private String extField02;
    
    @FieldInfo(name="备用字段3")
    @Column(name="EXT_FIELD03",length=1000)
    private String extField03;
    
    @FieldInfo(name="备用字段4")
    @Column(name="EXT_FIELD04",length=1000)
    private String extField04;
    
    @FieldInfo(name="备用字段5")
    @Column(name="EXT_FIELD05",length=1000)
    private String extField05;

    public String getExtField01() {
        return extField01;
    }

    public void setExtField01(String extField01) {
        this.extField01 = extField01;
    }

    public String getExtField02() {
        return extField02;
    }

    public void setExtField02(String extField02) {
        this.extField02 = extField02;
    }

    public String getExtField03() {
        return extField03;
    }

    public void setExtField03(String extField03) {
        this.extField03 = extField03;
    }

    public String getExtField04() {
        return extField04;
    }

    public void setExtField04(String extField04) {
        this.extField04 = extField04;
    }

    public String getExtField05() {
        return extField05;
    }

    public void setExtField05(String extField05) {
        this.extField05 = extField05;
    }
}
