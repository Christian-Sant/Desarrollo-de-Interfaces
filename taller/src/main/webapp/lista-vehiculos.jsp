<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Lista de Vehículos</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.0/font/bootstrap-icons.css">
</head>
<body class="bg-light">
    
    <nav class="navbar navbar-dark bg-dark mb-4">
        <div class="container">
            <a class="navbar-brand" href="index.jsp">Taller</a>
            <div class="d-flex">
                <a href="index.jsp" class="btn btn-outline-light btn-sm">Volver al Inicio</a>
            </div>
        </div>
    </nav>

    <div class="container">
        <div class="d-flex justify-content-between align-items-center mb-4">
            <h2><i class="bi bi-car-front"></i> Vehículos Registrados</h2>
            <div>
                <a href="VehiculoController?accion=dashboard" class="btn btn-info text-white me-2"><i class="bi bi-graph-up"></i> Estadísticas</a>
                <a href="VehiculoController?accion=nuevo" class="btn btn-primary"><i class="bi bi-plus-lg"></i> Nuevo Vehículo</a>
            </div>
        </div>

        <div class="card shadow-sm border-0">
            <div class="card-body p-0">
                <div class="table-responsive">
                    <table class="table table-hover table-striped mb-0 align-middle">
                        <thead class="table-dark">
                            <tr>
                                <th>ID</th>
                                <th>Matrícula</th>
                                <th>Marca</th>
                                <th>Modelo</th>
                                <th>Año</th>
                                <th>Propietario</th>
                                <th class="text-end">Acciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="v" items="${vehiculos}">
                                <tr>
                                    <td>#${v.idVehiculo}</td>
                                    <td><span class="badge bg-secondary">${v.matricula}</span></td>
                                    <td>${v.marca}</td>
                                    <td>${v.modelo}</td>
                                    <td>${v.anio}</td>
                                    <td>${v.nombrePropietarioAux != null ? v.nombrePropietarioAux : v.idPropietario}</td>
                                    <td class="text-end">
                                        <a href="VehiculoController?accion=editar&id=${v.idVehiculo}" class="btn btn-warning btn-sm" title="Editar">
                                            <i class="bi bi-pencil-square"></i>
                                        </a>
                                        <a href="VehiculoController?accion=eliminar&id=${v.idVehiculo}" class="btn btn-danger btn-sm"
                                           onclick="return confirm('¿Seguro que deseas eliminar este vehículo?');" title="Eliminar">
                                            <i class="bi bi-trash"></i>
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</body>
</html>