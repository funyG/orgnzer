package model;

import dao.Database;
import dao.Project;
import dto.FeedObjects;

import java.sql.Connection;
import java.util.ArrayList;

public class ProjectManager {
    Database database = new Database();
    Project project = new Project();


    public ArrayList<FeedObjects> GetProductById(Integer product_id) throws Exception {
        ArrayList<FeedObjects> feeds = null;
        try {
            Connection connection = database.Get_Connection();
            feeds = project.getProductDetails(connection, product_id);
        } catch (Exception e) {
            System.out.println("bbbbbbbb" + e);
        }
        System.out.println("sdsf" + feeds);
        return feeds;
    }

    public ArrayList<FeedObjects> GetAllProducts() throws Exception {
        ArrayList<FeedObjects> feeds = null;
        try {
            Connection connection = database.Get_Connection();
            feeds = project.ProductList(connection);
        } catch (Exception e) {
            throw e;
        }
        return feeds;
    }

    public ArrayList<FeedObjects> AddAgent(String id, String firstname, String lastname, String hours, String proffesion, String group_id) throws Exception {
        ArrayList<FeedObjects> insertion = null;
        System.out.println("vzel sem podatke iz webservica [" + id + firstname + lastname);
        try {
            Connection connection = database.Get_Connection();
            insertion = project.AddAgent(connection, id, firstname, lastname, hours, proffesion, group_id);
        } catch (Exception e) {
            throw e;
        }
        return insertion;
    }

    public ArrayList<FeedObjects> EditAgent(String id, String firstname, String lastname, String hours, String proffesion, String group_id) throws Exception {
        ArrayList<FeedObjects> updateQ = null;
        try {
            Connection connection = database.Get_Connection();
            updateQ = project.EditAgent(connection, id, firstname, lastname, hours, proffesion, group_id);
            System.out.println(("MODEL> from dao >AddAgent -> vzel sem oidatje iz objekta" + updateQ));

        } catch (Exception e) {
            System.out.println("MODEL> from dao > Addagent exception !!1");
        }
        return updateQ;
    }


    public ArrayList<FeedObjects> Categories() throws Exception {
        ArrayList<FeedObjects> query = null;
        try {
            Connection connection = database.Get_Connection();
            query = project.Categories(connection);
        } catch (Exception e) {
            System.out.println("CATEgories dao microser ?=> inj. to servic dao" + e);
        }
        return query;
    }

    public ArrayList<FeedObjects> Subcategories() throws Exception {
        ArrayList<FeedObjects> query = null;
        try {
            Connection connection = database.Get_Connection();
            query = project.Subcategories(connection);
        } catch (Exception e) {
            System.out.println("subcat error");
        }
        return query;

    }

    public ArrayList<FeedObjects> SubCategoryToCategory(Integer category_id) throws Exception {
        ArrayList<FeedObjects> query = null;
        try {
            Connection connection = database.Get_Connection();
            query = project.CategoryToSubCategory(connection, category_id);
        } catch (Exception e) {
            System.out.println("CATEgories => inj. to servic dao" + e);
        }
        return query;
    }

    public ArrayList<FeedObjects> ProductsInSubCategory(Integer subcategory_id) throws Exception {
        ArrayList<FeedObjects> productsInSubcategory = null;
        try {
            Connection connection = database.Get_Connection();
            productsInSubcategory = project.ProductsInSubCategory(connection, subcategory_id);
        } catch (Exception e) {
            System.out.println("error productInSubcategoryModel");
        }
        return productsInSubcategory;
    }

}

