public class Corrente extends Conta {

    public double rendimento() {
        return getSaldo() * 0.015;
    }
}
