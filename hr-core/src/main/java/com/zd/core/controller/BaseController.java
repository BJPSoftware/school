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
}