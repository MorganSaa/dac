package com.AutoWeb.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.AutoWeb.dao.CustomerDAO;
import com.AutoWeb.dao.SaleDAO;
import com.AutoWeb.dao.SaleItemDAO;
import com.AutoWeb.entities.Customer;
import com.AutoWeb.entities.Sale;
import com.AutoWeb.entities.SaleItem;
import com.AutoWeb.entities.User;

@WebServlet("/SaleServlet")
public class SaleServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private SaleDAO saleDAO;
    private SaleItemDAO saleItemDAO;
    private CustomerDAO customerDAO;

    public void init() {
        saleDAO = new SaleDAO();
        saleItemDAO = new SaleItemDAO();
        customerDAO = new CustomerDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action != null && action.equals("addSale")) {
            addSale(request, response);
        } else {
            response.sendRedirect("error.jsp");
        }
    }

    private void addSale(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idParam = request.getParameter("id");
        String valueParam = request.getParameter("value");
        String quantityParam = request.getParameter("quantity");

        if (idParam == null || valueParam == null || quantityParam == null) {
            response.sendRedirect("error.jsp");
            return;
        }

        try {
            Long id = Long.parseLong(idParam);
            Double value = Double.parseDouble(valueParam);
            Integer quantity = Integer.parseInt(quantityParam);

            Sale sale = new Sale();
            sale.setId(id);
            sale.setValue(value);

            saleDAO.addSale(sale);

            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");

            if (user != null) {
                Long userId = user.getId();
                String userName = user.getName();
                String userEmail = user.getEmail();
                String userCpf = user.getCpf();

                Customer newCustomer = new Customer();
                newCustomer.setId(userId);
                newCustomer.setName(userName);
                newCustomer.setEmail(userEmail);
                newCustomer.setCpf(userCpf);

                customerDAO.addPart(newCustomer);
            }

            SaleItem saleItem = new SaleItem();
            saleItem.setSaleId(sale.getId());
            saleItem.setPartId(Long.parseLong(request.getParameter("id")));
            saleItem.setQuantity(Integer.parseInt(request.getParameter("quantity")));

            saleItemDAO.addSaleItem(saleItem);

            response.sendRedirect("index.jsp");
        } catch (NumberFormatException e) {
            response.sendRedirect("error.jsp");
        }
    }
}
