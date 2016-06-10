package com.uga.energie.repository;

import com.uga.energie.dataSource.ConnectionClass;
import com.uga.energie.model.Consommation;
import com.uga.energie.model.TypeAppareil;
import org.junit.Test;

import java.sql.Connection;

/**
 * Created by Lenovo on 10/06/2016.
 */
public class ConsommationRepositoryTest {
    Connection dataSource = ConnectionClass.getDataSource();
    ConsommationRepository consommationRepository = new ConsommationRepository(dataSource);

    @Test
    public void create() throws Exception {
        Consommation consommation = new Consommation(1, 1, 1, 1, 120);
        consommationRepository.create(consommation);
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