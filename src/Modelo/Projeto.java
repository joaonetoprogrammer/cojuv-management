package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Visao.Atualizar.AtualizarProjeto;
import Visao.Cadastrar.CadastrarProjeto;
import Visao.Consultar.ConsultarProjeto;
import Visao.Deletar.DeletarProjeto;
import Visao.Principal.MenuProjeto;

public class Projeto {

	/**** VARIAVEIS ENCAPSULADAS REFERENTES AO BANCO DE DADODS ***/
	private int Pro_id;
	private String Pro_nome;
	private String Pro_orientador;
	private String Pro_pub_alvo;
	private String Pro_localidade;
	private String Pro_descricao;
	private String Pro_email_orientador;
	private String Pro_telefone_orientador;

	/**** METODOS GETERES E SETERES REFERENTES AS VARIAVEIS EMCAPSULADAS ****/
	public int getPro_id() {
		return Pro_id;
	}

	public void setPro_id(int pro_id) {
		Pro_id = pro_id;
	}

	public String getPro_nome() {
		return Pro_nome;
	}

	public void setPro_nome(String pro_nome) {
		Pro_nome = pro_nome;
	}

	public String getPro_orientador() {
		return Pro_orientador;
	}

	public void setPro_orientador(String pro_orientador) {
		Pro_orientador = pro_orientador;
	}

	public String getPro_pub_alvo() {
		return Pro_pub_alvo;
	}

	public void setPro_pub_alvo(String pro_pub_alvo) {
		Pro_pub_alvo = pro_pub_alvo;
	}

	public String getPro_localidade() {
		return Pro_localidade;
	}

	public void setPro_localidade(String pro_localidade) {
		Pro_localidade = pro_localidade;
	}

	public String getPro_descricao() {
		return Pro_descricao;
	}

	public void setPro_descricao(String pro_descricao) {
		Pro_descricao = pro_descricao;
	}

	public String getPro_email_orientador() {
		return Pro_email_orientador;
	}

	public void setPro_email_orientador(String pro_email_orientador) {
		Pro_email_orientador = pro_email_orientador;
	}

	public String getPro_telefone_orientador() {
		return Pro_telefone_orientador;
	}

	public void setPro_telefone_orientador(String pro_telefone_orientador) {
		Pro_telefone_orientador = pro_telefone_orientador;
	}

	/**** METODO DE CADASTRO DE PROJETO ****/
	public void InserirProjeto(Projeto a, Connection con) {

		String sql = "insert into Pro values(0,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, a.getPro_nome());
			ps.setString(2, a.getPro_orientador());
			ps.setString(3, a.getPro_email_orientador());
			ps.setString(4, a.getPro_telefone_orientador());
			ps.setString(5, a.getPro_pub_alvo());
			ps.setString(6, a.getPro_localidade());
			ps.setString(7, a.getPro_descricao());

			if (ps.executeUpdate() > 0) {
				JOptionPane.showMessageDialog(null,
						"Cadastro Realizado com Sucesso",
						"Coordenadoria da Juventude",
						JOptionPane.INFORMATION_MESSAGE);
				
				CadastrarProjeto.projeto1.setText("");
				CadastrarProjeto.orientador1.setText("");
				CadastrarProjeto.publicoalvo1.setText("");
				CadastrarProjeto.localidade1.setText("");
				CadastrarProjeto.area.setText("");
				CadastrarProjeto.email1.setText("");
				CadastrarProjeto.telefone1.setText("");

			} else {
				JOptionPane.showMessageDialog(null, "Erro ao Inserir");
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Você excedeu o número de caracteres");
		}

	}

