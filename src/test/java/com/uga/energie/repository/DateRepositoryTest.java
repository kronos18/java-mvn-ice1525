package com.uga.energie.repository;

import com.uga.energie.dataSource.ConnectionClass;
import com.uga.energie.model.Date;
import org.junit.Test;

import java.sql.Connection;

/**
 * Created by Lenovo on 10/06/2016.
 */
public class DateRepositoryTest {
    Connection dataSource = ConnectionClass.getDataSource();
    DateRepository dateRepository = new DateRepository(dataSource);

    @Test
    public void create() throws Exception {
        Date date = new Date(1, "18/06/1999");
        dateRepository.create(date);
    }

    @Test
    public void findById() throws Exception {

    }

    @Test
    public void update() throws Exception {

    }

    @Test
    public void delete() throws Exception {

    }

}