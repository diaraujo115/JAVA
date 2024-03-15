
package testaconta;


public class TestaConta {

    
    public static void main(String[] args) {
       //Criando objetos da classe Conta
        Conta referencia = new Conta();
        referencia.saldo = 1000.0;
        referencia.limite = 500.0;
        referencia.numero = 1; 

        System.out.println(referencia.saldo);
        System.out.println(referencia.limite);
        System.out.println(referencia.numero);
        
         System.out.println(" ");

       
        
        //Criando objetos da classe Cliente
        Cliente cliente1 = new Cliente();
        Cliente cliente2 = new Cliente();
            cliente1.nome= "Ryan";
            cliente1.codigo=1;
            cliente2.nome= "Lucas";
            cliente2.codigo=2;
        
            System.out.println("Nome cliente 1: " + cliente1.nome);
            System.out.println("Cod cliente 1: " + cliente1.codigo);
            System.out.println("Nome cliente 2: " +cliente2.nome);
            System.out.println("Cod cliente 2: " + cliente2.codigo);
            
            System.out.println(" ");

            

         //Criando objetos da classe CartaoDeCredito
         CartaoDeCredito cartao1 = new CartaoDeCredito();
         CartaoDeCredito cartao2 =  new CartaoDeCredito();
            cartao1.numero=123;
            cartao1.dataDeValidade="09/30";
            cartao2.numero=321;
            cartao2.dataDeValidade="06/30";
            
            System.out.println("Numero cartão 1: " + cartao1.numero);
            System.out.println("Data de validade cartão 1: " + cartao1.dataDeValidade);
            System.out.println("Numero cartão 2: " + cartao2.numero);
            System.out.println("Data de validade cartão 2: " + cartao2.dataDeValidade);
            
                        System.out.println(" ");

        //Criando objetos da classe Agencia
        Agencia agencia1 = new Agencia();
        Agencia agencia2 = new Agencia();
            agencia1.numero=444;
            agencia1.uf="DF";
            agencia2.numero=555;
            agencia2.uf="AM";
            
            System.out.println("Numero agência 1: " + agencia1.numero);
            System.out.println("UF da agência 1: " + agencia1.uf);
            System.out.println("Numero agência 2: " + agencia2.numero);
            System.out.println("UF da agência 2: " + agencia2.uf);
       
        
        System.out.println(" ");

        
       //Criando um relacionamento entre objetos da classe Cliente  e da classe CartaoDeCredito
                  
        CartaoDeCredito cdc =  new CartaoDeCredito();
        Cliente c = new Cliente();
        cdc.cliente=c;
        
        cdc.cliente.nome ="Maria da Silva";
        cdc.cliente.codigo=453;
        
        System.out.println("Nome do Cliente: " + cdc.cliente.nome);
        System.out.println("Codigo do Cliente: " +cdc.cliente.codigo);
        
        System.out.println(" ");

        
        
        Conta cont =  new Conta();
        Agencia a = new Agencia();
        cont.agencia=a;
        
        cont.agencia.numero =3213555;
        cont.agencia.uf="RJ";
        
        System.out.println("Numero da Agência: " + cont.agencia.numero);
        System.out.println("UF da agência: " +cont.agencia.uf);
    }
    
}
