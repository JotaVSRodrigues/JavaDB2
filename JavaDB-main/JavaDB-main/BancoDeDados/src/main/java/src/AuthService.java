package src;

import java.sql.*;
import org.mindrot.jbcrypt.BCrypt;

public class AuthService {
    public boolean registerUser(String nome, String email, String senha){
        // cria uma variável que armazena a query que será utilizada na criação de um
        // objeto na tabela users
        String query = "INSERT INTO users (nome, email, senha) VALUES (?,?,?)";
        String senhaHash = BCrypt.hashpw(senha, BCrypt.gensalt());
        
        // Connection -> classe que cria um objeto conector ao banco de dados
        // PreparedStatement -> executar as consultas no banco
        try (Connection conexao = DBconnection.getConnection();
            PreparedStatement objeto = conexao.prepareStatement(query)) {
            
            objeto.setString(1, nome);
            objeto.setString(2, email);
            objeto.setString(3, senhaHash);
            
            /* executando o cadastro do usuário e retornando sucesso ou falha*/
            
            objeto.executeUpdate();
            return true;

        } catch (SQLException ex) {
           ex.printStackTrace();
           return false;
        }
    }
    
    public boolean loginUser(String email, String senha) throws SQLException{
        String query = "SELECT * FROM users WHERE email = ?";
        
        try (Connection conexao = DBconnection.getConnection();
             PreparedStatement login = conexao.prepareStatement(query)){
            
            login.setString(1, email);
           
            // ResultSet -> Lib que permite realizar consultas no banco
            // Nesse trecho, criamos um objeto para consultar o banco de busca do email solicitado e executamos a busca
            ResultSet consulta = login.executeQuery();
            
            if (consulta.next()) {
                String senhaArm = consulta.getString("senha");
                
                if (BCrypt.checkpw(senha, senhaArm)) {
                    return true;
                }
            } return false;
        } catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    
    // Passo 1 -> verificar se o usuário existe a partir do email
    public boolean verificarEmail(String email){
        String query = "SELECT * FROM users WHERE email = ?";
        
        return true;
    }
}

