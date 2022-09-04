package com.Empresa.proyecto.Controller;

import com.Empresa.proyecto.Entity.Empresa;
import com.Empresa.proyecto.Services.ServiceEmpresa;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Api(tags= "Empresa", description = "metodos para el Api Empresa")
@RestController
@RequestMapping(value = "/api")
public class ControllerEmpresa {

    @Autowired
    ServiceEmpresa serviceEmpresa;

    @GetMapping(path = "/enterprises/listarEmpresas", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> listartodo() {

        return new ResponseEntity<Object>(serviceEmpresa.listarEmpresas(), HttpStatus.OK);
    }

    @PostMapping(path = "/enterprises/crearEmpresas", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> insertarPersona(@RequestBody Empresa empresa) {
        return new ResponseEntity<Boolean>(serviceEmpresa.insertarEmpresa(empresa), HttpStatus.OK);
    }

    @GetMapping(path ="/enterprises/BuscarEmpresa/{nit}",produces= MediaType.APPLICATION_JSON_VALUE)
    public Optional BuscarEmpresa (@PathVariable Long nit){
        return serviceEmpresa.BuscarPersonanit(nit);

    }

    @PatchMapping(path ="/enterprises/actualizarEmpresa", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void actualizarEmpresa(@RequestBody Empresa empresa) {

        serviceEmpresa.actualizarEmpresapar(empresa);

    }

    @DeleteMapping(path = "/enterprises/borrarEmpresa/{nit}")
    public void borrarPersonaJPA(@PathVariable Long nit){

        serviceEmpresa.borrarEmpressa(nit);
    }

}
