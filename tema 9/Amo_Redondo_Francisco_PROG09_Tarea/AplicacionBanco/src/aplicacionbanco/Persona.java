
package aplicacionbanco;

import java.io.Serializable;

public class Persona implements Serializable {
 private String nombre;
 private String apellido;
 private String fecha_nac;

    public Persona(String nombre, String apellido, String fecha_nac) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha_nac = fecha_nac;
    }

    @Override
    public String toString() {
        return "Nombre:" + nombre + " / Apellido: " + apellido + " / Fecha_nac: " + fecha_nac;
    }


    
  
 
 
 
 
}
