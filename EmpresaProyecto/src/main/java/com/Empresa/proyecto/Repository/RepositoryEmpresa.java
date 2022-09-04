package com.Empresa.proyecto.Repository;

import com.Empresa.proyecto.Entity.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryEmpresa extends JpaRepository<Empresa, Long> {

}
