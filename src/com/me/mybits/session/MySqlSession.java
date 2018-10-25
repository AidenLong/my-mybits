package com.me.mybits.session;

import com.me.mybits.excutor.Excutor;
import com.me.mybits.excutor.SimpleExcutor;
import com.me.mybits.handler.MyMapperHandler;

import java.lang.reflect.Proxy;

public class MySqlSession {

    private Excutor excutor = new SimpleExcutor();

    public <T> T selectOne(String statement,Object parameter){
        return excutor.query(statement, parameter);
    }

    public <T> T getMapper(Class<T> clas){
        return (T)Proxy.newProxyInstance(clas.getClassLoader(),new Class[]{clas}, new MyMapperHandler<>(this));
    }

}
