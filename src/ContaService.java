import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ContaService {
    
    public static void inserir(Conta conta) throws SQLException {
        try(Connection conn = App.getConexao()) {
            String sql = "INSERT INTO conta (numero,cliente,saldo) VALUES (?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,conta.getNumero());
            ps.setString(2,conta.getCliente().getNome());
            ps.setDouble(3,conta.getSaldo());
            int res = ps.executeUpdate();
            if(res > 0) {
                System.out.println("CONTA INSERIDA!");
            }
        } catch(SQLException ex) {
            System.out.println("NÃO FOI POSSÍVEL INSERIR A CONTA!");
        }
    }

}
