package dfoster.currencyexchanger;

import java.io.*;
import java.sql.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

//@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");

        String urlConnection = "jdbc:sqlite:C:/Users/demf/Desktop/CurrencyExchanger/currency_exchange.db";
        try {
            Connection connection = DriverManager.getConnection(urlConnection);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Currencies");

            while (resultSet.next()) {
                out.print("<h2>" + resultSet.getString("ID") + "\t" +
                    resultSet.getString("Code") + "\t" +
                    resultSet.getString("FullName") + "\t" +
                    resultSet.getString("Sign") + "</h2>\t\n");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }



        out.println("</body></html>");
    }

    public void destroy() {
    }
}