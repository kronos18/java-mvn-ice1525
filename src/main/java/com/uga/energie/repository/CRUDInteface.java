package com.uga.energie.repository;

import com.uga.energie.model.Date;

/**
 * Created by Lenovo on 08/06/2016.
 */
public interface CRUDInteface<T> {

    void create(T currentModel);


    Date findById(int id);


    void update(T currentModel);


    void delete(int id);
}
