import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
            System.err.println("NÃO FOI POSSÍVEL INSERIR A CONTA!");
        }
    }

    public static void atualizar(Conta conta, String numero) throws SQLException {
        try(Connection conn = App.getConexao()) {
            String sql = "UPDATE conta SET numero = ?, cliente = ?, saldo = ? WHERE numero = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,conta.getNumero());
            ps.setString(2,conta.getCliente().getNome());
            ps.setDouble(3,conta.getSaldo());
            ps.setString(4,numero);
            int res = ps.executeUpdate();
            if(res > 0) {
                System.out.println("CONTA ATUALIZADA!");
            }
        } catch(SQLException ex) {
            System.err.println("NÃO FOI POSSÍVEL ATUALIZAR A CONTA!");
        }
    }

    public static void deletar(Conta conta) throws SQLException {
        try(Connection conn = App.getConexao()) {
            String sql = "DELETE FROM conta WHERE numero = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,conta.getNumero());
            int res = ps.executeUpdate();
            if(res > 0) {
                System.out.println("CONTA DELETADA!");
            }
        } catch(SQLException ex) {
            System.err.println("NÃO FOI POSSÍVEL DELETAR A CONTA!");
        }
    }

    public static List<Conta> listarContas() throws SQLException {
        List<Conta> contas = new ArrayList<>();
        try(Connection conn = App.getConexao()) {
            String sql = "SELECT * FROM conta";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {
                Conta c = new Conta();
                c.setNumero(rs.getString("numero"));
                //c.setCliente(((Conta) rs).getCliente());
                c.setSaldo(rs.getDouble("saldo"));
                contas.add(c);
            }
        } catch(SQLException ex) {
            System.err.println("NÃO FOI POSSÍVEL LISTAR AS CONTAS!");
            ex.printStackTrace();
        }
        return contas;
    }

    public static List<Conta> listarPorNumero(String numero) throws SQLException {
        List<Conta> contas = new ArrayList<>();
        try(Connection conn = App.getConexao()) {
            String sql = "SELECT * FROM conta WHERE numero = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,numero);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Conta c = new Conta();
                c.setNumero(rs.getString("numero"));
                //c.setCliente(((Conta) rs).getCliente());
                c.setSaldo(rs.getDouble("saldo"));
                contas.add(c);
            }
        } catch(SQLException ex) {
            System.err.println("NÃO FOI POSSÍVEL LISTAR AS CONTAS!");
            ex.printStackTrace();
        }
        return contas;
    }

}
