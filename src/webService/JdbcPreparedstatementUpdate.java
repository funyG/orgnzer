package webService;
import org.apache.commons.lang3.RandomStringUtils;

import javax.swing.*;
import java.util.UUID;
import java.sql.*;

public class JdbcPreparedstatementUpdate {

    public static void main(String args[]) {
        String randomString = UUID.randomUUID().toString();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String db = "organizer";
        String user = "root";
        String pass = "BostjanC1";
        Connection connection = null;
        String randomNumbers  = "1234567890";
        String randomLetters = "qwertzuiopasdfghjklyxcvbnm" + randomNumbers;

        try {
            String connectionURL = "jdbc:mysql://localhost/organizer";
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(connectionURL, "root", "BostjanC1");
            String generatedString = RandomStringUtils.random(7, randomLetters).toString();
            System.out.println(generatedString);
            pst.close();
            connection.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
