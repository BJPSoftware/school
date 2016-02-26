package com.zd.hr.controller.sys;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.Table;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zd.core.constant.NodeType;
import com.zd.core.constant.TreeVeriable;
import com.zd.core.controller.BaseController;
import com.zd.core.domain.extjs.JSONTreeNode;
import com.zd.core.util.EntityUtil;
import com.zd.core.util.JsonBuilder;
import com.zd.core.util.ModelUtil;
import com.zd.core.util.StringUtils;
import com.zd.hr.domain.sys.SysDept;
import com.zd.hr.service.sys.SysDeptService;

@Controller
@RequestMapping("/sysdept")
public class SysDeptController extends BaseController<SysDept> {

    @Resource
    private SysDeptService SysDeptService;
    /**
     * 部门树形数据
     * 
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping("/getDeptTree")
    public void getDeptTree(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // node:ROOT
        // excludes:checked
        String parentId=request.getParameter("parentId");
        String node = request.getParameter("node");
        String excludes = request.getParameter("excludes");
        String whereSql = request.getParameter("whereSql");
        //boolean expanded = request.getParameter("expanded");
        boolean expanded = true;
        String strData = null;
        
        SysDept sysDept = new SysDept();
        
         if(StringUtils.isEmpty(parentId)){
             parentId=NodeType.ROOT;
         }
        SysDept parentDept = new SysDept();
        parentDept.setDeptId(parentId);
        sysDept.setParentDept(parentDept);
        
        // 得到根节点ID
        if (!(StringUtils.isNotEmpty(node) && node.equalsIgnoreCase(TreeVeriable.ROOT))) {
            node = TreeVeriable.ROOT;
        }
        Class<?> c=sysDept.getClass();
        //表名
        String tableName = ModelUtil.getTableName(c, false);
        //得到模版类
        JSONTreeNode template=ModelUtil.getJSONTreeNodeTemplate(c);
        //递归查询出集合
        //node, entityName, whereSql, template
        List<JSONTreeNode> lists=SysDeptService.getTreeList(node, tableName, whereSql, template, expanded);
        //构建成树形节点对象
        JSONTreeNode root=SysDeptService.buildJSONTreeNode(lists, node);
        if(node.equalsIgnoreCase(TreeVeriable.ROOT)){
            //strData=JsonBuilder.buildList(root.getChildren(), excludes);
            strData = JsonBuilder.getInstance().buildList(root.getChildren(), excludes);
        }else{
            List<JSONTreeNode> alist=new ArrayList<JSONTreeNode>();
            alist.add(root);
            strData = JsonBuilder.getInstance().buildList(root.getChildren(), excludes);   
        }      
        writeJSON(response, strData);
    }
    // public Object getModel() {
    // // TODO Auto-generated method stub
    // String parentId=request.getParameter("parentId");
    // if(StringUtil.isEmpty(parentId)){
    // parentId=NodeType.ROOT;
    // }
    // Department parent=new Department();
    // parent.setDeptId(parentId);
    // department.setParent(parent);
    // return department;
    // }

    @Override
    public SysDept getModel() {
        // TODO Auto-generated method stub

        return null;
    }
}
