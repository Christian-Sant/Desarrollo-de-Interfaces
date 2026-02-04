<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Taller</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.0/font/bootstrap-icons.css">
    <style>
        body { background-color: #f8f9fa; }
        .hero-card { transition: transform 0.3s; cursor: pointer; }
        .hero-card:hover { transform: translateY(-5px); box-shadow: 0 4px 15px rgba(0,0,0,0.1); }
    </style>
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark mb-4">
        <div class="container">
            <a class="navbar-brand" href="index.jsp"><i class="bi bi-wrench-adjustable"></i> Taller Vera</a>
        </div>
    </nav>

    <div class="container">
        <div class="text-center mb-5">
            <h1 class="display-4">Bienvenido al Taller Vera</h1>
            <p class="lead text-muted">Sistema Integral de Gestión de Vehículos y Clientes</p>
        </div>

        <div class="row g-4">
            <div class="col-md-4">
                <div class="card h-100 hero-card text-center p-4 border-0 shadow-sm">
                    <div class="card-body">
                        <i class="bi bi-car-front-fill text-primary display-1 mb-3"></i>
                        <h3 class="card-title">Vehículos</h3>
                        <p class="card-text">Gestiona el inventario, añade nuevos coches y edita datos.</p>
                        <a href="VehiculoController?accion=listar" class="btn btn-outline-primary stretched-link">Ir a Vehículos</a>
                    </div>
                </div>
            </div>

            <div class="col-md-4">
                <div class="card h-100 hero-card text-center p-4 border-0 shadow-sm">
                    <div class="card-body">
                        <i class="bi bi-people-fill text-success display-1 mb-3"></i>
                        <h3 class="card-title">Propietarios</h3>
                        <p class="card-text">Administra la base de datos de clientes y contactos.</p>
                        <a href="PropietarioController?accion=listar" class="btn btn-outline-success stretched-link">Ir a Propietarios</a>
                    </div>
                </div>
            </div>

            <div class="col-md-4">
                <div class="card h-100 hero-card text-center p-4 border-0 shadow-sm">
                    <div class="card-body">
                        <i class="bi bi-bar-chart-fill text-warning display-1 mb-3"></i>
                        <h3 class="card-title">Estadísticas</h3>
                        <p class="card-text">Consulta métricas, vehículos antiguos y totales.</p>
                        <a href="VehiculoController?accion=dashboard" class="btn btn-outline-warning stretched-link">Ver Dashboard</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>