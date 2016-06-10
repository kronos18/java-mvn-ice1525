package com.uga.energie.repository;

import com.uga.energie.dataSource.ConnectionClass;
import com.uga.energie.model.TypeAppareil;
import org.junit.Test;

import java.sql.Connection;

/**
 * Created by Lenovo on 10/06/2016.
 */
public class TypeAppareilRepositoryTest {
    Connection dataSource = ConnectionClass.getDataSource();
    TypeAppareilRepository typeAppareilRepository = new TypeAppareilRepository(dataSource);

    @Test
    public void create() throws Exception {
        TypeAppareil typeAppareil = new TypeAppareil(1, "machine a laver");
        typeAppareilRepository.create(typeAppareil);
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