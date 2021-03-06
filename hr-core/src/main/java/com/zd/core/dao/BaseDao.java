package com.zd.core.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.zd.core.support.BaseParameter;
import com.zd.core.support.QueryResult;

/**
 * @框架唯一的升级和技术支持地址：http://shop111863449.taobao.com
 */
public interface BaseDao<E> {

	/**
	 * 持久化对象实体
	 * @param entity 对象实体
	 */
	public void persist(E entity);

	/**
	 * 根据多个id参数删除对象
	 * @param id 多个id，以英文逗号隔开
	 * @return 返回true或者false
	 */
	public boolean deleteByPK(Serializable... id);
	
	/**
	 * 逻辑删除记录
	 * @param ids 要删除的主键ID
	 * @return
	 */
	public boolean deleteByPK(String ids);
		
	/**
	 * 逻辑删除或还原指定的记录
	 * @param ids 要处理的记录的ID
	 * @param isDelete 处理标记
	 * @return
	 */
	public boolean logicDelOrRestore(String ids,String isDelete);
	/**
	 * 删除对象实体
	 * @param entity 对象实体
	 */
	public void delete(E entity);

	/**
	 * 以HQL的方式，根据单个属性删除对象实体
	 * @param propName 属性名称
	 * @param propValue 属性值
	 */
	public void deleteByProperties(String propName, Object propValue);

	/**
	 * 以HQL的方式，根据多个属性删除对象实体
	 * @param propName 属性名称
	 * @param propValue 属性值
	 */
	public void deleteByProperties(String[] propName, Object[] propValue);

	/**
	 * 根据给定的Detached对象标识符更新对象实体
	 * @param entity 对象实体
	 */
	public void update(E entity);

	/**
	 * 根据多个属性条件更新对象实体多个属性
	 * @param conditionName WHERE子句条件的属性数组名称
	 * @param conditionValue WHERE子句条件的属性数组值
	 * @param propertyName UPDATE子句属性数组名称
	 * @param propertyValue UPDATE子句属性数组值
	 */
	public void updateByProperties(String[] conditionName, Object[] conditionValue, String[] propertyName, Object[] propertyValue);

	/**
	 * 根据单个属性条件更新对象实体多个属性
	 * @param conditionName WHERE子句条件的属性数组名称
	 * @param conditionValue WHERE子句条件的属性数组值
	 * @param propertyName UPDATE子句属性名称
	 * @param propertyValue UPDATE子句属性值
	 */
	public void updateByProperties(String[] conditionName, Object[] conditionValue, String propertyName, Object propertyValue);

	/**
	 * 根据多个属性条件更新对象实体单个属性
	 * @param conditionName WHERE子句条件的属性名称
	 * @param conditionValue WHERE子句条件的属性值
	 * @param propertyName UPDATE子句属性数组名称
	 * @param propertyValue UPDATE子句属性数组值
	 */
	public void updateByProperties(String conditionName, Object conditionValue, String[] propertyName, Object[] propertyValue);

	/**
	 * 根据单个属性条件更新对象实体单个属性
	 * @param conditionName WHERE子句条件的属性名称
	 * @param conditionValue WHERE子句条件的属性值
	 * @param propertyName UPDATE子句属性名称
	 * @param propertyValue UPDATE子句属性值
	 */
	public void updateByProperties(String conditionName, Object conditionValue, String propertyName, Object propertyValue);

	/**
	 * 先删除再插入去更新对象实体
	 * @param entity 待更新的对象实体
	 * @param oldId 已存在的对象实体主键
	 */
	public void update(E entity, Serializable oldId);

	/**
	 * 合并给定的对象实体状态到当前的持久化上下文
	 * @param entity 给定的对象实体
	 * @return 返回对象实体
	 */
	public E merge(E entity);

	/**
	 * 根据ID立即加载持久化对象实体
	 * @param id ID值
	 * @return 返回对象实体
	 */
	public E get(Serializable id);

	/**
	 * 根据ID延迟加载持久化对象实体
	 * @param id ID值
	 * @return 返回对象实体
	 */
	public E load(Serializable id);

	/**
	 * 根据属性数组获取单个对象实体
	 * @param propName 属性数组名称
	 * @param propValue 属性数组值
	 * @return 返回对象实体
	 */
	public E getByProerties(String[] propName, Object[] propValue);

	/**
	 * 根据属性数组和排序条件获取单个对象实体
	 * @param propName 属性数组名称
	 * @param propValue 属性数组值
	 * @param sortedCondition 排序条件
	 * @return 返回对象实体
	 */
	public E getByProerties(String[] propName, Object[] propValue, Map<String, String> sortedCondition);

	/**
	 * 根据属性获取单个对象实体
	 * @param propName 属性名称
	 * @param propValue 属性值
	 * @return 返回对象实体
	 */
	public E getByProerties(String propName, Object propValue);

	/**
	 * 根据属性和排序条件获取单个对象实体
	 * @param propName 属性名称
	 * @param propValue 属性值
	 * @param sortedCondition 排序条件
	 * @return 返回对象实体
	 */
	public E getByProerties(String propName, Object propValue, Map<String, String> sortedCondition);

	/**
	 * 根据属性、排序条件和要返回的记录数目获取对象实体列表
	 * @param propName 属性数组名称
	 * @param propValue 属性数组值
	 * @param sortedCondition 排序条件
	 * @param top 要返回的记录数目
	 * @return 返回对象实体列表
	 */
	public List<E> queryByProerties(String[] propName, Object[] propValue, Map<String, String> sortedCondition, Integer top);