	/**** AÇÃO DO BOTAO CONFIRMAR PROJETO ****/
	public void BotaoCadastrarEmpresa() {
		String nome = CadastrarProjeto.projeto1.getText();
		String orientador = CadastrarProjeto.orientador1.getText();
		String publicoAlvo = CadastrarProjeto.publicoalvo1.getText();
		String localidade = CadastrarProjeto.localidade1.getText();
		String descricao = CadastrarProjeto.area.getText();
		String emailOrientador = CadastrarProjeto.email1.getText();
		String telefoneOrientador = CadastrarProjeto.telefone1.getText();

		if (nome.equals("") || orientador.equals("") || publicoAlvo.equals("")
				|| localidade.equals("") || descricao.equals("")
				|| emailOrientador.equals("")
				|| telefoneOrientador.equals("(  )    -    ")) {
			JOptionPane.showMessageDialog(null,
					"Nenhum campo pode estar vazio",
					"Coordenadoria da Juventude", JOptionPane.WARNING_MESSAGE);

		} else {
			Projeto pro = new Projeto();
			pro.setPro_nome(nome);
			pro.setPro_orientador(orientador);
			pro.setPro_pub_alvo(publicoAlvo);
			pro.setPro_localidade(localidade);
			pro.setPro_descricao(descricao);
			pro.setPro_email_orientador(emailOrientador);
			pro.setPro_telefone_orientador(telefoneOrientador);

			pro.InserirProjeto(pro, Conexao.abrirConexao());
			Conexao.FecharConeao(Conexao.abrirConexao());

	

		}

	}

	/****
	 * AÇÃO DO BOTAO VOLTAR PROJETO
	 * 
	 * @throws ParseException
	 ****/
	public void BotaoVoltarCadastrarProjeto() {
		new MenuProjeto().setVisible(true);
		CadastrarProjeto.Tela.setVisible(false);
	}

