package com.Empresa.proyecto.Entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Empleado {
    @Id
    private Long documento ;
    private Rol rol;
    private String nombreEmpleado;
    private String correoEmpleado;
    private Empresa empresa;

}
