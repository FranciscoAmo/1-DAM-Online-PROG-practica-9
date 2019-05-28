
package aplicacionbanco;

public class Entidades {
  private EntidadesCobro entidadesCobro;
  private int maxCobro;
  
  
  
  public Entidades(EntidadesCobro entidadesCobro, int maxCobro){
  this.entidadesCobro=entidadesCobro;
  this.maxCobro=maxCobro;

  }

    public EntidadesCobro getEntidadesCobro() {
        return entidadesCobro;
    }

    public void setEntidadesCobro(EntidadesCobro entidadesCobro) {
        this.entidadesCobro = entidadesCobro;
    }

    public int getMaxCobro() {
        return maxCobro;
    }

    public void setMaxCobro(int maxCobro) {
        this.maxCobro = maxCobro;
    }
  





  
}
