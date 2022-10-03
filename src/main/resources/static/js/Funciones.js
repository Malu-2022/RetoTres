const BASE_URL = 'http://localhost:8080/'

function TraerInformacionCategoria(){
    $.ajax({
        //url:"http://localhost:8080/api/categoria/categoriacompleta",
        
        type:"GET",
        datatype:"JSON",
        success:function(respuesta){
            pintarRespuestaCategoria(respuesta);
        },
        error:function(xhr,status){
            alert('Operacion no satisfactoria,'+ xhr.status);
        },
      });
}


function pintarRespuestaCategoria(items){

    $("#resultado").empty();

   //declarar variables js
   let myTable="<table>";
   myTable += "<tr><th>Codigo</th><th>Nombre</th></tr>";
   for(i=0;i<items.length;i++){
       myTable+="<tr>";
       myTable+="<td>"+ items[i].id+ "</td>";
       myTable+="<td>"+ items[i].name+"</td>";
       // myTable+="<td><button onclick='borrarCategoria("+items[i].id+")'>Borrar</button>";
       myTable+="</tr>";
    }
   myTable +="</table>";
   $("#resultado").append(myTable);
}


function GuardarInformacionCategoria() {
                  
    $("#resultado").empty();
    let myData={name: $("#nameCategoria").val()}
    let dataToSend=JSON.stringify(myData);
    
    $.ajax({

        url:"http://localhost:8080/api/categoria/salvarcategoria",
        type:"POST",
        data:dataToSend,
        contentType:"application/JSON",
        datatype:"JSON",
        success:function(respuesta){
           alert("Inserccion Exitosa");
        },
        error:function(xhr,status){
            alert('Operacion no satisfactoria,'+ xhr.status);
        }
    });
}