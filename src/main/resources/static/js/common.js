function mostrarToast(mensaje, tipo) {
  Toastify({
    text: mensaje,
    duration: 3000,
    close: true,
    gravity: "top",
    position: "right",
    backgroundColor: tipo === 'success' ? '#27ae60' : '#e74c3c',
    stopOnFocus: true
  }).showToast();
}


