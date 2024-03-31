<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.AutoWeb.entities.Vehicle" %> <!-- Importe a classe Vehicle aqui -->
<!DOCTYPE html>
<html lang="pt-BR">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Adicionar Veículo</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>

<body>
    <div class="container mt-5">
        <h2>Adicionar Veículo</h2>
        <form action="VehicleServlet" method="post">
            <input type="hidden" name="action" value="addVehicle">
            <div class="form-group">
                <label for="plate">Placa:</label>
                <input type="text" class="form-control" id="plate" name="plate" required>
            </div>
            <div class="form-group">
                <label for="model">Modelo:</label>
                <input type="text" class="form-control" id="model" name="model" required>
            </div>
            <div class="form-group">
                <label for="manufactureYear">Ano de Fabricação:</label>
                <input type="number" class="form-control" id="manufactureYear" name="manufactureyear" required>
            </div>

            <button type="submit" class="btn btn-primary">Salvar</button>
            <button type="button" class="btn btn-secondary" onclick="window.location.href='dashboard.jsp';">Voltar para o Dashboard</button>
        
 			</form>
       
    <form action="VehicleServlet" method="get">
        <input type="hidden" name="action" value="getAllVehicles">
        <button type="submit" class="btn btn-info mt-3">Listar Veículos</button>
    </form>
    </div>
</body>

</html>
