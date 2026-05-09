package com.trips.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.trips.models.Rol;

@Service
public class RolServiceImpl implements IRolService {

    private List<Rol> lista = null;

    public RolServiceImpl() {

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        lista = new LinkedList<>();

        try {
            Rol rol1 = new Rol();
            rol1.setId(1);
            rol1.setNomRol("Gerente");
            rol1.setDescripcion("Encargado de supervisar todas las áreas y sus colaboradores");
            rol1.setActivo("Activo");
            rol1.setFecha(sdf.parse("11-11-2016"));

            Rol rol2 = new Rol();
            rol2.setId(2);
            rol2.setNomRol("Subgerente");
            rol2.setDescripcion("Brindar apoyo al gerente y servir de puente con colaboradores");
            rol2.setActivo("Inactivo");
            rol2.setFecha(sdf.parse("13-05-2020"));

            Rol rol3 = new Rol();
            rol3.setId(3);
            rol3.setNomRol("Colaborador");
            rol3.setDescripcion("Ejecutar las tareas asignadas dentro de la empresa");
            rol3.setActivo("Activo");
            rol3.setFecha(sdf.parse("13-06-2024"));

            Rol rol4 = new Rol();
            rol4.setId(4);
            rol4.setNomRol("Visitante");
            rol4.setDescripcion("Persona externa que interactúa con la empresa");
            rol4.setActivo("Activo");
            rol4.setFecha(sdf.parse("11-08-2014"));

            lista.add(rol1);
            lista.add(rol2);
            lista.add(rol3);
            lista.add(rol4);

        } catch (ParseException e) {
            System.out.println("Error al parsear fecha: " + e.getMessage());
        }
    }

    @Override
    public List<Rol> buscarTodos() {
        return lista;
    }

    @Override
    public Rol buscarPorId(Integer idRol) {
        for (Rol rol : lista) {
            if (rol.getId() == idRol) {
                return rol;
            }
        }
        return null;
    }

    @Override
    public void eliminar(Integer idRol) {
        lista.removeIf(rol -> rol.getId() == idRol);
    }
}