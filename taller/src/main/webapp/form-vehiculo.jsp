<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>${vehiculo == null ? 'Nuevo' : 'Editar'} Vehículo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

    <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-md-8 col-lg-6">
                <div class="card shadow border-0">
                    <div class="card-header bg-primary text-white">
                        <h4 class="mb-0">${vehiculo == null ? 'Registrar Nuevo' : 'Editar'} Vehículo</h4>
                    </div>
                    <div class="card-body p-4">
                        <form action="VehiculoController" method="post">
                            <input type="hidden" name="accion" value="${vehiculo == null ? 'guardar' : 'actualizar'}">
                            
                            <c:if test="${vehiculo != null}">
                                <input type="hidden" name="id" value="${vehiculo.idVehiculo}">
                            </c:if>

                            <div class="mb-3">
                                <label class="form-label">Matrícula</label>
                                <input type="text" name="matricula" class="form-control" value="${vehiculo.matricula}" required placeholder="Ej: 1234-ABC">
                            </div>

                            <div class="row">
                                <div class="col-md-6 mb-3">
                                    <label class="form-label">Marca</label>
                                    <input type="text" name="marca" class="form-control" value="${vehiculo.marca}" required>
                                </div>
                                <div class="col-md-6 mb-3">
                                    <label class="form-label">Modelo</label>
                                    <input type="text" name="modelo" class="form-control" value="${vehiculo.modelo}" required>
                                </div>
                            </div>

                            <div class="mb-3">
                                <label class="form-label">Año de Fabricación</label>
                                <input type="number" name="anio" class="form-control" value="${vehiculo.anio}" required min="1900" max="2026">
                            </div>

                            <div class="mb-4">
                                <label class="form-label">Propietario</label>
                                <select name="idPropietario" class="form-select" required>
                                    <option value="">-- Seleccione Propietario --</option>
                                    <c:forEach var="prop" items="${listaPropietarios}">
                                        <option value="${prop.idPropietario}" ${vehiculo.idPropietario == prop.idPropietario ? 'selected' : ''}>
                                            ${prop.nombre}
                                        </option>
                                    </c:forEach>
                                </select>
                            </div>

                            <div class="d-grid gap-2">
                                <button type="submit" class="btn btn-primary btn-lg">Guardar Vehículo</button>
                                <a href="VehiculoController?accion=listar" class="btn btn-outline-secondary">Cancelar</a>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>