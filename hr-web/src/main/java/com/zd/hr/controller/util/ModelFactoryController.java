package com.zd.hr.controller.util;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zd.core.controller.BaseController;
import com.zd.core.util.EntityUtil;
import com.zd.core.util.JsonBuilder;
import com.zd.core.util.ModelUtil;
import com.zd.core.util.StringUtils;
import com.zd.hr.domain.sys.SysLog;


@Controller
@RequestMapping("/ModelFactory")
public class ModelFactoryController extends BaseController<SysLog>{
    
    @RequestMapping("/getModelFields")
    public void getModelFields (HttpServletRequest request, HttpServletResponse response) throws Exception{
        String modelName = request.getParameter("modelName");
        String excludes = request.getParameter("excludes");
        String strData = null;
        if(!StringUtils.isNotEmpty(ModelUtil.modelJson.get(modelName))){
            Class<?> c = EntityUtil.getClassByName(modelName);
            Field[] fields=ModelUtil.getClassFields(c, false);
            strData=JsonBuilder.getInstance().getModelFileds(modelName, fields, excludes);
        } else {
            strData=ModelUtil.modelJson.get(modelName);
        }
        writeJSON(response, strData);
    }

    @Override
    public SysLog getModel() {
        // TODO Auto-generated method stub
        return null;
    }
 
}
