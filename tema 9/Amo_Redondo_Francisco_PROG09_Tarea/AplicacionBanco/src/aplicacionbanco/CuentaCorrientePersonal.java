
package aplicacionbanco;

import java.io.Serializable;



public class CuentaCorrientePersonal extends CuentaCorriente implements Serializable{
    private  double comision_mantenimiento;

    public CuentaCorrientePersonal( Persona titular, double saldo, String ccc) {
        super(titular, saldo, ccc);
        this.comision_mantenimiento =0;
    }

    public double getComision_mantenimiento() {
        return comision_mantenimiento;
    }

    public void setComision_mantenimiento(double comision_mantenimiento) {
        this.comision_mantenimiento = comision_mantenimiento;
    }

    @Override
    public String toString() {
        return super.toString() + " COMISION_MANTENIMIENTO: " + comision_mantenimiento+"\n\n";
    }

  

  
    
}
