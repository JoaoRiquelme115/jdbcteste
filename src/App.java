import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        
    }

    public static Connection getConexao() {
        Connection conexao = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://200.128.9.179:3306/bancoifba";
            String username = "remoto";
            String password = "remoto";
            conexao = DriverManager.getConnection(url,username,password);
            System.out.println("CONECTADO AO BANCO DE DADOS!");
            return conexao;
        } catch(ClassNotFoundException e) {
            System.err.println("Não foi possível encontrar o Driver especificado!");
            return null;
        } catch(SQLException e) {
            System.err.println("Não foi possível conectar ao Banco de Dados!");
            return null;
        }
    }

}
