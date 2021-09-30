<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script type="text/javascript" src="js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="js/Prestamos.js"></script>
<title>Registrar Prestamos</title>
</head>
<body>
<%! String isbn="",titulo="",fecha_dev="";
int codigo_p=0;%>

<%
if(request.getParameter("codigo")!=null){
	isbn=request.getParameter("codigo");
	titulo=request.getParameter("titulo");
}

if(request.getParameter("men")!=null){
String mensaje=request.getParameter("men");
out.print("<script>alert('"+mensaje+"');</script>");
}
%>
<form action="Prestamos" method="post">
<div><label>Codigo Libro: </label><select id="listaLibros" name="codigo"></select>
<input type="submit" name="consultarLib" value="Consultar"></div>
</form>
<form action="Prestamos" method="post">
<div><label>Titulo:</label><input type="text" name="titulo" value="<%=titulo%>">
<input type="hidden" name="isbn" value="<%=isbn%>">
</div>
<div><label>Estudiante:</label><input type="text" name="est" required></div>
<div><label>Fecha Prestamo:</label><input type="date" name="fecha" required></div>
<div><label>Codigo Prestamo: <%=codigo_p%></label></div>
<div><label>Fecha Devolucion:<%=fecha_dev%></label></div>
<input type="submit" name="registrar" value=Registrar"></div>
</form>
</body>
</html>