package model;

public class Empregado {

	private int id;
	private String nome;
	private int idade;
	private double salario;
	
	public Empregado()
	{	
	}
	
	public Empregado(int id,String nome, int idade, double salario) {
		super();
		this.id=id;
		this.nome = nome;
		this.idade = idade;
		this.salario = salario;		
	}
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	
	
	
}
