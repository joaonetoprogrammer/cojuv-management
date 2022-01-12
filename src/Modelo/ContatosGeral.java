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

import Visao.Atualizar.AtualizarContatosGeral;
import Visao.Cadastrar.CadastrarContatosGeral;
import Visao.Consultar.ConsultarContatosGeral;
import Visao.Deletar.DeletarContatosGeral;
import Visao.Principal.MenuContatosGeral;

public class ContatosGeral {

	/**** VARIAVEIS ENCAPSULADAS REFERENTES AO BANCO DE DADODS ****/
	private int Contato_id;
	private String Contato_nome;
	private String Contato_email;
	private String Contato_telefone;
	private String Contato_lotacao;
	private String Contato_funcao;
	private String Contato_facebook;

	/**** METODOS GETERES E SETERES REFERENTES AS VARIAVEIS ENCAPSULADAS ****/

	public int getContato_id() {
		return Contato_id;
	}

	public void setContato_id(int contato_id) {
		Contato_id = contato_id;
	}

	public String getContato_nome() {
		return Contato_nome;
	}

	public void setContato_nome(String contato_nome) {
		Contato_nome = contato_nome;
	}

	public String getContato_email() {
		return Contato_email;
	}

	public void setContato_email(String contato_email) {
		Contato_email = contato_email;
	}

	public String getContato_telefone() {
		return Contato_telefone;
	}

	public void setContato_telefone(String contato_telefone) {
		Contato_telefone = contato_telefone;
	}

	public String getContato_lotacao() {
		return Contato_lotacao;
	}

	public void setContato_lotacao(String contato_lotacao) {
		Contato_lotacao = contato_lotacao;
	}

	public String getContato_funcao() {
		return Contato_funcao;
	}

	public void setContato_funcao(String contato_funcao) {
		Contato_funcao = contato_funcao;
	}

	public String getContato_facebook() {
		return Contato_facebook;
	}

	public void setContato_facebook(String contato_facebook) {
		Contato_facebook = contato_facebook;
	}

