package com.Empresa.proyecto.Services;

import com.Empresa.proyecto.Entity.Empresa;
import com.Empresa.proyecto.Repository.RepositoryEmpresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceEmpresa {

    @Autowired
    RepositoryEmpresa repositoryEmpresa;

    public List<Empresa> listarEmpresas() {

        List<Empresa> list = repositoryEmpresa.findAll();

        return list;
    }


    public Boolean insertarEmpresa(Empresa empresa) {
        try {
            repositoryEmpresa.save(empresa);
        } catch (Exception e) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    /*public Empresa BuscarEmpresa(Long nit) {

       repositoryEmpresa.findById(nit);

         return empresa;
    }*/
    public Optional< Empresa > BuscarPersonanit(Long nit) {
        return repositoryEmpresa.findById(nit);
    }

    public void actualizarEmpresapar (Empresa empresa){

        Empresa EmpTemp = repositoryEmpresa.findById(empresa.getNit()).orElse(null);

        if (empresa.getNombreEmpresa() != null){
            EmpTemp.setNombreEmpresa(empresa.getNombreEmpresa());
        }else if(empresa.getDireccionEmpresa() !=null){
            EmpTemp.setDireccionEmpresa(empresa.getDireccionEmpresa());
        } else if (empresa.getTelefono() != null) {
            EmpTemp.setTelefono(empresa.getTelefono());
        }

        repositoryEmpresa.save(EmpTemp);
    }

    public void  borrarEmpressa(Long nit){
        repositoryEmpresa.deleteById(nit);
    }

}

