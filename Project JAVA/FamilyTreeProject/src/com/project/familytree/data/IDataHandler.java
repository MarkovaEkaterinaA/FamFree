package com.project.familytree.data;

import java.io.IOException;

public interface IDataHandler<T> {
    void save(T data, String filename) throws IOException;
    T load(String filename) throws IOException, ClassNotFoundException;
}
