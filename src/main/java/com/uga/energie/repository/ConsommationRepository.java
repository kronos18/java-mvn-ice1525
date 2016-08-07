package com.uga.energie.repository;

import com.uga.energie.model.Appareil;
import com.uga.energie.model.Consommation;
import com.uga.energie.model.Maison;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Lenovo on 08/06/2016.
 */
public class ConsommationRepository implements CRUDInteface<Consommation> {

    private static final String INSERT = "insert into uga.Consommation(iddate, idheure, idappareil, etat, energy_wh ) values( ? ,? ,? ,?, ? )";
    private static final String FIND_BY_ID = "select * from uga.Consommation where id = ?";
    private static final String GET_TOP1_CONSO_TOTAL = new StringBuilder().append(

            "SELECT idmaison as id_maison,")
            .append(" SUM(energy_wh) as conso_totale,")
            .append(" uga.appareil.name as name_appareil,")
            .append(" uga.typeappareil.name as name_type_apareil")
            .append(" FROM uga.consommation")
            .append(" , uga.appareil")
            .append(" , uga.typeappareil")
            .append(" WHERE uga.appareil.id = uga.consommation.idappareil")
            .append(" AND uga.typeappareil.id  =  uga.appareil.idtypeappareil")
            .append(" AND iddate in")
            .append(" (")
            .append("       SELECT ID")
            .append("       FROM uga.date")
            .append("       WHERE ddate >= to_date(CONCAT('1998-',EXTRACT(MONTH FROM NOW())-1 ,'-01'),'YYYY-MM-DD')")
            .append("       and ddate <= to_date(CONCAT('1998-',EXTRACT(MONTH FROM NOW())-1 ,'-31'),'YYYY-MM-DD')")
            .append("  )")
            .append("  GROUP BY uga.appareil.id, uga.appareil.name,uga.typeappareil.name")
            .append("  ORDER BY conso_totale desc")
            .append("  LIMIT 1 ;")
            .toString();

    private static final String GET_CONSO_TOTAL_BY_MAISON_ID = new StringBuilder().append(
            "SELECT sum(conso_totale) AS conso_totale,")
                                                                                  .append(" a.last_date,")
                                                                                  .append(" a.last_heure,")
                                                                                  .append(" a.idmaison,")
                                                                                  .append(" a.id_date ")
                                                                                  .append("FROM")
                                                                                  .append("  ( SELECT distinct( max(uga.date.ddate) ) AS last_date,")
                                                                                  .append("    max(extract(hour")
                                                                                  .append("    FROM uga.heure.heure)) AS last_heure,")
                                                                                  .append("energy_wh AS conso_totale,")
                                                                                  .append(" uga.appareil.idmaison,")
                                                                                  .append(" uga.date.id AS id_date")
                                                                                  .append("   FROM uga.Consommation")
                                                                                  .append("   JOIN uga.appareil ON ( uga.appareil.id = uga.consommation.idappareil )")
                                                                                  .append("   JOIN uga.maison ON ( uga.maison.id = uga.appareil.idmaison )")
                                                                                  .append("   JOIN uga.date ON ( uga.date.id = uga.consommation.iddate )")
                                                                                  .append("   JOIN uga.heure ON ( uga.heure.id = uga.consommation.idheure )")
                                                                                  .append("   WHERE uga.appareil.idmaison = ?")
                                                                                  .append("     AND uga.date.ddate IN")
                                                                                  .append(" ( SELECT distinct( max(uga.date.ddate) ) AS last_date")
                                                                                  .append("  FROM uga.Consommation")
                                                                                  .append("  JOIN uga.appareil ON ( uga.appareil.id = uga.consommation.idappareil )")
                                                                                  .append("  LEFT OUTER JOIN uga.maison ON ( uga.maison.id = uga.appareil.idmaison )")
                                                                                  .append("  LEFT OUTER JOIN uga.date ON ( uga.date.id = uga.consommation.iddate )")
                                                                                  .append("  LEFT OUTER JOIN uga.heure ON ( uga.heure.id = uga.consommation.idheure )")
                                                                                  .append("  WHERE uga.appareil.idmaison = ? )")
                                                                                  .append("   GROUP BY uga.appareil.idmaison,")
                                                                                  .append("uga.date.id,")
                                                                                  .append("uga.consommation.energy_wh")
                                                                                  .append("   ORDER BY last_heure DESC ) A")
                                                                                  .append(" GROUP BY a.last_date,")
                                                                                  .append("   a.idmaison,")
                                                                                  .append("   a.last_heure,")
                                                                                  .append("   a.id_date ")
                                                                                  .append("ORDER BY last_heure DESC LIMIT 1")
                                                                                  .toString();
    private final Connection connection;

    public ConsommationRepository(Connection dataSource) {
        this.connection = dataSource;
    }


    public void create(Consommation currentModel) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setObject(1, currentModel.getIdDate());
            preparedStatement.setObject(2, currentModel.getIdHeure());
            preparedStatement.setObject(3, currentModel.getIdAppareil());
            preparedStatement.setObject(4, currentModel.getEtat());
            preparedStatement.setObject(5, currentModel.getEnergy_wh());
            preparedStatement.executeUpdate();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

    //TODO A faire
    public Consommation findById(int id) {
        Consommation consommation = null;
        try {
            ResultSet rs;
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID);
            preparedStatement.setObject(1, id);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                // read the result set
                consommation = new Consommation(rs.getInt("iddate"),
                                                rs.getInt("idheure"),
                                                rs.getInt("idappareil"),
                                                rs.getInt("etat"),
                                                rs.getInt("energy_wh"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return consommation;
    }

    public Consommation getByAppareilId(int id) {
        Consommation consommation = null;
        try {
            ResultSet rs;
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID);
            preparedStatement.setObject(1, id);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                // read the result set
                consommation = new Consommation(rs.getInt("iddate"),
                                                rs.getInt("idheure"),
                                                rs.getInt("idappareil"),
                                                rs.getInt("etat"),
                                                rs.getInt("energy_wh"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return consommation;
    }

    public void update(Consommation currentModel) {

    }

    public void delete(int id) {

    }

    public int getConsommationTotalByMaisonId(int maisonId) {
        int consommationTotalValue = 0;
        try {
            ResultSet rs;
            PreparedStatement preparedStatement = connection.prepareStatement(GET_CONSO_TOTAL_BY_MAISON_ID);
            preparedStatement.setObject(1, maisonId);
            preparedStatement.setObject(2, maisonId);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                // read the result set
                consommationTotalValue = rs.getInt("conso_totale");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return consommationTotalValue;
    }

    public ArrayList<String>  getTop1ConsoAppareil(){
        ArrayList<String> result = new ArrayList<String>();
        try {
            ResultSet rs;
            PreparedStatement preparedStatement = connection.prepareStatement(GET_TOP1_CONSO_TOTAL);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                // read the result set
                result.add("" + rs.getString("name_appareil"));
                result.add("" + rs.getString("name_type_apareil"));
                result.add("" + rs.getInt("conso_totale"));
                result.add("" + rs.getInt("id_maison"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }


}
