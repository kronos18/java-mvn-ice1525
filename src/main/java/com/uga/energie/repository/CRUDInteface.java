package com.uga.energie.repository;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Lenovo on 08/06/2016.
 */
public interface CRUDInteface<T> {

    void create(T currentModel);


    void findById(int id);


    void update(T currentModel);


    void delete(int id);
}
