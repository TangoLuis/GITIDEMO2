package com.Empresa.proyecto.Services;

import com.Empresa.proyecto.Entity.Empleado;
import com.Empresa.proyecto.Entity.Empresa;
import com.Empresa.proyecto.Repository.RepositoryEmpleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceEmpleado {

    @Autowired
    RepositoryEmpleado repositoryEmpleado;

    public List<Empleado> listarEmpleados() {

        List<Empleado> list = repositoryEmpleado.findAll();

        return list;
    }

    public Empleado insertarEmpleado (Empleado empleado) {
       /* try {
            repositoryEmpleado.save(empleado);
        } catch (Exception e) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;*/
        return repositoryEmpleado.save(empleado);

    }
    public Optional<Empleado> BuscarEmpleadoDoc(Long documento) {

        return repositoryEmpleado.findById(documento);
    }

    public void actualizarEmpleado (Empleado empleado){

        Empleado EmpleadoTemp = repositoryEmpleado.findById(empleado.getDocumento()).orElse(null);

        if (empleado.getNombreEmpleado() != null){
            EmpleadoTemp.setNombreEmpleado(empleado.getNombreEmpleado());
        }else if(empleado.getCorreoEmpleado() !=null){
            EmpleadoTemp.setCorreoEmpleado(empleado.getCorreoEmpleado());
        } else if (empleado.getRol() != null) {
            EmpleadoTemp.setRol(empleado.getRol());
        }

        repositoryEmpleado.save(EmpleadoTemp);
    }

    public void  borrarEmpleado(Long documento){
        repositoryEmpleado.deleteById(documento);
    }

}


