package com.uga.energie.repository;

import com.uga.energie.dataSource.ConnectionClass;
import com.uga.energie.model.Appareil;
import org.junit.Test;

import javax.sql.DataSource;

import java.sql.Connection;

import static org.junit.Assert.*;

/**
 * Created by Lenovo on 08/06/2016.
 */
public class AppareilRepositoryTest {
    private Connection dataSource = ConnectionClass.getDataSource();
    private AppareilRepository appareilRepository = new AppareilRepository(dataSource);

    @Test
    public void create() throws Exception {
        Appareil appareil = new Appareil(1, "whirlpool s545", 1, 1);
        appareilRepository.create(appareil);
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