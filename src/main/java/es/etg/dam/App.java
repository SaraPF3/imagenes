package es.etg.dam;

import java.io.IOException;

public class App {

    private static final String COMANDO = "convert";
    private static final String RUTA = "src/main/resources/";
    public static final String ENTRADA = RUTA + "monalisa.jpg";
    public static final String SALIDA = RUTA + "monalisa.png";

    public static void main(String[] args) throws IOException, Exception {

        Ejecutable ejec = new Comando(COMANDO, ENTRADA, SALIDA);
        ejec.ejecutar();
    }
}