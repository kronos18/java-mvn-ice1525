package com.uga.energie.repository;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Lenovo on 08/06/2016.
 */
public interface CRUDInteface {
    <T> void create(T currentModel);

    <T> void findById(int id);

    <T> void update(String tableName, T currentModel);

    <T> void delete(int id, T currentModel);
}
