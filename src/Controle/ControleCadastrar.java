package Controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Modelo.ContatosGeral;
import Modelo.Empresa;
import Modelo.Grupos;
import Modelo.Lembrete;
import Modelo.Projeto;
import Modelo.ServidorPublico;
import Modelo.ServidorTerceirizado;
import Visao.Cadastrar.CadastrarContatosGeral;
import Visao.Cadastrar.CadastrarEmpresa;
import Visao.Cadastrar.CadastrarGrupos;
import Visao.Cadastrar.CadastrarLembrete;
import Visao.Cadastrar.CadastrarProjeto;
import Visao.Cadastrar.CadastrarServidorPublico;
import Visao.Cadastrar.CadastrarServidorTerceirizado;

public class ControleCadastrar implements ActionListener {

	ServidorPublico sp = new ServidorPublico();
	ServidorTerceirizado st = new ServidorTerceirizado();
	Lembrete le = new Lembrete();
	Projeto p = new Projeto();
	Empresa mm = new Empresa();
	Grupos g = new Grupos();
	ContatosGeral cg = new ContatosGeral();

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == CadastrarServidorPublico.confirmar) {
			sp.BotaoCadastrarServidorPublico();
		} else if (e.getSource() == CadastrarServidorPublico.voltar) {
			sp.BotaoVoltarCadastrarServidorPublico();
		} else if (e.getSource() == CadastrarServidorTerceirizado.confirmar) {
			st.BotaoCadastrarServidorTerceirizado();
		} else if (e.getSource() == CadastrarServidorTerceirizado.voltar) {
			st.BotaoVoltarCadastrarServidorTerceirizado();
		} else if (e.getSource() == CadastrarLembrete.salvar) {
			le.BotaoSalvarLambrete();
		} else if (e.getSource() == CadastrarLembrete.sair) {
			le.BotaoSairCadastrarLembrete();
		} else if (e.getSource() == CadastrarProjeto.cadastrar) {
			p.BotaoCadastrarEmpresa();
		} else if (e.getSource() == CadastrarProjeto.voltar) {
			p.BotaoVoltarCadastrarProjeto();
		} else if (e.getSource() == CadastrarEmpresa.cadastrar) {
			mm.BotaoCadastrarEmpresa();
		} else if (e.getSource() == CadastrarEmpresa.voltar) {
			mm.BotaoVoltarCadastrarEmpresa();
		} else if (e.getSource() == CadastrarGrupos.cadastrar) {
			g.BotaoCadastrarGrupo();
		} else if (e.getSource() == CadastrarGrupos.voltar) {
			g.BotaoVoltarCadastrarGrupos();
		} else if (e.getSource() == CadastrarContatosGeral.confirmar){
			cg.BotaoCadastrarContatosGeral();
		} else if (e.getSource() == CadastrarContatosGeral.voltar) {
			cg.BotaoVoltarCadastrarContatosGeral();
		}
	}

}
