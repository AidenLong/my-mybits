package com.me.mybits.excutor;

public interface Excutor {

    public <T> T query(String statement, Object parameter);
}
