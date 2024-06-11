public class Juridico extends Cliente {
    private String cnpj;

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return this.cnpj;
    }

    public boolean validaCnpj(String cnpj) {
        return true;
    }
}
