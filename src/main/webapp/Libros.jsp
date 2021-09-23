<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%!String codigo="",titulo="",editorial="",autor="",estado="";
int paginas=1;
%>
<%
if(request.getParameter("codigo")!=null){
codigo=request.getParameter("codigo");
titulo=request.getParameter("titulo");
editorial=request.getParameter("editorial");
autor=request.getParameter("autor");
paginas=Integer.parseInt(request.getParameter("paginas"));
estado="disabled";
}
%>
<h1>Modulo Libros</h1>
<form action="Libros" method="post">
<div><label>Codigo: </label><input type="text" name="isbn" value="<%=codigo%>" <%=estado%> required></div>
<input type="hidden" name="cod" value="<%=codigo%>">
<div><label>Titulo: </label><input type="text" name="titulo" value="<%=titulo%>" required></div>
<div><label>Editorial: </label><input type="text" name="editorial" value="<%=editorial%>"></div>
<div><label>Autor: </label><input type="text" name="autor" value="<%=autor%>" required></div>
<div><label>Paginas: </label><input type="number" name="paginas" value="<%=paginas%>"></div>
<div><input type="submit" name="insertar" value="Registrar">
<input type="submit" name="actualizar" value="Actualizar">
<input type="submit" name="eliminar" value="Eliminar">
</div>
</form>
<hr>
<form action="Libros" method="post">
<fieldset>
<legend>Consultar:</legend>
<div><label>Codigo: </label><input type="text" name="codigo">
<input type="submit" name="consultar" value="Consultar"></div></fieldset>
</form>
<%
if(request.getParameter("men")!=null){
String mensaje=request.getParameter("men");
out.print("<script>alert('"+mensaje+"');</script>");
}
%>

<hr>
<form action="Libros" method="post" enctype="multipart/form-data">
<div><label>Archivo</label><input type="file" value="Examinar" name="archivo">
</div>
<input type="submit" value="Cargar Archivo" name="cargar">
</form>

















</body>
</html>