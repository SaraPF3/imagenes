# Convertir formato de imágenes

Hecho por: Sara Pérez

> El link del repositorio es: <https://github.com/SaraPF3/imagenes>

En este proyecto se puede modificar el formato de las imágenes. Para ello, desde la carpeta **classes** se ejecuta, por ejemplo, el comando **java es.etg.dam.App monalisa.jpg monalisa.png**, para obtener la imagen con la extensión png.

En el archivo **App.java** se ejecuta el comando con los dos parámetros dados:

```java
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
```

La clase **Comando** obtiene los datos de **App** y los utiliza el método ejecutar:

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
```

**Ejecutable** es la interfaz que lanza la clase **Comando**:

```java
public interface Ejecutable {
    String ejecutar() throws IOException, Exception;
}
```
