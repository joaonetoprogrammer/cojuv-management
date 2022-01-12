package Controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Modelo.Administrador;
import Visao.Principal.MenuContatosGeral;
import Visao.Principal.MenuEmpresa;
import Visao.Principal.MenuGrupos;
import Visao.Principal.MenuProjeto;
import Visao.Principal.MenuServidorPublico;
import Visao.Principal.MenuServidorTerceirizado;

public class ControleMenus implements ActionListener {

	Administrador ad = new Administrador();

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == MenuEmpresa.cadastrar) {
			ad.BotaoCadastrarTelaMenuEmpresa();

		}

		else if (e.getSource() == MenuEmpresa.consultar) {
			ad.BotaoConsultarTelaMenuEmpresa();
		}

		else if (e.getSource() == MenuEmpresa.alterar) {
			ad.BotaoAtualizarTelaMenuEmpresa();
		}

		else if (e.getSource() == MenuEmpresa.deletar) {
			ad.BotaoDeletarTelaMenuEmpresa();
		} else if (e.getSource() == MenuEmpresa.sair) {
			ad.BotaoSairTelaMenuEmpresa();
		}

		// SERVIDOR PUBLICO
		else if (e.getSource() == MenuServidorPublico.cadastrar) {
			ad.BotaoCadastrarTelaMenuServidorPublico();

		}

		else if (e.getSource() == MenuServidorPublico.consultar) {
			ad.BotaoConsultarTelaMenuServidorPublico();
		}

		else if (e.getSource() == MenuServidorPublico.alterar) {
			ad.BotaoAtualizarTelaMenuServidorPublico();
		}

		else if (e.getSource() == MenuServidorPublico.deletar) {
			ad.BotaoDeletarTelaMenuServidorPublico();
		} else if (e.getSource() == MenuServidorPublico.sair) {
			ad.BotaoSairTelaMenuServidorPublico();
		}

		// SERVIDOR TERCEIRIZADO
		else if (e.getSource() == MenuServidorTerceirizado.cadastrar) {
			ad.BotaoCadastrarTelaMenuServidorTerceirizado();

		}

		else if (e.getSource() == MenuServidorTerceirizado.consultar) {
			ad.BotaoConsultarTelaMenuServidorTerceirizado();
		}

		else if (e.getSource() == MenuServidorTerceirizado.alterar) {
			ad.BotaoAtualizarTelaMenuServidorTerceirizado();
		}

		else if (e.getSource() == MenuServidorTerceirizado.deletar) {
			ad.BotaoDeletarTelaMenuServidorTerceirizado();
		} else if (e.getSource() == MenuServidorTerceirizado.sair) {
			ad.BotaoSairTelaMenuServidorTerceirizado();
		}

		// PROJETO
		else if (e.getSource() == MenuProjeto.cadastrar) {
			ad.BotaoCadastrarTelaMenuProjeto();

		}

		else if (e.getSource() == MenuProjeto.consultar) {
			ad.BotaoConsultarTelaMenuProjeto();
		}

		else if (e.getSource() == MenuProjeto.alterar) {
			ad.BotaoAtualizarTelaMenuProjeto();
		}

		else if (e.getSource() == MenuProjeto.deletar) {
			ad.BotaoDeletarTelaMenuProjeto();
		} else if (e.getSource() == MenuProjeto.sair) {
			ad.BotaoSairTelaMenuProjeto();
		}

		// GRUPOS
		else if (e.getSource() == MenuGrupos.cadastrar) {
			ad.BotaoCadastrarTelaMenuGrupos();

		}

		else if (e.getSource() == MenuGrupos.consultar) {
			ad.BotaoConsultarTelaMenuGrupos();
		}

		else if (e.getSource() == MenuGrupos.alterar) {
			ad.BotaoAtualizarTelaMenuGrupos();
		}

		else if (e.getSource() == MenuGrupos.deletar) {
			ad.BotaoDeletarTelaMenuGrupos();
		} else if (e.getSource() == MenuGrupos.sair) {
			ad.BotaoSairTelaMenuGrupos();
		}

		// CONTATOS GERAL
		else if (e.getSource() == MenuContatosGeral.cadastrar) {
			ad.BotaoCadastrarTelaMenuContatoGeral();

		}

		else if (e.getSource() == MenuContatosGeral.consultar) {
			ad.BotaoConsultarTelaMenuContatoGeral();
		}

		else if (e.getSource() == MenuContatosGeral.alterar) {
			ad.BotaoAtualizarTelaMenuContatosGeral();
		}

		else if (e.getSource() == MenuContatosGeral.deletar) {
			ad.BotaoDeletarTelaMenuContatoGeral();
		} else if (e.getSource() == MenuContatosGeral.sair) {
			ad.BotaoSairTelaMenuContatoGeral();
		}

	}

}
