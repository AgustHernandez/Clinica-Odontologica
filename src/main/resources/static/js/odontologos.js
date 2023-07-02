function getOdontologos(){
    let url = "/api/odontologos";
    let method = "GET";
    let data = null;
    apiCall(url, method, data, construirTablaOdontologos);
}

function construirTablaOdontologos(response){
    response.forEach(odontologo => {
            let get_More_Info_Btn = '<button' +
                                         ' id=' + '\"' + 'btn_id_' + odontologo.id + '\"' +
                                         ' type="button" class="btn btn-info btn_id">' +
                                         "Modificar" +
                                         '</button>';

            let delete_Btn = '<button' +
                                  ' id=' + '\"' + 'btn_id_' + odontologo.id + '\"' +
                                  ' type="button"' + 'onclick=' + 'deleteOdontologo(' + odontologo.id + ') "class="btn btn-info btn_id">' +
                                  "Eliminar" +
                                  '</button>';

            let tr_id = 'tr_' + odontologo.id;
            let odontologoRow = '<tr id=\"' + tr_id + "\"" + ' class="rowData">' +
                      '<td>' + get_More_Info_Btn + delete_Btn + '</td>' +
                      '<td>' + odontologo.nombre.toUpperCase() + '</td>' +
                      '<td>' + odontologo.apellido.toUpperCase() + '</td>' +
                      '<td>' + odontologo.matricula + '</td>' +
                      '</tr>';
            $('#odontologoTable tbody').append(odontologoRow);
    });
}

function postOdontologo(){
    let url = "/api/odontologos";
    let method = "POST";
    let data = {
        "apellido":document.getElementById("apellido").value,
        "nombre":document.getElementById("nombre").value,
        "matricula":document.getElementById("matricula").value
    };
    apiCall(url, method, data, agregarOdontologo);
}

function agregarOdontologo(response){
    document.getElementById("apellido").value = "";
    document.getElementById("nombre").value = "";
    document.getElementById("matricula").value = "";
}

function deleteOdontologo(id){
    let url = "/api/odontologos/" + id;
    let method = "DELETE";
    let data = null;
    apiCall(url, method, data, eliminarOdontologo);
}

function eliminarOdontologo(response){
    if (response == true) {
       mostrarToast("Odontologo eliminado con éxito", "success");
       $('#odontologoTable tr.rowData').remove();
       getOdontologos();
    }else{
        mostrarToast("Error al eliminar un odontologo.", "error");
    }
}