	/** ---------------METODOS REFERERENTES A TELA DE CADASTRAR--------------- **/
	/**** METODO DE CADASTRO DE CONTATOS EM GERAL ****/
	public void InserirContatosGeral(ContatosGeral a, Connection con) {

		String sql = "insert into cgeral values(0,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, a.getContato_nome());
			ps.setString(2, a.getContato_email());
			ps.setString(3, a.getContato_telefone());
			ps.setString(4, a.getContato_lotacao());
			ps.setString(5, a.getContato_funcao());
			ps.setString(6, a.getContato_facebook());

			if (ps.executeUpdate() > 0) {
				JOptionPane.showMessageDialog(null,
						"Cadastro Realizado com Sucesso",
						"Coordenadoria da Juventude",
						JOptionPane.INFORMATION_MESSAGE);

				Conexao.FecharConeao(Conexao.abrirConexao());
				CadastrarContatosGeral.campoNome.setText("");
				CadastrarContatosGeral.campoEmail.setText("");
				CadastrarContatosGeral.campoTelefone.setText("");
				CadastrarContatosGeral.comboLotacao.setSelectedItem("");
				CadastrarContatosGeral.campoFuncao.setText("");
				CadastrarContatosGeral.campoFacebook.setText("");

			} else {
				JOptionPane.showMessageDialog(null, "Erro ao Inserir");
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,
					"Você excedeu o número de caracteres");
		}

	}

	/****
	 * AÇÃO DO BOTAO CONFIRMAR CADASTRAR CONTATOS GERAL
	 * 
	 * @throws ParseException
	 ****/
	public void BotaoCadastrarContatosGeral() {
		String nome = CadastrarContatosGeral.campoNome.getText();
		String email = CadastrarContatosGeral.campoEmail.getText();
		String telefone = CadastrarContatosGeral.campoTelefone.getText();
		String lotacao = CadastrarContatosGeral.comboLotacao.getSelectedItem()
				.toString();
		String funcao = CadastrarContatosGeral.campoFuncao.getText();
		String facebook = CadastrarContatosGeral.campoFacebook.getText();

		if (nome.equals("") || email.equals("")
				|| telefone.equals("(  )    -    ") || facebook.equals("")
				|| funcao.equals("") || lotacao.equals("")) {
			JOptionPane.showMessageDialog(null,
					"Nenhum campo pode estar vazio",
					"Coordenadoria da Juventude", JOptionPane.WARNING_MESSAGE);

		} else {

			ContatosGeral ser = new ContatosGeral();
			ser.setContato_nome(nome);
			ser.setContato_email(email);
			ser.setContato_telefone(telefone);
			ser.setContato_lotacao(lotacao);
			ser.setContato_funcao(funcao);
			ser.setContato_facebook(facebook);

			ser.InserirContatosGeral(ser, Conexao.abrirConexao());

		}

	}

	/****
	 * AÇÃO DO BOTAO VOLTAR CADASTRAR CONTATOS GERAL
	 * 
	 * @throws ParseException
	 ****/
	public void BotaoVoltarCadastrarContatosGeral() {
		new MenuContatosGeral().setVisible(true);
		CadastrarContatosGeral.tela.setVisible(false);
	}

	/** ---------------METODOS REFERERENTES A TELA DE ATUALIZAR--------------- **/
	/**** METODO PARA TESTAR CONTATOS GERAL ****/
	public boolean TestarContatosGeral(Connection con) {
		String co = AtualizarContatosGeral.codigo1.getText();
		int cod = Integer.parseInt(co);
		boolean resultado = false;
		try {
			String sql = "select * from cgeral where cg_id = " + cod + "";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					resultado = true;
				}
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "aki ooo" + e.getMessage(),
					"Coordenadoria da Juventude",
					JOptionPane.INFORMATION_MESSAGE);
		}
		return resultado;
	}

	/**** METODO PARA CAPTURAR CONTATOS GERAL ****/
	public void CapturarContatosGeral(ContatosGeral sp, Connection con) {
		String co = AtualizarContatosGeral.codigo1.getText();
		int cod = Integer.parseInt(co);
		String sql = "select * from cgeral where cg_id =" + cod + "";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					sp.setContato_id(rs.getInt(1));
					sp.setContato_nome(rs.getString(2));
					sp.setContato_email(rs.getString(3));
					sp.setContato_telefone(rs.getString(4));
					sp.setContato_lotacao(rs.getString(5));
					sp.setContato_funcao(rs.getString(6));
					sp.setContato_facebook(rs.getString(7));

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

	/**** METODO PARA ALTERAR CONTATOS GERAL ****/
	@SuppressWarnings("deprecation")
	public void AlterarContatosGeral(ContatosGeral sp, Connection con) {
		String sql = "update cgeral set cg_nome=?,cg_email=?,"
				+ "cg_telefone=?,cg_lotacao=?,"
				+ "cg_funcao=?,cg_facebook=? where cg_id = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, sp.getContato_nome());
			ps.setString(2, sp.getContato_email());
			ps.setString(3, sp.getContato_telefone());
			ps.setString(4, sp.getContato_lotacao());
			ps.setString(5, sp.getContato_funcao());
			ps.setString(6, sp.getContato_facebook());
			ps.setInt(7, sp.getContato_id());

			if (ps.executeUpdate() > 0) {

				JOptionPane.showMessageDialog(null,
						"Atualização realizada com sucesso",
						"Coordenadoria da Juventude",
						JOptionPane.INFORMATION_MESSAGE);
				Conexao.FecharConeao(Conexao.abrirConexao());
				AtualizarContatosGeral.telefone1.setText("");
				AtualizarContatosGeral.nome1.setText("");
				AtualizarContatosGeral.funcao1.setText("");
				AtualizarContatosGeral.email1.setText("");
				AtualizarContatosGeral.facebook1.setText("");
				AtualizarContatosGeral.combo.setSelectedItem("");

				AtualizarContatosGeral.codigo1.setText("");
				AtualizarContatosGeral.codigo1.enable();
				AtualizarContatosGeral.nome1.disable();
				AtualizarContatosGeral.email1.disable();
				AtualizarContatosGeral.funcao1.disable();
				AtualizarContatosGeral.telefone1.disable();
				AtualizarContatosGeral.facebook1.disable();
				AtualizarContatosGeral.combo.disable();
				AtualizarContatosGeral.atualizar.disable();

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

	/**** METODO PARA INSERIR DADOS CONTATOS GERAL ****/
	@SuppressWarnings("deprecation")
	public void InseririDadosContatosGeral(ContatosGeral sp2) {
		AtualizarContatosGeral.nome1.enable();
		AtualizarContatosGeral.email1.enable();
		AtualizarContatosGeral.funcao1.enable();
		AtualizarContatosGeral.telefone1.enable();
		AtualizarContatosGeral.facebook1.enable();
		AtualizarContatosGeral.combo.enable();
		AtualizarContatosGeral.atualizar.enable();

		AtualizarContatosGeral.nome1.setText("" + sp2.getContato_nome());
		AtualizarContatosGeral.email1.setText("" + sp2.getContato_email());
		AtualizarContatosGeral.funcao1.setText("" + sp2.getContato_funcao());
		AtualizarContatosGeral.facebook1
				.setText("" + sp2.getContato_facebook());
		AtualizarContatosGeral.telefone1
				.setText("" + sp2.getContato_telefone());
		AtualizarContatosGeral.combo.setSelectedItem(""
				+ sp2.getContato_lotacao());

	}

	/**** ACAO DO BOTAO OK ****/
	@SuppressWarnings("deprecation")
	public void AcaoDoBotaoOkContatosGeral() {
		String ok = AtualizarContatosGeral.codigo1.getText();
		ContatosGeral sp = new ContatosGeral();
		try {
			if (ok.equals("")) {
				JOptionPane.showMessageDialog(null,
						"Digite o código para atualizar",
						"Coordenadoria da Juventude",
						JOptionPane.WARNING_MESSAGE);
			} else if (sp.TestarContatosGeral(Conexao.abrirConexao()) == false) {
				JOptionPane
						.showMessageDialog(null, "Código não encontrado",
								"Coordenadoria da Juventude",
								JOptionPane.ERROR_MESSAGE);
				Conexao.FecharConeao(Conexao.abrirConexao());

			} else if (sp.TestarContatosGeral(Conexao.abrirConexao()) == true) {
				AtualizarContatosGeral.telefone1.setText("");
				AtualizarContatosGeral.nome1.setText("");
				AtualizarContatosGeral.funcao1.setText("");
				AtualizarContatosGeral.email1.setText("");
				AtualizarContatosGeral.facebook1.setText("");
				AtualizarContatosGeral.combo.setSelectedItem("");
				sp.CapturarContatosGeral(sp, Conexao.abrirConexao());
				Conexao.FecharConeao(Conexao.abrirConexao());
				sp.InseririDadosContatosGeral(sp);

				AtualizarContatosGeral.codigo1.disable();
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "O código só possui números",
					"Coordenadoria da Juventude", JOptionPane.WARNING_MESSAGE);

		}
	}

	/**** ACAO DO BOTAO ALTERAR CONTATOS GERAL ****/
	public void AcaoDoBotaoAlterarContatosGeral() {
		String codigo = AtualizarContatosGeral.codigo1.getText();
		String telefone = AtualizarContatosGeral.telefone1.getText();
		String nome = AtualizarContatosGeral.nome1.getText();
		String funcao = AtualizarContatosGeral.funcao1.getText();
		String facebook = AtualizarContatosGeral.facebook1.getText();
		String email = AtualizarContatosGeral.email1.getText();
		String lotacao = AtualizarContatosGeral.combo.getSelectedItem()
				.toString();

		if (nome.equals("") || email.equals("") || funcao.equals("")
				|| lotacao.equals("") || facebook.equals("")
				|| telefone.equals("") || lotacao.equals("")) {
			JOptionPane.showMessageDialog(null,
					"Nenhum campo pode estar vazio",
					"Coordenadoria da Juventude", JOptionPane.WARNING_MESSAGE);

		} else {
			int cod = Integer.parseInt(codigo);
			ContatosGeral sp = new ContatosGeral();
			sp.setContato_id(cod);
			sp.setContato_nome(nome);
			sp.setContato_email(email);
			sp.setContato_funcao(funcao);
			sp.setContato_telefone(telefone);
			sp.setContato_lotacao(lotacao);
			sp.setContato_facebook(facebook);

			sp.AlterarContatosGeral(sp, Conexao.abrirConexao());

		}
	}

	/****
	 * AÇÃO DO BOTAO VOLTAR ATUALIZAR CONTATOS GERAL
	 * 
	 * @throws ParseException
	 ****/
	public void BotaoVoltarAtualizarContatosGeral() {
		new MenuContatosGeral().setVisible(true);
		AtualizarContatosGeral.Tela.setVisible(false);
	}

	/***** METODOS REFERENTES A TELA DE CONSULTARR ******/
	/**** METODO DE LISTAR CONTATOS GERAL POR CODIGO ****/
	public List<ContatosGeral> ListarContatosGeralCodigo(Connection con) {
		String sql = "select cg_id,cg_nome,cg_email,cg_telefone,"
				+ "cg_lotacao,cg_funcao,cg_facebook from cgeral";
		List<ContatosGeral> lista = new ArrayList<ContatosGeral>();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					ContatosGeral sp = new ContatosGeral();
					sp.setContato_id(rs.getInt(1));
					sp.setContato_nome(rs.getString(2));
					sp.setContato_email(rs.getString(3));
					sp.setContato_telefone(rs.getString(4));
					sp.setContato_lotacao(rs.getString(5));
					sp.setContato_funcao(rs.getString(6));
					sp.setContato_facebook(rs.getString(7));

					lista.add(sp);
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
		ContatosGeral sp = new ContatosGeral();
		List<ContatosGeral> lista = new ArrayList<>();
		lista = sp.ListarContatosGeralCodigo(Conexao.abrirConexao());

		DefaultTableModel tbm = (DefaultTableModel) ConsultarContatosGeral.Tabela
				.getModel();
		while (tbm.getRowCount() > 0) {
			tbm.removeRow(0);

		}

		int i = 0;
		for (ContatosGeral tab : lista) {
			tbm.addRow(new String[i]);
			ConsultarContatosGeral.Tabela.setValueAt(tab.getContato_id(), i, 0);
			ConsultarContatosGeral.Tabela.setValueAt(tab.getContato_nome(), i,
					1);
			ConsultarContatosGeral.Tabela.setValueAt(tab.getContato_telefone(),
					i, 2);
			ConsultarContatosGeral.Tabela.setValueAt(tab.getContato_email(), i,
					3);

			ConsultarContatosGeral.Tabela.setValueAt(tab.getContato_lotacao(),
					i, 4);
			ConsultarContatosGeral.Tabela.setValueAt(tab.getContato_funcao(),
					i, 5);
			ConsultarContatosGeral.Tabela.setValueAt(tab.getContato_facebook(),
					i, 6);

			i++;
		}
		Conexao.FecharConeao(Conexao.abrirConexao());
	}

	/**** METODO DE LISTAR CONTATOS GERAL POR NOME DIGITADO ****/
	public List<ContatosGeral> ListarContatosGeralNome(Connection con,
			String nome) {
		String sql = "select cg_id, cg_nome,cg_email,cg_telefone,"
				+ "cg_lotacao,cg_funcao,cg_facebook from cgeral where cg_nome like '"
				+ nome + "%'";
		List<ContatosGeral> lista = new ArrayList<ContatosGeral>();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					ContatosGeral sp = new ContatosGeral();
					sp.setContato_id(rs.getInt(1));
					sp.setContato_nome(rs.getString(2));
					sp.setContato_email(rs.getString(3));
					sp.setContato_telefone(rs.getString(4));
					sp.setContato_lotacao(rs.getString(5));
					sp.setContato_funcao(rs.getString(6));
					sp.setContato_facebook(rs.getString(7));

					lista.add(sp);
				}
				return lista;
			} else {
				return null;
			}

		} catch (SQLException e) {
			return null;
		}
	}

	/**** METODO PARA ATUALIZAR TABLE POR NOME DIGITADO ****/
	public void AtualizaTableNome() {
		ContatosGeral sp = new ContatosGeral();
		List<ContatosGeral> lista = new ArrayList<>();
		String nome = ConsultarContatosGeral.campo.getText();
		lista = sp.ListarContatosGeralNome(Conexao.abrirConexao(), nome);

		if (nome.equals("")) {
			JOptionPane.showMessageDialog(null, "Digite o nome a pesquisar",
					"Coordenadoria da Juventude", JOptionPane.ERROR_MESSAGE);

		} else {
			DefaultTableModel tbm = (DefaultTableModel) ConsultarContatosGeral.Tabela
					.getModel();
			while (tbm.getRowCount() > 0) {
				tbm.removeRow(0);

			}

			int i = 0;
			for (ContatosGeral tab : lista) {
				tbm.addRow(new String[i]);
				ConsultarContatosGeral.Tabela.setValueAt(tab.getContato_id(),
						i, 0);
				ConsultarContatosGeral.Tabela.setValueAt(tab.getContato_nome(),
						i, 1);
				ConsultarContatosGeral.Tabela.setValueAt(
						tab.getContato_telefone(), i, 2);
				ConsultarContatosGeral.Tabela.setValueAt(
						tab.getContato_email(), i, 3);
				ConsultarContatosGeral.Tabela.setValueAt(
						tab.getContato_lotacao(), i, 4);
				ConsultarContatosGeral.Tabela.setValueAt(
						tab.getContato_funcao(), i, 5);
				ConsultarContatosGeral.Tabela.setValueAt(
						tab.getContato_facebook(), i, 6);
				i++;

			}
			Conexao.FecharConeao(Conexao.abrirConexao());
		}
	}

	/**** METODO DE LISTAR CONTATOS GERAL POR ORDEM ALFABETICA ****/
	public List<ContatosGeral> ListarContatosGeralOrdem(Connection con) {
		String sql = "select cg_id,cg_nome,cg_email,cg_telefone,"
				+ "cg_lotacao,cg_funcao,cg_facebook from cgeral OrDER BY cg_nome ASC";
		List<ContatosGeral> lista = new ArrayList<ContatosGeral>();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					ContatosGeral sp = new ContatosGeral();
					sp.setContato_id(rs.getInt(1));
					sp.setContato_nome(rs.getString(2));
					sp.setContato_email(rs.getString(3));
					sp.setContato_telefone(rs.getString(4));
					sp.setContato_lotacao(rs.getString(5));
					sp.setContato_funcao(rs.getString(6));
					sp.setContato_facebook(rs.getString(7));

					lista.add(sp);
				}
				return lista;
			} else {
				return null;
			}

		} catch (SQLException e) {
			return null;
		}
	}

	/**** METODO PARA ATUALIZAR TABLE POR ORDEM ALFABÉTICA ****/
	public void AtualizaTableOrdem() {
		ContatosGeral sp = new ContatosGeral();
		List<ContatosGeral> lista = new ArrayList<>();
		lista = sp.ListarContatosGeralOrdem(Conexao.abrirConexao());

		DefaultTableModel tbm = (DefaultTableModel) ConsultarContatosGeral.Tabela
				.getModel();
		while (tbm.getRowCount() > 0) {
			tbm.removeRow(0);

		}

		int i = 0;
		for (ContatosGeral tab : lista) {
			tbm.addRow(new String[i]);
			ConsultarContatosGeral.Tabela.setValueAt(tab.getContato_id(), i, 0);
			ConsultarContatosGeral.Tabela.setValueAt(tab.getContato_nome(), i,
					1);
			ConsultarContatosGeral.Tabela.setValueAt(tab.getContato_telefone(),
					i, 2);
			ConsultarContatosGeral.Tabela.setValueAt(tab.getContato_email(), i,
					3);
			ConsultarContatosGeral.Tabela.setValueAt(tab.getContato_lotacao(),
					i, 4);
			ConsultarContatosGeral.Tabela.setValueAt(tab.getContato_funcao(),
					i, 5);
			ConsultarContatosGeral.Tabela.setValueAt(tab.getContato_facebook(),
					i, 6);
			i++;

		}
		Conexao.FecharConeao(Conexao.abrirConexao());
	}

	/**** METODO DE LISTAR CONTATOS GERAL POR LOTACAO ****/
	public List<ContatosGeral> ListarContatosGeralLotacao(Connection con,
			String lotacao) {
		String sql = "select cg_id,cg_nome,cg_email,cg_telefone,"
				+ "cg_lotacao,cg_funcao,cg_facebook from cgeral where cg_lotacao like '"
				+ lotacao + "%'";
		List<ContatosGeral> lista = new ArrayList<ContatosGeral>();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					ContatosGeral sp = new ContatosGeral();
					sp.setContato_id(rs.getInt(1));
					sp.setContato_nome(rs.getString(2));
					sp.setContato_email(rs.getString(3));
					sp.setContato_telefone(rs.getString(4));
					sp.setContato_lotacao(rs.getString(5));
					sp.setContato_funcao(rs.getString(6));
					sp.setContato_facebook(rs.getString(7));

					lista.add(sp);
				}
				return lista;
			} else {
				return null;
			}

		} catch (SQLException e) {
			return null;
		}
	}

	/**** METODO PARA ATUALIZAR TABLE POR LOTACAO SELECIONADA ****/
	public void AtualizaTableLotacao() {
		ContatosGeral sp = new ContatosGeral();
		List<ContatosGeral> lista = new ArrayList<>();
		String lotacao = ConsultarContatosGeral.comboLotacao
				.getSelectedItem().toString();
		lista = sp
				.ListarContatosGeralLotacao(Conexao.abrirConexao(), lotacao);
		if (lotacao.equals("")) {
			JOptionPane.showMessageDialog(null, "Selecione uma lotação",
					"Coordenadoria da Juventude", JOptionPane.ERROR_MESSAGE);

		} else {

			DefaultTableModel tbm = (DefaultTableModel) ConsultarContatosGeral.Tabela
					.getModel();
			while (tbm.getRowCount() > 0) {
				tbm.removeRow(0);

			}

			int i = 0;
			for (ContatosGeral tab : lista) {
				tbm.addRow(new String[i]);
				ConsultarContatosGeral.Tabela.setValueAt(tab.getContato_id(),
						i, 0);
				ConsultarContatosGeral.Tabela.setValueAt(tab.getContato_nome(),
						i, 1);
				ConsultarContatosGeral.Tabela.setValueAt(
						tab.getContato_telefone(), i, 2);
				ConsultarContatosGeral.Tabela.setValueAt(
						tab.getContato_email(), i, 3);
				ConsultarContatosGeral.Tabela.setValueAt(
						tab.getContato_lotacao(), i, 4);
				ConsultarContatosGeral.Tabela.setValueAt(
						tab.getContato_funcao(), i, 5);
				ConsultarContatosGeral.Tabela.setValueAt(
						tab.getContato_facebook(), i, 6);
				i++;

			}
			Conexao.FecharConeao(Conexao.abrirConexao());
		}
	}

	/****
	 * AÇÃO DO BOTAO VOLTAR CONSULTAR CONTATOS GERAL
	 * 
	 * @throws ParseException
	 ****/
	public void BotaoVoltarConsultarContatosGeral() {
		new MenuContatosGeral().setVisible(true);
		ConsultarContatosGeral.Tela.setVisible(false);
	}

	/**** METODOS REFERENTES A TELA DE DELETAR ****/
	/**** METODO DE LISTAR COMBO CONTATOS GERAL ****/
	public List<ContatosGeral> ListarComboContatosGeral(ContatosGeral sp2,
			Connection con) {
		String lotacao = DeletarContatosGeral.combo.getSelectedItem()
				.toString();
		sp2.setContato_lotacao(lotacao);
		String sql = "Select * from cgeral where cg_lotacao = ? OrDER BY cg_nome ASC";
		List<ContatosGeral> lista = new ArrayList<>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, sp2.getContato_lotacao());
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					ContatosGeral sp = new ContatosGeral();
					sp.setContato_nome(rs.getString(2));
					lista.add(sp);

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

	/**** ACAO DO BOTAO OK ****/
	public void AcaoBotaoOk() {
		String lotacao = DeletarContatosGeral.combo.getSelectedItem()
				.toString();
		if (lotacao.equals("")) {
			JOptionPane.showMessageDialog(null, "Selecione uma lotação",
					"Coordenadoria da Juventude", JOptionPane.ERROR_MESSAGE);
		} else {
			ContatosGeral sp = new ContatosGeral();
			DeletarContatosGeral.combo1.removeAllItems();
			List<ContatosGeral> lista = new ArrayList<>();
			lista = sp.ListarComboContatosGeral(sp, Conexao.abrirConexao());
			DeletarContatosGeral.combo1.addItem("");

			for (ContatosGeral a : lista) {

				DeletarContatosGeral.combo1.addItem(a.getContato_nome());

			}
		}
		Conexao.FecharConeao(Conexao.abrirConexao());
	}

	/**** METODO PARA DELETAR CONTATOS GERAL ****/
	public void ExcluirContatosGeral(Connection con, ContatosGeral sp) {
		String nome = DeletarContatosGeral.combo1.getSelectedItem()
				.toString();

		sp.setContato_nome(nome);
		String sql = "delete from cgeral where cg_nome =?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, sp.getContato_nome());
			if (ps.executeUpdate() > 0) {
				JOptionPane.showMessageDialog(null, "Deletado com Sucesso",
						"Coordenadoria da Juventude",
						JOptionPane.INFORMATION_MESSAGE);
				// DeletarServidorPublico.combo1.removeAllItems();
				sp.AcaoBotaoOk();
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

	/**** ACAO DO BOTAO DELETAR CONTATOS GERAL ****/
	public void AcaodoBotaoDeletarContatosGeral() {
		try {
			ContatosGeral sp = new ContatosGeral();
			String nome = DeletarContatosGeral.combo1.getSelectedItem()
					.toString();
			String lotacao = DeletarContatosGeral.combo.getSelectedItem()
					.toString();
			if (nome.equals("")) {
				JOptionPane
						.showMessageDialog(null,
								"Selecione um Item para deletar",
								"Coordenadoria da Juventude",
								JOptionPane.ERROR_MESSAGE);

			} else {
				int b = JOptionPane
						.showConfirmDialog(null, "Deseja Realmente Excluir?"
								+ "\n (" + nome + ") (" + lotacao + ")",
								"Coordenadoria da Juventude",
								JOptionPane.YES_NO_OPTION,
								JOptionPane.QUESTION_MESSAGE);
				if (b == 0) {
					sp.ExcluirContatosGeral(Conexao.abrirConexao(), sp);
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
	 * AÇÃO DO BOTAO VOLTAR DELETAR CONTATOS GERAL
	 * 
	 * @throws ParseException
	 ****/
	public void BotaoVoltarDeletarContatosGeral() {
		new MenuContatosGeral().setVisible(true);
		DeletarContatosGeral.Tela.setVisible(false);
	}
}