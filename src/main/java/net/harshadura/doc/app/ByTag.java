package net.harshadura.doc.app;

import net.harshadura.doc.db.DBConnect;
import net.harshadura.doc.db.PropertyLoader;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class ByTag extends HttpServlet {

    private PropertyLoader propertyLoader = new PropertyLoader();
    private DBConnect dbConnect;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String tagsName = request.getParameter("tags").toString();

        String tagParts[] = tagsName.split(",");

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

            String query = "SELECT * from doc";
            ResultSet rs = stmt.executeQuery(query);

            out.println("<P ALIGN='center'><TABLE BORDER=1>");
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            // table header
            out.println("<TR>");
            for (int i = 0; i < columnCount; i++) {
                out.println("<TH>" + rsmd.getColumnLabel(i + 1) + "</TH>");
            }
            out.println("</TR>");
            boolean nothingFoundFlag = true;
            // the data
            while (rs.next()) {

                String tagNow = rs.getString("tags");
                String tagNowParts[] = tagNow.split(",");

                boolean foundSwitch = false;
                for(int i = 0; i < tagParts.length; i++)
                {
                    for (int j = 0; j < tagNowParts.length;j++)
                    {
                        if( tagParts[i].equals(tagNowParts[j]))
                        {
                            nothingFoundFlag=false;
                            foundSwitch = true;
                            out.println("<TR>");
                            for (int k = 0; k < columnCount; k++) {
                                out.println("<TD>" + rs.getString(k + 1) + "</TD>");
                            }
                            out.println("</TR>");
                        }
                    }
                foundSwitch = false;
                }
            }
            out.println("</TABLE></P>");

            if(nothingFoundFlag==true){
               out.println("<br/><h2>Nothing Found Search By Tag: " + tagsName + "</h2>");
            }

        } catch (Exception e) {
            System.out.println("An error occured while retrieving docs search by tags: " + e);
            e.printStackTrace();
        }
        out.println("</center>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }

}