package com.uga.energie.repository;

import com.uga.energie.dataSource.ConnectionClass;
import com.uga.energie.model.Quartier;
import org.junit.Test;

import java.sql.Connection;

/**
 * Created by Lenovo on 10/06/2016.
 */
public class QuartierRepositoryTest {
    Connection dataSource = ConnectionClass.getDataSource();
    QuartierRepository appareilRepository = new QuartierRepository(dataSource);

    @Test
    public void create() throws Exception {
        Quartier quartier = new Quartier(1, "quartier1");
        appareilRepository.create(quartier);
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