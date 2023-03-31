package edu.nur.edd.observer;

public class BancoTest {
    private CuentaObservada cuenta;

    public BancoTest() {
        cuenta = new CuentaObservada();
        ComercialAntojo20230213 comercial =
                new ComercialAntojo20230213();
        cuenta.addObserver(comercial);
    }

    public void test() {
        cuenta.depositar(100); //100
        cuenta.retirar(10); //90
        cuenta.depositar(200); //290
        cuenta.retirar(50); //240
        cuenta.depositar(340); //580
        cuenta.retirar(60); //520
    }

    @Override
    public String toString() {
        return "BancoTest{" +
                "cuenta=" + cuenta +
                '}';
    }

    public static void main(String[] args) {
        BancoTest b = new BancoTest();
        System.out.println(b);
        b.test();
        System.out.println(b);
    }
}
