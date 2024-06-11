public class Conta {
    private String numero;
    private Cliente cliente;
    private double saldo;
    private double limite;

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNumero() {
        return this.numero;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public double rendimento() {
        return 0;
    }

    public boolean sacar(Double valor) {
        if(this.saldo >= valor) {
            this.saldo -= valor;
            return true;
        } else {
            return false;
        }
    }

    public void depositar(Double valor) {
        this.saldo += valor;
    }

    public boolean transferir(Double valor, Conta conta2) {
        if(sacar(valor)) {
            conta2.depositar(valor);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Conta [numero=" + numero + ", cliente=" + cliente + ", saldo=" + saldo + "]";
    }

}
