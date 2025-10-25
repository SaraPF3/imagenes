package es.etg.dam;

import java.io.IOException;

public class App {

    private static final String COMANDO = "convert";
    public static final int NUM0 = 0;
    public static final int NUM1 = 1;
    private static final String MSG_ERROR = "La extensión de la imagen no es correcta";
    private static final String MSG_ERROR_ARGS = "Se deben introducir los dos valores correctamente";
    public static final boolean TR = true;
    public static final boolean FL = false;
    private static final String[] EXT_VALIDAS = {".jpg", ".jpeg", ".png", ".gif", ".tiff", ".webp"};

    public static void main(String[] args) throws IOException, Exception {

        boolean exito = FL;

        if (args.length < 2) {
            System.out.println(MSG_ERROR_ARGS);
            return;
        }

        String imagenEntrada = args[NUM0];
        String imagenSalida = args[NUM1];

        for (String ext : EXT_VALIDAS) {
            if (imagenSalida.endsWith(ext)) {
                Ejecutable ejec = new Comando(COMANDO, imagenEntrada, imagenSalida);
                ejec.ejecutar();
                exito = TR;
            }
        }

        if (exito != TR) {
            System.out.println(MSG_ERROR);
        }
    }
}
