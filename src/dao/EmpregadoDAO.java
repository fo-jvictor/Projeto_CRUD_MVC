package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Empregado;

public class EmpregadoDAO {

	// variavel que vai ser utilizada para realizar operações no banco de dados
	private Connection con;

	// a classe DAO de alguma entidade vai ser a classe que possui
	// os métodos CRUD.
	public EmpregadoDAO() {
	}

	public boolean consultaEmpregado(Empregado e) {
		// metodo de consulta empregado no banco de dados
		ClasseConexaoMySQL.abrirConexaoMySQL();
		// con recebendo o .getCon() da classe de conexao com o banco.
		// o método publico getCon() na classe ConexaoMySQL retorna o atributo con
		// que possui uma conexao com os dados de username, senha e servidor
		con = ClasseConexaoMySQL.getCon();

		int idade = 0;
		String nome = null;
		double salario = 0;

		String sql = "select * from Empregado where id like ?";
		PreparedStatement prepS;
		try {
			prepS = con.prepareStatement(sql);
			prepS.setInt(1, e.getId());
			// resultSet retorna quantas linhas foram afetadas no banco de dados
			ResultSet resultSet = prepS.executeQuery();

			while (resultSet.next()) {

				nome = resultSet.getString(2);
				idade = resultSet.getInt(3);
				salario = resultSet.getDouble(4);

				// implementação minha....
				// com essa implementação os valores de nome,idade só vao ser settados caso
				// result set tenha um "next"
				// e.setNome(resultSet.getString(2));
				// e.setIdade(resultSet.getInt(3));
				// e.setSalario(resultSet.getDouble(4);
			}
			// jeito que o professor implementou, achei estranho pq se o resultSet não tiver
			// next no while
			// ele vai setar os campos do empregado e iguais a nulo. pq é o valor das
			// variaveis caso não entre
			// no loop while
			e.setNome(nome);
			e.setIdade(idade);
			e.setSalario(salario);
			con.close();
			return true;

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return false;
		}

	}

	public boolean cadastraEmpregado(Empregado e) {

		ClasseConexaoMySQL.abrirConexaoMySQL();
		con = ClasseConexaoMySQL.getCon();

		if (con != null) {

			String sql = "insert into Empregado (id,nome,idade,salario) values (?,?,?,?)";
			PreparedStatement prepS;
			try {
				prepS = con.prepareStatement(sql);
				prepS.setInt(1, e.getId());
				prepS.setString(2, e.getNome());
				prepS.setInt(3, e.getIdade());
				prepS.setDouble(4, e.getSalario());

				int result = prepS.executeUpdate();

				if (result == 1) {
					ClasseConexaoMySQL.fecharConexao();
					System.out.println("QUERY FUNCIONOU!!!");
					return true;
				}
				ClasseConexaoMySQL.fecharConexao();
				return false;

			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return false;

	}

	public boolean deletaEmpregado(Empregado e) {

		ClasseConexaoMySQL.abrirConexaoMySQL();
		con = ClasseConexaoMySQL.getCon();

		if (con != null) {
			String sql = "delete from Empregado where id like ?";
			PreparedStatement prepS;

			try {
				prepS = con.prepareStatement(sql);
				prepS.setInt(1, e.getId());
				int result = prepS.executeUpdate();

				if (result > 0) {
					ClasseConexaoMySQL.fecharConexao();
					System.out.println("DELETE FUNCIONOU");
					return true;
				}
				ClasseConexaoMySQL.fecharConexao();
				return false;

			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return false;
	}

	public boolean atualizaEmpregado(Empregado e) {
		ClasseConexaoMySQL.abrirConexaoMySQL();
		con = ClasseConexaoMySQL.getCon();

		if (con != null) {
			String sql = "update Empregado set nome = ?,idade = ?,salario = ? where id = ?";
			PreparedStatement prepS;
			try {				
				prepS = con.prepareStatement(sql);
				prepS.setString(1, e.getNome());
				prepS.setInt(2, e.getIdade());
				prepS.setDouble(3, e.getSalario());
				prepS.setInt(4, e.getId());
				int result = prepS.executeUpdate();
				
				if(result>0)
				{
					ClasseConexaoMySQL.fecharConexao();
					System.out.println("UPDATE FUNCIONOU!");
					return true;
				}
				ClasseConexaoMySQL.fecharConexao();
				return false;
				
			}catch(SQLException e1)
			{
				e1.printStackTrace();
			}

		}
		return false;
	}
}
