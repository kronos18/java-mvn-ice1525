package com.uga.energie.repository;

import com.uga.energie.dataSource.ConnectionClass;
import com.uga.energie.model.Quartier;
import org.junit.Test;

import java.sql.Connection;

import static org.junit.Assert.assertNotNull;

/**
 * Created by Lenovo on 10/06/2016.
 */
public class QuartierRepositoryTest {
    Connection dataSource = ConnectionClass.getDataSource();
    QuartierRepository quartierRepository = new QuartierRepository(dataSource);

    @Test
    public void create() throws Exception {
        Quartier quartier = new Quartier(1, "quartier1");
        quartierRepository.create(quartier);
    }

    @Test
    public void findById() throws Exception {
        Quartier quartier = quartierRepository.findById(1);
        assertNotNull(quartier);
    }

    @Test
    public void update() throws Exception {

    }

    @Test
    public void delete() throws Exception {

    }

}