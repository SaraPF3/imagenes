package es.etg.dam;

import java.io.IOException;

public class App {

    public static final int NUM0 = 0;
    public static final int NUM1 = 1;
    private static final String COMANDO = "convert";
    private static final String MSG_ERROR = "Error: ";
    private static final String MSG_ERROR_ARGS = "Se deben introducir los valores correctamente";
    private static final String MSG_FIN = "Conversión completada: ";

    public static void main(String[] args) throws IOException, Exception {

        if (args.length < 2) {
            System.out.println(MSG_ERROR_ARGS);
            return;
        }

        String imagenEntrada = args[NUM0];
        String imagenSalida = args[NUM1];

        String[] comando = {COMANDO, imagenEntrada, imagenSalida};

        try {
            Process proceso = Runtime.getRuntime().exec(comando);

            int resultado = proceso.waitFor();

            if (resultado == 0) {
                System.out.println(MSG_FIN + imagenSalida);
            } else {
                System.out.println(MSG_ERROR + resultado);
            }

        } catch (IOException ioe) {
            System.out.println(MSG_ERROR + ioe);
        } catch (InterruptedException ie) {
            System.out.println(MSG_ERROR + ie.getMessage());
        }
    }
}