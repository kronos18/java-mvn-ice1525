package com.uga.energie.repository;

import com.uga.energie.dataSource.ConnectionClass;
import com.uga.energie.model.Heure;
import org.junit.Test;

import java.sql.Connection;

/**
 * Created by Lenovo on 10/06/2016.
 */
public class HeureRepositoryTest {
    Connection dataSource = ConnectionClass.getDataSource();
    HeureRepository heureRepository = new HeureRepository(dataSource);

    @Test
    public void create() throws Exception {
        Heure heure = new Heure(1, "00:00");
        heureRepository.create(heure);
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