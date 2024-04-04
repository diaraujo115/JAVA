package testaconta;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

public class TestaConta {

    public static void main(String[] args) {
      
Conta c = new Conta();
Conta c2 = new Conta();
ContaPoupanca cp = new ContaPoupanca(123);
double saldoDisponivel, saldoInicial;
saldoInicial = c.getSaldo();

String valor = JOptionPane.showInputDialog("Digite um valor para deposito: ");
double saldo = Double.parseDouble(valor);
c.setSaldo(saldo);
saldoDisponivel = c.getSaldo();
String mensagem = String.format("Saldo Inicial da Conta: " + saldoInicial +
     "\nSaldo Disponível após depósito: " + saldoDisponivel +
     "\nLimite do Cheque Especial: " + c.getLimite() +
     "\nSaldo Total do Cliente: " + c.consultaSaldoDisponivel());
       JOptionPane.showMessageDialog(null, mensagem);
       
       double rendimentoMensal = cp.calcularRendimentoMensal();
        JOptionPane.showMessageDialog(null, "Rendimento mensal da Conta Poupança: " + rendimentoMensal);
        
        
       String infoContaPoupanca = String.format("Número da Conta Poupança: %d\n" +
                "Saldo da Conta Poupança: %.2f\n" +
                "Data de Aniversário da Conta Poupança: %s\n" +
                "Taxa de Rendimento da Conta Poupança: %.2f%%\n" +
                "Valor do Rendimento Mensal se deixar o dinheiro aplicado durante um mês: %.2f\n" +
                "Saldo Total após 1 mês: %.2f",
                cp.getNumero(), cp.getSaldo(), cp.getDataAniversario().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), cp.getTaxaRendimento(), rendimentoMensal, (cp.getSaldo()+rendimentoMensal));
        JOptionPane.showMessageDialog(null, infoContaPoupanca);
        
String valorSaque = JOptionPane.showInputDialog("Digite um valor para saque: ");
double saque = Double.parseDouble(valorSaque);
c.saca(saque);
String mensagem2 = String.format("Saldo da Conta: " + c.getSaldo() +
        "\nSaldo Total da Conta após o saque: " +
        c.consultaSaldoDisponivel());
JOptionPane.showMessageDialog(null, mensagem2);   


String valorTransferencia = JOptionPane.showInputDialog("Digite um valor para Transferência: ");
double transf = Double.parseDouble(valorTransferencia);
double saldoConta1 = c.consultaSaldoDisponivel();
 if (transf <= saldoConta1){
   c.saca(transf);
   c2.deposita(transf);
 }
 else{
     System.out.println("Transferência não realizada!");
 }
String mensagem3 = String.format("Saldo da Conta 1: " + c.getSaldo() +
        "\nLimite da Conta 1: " + c.getLimite() +
        "\nSaldo Total da Conta 1 após a transferência: " +
        c.consultaSaldoDisponivel() + 
        "\n\nSaldo da Conta 2: " + c2.getSaldo() +
        "\nLimite da Conta 2: " + c2.getLimite() +
        "\nSaldo Total da Conta 2 após a transferência: " +
        c2.consultaSaldoDisponivel());
JOptionPane.showMessageDialog(null, mensagem3);   
     }
    
    
    
}
