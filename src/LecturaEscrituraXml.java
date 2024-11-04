import javax.xml.stream.*;
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

    public void lecturaXmlSororitas(String path) {

        String elementoActual = "";
        String codigo = "";
        String nome = "";
        String puntos = "";

        XMLInputFactory xif = XMLInputFactory.newInstance();
        try{
            XMLStreamReader xmlStreamReader = xif.createXMLStreamReader(new FileInputStream(path));

            int element;

            while(xmlStreamReader.hasNext()){
                element = xmlStreamReader.next();

                if(element == XMLStreamConstants.START_ELEMENT){
                    elementoActual = xmlStreamReader.getLocalName();
                }
                else if(element == XMLStreamConstants.CHARACTERS){
                    String text = xmlStreamReader.getText().trim();
                    if("codigo".equals(elementoActual) && !text.isEmpty()){
                        codigo = text;
                    }
                    else if("nome".equals(elementoActual) && !text.isEmpty()){
                        nome = text;
                    }
                    else if("puntos".equals(elementoActual) && !text.isEmpty()){
                        puntos = text;
                    }
                }
                else if(element == XMLStreamConstants.END_ELEMENT){
                    if("unidad".equals(xmlStreamReader.getLocalName())){
                        System.out.println("Codigo: " + codigo);
                        System.out.println("Nome: " + nome);
                        System.out.println("Puntos: " + puntos);
                    }
                }
            }
            xmlStreamReader.close();
        } catch (XMLStreamException e) {
            System.out.println("Ups, ha ocurrido un error al operar con el archivo xml");
        }catch(FileNotFoundException e){
            System.out.println("Ups, no se encontro el archivo para leerlo");
        }

    }
}
