package com.me.mybits;

import com.me.mybits.entity.User;
import com.me.mybits.mapper.UserMapper;
import com.me.mybits.session.MySqlSession;

public class TestManuMybaties {

    public static void main(String[] args) {
        MySqlSession sqlSession = new MySqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User userById = mapper.getUserById("1");
        System.out.println(userById);
    }
}
