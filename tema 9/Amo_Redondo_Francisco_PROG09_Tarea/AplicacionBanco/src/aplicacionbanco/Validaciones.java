package aplicacionbanco;

import java.util.Scanner;

public class Validaciones {

    static Scanner sc = new Scanner(System.in);

    public static String pedirCcc() {

        String ccc = "";

        boolean validacion = false;
        do {

            try {
                validacion = true;
                System.out.println("INTRODUCE EL CCC");

                ccc = sc.nextLine();

                if (ccc.length() != 20) {
                    System.err.println("NO SON LA CANTIDAD CORRECTA DE DIGITOS");
                    validacion = false;
                }
                if (!obtenerDigitos(ccc).equals(ccc.substring(8, 10))) {
                    System.err.println("LOS DIGITOS DE CONTROS CON CONCUERDAN");
                    validacion = false;
                }

            } catch (NumberFormatException | StringIndexOutOfBoundsException ex) {
                System.err.println("dDEBES INTRODUCIR NUMEROS");
                validacion = false;
            }

        } while (validacion == false);

        System.out.println("ccc VALIDO");
        sc.reset();
        return ccc;
    }

    // para obtener los digitos de control del cc introducido(metodo estatico para poder usarlo en establecerCcc()
    public static String obtenerDigitos(String ccc) {
        String digitos;
        int digito1 = 0;
        int digito2 = 0;
        int[] factores = {1, 2, 4, 8, 5, 10, 9, 7, 3, 6};
        //entidad-oficina
        for (int i = 0; i < factores.length - 2; i++) {
            digito1 += factores[i + 2] * Integer.parseInt(ccc.substring(i, i + 1));
        }
        //cuenta
        for (int i = 0; i < factores.length; i++) {
            digito2 += factores[i] * Integer.parseInt(ccc.substring(i + 10, i + 11));
        }
        //calulo el resto
        digito1 = 11 - (digito1 % 11);
        digito2 = 11 - (digito2 % 11);
        //resto de 11
        if (digito1 == 11) {
            digito1 = 0;
        } else {
            if (digito1 == 10) {
                digito1 = 1;
            }
        }

        if (digito2 == 11) {
            digito2 = 0;
        } else {
            if (digito2 == 10) {
                digito2 = 1;
            }
        }
        digitos = String.valueOf(digito1) + String.valueOf(digito2);
        return digitos;
    }

    public static String pedirNombre() {
        String nombre;
        System.out.println("INRODUCE EL NOMBRE");
        nombre = sc.nextLine();
        sc.reset();
        return nombre;
    }

    public static String pedirApellidos() {
        String apellidos;
        System.out.println("INTRODUCE EL APELLIDO");
        apellidos = sc.nextLine();
        sc.reset();
        return apellidos;
    }

    public static String pedirfechanacimiento() {
        String fecha = "";
        int dia;
        int mes;
        int año;
        boolean salir;
        do {
            salir = true;
            try {
                System.out.println("INTRODUCE EL DIA DE NACIMIENTO");
                dia = Integer.parseInt(sc.nextLine());
                if (dia > 31) {
                    salir = false;
                }
                sc.reset();
                System.out.println("INTRODUCE EL MES DE NACIMIENTO");
                mes = Integer.parseInt(sc.nextLine());
                if (mes > 12) {
                    salir = false;
                }
                sc.reset();
                System.out.println("INTRODUCE EL AÑO DE NACIMIENTO");
                año = Integer.parseInt(sc.nextLine());
                if (Integer.toString(año).length() != 4) {
                    salir = false;
                }
                if (!salir) {
                    System.err.println("NO ES UNA FECHA VALIDA");
                }
                sc.reset();

                fecha = dia + "/" + mes + "/" + año;

            } catch (NumberFormatException ex) {
                System.err.println("DEBES INTRODUCIR NUMEROS");
                salir = false;
            }

            sc.reset();
        } while (!salir);

        return fecha;
    }

    public static int pedirMenu() {
        int opcion;
        do {
            System.out.println("BANCO");
            System.out.println("========================");
            System.out.println("1 - ABRIR UNA NUEVA CUENTA");
            System.out.println("2 - VER LISTADO DE CUENTAS DISPONIBLES");
            System.out.println("3 - OBTENER DATOS DE UNA CUENTA");
            System.out.println("4 - REALIZAR INGRESO EN UNA CUENTA");
            System.out.println("5 - RETIRAR EFECTIVO DE UNA CUENTA");
            System.out.println("6 - CONSULTAR EL SALDO DE UNA CUENTA");
            System.out.println("7 - SALIR");
            System.out.println("--------------------");
            System.out.println("  Introduce una opción:\n");
            try {
                opcion = Integer.parseInt(sc.nextLine());
                if (opcion < 0 || opcion > 7) {
                    System.err.println("introduce un valor entre 0-5");

                }
            } catch (NumberFormatException ex) {
                System.err.println("INTRODUCE NUMEROS");
                opcion = -1;

            }

        } while (opcion < 0 || opcion > 7);

        return opcion;
    }

