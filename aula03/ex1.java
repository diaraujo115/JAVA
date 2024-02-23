package aula03;

import java.util.Scanner;

public class ex1 {

	 public static void main(String[] args) {
	       Scanner ler= new Scanner(System.in);
	       
 double peso, altura, imc;
	       
	       System.out.printf("Informe o seu peso e altura:\n");
	       peso = ler.nextDouble();
	       altura = ler.nextDouble();
	       
	       imc=peso /(altura*altura);
           System.out.printf("valor do imc:\n"+imc);
 
	      
	       
	       if (imc<20) {
	           System.out.printf("Magro\n");
	       
	       }else if(imc >=20 && imc <24) {
	           System.out.printf("Normal\n");
	           
	       }else if(imc >=24 && imc <29) {
	           System.out.printf("Acima do peso\\n");
	           
	       }else if(imc >=29 && imc <34) {
	           System.out.printf("Obeso\\n");
	       
	       }else if(imc >=34) {
	           System.out.printf("Muito obeso\\n");
	           
	           

	       } 
	       
	       

	    }
	    
	}