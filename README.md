# Convertir formato de imágenes

Hecho por: Sara Pérez

> El link del repositorio es: <https://github.com/SaraPF3/imagenes>

En este proyecto se puede modificar el formato de las imágenes.

En el archivo **App.java** se ejecuta el comando con los dos parámetros dados:

```java
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
```

La clase **Comando** obtiene los datos de **App** y los utiliza el el método ejecutar:

```java
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
        int NUM0 = 0;
        int NUM_ERR = 34;
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
```

**Ejecutable** es la interfaz que lanza la clase **Comando**:

```java
public interface Ejecutable {
    String ejecutar() throws IOException, Exception;
}
```
