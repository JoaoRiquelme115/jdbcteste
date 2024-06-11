import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!\n\n");
        
        // Instanciando o primeiro cliente
        Cliente cl1 = new Cliente();
        cl1.setNome("Gabriel Coqueiro");
        cl1.setTelefone("77999996666");

        // Instanciando a primeira conta
        // Conta co1 = new Conta();
        // co1.setNumero("555-5");
        // co1.setCliente(cl1);
        // co1.depositar(1000.0);

        Poupanca co2 = new Poupanca();
        co2.setNumero("555-6");
        co2.setCliente(cl1);
        co2.depositar(5.0);

        // >>>>> CONEXÃO CRUD
        
        // Testando inserir uma conta
        // ContaService.inserir(co2);

        /* 
        // Testando atualizar uma conta
        Cliente cl2 = new Cliente();
        cl2.setNome("riquelme");
        cl2.setTelefone("77988821046");
        co1.setCliente(cl2);
        ContaService.atualizar(co1,"555-0");
        */

        // Testando deletar uma conta
        // ContaService.deletar(co1);
        
        // Testando listar todas as contas e listar por numero da conta
        // listarArray(ContaService.listarContas());
        // System.out.println("\n\n");
        listarArray(ContaService.listarPorNumero("555-6"));

    }

    public static void listarArray(List<Conta> lista) {
        for(int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i));
        }
    }

    public static Connection getConexao() {
        Connection conexao = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://200.128.9.179:3306/bancoifba";
            String username = "remoto";
            String password = "remoto";
            conexao = DriverManager.getConnection(url,username,password);
        } catch(ClassNotFoundException | SQLException e) {
            System.err.println("Não foi possível encontrar o Driver especificado!");
            e.printStackTrace();
        }
        return conexao;
    }

}