	/** ---------------METODOS REFERERENTES A TELA DE ATUALIZAR--------------- **/
	/**** METODO PARA TESTAR PROJETO ****/
	public boolean TestarProjeto(Connection con) {
		String codigo = AtualizarProjeto.codigo1.getText();
		int cod = Integer.parseInt(codigo);
		boolean resultado = false;
		try {
			String sql = "select * from Pro where Pro_id = " + cod + "";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					resultado = true;
				}
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(),
					"Coordenadoria da Juventude",
					JOptionPane.INFORMATION_MESSAGE);
		}
		return resultado;
	}

	/**** METODO PARA CAPTURAR PROJETO ****/
	public void CapturarProjeto(Projeto pr, Connection con) {
		String codigo = AtualizarProjeto.codigo1.getText();
		int cod = Integer.parseInt(codigo);
		String sql = "select * from Pro where Pro_id =" + cod + " ";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					pr.setPro_id(rs.getInt(1));
					pr.setPro_nome(rs.getString(2));
					pr.setPro_orientador(rs.getString(3));
					pr.setPro_email_orientador(rs.getString(4));
					pr.setPro_telefone_orientador(rs.getString(5));
					pr.setPro_pub_alvo(rs.getString(6));
					pr.setPro_localidade(rs.getString(7));
					pr.setPro_descricao(rs.getString(8));

				}

			} else {
				JOptionPane.showMessageDialog(null, "Errado",
						"Coordenadoria da Juventude",
						JOptionPane.INFORMATION_MESSAGE);

			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro" + e.getMessage(),
					"Coordenadoria da Juventude",
					JOptionPane.INFORMATION_MESSAGE);
		}

	}

	/**** METODO PARA ALTERAR PROJETO ****/
	@SuppressWarnings("deprecation")
	public void AlterarProjeto(Projeto pr, Connection con) {
		String sql = "update Pro set nome=?,orientador=?,email=?,telefone=?,p_alvo=?,"
				+ "local=?,des=? where Pro_id = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, pr.getPro_nome());
			ps.setString(2, pr.getPro_orientador());
			ps.setString(3, pr.getPro_email_orientador());
			ps.setString(4, pr.getPro_telefone_orientador());
			ps.setString(5, pr.getPro_pub_alvo());
			ps.setString(6, pr.getPro_localidade());
			ps.setString(7, pr.getPro_descricao());

			ps.setInt(8, pr.getPro_id());

			if (ps.executeUpdate() > 0) {
				JOptionPane.showMessageDialog(null,
						"Atualização realizada com sucesso",
						"Coordenadoria da Juventude",
						JOptionPane.INFORMATION_MESSAGE);
				AtualizarProjeto.telefone1.setText("");
				AtualizarProjeto.orientador1.setText("");
				AtualizarProjeto.localidade1.setText("");
				AtualizarProjeto.area.setText("");
				AtualizarProjeto.email1.setText("");
				AtualizarProjeto.projeto1.setText("");
				AtualizarProjeto.publicoalvo1.setText("");

				AtualizarProjeto.codigo1.setText("");
				AtualizarProjeto.codigo1.enable();
				AtualizarProjeto.projeto1.disable();
				AtualizarProjeto.orientador1.disable();
				AtualizarProjeto.localidade1.disable();
				AtualizarProjeto.area.disable();
				AtualizarProjeto.email1.disable();
				AtualizarProjeto.telefone1.disable();
				AtualizarProjeto.publicoalvo1.disable();
			} else {
				JOptionPane.showMessageDialog(null, "Erro ao Atualizar",
						"Coordenadoria da Juventude",
						JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,
					"Você excedeu o número de caracteres",
					"Coordenadoria da Juventude",
					JOptionPane.INFORMATION_MESSAGE);
		}

	}

	/**** METODO PARA INSERIR DADOS PROJETO ****/
	@SuppressWarnings("deprecation")
	public void InseririDadosProjeto(Projeto pr2) {

		AtualizarProjeto.projeto1.enable();
		AtualizarProjeto.orientador1.enable();
		AtualizarProjeto.publicoalvo1.enable();
		AtualizarProjeto.email1.enable();
		AtualizarProjeto.localidade1.enable();
		AtualizarProjeto.area.enable();
		AtualizarProjeto.telefone1.enable();

		AtualizarProjeto.projeto1.setText("" + pr2.getPro_nome());
		AtualizarProjeto.orientador1.setText("" + pr2.getPro_orientador());
		AtualizarProjeto.publicoalvo1.setText("" + pr2.getPro_pub_alvo());
		AtualizarProjeto.localidade1.setText("" + pr2.getPro_localidade());
		AtualizarProjeto.area.setText("" + pr2.getPro_descricao());
		AtualizarProjeto.telefone1.setText(""
				+ pr2.getPro_telefone_orientador());
		AtualizarProjeto.email1.setText("" + pr2.getPro_email_orientador());

	}

	/**** ACAO DO BOTAO OK PROJETO ****/
	@SuppressWarnings("deprecation")
	public void AcaoDoBotaoOkProjeto() {
		String ok = AtualizarProjeto.codigo1.getText();
		Projeto pr = new Projeto();
		try {
			if (ok.equals("")) {
				JOptionPane.showMessageDialog(null,
						"Digite o código para atualizar",
						"Coordenadoria da Juventude",
						JOptionPane.WARNING_MESSAGE);

			} else if (pr.TestarProjeto(Conexao.abrirConexao()) == false) {
				JOptionPane
						.showMessageDialog(null, "Código não encontrado",
								"Coordenadoria da Juventude",
								JOptionPane.ERROR_MESSAGE);
				Conexao.FecharConeao(Conexao.abrirConexao());

			} else if (pr.TestarProjeto(Conexao.abrirConexao()) == true) {
				AtualizarProjeto.projeto1.setText("");
				AtualizarProjeto.orientador1.setText("");
				AtualizarProjeto.email1.setText("");
				AtualizarProjeto.area.setText("");
				AtualizarProjeto.telefone1.setText("");
				AtualizarProjeto.publicoalvo1.setText("");
				AtualizarProjeto.localidade1.setText("");

				pr.CapturarProjeto(pr, Conexao.abrirConexao());
				Conexao.FecharConeao(Conexao.abrirConexao());
				pr.InseririDadosProjeto(pr);

				AtualizarProjeto.codigo1.disable();
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "O código só possui números",
					"Coordenadoria da Juventude", JOptionPane.WARNING_MESSAGE);

		}

	}

	/**** ACAO DO BOTAO ALTERAR PROJETO ****/
	public void AcaoDoBotaoAlterarProjeto() {
		String telefone = AtualizarProjeto.telefone1.getText();
		String nome = AtualizarProjeto.projeto1.getText();
		String codigo = AtualizarProjeto.codigo1.getText();
		String orientador = AtualizarProjeto.orientador1.getText();
		String localidade = AtualizarProjeto.localidade1.getText();
		String email = AtualizarProjeto.email1.getText();
		String descricao = AtualizarProjeto.area.getText();
		String publicoalvo = AtualizarProjeto.publicoalvo1.getText();

		if (nome.equals("") || email.equals("") || publicoalvo.equals("")
				|| orientador.equals("") || telefone.equals("")
				|| localidade.equals("") || descricao.equals("")) {
			JOptionPane.showMessageDialog(null,
					"Nenhum campo pode estar vazio",
					"Coordenadoria da Juventude", JOptionPane.WARNING_MESSAGE);

		} else {
			Projeto pr = new Projeto();
			int cod = Integer.parseInt(codigo);
			pr.setPro_nome(nome);
			pr.setPro_orientador(orientador);
			pr.setPro_localidade(localidade);
			pr.setPro_descricao(descricao);
			pr.setPro_pub_alvo(publicoalvo);
			pr.setPro_email_orientador(email);
			pr.setPro_telefone_orientador(telefone);
			pr.setPro_id(cod);

			pr.AlterarProjeto(pr, Conexao.abrirConexao());
			Conexao.FecharConeao(Conexao.abrirConexao());

		}
	}

	/****
	 * AÇÃO DO BOTAO VOLTAR PROJETO
	 * 
	 * @throws ParseException
	 ****/
	public void BotaoVoltarAtualizarProjeto() {
		new MenuProjeto().setVisible(true);
		AtualizarProjeto.Tela.setVisible(false);
	}

	/***** METODOS REFERENTES A TELA DE CONSULTARR ******/
	/**** METODO DE LISTAR PROJETO POR CODIGO ****/
	public List<Projeto> ListarProjetoCodigo(Connection con) {
		String sql = "select Pro_id,nome,orientador,email,telefone,p_alvo,"
				+ "local,des from Pro";
		List<Projeto> lista = new ArrayList<Projeto>();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					Projeto pr = new Projeto();
					pr.setPro_id(rs.getInt(1));
					pr.setPro_nome(rs.getString(2));
					pr.setPro_orientador(rs.getString(3));
					pr.setPro_email_orientador(rs.getString(4));
					pr.setPro_telefone_orientador(rs.getString(5));
					pr.setPro_pub_alvo(rs.getString(6));
					pr.setPro_localidade(rs.getString(7));
					pr.setPro_descricao(rs.getString(8));

					lista.add(pr);
				}
				return lista;
			} else {
				return null;
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(),
					"Coordenadoria da Juventude", JOptionPane.ERROR_MESSAGE);
		}
		return lista;
	}

	/**** METODO PARA ATUALIZAR TABLE ****/
	public void AtualizaTable() {
		Projeto pro = new Projeto();
		List<Projeto> lista = new ArrayList<>();
		lista = pro.ListarProjetoCodigo(Conexao.abrirConexao());

		DefaultTableModel tbm = (DefaultTableModel) ConsultarProjeto.Tabela
				.getModel();
		while (tbm.getRowCount() > 0) {
			tbm.removeRow(0);

		}

		int i = 0;
		for (Projeto tab : lista) {
			tbm.addRow(new String[i]);
			ConsultarProjeto.Tabela.setValueAt(tab.getPro_id(), i, 0);
			ConsultarProjeto.Tabela.setValueAt(tab.getPro_nome(), i, 1);
			ConsultarProjeto.Tabela.setValueAt(tab.getPro_orientador(), i, 2);
			ConsultarProjeto.Tabela.setValueAt(
					tab.getPro_telefone_orientador(), i, 3);
			ConsultarProjeto.Tabela.setValueAt(tab.getPro_email_orientador(),
					i, 4);
			ConsultarProjeto.Tabela.setValueAt(tab.getPro_pub_alvo(), i, 5);
			ConsultarProjeto.Tabela.setValueAt(tab.getPro_localidade(), i, 6);
			ConsultarProjeto.Tabela.setValueAt(tab.getPro_descricao(), i, 7);
			i++;
		}
		Conexao.FecharConeao(Conexao.abrirConexao());
	}

	/**** METODO DE LISTAR PROJETO POR NOME DIGITADO ****/
	public List<Projeto> ListarProjetoNome(Connection con, String nome) {
		String sql = "select Pro_id,nome,orientador,email,telefone,p_alvo,local,"
				+ "des from Pro where nome like '" + nome + "%'";
		List<Projeto> lista = new ArrayList<Projeto>();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					Projeto pr = new Projeto();
					pr.setPro_id(rs.getInt(1));
					pr.setPro_nome(rs.getString(2));
					pr.setPro_orientador(rs.getString(3));
					pr.setPro_email_orientador(rs.getString(4));
					pr.setPro_telefone_orientador(rs.getString(5));
					pr.setPro_pub_alvo(rs.getString(6));
					pr.setPro_localidade(rs.getString(7));
					pr.setPro_descricao(rs.getString(8));

					lista.add(pr);
				}
				return lista;
			} else {
				return null;
			}

		} catch (SQLException e) {
			return null;
		}
	}

	/**** METODO PARA ATUALIZAR TABLE POR NOME ****/
	public void AtualizaTableNome() {
		Projeto pro = new Projeto();
		String nome = ConsultarProjeto.campo.getText();
		List<Projeto> lista = new ArrayList<>();
		lista = pro.ListarProjetoNome(Conexao.abrirConexao(), nome);

		if (nome.equals("")) {
			JOptionPane.showMessageDialog(null, "Digite o nome do projeto a pesquisar",
					"Coordenadoria da Juventude", JOptionPane.ERROR_MESSAGE);

		} else {
			DefaultTableModel tbm = (DefaultTableModel) ConsultarProjeto.Tabela
					.getModel();
			while (tbm.getRowCount() > 0) {
				tbm.removeRow(0);

			}

			int i = 0;
			for (Projeto tab : lista) {
				tbm.addRow(new String[i]);
				ConsultarProjeto.Tabela.setValueAt(tab.getPro_id(), i, 0);
				ConsultarProjeto.Tabela.setValueAt(tab.getPro_nome(), i, 1);
				ConsultarProjeto.Tabela.setValueAt(tab.getPro_orientador(), i,
						2);
				ConsultarProjeto.Tabela.setValueAt(
						tab.getPro_telefone_orientador(), i, 3);
				ConsultarProjeto.Tabela.setValueAt(
						tab.getPro_email_orientador(), i, 4);
				ConsultarProjeto.Tabela.setValueAt(tab.getPro_pub_alvo(), i, 5);
				ConsultarProjeto.Tabela.setValueAt(tab.getPro_localidade(), i,
						6);
				ConsultarProjeto.Tabela.setValueAt(tab.getPro_descricao(), i, 7);

				i++;
			}
			Conexao.FecharConeao(Conexao.abrirConexao());
		}
	}

	/**** METODO DE LISTAR PROJETO POR ORIENTADOR DIGITADO ****/
	public List<Projeto> ListarProjetoOrientador(Connection con,
			String orientador) {
		String sql = "select Pro_id, nome,orientador,email,telefone,p_alvo,local,"
				+ "des from Pro where orinentador like '" + orientador + "%'";
		List<Projeto> lista = new ArrayList<Projeto>();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					Projeto pr = new Projeto();
					pr.setPro_id(rs.getInt(1));
					pr.setPro_nome(rs.getString(2));
					pr.setPro_orientador(rs.getString(3));
					pr.setPro_email_orientador(rs.getString(4));
					pr.setPro_telefone_orientador(rs.getString(5));
					pr.setPro_pub_alvo(rs.getString(6));
					pr.setPro_localidade(rs.getString(7));
					pr.setPro_descricao(rs.getString(8));
					lista.add(pr);
				}
				return lista;
			} else {
				return null;
			}

		} catch (SQLException e) {
			return null;
		}
	}

	/**** METODO PARA ATUALIZAR TABLE POR ORIENTADOR ****/
	public void AtualizaTableOrientador() {
		Projeto pro = new Projeto();
		String orientador = ConsultarProjeto.campo2.getText();
		List<Projeto> lista = new ArrayList<>();
		lista = pro.ListarProjetoOrientador(Conexao.abrirConexao(), orientador);
		if (orientador.equals("")) {
			JOptionPane.showMessageDialog(null, "Digite o nome do orientador a pesquisar",
					"Coordenadoria da Juventude", JOptionPane.ERROR_MESSAGE);

		} else {

			DefaultTableModel tbm = (DefaultTableModel) ConsultarProjeto.Tabela
					.getModel();
			while (tbm.getRowCount() > 0) {
				tbm.removeRow(0);

			}

			int i = 0;
			for (Projeto tab : lista) {
				tbm.addRow(new String[i]);
				ConsultarProjeto.Tabela.setValueAt(tab.getPro_id(), i, 0);
				ConsultarProjeto.Tabela.setValueAt(tab.getPro_nome(), i, 1);
				ConsultarProjeto.Tabela.setValueAt(tab.getPro_orientador(), i,
						2);
				ConsultarProjeto.Tabela.setValueAt(
						tab.getPro_telefone_orientador(), i, 3);
				ConsultarProjeto.Tabela.setValueAt(
						tab.getPro_email_orientador(), i, 4);
				ConsultarProjeto.Tabela.setValueAt(tab.getPro_pub_alvo(), i, 5);
				ConsultarProjeto.Tabela.setValueAt(tab.getPro_localidade(), i,
						6);
				ConsultarProjeto.Tabela.setValueAt(tab.getPro_descricao(), i, 7);

				i++;
			}
			Conexao.FecharConeao(Conexao.abrirConexao());
		}
	}

	/**** METODO DE LISTAR PROJETO POR ORDEM ALFABETICA ****/
	public List<Projeto> ListarProjetoOrdem(Connection con) {
		String sql = "select Pro_id, nome,orientador,email,telefone,p_alvo,local,"
				+ "des from Pro ORDER BY nome ASC";
		List<Projeto> lista = new ArrayList<Projeto>();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					Projeto pr = new Projeto();
					pr.setPro_id(rs.getInt(1));
					pr.setPro_nome(rs.getString(2));
					pr.setPro_orientador(rs.getString(3));
					pr.setPro_email_orientador(rs.getString(4));
					pr.setPro_telefone_orientador(rs.getString(5));
					pr.setPro_pub_alvo(rs.getString(6));
					pr.setPro_localidade(rs.getString(7));
					pr.setPro_descricao(rs.getString(8));

					lista.add(pr);
				}
				return lista;
			} else {
				return null;
			}

		} catch (SQLException e) {
			return null;
		}
	}

	/**** METODO PARA ATUALIZAR TABLE POR ORDEM ****/
	public void AtualizaTableOrdem() {
		Projeto pro = new Projeto();
		List<Projeto> lista = new ArrayList<>();
		lista = pro.ListarProjetoOrdem(Conexao.abrirConexao());

		DefaultTableModel tbm = (DefaultTableModel) ConsultarProjeto.Tabela
				.getModel();
		while (tbm.getRowCount() > 0) {
			tbm.removeRow(0);

		}

		int i = 0;
		for (Projeto tab : lista) {
			tbm.addRow(new String[i]);
			ConsultarProjeto.Tabela.setValueAt(tab.getPro_id(), i, 0);
			ConsultarProjeto.Tabela.setValueAt(tab.getPro_nome(), i, 1);
			ConsultarProjeto.Tabela.setValueAt(tab.getPro_orientador(), i, 2);
			ConsultarProjeto.Tabela.setValueAt(
					tab.getPro_telefone_orientador(), i, 3);
			ConsultarProjeto.Tabela.setValueAt(tab.getPro_email_orientador(),
					i, 4);
			ConsultarProjeto.Tabela.setValueAt(tab.getPro_pub_alvo(), i, 5);
			ConsultarProjeto.Tabela.setValueAt(tab.getPro_localidade(), i, 6);
			ConsultarProjeto.Tabela.setValueAt(tab.getPro_descricao(), i, 7);
			i++;
		}
		Conexao.FecharConeao(Conexao.abrirConexao());
	}

	/****
	 * AÇÃO DO BOTAO VOLTAR CONSULTAR PROJETO
	 * 
	 * @throws ParseException
	 ****/
	public void BotaoVoltarConsultarProjeto() {
		new MenuProjeto().setVisible(true);
		ConsultarProjeto.Tela.setVisible(false);
	}

	/******* METODOS REFERENTES A TELA DE DELETAR ******/
	/**** METODO DE LISTAR COMBO PROJETO ****/
	public List<Projeto> ListarComboeProjeto(Connection con) {

		String sql = "Select nome from Pro ORDER BY nome ASC";
		List<Projeto> lista = new ArrayList<>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {

					Projeto pro = new Projeto();
					pro.setPro_nome(rs.getString(1));
					lista.add(pro);

				}
				return lista;

			} else {
				return null;
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(),
					"Coordenadoria da Juventude", JOptionPane.ERROR_MESSAGE);
			return null;
		}
	}

	/**** METODO DA TELA ****/
	public void MetodoDaTela() {

		DeletarProjeto.nome1.removeAllItems();
		DeletarProjeto.nome1.addItem("");
		Projeto pro = new Projeto();
		List<Projeto> lista = new ArrayList<>();
		lista = pro.ListarComboeProjeto(Conexao.abrirConexao());
		for (Projeto a : lista) {

			DeletarProjeto.nome1.addItem(a.getPro_nome());

		}
		Conexao.FecharConeao(Conexao.abrirConexao());
	}

	/**** METODO PARA DELETAR PROJETO ****/
	public void ExcluirProjeto(Connection con, Projeto pro) {

		String nome = DeletarProjeto.nome1.getSelectedItem().toString();
		pro.setPro_nome(nome);
		String sql = "delete from Pro where nome =?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, pro.getPro_nome());
			if (ps.executeUpdate() > 0) {
				JOptionPane.showMessageDialog(null, "Deletado com Sucesso",
						"Coordenadoria da Juventude",
						JOptionPane.INFORMATION_MESSAGE);
				// DeletarServidorPublico.combo1.removeAllItems();
				pro.MetodoDaTela();

			} else {
				JOptionPane
						.showMessageDialog(null, "Erro ao deletar",
								"Coordenadoria da Juventude",
								JOptionPane.ERROR_MESSAGE);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(),
					"Coordenadoria da Juventude", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**** ACAO DO BOTAO DELETAR PROJETO ****/
	public void AcaodoBotaoDeletarProjeto() {
		try {
			Projeto pro = new Projeto();
			String nome = DeletarProjeto.nome1.getSelectedItem().toString();
			if (nome.equals("")) {
				JOptionPane
						.showMessageDialog(null,
								"Selecione um Item para deletar",
								"Coordenadoria da Juventude",
								JOptionPane.ERROR_MESSAGE);

			} else {
				int b = JOptionPane
						.showConfirmDialog(null, "Deseja Realmente Excluir?"
								+ "\n (" + nome + ")",
								"Coordenadoria da Juventude",
								JOptionPane.YES_NO_OPTION,
								JOptionPane.QUESTION_MESSAGE);
				if (b == 0) {
					pro.ExcluirProjeto(Conexao.abrirConexao(), pro);
					Conexao.FecharConeao(Conexao.abrirConexao());
				}
			}
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null,
					"Selecione um Item para deletar",
					"Coordenadoria da Juventude", JOptionPane.ERROR_MESSAGE);
		}

	}

	/****
	 * AÇÃO DO BOTAO VOLTAR DELETAR PROJETO
	 * 
	 * @throws ParseException
	 ****/
	public void BotaoVoltarDeletarProjeto() {
		new MenuProjeto().setVisible(true);
		DeletarProjeto.Tela.setVisible(false);
	}
}
