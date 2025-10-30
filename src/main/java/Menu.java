import java.util.Scanner;

public class Menu {

    private Scanner scanner;
    private String[][] vinilos;

    public Menu(Scanner scanner, String[][] vinilos) {
        this.scanner = scanner;
        this.vinilos = vinilos;
    }

    public void iniciar() {
        int opcion = 0;
        do {
            mostrarOpciones();
            try {
                opcion = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Error: Debe ingresar un número.");
                scanner.nextLine();
                opcion = 0;
                continue;
            }
            scanner.nextLine();
            gestionarOpcion(opcion);
            if (opcion != 6) {
                System.out.print("Presione [Enter] para continuar...");
                scanner.nextLine();
            }
        } while (opcion != 6);
    }

    private void mostrarOpciones() {
        System.out.println("===================================");
        System.out.println("   GESTOR DE COLECCIÓN DE VINILOS");
        System.out.println("===================================");
        System.out.println("1. Ver colección completa");
        System.out.println("2. Agregar nuevo vinilo");
        System.out.println("3. Buscar vinilos (por Artista)");
        System.out.println("4. Verificar si existe (por Álbum)");
        System.out.println("5. Ver espacio disponible");
        System.out.println("6. Salir");
        System.out.println("===================================");
        System.out.print("Seleccione una opción: ");
    }

    private void gestionarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                System.out.println("--- COLECCIÓN COMPLETA ---");
                ColeccionVinilos.mostrarColeccion(this.vinilos);
                break;
            case 2:
                System.out.println("--- AGREGAR NUEVO VINILO ---");
                System.out.print("Ingrese Artista: ");
                String artista = scanner.nextLine();
                System.out.print("Ingrese Álbum: ");
                String album = scanner.nextLine();
                System.out.print("Ingrese Año: ");
                String año = scanner.nextLine(); // Cambio aquí
                ColeccionVinilos.agregarVinilo(this.vinilos, artista, album, año, true); // Cambio aquí
                break;
            case 3:
                System.out.println("--- BUSCAR POR ARTISTA ---");
                System.out.print("Ingrese nombre del artista a buscar: ");
                String artistaBusqueda = scanner.nextLine();
                ColeccionVinilos.mostrarBusquedaArtista(this.vinilos, artistaBusqueda);
                break;
            case 4:
                System.out.println("--- VERIFICAR POR ÁLBUM ---");
                System.out.print("Ingrese nombre del álbum a buscar: ");
                String albumBusqueda = scanner.nextLine();
                boolean existe = ColeccionVinilos.buscarViniloPorAlbum(this.vinilos, albumBusqueda);
                System.out.println("¿El vinilo '" + albumBusqueda + "' está en la colección? -> " + (existe ? "SÍ" : "NO"));
                break;
            case 5:
                System.out.println("--- ESPACIO DISPONIBLE ---");
                ColeccionVinilos.mostrarDisponibles(this.vinilos);
                ColeccionVinilos.mostrarTotal(this.vinilos);
                break;
            case 6:
                System.out.println("Cerrando el programa. ¡Adiós!");
                break;
            default:
                if (opcion != 0) {
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
                }
        }
    }
}

