package com.Empresa.proyecto.Entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Empresa {

        @Id
        private Long nit;
        private String nombreEmpresa;
        private String direccionEmpresa;
        private String telefono;

}
