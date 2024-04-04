package testaconta;

public class TestaConta {
    
    public static void main(String[] args) {
        
        Conta c = new Conta();
        c.setSaldo(10000);
        System.out.println("Saldo do cliente:"+c.getSaldo());
        
        Conta referencia = new Conta();
        referencia.setSaldo(1000.0); 
        referencia.saca(3501);
        //referencia.limite = 500.0;
     //   referencia.numero = 1;
        
        System.out.println("Saldo do Cliente: " + referencia.getSaldo());
      //  System.out.println("Limite do Cliente: " + referencia.limite);
      //  System.out.println("Número da Conta: " + referencia.numero);
        
        Cliente cliente1 = new Cliente();
        Cliente cliente2 = new Cliente();
        cliente1.nome = "João Paulo Pimentel";
        cliente1.codigo = 1;
        
        cliente2.nome = "José da Silva";
        cliente2.codigo = 2;        
        
        System.out.println("Nome do cliente 1: " + cliente1.nome);
        System.out.println("Codigo do cliente 1 :" + cliente1.codigo);
        
        System.out.println("Nome do cliente 2: " + cliente2.nome);
        System.out.println("Codigo do cliente 2 :" + cliente2.codigo);
        
        CartaoDeCredito cartao1 = new CartaoDeCredito();
        CartaoDeCredito cartao2 = new CartaoDeCredito();
        
        cartao1.numero = 123456789;
        cartao1.dataDeValidade = "14/03/2030";
        
                
        cartao2.numero = 123456790;
        cartao2.dataDeValidade = "14/03/2031";
        
        System.out.println("Numero do Cartao 1: " + cartao1.numero);
        System.out.println("Data de validade do cartao 1: " + cartao1.dataDeValidade);
        
        System.out.println("Numero do Cartao 2: " + cartao2.numero);
        System.out.println("Data de validade do cartao 2: " + cartao2.dataDeValidade);
        
        Agencia agencia1 = new Agencia();
        Agencia agencia2 = new Agencia();
        
        agencia1.numero = 1;
        agencia1.uf = "DF";
        agencia2.numero = 2;
        agencia2.uf = "GO";
        
        System.out.println("Numero da Agencia 1: " + agencia1.numero);
        System.out.println("UF da Agencia 1: " + agencia1.uf);
        
        System.out.println("Numero da Agencia 2: " + agencia2.numero);
        System.out.println("UF da Agencia 2: " + agencia2.uf);
        
        CartaoDeCredito cdc = new CartaoDeCredito();
        Cliente cl = new Cliente();
        cdc.cliente = cl;
        
        cdc.cliente.nome = "Maria da Silva";
        cdc.cliente.codigo = 1;
        
        System.out.println("Nome do Cliente: " + cdc.cliente.nome);
        System.out.println("Codigo do Cliente: " + cdc.cliente.codigo);
        
        Agencia agencia = new Agencia();
        Conta conta = new Conta();
        agencia.conta = conta;
        
   //     agencia.conta.saldo = 1000.0;
   //     agencia.conta.numero = 1;
        
   //     System.out.println("Saldo da Conta: " + agencia.conta.saldo);
   //     System.out.println("Numero da Conta: " + agencia.conta.numero);
        
    }
    
}
