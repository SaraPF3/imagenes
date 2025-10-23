package es.etg.dam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
        String N = "\n";
        StringBuilder output = new StringBuilder();

        String[] comand = {comando, parametro, parametro2};

        try {
            Process process = Runtime.getRuntime().exec(comand);

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append(N);
            }

            int exitVal = process.waitFor();
            if (exitVal == 0) {
            } else {
                System.out.println(MSG_ERROR);
            }

        } catch (IOException | InterruptedException e) {
            System.exit(34);
        }
        return output.toString();
    }
}
