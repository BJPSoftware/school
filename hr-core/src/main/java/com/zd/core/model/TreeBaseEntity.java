package com.zd.core.model;

import javax.persistence.MappedSuperclass;

import com.zd.core.annotation.NodeType;
import com.zd.core.constant.TreeNodeType;

/**
 * 树形实体类
 * @author luoyibo
 *
 */
@MappedSuperclass
public class TreeBaseEntity extends BaseEntity {
	@NodeType(type=TreeNodeType.LAYER)
	private Integer layer;
	@NodeType(type=TreeNodeType.NODEINFO)
	private String nodeInfo;
	@NodeType(type=TreeNodeType.LEAF)
	private String nodeType;
	@NodeType(type=TreeNodeType.NODEINFOTYPE)
	private String nodeInfoType;
	public Integer getLayer() {
		return layer;
	}
	public void setLayer(Integer layer) {
		this.layer = layer;
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
