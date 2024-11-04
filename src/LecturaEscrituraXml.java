import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.*;
import java.util.List;

public class LecturaEscrituraXml {

    public void escrituraArchivoXml(List<Sororitas> sororitasList, String path){
        XMLOutputFactory xof = XMLOutputFactory.newInstance();
        try{
            XMLStreamWriter xmlStreamWriter = xof.createXMLStreamWriter(new FileWriter(path));
            xmlStreamWriter.writeStartDocument();
            xmlStreamWriter.writeCharacters("\n");
            xmlStreamWriter.writeStartElement("unidades");

            for(int i = 0; i < sororitasList.size(); i++){
                xmlStreamWriter.writeCharacters("\n");
                xmlStreamWriter.writeStartElement("unidad");
                xmlStreamWriter.writeStartElement("codigo");
                xmlStreamWriter.writeCharacters(String.valueOf(sororitasList.get(i).getCodigo()));
                xmlStreamWriter.writeEndElement();
                xmlStreamWriter.writeCharacters("\n");
                xmlStreamWriter.writeStartElement("nome");
                xmlStreamWriter.writeCharacters(sororitasList.get(i).getNome());
                xmlStreamWriter.writeEndElement();
                xmlStreamWriter.writeCharacters("\n");
                xmlStreamWriter.writeStartElement("puntos");
                xmlStreamWriter.writeCharacters(String.valueOf(sororitasList.get(i).getPuntos()));
                xmlStreamWriter.writeEndElement();
                xmlStreamWriter.writeEndElement();
            }
            xmlStreamWriter.writeEndElement();
            xmlStreamWriter.writeEndDocument();
            xmlStreamWriter.close();
        } catch (XMLStreamException | IOException e) {
            System.out.println("Ups, no se encontro el archivo");
        }
    }
}