	/**
	 * 根据属性和排序条件获取对象实体列表
	 * @param propName 属性数组名称
	 * @param propValue 属性数组值
	 * @param sortedCondition 排序条件
	 * @return 返回对象实体列表
	 */
	public List<E> queryByProerties(String[] propName, Object[] propValue, Map<String, String> sortedCondition);

	/**
	 * 根据属性和要返回的记录数目获取对象实体列表
	 * @param propName 属性数组名称
	 * @param propValue 属性数组值
	 * @param top 要返回的记录数目
	 * @return 返回对象实体列表
	 */
	public List<E> queryByProerties(String[] propName, Object[] propValue, Integer top);

	/**
	 * 根据属性获取对象实体列表
	 * @param propName 属性数组名称
	 * @param propValue 属性数组值
	 * @return
	 */
	public List<E> queryByProerties(String[] propName, Object[] propValue);

	/**
	 * 根据属性、排序条件和要返回的记录数目获取对象实体列表
	 * @param propName 属性名称
	 * @param propValue 属性值
	 * @param sortedCondition 排序条件
	 * @param top 要返回的记录数目
	 * @return 返回对象实体列表
	 */
	public List<E> queryByProerties(String propName, Object propValue, Map<String, String> sortedCondition, Integer top);

	/**
	 * 根据属性和排序条件获取对象实体列表
	 * @param propName 属性名称
	 * @param propValue 属性值
	 * @param sortedCondition 排序条件
	 * @return 返回对象实体列表
	 */
	public List<E> queryByProerties(String propName, Object propValue, Map<String, String> sortedCondition);

	/**
	 * 根据属性和要返回的记录数目获取对象实体列表
	 * @param propName 属性名称
	 * @param propValue 属性值
	 * @param top 要返回的记录数目
	 * @return 返回对象实体列表
	 */
	public List<E> queryByProerties(String propName, Object propValue, Integer top);

	/**
	 * 根据属性获取对象实体列表
	 * @param propName 属性名称
	 * @param propValue 属性值
	 * @return 返回对象实体列表
	 */
	public List<E> queryByProerties(String propName, Object propValue);

	/**
	 * 彻底清除会话
	 */
	public void clear();

	/**
	 * 从会话缓存中删除此对象实体
	 * @param entity 待删除的对象实体
	 */
	public void evict(E entity);

	/**
	 * 查询出对象实体的所有数目
	 * @return 返回对象实体所有数目
	 */
	public Long countAll();

	/**
	 * 查询出所有的对象实体列表
	 * @return 返回对象实体列表
	 */
	public List<E> doQueryAll();

	/**
	 * 根据排序条件和要返回的记录数目查询出对象实体列表
	 * @param sortedCondition 排序条件
	 * @param top 要返回的记录数目
	 * @return 返回对象实体列表
	 */
	public List<E> doQueryAll(Map<String, String> sortedCondition, Integer top);

	/**
	 * 根据要返回的记录数目查询出对象实体列表
	 * @param top 要返回的记录数目
	 * @return 返回对象实体列表
	 */
	public List<E> doQueryAll(Integer top);

	/**
	 * 根据各种查询条件返回对象实体数目
	 * @param parameter 各种查询条件
	 * @return 返回对象实体数目
	 */
	public Long doCount(BaseParameter parameter);

	/**
	 * 根据各种查询条件返回对象实体列表
	 * @param parameter 各种查询条件
	 * @return 返回对象实体列表
	 */
	public List<E> doQuery(BaseParameter parameter);

	/**
	 * 根据SQL查询实体列表
	 * @param sql
	 * @return
	 */
	public List<E> doQuery(String sql);
	/**
	 * 根据各种查询条件返回分页列表
	 * @param parameter 各种查询条件
	 * @return 返回分页列表
	 */
	public QueryResult<E> doPaginationQuery(BaseParameter parameter);

	/**
	 * 根据各种查询条件返回分页列表
	 * @param parameter 各种查询条件
	 * @param bool 默认为true；如果为false，增加属性是否为空等查询条件
	 * @return 返回分页列表
	 */
	public QueryResult<E> doPaginationQuery(BaseParameter parameter, boolean bool);

    public List<E> queryByHql(String hql,Integer start,Integer limit);
    
    /**
     * 根据HQL查询条件查询总记录
     * @param whereSql
     * @return
     */
    public Integer getCount(String hql);  
    
    /**
     * 执行hql语句
     * @param hql
     * @return
     */
    public int executeHql(String hql);
    
    /**
     * 判断字段的值是否存在 如果是插入id赋值-1或者new Guid,如果是修改id赋值 要修改项的值
     * @param fieldName 要判断的字段
     * @param fieldValue 要判断的字段的值
     * @param id 实体的标识
     * @param where 附加查询条件
     * @return
     */
    public boolean IsFieldExist( String fieldName, String fieldValue, String id, String where );
    
    /**
     * 判断字段的值是否存在 如果是插入id赋值-1或者new Guid,如果是修改id赋值 要修改项的值
     * @param fieldName 要判断的字段
     * @param fieldValue 要判断的字段的值
     * @param id 实体的标识
     * @return
     */
    public boolean IsFieldExist( String fieldName, String fieldValue, String id );
    
}
