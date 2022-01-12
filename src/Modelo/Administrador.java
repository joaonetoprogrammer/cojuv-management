package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import Visao.Atualizar.AtualizarContatosGeral;
import Visao.Atualizar.AtualizarEmpresa;
import Visao.Atualizar.AtualizarGrupos;
import Visao.Atualizar.AtualizarProjeto;
import Visao.Atualizar.AtualizarServidorPublico;
import Visao.Atualizar.AtualizarServidorTerceirizado;
import Visao.Cadastrar.CadastrarContatosGeral;
import Visao.Cadastrar.CadastrarEmpresa;
import Visao.Cadastrar.CadastrarGrupos;
import Visao.Cadastrar.CadastrarLembrete;
import Visao.Cadastrar.CadastrarProjeto;
import Visao.Cadastrar.CadastrarServidorPublico;
import Visao.Cadastrar.CadastrarServidorTerceirizado;
import Visao.Consultar.ConsultarContatosGeral;
import Visao.Consultar.ConsultarEmpresa;
import Visao.Consultar.ConsultarGrupos;
import Visao.Consultar.ConsultarProjeto;
import Visao.Consultar.ConsultarServidorPublico;
import Visao.Consultar.ConsultarServidorTerceirizado;
import Visao.Deletar.DeletarContatosGeral;
import Visao.Deletar.DeletarEmpresa;
import Visao.Deletar.DeletarGrupos;
import Visao.Deletar.DeletarProjeto;
import Visao.Deletar.DeletarServidorPublico;
import Visao.Deletar.DeletarServidorTerceirizado;
import Visao.Principal.MenuContatosGeral;
import Visao.Principal.MenuEmpresa;
import Visao.Principal.MenuGrupos;
import Visao.Principal.MenuPrincipal;
import Visao.Principal.MenuProjeto;
import Visao.Principal.MenuServidorPublico;
import Visao.Principal.MenuServidorTerceirizado;
import Visao.Principal.TelaDeAlteracao;
import Visao.Principal.TelaDeLembrete;
import Visao.Principal.TelaLogin;

public class Administrador {

	/**** VARIAVEIS ENCAPSULADAS REFERENTES AO BANCO DE DADODS ****/
	private int Admin_id;
	private String Admin_login;
	private String Admin_senha;

	/**** METODOS GETERES E SETERES REFERENTES AS VARIAVEIS ENCAPSULADAS ****/
	public int getAdmin_id() {
		return Admin_id;
	}

	public void setAdmin_id(int admin_id) {
		Admin_id = admin_id;
	}

	public String getAdmin_login() {
		return Admin_login;
	}

	public void setAdmin_login(String admin_login) {
		Admin_login = admin_login;
	}

	public String getAdmin_senha() {
		return Admin_senha;
	}

	public void setAdmin_senha(String admin_senha) {
		Admin_senha = admin_senha;
	}

