package testaconta;


public class Conta {
   private double saldo;
   private double limite = 500;
   private int numero;
   
   public void deposita (double valor){
       this.saldo += valor;}
   
   public double consultaSaldoDisponivel(){
       return this.saldo + this.limite;
   }
   

   
   public void setSaldo(double saldo){
       this.saldo = saldo;
   }
   public double getSaldo(){
       return saldo;
   }
   
   public void setLimite(double limite){
       this.limite=limite;
   }
   
   public double getLimite(){
       return this.limite;
   }

   public void setNumero(int numero){
       this.numero=numero;
   }

   
   public void saca (double valor){
       if (valor<=0){
           System.out.println("NÃO PODE SACAR VALOR ZERADO OU NEGATIVO");
       }
       else if (valor>(this.saldo + this.limite)){
           System.out.println("SALDO INDISPONÍVEL");
       }
       else {
           this.saldo =  this.saldo = valor;
       }
   }
   
}
