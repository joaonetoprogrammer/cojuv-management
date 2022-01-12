package Controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Modelo.ContatosGeral;
import Modelo.Empresa;
import Modelo.Grupos;
import Modelo.Projeto;
import Modelo.ServidorPublico;
import Modelo.ServidorTerceirizado;
import Visao.Atualizar.AtualizarContatosGeral;
import Visao.Atualizar.AtualizarEmpresa;
import Visao.Atualizar.AtualizarGrupos;
import Visao.Atualizar.AtualizarProjeto;
import Visao.Atualizar.AtualizarServidorPublico;
import Visao.Atualizar.AtualizarServidorTerceirizado;

public class ControleAtualizar implements ActionListener {

	ServidorPublico sp = new ServidorPublico();
	ServidorTerceirizado st = new ServidorTerceirizado();
	Projeto pr = new Projeto();
	Empresa emp = new Empresa();
	Grupos g = new Grupos();
	ContatosGeral cg = new ContatosGeral();


	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == AtualizarServidorPublico.ok) {
			sp.AcaoDoBotaoOkServidorPublico();

		} else if (e.getSource() == AtualizarServidorPublico.atualizar) {
			sp.AcaoDoBotaoAlterarServidorPublico();

		} else if (e.getSource() == AtualizarServidorPublico.voltar) {

			sp.BotaoVoltarAtualizarServidorPublico();

		} else if (e.getSource() == AtualizarServidorTerceirizado.ok) {
			st.AcaoDoBotaoOkServidorTerceirizado();

		} else if (e.getSource() == AtualizarServidorTerceirizado.atualizar) {
			st.AcaoDoBotaoAlterarServidorTerceirizado();

		} else if (e.getSource() == AtualizarServidorTerceirizado.voltar) {
			st.BotaoVoltarAtualizarServidorTerceirizado();

		} else if (e.getSource() == AtualizarProjeto.ok) {
			pr.AcaoDoBotaoOkProjeto();

		} else if (e.getSource() == AtualizarProjeto.atualizar) {
			pr.AcaoDoBotaoAlterarProjeto();
		} else if (e.getSource() == AtualizarProjeto.voltar) {
			pr.BotaoVoltarAtualizarProjeto();
		} else if (e.getSource() == AtualizarEmpresa.ok) {
			emp.AcaoDoBotaoOkEmpresa();

		} else if (e.getSource() == AtualizarEmpresa.atualizar) {
			emp.AcaoDoBotaoAlterarEmpresa();
		} else if (e.getSource() == AtualizarEmpresa.voltar) {
			emp.BotaoVoltarAtualizarEmpresa();
		} else if (e.getSource() == AtualizarGrupos.ok) {
			g.AcaoDoBotaoOkGrupos();

		} else if (e.getSource() == AtualizarGrupos.atualizar) {
			g.AcaoDoBotaoAlterarGrupos();
		} else if (e.getSource() == AtualizarGrupos.voltar) {
			g.BotaoVoltarAtualizarGrupos();
		}
		else if (e.getSource() == AtualizarContatosGeral.ok) {
			cg.AcaoDoBotaoOkContatosGeral();
		} else if (e.getSource() == AtualizarContatosGeral.atualizar) {
			cg.AcaoDoBotaoAlterarContatosGeral();
		} else if (e.getSource() == AtualizarContatosGeral.voltar) {
			cg.BotaoVoltarAtualizarContatosGeral();
		}
	}

}
