import java.util.Scanner;

public class Utilidades {

    private static final Scanner SC = new Scanner(System.in);

    /**
     * Devuelve un número entero aleatorio entre min y max (ambos incluidos).
     */
    public static int numeroAleatorio(int min, int max) {
        return (int)(Math.random() * (max - min + 1)) + min; //devuelve un número aleatorio entre min y máx (ambos incluids)
    }

    /**
     * Convierte una coordenada tipo "A5" en fila.
     * Suponemos que la parte numérica es la fila.
     * Consideramos que EXISTE LA FILA 0.
     * Ejemplo: "A5" -> 5
     *
     * Si la coordenada no es válida, debe devolver -1.
     */
    public static int convertirFila(String coord) { //convierte la coordenada en fila
        if (coord.length() < 2) return -1; //si es muy corta, no es válida
        String numero = coord.substring(1); //quita le letra y guarda sólo el número
        return Integer.parseInt(numero); //convierte el texto a número
    }

    /**
     * Convierte una coordenada tipo "A5" en columna.
     * La letra indica la columna: A=0, B=1, C=2, ...
     *
     * Si la coordenada no es válida, puede devolver -1.
     */
    public static int convertirColumna(String coord) {
        if (coord.length() < 1) return -1; //comprueba si el texto está vacía, y si lo está devuelve un -1 (error)
        String letra = coord.substring(0, 1); //coge la primera letra de la coordenada
        if (letra.equals("A")) return 0; //si la letra es A, la columna es 0
        if (letra.equals("B")) return 1; //si la letra es B, la columna es 1, y así sucesivamente
        if (letra.equals("C")) return 2;
        if (letra.equals("D")) return 3;
        if (letra.equals("E")) return 4;
        if (letra.equals("F")) return 5;
        if (letra.equals("G")) return 6;
        if (letra.equals("H")) return 7;
        if (letra.equals("I")) return 8;
        if (letra.equals("J")) return 9;
        return -1; //sino devuelve -1
    }

    /**
     * Lee una línea de texto de la entrada estándar.
     */
    public static String leerLinea() {
        return SC.nextLine();
    }
}