package controller;

import javax.swing.JOptionPane;

import com.maria.utils.fila.string.Fila;

public class TelefoneController {

	public TelefoneController() {
		super();
	}

	public void insereLigacao(Fila f, String numeroTelefone) {
		f.insert(numeroTelefone);
	}

	public void consultaLigacoes(Fila f) {
		if (f.isEmpty()) {
			JOptionPane.showMessageDialog(null, "N�o h� chamadas perdidas");
		} else {
			try {
				String chamada = f.remove();
				JOptionPane.showMessageDialog(null, chamada);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "N�o h� chamadas perdidas");
			}
		}
	}

}
