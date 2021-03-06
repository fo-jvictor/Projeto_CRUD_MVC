package visao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controle.EmpregadoControle;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class JanelaPrincipal extends JFrame {

	private JPanel contentPane;
	private JTextField idField;
	private JTextField nomeField;
	private JTextField idadeField;
	private JTextField salarioField;
	private JButton buttonConsultar;
	private JButton buttonCadastrar;
	private JButton buttonRemover;
	private JButton buttonAtualizar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaPrincipal frame = new JanelaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JanelaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 477, 193);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Id:");
		lblNewLabel.setBounds(10, 11, 46, 14);
		contentPane.add(lblNewLabel);
		
		idField = new JTextField();
		idField.setBounds(41, 8, 92, 20);
		contentPane.add(idField);
		idField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setBounds(10, 47, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		nomeField = new JTextField();
		nomeField.setBounds(51, 44, 173, 20);
		contentPane.add(nomeField);
		nomeField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Idade:");
		lblNewLabel_2.setBounds(239, 11, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		idadeField = new JTextField();
		idadeField.setBounds(280, 8, 118, 20);
		contentPane.add(idadeField);
		idadeField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Salario:");
		lblNewLabel_3.setBounds(239, 47, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		salarioField = new JTextField();
		salarioField.setBounds(280, 44, 118, 20);
		contentPane.add(salarioField);
		salarioField.setColumns(10);
		
		buttonConsultar = new JButton("Consultar");
		buttonConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//EmpregadoControle empregadoControle = new EmpregadoControle(frame);
			}
		});
		buttonConsultar.setBounds(10, 123, 102, 23);
		contentPane.add(buttonConsultar);
		
		buttonRemover = new JButton("Remover");
		buttonRemover.setBounds(122, 123, 102, 23);
		contentPane.add(buttonRemover);
		
		buttonCadastrar = new JButton("Cadastrar");
		buttonCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonCadastrar.setBounds(236, 123, 101, 23);
		contentPane.add(buttonCadastrar);
		
		buttonAtualizar = new JButton("Atualizar");
		buttonAtualizar.setBounds(348, 123, 103, 23);
		contentPane.add(buttonAtualizar);
	}

	public JTextField getIdField() {
		return idField;
	}

	public void setIdField(JTextField idField) {
		this.idField = idField;
	}

	public JTextField getNomeField() {
		return nomeField;
	}

	public void setNomeField(JTextField nomeField) {
		this.nomeField = nomeField;
	}

	public JTextField getIdadeField() {
		return idadeField;
	}

	public void setIdadeField(JTextField idadeField) {
		this.idadeField = idadeField;
	}

	public JTextField getSalarioField() {
		return salarioField;
	}

	public void setSalarioField(JTextField salarioField) {
		this.salarioField = salarioField;
	}

	public JButton getButtonConsultar() {
		return buttonConsultar;
	}

	public void setButtonConsultar(JButton buttonConsultar) {
		this.buttonConsultar = buttonConsultar;
	}

	public JButton getButtonCadastrar() {
		return buttonCadastrar;
	}

	public void setButtonCadastrar(JButton buttonCadastrar) {
		this.buttonCadastrar = buttonCadastrar;
	}	

	public JButton getButtonRemover() {
		return buttonRemover;
	}

	public void setButtonRemover(JButton buttonRemover) {
		this.buttonRemover = buttonRemover;
	}

	public JButton getButtonAtualizar() {
		return buttonAtualizar;
	}

	public void setButtonAtualizar(JButton buttonAtualizar) {
		this.buttonAtualizar = buttonAtualizar;
	}
	
	
}
