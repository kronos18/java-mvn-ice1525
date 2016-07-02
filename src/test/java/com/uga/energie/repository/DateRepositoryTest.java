package com.uga.energie.repository;

import com.uga.energie.dataSource.ConnectionClass;
import com.uga.energie.model.Date;
import org.junit.Test;

import java.sql.Connection;

import static org.junit.Assert.assertNotNull;

/**
 * Created by Lenovo on 10/06/2016.
 */
public class DateRepositoryTest {
    Connection dataSource = ConnectionClass.getDataSource();
    DateRepository dateRepository = new DateRepository(dataSource);

    @Test
    public void create() throws Exception {
        Date date = new Date(3, "18/06/96");
        dateRepository.create(date);
    }

    @Test
    public void findById() throws Exception {
        Date dateRepositoryById = dateRepository.findById(1);
        assertNotNull(dateRepositoryById);

    }

    @Test
    public void update() throws Exception {

    }

    @Test
    public void delete() throws Exception {

    }

}