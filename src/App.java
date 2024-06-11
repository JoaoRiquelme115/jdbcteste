import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!\n\n");
        
        // Instanciando o primeiro cliente
        Cliente cl1 = new Cliente();
        cl1.setNome("caio");
        cl1.setTelefone("77988821045");

        // Instanciando a primeira conta
        Conta co1 = new Conta();
        co1.setNumero("555-0");
        co1.setCliente(cl1);
        co1.setSaldo(1000.0);

        
        // >>>>> CONEXÃO CRUD
        /*
        // Testando inserir uma conta
        ContaService.inserir(co1);
        */

        /* 
        // Testando atualizar uma conta
        Cliente cl2 = new Cliente();
        cl2.setNome("riquelme");
        cl2.setTelefone("77988821046");
        co1.setCliente(cl2);
        ContaService.atualizar(co1,"555-0");
        */

        /*
        // Testando deletar uma conta
        ContaService.deletar(co1);
        */
        
        // Testando listarContas
        System.out.println(ContaService.listarContas());
        
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