    public static double pedirTipoInteres() {
        double tipo = 0;
        boolean salir;

        do {
            salir = true;
            System.out.println("INTRODUCE EL TIPO DE INTERES");
            try {
                tipo = Integer.parseInt(sc.nextLine());
                if (tipo < 0) {
                    System.err.println("EL TIPO DE INTERES NO PUEDE SER NEGATIVO");
                }
            } catch (NumberFormatException nfe) {
                System.err.println("INTRODUCE UN NUMERO VALIDO");
                salir = false;// menos 1 para que falle
            }
            sc.reset();
        } while (!salir);

        return tipo;
    }

    
    public static double pedirSaldo() {

        double saldo = 0;
        boolean salir;
        do {
            salir = true;
            System.out.println("INTRODUCE EL SALDO INICIAL");
            try {
                saldo = Integer.parseInt(sc.nextLine());

            } catch (NumberFormatException nfe) {
                System.err.println("INTRODUCE UNA CANTIDAD CORRECTA");
                salir = false;// falso para que falle
            }
            sc.reset();
        } while (!salir);

        return saldo;
    }

    
    public static double pedirEfectivo() {

        double efectivo = 0;
        boolean salir;
        do {
            salir = true;
            System.out.println("INTRODUCE EL EFECTIVO ");
            try {
                efectivo = Integer.parseInt(sc.nextLine());
                if (efectivo < 0) {
                    System.err.println("EL EFECTIVO DEBE SER POSITIVO");
                    salir = false;
                }

            } catch (NumberFormatException nfe) {
                System.err.println("INTRODUCE UN NUMERO");
                salir = false;// falso para que falle
            }
            sc.reset();
        } while (!salir);

        return efectivo;
    }

    
    public static double pedirComisionMax() {

        double comision = 0;
        boolean salir;
        do {
            salir = true;
            System.out.println("INTRODUCE EL DESCUBIERTO MAX PERMITIDO");
            try {
                comision = Integer.parseInt(sc.nextLine());
                if (comision < 0) {
                    System.err.println("DEBE SER UN VALOR POSITIVO");
                    salir = false;
                }

            } catch (NumberFormatException nfe) {
                System.err.println("INTRODUCE NUMEROS");
                salir = false;// falso para que falle
            }
            sc.reset();
        } while (!salir);

        return comision;
    }

    
    
    public static double pedirComisionFija() {

        double comision = 0;
        boolean salir;
        do {
            salir = true;
            System.out.println("INTRODUCE LA COMISION FIJA");
            try {
                comision = Integer.parseInt(sc.nextLine());
                if (comision < 0) {
                    System.err.println("DEBE SER UN VALOR POSITIVO");
                    salir = false;
                }

            } catch (NumberFormatException nfe) {
                System.err.println("INTRODUCE NUMEROS");
                salir = false;// falso para que falle
            }
            sc.reset();
        } while (!salir);

        return comision;
    }

    public static int pedirMenuCuentas() {
        int opcion;
        do {
            System.out.println("QUE TIPO DE CUENTA QUIERES ABRIR");
            System.out.println("========================");
            System.out.println("1 - CUENTA AHORRO");
            System.out.println("2 - CUENTA CORRIENTE PERSONAL");
            System.out.println("3 - CUENTA CORRIENTE EMPRESA");
            System.out.println("4 - SALIR");
            System.out.println("--------------------");
            System.out.println("  Introduce una opción:");
            try {
                opcion = Integer.parseInt(sc.nextLine());
                if (opcion < 0 || opcion > 4) {
                    System.out.println("introduce un valor entre 0-5");
                    opcion = -1;
                }
            } catch (NumberFormatException ex) {
                System.out.println("debes introducir numeros");
                opcion = -1;
            }
            sc.reset();
        } while (opcion < 0 || opcion > 4);

        return opcion;
    }

    
    
    public static Entidades pedirEntidades() {
        String entidades;
        int contador = 0;
        boolean salir;

        int seleccion;
        int cantidad = 0;

        EntidadesCobro[] ec = EntidadesCobro.values();
        EntidadesCobro entidad = null;
        Entidades e;
        do {
            salir = true;
            System.out.println("");
            for (EntidadesCobro value : EntidadesCobro.values()) {
                    entidades = contador + "-Entidad" + value;
                        contador++;
                    System.out.println(entidades);
            }

            System.out.println("QUE ENTIDAD QUIERES AÑADIR PARA PODER REALIZAR COBROS");
            System.out.println("introduce el numero de la entidad");
            try {
                seleccion = Integer.parseInt(sc.nextLine());
                if (seleccion > ec.length) {
                    System.err.println("DEBES INTRODUCIR VALORES ENTRE 0 Y " + ec.length);
                    salir = false;
                } else {
                    entidad = ec[seleccion];

                }

                System.out.println("QUE CANTIDAD ESTA AUTORIZADA A COBRAR");
                sc.reset();

                cantidad = Integer.parseInt(sc.nextLine());

            } catch (NumberFormatException ex) {
                System.err.println("DEBES INTRODUCIR NUMEROS");
                salir = false;
            }

        } while (!salir);
        e = new Entidades(entidad, cantidad);

        return e;
    }

    public static boolean pedirOtraEntidad() {
        String eleccion;
        boolean continuar;
        System.out.println("Quiere introducir otra entidad// SI PARA CONTINUAR");
        sc.reset();
        eleccion = sc.nextLine();
        if (eleccion.equalsIgnoreCase("si")) {
            continuar = true;
        } else {
            continuar = false;
        }
        return continuar;
    }

}
