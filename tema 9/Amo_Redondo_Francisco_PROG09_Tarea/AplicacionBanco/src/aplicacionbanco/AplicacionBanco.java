package aplicacionbanco;

import static aplicacionbanco.Validaciones.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AplicacionBanco {

    public static void main(String[] args) {
        int opcion;

        Scanner sc = new Scanner(System.in);

        Persona p;
        CuentaCorrientePersonal e;
        CuentaCorrienteEmpresa j;
        CuentaAhorro f;
        File file = new File("datos.txt");
        ArrayList<CuentaBancaria> cuentasbancarias = new ArrayList<>();
        
        boolean salir;
        if(file.exists()){
            try {
                ObjectInputStream ois =new ObjectInputStream(new FileInputStream(file));
                cuentasbancarias=(ArrayList<CuentaBancaria>)ois.readObject();
                
                
            } catch (FileNotFoundException ex) {
                Logger.getLogger(AplicacionBanco.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(AplicacionBanco.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(AplicacionBanco.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }
 
 
        do{
        opcion = pedirMenu();
  
        salir=false;
            
        switch (opcion) {

            case 1:
                int seleccion;
                seleccion = pedirMenuCuentas();
                
                switch (seleccion) {
                    case 1:
                        p = new Persona(pedirNombre(), pedirApellidos(), pedirfechanacimiento());
                        f = new CuentaAhorro(p,
                                pedirSaldo(),
                                pedirCcc());

                        f.setTipo_interes(pedirTipoInteres());

                        cuentasbancarias.add(f);
                        
                        

                        break;
                    case 2:
                        
                        p = new Persona(pedirNombre(), pedirApellidos(), pedirfechanacimiento());
                        e = new CuentaCorrientePersonal(p,
                                pedirSaldo(),
                                pedirCcc());
                        do{
                            
                            e.introducirEntidadCobro(pedirEntidades());
                          
                        }while(pedirOtraEntidad());
                        
                        e.setComision_mantenimiento(pedirComisionFija());
                        
                        cuentasbancarias.add(e);
                        
                        

                        break;
                    case 3:
                        p = new Persona(pedirNombre(), pedirApellidos(), pedirfechanacimiento());
                        j = new CuentaCorrienteEmpresa(p,
                                pedirSaldo(),
                                pedirCcc());
                            do{
                            
                            j.introducirEntidadCobro(pedirEntidades());
                           
                                 
                            }while(pedirOtraEntidad());
                        
                        
                        j.setComisionFijaPorDescubierto(pedirComisionFija());
                        j.setMaxDescubiertoPermitido(pedirComisionMax());
                        j.setTipoIntDescubierto(pedirTipoInteres());

                        cuentasbancarias.add(j);
                        
                        
                        break;
                    case 4:
                       
                        break;
                }

                break;
            case 2:
                
                    System.out.println();          
                for (CuentaBancaria c : cuentasbancarias) {
                    System.out.println("CCC: "+c.getCcc()+"/\tTITULAR: "+c.getTitular()+"/\tSALDO: "+c.getSaldo());
                    
                }
                    System.out.println();
                
                break;
            case 3:
                int i = 0;
                int eleccion;
                boolean salir2;
        
                    System.out.println();                   
                for (CuentaBancaria c : cuentasbancarias) {
                    System.out.println(i +"-/\tCCC: "+c.getCcc());
                    i++;
                }
                    System.out.println();
                do {
                    salir2 = true;
                    System.out.println("ELIGE EL NUMERO DE LA CUENTA A VER");
                    
                    try {

                        eleccion = Integer.parseInt(sc.nextLine());

                        System.out.println(cuentasbancarias.get(eleccion).toString());
                       

                    } catch (NumberFormatException nfe) {

                        System.err.println("INTRODUCE NUMEROS");
                        salir = false;
                    }catch(IndexOutOfBoundsException iobe){
                        System.err.println("NO ES UN VALOR VALIDO");
                        salir=false;
                    }
                } while (!salir2);

                break;
            case 4:
                i=0;
                    System.out.println();              
                for (CuentaBancaria c : cuentasbancarias) {
                    System.out.println(i +" -/\tCCC: "+ c.getCcc());
                    i++;
                    }
                    System.out.println();
                do {
                    salir2 = true;
                    System.out.println("ELIGE EL NUMERO DE LA CUENTA EN LA QUE QUIERES INGRESAR");
                    try {

                        eleccion = Integer.parseInt(sc.nextLine());

                        System.out.println(cuentasbancarias.get(eleccion).toString());
                        
                        cuentasbancarias.get(eleccion).realizarIngreso(pedirEfectivo());

                    } catch (NumberFormatException nfe) {

                        System.err.println("INTRODUCE NUMEROS");
                        salir = false;
                    }catch(IndexOutOfBoundsException iobe){
                        System.err.println("NO ES UN NUMERO VALIDO");
                        salir=false;
                    }
                } while (!salir2);
                
               
                
                
                break;
            case 5:
                
                i=0;
                    System.out.println();
                    System.out.println("numero\tCCC");
                    
                for (CuentaBancaria c : cuentasbancarias) {
                    System.out.println(i +" -/\t"+c.getCcc());
                    i++;
                    }
                    System.out.println();
                do {
                    salir2 = true;
                    System.out.println("ELIGE EL NUMERO DE LA CUENTA DE LA QUE QUIERES RETIRAR DINERO");
                    try {

                        eleccion = Integer.parseInt(sc.nextLine());

                        System.out.println(cuentasbancarias.get(eleccion).toString());
                        
                        cuentasbancarias.get(eleccion).retirarDinero(pedirEfectivo());

                    } catch (NumberFormatException nfe) {

                        System.err.println("INTRODUCE NUMEROS");
                        salir = false;
                    }catch(IndexOutOfBoundsException iobe){
                        System.err.println("NO ES UN NUMEROS VALIDO");
                        salir=false;
                    }
                } while (!salir2);
                
                
                break;
            case 6:
                
                
                 i=0;
                    System.out.println();
                    System.out.println("numero\t CCC");
                for (CuentaBancaria c : cuentasbancarias) {
                    System.out.println(i +"-/\t"+c.getCcc());
                    i++;
                    }
                    System.out.println();
                    
                do {
                    salir2 = true;
                    System.out.println("ELIGE EL NUMERO DE LA CUENTA EN LA QUE QUIERES CONSULTAR SALDO");
                    try {

                        eleccion = Integer.parseInt(sc.nextLine());
 
                        System.out.println("La cuenta tiene :"+cuentasbancarias.get(eleccion).getSaldo()+ " euros");

                    } catch (NumberFormatException nfe) {

                        System.out.println("INTRODUCE NUMEROS");
                        salir = false;
                    }catch(IndexOutOfBoundsException iobe){
                        System.out.println("NO ES UN NUMERO VALIDO");
                        salir=false;
                    }
                } while (!salir2);
                
           
                break;
            case 7:
                salir=true;
                
                 try {
             ObjectOutputStream ooe = new ObjectOutputStream(new FileOutputStream("datos.txt"));
            
            ooe.writeObject(cuentasbancarias);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AplicacionBanco.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AplicacionBanco.class.getName()).log(Level.SEVERE, null, ex);
        }
                
                break;

        }
         }while(!salir);
    }
      


       
    
    
}
