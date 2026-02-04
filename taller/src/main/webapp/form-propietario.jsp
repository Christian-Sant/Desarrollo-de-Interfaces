<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>${propietario == null ? 'Nuevo' : 'Editar'} Propietario</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

    <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-md-8 col-lg-6">
                <div class="card shadow border-0">
                    <div class="card-header bg-success text-white">
                        <h4 class="mb-0">${propietario == null ? 'Registrar' : 'Editar'} Propietario</h4>
                    </div>
                    <div class="card-body p-4">
                        <form action="PropietarioController" method="post">
                            <input type="hidden" name="accion" value="${propietario == null ? 'guardar' : 'actualizar'}">
                            
                            <c:if test="${propietario != null}">
                                <input type="hidden" name="id" value="${propietario.idPropietario}">
                            </c:if>

                            <div class="mb-3">
                                <label class="form-label">Nombre Completo</label>
                                <input type="text" name="nombre" class="form-control" value="${propietario.nombre}" required>
                            </div>

                            <div class="mb-3">
                                <label class="form-label">Teléfono</label>
                                <input type="text" name="telefono" class="form-control" value="${propietario.telefono}">
                            </div>

                            <div class="mb-4">
                                <label class="form-label">Dirección</label>
                                <input type="text" name="direccion" class="form-control" value="${propietario.direccion}">
                            </div>

                            <div class="d-grid gap-2">
                                <button type="submit" class="btn btn-success btn-lg">Guardar Datos</button>
                                <a href="PropietarioController?accion=listar" class="btn btn-outline-secondary">Cancelar</a>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>