package com.example.ProyectoFinal.datos;

import com.example.ProyectoFinal.exceptions.DuplicatedElementException;
import com.example.ProyectoFinal.exceptions.ElementAlreadyExistsException;
import com.example.ProyectoFinal.exceptions.ResourceNotFoundException;
import com.example.ProyectoFinal.model.Odontologo;
import com.example.ProyectoFinal.repository.IOdontologoRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class OdontologoDAOTest {

    @Mock
    private IOdontologoRepository odontologoRepository;

    @InjectMocks
    private OdontologoDAO odontologoDAO;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testListar() {
        List<Odontologo> odontologos = new ArrayList<>();
        when(odontologoRepository.findAll()).thenReturn(odontologos);

        List<Odontologo> resultado = odontologoDAO.listar();

        assertEquals(odontologos, resultado);
        verify(odontologoRepository, times(1)).findAll();
    }

    @Test
    public void testAgregar() throws ElementAlreadyExistsException {
        Odontologo odontologo = new Odontologo();
        when(odontologoRepository.save(odontologo)).thenReturn(odontologo);

        Odontologo resultado = odontologoDAO.agregar(odontologo);

        assertEquals(odontologo, resultado);
        verify(odontologoRepository, times(1)).save(odontologo);
    }

    @Test
    public void testModificar() throws ResourceNotFoundException, DuplicatedElementException {
        Odontologo odontologo = new Odontologo();
        when(odontologoRepository.save(odontologo)).thenReturn(odontologo);

        Odontologo resultado = odontologoDAO.modificar(odontologo,false);

        assertEquals(odontologo, resultado);
        verify(odontologoRepository, times(1)).save(odontologo);
    }

    @Test
    public void testEliminar() throws ResourceNotFoundException {
        Long id = 1L;
        Odontologo odontologo = new Odontologo();
        when(odontologoRepository.findById(id)).thenReturn(Optional.of(odontologo));

        Boolean resultado = odontologoDAO.eliminar(id);

        assertTrue(resultado);
        verify(odontologoRepository, times(1)).findById(id);
        verify(odontologoRepository, times(1)).delete(odontologo);
    }

    @Test(expected = NoSuchElementException.class)
    public void testEliminar_RecursoNoEncontrado() throws NoSuchElementException, ResourceNotFoundException {
        Long id = 1L;
        when(odontologoRepository.findById(id)).thenReturn(Optional.empty());

        odontologoDAO.eliminar(id);
    }

    @Test
    public void testBuscar() throws NoSuchElementException, ResourceNotFoundException {
        Long id = 1L;
        Odontologo odontologo = new Odontologo();
        when(odontologoRepository.findById(id)).thenReturn(Optional.of(odontologo));

        Odontologo resultado = odontologoDAO.buscar(id);

        assertEquals(odontologo, resultado);
        verify(odontologoRepository, times(1)).findById(id);
    }

    @Test(expected = NoSuchElementException.class)
    public void testBuscar_RecursoNoEncontrado() throws NoSuchElementException, ResourceNotFoundException {
        Long id = 1L;
        when(odontologoRepository.findById(id)).thenReturn(Optional.empty());

        odontologoDAO.buscar(id);
    }
}
