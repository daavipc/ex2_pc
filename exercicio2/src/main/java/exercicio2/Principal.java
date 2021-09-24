package exercicio2;
import java.io.*;

public class Principal {
	
	public static void main(String[] args) throws IOException {
		
		DAO dao = new DAO();
		dao.conectar();
		
		Usuario usuario = new Usuario();
		
		int choice = 0;
		
		do{
			int code = -1;
			System.out.println("\n====== Data Base CRUD ======");
System.out.println(" 1) List \n 2) Insert \n 3) Delete \n 4) Update \n 5) Exit");
choice = MyIO.readInt();

if(choice != 5) {
	switch (choice){
	
	case 1: 
		Usuario[] usuarios = dao.getUsuarios();
	
System.out.println("\n====== Users List ======");		
	for(int i = 0; i < usuarios.length; i++) {
		System.out.println(usuarios[i].toString());
	}
	break;
		
case 2:
String name;
String password;
char gen;
	
System.out.println("\n====== Insert a User ======");
System.out.print("Code: ");
code = MyIO.readInt();
	
System.out.print("Name: ");
name = MyIO.readLine();
	
System.out.print("Password: ");
password = MyIO.readLine();

System.out.print("Genre (M or F): ");
gen = MyIO.readChar();

usuario = new Usuario(code, name, password, gen);
if(dao.inserirUsuario(usuario) == true) {
	System.out.println("Inserção com sucesso -> " + usuario.toString());
	}
	break;
		
case 3: //Excluir usuário
System.out.println("\n====== Delete a User ======");
System.out.print("\nCode: ");
	code = MyIO.readInt();
	
	dao.excluirUsuario(code);
	break;
		
case 4: //Atualizar usuário
String newPassword;

System.out.println("\n====== Update a User ======");			
System.out.print("New password: ");
			newPassword = MyIO.readLine();
			
			usuario.setSenha(newPassword);
			dao.atualizarUsuario(usuario);
			break;
		}
	}
} while(choice != 5);

System.out.print("\n====== End of Code ======");
		dao.close();
	}
}