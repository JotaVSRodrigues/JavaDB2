package src;

import java.util.*;

public class UserInterface {

    private static AuthService autenticacao = new AuthService();
    
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        
        System.out.println("Registro de Usuário");
        System.out.println("Nome: ");
        String nome = scanner.nextLine();
        
        System.out.println("Email: ");
        String email = scanner.nextLine();
        
        System.out.println("Senha: ");
        String senha = scanner.nextLine();
        
        boolean sucesso = autenticacao.registerUser(nome, email, senha);
        
        if(!sucesso){
            System.out.println("Erro no registro");
        } else {
            System.out.println("Registro realizado com sucesso");
        }
        
        scanner.close();
    }
}
