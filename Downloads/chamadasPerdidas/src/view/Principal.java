package view;

import javax.swing.JOptionPane;

import com.maria.utils.fila.string.Fila;

import controller.TelefoneController;

public class Principal {

	public static void main(String[] args) {
		Fila f = new Fila();
		TelefoneController telefone = new TelefoneController();
		
		String[] actionButtons = { "Adicionar chamada", "Consultar chamadas perdidas", "Cancelar" };
		
		int opcao = 0;

		do {
			opcao = JOptionPane.showOptionDialog(null, "Qual ser� a a��o?", "Confirmation",
					JOptionPane.INFORMATION_MESSAGE, 0, null, actionButtons, actionButtons[0]);
			
			switch (opcao) {
				case 0:
					String chamada = JOptionPane.showInputDialog(null, "Insira um n�mero de telefone");
					telefone.insereLigacao(f, chamada);
					break;
				case 1:
					telefone.consultaLigacoes(f);
					break;
			}

		} while (opcao != 2);
		
	}

}
