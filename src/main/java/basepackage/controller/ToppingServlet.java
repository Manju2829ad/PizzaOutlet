package basepackage.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import basepackage.config.AppConfig;
import basepackage.model.Topping;
import basepackage.service.ToppingService;

@WebServlet("/toppings")
public class ToppingServlet extends HttpServlet {

    private ToppingService toppingService;

    public ToppingServlet() {
        toppingService = AppConfig.getToppingService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Fetch toppings from the database or a data source
        List<Topping> toppings = toppingService.getAllToppings();

        // Convert the toppings list to JSON
        String json = new Gson().toJson(toppings);

        // Set the response content type to JSON
        resp.setContentType("application/json");

        // Write the JSON response
        resp.getWriter().write(json);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Handle adding a topping to the cart
        String toppingName = req.getParameter("toppingName");
        // Add the topping to the cart logic here
        toppingService.saveTopping(new Topping(toppingName));
    }
}