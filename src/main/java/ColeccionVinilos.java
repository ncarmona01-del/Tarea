

public class ColeccionVinilos {

    public static int MAX_COLECCION = 100;

    public static void vinilosIniciales(String m[][]) {
        agregarVinilo(m, "Iron Maiden", "Iron Maiden", "1980", false);
        agregarVinilo(m, "Iron Maiden", "Killers", "1981", false);
        agregarVinilo(m, "Iron Maiden", "The number of the beast", "1982", false);
        agregarVinilo(m, "AC-DC", "Back in black", "1980", false);
        agregarVinilo(m, "AC-DC", "Highway to Hell", "1979", false);
        agregarVinilo(m, "AC-DC", "Who made who", "1986", false);
        agregarVinilo(m, "Judas Priest", "British steel", "1980", false);
        agregarVinilo(m, "Judas Priest", "Painkiller", "1990", false);
        agregarVinilo(m, "Judas Priest", "Defenders of the faith", "1984", false);
        agregarVinilo(m, "Kiss", "Destroyer", "1976", false);
    }

    public static int totalVinilos(String m[][]) {
        for (int i = 0; i < m.length; i++) {
            if (m[i][0] == null) {
                return i;
            }
        }
        return m.length;
    }

    public static void agregarVinilo(String m[][], String artista, String album, String año, boolean mostrarMensaje) {
        int indice = totalVinilos(m);
        if (indice >= m.length) {
            System.out.println("Error: Colección llena. No se pudo agregar '" + album + "'.");
        } else {
            m[indice][0] = artista;
            m[indice][1] = album;
            m[indice][2] = año;

            if (mostrarMensaje) {
                System.out.println("¡Vinilo '" + album + "' agregado con éxito!");
            }
        }
    }

    public static boolean buscarViniloPorAlbum(String m[][], String album) {
        int total = totalVinilos(m);
        for (int i = 0; i < total; i++) {
            if (m[i][1] != null && m[i][1].equalsIgnoreCase(album)) {
                return true;
            }
        }
        return false;
    }

    public static void mostrarBusquedaArtista(String m[][], String artista) {
        int total = totalVinilos(m);
        boolean encontrado = false;
        for (int i = 0; i < total; i++) {
            if (m[i][0] != null && m[i][0].equalsIgnoreCase(artista)) {
                System.out.println("  -> " + m[i][0] + " | " + m[i][1] + " | " + m[i][2]);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontraron vinilos del artista: " + artista);
        }
    }

    public static void mostrarColeccion(String m[][]) {
        int total = totalVinilos(m);
        if (total == 0) {
            System.out.println("La colección está vacía.");
            return;
        }
        for (int i = 0; i < total; i++) {
            System.out.println((i + 1) + ". " + m[i][0] + " | " + m[i][1] + " | " + m[i][2]);
        }
    }

    public static void mostrarTotal(String m[][]) {
        System.out.println("Total de vinilos en colección: " + totalVinilos(m));
    }

    public static int disponibles(String m[][]) {
        return m.length - totalVinilos(m);
    }

    public static void mostrarDisponibles(String m[][]) {
        System.out.println("Espacios disponibles: " + disponibles(m));
    }

    public static boolean buscarArtista(String m[][], String artista) {
        int total = totalVinilos(m);
        for (int i = 0; i < total; i++) {
            if (m[i][0] != null && m[i][0].equalsIgnoreCase(artista)) {
                return true;
            }
        }
        return false;
    }
}