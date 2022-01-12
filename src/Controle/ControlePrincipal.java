package Controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Modelo.Administrador;
import Modelo.Lembrete;
import Modelo.ServidorPublico;
import Visao.Principal.Calendario;
import Visao.Principal.MalaDireta;
import Visao.Principal.MenuGrupos;
import Visao.Principal.MenuPrincipal;
import Visao.Principal.MenuServidorPublico;
import Visao.Principal.TelaDeLembrete;
import Visao.Principal.VisualizarLista;

public class ControlePrincipal implements ActionListener, KeyListener {

	Administrador ad = new Administrador();
	ServidorPublico ad2 = new ServidorPublico();
	Lembrete l = new Lembrete();

	public void keyPressed(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == MenuPrincipal.sair) {
			ad.BotaoSairTelaMenuPrincipal();
		}

		else if (e.getSource() == MenuPrincipal.ServidorPublico) {
			new MenuServidorPublico().setVisible(true);
			MenuPrincipal.Tela.dispose();
		}

		else if (e.getSource() == MenuPrincipal.ServidorTerceirizado) {
			ad.BotaoServidorTerceirizadoTelaMenuPrincipal();
		}

		else if (e.getSource() == MenuPrincipal.Empresas) {
			ad.BotaoEmpresaTelaMenuPrincipal();
		}

		else if (e.getSource() == MenuPrincipal.Projetos) {
			ad.BotaoProjetoTelaMenuPrincipal();
		}
		else if (e.getSource() == MenuPrincipal.contatosGeral) {
			ad.BotaoContatosGeralTelaMenuPrincipal();
		}

		else if (e.getSource() == TelaDeLembrete.b) {
			l.AcaoFechar();
		}

		else if (e.getSource() == MenuPrincipal.MalaDireta) {
			new MalaDireta().setVisible(true);
			MenuPrincipal.Tela.dispose();
		}

		else if (e.getSource() == MenuPrincipal.Lembretes) {
			ad.BotaoLembreteTelaMenuPrincipal();
		} else if (e.getSource() == MenuPrincipal.calendar) {
			new Calendario().setVisible(true);
		} else if (e.getSource() == MenuPrincipal.grupos) {
			new MenuGrupos().setVisible(true);
			MenuPrincipal.Tela.dispose();
		}else if (e.getSource() == MenuPrincipal.ver) {
			new VisualizarLista().setVisible(true);
		}

	}

}
