package com.db1group.standardapi.infrastructure;

import java.util.List;
import java.util.stream.Collectors;

public interface Mapper<T, R> {

    R apply(T t);

    default List<R> apply(List<T> tList) {
        return tList.stream().map(this::apply).collect(Collectors.toList());
    }

}
