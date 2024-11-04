import java.sql.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Clase con las operaciones crud de la base de datos
 * @author cristian
 * @version 1.0
 */
public class CrudDB {

    /**
     * metodo paara obtener un objeto tipo Sororitas que ordenamos de mayor a menor por puntos
     * @param codigo el codigo a introducir
     * @return el objeto
     */
    public Sororitas getSororitas(int codigo) {
        /**
         * Explicacion:
         * 1. creamos una consulta
         * 2. creamos un objeto vacío de Sororitas
         * 3. en el try-catch creamos la conexion
         * 4. preparamos la consulta y metemos el codigo
         * 5. mientras haya resultados, creamos un objeto con los valores de la consulta
         * 6. devolvemos el objeto
         */
        String consulta = "select nome,puntos from adeptaSororitas where cod = ?";
        Sororitas sororitas = new Sororitas();
        try{
            Connection conn = ConexionDB.conectar();
            PreparedStatement ps = conn.prepareStatement(consulta);
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                sororitas.setNome(rs.getString("nome"));
                sororitas.setPuntos(rs.getInt("puntos"));
            }
            conn.close();
        }catch(SQLException e){
            System.out.println("Ups, no se pudo conectar con la base de datos");
        }
        return sororitas;
    }

    /**
     * Metodo que devuelve una lista de objetos Sororitas
     * @param listaCodigos la lista de codigos
     * @return la lista de objetos
     */
    public List<Sororitas> getListSororitas(List<Integer> listaCodigos) {
        /**
         * Explicacion:
         * 1. creamos una lista de objetos Sororitas
         * 2. hacemos un bucle para recorrer la lista de codigos que pasamos por parámetro
         * 3. creamos un objeto igual al metodo que devuelve un objeto en la consulta
         * 4. añadimos el objeto a la lista
         * 5. la ordenamos de mayor a menor por precio
         * 6. devolvemos la lista
         */
        List<Sororitas> sororitasList = new ArrayList<>();
        for(Integer codigo : listaCodigos) {
            Sororitas sororitas = getSororitas(codigo);
            sororitasList.add(sororitas);
            sororitasList.sort(Comparator.comparing(Sororitas::getPuntos).reversed());
        }
        return sororitasList;
    }
}
