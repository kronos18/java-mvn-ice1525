package com.uga.energie.repository;

import com.uga.energie.dataSource.ConnectionClass;

import java.sql.Connection;

/**
 * Created by Lenovo on 10/06/2016.
 */
public class Repository {
    private static Connection connection;
    private static AppareilRepository appareilRepository;
    private static QuartierRepository quartierRepository;
    private static MaisonRepository maisonRepository;
    private static TypeAppareilRepository typeAppareilRepository;
    private static ConsommationRepository consommationRepository;
    private static DateRepository dateRepository;
    private static HeureRepository heureRepository;

    public Repository() {
        initRepository();
    }

    public static AppareilRepository getAppareilRepository() {
        if (null == appareilRepository) {
            appareilRepository = new AppareilRepository(connection);
        }
        return appareilRepository;
    }

    public static ConsommationRepository getConsommationRepository() {
        if (null == consommationRepository) {
            consommationRepository = new ConsommationRepository(connection);
        }
        return consommationRepository;
    }

    public static MaisonRepository getMaisonRepository() {
        if (null == maisonRepository) {
            maisonRepository = new MaisonRepository(connection);
        }
        return maisonRepository;
    }

    public static DateRepository getDateRepository() {
        if (null == dateRepository) {
            dateRepository = new DateRepository(connection);
        }
        return dateRepository;
    }

    public static HeureRepository getHeureRepository() {
        if (null == heureRepository) {
            heureRepository = new HeureRepository(connection);
        }
        return heureRepository;
    }

    public static QuartierRepository getQuartierRepository() {
        if (null == quartierRepository) {
            quartierRepository = new QuartierRepository(connection);
        }
        return quartierRepository;
    }

    public static TypeAppareilRepository getTypeAppareilRepository() {
        if (null == typeAppareilRepository) {
            typeAppareilRepository = new TypeAppareilRepository(connection);
        }
        return typeAppareilRepository;
    }

    private boolean isNotRepositoryInit() {
        return null == appareilRepository && null == quartierRepository && null == maisonRepository &&
                null == typeAppareilRepository && null == consommationRepository && null == dateRepository &&
                null == heureRepository;
    }

    private static void initRepository() {
        connection = ConnectionClass.getDataSource();
        appareilRepository = new AppareilRepository(connection);
        quartierRepository = new QuartierRepository(connection);
        maisonRepository = new MaisonRepository(connection);
        typeAppareilRepository = new TypeAppareilRepository(connection);
        consommationRepository = new ConsommationRepository(connection);
        dateRepository = new DateRepository(connection);
        heureRepository = new HeureRepository(connection);
    }
}
