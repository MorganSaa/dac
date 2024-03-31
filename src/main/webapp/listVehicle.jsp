<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %> 
<%@ page import="com.AutoWeb.entities.Vehicle" %> 
<!DOCTYPE html>
<html lang="pt-BR">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lista de Veículos</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>

<body>
    <div class="container mt-5">
        <h2>Lista de Veículos</h2>
        <table class="table">
            <thead>
                <tr>
                    <th>Placa</th>
                    <th>Modelo</th>
                    <th>Ano de Fabricação</th>
                </tr>
            </thead>
            <tbody>
                <% 
                List<Vehicle> vehicles = (List<Vehicle>) request.getAttribute("vehicles");
                if (vehicles != null) {
                    for (Vehicle vehicle : vehicles) {
                %>
                    <tr>
                        <td><%= vehicle.getPlate() %></td>
                        <td><%= vehicle.getModel() %></td>
                        <td><%= vehicle.getManufactureYear() %></td>
                    </tr>
                <% 
                    }
                } else {
                %>
                    <tr>
                        <td colspan="3">Nenhum veículo encontrado</td>
                    </tr>
                <% 
                }
                %>
            </tbody>
        </table>
    </div>
</body>

</html>
