package com.uga.energie.repository;

import com.uga.energie.dataSource.ConnectionClass;
import com.uga.energie.model.Maison;
import org.junit.Test;

import java.sql.Connection;

import static org.junit.Assert.assertNotNull;

/**
 * Created by Lenovo on 10/06/2016.
 */
public class MaisonRepositoryTest {
    Connection dataSource = ConnectionClass.getDataSource();
    MaisonRepository maisonRepository = new MaisonRepository(dataSource);

    @Test
    public void create() throws Exception {
        Maison maison = new Maison(1, 1);
        maisonRepository.create(maison);
    }

    @Test
    public void findById() throws Exception {
        Maison maison = maisonRepository.findById(1);
        assertNotNull(maison);
    }

    @Test
    public void update() throws Exception {

    }

    @Test
    public void delete() throws Exception {

    }

}