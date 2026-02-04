<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Dashboard Taller</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.0/font/bootstrap-icons.css">
</head>
<body class="bg-light">

    <nav class="navbar navbar-dark bg-dark mb-4">
        <div class="container">
            <a class="navbar-brand" href="index.jsp">Taller - Estadísticas</a>
            <a href="VehiculoController?accion=listar" class="btn btn-outline-light btn-sm">Volver al Listado</a>
        </div>
    </nav>

    <div class="container">
        <h2 class="mb-4">Panel de Control</h2>

        <div class="row mb-4">
            <div class="col-md-6 col-lg-4">
                <div class="card text-white bg-primary mb-3 shadow">
                    <div class="card-header">Total Vehículos</div>
                    <div class="card-body text-center">
                        <h1 class="display-1 fw-bold"><i class="bi bi-speedometer2"></i> ${total}</h1>
                        <p class="card-text">Vehículos registrados en el sistema</p>
                    </div>
                </div>
            </div>
            
            <div class="col-md-6 col-lg-8">
                <div class="card shadow border-0 h-100">
                    <div class="card-header bg-warning text-dark">
                        <h5 class="mb-0"><i class="bi bi-hourglass-bottom"></i> Top 5 Vehículos Más Antiguos</h5>
                    </div>
                    <ul class="list-group list-group-flush">
                        <c:forEach var="v" items="${antiguos}">
                            <li class="list-group-item d-flex justify-content-between align-items-center">
                                <div>
                                    <strong>${v.marca} ${v.modelo}</strong>
                                    <br>
                                    <small class="text-muted">Matrícula: ${v.matricula}</small>
                                </div>
                                <span class="badge bg-dark rounded-pill">Año ${v.anio}</span>
                            </li>
                        </c:forEach>
                        <c:if test="${empty antiguos}">
                            <li class="list-group-item text-muted">No hay datos suficientes.</li>
                        </c:if>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</body>
</html>