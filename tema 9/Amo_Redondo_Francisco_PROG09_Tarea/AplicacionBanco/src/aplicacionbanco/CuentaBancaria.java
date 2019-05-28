
package aplicacionbanco;

import static aplicacionbanco.Validaciones.pedirEfectivo;
import java.io.Serializable;



public abstract class CuentaBancaria implements Serializable{
    private Persona titular;
    double saldo=0;
    private String ccc;

    public CuentaBancaria(Persona titular, double saldo, String ccc) {
        this.titular = titular;
        this.saldo = saldo;
        this.ccc = ccc;
    }

    public Persona getTitular() {
        return titular;
    }

    public void setTitular(Persona titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getCcc() {
        return ccc;
    }

    public void setCcc(String ccc) {
        this.ccc = ccc;
    }
   
    public void realizarIngreso(double ingreso){
        this.saldo+=ingreso;
    }
    public void retirarDinero(double efectivo){
        if(efectivo>this.saldo){
        System.err.println("NO SE PUEDE PERDIR MAS DE "+saldo+" EUROS");
        retirarDinero(pedirEfectivo());
        }
        if(this.saldo==0){
        System.out.println("NO PUEDES SACAR DINERO");
        efectivo=0;
        }
        this.saldo=this.saldo-efectivo;
    }

    @Override
    public String toString() {
        return  "CCC: "+ ccc+ "\t/\tTITULAR: " +titular+ "\t/\tSALD: " +saldo + "/\n" ;
    }
    
  
}
