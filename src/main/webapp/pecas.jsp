<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Adicionar Item de Venda</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container">
    <h1 class="mt-4 mb-4">Adicionar Item de Venda</h1>
    <form action="SaleItemServlet" method="post">
        <input type="hidden" name="action" value="add">
        <div class="form-group">
            <label for="saleId">ID da Venda:</label>
            <input type="text" class="form-control" id="saleId" name="saleId" placeholder="Digite o ID da Venda" required>
        </div>
        <div class="form-group">
            <label for="partId">ID da Peça:</label>
            <input type="text" class="form-control" id="partId" name="partId" placeholder="Digite o ID da Peça" required>
        </div>
        <div class="form-group">
            <label for="quantity">Quantidade:</label>
            <input type="number" class="form-control" id="quantity" name="quantity" placeholder="Digite a Quantidade" required>
        </div>
        <button type="submit" class="btn btn-primary">Adicionar Item de Venda</button>
    </form>
    <br>
    <!-- Botão para voltar para a página dashboard.jsp -->
    <a href="dashboard.jsp" class="btn btn-secondary">Voltar para o Dashboard</a>
</div>

</body>
</html>
