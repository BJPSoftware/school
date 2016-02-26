package com.zd.hr.domain.sys;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zd.core.annotation.FieldInfo;
import com.zd.core.annotation.NodeType;
import com.zd.core.constant.TreeNodeType;
import com.zd.core.domain.TreeBaseEntity;


@Entity
@Table(name="HR_SYS_DEPT")
public class SysDept extends TreeBaseEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @GeneratedValue(generator = "uuid")
    @NodeType(type=TreeNodeType.ID)
    @FieldInfo(name="主键")
    @Column(name = "DEPT_ID")
    private String deptId;
    
    @FieldInfo(name="部门名称")
    @NodeType(type=TreeNodeType.TEXT)
    @Column(name="DEPT_NAME")
    private String deptName;
    
    @FieldInfo(name="部门代码")
    @NodeType(type=TreeNodeType.CODE)
    @Column(name="DEPT_CODE")
    private String deptCode;
    
    /**
     * 上级部门
     */
    @JsonIgnore
    @ManyToOne(optional=true,fetch=FetchType.LAZY)
    @NodeType(type=TreeNodeType.PARENT)
    @JoinColumn(name="PARENT_DEPT")
    private SysDept parentDept;
    
    /**
     * 部门包含的子部门
     */
    @JsonIgnore
    @OneToMany(fetch=FetchType.LAZY,mappedBy="parentDept",cascade={CascadeType.REMOVE})
    @LazyCollection(LazyCollectionOption.TRUE)
    private Set<SysDept> childDept = new HashSet<SysDept>();

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

    public SysDept getParentDept() {
        return parentDept;
    }

    public void setParentDept(SysDept parentDept) {
        this.parentDept = parentDept;
    }

    public Set<SysDept> getChildDept() {
        return childDept;
    }

    public void setChildDept(Set<SysDept> childDept) {
        this.childDept = childDept;
    } 
}
