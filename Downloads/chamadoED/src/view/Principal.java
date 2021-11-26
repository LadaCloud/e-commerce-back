package view;

import javax.swing.JOptionPane;

import com.maria.utils.fila.integer.Fila;

import controller.FilaController;

public class Principal {

	public static void main(String[] args) {
		Fila fila = new Fila();
		Fila filaPrioritaria = new Fila();
		
		FilaController filaController = new FilaController();

		String[] actionButtons = { "Adicionar senha priorit�ria", "Adicionar senha n�o priorit�ria", "Chamar para o atendimento", "Cancelar" };
		
		int senha = 0;
		int senhaPrioritaria = 0;

		int opcao = 0;

		do {
			opcao = JOptionPane.showOptionDialog(null, "Qual ser� a a��o?", "Confirmation",
					JOptionPane.INFORMATION_MESSAGE, 0, null, actionButtons, actionButtons[0]);

			switch (opcao) {
			case 0:
				filaController.insereSenha(filaPrioritaria, ++senhaPrioritaria);
				break;
			case 1:
				filaController.insereSenha(fila, ++senha);
				break;
			case 2:
				try {
					filaController.chamarParaConsultas(fila, filaPrioritaria);
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			}

		} while (opcao != 3);

	}

}
