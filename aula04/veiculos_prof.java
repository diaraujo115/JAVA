
package carro2;

    import java.util.Scanner;
import javax.swing.JOptionPane;


public class Carro2 {

    public static void main(String[] args) {
        int ano, contaGeral=0, conta2000=0;
        float valor, valorDesconto=0;
        String decisao;
        boolean continuar = true;
      while (continuar == true){
        Scanner leia = new Scanner(System.in);
        
        System.out.print("Digite o valor do veiculo: ");
        valor = leia.nextFloat();
        System.out.print("Digite o ano do veiculo: ");
        ano = leia.nextInt();
        
        valorDesconto = valorDesc(ano, valor);
        
        System.out.println("Desconto: " + valorDesconto);
        System.out.println("Valor do Veiculo: " + (valor-valorDesconto));
        
        decisao = JOptionPane.showInputDialog("Deseja fazer outro calculo? S ou N");
        if (decisao.equals("S") || (decisao.equals("s"))){
            System.out.println("Novo Calculo");
        }else{
            System.out.println("Você saiu");
            continuar = false;
        }
        
      }
        
    }
    public static float valorDesc(int anoCarro, float valorCarro){
        if (anoCarro <=2000){
           return(valorCarro*12)/100;
        }
        else {
           return(valorCarro*7)/100;
        }
    }
    
}
