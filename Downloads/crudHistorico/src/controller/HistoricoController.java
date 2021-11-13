package controller;

import javax.swing.JOptionPane;

import com.felix.utils.pilha.string.Pilha;

public class HistoricoController {

	public HistoricoController() {
		
	}
	
	public void insereHistorico(Pilha pilha, String url) {
		if (validaUrl(url)) {
			pilha.push(url);
			JOptionPane.showMessageDialog(null, "Site " + url + " inserido");
		} else {
			JOptionPane.showMessageDialog(null, "Site " + url + " inválido. A url deve seguir o exemplo: https://www.example.com");
		}
		
	}
	
	public void consultaHistorico(Pilha pilha) {
		try {
			JOptionPane.showMessageDialog(null, pilha.top());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Histórico vazio");
		}
		
	}
	
	public void removeHistorico(Pilha pilha) {
		try {
			String item = pilha.pop();
			JOptionPane.showMessageDialog(null, "Site " + item + " removido");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Histórico vazio");
		}
	}
	
	public static boolean validaUrl(String url) {
		String[] vetSite = url.split("\\.");
		
		if (vetSite[0].equals("http://www") && vetSite.length >= 3) {
			return true;
		}
		
		return false;
	}

}
