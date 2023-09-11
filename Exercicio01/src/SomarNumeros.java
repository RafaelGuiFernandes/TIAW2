import java.util.*;

class SomarDoisNumeros {
	public static Scanner sc = new Scanner(System.in);
	public static void main(String args[]){
		// define data
		int num1 , num2 , soma;
		
		// read
		System.out.println("Digite um numero");
		num1 = sc.nextInt();
		System.out.println("Digite outro numero");
		num2 = sc.nextInt();
		
		// sum
		soma = num1 + num2;
		
		// show result
		System.out.println("Soma: "+ soma);
	}
}
