package com.uga.energie.repository;

import com.uga.energie.dataSource.ConnectionClass;
import org.junit.Test;

import javax.sql.DataSource;

import java.sql.Connection;

import static org.junit.Assert.*;

/**
 * Created by Lenovo on 08/06/2016.
 */
public class AppareilRepositoryTest {
    Connection dataSource = ConnectionClass.getDataSource();
    AppareilRepository appareilRepository = new AppareilRepository(dataSource);

    @Test
    public void create() throws Exception {
        appareilRepository.create(null);
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