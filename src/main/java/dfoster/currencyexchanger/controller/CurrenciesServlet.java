package dfoster.currencyexchanger.controller;

import com.google.gson.Gson;
import dfoster.currencyexchanger.dao.CurrencyDAO;
import dfoster.currencyexchanger.model.Currency;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/currencies")
public class CurrenciesServlet extends HttpServlet {
    private String message;

    public void init() {}
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("application/json");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");
        response.setHeader("Access-Control-Max-Age", "86400");
        if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
            return;
        }

        response.setStatus(HttpServletResponse.SC_OK);
        Currency currency = new Currency();
        currency.setCode(request.getParameter("code"));
        currency.setName(request.getParameter("name"));
        currency.setSign(request.getParameter("sign"));
        CurrencyDAO currencyDAO = new CurrencyDAO();
        currencyDAO.addCurrencies(currency);

    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");
        response.setHeader("Access-Control-Max-Age", "86400");
        if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
            return;
        }

        response.setStatus(HttpServletResponse.SC_OK);


        new Gson().toJson(new CurrencyDAO().getCurrencies(), response.getWriter());
    }
    public void destroy() {
    }
}