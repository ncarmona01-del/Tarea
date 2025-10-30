import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String[][] vinilos = new String[ColeccionVinilos.MAX_COLECCION][3];

        Scanner scanner = new Scanner(System.in);

        ColeccionVinilos.vinilosIniciales(vinilos);

        Menu menu = new Menu(scanner, vinilos);

        menu.iniciar();

        scanner.close();
    }
}
