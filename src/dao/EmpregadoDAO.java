package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Empregado;

public class EmpregadoDAO {

	private Connection con;
	
	public EmpregadoDAO() {
	}

	public boolean consultaEmpregado(Empregado empregado) {
		ClasseConexaoMySQL.abrirConexaoMySQL();
		con = ClasseConexaoMySQL.getCon();

		int idade = 0;
		String nome = null;
		double salario = 0;

		String sql = "select * from Empregado where id like ?";
		PreparedStatement prepS;
		try {
			prepS = con.prepareStatement(sql);
			prepS.setInt(1, empregado.getId());
			ResultSet resultSet = prepS.executeQuery();

			while (resultSet.next()) {

				nome = resultSet.getString(2);
				idade = resultSet.getInt(3);
				salario = resultSet.getDouble(4);
				
			}
			empregado.setNome(nome);
			empregado.setIdade(idade);
			empregado.setSalario(salario);
			con.close();
			return true;

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return false;
		}

	}

	public boolean cadastraEmpregado(Empregado empregado) {

		ClasseConexaoMySQL.abrirConexaoMySQL();
		con = ClasseConexaoMySQL.getCon();

		if (con != null) {

			String sql = "insert into Empregado (id,nome,idade,salario) values (?,?,?,?)";
			PreparedStatement prepS;
			try {
				prepS = con.prepareStatement(sql);
				prepS.setInt(1, empregado.getId());
				prepS.setString(2, empregado.getNome());
				prepS.setInt(3, empregado.getIdade());
				prepS.setDouble(4, empregado.getSalario());

				int result = prepS.executeUpdate();

				if (result == 1) {
					ClasseConexaoMySQL.fecharConexao();
					System.out.println("Empregado cadastrado com sucesso!");
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

	public boolean deletaEmpregado(Empregado empregado) {

		ClasseConexaoMySQL.abrirConexaoMySQL();
		con = ClasseConexaoMySQL.getCon();

		if (con != null) {
			String sql = "delete from Empregado where id like ?";
			PreparedStatement prepS;

			try {
				prepS = con.prepareStatement(sql);
				prepS.setInt(1, empregado.getId());
				int result = prepS.executeUpdate();

				if (result > 0) {
					ClasseConexaoMySQL.fecharConexao();
					System.out.println("Empregado deletado com sucesso!");
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

	public boolean atualizaEmpregado(Empregado empregado) {
		ClasseConexaoMySQL.abrirConexaoMySQL();
		con = ClasseConexaoMySQL.getCon();

		if (con != null) {
			String sql = "update Empregado set nome = ?,idade = ?,salario = ? where id = ?";
			PreparedStatement prepS;
			try {				
				prepS = con.prepareStatement(sql);
				prepS.setString(1, empregado.getNome());
				prepS.setInt(2, empregado.getIdade());
				prepS.setDouble(3, empregado.getSalario());
				prepS.setInt(4, empregado.getId());
				int result = prepS.executeUpdate();
				
				if(result>0)
				{
					ClasseConexaoMySQL.fecharConexao();
					System.out.println("Empregado atualizado com sucesso!");
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
