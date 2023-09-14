package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.User;

public class UserDAO extends DAO {

	public UserDAO() {
		super();
		conectar();
	}
	
	public void finalize() {
		close();
	}
	
	// listar
	public List<User> get() {
		
		List<User> users = new ArrayList<User>();
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM exercicio02";
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);	           
	        while(rs.next()) {	            	
	        	User u = new User(rs.getInt("id"), rs.getString("nome"), rs.getString("sexo").charAt(0) , rs.getInt("idade") );
	        	users.add(u);
	        }
	        st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return users;
	}
	
	// Inserir
	public boolean insert(User user) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			String sql = "INSERT INTO exercicio02 (id, nome, sexo, idade) "
				       + "VALUES ("+user.getId()+ ", '" + user.getNome() + "', '"  
				       + user.getSexo() + "', " + user.getIdade() + ");";
			System.out.println(sql);
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	// excluir
	public boolean delete(int id) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			String sql = "DELETE FROM exercicio02 WHERE id = " + id;
			System.out.println(sql);
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	// atualizar
	public boolean update(User user) {
		boolean status = false;
		try {
			Statement st = conexao.createStatement();
			String sql = "UPDATE exercicio02 SET nome = '" + user.getNome() + "', sexo = '"  
				       + user.getSexo() + "', idade = '" + user.getIdade() + "'"
					   + " WHERE id = " + user.getId();
			System.out.println(sql);
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}


}
