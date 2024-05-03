
package com.mycompany.testaconta2;

public class TestaConta2 {

    public static void main(String[] args) {
        ContaCorrente c1 = new ContaCorrente();
        ContaPoupanca c2 = new ContaPoupanca();
        
        c1.deposita(500);
        c2.deposita(500);
        
        c1.saca(100);
        c2.saca(100);
        System.out.println("SALDO CONTA CORRENTE: "+c1.getSaldo());
        System.out.println("SALDO CONTA POUPANÇA: "+c2.getSaldo());
        
        GeradorDeExtrato g = new GeradorDeExtrato();
        g.geraExtrato(c1);
        g.geraExtrato(c2);

        
    }
}
