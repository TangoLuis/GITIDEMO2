package com.Empresa.proyecto.Entity;

import lombok.Data;

@Data
public class MovimientoDenero {
    private Double monto;
    private String conceptoMovi;
    private Empleado empleado;
    private Double creacionMonto;

    public double dato(boolean e){
        if (e==true){
            this.creacionMonto=1000.0;
        }
        else {
            this.creacionMonto=-1000.0;
        }
        return creacionMonto;
    }
}
