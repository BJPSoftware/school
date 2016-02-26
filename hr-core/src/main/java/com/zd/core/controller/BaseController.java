package com.zd.core.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.JsonEncoding;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.ObjectMapper;

import com.opensymphony.xwork2.ModelDriven;
import com.zd.core.domain.BaseEntity;

public abstract class BaseController<E extends BaseEntity> implements ModelDriven<E> {

    protected static ObjectMapper mapper = new ObjectMapper();
    protected static JsonFactory factory = mapper.getJsonFactory();

    protected void writeJSON(HttpServletResponse response, String json) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write(json);
    }

    protected void writeJSON(HttpServletResponse response, Object obj) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        JsonGenerator responseJsonGenerator = factory.createJsonGenerator(response.getOutputStream(),
                JsonEncoding.UTF8);
        responseJsonGenerator.writeObject(obj);
    }

    /**
     * 默认的读取树形方法
     */
//    public void getTree() {
        // Object model=getModel();
        // if(model!=null && model instanceof TreeBaseEntity){
        // Class<?> c=model.getClass();
        // //得到根节点ID
        // if(!(StringUtil.isNotEmpty(node) &&
        // node.equalsIgnoreCase(TreeVeriable.ROOT))){
        // node=TreeVeriable.ROOT;
        // }
        // //得到表名
        // String entityName=c.getSimpleName();
        // //得到模版类
        // JSONTreeNode template=ModelUtil.getJSONTreeNodeTemplate(c);
        // //递归查询出集合
        // List<JSONTreeNode> lists=pcServiceTemplate.getTreeList(node,
        // entityName, whereSql, template);
        // //构建成树形节点对象
        // JSONTreeNode root=pcServiceTemplate.buildJSONTreeNode(lists, node);
        // if(node.equalsIgnoreCase(TreeVeriable.ROOT)){
        // strData=jsonBuilder.buildList(root.getChildren(), excludes);
        // }else{
        // List<JSONTreeNode> alist=new ArrayList<JSONTreeNode>();
        // alist.add(root);
        // strData=jsonBuilder.buildList(root.getChildren(), excludes);
        // }
        // toWrite(strData);
//    }

//    @Override
//    public void setServletRequest(HttpServletRequest request) {
//        // TODO Auto-generated method stub
//        this.request = request;
//    }
//
//    @Override
//    public void setServletResponse(HttpServletResponse response) {
//        // TODO Auto-generated method stub
//        this.response = response;
//    }
}