	/**** METODO DE LOGAR ****/
	public boolean Logar(String login, String senha, Connection con) {
		boolean resultado = false;

		try {
			String consulta = "select login,senha from adm "
					+ "where login = '" + login + "' and senha = '" + senha
					+ "'";
			PreparedStatement ps = con.prepareStatement(consulta);
			ResultSet rs = ps.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					Administrador a = new Administrador();
					a.setAdmin_login(rs.getString(1));
					a.setAdmin_senha(rs.getString(2));
					resultado = true;
				}
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(),
					"Cordenadoria da Juventude", JOptionPane.ERROR_MESSAGE);
		}
		return resultado;
	}

	/****
	 * ACAO DO BOTAO ENTRAR TELA DE LOGIN
	 * 
	 * @throws ParseException
	 ****/
	public void Metodo_Botao_Entrar() {
		String login = TelaLogin.login1.getText();
		@SuppressWarnings("deprecation")
		String senha = TelaLogin.senha1.getText();
		Administrador admin = new Administrador();
		if (login.equalsIgnoreCase("") || senha.equalsIgnoreCase("")) {
			JOptionPane.showMessageDialog(null,
					"Nenhum campo pode estar vazio",
					"Cordenadoria da Juventude", JOptionPane.WARNING_MESSAGE);

			TelaLogin.login1.setText("");
			TelaLogin.senha1.setText("");
		} else if (admin.Logar(login, senha, Conexao.abrirConexao()) == true) {
			new MenuPrincipal().setVisible(true);
			TelaLogin.Tela.dispose();
			Lembrete l = new Lembrete();
			l.Lembrete2(Conexao.abrirConexao());
			Conexao.FecharConeao(Conexao.abrirConexao());
		}

		else if (admin.Logar(login, senha, Conexao.abrirConexao()) == false) {
			JOptionPane.showMessageDialog(null, "Usuário ou Senha Inválidos",
					"Cordenadoria da Juventude", JOptionPane.ERROR_MESSAGE);
			TelaLogin.login1.setText("");
			TelaLogin.senha1.setText("");
		}
	}

	/**** METODO DA TELA DE ALTERAÇÃO DE SEGURANÇA ****/
	public boolean seguranca(String login, String senha, Connection con) {
		boolean resultado = false;

		try {
			String consulta = "select login,senha from adm "
					+ "where login = '" + login + "' and senha = '" + senha
					+ "'";
			PreparedStatement ps = con.prepareStatement(consulta);
			ResultSet rs = ps.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					Administrador a = new Administrador();
					a.setAdmin_login(rs.getString(1));
					a.setAdmin_senha(rs.getString(2));
					resultado = true;
				}
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(),
					"Cordenadoria da Juventude", JOptionPane.ERROR_MESSAGE);
		}
		return resultado;
	}

	/****
	 * ACAO DO BOTAO ENTRAR TELA DE LOGIN
	 * 
	 * @throws ParseException
	 ****/
	@SuppressWarnings("deprecation")
	public void AcaoDoBotaoOk() {
		String login = TelaDeAlteracao.tLoginAtual.getText();
		String senha = TelaDeAlteracao.tSenhaAtual.getText();
		Administrador admin = new Administrador();
		if (login.equalsIgnoreCase("") || senha.equalsIgnoreCase("")) {
			JOptionPane.showMessageDialog(null,
					"Nenhum campo pode estar vazio",
					"Cordenadoria da Juventude", JOptionPane.WARNING_MESSAGE);

			TelaDeAlteracao.tLoginAtual.setText("");
			TelaDeAlteracao.tSenhaAtual.setText("");
		} else if (admin.seguranca(login, senha, Conexao.abrirConexao()) == true) {
			JOptionPane.showMessageDialog(null, "Login e Senha Corretos",
					"Cordenadoria da Juventude",
					JOptionPane.INFORMATION_MESSAGE);
			TelaDeAlteracao.tNovoLogin.enable();
			TelaDeAlteracao.tNovaSenha.enable();
			TelaDeAlteracao.tcSenha.enable();

			TelaDeAlteracao.tLoginAtual.disable();
			TelaDeAlteracao.tSenhaAtual.disable();

			Conexao.FecharConeao(Conexao.abrirConexao());
		}

		else if (admin.seguranca(login, senha, Conexao.abrirConexao()) == false) {
			JOptionPane.showMessageDialog(null, "Usuário ou Senha Inválidos",
					"Cordenadoria da Juventude", JOptionPane.ERROR_MESSAGE);
			TelaDeAlteracao.tLoginAtual.setText("");
			TelaDeAlteracao.tSenhaAtual.setText("");
		}
	}

	@SuppressWarnings("deprecation")
	public void alterar(Connection con, Administrador a) {
		String sql = "update Adm set login=?,senha=? where Adm_id =?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, a.getAdmin_login());
			ps.setString(2, a.getAdmin_senha());
			ps.setInt(3, 1);


			if (ps.executeUpdate() > 0) {
				JOptionPane.showMessageDialog(null,
						"Alteração realizada com sucesso",
						"Cordenadoria da Juventude",
						JOptionPane.INFORMATION_MESSAGE);

				TelaDeAlteracao.tNovoLogin.setText("");
				TelaDeAlteracao.tNovaSenha.setText("");
				TelaDeAlteracao.tcSenha.setText("");

				TelaDeAlteracao.tNovoLogin.disable();
				TelaDeAlteracao.tNovaSenha.disable();
				TelaDeAlteracao.tcSenha.disable();

				TelaDeAlteracao.tLoginAtual.enable();
				TelaDeAlteracao.tSenhaAtual.enable();

			} else {
				JOptionPane.showMessageDialog(null, "Erro ao Inserir");
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,
					"Você excedeu o número de caracteres");
		}

	}

	@SuppressWarnings("deprecation")
	public void AcaoDoBotaoAalterar() {
		String loginNovo = TelaDeAlteracao.tNovoLogin.getText();
		String senhaNova = TelaDeAlteracao.tNovaSenha.getText();
		String senhaNova2 = TelaDeAlteracao.tcSenha.getText();

		Administrador admin = new Administrador();
		if (loginNovo.equalsIgnoreCase("") || senhaNova.equalsIgnoreCase("")
				|| senhaNova2.equalsIgnoreCase("")) {
			JOptionPane.showMessageDialog(null,
					"Nenhum campo pode estar vazio",
					"Cordenadoria da Juventude", JOptionPane.WARNING_MESSAGE);

		} else if (senhaNova.equalsIgnoreCase(senhaNova2)) {

			admin.setAdmin_login(loginNovo);
			admin.setAdmin_senha(senhaNova2);

			admin.alterar(Conexao.abrirConexao(), admin);

		} else if (senhaNova != senhaNova2) {
			JOptionPane.showMessageDialog(null,
					"Sua confirmação de senha não está compatível",
					"Cordenadoria da Juventude", JOptionPane.WARNING_MESSAGE);

		}

	}

	/**** ACAO DO BOTAO SAIR TELA DE LOGIN ****/
	public void BotaoSairTelaLogin() {
		TelaLogin.Tela.dispose();
	}

	/** ---------------------------------------------------------- **/
	/**** METODOS REFERENTES A TELA DE MENU PRINCIPAL ****/
	/**** ACAO DO BOTAO SAIR TELA DE MENU PRINCIPAL ****/
	public void BotaoSairTelaMenuPrincipal() {
		MenuPrincipal.Tela.dispose();
	}

	/**** ACAO DO BOTAO SERVIDOR TERCEIRIZADO DE MENU PRINCIPAL ****/
	public void BotaoServidorTerceirizadoTelaMenuPrincipal() {
		new MenuServidorTerceirizado().setVisible(true);
		MenuPrincipal.Tela.dispose();

	}

	/**** ACAO DO BOTAO SERVIDOR PUBLICO DE MENU PRINCIPAL ****/
	public void BotaoServidorPublicoTelaMenuPrincipal() {
		new MenuServidorPublico().setVisible(true);
		MenuPrincipal.Tela.dispose();

	}

	/**** ACAO DO BOTAO EMPRESA DE MENU PRINCIPAL ****/
	public void BotaoEmpresaTelaMenuPrincipal() {
		new MenuEmpresa().setVisible(true);
		MenuPrincipal.Tela.dispose();

	}

	/**** ACAO DO BOTAO PROJETOS DE MENU PRINCIPAL ****/
	public void BotaoProjetoTelaMenuPrincipal() {
		new MenuProjeto().setVisible(true);
		MenuPrincipal.Tela.dispose();

	}

	/****
	 * ACAO DO BOTAO LEMBRETE DE MENU PRINCIPAL */
	public void BotaoLembreteTelaMenuPrincipal() {
		new CadastrarLembrete().setVisible(true);
		MenuPrincipal.Tela.dispose();

	}
	
	/**** ACAO DO BOTAO CONTATOS GERAL DE MENU PRINCIPAL ****/
	public void BotaoContatosGeralTelaMenuPrincipal() {
		new MenuContatosGeral().setVisible(true);
		MenuPrincipal.Tela.dispose();

	}

	/********* METODOS REFERENTES A TELA DE MENU EMPRESA **********/
	/****
	 * ACAO DO BOTAO CADASTRAR MENU EMPRESA
	 * 
	 * @throws ParseException
	 ****/
	public void BotaoCadastrarTelaMenuEmpresa() {
		new CadastrarEmpresa().setVisible(true);
		MenuEmpresa.Tela.setVisible(false);

	}

	/**** ACAO DO BOTAO DELETAR MENU EMPRESA ****/
	public void BotaoDeletarTelaMenuEmpresa() {
		new DeletarEmpresa().setVisible(true);
		MenuEmpresa.Tela.setVisible(false);

	}

	/**** ACAO DO BOTAO CONSULTAR MENU EMPRESA ****/
	public void BotaoConsultarTelaMenuEmpresa() {
		new ConsultarEmpresa().setVisible(true);
		MenuEmpresa.Tela.setVisible(false);

	}

	/****
	 * ACAO DO BOTAO ATUALIZAR MENU EMPRESA
	 * 
	 * @throws ParseException
	 ****/
	public void BotaoAtualizarTelaMenuEmpresa() {
		new AtualizarEmpresa().setVisible(true);
		MenuEmpresa.Tela.setVisible(false);

	}

	/****
	 * ACAO DO BOTAO SAIR MENU EMPRESA
	 * 
	 * @throws ParseException
	 ****/
	public void BotaoSairTelaMenuEmpresa() {
		new MenuPrincipal().setVisible(true);
		MenuEmpresa.Tela.setVisible(false);

	}

	/********* METODOS REFERENTES A TELA DE MENU GRUPOS **********/
	/****
	 * ACAO DO BOTAO CADASTRAR MENU GRUPOS
	 * 
	 * @throws ParseException
	 ****/
	public void BotaoCadastrarTelaMenuGrupos() {
		new CadastrarGrupos().setVisible(true);
		MenuGrupos.Tela.setVisible(false);

	}

	/**** ACAO DO BOTAO DELETAR MENU GRUPOS ****/
	public void BotaoDeletarTelaMenuGrupos() {
		new DeletarGrupos().setVisible(true);
		MenuGrupos.Tela.setVisible(false);

	}

	/**** ACAO DO BOTAO CONSULTAR MENU GRUPOS ****/
	public void BotaoConsultarTelaMenuGrupos() {
		new ConsultarGrupos().setVisible(true);
		MenuGrupos.Tela.setVisible(false);

	}

	/****
	 * ACAO DO BOTAO ATUALIZAR MENU GRUPOS
	 * 
	 * @throws ParseException
	 ****/
	public void BotaoAtualizarTelaMenuGrupos() {
		new AtualizarGrupos().setVisible(true);
		MenuGrupos.Tela.setVisible(false);

	}

	/****
	 * ACAO DO BOTAO SAIR MENU GRUPOS
	 * 
	 * @throws ParseException
	 ****/
	public void BotaoSairTelaMenuGrupos() {
		new MenuPrincipal().setVisible(true);
		MenuGrupos.Tela.setVisible(false);

	}

	/********* METODOS REFERENTES A TELA DE MENU SERVIDOR PUBLICO **********/
	/****
	 * ACAO DO BOTAO CADASTRAR MENU SERVIDOR PUBLICO
	 * 
	 * @throws ParseException
	 ****/
	public void BotaoCadastrarTelaMenuServidorPublico() {
		new CadastrarServidorPublico().setVisible(true);
		MenuServidorPublico.Tela.setVisible(false);

	}

	/**** ACAO DO BOTAO DELETAR SERVIDOR PUBLICO ****/
	public void BotaoDeletarTelaMenuServidorPublico() {
		new DeletarServidorPublico().setVisible(true);
		MenuServidorPublico.Tela.setVisible(false);

	}

	/**** ACAO DO BOTAO CONSULTAR SERVIDOR PUBLICO ****/
	public void BotaoConsultarTelaMenuServidorPublico() {
		new ConsultarServidorPublico().setVisible(true);
		MenuServidorPublico.Tela.setVisible(false);

	}

	/****
	 * ACAO DO BOTAO ATUALIZAR SERVIDOR PUBLICO
	 * 
	 * @throws ParseException
	 ****/
	public void BotaoAtualizarTelaMenuServidorPublico() {
		new AtualizarServidorPublico().setVisible(true);
		MenuServidorPublico.Tela.setVisible(false);

	}

	/****
	 * ACAO DO BOTAO SAIR MENU SERVIDOR PUBLICO
	 * 
	 * @throws ParseException
	 ****/
	public void BotaoSairTelaMenuServidorPublico() {
		new MenuPrincipal().setVisible(true);
		MenuServidorPublico.Tela.setVisible(false);

	}

	/********* METODOS REFERENTES A TELA DE MENU SERVIDOR TERCEIRIZADO **********/
	/****
	 * ACAO DO BOTAO CADASTRAR MENU SERVIDOR TERCEIRIZADO
	 * 
	 * @throws ParseException
	 ****/
	public void BotaoCadastrarTelaMenuServidorTerceirizado() {
		new CadastrarServidorTerceirizado().setVisible(true);
		MenuServidorTerceirizado.Tela.setVisible(false);

	}

	/**** ACAO DO BOTAO DELETAR SERVIDOR TERCEIRIZADO ****/
	public void BotaoDeletarTelaMenuServidorTerceirizado() {
		new DeletarServidorTerceirizado().setVisible(true);
		MenuServidorTerceirizado.Tela.setVisible(false);

	}

	/**** ACAO DO BOTAO CONSULTAR SERVIDOR TERCEIRIZADO ****/
	public void BotaoConsultarTelaMenuServidorTerceirizado() {
		new ConsultarServidorTerceirizado().setVisible(true);
		MenuServidorTerceirizado.Tela.setVisible(false);

	}

	/****
	 * ACAO DO BOTAO ATUALIZAR SERVIDOR TERCEIRIZADO
	 * 
	 * @throws ParseException
	 ****/
	public void BotaoAtualizarTelaMenuServidorTerceirizado() {
		new AtualizarServidorTerceirizado().setVisible(true);
		MenuServidorTerceirizado.Tela.setVisible(false);

	}

	/****
	 * ACAO DO BOTAO SAIR MENU SERVIDOR TERCEIRIZADO
	 * 
	 * @throws ParseException
	 ****/
	public void BotaoSairTelaMenuServidorTerceirizado() {
		new MenuPrincipal().setVisible(true);
		MenuServidorTerceirizado.Tela.setVisible(false);

	}

	/********* METODOS REFERENTES A TELA DE MENU PROJETO **********/
	/****
	 * ACAO DO BOTAO CADASTRAR MENU PROJETO */
	public void BotaoCadastrarTelaMenuProjeto() {
		new CadastrarProjeto().setVisible(true);
		MenuProjeto.Tela.setVisible(false);

	}

	/**** ACAO DO BOTAO DELETAR PROJETO ****/
	public void BotaoDeletarTelaMenuProjeto() {
		new DeletarProjeto().setVisible(true);
		MenuProjeto.Tela.setVisible(false);

	}

	/**** ACAO DO BOTAO CONSULTAR PROJETO ****/
	public void BotaoConsultarTelaMenuProjeto() {
		new ConsultarProjeto().setVisible(true);
		MenuProjeto.Tela.setVisible(false);

	}

	/****
	 * ACAO DO BOTAO ATUALIZAR PROJETO
	 * 
	 * @throws ParseException
	 ****/
	public void BotaoAtualizarTelaMenuProjeto() {
		new AtualizarProjeto().setVisible(true);
		MenuProjeto.Tela.setVisible(false);

	}

	/****
	 * ACAO DO BOTAO SAIR MENU PROJETO
	 * 
	 * @throws ParseException
	 ****/
	public void BotaoSairTelaMenuProjeto() {
		new MenuPrincipal().setVisible(true);
		MenuProjeto.Tela.setVisible(false);

	}
	
	
	/********* METODOS REFERENTES A TELA DE MENU CONTATOS GERAL **********/
	/****
	 * ACAO DO BOTAO CADASTRAR CONTATOS GERAL */
	public void BotaoCadastrarTelaMenuContatoGeral() {
		new CadastrarContatosGeral().setVisible(true);
		MenuContatosGeral.Tela.setVisible(false);

	}

	/**** ACAO DO BOTAO DELETAR CONTATOS GERAL ****/
	public void BotaoDeletarTelaMenuContatoGeral() {
		new DeletarContatosGeral().setVisible(true);
		MenuContatosGeral.Tela.setVisible(false);

	}

	/**** ACAO DO BOTAO CONSULTAR CONTATOS GERAL ****/
	public void BotaoConsultarTelaMenuContatoGeral() {
		new ConsultarContatosGeral().setVisible(true);
		MenuContatosGeral.Tela.setVisible(false);

	}

	/****
	 * ACAO DO BOTAO ATUALIZAR CONTATOS GERAL */
	public void BotaoAtualizarTelaMenuContatosGeral() {
		new AtualizarContatosGeral().setVisible(true);
		MenuContatosGeral.Tela.setVisible(false);

	}

	/****
	 * ACAO DO BOTAO SAIR MENU CONTATOS GERAL
	 * 
	 * @throws ParseException
	 ****/
	public void BotaoSairTelaMenuContatoGeral() {
		new MenuPrincipal().setVisible(true);
		MenuContatosGeral.Tela.setVisible(false);

	}

	/**** METODO PARA ATUALIZAR DATA ****/
	public void AtualizarData() {
		Date data = new Date();
		SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
		MenuPrincipal.form.setText(date.format(data));

	}

	public void AtualizarData2() {
		Date data = new Date();
		SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
		TelaDeLembrete.form.setText(date.format(data));

	}

	public void AtualizarData3() {
		Date data = new Date();
		SimpleDateFormat date = new SimpleDateFormat("  dd/MM/yyyy");
		SimpleDateFormat hora = new SimpleDateFormat("       hh:mm");
		MenuPrincipal.data.setText(date.format(data));
		MenuPrincipal.hora.setText(hora.format(data));
	}
}
