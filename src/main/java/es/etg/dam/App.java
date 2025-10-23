package es.etg.dam;

import java.io.IOException;

public class App {

    public static final int NUM0 = 0;
    public static final int NUM1 = 1;
    private static final String COMANDO = "convert";
    private static final String MSG_ERROR_ARGS = "Se deben introducir los valores correctamente";

    public static void main(String[] args) throws IOException, Exception {

        if (args.length < 2) {
            System.out.println(MSG_ERROR_ARGS);
            return;
        }

        String imagenEntrada = args[NUM0];
        String imagenSalida = args[NUM1];

        Ejecutable ejec = new Comando(COMANDO, imagenEntrada, imagenSalida);
        ejec.ejecutar();
    }
}