import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase de lectura y escritura de ficheros
 * @author cristian
 * @version 1.0
 */
public class LecturaEscrituraFicheros {

    /**
     * Metodo que devuelve una lista de codigos de un fichero
     * @param path el path del archivo
     * @return la lista de codigos
     */
    public List<Integer> getListaCodigos(String path) {
        /**
         * Explicacion:
         * 1. creamos una lista de enteros
         * 2. creamos un file con el path del archivo
         * 3. si existe lo leemos y añadimos lo leido a la lista
         * 4. devolvemos la lista de codigos
         */
        List<Integer> listaCodigos = new ArrayList<>();
        File file = new File(path);

        if (file.exists()) {
            try {
                BufferedReader br = new BufferedReader(new FileReader(file));
                String linea;
                while ((linea = br.readLine()) != null) {
                    listaCodigos.add(Integer.parseInt(linea));
                }
            } catch (IOException e) {
                System.out.println("Ups, no se pudo leer el archivo");
            }
        }
        return listaCodigos;
    }

    /**
     * Metodo que escribe en un fichero serializable
     * @param sororitasList la lista de objetos a serializar
     * @param path el path del archivo
     */
    public void escribirFicheroSerializable(List<Sororitas> sororitasList, String path) {

        /**
         * Explicacion:
         * 1. creamos el fichero
         * 2. si no existe se crea y si existe se escribe en el
         * 3. llamamos a la clase ObjectOutputStream para escribir en el fichero
         * 4. hacemos un for para ir escribiendo en el fichero con los diferentes objetos de la lista
         */
        File file = new File(path);
        if (!file.exists()) {
            try {
                if (file.createNewFile()) {
                    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
                    for (Sororitas sor : sororitasList) {
                        oos.writeObject(sor);
                    }
                    oos.close();
                    System.out.println("Escritura en el fichero con exito");
                }
            } catch (IOException e) {
                System.out.println("Ups, no se pudo escribir el archivo para escribir en datos");
            }


        } else {
            try {
                if (file.isFile()) {
                    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
                    for (Sororitas sor : sororitasList) {
                        oos.writeObject(sor);
                    }
                    oos.close();
                    System.out.println("Fichero creado y escritura con exito");
                }
            } catch (IOException e) {
                System.out.println("Ups, no se pudo crear el archivo para escribir en datos");
            }

        }
    }

    /**
     * Metodo que lee el fichero serializable
     * @param path el path del fichero
     */
    public void readFileDatSororitas(String path){
        /**
         * Explicacion:
         * 1. hacemos un objeto file y de parámetro le metemos el path
         * 2. preguntamos si existe
         * 3. creamos un objeto de ObjectInputStream para leer el archivo
         * 4. mientras lo leido sea diferente de null, imprime los resultados
         * 5. capturamos excepciones
         */
        File file = new File(path);
        if (file.exists()) {
            try{
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
                Sororitas sor;
                while((sor = (Sororitas)ois.readObject()) != null){
                    System.out.println(sor);
                }
            } catch (IOException e) {
                System.out.println("Ups, no se pudo leer el archivo dat o has llegado al final");
            }catch(ClassNotFoundException e){
                System.out.println("Ups, no se encontró la clase");
            }
        }
    }
}
