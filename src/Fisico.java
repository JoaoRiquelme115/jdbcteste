public class Fisico extends Cliente {
    private String cpf;

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCpf() {
        return this.cpf;
    }

    public boolean validaCpf(String cpf) {
        return true;
    }
}
