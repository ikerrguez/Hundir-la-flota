public class Tablero {

    /**
     * Crea un tablero de barcos y lo inicializa a -1 (sin barco).
     * En las posiciones del barco, guardaremos su id más adelante.
     * Lo devuelve como resultado!
     */
    public static int[][] crearTableroBarcos(int filas, int columnas) {
        int[][] tablero = new int[filas][columnas];
        for (int f = 0; f < filas; f++) {
            for (int c = 0; c < columnas; c++) {
                tablero[f][c] = -1;//sin barco
            }
        }
        return tablero;
    }

    /**
     * Crea un tablero de disparos y lo inicializa a '~' (no disparado).
     */
    public static char[][] crearTableroDisparos(int filas, int columnas) {
        char[][] tablero = new char[filas][columnas];
        for (int f = 0; f < filas; f++) {
            for (int c = 0; c < columnas; c++) {
                tablero[f][c] = '~';//no disparado
            }
        }
        return tablero;
    }

    /**
     * Muestra un tablero de disparos (del jugador o de la CPU).
     * Recuerda que tienes que imprimir también el número de fila, y el número de columna,
     * como un tablero real.
     * <p>
     * Recibe como entrada el tablero a imprimir, no devuelve nada de salida, simplemente lo imprime.
     */
    public static void mostrarTableroDisparos(char[][] tableroDisparos) {
        char[] letras = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};

        System.out.print("   "); //espacio inicial para la columna de números

        for (int c = 0; c < tableroDisparos[0].length; c++) {
            System.out.print(letras[c] + "  "); //imprime las letras con un espacio extra para separar
        }
        System.out.println(); //salto de línea

        for (int f = 0; f < tableroDisparos.length; f++) {
            // TRUCO DE ALINEACIÓN:
            // Si el número es 10 (2 cifras), ponemos un espacio después: "10 "
            // Si el número es 1-9 (1 cifra), ponemos dos espacios después: "1  "
            // Así siempre ocupan 3 huecos en total.
            if ((f + 1) < 10) {
                System.out.print((f + 1) + "  ");
            } else {
                System.out.print((f + 1) + " ");
            }
            for (int c = 0; c < tableroDisparos[f].length; c++) { //imprimime el contenido de la celda
                System.out.print(tableroDisparos[f][c] + "  "); //pone el símbolo y dos espacios para separar bien las columnas
            }
            System.out.println();
        }
    }

    /**
     * Muestra el tablero del jugador con sus barcos y el estado de disparos
     * de la CPU (agua, tocado, hundido). EL objetivo de esta función es mostrar
     * al usuario sus barcos junto a los disparos del enemigo (en un sólo tablero).
     * <p>
     * tableroBarcos: IDs de barcos o -1
     * tableroDisparosCPU: qué ha disparado la CPU sobre este tablero
     * <p>
     * Por ejemplo, si en la posición 1,1:
     * - hay agua y no ha habido disparos, '.'.
     * - hay agua y ha habido disparo, '~'.
     * - había un barco y hubo un disparo, pero el barco sigue activo: 'T'
     * - había un barco y hubo un disparo, el barco está hundido: 'H'
     * - hay un barco, el barco "1": 1
     */
    public static void mostrarTableroConBarcos(int[][] tableroBarcos, char[][] tableroDisparosCPU) {
        char[] letras = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};

        System.out.print("   "); //hueco para la esquina
        for (int c = 0; c < tableroBarcos[0].length; c++) {
            System.out.print(letras[c] + "  "); //letras más dos espacios
        }
        System.out.println(); //salto de línea

        for (int f = 0; f < tableroBarcos.length; f++) { //recorre filas
            // TRUCO DE ALINEACIÓN (Mismo que arriba)
            if ((f + 1) < 10) {
                System.out.print((f + 1) + "  "); //si 1 cifra -> 2 espacios
            } else {
                System.out.print((f + 1) + " "); //si 2 cifras -> 1 espacio
            }

            for (int c = 0; c < tableroBarcos[f].length; c++) { //recorre columnas
                int miBarco = tableroBarcos[f][c]; //-1 o ID del barco
                char disparoEnemigo = tableroDisparosCPU[f][c]; //'~', 'A', 'T', 'H'

                String simboloAImprimir = ""; //aquí se guarda lo que vamos a pintar

                if (miBarco == -1) {
                    //AGUA
                    //si si hay agua y no ha habido disparos: '.'
                    if (disparoEnemigo == '~') {
                        simboloAImprimir = ".";
                    } else {
                        //si hay agua y ha habido disparo: '~'
                        //truco para convertir char a String: comillas vacías + char
                        simboloAImprimir = "" + disparoEnemigo;
                    }
                } else {
                    //HAY BARCO
                    if (disparoEnemigo == 'T' || disparoEnemigo == 'H') { //si le han dado o hundido, mostramos eso ('T' o 'H')
                        simboloAImprimir = "" + disparoEnemigo;
                    } else {
                        //si hay barco y NO le han dado, mostramos su ID (0, 1, 2...)
                        simboloAImprimir = "" + miBarco;
                    }
                }

                System.out.print(simboloAImprimir + "  "); //imprime siempre con dos espacios al final
            }
            System.out.println();
        }
    }

    /**
     * Comprueba si una coordenada está dentro del tablero. Devuelve "true" si está, "false" si no está.
     */
    public static boolean esCoordenadaValida(int fila, int columna, int filas, int columnas) {
        if (fila >= 0 && fila < filas && columna >= 0 && columna < columnas) {
            return true; //está dentro
        } else {
            return false; //está fuera
        }
    }
}