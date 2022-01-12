package Controle;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import Visao.Principal.MenuContatosGeral;

public class ControleFechaContatosGeral implements WindowListener {

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	// Ação dada para que ?
	// Quando o botão fechar for clicado ela abra novamente a TELA PRINCIPAL !
	// (MENU PRINCIPAL)
	@Override
	public void windowClosed(WindowEvent arg0) {
		new MenuContatosGeral().setVisible(true);

	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

}
