package es.etg.dam;

import java.io.IOException;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Comando implements Ejecutable {

    private String comando;
    private String parametro;
    private String parametro2;


    public Comando(String comando) {
        this.comando = comando;
    }

    @Override
    public String ejecutar() throws IOException, Exception {

        String MSG_ERROR = "Ha ocurrido un error al ejecutar el comando.";
        int NUM0 = 0;
        int NUM_ERR = 34;
        StringBuilder output = new StringBuilder();

        String[] comand = {comando, parametro, parametro2};

        try {
            Process process = Runtime.getRuntime().exec(comand);

            int exitVal = process.waitFor();
            if (exitVal == NUM0) {
            } else {
                System.out.println(MSG_ERROR);
            }

        } catch (IOException | InterruptedException e) {
            System.exit(NUM_ERR);
        }
        return output.toString();
    }
}
