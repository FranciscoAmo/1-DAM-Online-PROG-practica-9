// esta cuenta permite tener una cantidad al descubierto: deber dinero
// se cobrara intereses por ese descubierto 


package aplicacionbanco;

import static aplicacionbanco.Validaciones.pedirEfectivo;
import java.io.Serializable;


public class CuentaCorrienteEmpresa extends CuentaCorriente implements Serializable{
    private double tipoIntDescubierto;
    private double maxDescubiertoPermitido;
    private double comisionFijaPorDescubierto;

    public CuentaCorrienteEmpresa(Persona titular, double saldo, String ccc) {
        super(titular, saldo, ccc);
        this.tipoIntDescubierto = 0;
        this.maxDescubiertoPermitido = 0;
        this.comisionFijaPorDescubierto=0;
    }

    public CuentaCorrienteEmpresa(Persona titular, double saldo, String ccc,double tipoIntDescubierto, double maxDescubiertoPermitido) {
        super(titular, saldo, ccc);
        this.tipoIntDescubierto = tipoIntDescubierto;
        this.maxDescubiertoPermitido = maxDescubiertoPermitido;
    }

    public double getTipoIntDescubierto() {
        return tipoIntDescubierto;
    }

    public void setTipoIntDescubierto(double tipoIntDescubierto){
        this.tipoIntDescubierto = tipoIntDescubierto;
    }

    public double getMaxDescubiertoPermitido() {
        return maxDescubiertoPermitido;
    }

    public void setMaxDescubiertoPermitido(double maxDescubiertoPermitido) {
        this.maxDescubiertoPermitido = maxDescubiertoPermitido;
    }

    public double getComisionFijaPorDescubierto() {
        return comisionFijaPorDescubierto;
    }

    public void setComisionFijaPorDescubierto(double comisionFijaPorDescubierto) {
        this.comisionFijaPorDescubierto = comisionFijaPorDescubierto;
    }

    
    
    @Override
    public String toString() {
        return super.toString()+ "\nTIPO_INTERES_DESCUBIERTO: " + tipoIntDescubierto + "\nMAX_DESCUBIERTO_PERMITIDO: " + maxDescubiertoPermitido+"\nCOMISION_FIJA_POR_DESCUBIERTO: "+comisionFijaPorDescubierto+"\n\n";
    }

   

    @Override
    public void retirarDinero(double efectivo) {
        
        if(efectivo>(maxDescubiertoPermitido+getSaldo())){
        System.err.println("NO PUEDES DEJAR AL DESCUBIERTO MAS DE "+ maxDescubiertoPermitido);
        retirarDinero(pedirEfectivo());
        }
        if(-(this.saldo)==maxDescubiertoPermitido){
        System.err.println("YA HAS LLEGADO AL LIMITE DE DESCUBIERTO");
        efectivo=0;
        }
        
        this.saldo=this.saldo-efectivo;
    }

    

    
    
    
    
    
    
}
