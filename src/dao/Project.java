package dao;

import dto.FeedObjects;

import javax.naming.PartialResultException;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class Project {


    public ArrayList<FeedObjects> getProductDetails(Connection connection, Integer id)
            throws Exception {
        ArrayList<FeedObjects> feedData = new ArrayList<FeedObjects>();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT id, product_name, description, price, allergens, category_id, sub_category_id FROM organizer.products WHERE id= ?");
            ps.setInt(1, id);
            System.out.println("PREPEARED STATEMENT FAILURE " + ps);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                FeedObjects feedObject = new FeedObjects();
                feedObject.setProduct_name(rs.getString("product_name"));
                feedObject.setDescription(rs.getString("description"));
                feedObject.setPrice(rs.getBigDecimal("price"));
                feedObject.setAllergens(rs.getString("allergens"));
                feedObject.setCategory_id(rs.getInt("category_id"));
                feedObject.setSub_category_id(rs.getInt("sub_category_id"));
                feedData.add(feedObject);
            }
            if (feedData.isEmpty()) {
                System.out.println("getProductsDetails > no object assosiated with given query id ");
            }
            return feedData;

        } catch (Exception e) {
            System.out.println(e);
            throw e;
        }
    }


    public ArrayList<FeedObjects> ProductList(Connection connection) throws Exception {
        ArrayList<FeedObjects> feedData = new ArrayList<FeedObjects>();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT id, product_name, description, price, allergens, category_id, sub_category_id FROM organizer.products");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                FeedObjects feedObject = new FeedObjects();
                feedObject.setProduct_name(rs.getString("product_name"));
                feedObject.setDescription(rs.getString("description"));
                feedObject.setPrice(rs.getBigDecimal("price"));
                feedObject.setAllergens(rs.getString("allergens"));
                feedObject.setCategory_id(rs.getInt("category_id"));
                feedObject.setSub_category_id(rs.getInt("sub_category_id"));
                feedData.add(feedObject);
            }
            return feedData;

        } catch (Exception e) {
            throw e;
        }
    }

    // -toDo ps.Close() probi
    public ArrayList<FeedObjects> AddAgent(Connection connection, String id, String firstname, String lastname, String hours, String proffesion, String group_id) throws Exception {
        ArrayList<FeedObjects> name = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO organizer.agent(id, firstname, lastname, hours, group_id, proffesion)VALUES" + "(?,?,?,?,?,?)");
            ps.setString(1, "0");
            ps.setString(2, firstname);
            ps.setString(3, lastname);
            ps.setString(4, hours);
            ps.setString(5, proffesion);
            ps.setString(6, group_id);
            System.out.println("prepeared statemtent for Adding userAgent" + ps);
            ps.executeUpdate();
            ps.close(); //Dodal si close če ne dela ga odstrani

        } catch (Exception e) {
            System.out.println(" AddEgentGotAnError!!!" + e);
        }
        System.out.println(name);
        return name;

    }

    public ArrayList<FeedObjects> EditAgent(Connection connection, String id, String firstname, String lastname, String hours, String proffesion, String group_id) throws Exception {
        ArrayList<FeedObjects> editableAgent = new ArrayList<>();
        try {
            FeedObjects feedobj = new FeedObjects();
            PreparedStatement ps = connection.prepareStatement("UPDATE organizer.agent SET id=?, firstname=?, lastname=?, hours=?, group_id=?, proffesion=? WHERE id=" + id);
            // ne preverimo ali obstaja, samo updejtamo. Če ga ni ga ne vstavimo v bazo.mogoče if?
            ps.setString(1, id);
            ps.setString(2, firstname);
            ps.setString(3, lastname);
            ps.setString(4, hours);
            ps.setString(5, proffesion);
            ps.setString(6, group_id);
            ps.executeUpdate();
            System.out.println("MODEL  >Edit PUT STATEMENT" + "(editing user" + id + " )" + ps);
            ps.close();

        } catch (Exception e) {
            System.out.println("UPDATE STATEMENT WENT WRONG" + e);

        }
        return editableAgent;
    }

    public ArrayList<FeedObjects> Categories(Connection connection) throws Exception {
        ArrayList<FeedObjects> quer = new ArrayList<>();
        PreparedStatement ps = connection.prepareStatement("SELECT id, name FROM organizer.category");
        ResultSet rs = ps.executeQuery();
        try {
            while (rs.next()) {
                FeedObjects feedObject = new FeedObjects();
                feedObject.setCategory_id(rs.getInt("id"));
                feedObject.setCategory_name(rs.getString("name"));
                quer.add(feedObject);
            }
            return quer;
        } catch (Exception e) {
            throw e;
        }


    }

    public ArrayList<FeedObjects> CategoryToSubCategory(Connection connection, Integer category_id) throws Exception {
        ArrayList<FeedObjects> quer = new ArrayList<>();
        PreparedStatement ps = connection.prepareStatement("SELECT id, name, category_id FROM organizer.sub_category WHERE category_id = ?");
        ps.setInt(1, category_id);

        System.out.println("CategoryToSubCategory DAO LAYER = > " +  ps );
        ResultSet rs = ps.executeQuery();
        try {
            while (rs.next()) {

                FeedObjects feedObject = new FeedObjects();
                feedObject.setProduct_name(rs.getString("name"));
                feedObject.setCategory_id(rs.getInt("category_id"));

                quer.add(feedObject);
            }
            return quer;
        } catch (Exception e) {
            throw e;
        }


    }

    public ArrayList<FeedObjects> ProductsInSubCategory(Connection connection, Integer subcategory_id) throws Exception {
        ArrayList<FeedObjects> productsInSubcategory = new ArrayList<>();
        PreparedStatement ps = connection.prepareStatement("SELECT id, product_name, description, price, allergens, category_id, sub_category_id FROM organizer.products WHERE sub_category_id= ?");
        ps.setInt(1, subcategory_id);
        ResultSet rs = ps.executeQuery();
        try {
            while (rs.next()) {
                FeedObjects feedObject = new FeedObjects();
                feedObject.setProduct_name(rs.getString("product_name"));
                feedObject.setDescription(rs.getString("description"));
                feedObject.setPrice(rs.getBigDecimal("price"));
                feedObject.setAllergens(rs.getString("allergens"));
                feedObject.setCategory_id(rs.getInt("category_id"));
                feedObject.setSub_category_id(rs.getInt("sub_category_id"));
                productsInSubcategory.add(feedObject);
            }
            return productsInSubcategory;
        } catch (Exception e) {
            throw e;
        }
    }

    public ArrayList<FeedObjects> Subcategories(Connection connection) throws Exception {
        ArrayList<FeedObjects> subcategories = new ArrayList<>();
        PreparedStatement ps = connection.prepareStatement("SELECT id, name FROM organizer.sub_category");
        ResultSet rs = ps.executeQuery();
        try {
            while (rs.next()) {
                FeedObjects cat = new FeedObjects();
                cat.setCategory_id(rs.getInt("id"));
                cat.setCategory_name(rs.getString("name"));
                subcategories.add(cat);
            }
            return subcategories;
        } catch (Exception e) {
            throw e;
        }
    }
}