package Controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Modelo.ContatosGeral;
import Modelo.Empresa;
import Modelo.Grupos;
import Modelo.Projeto;
import Modelo.ServidorPublico;
import Modelo.ServidorTerceirizado;
import Visao.Deletar.DeletarContatosGeral;
import Visao.Deletar.DeletarEmpresa;
import Visao.Deletar.DeletarGrupos;
import Visao.Deletar.DeletarProjeto;
import Visao.Deletar.DeletarServidorPublico;
import Visao.Deletar.DeletarServidorTerceirizado;

public class ControleDeletar implements ActionListener {

	ServidorPublico sp = new ServidorPublico();
	ServidorTerceirizado st = new ServidorTerceirizado();
	Empresa emp = new Empresa();
	Projeto pro = new Projeto();
	Grupos g = new Grupos();
	ContatosGeral cg = new ContatosGeral();

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == DeletarServidorPublico.ok) {
			sp.AcaoBotaoOk();
		} else if (e.getSource() == DeletarServidorPublico.deletar) {
			sp.AcaodoBotaoDeletarServidorPublico();

		} else if (e.getSource() == DeletarServidorPublico.voltar) {
			sp.BotaoVoltarDeletarServidorPublico();

		} else if (e.getSource() == DeletarServidorTerceirizado.ok) {
			st.AcaoBotaoOk();
		} else if (e.getSource() == DeletarServidorTerceirizado.deletar) {
			st.AcaodoBotaoDeletarServidorTerceirizado();

		} else if (e.getSource() == DeletarServidorTerceirizado.voltar) {
			st.BotaoVoltarDeletarServidorTerceirizado();

		} else if (e.getSource() == DeletarEmpresa.deletar) {
			emp.AcaodoBotaoDeletarEmpresa();

		} else if (e.getSource() == DeletarEmpresa.voltar) {
			emp.BotaoVoltarDeletarEmpresa();

		} else if (e.getSource() == DeletarProjeto.deletar) {
			pro.AcaodoBotaoDeletarProjeto();

		} else if (e.getSource() == DeletarProjeto.voltar) {
			pro.BotaoVoltarDeletarProjeto();

		} else if (e.getSource() == DeletarGrupos.deletar) {
			g.AcaodoBotaoDeletarGrupo();

		} else if (e.getSource() == DeletarGrupos.voltar) {
			g.BotaoVoltarDeletarGrupos();

		} else if (e.getSource() == DeletarContatosGeral.ok) {
			cg.AcaoBotaoOk();

		} else if (e.getSource() == DeletarContatosGeral.deletar) {
			cg.AcaodoBotaoDeletarContatosGeral();

		} else if (e.getSource() == DeletarContatosGeral.voltar) {
			cg.BotaoVoltarDeletarContatosGeral();

		}
	}
}
