package model;

import dao.Database;
import dao.Orders;
import dao.Project;
import dto.FeedObjects;

import java.sql.Array;
import java.sql.Connection;
import java.util.ArrayList;

public class OrdersManager {
    Database database = new Database();
    Orders orders = new Orders();


    public ArrayList<FeedObjects> Order(Integer orderId, String Sessionid, String CostumerName, String CostumerSureName, String address, Integer number, boolean StudentStatus) throws Exception {
        ArrayList<FeedObjects> order = null;
        try {
            Connection connection = database.Get_Connection();
            order = orders.SendOrder(connection, orderId, Sessionid, CostumerName, CostumerSureName,address,number,StudentStatus);
        } catch (Exception e ) {
            System.out.println("Orders manager( model)  ORDER ===>>>>>>" + order );
        }
        return order;
    }
}
