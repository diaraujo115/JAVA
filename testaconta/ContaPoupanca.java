
package testaconta;

import java.time.LocalDate;


public class ContaPoupanca {
       private double saldo;
       private int numero;
       private LocalDate dataAniversario;
       private double taxaRendimento;
       
       public ContaPoupanca(int numero) {
        this.numero = numero;
        this.taxaRendimento = 1.2; 
        this.saldo = 1350; 
        this.dataAniversario = LocalDate.of(2024, 5, 23);
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public LocalDate getDataAniversario() {
        return dataAniversario;
    }

    public void setDataAniversario(LocalDate dataAniversario) {
        this.dataAniversario = dataAniversario;
    }

    public double getTaxaRendimento() {
        return taxaRendimento;
    }

    public void setTaxaRendimento(double taxaRendimento) {
        this.taxaRendimento = taxaRendimento;
    }
    
    public double calcularRendimentoMensal() {
        double rendimento = (saldo * taxaRendimento) / 100.0;
        saldo += rendimento;
        return rendimento;
    }
    
    
       
  
 
}

