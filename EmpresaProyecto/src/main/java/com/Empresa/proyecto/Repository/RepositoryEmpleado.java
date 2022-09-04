package com.Empresa.proyecto.Repository;

import com.Empresa.proyecto.Entity.Empleado;
import com.Empresa.proyecto.Entity.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryEmpleado extends JpaRepository<Empleado, Long> {
}
