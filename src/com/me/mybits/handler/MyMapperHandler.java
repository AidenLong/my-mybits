package com.me.mybits.handler;

import com.me.mybits.mapper.UserMapperXml;
import com.me.mybits.session.MySqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyMapperHandler<T> implements InvocationHandler {

    private MySqlSession mySqlSession = null;

    public MyMapperHandler(MySqlSession mySqlSession) {
        this.mySqlSession = mySqlSession;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getDeclaringClass().getName().equals(UserMapperXml.namespate)) {
            String sql = UserMapperXml.map.get(method.getName());
            return mySqlSession.selectOne(sql, String.valueOf(args[0]));
        }
        return null;
    }
}
