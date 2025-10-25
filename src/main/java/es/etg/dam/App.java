package es.etg.dam;

import java.io.IOException;

public class App {

    private static final String COMANDO = "convert";
    private static final String RUTA = "src/main/resources/";
    public static final String ENTRADA = RUTA + "monalisa.jpg";
    public static final String SALIDA = RUTA + "monalisa.gif";
    private static final String MSG_ERROR = "Se deben introducir los valores correctamente";
    public static final boolean TR = true;
    public static final boolean FL = false;
    private static final String[] EXT_VALIDAS = {".jpg", ".jpeg", ".png", ".gif", ".bmp", ".tiff", "webp"};

    public static void main(String[] args) throws IOException, Exception {

        boolean exito = FL;

        for (String ext : EXT_VALIDAS) {
            if (SALIDA.endsWith(ext)) {
                Ejecutable ejec = new Comando(COMANDO, ENTRADA, SALIDA);
                ejec.ejecutar();
                exito = TR;
            }
        }

        if (exito != TR) {
            System.out.println(MSG_ERROR);
        }
    }
}
