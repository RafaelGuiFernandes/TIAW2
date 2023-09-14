package app;

import java.util.List;
import java.util.Scanner;

import dao.UserDAO;
import model.User;

public class Principal {
	public static Scanner sc = new Scanner(System.in);
	
	public static User readNewUser() {
		int id = -1;
		String nome = "";
		char sexo = '*';
		int idade = -1;
		System.out.println("Id: ");
		id = sc.nextInt();
		System.out.println("Nome: ");
		nome = sc.next();
		System.out.println("Sexo (M / F): ");
		sexo = sc.next().charAt(0);
		System.out.println("Idade: ");
		idade = sc.nextInt();
		
		return (new User( id , nome , sexo , idade ));
	}
	
	public static void main( String[] args ) throws Exception {
		// define data
		int option = 0;
		
		UserDAO userDAO = new UserDAO();
		
		
		// menu
		do {			
			System.out.println("=--------- Exercicio 02 ------------=");
			System.out.println("|		   1 - Listar   			|");
			System.out.println("|		   2 - Inserir   			|");
			System.out.println("|		   3 - Excluir   			|");
			System.out.println("|		   4 - Atualizar 			|");
			System.out.println("|		   5 - Sair     			|");
			System.out.println("=-----------------------------------=");
			System.out.println("Opcao: ");

			option = sc.nextInt();
			
			switch( option ) {
				case 1:
					// listar
					List<User> users = userDAO.get();
					for (User u: users) {
						System.out.println(u.toString());
					}
					break;
				case 2:
					// inserir
					if(userDAO.insert(readNewUser()) == true) {
						System.out.println("Inserção com sucesso");
					}
					break;
				case 3:
					// excluir
					System.out.println("Excluir usuario ( id ): ");
					if(userDAO.delete( sc.nextInt() ) == true ) {
						System.out.println("User excluido com sucesso");
					}
					break;
				case 4:
					// atualizar
					System.out.println("Atualizar usuario ( id ): ");
					if(userDAO.update(readNewUser()) == true) {
						System.out.println("User atualizado com sucesso");
					}
					break;
				default:
					// parar
					userDAO.close();
					break;
			}
		} while( option != 5 );
		
		
	}
}
