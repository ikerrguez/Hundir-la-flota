import java.util.Random;

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
        Random random = new Random(); //crea un objeto de la clase Random para generar números aleatorios

        for (int i = 0; i < tamanosBarcos.length; i++) { //recorre todos los tamaños de barcos (uno por cada barco)
            boolean colocado = false; //barco aun no fue colocado

            while (!colocado) { //repite hasta que el barco sea colocado
                int fila = random.nextInt(tableroBarcos.length); //fila aleatoria
                int columna = random.nextInt(tableroBarcos[0].length);//columna aleatoria
                boolean horizontal = random.nextBoolean(); //barco horizontal aleatorio (true)

                if (sePuedeColocarBarco(tableroBarcos, fila, columna, tamanosBarcos[i], horizontal)) { //si el barco cabe
                    colocarBarco(tableroBarcos, fila, columna, tamanosBarcos[i], horizontal, i);  //si el barco cabe y no choca con otro, lo dibuja en el tablero
                    colocado = true;
                }
            }
        }
    }

    /**
     * Comprueba si un barco de cierto tamaño cabe desde (fila, columna) en la orientación
     * indicada, sin salirse del mapa y sin solaparse con otros barcos.
     *
     * Nos devuelve true si se puede colocar, false si no se puede colocar.
     */
    public static boolean sePuedeColocarBarco(int[][] tablero, int fila, int columna, int tamano, boolean horizontal) {
        if (horizontal) {
            if (columna + tamano > tablero[0].length) {
                return false; //el barco no sale por la derecha del tabelro
            }
            for (int c = columna; c < columna + tamano; c++) {
                if (tablero[fila][c] != -1){
                    return false; //si está ocupada alguna celda, no se puede colocar
                }
            }
        } else {
            if (fila + tamano > tablero.length){
                return false; //el barco no se sale por debajo del tablero
            }
            for (int f = fila; f < fila + tamano; f++) {
                if (tablero[f][columna] != -1) {
                    return false; // si está ocupada alguna celda, no se puede colocar
                }
            }
        }
        return true;
    }

    /**
     * Coloca realmente el barco en el tablero, escribiendo su ID en todas las celdas.
     */
    public static void colocarBarco(int[][] tablero, int fila, int columna, int tamano, boolean horizontal, int idBarco) {
        if (horizontal) {
            for (int c = columna; c < columna + tamano; c++) {
                tablero[fila][c] = idBarco; //escribe que barco ocupa esta posición
            }
        } else {
            for (int f = fila; f < fila + tamano; f++) {
                tablero[f][columna] = idBarco; //escribe que barco ocupa esta posición
            }
        }
    }

    /**
     * Comprueba si TODOS los barcos han sido hundidos.
     * Esto ocurre cuando impactos[i] == tamanosBarcos[i] para todos los barcos.
     *
     * Lo puedes llamar tras hacer un impacto con los arrays de impactos y tamaños
     * del jugador atacado para comprobar si ha acabado la partida.
     */
    public static boolean todosHundidos(int[] impactos, int[] tamanosBarcos) {
        for (int i = 0; i < impactos.length; i++) {
            if (impactos[i] < tamanosBarcos[i]) return false; //si algún barco aún no recibió todos los impactos que tenía que recibir, aún no se acabó la partida
        }
        return true;
    }
}