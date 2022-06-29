package controle;

import visao.JanelaPrincipal;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JanelaPrincipal janela = new JanelaPrincipal();
		janela.setVisible(true);
		EmpregadoControle empregadoControle = new EmpregadoControle(janela);
	}

}
