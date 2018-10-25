package com.me.mybits.mapper;

import java.util.HashMap;
import java.util.Map;

public class UserMapperXml {

    public static final String namespate = "com.me.mybits.mapper.UserMapper";

    public static final Map<String, String> map = new HashMap<String, String>();

    static {
        //模拟xml中的id与sql语句
        map.put("getUserById", "select * from sys_user where id = ?");

    }
}
