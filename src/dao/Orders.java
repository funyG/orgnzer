package dao;
import dto.FeedObjects;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Orders {


//    public ArrayList<FeedObjects> ShopingCart() throws Exception {
//
//    }

    public ArrayList<FeedObjects> SendOrder(Connection connection, Integer orderId, String Sessionid, String CostumerName, String CostumerSureName, String address, Integer number, boolean StudentStatus) throws Exception {
        ArrayList<FeedObjects> narocilo = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO organizer.ShopingCart (orderId, SessionId, costumer_name, costumer_surnmane, costumer_address, costumer_phonenumber, Student_status, DateCreated) VALUES(?, ?, ?, ?, ?, ?, ?, CURRENT_TIMESTAMP)");
                ps.setInt(1, orderId);
                ps.setString(2, Sessionid);
                ps.setString(3, CostumerName);
                ps.setString(4, CostumerSureName);
                ps.setString(5, address);
                ps.setInt(6, number);
                ps.setBoolean(7, StudentStatus);
                System.out.println("NAROČILOO dao>>>>>>>: " + ps );
                ps.executeUpdate();
                ps.close();
        } catch (Exception e) {
            System.out.println("DAO LEAYER EERROR PRI NAROLČILU" + e );
        }
        return narocilo;
    }


}
