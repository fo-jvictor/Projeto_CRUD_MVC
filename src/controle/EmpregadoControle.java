package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		this.janela.getButtonDelete().addActionListener(this);
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
	}
	
	public void cadastraEmpregado()
	{
		int id = Integer.parseInt(janela.getIdField().getText());
		String nome = janela.getNomeField().getText();
		int idade = Integer.parseInt(janela.getIdadeField().getText());
		double salario = Double.parseDouble(janela.getSalarioField().getText());
		Empregado empregado = new Empregado(id,nome,idade,salario);		
		empregadoDAO.cadastraEmpregado(empregado);		
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
		
		if(e.getActionCommand().equals("Delete"))
		{
			removeEmpregado();
		}
		
		if(e.getActionCommand().equals("Atualizar"))
		{
			atualizaEmpregado();
		}
	}

}
