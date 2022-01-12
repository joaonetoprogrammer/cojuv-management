package Controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Modelo.Administrador;
import Visao.Principal.TelaDeAlteracao;
import Visao.Principal.TelaLogin;

public class ControleLogin implements ActionListener {

	Administrador ad = new Administrador();

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == TelaLogin.entrar) {
			ad.Metodo_Botao_Entrar();
		}

		else if (e.getSource() == TelaLogin.sair) {
			ad.BotaoSairTelaLogin();
		} else if (e.getSource() == TelaDeAlteracao.ok) {
			ad.AcaoDoBotaoOk();
		}

		else if (e.getSource() == TelaDeAlteracao.alterar) {
			ad.AcaoDoBotaoAalterar();
		}
		else if (e.getSource() == TelaLogin.alterar) {
			new TelaDeAlteracao().setVisible(true);
		}
	}

}
