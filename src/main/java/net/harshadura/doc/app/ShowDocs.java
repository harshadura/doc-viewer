package net.harshadura.doc.app;

import net.harshadura.doc.db.DBConnect;
import net.harshadura.doc.db.PropertyLoader;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowDocs extends HttpServlet {

    private PropertyLoader propertyLoader = new PropertyLoader();
    private DBConnect dbConnect;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>All Docs</title></head>");
        out.println("<body>");
        out.println("<center><h1>All Docs</h1>");
        Connection conn = null;
        Statement stmt = null;
        try {
            dbConnect = new DBConnect();
            conn = dbConnect.connect();
            stmt = conn.createStatement();

            String query = "SELECT uuid, content, tags from doc";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String uuid = rs.getInt("uuid") + "";
                String content = rs.getString("content");
                String tags = rs.getString("tags");

                out.print(uuid + "::");
                out.print(content + "::");
                out.print(tags + "::");
                out.print("<br/>");

            }
        } catch (SQLException e) {
            out.println("An error occured while retrieving " + "all docs: "
                    + e.toString());
        } catch (Exception e) {
            throw (new ServletException(e.toString()));
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
            }
        }
        out.println("</center>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}