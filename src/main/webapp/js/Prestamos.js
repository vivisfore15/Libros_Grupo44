$(document).ready(function(){
	
cargaLibros();
	
function cargaLibros(){
	
$.ajax({
	type:"post",
	url:"Prestamos",
	dataType: "json",
	success: function(result){
		console.log(result)
		let datos=document.getElementById("listaLibros")
		console.log(datos)
		datos.innerHTML='';
		for(let i of result){
			datos.innerHTML+=`<option value="${i.Isbn}">${i.Titulo}</option>`;
			}
	}
})	
}

	
})