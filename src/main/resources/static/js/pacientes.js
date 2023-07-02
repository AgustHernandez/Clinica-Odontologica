function getPacientes(){
    let url = "/api/pacientes";
    let method = "GET";
    let data = null;
    apiCall(url, method, data, construirTablaPacientes);
}

function construirTablaPacientes(response){
    response.forEach(paciente => {
            let get_More_Info_Btn = '<button' +
                                        ' id=' + '\"' + 'btn_id_' + paciente.id + '\"' +
                                        ' type="button"' + 'onclick=' + 'modificarPaciente(' + paciente.id + ') class="btn btn-info btn_id">' +
                                        "Modificar" +
                                        '</button>';

            let delete_Btn = '<button' +
                                              ' id=' + '\"' + 'btn_id_' + paciente.id + '\"' +
                                              ' type="button"' + 'onclick=' + 'deletePaciente(' + paciente.id + ') "class="btn btn-info btn_id">' +
                                              "Eliminar" +
                                              '</button>';

            let tr_id = 'tr_' + paciente.id;
            let pacienteRow = '<tr id=\"' + tr_id + "\"" + ' class="rowData">' +
                      '<td>' + get_More_Info_Btn + delete_Btn + '</td>' +
                      '<td>' + paciente.nombre.toUpperCase() + '</td>' +
                      '<td>' + paciente.apellido.toUpperCase() + '</td>' +
                      '<td>' + paciente.dni + '</td>' +
                      '<td>' + paciente.direccion.calle.toUpperCase() + " " + paciente.direccion.altura.toUpperCase() + ", " + paciente.direccion.localidad.toUpperCase() + ", " + paciente.direccion.provincia.toUpperCase() + '</td>' +
                      '</tr>';
            $('#pacienteTable tbody').append(pacienteRow);
    });
}

function postPaciente(){
    let url = "/api/pacientes";
    let method = "POST";
    let data = {
        "apellido":document.getElementById("apellido").value,
        "nombre":document.getElementById("nombre").value,
        "dni":document.getElementById("dni").value,
        "direccion": {
                "calle":document.getElementById("calle").value,
                "altura":document.getElementById("altura").value,
                "localidad":document.getElementById("localidad").value,
                "provincia":document.getElementById("provincia").value,
        }
    };
    apiCall(url, method, data, agregarPaciente);
}

function agregarPaciente(response){
    document.getElementById("apellido").value = "";
    document.getElementById("nombre").value = "";
    document.getElementById("dni").value = "";
    document.getElementById("calle").value = "";
    document.getElementById("altura").value = "";
    document.getElementById("localidad").value = "";
    document.getElementById("provincia").value = "";

    mostrarToast("Paciente eliminado con éxito", "success");
}

function putPaciente(id){
    let url = "/api/pacientes/" + id;
    let method = "PUT";
    let data = null;
    apiCall(url, method, data, modificarPaciente);
}

function modificarPaciente(id){
    document.getElementById("popupModificacion").classList.remove("overlay")
    if(document.getElementById("popupModificacion").classList.contains("popupOpen")) {
        document.getElementById("popupModificacion").classList.remove("popupOpen");
        document.getElementById("popupModificacion").classList.add("popupClose");
    } else {
        document.getElementById("popupModificacion").classList.add("popupOpen");
        document.getElementById("popupModificacion").classList.remove("popupClose");
    }


    /*if (response == true) {
       mostrarToast("Paciente eliminado con éxito", "success");
       $('#pacienteTable tr.rowData').remove();
       getPacientes();
    } else{
        mostrarToast("Error al eliminar un paciente.", "error");
    }*/
}


function deletePaciente(id){
    let url = "/api/pacientes/" + id;
    let method = "DELETE";
    let data = null;
    apiCall(url, method, data, eliminarPaciente);
}

function eliminarPaciente(response){
    if (response == true) {
       mostrarToast("Paciente eliminado con éxito", "success");
       $('#pacienteTable tr.rowData').remove();
       getPacientes();
    } else{
        mostrarToast("Error al eliminar un paciente.", "error");
    }
}