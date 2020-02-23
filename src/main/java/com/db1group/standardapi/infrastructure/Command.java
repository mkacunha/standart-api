package com.db1group.standardapi.infrastructure;

public interface Command<T> {

    void execute(T t);
}
