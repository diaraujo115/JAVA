package veiculos;



import java.util.Scanner;
public class Veiculos {

    
    public static void main(String[] args) {
        
        Scanner ler= new Scanner(System.in);
        int totalCarros,totalCarros2001=0, totalCarros2000=0;
        
        
       do{
           System.out.println("Digite o ano do veículo:");
        int anoCliente=ler.nextInt();
       
         System.out.println("Digite o valor do veículo:");
        double valorCarro=ler.nextDouble();
       
        double  descontoCarro=0, valorTotal=0;
        int anoCarro=2000;
        
        
        if (anoCliente<=anoCarro){
            descontoCarro=0.12;
            totalCarros2000++;
          
        }else if (anoCliente>anoCarro)
                descontoCarro=0.07;
                totalCarros2001++;
             
        valorTotal= valorCarro - (valorCarro*descontoCarro);
        totalCarros=totalCarros2001 + totalCarros2000;
        
        System.out.println("O valor do desconto é de: R$ " + (valorCarro*descontoCarro));

        System.out.println("O valor total do véiculo é de: R$ " + valorTotal);
        
        
       System.out.println("Deseja continuar com a checagem? (S/N)");
       String continuar = ler.next();
       
       if (!continuar.equalsIgnoreCase("S")) {
                break;
            }

       }while (true);
    
                
        System.out.println("Total de carros até o ano 2000: " + totalCarros2000);
        
        System.out.println("Total de carros geral: " + totalCarros);       


        
        }
            

    }
    
