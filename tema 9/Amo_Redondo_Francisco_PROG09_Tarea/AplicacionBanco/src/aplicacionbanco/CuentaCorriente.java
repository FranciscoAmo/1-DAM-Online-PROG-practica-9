package aplicacionbanco;

import static aplicacionbanco.Validaciones.pedirOtraEntidad;
import java.io.Serializable;
import java.util.ArrayList;

public abstract class CuentaCorriente extends CuentaBancaria implements Serializable {

    private ArrayList<Entidades> entidadesCobro;

    public CuentaCorriente(Persona titular, double saldo, String ccc) {
        super(titular, saldo, ccc);
        this.entidadesCobro = new ArrayList<>();
    }

    public ArrayList<Entidades> getEntidadesCobro() {
        return entidadesCobro;
    }

    public void introducirEntidadCobro(Entidades e) {
        entidadesCobro.add(e);
       

    }

    public String listarEntidades() {
        String listado = "ENTIDADES CON PERMISO DE COBRO(ENTIDAD/CANTIDAD):\n";
        String entidades = "";
        for (int i = 1; i < entidadesCobro.size(); i++) {
                    entidades = entidades + i + "-" + entidadesCobro.get(i).getEntidadesCobro()
                    + "\t/" + entidadesCobro.get(i).getMaxCobro() + "\n";

        }
        return listado + entidades;
    }

    @Override
    public String toString() {
        return super.toString() + listarEntidades();
    }

}
