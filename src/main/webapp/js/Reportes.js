$(document).ready(function(){

function listaLibros(){
	
$.ajax({
	type:"post",
	url:"Reportes",
	dataType:"json",
	data:{opcion:"Libros"},
	success: function(result){
		console.log(result) //Imprime Json
		var tabla=document.getElementById("tabla")
		tabla.innerHTML=''
		tabla.innerHTML+=`<tr class="cssss">
		<th>ISBN</th>
		<th>Titulo</th>
		<th>Editorial</th>
		<th>Autor</th>
		<th>Paginas</th>
		</tr>`
		for(let fila of result){
			tabla.innerHTML+=`<tr>
			<td>${fila.Isbn}</td>
			<td>${fila.Titulo}</td>
			<td>${fila.Editorial}</td>
			<td>${fila.Autor}</td>
			<td>${fila.No_paginas}</td>
			</tr>`
		}
	}
	
})

}

function listaPrestamos(){
	
$.ajax({
	type:"post",
	url:"Reportes",
	dataType:"json",
	data:{opcion:"Prestamos"},
	success: function(result){
		console.log(result) //Imprime Json
		var tabla=document.getElementById("tabla")
		tabla.innerHTML=''
		tabla.innerHTML+=`<tr class="cssss">
		<th>ID</th>
		<th>Estudiante</th>
		<th>Libro</th>
		<th>Fecha_P</th>
		<th>Fecha_D</th>
		</tr>`
		for(let fila of result){
			tabla.innerHTML+=`<tr>
			<td>${fila.Id_Prestamo}</td>
			<td>${fila.Estudiante}</td>
			<td>${fila.Libro}</td>
			<td>${fila.Fecha_p}</td>
			<td>${fila.Fecha_d}</td>
			</tr>`
		}
	}
	
})

}
	
$('#listaLibros').on('click',function(){
	listaLibros();
})

$('.listaPrestamos').on('click',function(){
	alert("Entro a boton")	
	listaPrestamos();
})
	
	
})