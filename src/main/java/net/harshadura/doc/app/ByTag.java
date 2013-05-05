package net.harshadura.doc.app;

import net.harshadura.doc.db.DBConnect;
import net.harshadura.doc.db.PropertyLoader;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ByTag extends HttpServlet {

    private PropertyLoader propertyLoader = new PropertyLoader();
    private DBConnect dbConnect;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String tagsName = request.getParameter("tags").toString();

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>Search By Tag</title></head>");
        out.println("<body>");
        out.println("<center><h1>Docs by Tag: " + tagsName + "</h1>");
        Connection conn = null;
        Statement stmt = null;
        try {
            dbConnect = new DBConnect();
            conn = dbConnect.connect();
            stmt = conn.createStatement();
            String orderBy = request.getParameter("sort");
            if ((orderBy == null) || orderBy.equals("")) {
                orderBy = "SSN";
            }
            String orderByDir = request.getParameter("sortdir");
            if ((orderByDir == null) || orderByDir.equals("")) {
                orderByDir = "asc";
            }
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