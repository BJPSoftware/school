package com.zd.core.domain;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import com.zd.core.annotation.NodeType;
import com.zd.core.constant.TreeNodeType;

@MappedSuperclass
public class TreeBaseEntity extends BaseEntity{

    private static final long serialVersionUID = 1L;
    
    @NodeType(type=TreeNodeType.LAYER)
    @Column(name="NODE_LAYER")
    private Integer nodelayer;
    
    @NodeType(type=TreeNodeType.NODEINFO)
    @Column(name="NODE_INFO")
    private String nodeInfo;
    
    @NodeType(type=TreeNodeType.LEAF)
    @Column(name="NODE_TYPE")
    private String nodeType;
    
    @NodeType(type=TreeNodeType.NODEINFOTYPE)
    @Column(name="NODE_INFOTYPE")
    private String nodeInfoType;
    
    public Integer getNodeLayer() {
        return nodelayer;
    }
    public void setLayer(Integer nodelayer) {
        this.nodelayer = nodelayer;
    }
    public String getNodeInfo() {
        return nodeInfo;
    }
    public void setNodeInfo(String nodeInfo) {
        this.nodeInfo = nodeInfo;
    }
    public String getNodeType() {
        return nodeType;
    }
    public void setNodeType(String nodeType) {
        this.nodeType = nodeType;
    }
    public String getNodeInfoType() {
        return nodeInfoType;
    }
    public void setNodeInfoType(String nodeInfoType) {
        this.nodeInfoType = nodeInfoType;
    }
}
