public class Fisico extends Cliente {
    private String cpf;

    public void setCpf() {
        this.cpf = cpf;
    }

    public String getCpf() {
        return this.cpf;
    }

    public boolean validaCpf(String cpf) {
        return true;
    }
}
