import java.io.Serializable;

/**
 * Clase Sororitas
 * @author cristian
 * @version 1.0
 */
public class Sororitas implements Serializable {

    /**
     * Atributos de clase
     */
    private int codigo;
    private String nome;
    private int puntos;

    /**
     * Constructor de la clase
     * @param codigo el codigo
     * @param nome el nombre
     * @param puntos los puntos
     */
    public Sororitas(int codigo, String nome, int puntos) {
        this.codigo = codigo;
        this.nome = nome;
        this.puntos = puntos;
    }

    public Sororitas(String nome, int puntos) {
        this.nome = nome;
        this.puntos = puntos;
    }

    public Sororitas() {
    }


    /**
     * getter y setter
     * @return los atributos
     */
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    @Override
    public String toString() {
        return "\nnome: " + nome +
                "\npuntos: " + puntos;
    }
}
