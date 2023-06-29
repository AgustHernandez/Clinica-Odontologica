function getTurnos(){
    let url = "/api/turnos";
    let method = "GET";
    let data = null;
    apiCall(url, method, data, construirTablaTurnos);
}

function construirTablaTurnos(response){
    response.forEach(turno => {
            let get_More_Info_Btn = '<button' +
                                        ' id=' + '\"' + 'btn_id_' + turno.id + '\"' +
                                        ' type="button" class="btn btn-info btn_id">' +
                                        "Modificar" +
                                        '</button>';

           let delete_Btn = '<button' +
                                  ' id=' + '\"' + 'btn_id_' + turno.id + '\"' +
                                  ' type="button" class="btn btn-info btn_id">' +
                                  "Eliminar" +
                                  '</button>';

            let tr_id = 'tr_' + turno.id;
            let turnoRow = '<tr id=\"' + tr_id + "\"" + '>' +
                      '<td>' + get_More_Info_Btn + delete_Btn + '</td>' +
                      '<td>' + turno.fecha + '</td>' +
                      '<td>' + turno.paciente.nombre + " " + turno.paciente.apellido + '</td>' +
                      '<td>' + turno.odontologo.nombre + " " + turno.odontologo.apellido + '</td>' +
                      '</tr>';
            $('#turnoTable tbody').append(turnoRow);
    });
}