package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import dao.EmpregadoDAO;
import model.Empregado;
import visao.JanelaPrincipal;

public class EmpregadoControle implements ActionListener {
	
	private JanelaPrincipal janela;
	private EmpregadoDAO empregadoDAO;
	
	public EmpregadoControle(JanelaPrincipal janela)
	{
		this.janela=janela;
		this.janela.getButtonConsultar().addActionListener(this);
		this.janela.getButtonCadastrar().addActionListener(this);
		this.janela.getButtonRemover().addActionListener(this);
		this.janela.getButtonAtualizar().addActionListener(this);
		empregadoDAO = new EmpregadoDAO();
	}
	
	public void consultaEmpregado()
	{
		int id = Integer.parseInt(janela.getIdField().getText());
		Empregado empregado = new Empregado(id,null,0,0);
		empregadoDAO.consultaEmpregado(empregado);		
		
		janela.getNomeField().setText(empregado.getNome());		
		janela.getIdadeField().setText(String.valueOf(empregado.getIdade()));
		janela.getSalarioField().setText(String.valueOf(empregado.getSalario()));		
	}
	
	public void removeEmpregado()
	{
		int id = Integer.parseInt(janela.getIdField().getText());
		Empregado empregado = new Empregado(id,null,0,0);
		empregadoDAO.deletaEmpregado(empregado);
		limpaTela();
		JOptionPane.showMessageDialog(janela,"Usuario removido com sucesso!","Remocao",1,null);
	}
	
	public void cadastraEmpregado()
	{
		int id = Integer.parseInt(janela.getIdField().getText());
		String nome = janela.getNomeField().getText();
		int idade = Integer.parseInt(janela.getIdadeField().getText());
		double salario = Double.parseDouble(janela.getSalarioField().getText());
		Empregado empregado = new Empregado(id,nome,idade,salario);		
		empregadoDAO.cadastraEmpregado(empregado);
		limpaTela();
		JOptionPane.showMessageDialog(janela,"Usuario cadastrado com sucesso!","Cadastro",1,null);
	}
	
	public void atualizaEmpregado()
	{
		//CONSULTA PRIMEIRO E DEPOIS ATUALIZA
		int id = Integer.parseInt(janela.getIdField().getText());
		String nome = janela.getNomeField().getText();
		int idade = Integer.parseInt(janela.getIdadeField().getText());
		double salario = Double.parseDouble(janela.getSalarioField().getText());
		Empregado empregado = new Empregado(id,nome,idade,salario);
		empregadoDAO.atualizaEmpregado(empregado);
		limpaTela();
		JOptionPane.showMessageDialog(janela,"Usuario atualizado com sucesso","Atualizacao",1,null);
	}
	
	public void limpaTela()
	{
		this.janela.getIdField().setText("");
		this.janela.getNomeField().setText("");
		this.janela.getIdadeField().setText("");
		this.janela.getSalarioField().setText("");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("Consultar"))
		{
			consultaEmpregado();
		}
		
		if(e.getActionCommand().equals("Cadastrar"))
		{
			cadastraEmpregado();
		}
		
		if(e.getActionCommand().equals("Remover"))
		{
			removeEmpregado();
		}
		
		if(e.getActionCommand().equals("Atualizar"))
		{
			atualizaEmpregado();
		}
	}

}
