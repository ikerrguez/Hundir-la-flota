public class Barcos {

    /**
     * Coloca todos los barcos indicados en tamanosBarcos. El array tamanosBarcos da los tamaños,
     * por ejemplo, 5, 4, 3, 3, 2. Así que para el barco "0" tienes que colocarlo en 5 posiciones consecutivas,
     * ya sea en horizontal o en vertical.
     *
     * Usa valores aleatorios para fila, columna y orientación (horizontal/vertical),
     * comprobando que:
     *  - no se sale del tablero
     *  - no se solapa con otros barcos
     *
     *  Recuerda, hay una función específica para colocar un barco. No dupliques el código aquí, desde aquí
     *  llama a esa función.
     *
     */
    public static void colocarBarcosAleatorios(int[][] tableroBarcos, int[] tamanosBarcos) {
        // TODO
    }

    /**
     * Comprueba si un barco de cierto tamaño cabe desde (fila, columna) en la orientación
     * indicada, sin salirse del mapa y sin solaparse con otros barcos.
     *
     * Nos devuelve true si se puede colocar, false si no se puede colocar.
     */
    public static boolean sePuedeColocarBarco(int[][] tablero, int fila, int columna, int tamano, boolean horizontal) {
        //TODO
        return false;
    }

    /**
     * Coloca realmente el barco en el tablero, escribiendo su ID en todas las celdas.
     */
    public static void colocarBarco(int[][] tablero, int fila, int columna, int tamano, boolean horizontal, int idBarco) {
        // TODO
    }

    /**
     * Comprueba si TODOS los barcos han sido hundidos.
     * Esto ocurre cuando impactos[i] == tamanosBarcos[i] para todos los barcos.
     *
     * Lo puedes llamar tras hacer un impacto con los arrays de impactos y tamaños
     * del jugador atacado para comprobar si ha acabado la partida.
     */
    public static boolean todosHundidos(int[] impactos, int[] tamanosBarcos) {
        //TODO
        return false;
    }
}