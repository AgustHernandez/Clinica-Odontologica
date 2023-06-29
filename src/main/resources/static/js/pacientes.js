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
                                        ' type="button" class="btn btn-info btn_id">' +
                                        "Modificar" +
                                        '</button>';

            let delete_Btn = '<button' +
                                  ' id=' + '\"' + 'btn_id_' + paciente.id + '\"' +
                                  ' type="button" class="btn btn-info btn_id">' +
                                  "Eliminar" +
                                  '</button>';

            let tr_id = 'tr_' + paciente.id;
            let pacienteRow = '<tr id=\"' + tr_id + "\"" + '>' +
                      '<td>' + get_More_Info_Btn + delete_Btn + '</td>' +
                      '<td>' + paciente.nombre.toUpperCase() + '</td>' +
                      '<td>' + paciente.apellido.toUpperCase() + '</td>' +
                      '<td>' + paciente.dni + '</td>' +
                      '</tr>';
            $('#pacienteTable tbody').append(pacienteRow);
    });
}