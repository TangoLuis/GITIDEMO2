package com.Empresa.proyecto.Controller;

import com.Empresa.proyecto.Entity.Empleado;
import com.Empresa.proyecto.Entity.Empresa;
import com.Empresa.proyecto.Services.ServiceEmpleado;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Api(tags= "Empleado", description = "metodos para el Api Empleado")
@RestController
@RequestMapping(value = "/api")
public class ControllerEmpleado {
@Autowired
    ServiceEmpleado serviceEmpleado;


    @GetMapping(path = "/enterprises/listarEmpleados", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> listartodo() {

        return new ResponseEntity<Object>(serviceEmpleado.listarEmpleados(), HttpStatus.OK);
    }

    @PostMapping(path = "/users/crearEmpleado", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    /*public ResponseEntity<Boolean> insertarEmpleado(@RequestBody Empleado empleado) {

        return new ResponseEntity<Boolean>(serviceEmpleado.insertarEmpleado(empleado), HttpStatus.OK);*/
    public Empleado insertar(@RequestBody Empleado empleado){
        return serviceEmpleado.insertarEmpleado(empleado);
    }
    @GetMapping(path ="/users/BuscarEmpleado/{documento}",produces= MediaType.APPLICATION_JSON_VALUE)
    public Optional BuscarEmpleadoDoc (@PathVariable Long documento){
        return serviceEmpleado.BuscarEmpleadoDoc(documento);

    }


    @PatchMapping(path ="/users/actualizarEmpleado", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void actualizarEmpleado(@RequestBody Empleado empleado) {

        serviceEmpleado.actualizarEmpleado(empleado);

    }
    @DeleteMapping(path = "/enterprises/borrarEmpleado/{documento}")
    public void borrarEmpleado(@PathVariable Long documento){

        serviceEmpleado.borrarEmpleado(documento);
    }

}
