package com.example.MyBootProject.db;

import java.util.List;
import java.util.Optional;

public interface MemoryDbRepositoryIfs<T> {

    Optional<T> findById(int index);
    T save(T entity);
    void deletedById(int index);
    List<T> listAll();

}
