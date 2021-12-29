package src.jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 *
 * @author abdel
 */
public class TestDbServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // setup connection variables
        String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker";

        // get connection to database
        try {
            out.println("Connecting to database: " + jdbcUrl);

            Class.forName("com.mysql.jdbc.Driver");

            Connection myConn = DriverManager.getConnection(jdbcUrl, "root", "");

            out.println("SUCCESS!!!");

//            myConn.close();
            Statement stmt = myConn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from customer");
            while (rs.next()) {
                out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3) + " " + rs.getString(4));
            }
            myConn.close();
        } catch (Exception exc) {
            exc.getMessage();
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
