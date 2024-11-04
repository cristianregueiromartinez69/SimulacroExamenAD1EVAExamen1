import java.util.List;

/**
 * Clase main donde ejecutamos el programa
 * @author cristian
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {

        //objeto de la clase LecturaEscrituraFicheros
        LecturaEscrituraFicheros lecturaCodigos = new LecturaEscrituraFicheros();

        //objeto de la clase CrudDB
        CrudDB crudDB = new CrudDB();

        LecturaEscrituraXml lecturaEscrituraXml = new LecturaEscrituraXml();

        //path con los codigos
        String pathCodigos = "C:/Users/crm23/OneDrive/Escritorio/dam2Clase/Acceso a Datos/SimulacroEXADEva1/codigosUnidades.txt";

        //hacemos una lista de codigos igual al metodo que nos devuelve los codigos del fichero
        List<Integer> listaCodigos = lecturaCodigos.getListaCodigos(pathCodigos);

        //hacemos una lista de objetos de una clase igual al metodo que nos devuelve un objeto de esa clase
        List <Sororitas> sororitasList = crudDB.getListSororitas(listaCodigos);

        //path del fichero a escribir los objetos
        String pathFicheroDatos = "C:/Users/crm23/OneDrive/Escritorio/dam2Clase/Acceso a Datos/SimulacroEXADEva1/sororitas.dat";

        /**
         * Escribimos y leemos del fichero serializable
         */
        lecturaCodigos.escribirFicheroSerializable(sororitasList, pathFicheroDatos);
        List<Sororitas> sororitasList1 =  lecturaCodigos.readFileDatSororitas(pathFicheroDatos);
        String pathXml = "sororitas.xml";

        lecturaEscrituraXml.escrituraArchivoXml(sororitasList1, pathXml);

        lecturaEscrituraXml.lecturaXmlSororitas(pathXml);




    }
}

//path archivo codigos
/**
 * "C:/Users/crm23/OneDrive/Escritorio/dam2Clase/Acceso a Datos/SimulacroEXADEva1/codigosUnidades.txt"
 */

//codigo comprobacion lecrura fichero
/**
 *  List<Integer> listaCodigos = lecturaCodigos.getListaCodigos("C:/Users/crm23/OneDrive/Escritorio/dam2Clase/Acceso a Datos/SimulacroEXADEva1/codigosUnidades.txt");
 *
 *         for(int codigo: listaCodigos) {
 *             System.out.println(codigo);
 *         }
 */