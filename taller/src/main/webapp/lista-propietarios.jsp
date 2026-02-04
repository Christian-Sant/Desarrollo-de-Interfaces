<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Lista de Propietarios</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.0/font/bootstrap-icons.css">
</head>
<body class="bg-light">

    <nav class="navbar navbar-dark bg-dark mb-4">
        <div class="container">
            <a class="navbar-brand" href="index.jsp">Taller Vera</a>
            <a href="VehiculoController?accion=listar" class="btn btn-outline-light btn-sm">Ir a Vehículos</a>
        </div>
    </nav>

    <div class="container">
        <div class="d-flex justify-content-between align-items-center mb-4">
            <h2><i class="bi bi-people"></i> Gestión de Propietarios</h2>
            <a href="PropietarioController?accion=nuevo" class="btn btn-success"><i class="bi bi-person-plus"></i> Nuevo Propietario</a>
        </div>

        <div class="card shadow-sm border-0">
            <div class="card-body p-0">
                <div class="table-responsive">
                    <table class="table table-hover table-striped mb-0 align-middle">
                        <thead class="table-success"> <tr>
                                <th>ID</th>
                                <th>Nombre</th>
                                <th>Teléfono</th>
                                <th>Dirección</th>
                                <th class="text-end">Acciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="p" items="${propietarios}">
                                <tr>
                                    <td>${p.idPropietario}</td>
                                    <td class="fw-bold">${p.nombre}</td>
                                    <td>${p.telefono}</td>
                                    <td>${p.direccion}</td>
                                    <td class="text-end">
                                        <a href="PropietarioController?accion=editar&id=${p.idPropietario}" class="btn btn-warning btn-sm">
                                            <i class="bi bi-pencil"></i>
                                        </a>
                                        <a href="PropietarioController?accion=eliminar&id=${p.idPropietario}" class="btn btn-danger btn-sm" 
                                           onclick="return confirm('¿Eliminar propietario? Esto podría afectar a sus vehículos.')">
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