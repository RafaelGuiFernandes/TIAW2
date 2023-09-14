package model;

public class User {
	private int id;
	private String nome;
	private char sexo;
	private int idade;
	
	public User() {
		this.id = -1;
		this.nome = "";
		this.sexo = '*';
		this.idade = -1;
	}
	
	public User( int id , String nome , char sexo, int idade ) {
		this.id = id;
		this.nome = nome;
		this.sexo = sexo;
		this.idade = idade;
	}
	
	public int getId() {
		return this.id;
	}
	public void setId( int id ) {
		this.id = id;
	}
	public String getNome() {
		return this.nome;
	}
	public void setNome( String nome ) {
		this.nome = nome;
	}
	public char getSexo () {
		return this.sexo;
	}
	public void setSexo( char sexo ) {
		this.sexo = sexo;
	}
	public int getIdade() {
		return this.idade;
	}
	public void setIdade( int idade ) {
		this.idade = idade;
	}
	
	@Override
	public String toString() {
		return "Usuario [id=" + this.id + ", nome=" + this.nome + ", sexo=" + this.sexo + ", idade=" + this.idade + "]";
	}	
}
