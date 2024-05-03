package testafuncionarios;

public class TestaFuncionarios {

  
    public static void main(String[] args) {
       ControleDePonto ponto = new ControleDePonto();
       Gerentes g = new Gerentes();
       g.setNome("Rafael da Silva");
       g.setSalario(25000);
       g.setUsuario("rafael.silva");
       g.setSenha("123456");
       g.setCodigo(155);
       System.out.println("GERENTE");
       System.out.println("Nome: " + g.getNome());
       System.out.println("Salario: " + g.getSalario());
       System.out.println("Bonificacao: " +
                g.calculaBonificacao());
       System.out.println("Usuario: " + g.getUsuario());
       System.out.println("Senha: " + g.getSenha());
       
       Secretarias s = new Secretarias();
       s.setNome("Joana da Silva");
       s.setSalario(8000);
       System.out.println("SECRETARIA");
       System.out.println("Nome: " + s.getNome());
       System.out.println("Salario: " + s.getSalario());
        System.out.println("Bonificacao: " + 
                s.calculaBonificacao());
        
      Telefonistas t=new Telefonistas();
      t.setRamal(1566);
      t.setCodigo(111);
      
      ponto.registraEntrada(t);
      ponto.registraEntrada(g);
      ponto.registraEntrada(s);
      ponto.registraSaida(t);
      ponto.registraSaida(g);
      ponto.registraSaida(s);
    }
    
}
