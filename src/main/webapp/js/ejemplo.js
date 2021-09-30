$(document).ready(function(){
	
	alert("Hola Mundo....");
	console.log("Hola Muchachos grupo 44")

function Sumar(){

	let num1=parseInt(document.getElementById("n1").value)
	let num2=parseInt(document.getElementById("n2").value)
	var suma=num1+num2
	console.log("La suma es: "+suma)
	var h2=document.getElementById("respuesta")
	h2.innerHTML="La suma es: "+suma
	//document.write("La operacion suma es: "+suma)	
}

$('.suma').on('click', function(){
	Sumar()
})
	
});