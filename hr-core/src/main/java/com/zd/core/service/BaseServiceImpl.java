package com.zd.core.service;

import com.zd.core.dao.BaseDao;
import com.zd.core.dao.BaseDaoImpl;
import com.zd.core.domain.extjs.JSONTreeNode;
import com.zd.core.support.BaseParameter;
import com.zd.core.support.QueryResult;
import com.zd.core.util.StringUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class BaseServiceImpl<E> implements BaseService<E> {
    protected BaseDao<E> dao;

    public void persist(E entity) {
        this.dao.persist(entity);
    }

    public boolean deleteByPK(Serializable[] id) {
        return this.dao.deleteByPK(id);
    }

    public void delete(E entity) {
        this.dao.delete(entity);
    }

    public void deleteByProperties(String[] propName, Object[] propValue) {
        this.dao.deleteByProperties(propName, propValue);
    }

    public void deleteByProperties(String propName, Object propValue) {
        this.dao.deleteByProperties(propName, propValue);
    }

    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public E get(Serializable id) {
        return this.dao.get(id);
    }

    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public E getByProerties(String[] propName, Object[] propValue) {
        return this.dao.getByProerties(propName, propValue);
    }

    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public E getByProerties(String propName, Object propValue) {
        return this.dao.getByProerties(propName, propValue);
    }

    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public E getByProerties(String[] propName, Object[] propValue, Map<String, String> sortedCondition) {
        return this.dao.getByProerties(propName, propValue, sortedCondition);
    }

    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public E getByProerties(String propName, Object propValue, Map<String, String> sortedCondition) {
        return this.dao.getByProerties(propName, propValue, sortedCondition);
    }

    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public E load(Serializable id) {
        return this.dao.load(id);
    }

    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public List<E> queryByProerties(String[] propName, Object[] propValue) {
        return this.dao.queryByProerties(propName, propValue);
    }

    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public List<E> queryByProerties(String propName, Object propValue) {
        return this.dao.queryByProerties(propName, propValue);
    }

    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public List<E> queryByProerties(String[] propName, Object[] propValue, Map<String, String> sortedCondition) {
        return this.dao.queryByProerties(propName, propValue, sortedCondition);
    }

    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public List<E> queryByProerties(String propName, Object propValue, Map<String, String> sortedCondition) {
        return this.dao.queryByProerties(propName, propValue, sortedCondition);
    }

    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public List<E> queryByProerties(String[] propName, Object[] propValue, Map<String, String> sortedCondition,
            Integer top) {
        return this.dao.queryByProerties(propName, propValue, sortedCondition, top);
    }

    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public List<E> queryByProerties(String[] propName, Object[] propValue, Integer top) {
        return this.dao.queryByProerties(propName, propValue, top);
    }

    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public List<E> queryByProerties(String propName, Object propValue, Map<String, String> sortedCondition,
            Integer top) {
        return this.dao.queryByProerties(propName, propValue, sortedCondition, top);
    }

    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public List<E> queryByProerties(String propName, Object propValue, Integer top) {
        return this.dao.queryByProerties(propName, propValue, top);
    }

    public E merge(E entity) {
        return this.dao.merge(entity);
    }

    public void update(E entity) {
        this.dao.update(entity);
    }

    public void updateByProperties(String[] conditionName, Object[] conditionValue, String[] propertyName,
            Object[] propertyValue) {
        this.dao.updateByProperties(conditionName, conditionValue, propertyName, propertyValue);
    }

    public void updateByProperties(String conditionName, Object conditionValue, String[] propertyName,
            Object[] propertyValue) {
        this.dao.updateByProperties(conditionName, conditionValue, propertyName, propertyValue);
    }

    public void updateByProperties(String[] conditionName, Object[] conditionValue, String propertyName,
            Object propertyValue) {
        this.dao.updateByProperties(conditionName, conditionValue, propertyName, propertyValue);
    }

    public void updateByProperties(String conditionName, Object conditionValue, String propertyName,
            Object propertyValue) {
        this.dao.updateByProperties(conditionName, conditionValue, propertyName, propertyValue);
    }

    public void update(E entity, Serializable oldId) {
        this.dao.update(entity, oldId);
    }

    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public List<E> doQueryAll() {
        return this.dao.doQueryAll();
    }

    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public List<E> doQueryAll(Map<String, String> sortedCondition, Integer top) {
        return this.dao.doQueryAll(sortedCondition, top);
    }

    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public List<E> doQueryAll(Integer top) {
        return this.dao.doQueryAll(top);
    }

    public void evict(E entity) {
        this.dao.evict(entity);
    }

    public void clear() {
        this.dao.clear();
    }

    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public Long countAll() {
        return this.dao.countAll();
    }

    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public Long doCount(BaseParameter parameter) {
        return this.dao.doCount(parameter);
    }

    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public List<E> doQuery(BaseParameter parameter) {
        return this.dao.doQuery(parameter);
    }

    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public QueryResult<E> doPaginationQuery(BaseParameter parameter) {
        return this.dao.doPaginationQuery(parameter);
    }

    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public QueryResult<E> doPaginationQuery(BaseParameter parameter, boolean bool) {
        return this.dao.doPaginationQuery(parameter, bool);
    }

    public JSONTreeNode buildJSONTreeNode(List<JSONTreeNode> list, String rootId) {
        // TODO Auto-generated method stub
        JSONTreeNode root = new JSONTreeNode();
        for (JSONTreeNode node : list) {
            if (!(StringUtils.isNotEmpty(node.getParent()) && !node.getId().equals(rootId))) {
                root = node;
                list.remove(node);
                break;
            }
        }
        createTreeChildren(list, root);
        return root;
    }

    private void createTreeChildren(List<JSONTreeNode> childrens, JSONTreeNode root) {
        String parentId = root.getId();
        for (int i = 0; i < childrens.size(); i++) {
            JSONTreeNode node = childrens.get(i);
            if (StringUtils.isNotEmpty(node.getParent()) && node.getParent().equals(parentId)) {
                root.getChildren().add(node);
                createTreeChildren(childrens, node);
            }
            if (i == childrens.size() - 1) {
                if (root.getChildren().size() < 1) {
                    root.setLeaf(true);
                }
                return;
            }
        }
    }

    public List<JSONTreeNode> getTreeList(String rootId, String tableName, String whereSql, JSONTreeNode template,
            Boolean expanded) {
        // TODO Auto-generated method stub
        List<JSONTreeNode> chilrens = new ArrayList<JSONTreeNode>();
        StringBuffer filedSql = new StringBuffer();
        filedSql.append("[" + template.getId() + "],");
        filedSql.append("[" + template.getText() + "],");
        filedSql.append("[" + template.getCode() + "],");
        filedSql.append("[" + template.getNodeType() + "],");
        filedSql.append("[" + template.getNodeInfo() + "],");
        filedSql.append("[" + template.getNodeInfoType() + "],");
        filedSql.append("[" + template.getParent() + "],");
        filedSql.append("[OrderIndex]");
        if (StringUtils.isNotEmpty(template.getIcon())) {
            filedSql.append(",[" + template.getIcon() + "]");
        }
        if (StringUtils.isNotEmpty(template.getHref())) {
            filedSql.append(",[" + template.getHref() + "]");
        }
        if (StringUtils.isNotEmpty(template.getBigIcon())) {
            filedSql.append(",[" + template.getBigIcon() + "]");
        }
        StringBuffer sql = new StringBuffer();
        sql.append("with ctr_child(" + filedSql.toString() + ") as (");
        sql.append(" select " + filedSql.toString() + " from " + tableName + " where 1=1 and [" + template.getId()
                + "] = '" + rootId + "'");
        String childSql = filedSql.toString();
        childSql = "a." + childSql;
        childSql = childSql.replace(",", ",a.");
        sql.append(" union all select " + childSql + " from " + tableName + " a inner join ctr_child b on");
        sql.append(" (a.[" + template.getParent() + "]=b.[" + template.getId() + "]) )");
        sql.append(" select * from ctr_child where 1=1");
        
        if (StringUtils.isNotEmpty(whereSql)) {
            sql.append(whereSql);
        }
        sql.append(" ORDER BY [" + template.getParent() + "] asc, [orderIndex] asc ");

        List<?> alist = this.dao.doQuery(sql.toString());
        for (int i = 0; i < alist.size(); i++) {
            Object[] obj = (Object[]) alist.get(i);
            JSONTreeNode node = new JSONTreeNode();
            node.setId((String) obj[0]);
            node.setText((String) obj[1]);
            node.setCode((String) obj[2]);
            if (com.zd.core.constant.NodeType.LEAF.equalsIgnoreCase((String) obj[3])) {
                node.setLeaf(true);
            } else {
                node.setLeaf(false);
            }
            node.setNodeInfo((String) obj[4]);
            node.setNodeInfoType((String) obj[5]);
            node.setParent((String) obj[6]);
            if (StringUtils.isNotEmpty((obj[7]) + "")) {
                node.setOrderIndex(Integer.parseInt(obj[7] + ""));
            }
            if (StringUtils.isNotEmpty(template.getIcon())) {
                node.setIcon((String) obj[8]);
                if (StringUtils.isNotEmpty(template.getHref())) {
                    node.setDisabled(Boolean.parseBoolean(obj[9].toString()));
                    if (StringUtils.isNotEmpty(template.getBigIcon())) {
                        node.setBigIcon((String) obj[10]);
                    }
                } else if (StringUtils.isNotEmpty(template.getBigIcon())) {
                    node.setBigIcon((String) obj[9]);
                }
            } else {
                if (StringUtils.isNotEmpty(template.getIcon())) {
                    node.setDisabled(Boolean.parseBoolean(obj[8].toString()));
                    if (StringUtils.isNotEmpty(template.getBigIcon())) {
                        node.setBigIcon((String) obj[9]);
                    }
                } else if (StringUtils.isNotEmpty(template.getBigIcon())) {
                    node.setBigIcon((String) obj[8]);
                }
            }
            if (expanded != null) {
                node.setExpanded(expanded);
            }
            chilrens.add(node);
        }
        return chilrens;
    }

}