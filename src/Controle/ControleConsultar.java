package Controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Modelo.ContatosGeral;
import Modelo.Empresa;
import Modelo.Grupos;
import Modelo.Lembrete;
import Modelo.MalaDireta2;
import Modelo.Projeto;
import Modelo.ServidorPublico;
import Modelo.ServidorTerceirizado;
import Visao.Consultar.ConsultarContatosGeral;
import Visao.Consultar.ConsultarEmpresa;
import Visao.Consultar.ConsultarGrupos;
import Visao.Consultar.ConsultarProjeto;
import Visao.Consultar.ConsultarServidorPublico;
import Visao.Consultar.ConsultarServidorTerceirizado;
import Visao.Principal.MalaDireta;
import Visao.Principal.MenuPrincipal;
import Visao.Principal.VisualizarLista;

public class ControleConsultar implements ActionListener {

	ServidorPublico sp = new ServidorPublico();
	ServidorTerceirizado st = new ServidorTerceirizado();
	Empresa emp = new Empresa();
	Projeto pro = new Projeto();
	MalaDireta2 m = new MalaDireta2();
	Grupos g = new Grupos();
	ContatosGeral cg = new ContatosGeral();
	Lembrete l = new Lembrete();

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == ConsultarServidorPublico.ok) {
			sp.AtualizaTableNome();
		} else if (e.getSource() == ConsultarServidorPublico.ok2) {
			sp.AtualizaTableLotacao();
		} else if (e.getSource() == ConsultarServidorPublico.porCodigo) {
			sp.AtualizaTable();
		} else if (e.getSource() == ConsultarServidorPublico.porOrdem) {
			sp.AtualizaTableOrdem();
		} else if (e.getSource() == ConsultarServidorPublico.voltar) {
			sp.BotaoVoltarConsultarServidorPublico();
		} else

		if (e.getSource() == ConsultarServidorTerceirizado.ok) {
			st.AtualizaTableNome();
		} else if (e.getSource() == ConsultarServidorTerceirizado.ok2) {
			st.AtualizaTableLotacao();
		} else if (e.getSource() == ConsultarServidorTerceirizado.porCodigo) {
			st.AtualizaTable();
		} else if (e.getSource() == ConsultarServidorTerceirizado.porOrdem) {
			st.AtualizaTableOrdem();
		} else if (e.getSource() == ConsultarServidorTerceirizado.voltar) {
			st.BotaoVoltarConsultarServidorTerceirizado();
		} else

		if (e.getSource() == ConsultarEmpresa.ok) {
			emp.AtualizaTableNome();
		} else if (e.getSource() == ConsultarEmpresa.porcodigo) {
			emp.AtualizaTable();
		} else if (e.getSource() == ConsultarEmpresa.ordemAlfabetica) {
			emp.AtualizaTableOrdem();
		} else if (e.getSource() == ConsultarEmpresa.voltar) {
			emp.BotaoVoltarConsultarEmpresa();
		} else

		if (e.getSource() == ConsultarProjeto.ok) {
			pro.AtualizaTableNome();
		} else if (e.getSource() == ConsultarProjeto.ok2) {
			pro.AtualizaTableOrientador();
		} else if (e.getSource() == ConsultarProjeto.porCodigo) {
			pro.AtualizaTable();
		} else if (e.getSource() == ConsultarProjeto.porOrdem) {
			pro.AtualizaTableOrdem();
		} else if (e.getSource() == ConsultarProjeto.voltar) {
			pro.BotaoVoltarConsultarProjeto();
		}

		else

		if (e.getSource() == ConsultarGrupos.ok) {
			g.AtualizaTableGrupo();
		} else if (e.getSource() == ConsultarGrupos.ok2) {
			g.AtualizaTableIdentidade();
		} else if (e.getSource() == ConsultarGrupos.porCodigo) {
			g.AtualizaTable();
		} else if (e.getSource() == ConsultarGrupos.porOrdem) {
			g.AtualizaTableOrdem();
		} else if (e.getSource() == ConsultarGrupos.voltar) {
			g.BotaoVoltarConsultarGrupos();
		}

		else

		if (e.getSource() == ConsultarContatosGeral.ok) {
			cg.AtualizaTableNome();
		} else if (e.getSource() == ConsultarContatosGeral.ok2) {
			cg.AtualizaTableLotacao();
		} else if (e.getSource() == ConsultarContatosGeral.porCodigo) {
			cg.AtualizaTable();
		} else if (e.getSource() == ConsultarContatosGeral.porOrdem) {
			cg.AtualizaTableOrdem();
		} else if (e.getSource() == ConsultarContatosGeral.voltar) {
			cg.BotaoVoltarConsultarContatosGeral();
		}

		else if (e.getSource() == MalaDireta.ok) {
			m.AtualizaTableLotacao2();
			m.AtualizaTableLotacao();

		} else if (e.getSource() == MalaDireta.b) {
			m.AtualizaTable();
			m.AtualizaTable2();

		} else if (e.getSource() == MalaDireta.voltar) {
			new MenuPrincipal().setVisible(true);
			MalaDireta.Tela.setVisible(false);

		} else if (e.getSource() == VisualizarLista.ok) {
			l.AtualizaTableLista();
		} else if (e.getSource() == MalaDireta.ok2) {
			m.AtualizaTableContatosLotacao();
		} else if (e.getSource() == MalaDireta.b2) {
			m.AtualizaTableContatosGeral();
		}
	}

}
