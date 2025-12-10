import java.util.Scanner;

public class Main {

    public static final int FILAS = 10;
    public static final int COLUMNAS = 10;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Tamaños de los barcos
        int[] tamanosBarcos = {5, 4, 3, 3, 2};
        int numBarcos = tamanosBarcos.length;

        // Tableros de barcos
        int[][] tableroBarcosJugador = Tablero.crearTableroBarcos(FILAS, COLUMNAS);
        int[][] tableroBarcosCPU = Tablero.crearTableroBarcos(FILAS, COLUMNAS);

        // Tableros de disparos
        char[][] tableroDisparosJugador = Tablero.crearTableroDisparos(FILAS, COLUMNAS);
        char[][] tableroDisparosCPU = Tablero.crearTableroDisparos(FILAS, COLUMNAS);

        // Impactos
        int[] impactosJugador = new int[numBarcos];
        int[] impactosCPU = new int[numBarcos];

        // Inicializar impactos a 0
        for (int i = 0; i < numBarcos; i++) {
            impactosJugador[i] = 0;
            impactosCPU[i] = 0;
        }

        // Colocar barcos
        System.out.println("Colocando barcos del jugador...");
        Barcos.colocarBarcosAleatorios(tableroBarcosJugador, tamanosBarcos);

        System.out.println("Colocando barcos de la CPU...");
        Barcos.colocarBarcosAleatorios(tableroBarcosCPU, tamanosBarcos);

        boolean finPartida = false;
        boolean turnoJugador = true;

        // Bucle principal
        while (!finPartida) {
            System.out.println();
            System.out.println("=============================");
            System.out.println("HUNDIR LA FLOTA - NUEVO TURNO");
            System.out.println("=============================");

            if (turnoJugador) {

                System.out.println("Turno del JUGADOR");

                // Mostrar tablero del jugador
                System.out.println("Tu tablero (tus barcos):");
                Tablero.mostrarTableroConBarcos(tableroBarcosJugador, tableroDisparosCPU);

                // Mostrar disparos del jugador
                System.out.println("Tus disparos sobre la CPU:");
                Tablero.mostrarTableroDisparos(tableroDisparosJugador);

                // Pedir coordenada
                System.out.print("Introduce coordenada (ej. A5): ");
                String coord = sc.nextLine().trim().toUpperCase();

                // Convertir coordenadas
                int fila = Utilidades.convertirFila(coord);
                int columna = Utilidades.convertirColumna(coord);

                if (!Tablero.esCoordenadaValida(fila, columna, FILAS, COLUMNAS)) {

                    System.out.println("Coordenada fuera del tablero. Pierdes el turno.");

                } else if (Disparos.yaDisparado(tableroDisparosJugador, fila, columna)) {

                    System.out.println("Ya habías disparado ahí. Pierdes el turno.");

                } else {

                    // Ejecutar disparo del jugador
                    boolean barcoHundido = Disparos.procesarDisparo(
                            fila,
                            columna,
                            tableroBarcosCPU,
                            tableroDisparosJugador,
                            impactosCPU,
                            tamanosBarcos
                    );

                    if (barcoHundido) {
                        System.out.println("¡Has hundido un barco!");
                    } else {
                        System.out.println("Disparo realizado.");
                    }
                }

                // Comprobar si la CPU ha perdido
                if (Barcos.todosHundidos(impactosCPU, tamanosBarcos)) {
                    System.out.println("¡Has ganado! Has hundido todos los barcos de la CPU.");
                    finPartida = true;
                }

            } else {

                System.out.println("Turno de la CPU");

                int filaCPU;
                int columnaCPU;

                // La CPU busca una coordenada válida donde no haya disparado
                do {
                    filaCPU = Utilidades.numeroAleatorio(0, FILAS - 1);
                    columnaCPU = Utilidades.numeroAleatorio(0, COLUMNAS - 1);
                } while (Disparos.yaDisparado(tableroDisparosCPU, filaCPU, columnaCPU));

                System.out.println("La CPU dispara a (" + filaCPU + ", " + columnaCPU + ")");

                // Ejecutar disparo de la CPU
                boolean barcoHundidoJugador = Disparos.procesarDisparo(
                        filaCPU,
                        columnaCPU,
                        tableroBarcosJugador,
                        tableroDisparosCPU,
                        impactosJugador,
                        tamanosBarcos
                );

                if (barcoHundidoJugador) {
                    System.out.println("La CPU te ha hundido un barco...");
                }

                // Comprobar si el jugador ha perdido
                if (Barcos.todosHundidos(impactosJugador, tamanosBarcos)) {
                    System.out.println("Has perdido. La CPU ha hundido todos tus barcos.");
                    finPartida = true;
                }
            }

            // Cambiar turno
            turnoJugador = !turnoJugador;
        }

        sc.close();
        System.out.println("Fin de la partida.");
    }
}
