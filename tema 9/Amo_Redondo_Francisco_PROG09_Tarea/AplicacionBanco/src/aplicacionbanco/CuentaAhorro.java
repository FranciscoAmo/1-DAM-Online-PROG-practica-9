
package aplicacionbanco;

import java.io.Serializable;

public class CuentaAhorro extends CuentaBancaria implements Serializable{
    private double tipo_interes;

    public CuentaAhorro( Persona titular ,double saldo, String ccc) {
        super(titular, saldo, ccc);
        this.tipo_interes =0;
    }

    public double getTipo_interes() {
        return tipo_interes;
    }

    public void setTipo_interes(double tipo_interes) {
        this.tipo_interes = tipo_interes;
    }

    @Override
    public String toString() {
         
        return super.toString()+ "\nTIPO_INTERES :" + tipo_interes+"\n\n";
    }

    

    

    
    
    
}
