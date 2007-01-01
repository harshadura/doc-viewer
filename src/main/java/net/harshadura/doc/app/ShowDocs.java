package net.harshadura.doc.app;

import net.harshadura.doc.db.DBConnect;
import net.harshadura.doc.db.PropertyLoader;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

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

            int rowCount = 0;
            out.println("<P ALIGN='center'><TABLE BORDER=1>");
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            // table header
            out.println("<TR>");
            for (int i = 0; i < columnCount; i++) {
                out.println("<TH>" + rsmd.getColumnLabel(i + 1) + "</TH>");
            }
            out.println("</TR>");
            // the data
            while (rs.next()) {
                rowCount++;
                out.println("<TR>");
                for (int i = 0; i < columnCount; i++) {
                    out.println("<TD>" + rs.getString(i + 1) + "</TD>");
                }
                out.println("</TR>");
            }
            out.println("</TABLE></P>");

        } catch (Exception e) {
           System.out.println("An error occured while retrieving " + "all docs: " + e.toString());
           e.printStackTrace();
        }
        out.println("</center>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}