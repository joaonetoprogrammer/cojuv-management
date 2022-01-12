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

import Visao.Atualizar.AtualizarServidorPublico;
import Visao.Cadastrar.CadastrarServidorPublico;
import Visao.Consultar.ConsultarServidorPublico;
import Visao.Deletar.DeletarServidorPublico;
import Visao.Principal.MenuServidorPublico;

public class ServidorPublico {

	/**** VARIAVEIS ENCAPSULADAS REFERENTES AO BANCO DE DADODS ****/
	private int Ser_p_id;
	private String Ser_p_nome;
	private String Ser_p_email;
	private String Ser_p_telefone;
	private String Ser_p_lotacao;
	private String Ser_p_matricula;
	private String Ser_p_funcao;
	private String Ser_p_facebook;

	/**** METODOS GETERES E SETERES REFERENTES AS VARIAVEIS ENCAPSULADAS ****/

	public int getSer_p_id() {
		return Ser_p_id;
	}

	public void setSer_p_id(int ser_p_id) {
		Ser_p_id = ser_p_id;
	}

	public String getSer_p_nome() {
		return Ser_p_nome;
	}

	public void setSer_p_nome(String ser_p_nome) {
		Ser_p_nome = ser_p_nome;
	}

	public String getSer_p_email() {
		return Ser_p_email;
	}

	public void setSer_p_email(String ser_p_email) {
		Ser_p_email = ser_p_email;
	}

	public String getSer_p_telefone() {
		return Ser_p_telefone;
	}

	public void setSer_p_telefone(String ser_p_telefone) {
		Ser_p_telefone = ser_p_telefone;
	}

	public String getSer_p_lotacao() {
		return Ser_p_lotacao;
	}

	public void setSer_p_lotacao(String ser_p_lotacao) {
		Ser_p_lotacao = ser_p_lotacao;
	}

	public String getSer_p_matricula() {
		return Ser_p_matricula;
	}

	public void setSer_p_matricula(String ser_p_matricula) {
		Ser_p_matricula = ser_p_matricula;
	}

	public String getSer_p_funcao() {
		return Ser_p_funcao;
	}

	public void setSer_p_funcao(String ser_p_funcao) {
		Ser_p_funcao = ser_p_funcao;
	}

	public String getSer_p_facebook() {
		return Ser_p_facebook;
	}

	public void setSer_p_facebook(String ser_p_facebook) {
		Ser_p_facebook = ser_p_facebook;
	}

	/** ---------------METODOS REFERERENTES A TELA DE CADASTRAR--------------- **/
	/**** METODO DE CADASTRO DE SERVIDOR PUBLICO ****/
	public void InserirServidorPublico(ServidorPublico a, Connection con) {

		String sql = "insert into serv_p values(0,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, a.getSer_p_nome());
			ps.setString(2, a.getSer_p_email());
			ps.setString(3, a.getSer_p_telefone());
			ps.setString(4, a.getSer_p_lotacao());
			ps.setString(5, a.getSer_p_matricula());
			ps.setString(6, a.getSer_p_funcao());
			ps.setString(7, a.getSer_p_facebook());

			if (ps.executeUpdate() > 0) {
				JOptionPane.showMessageDialog(null,
						"Cadastro Realizado com Sucesso",
						"Coordenadoria da Juventude",
						JOptionPane.INFORMATION_MESSAGE);

				Conexao.FecharConeao(Conexao.abrirConexao());
				CadastrarServidorPublico.campoNome.setText("");
				CadastrarServidorPublico.campoEmail.setText("");
				CadastrarServidorPublico.campoTelefone.setText("");
				CadastrarServidorPublico.comboLotacao.setSelectedItem("");
				CadastrarServidorPublico.campoMatricula.setText("");
				CadastrarServidorPublico.campoFuncao.setText("");
				CadastrarServidorPublico.campoFacebook.setText("");

			} else {
				JOptionPane.showMessageDialog(null, "Erro ao Inserir");
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,
					"Você excedeu o número de caracteres");
		}

	}

	/****
	 * AÇÃO DO BOTAO CONFIRMAR CADSATRAR SERVIDOR PUBLICO
	 * 
	 * @throws ParseException
	 ****/
	public void BotaoCadastrarServidorPublico() {
		String nome = CadastrarServidorPublico.campoNome.getText();
		String email = CadastrarServidorPublico.campoEmail.getText();
		String telefone = CadastrarServidorPublico.campoTelefone.getText();
		String lotacao = CadastrarServidorPublico.comboLotacao
				.getSelectedItem().toString();
		String matricula = CadastrarServidorPublico.campoMatricula.getText();
		String funcao = CadastrarServidorPublico.campoFuncao.getText();
		String facebook = CadastrarServidorPublico.campoFacebook.getText();

		if (nome.equals("") || email.equals("")
				|| telefone.equals("(  )    -    ") || matricula.equals("")
				|| facebook.equals("") || funcao.equals("")
				|| lotacao.equals("")) {
			JOptionPane.showMessageDialog(null,
					"Nenhum campo pode estar vazio",
					"Coordenadoria da Juventude", JOptionPane.WARNING_MESSAGE);

		} else {

			ServidorPublico ser = new ServidorPublico();
			ser.setSer_p_nome(nome);
			ser.setSer_p_email(email);
			ser.setSer_p_telefone(telefone);
			ser.setSer_p_lotacao(lotacao);
			ser.setSer_p_matricula(matricula);
			ser.setSer_p_funcao(funcao);
			ser.setSer_p_facebook(facebook);

			ser.InserirServidorPublico(ser, Conexao.abrirConexao());

		}

	}

	/****
	 * AÇÃO DO BOTAO VOLTAR CADASTRAR SERVIDOR PUBLICO
	 * 
	 * @throws ParseException
	 ****/
	public void BotaoVoltarCadastrarServidorPublico() {
		new MenuServidorPublico().setVisible(true);
		CadastrarServidorPublico.tela.setVisible(false);
	}

	/** ---------------METODOS REFERERENTES A TELA DE ATUALIZAR--------------- **/
	/**** METODO PARA TESTAR SERVIDOR PUBLICO ****/
	public boolean TestarServidorPublico(Connection con) {
		String co = AtualizarServidorPublico.codigo1.getText();
		int cod = Integer.parseInt(co);
		boolean resultado = false;
		try {
			String sql = "select * from serv_p where pub_id = " + cod + "";
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

	/**** METODO PARA CAPTURAR SERVIDOR PUBLICO ****/
	public void CapturarServidorPublico(ServidorPublico sp, Connection con) {
		String co = AtualizarServidorPublico.codigo1.getText();
		int cod = Integer.parseInt(co);
		String sql = "select * from serv_p where pub_id =" + cod + "";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					sp.setSer_p_id(rs.getInt(1));
					sp.setSer_p_nome(rs.getString(2));
					sp.setSer_p_email(rs.getString(3));
					sp.setSer_p_telefone(rs.getString(4));
					sp.setSer_p_lotacao(rs.getString(5));
					sp.setSer_p_matricula(rs.getString(6));
					sp.setSer_p_funcao(rs.getString(7));
					sp.setSer_p_facebook(rs.getString(8));

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

	/**** METODO PARA ALTERAR SERVIDOR PUBLICO ****/
	@SuppressWarnings("deprecation")
	public void AlterarServidorPublico(ServidorPublico sp, Connection con) {
		String sql = "update serv_p set nome=?,email=?,"
				+ "telefone=?,lotacao=?,matricula=?,"
				+ "funcao=?,facebook=? where pub_id = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, sp.getSer_p_nome());
			ps.setString(2, sp.getSer_p_email());
			ps.setString(3, sp.getSer_p_telefone());
			ps.setString(4, sp.getSer_p_lotacao());
			ps.setString(5, sp.getSer_p_matricula());
			ps.setString(6, sp.getSer_p_funcao());
			ps.setString(7, sp.getSer_p_facebook());
			ps.setInt(8, sp.getSer_p_id());

			if (ps.executeUpdate() > 0) {

				JOptionPane.showMessageDialog(null,
						"Atualização realizada com sucesso",
						"Coordenadoria da Juventude",
						JOptionPane.INFORMATION_MESSAGE);
				Conexao.FecharConeao(Conexao.abrirConexao());
				AtualizarServidorPublico.telefone1.setText("");
				AtualizarServidorPublico.nome1.setText("");
				AtualizarServidorPublico.funcao1.setText("");
				AtualizarServidorPublico.matricula1.setText("");
				AtualizarServidorPublico.email1.setText("");
				AtualizarServidorPublico.facebook1.setText("");
				AtualizarServidorPublico.combo.setSelectedItem("");

				AtualizarServidorPublico.codigo1.setText("");
				AtualizarServidorPublico.codigo1.enable();
				AtualizarServidorPublico.nome1.disable();
				AtualizarServidorPublico.email1.disable();
				AtualizarServidorPublico.matricula1.disable();
				AtualizarServidorPublico.funcao1.disable();
				AtualizarServidorPublico.telefone1.disable();
				AtualizarServidorPublico.facebook1.disable();
				AtualizarServidorPublico.combo.disable();
				AtualizarServidorPublico.atualizar.disable();

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

	/**** METODO PARA INSERIR DADOS SERVIDOR PUBLICO ****/
	@SuppressWarnings("deprecation")
	public void InseririDadosServidorPublico(ServidorPublico sp2) {
		AtualizarServidorPublico.nome1.enable();
		AtualizarServidorPublico.email1.enable();
		AtualizarServidorPublico.matricula1.enable();
		AtualizarServidorPublico.funcao1.enable();
		AtualizarServidorPublico.telefone1.enable();
		AtualizarServidorPublico.facebook1.enable();
		AtualizarServidorPublico.combo.enable();
		AtualizarServidorPublico.atualizar.enable();

		AtualizarServidorPublico.nome1.setText("" + sp2.getSer_p_nome());
		AtualizarServidorPublico.email1.setText("" + sp2.getSer_p_email());
		AtualizarServidorPublico.matricula1.setText(""
				+ sp2.getSer_p_matricula());
		AtualizarServidorPublico.funcao1.setText("" + sp2.getSer_p_funcao());
		AtualizarServidorPublico.facebook1
				.setText("" + sp2.getSer_p_facebook());
		AtualizarServidorPublico.telefone1
				.setText("" + sp2.getSer_p_telefone());
		AtualizarServidorPublico.combo.setSelectedItem(""
				+ sp2.getSer_p_lotacao());

	}

	/**** ACAO DO BOTAO OK ****/
	@SuppressWarnings("deprecation")
	public void AcaoDoBotaoOkServidorPublico() {
		String ok = AtualizarServidorPublico.codigo1.getText();
		ServidorPublico sp = new ServidorPublico();
		try {
			if (ok.equals("")) {
				JOptionPane.showMessageDialog(null,
						"Digite o código para atualizar",
						"Coordenadoria da Juventude",
						JOptionPane.WARNING_MESSAGE);
			} else if (sp.TestarServidorPublico(Conexao.abrirConexao()) == false) {
				JOptionPane
						.showMessageDialog(null, "Código não encontrado",
								"Coordenadoria da Juventude",
								JOptionPane.ERROR_MESSAGE);
				Conexao.FecharConeao(Conexao.abrirConexao());

			} else if (sp.TestarServidorPublico(Conexao.abrirConexao()) == true) {
				AtualizarServidorPublico.telefone1.setText("");
				AtualizarServidorPublico.nome1.setText("");
				AtualizarServidorPublico.funcao1.setText("");
				AtualizarServidorPublico.matricula1.setText("");
				AtualizarServidorPublico.email1.setText("");
				AtualizarServidorPublico.facebook1.setText("");
				AtualizarServidorPublico.combo.setSelectedItem("");
				sp.CapturarServidorPublico(sp, Conexao.abrirConexao());
				Conexao.FecharConeao(Conexao.abrirConexao());
				sp.InseririDadosServidorPublico(sp);

				AtualizarServidorPublico.codigo1.disable();
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "O código só possui números",
					"Coordenadoria da Juventude", JOptionPane.WARNING_MESSAGE);

		}
	}

	/**** ACAO DO BOTAO ALTERAR SERVIDOR PUBLICO ****/
	public void AcaoDoBotaoAlterarServidorPublico() {
		String codigo = AtualizarServidorPublico.codigo1.getText();
		String telefone = AtualizarServidorPublico.telefone1.getText();
		String nome = AtualizarServidorPublico.nome1.getText();
		String funcao = AtualizarServidorPublico.funcao1.getText();
		String facebook = AtualizarServidorPublico.facebook1.getText();
		String matricula = AtualizarServidorPublico.matricula1.getText();
		String email = AtualizarServidorPublico.email1.getText();
		String lotacao = AtualizarServidorPublico.combo.getSelectedItem()
				.toString();

		if (nome.equals("") || email.equals("") || funcao.equals("")
				|| lotacao.equals("") || matricula.equals("")
				|| facebook.equals("") || telefone.equals("")
				|| lotacao.equals("")) {
			JOptionPane.showMessageDialog(null,
					"Nenhum campo pode estar vazio",
					"Coordenadoria da Juventude", JOptionPane.WARNING_MESSAGE);

		} else {
			int cod = Integer.parseInt(codigo);
			ServidorPublico sp = new ServidorPublico();
			sp.setSer_p_id(cod);
			sp.setSer_p_nome(nome);
			sp.setSer_p_email(email);
			sp.setSer_p_matricula(matricula);
			sp.setSer_p_funcao(funcao);
			sp.setSer_p_telefone(telefone);
			sp.setSer_p_lotacao(lotacao);
			sp.setSer_p_facebook(facebook);

			sp.AlterarServidorPublico(sp, Conexao.abrirConexao());

		}
	}

	/****
	 * AÇÃO DO BOTAO VOLTAR ATUALIZAR SERVIDOR PUBLICO
	 * 
	 * @throws ParseException
	 ****/
	public void BotaoVoltarAtualizarServidorPublico() {
		new MenuServidorPublico().setVisible(true);
		AtualizarServidorPublico.Tela.setVisible(false);
	}

	/***** METODOS REFERENTES A TELA DE CONSULTARR ******/
	/**** METODO DE LISTAR SERVIDOR PUBLICO POR CODIGO ****/
	public List<ServidorPublico> ListarServidorPublicoCodigo(Connection con) {
		String sql = "select pub_id,nome,email,telefone,"
				+ "lotacao,matricula,funcao,facebook from serv_p";
		List<ServidorPublico> lista = new ArrayList<ServidorPublico>();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					ServidorPublico sp = new ServidorPublico();
					sp.setSer_p_id(rs.getInt(1));
					sp.setSer_p_nome(rs.getString(2));
					sp.setSer_p_email(rs.getString(3));
					sp.setSer_p_telefone(rs.getString(4));
					sp.setSer_p_lotacao(rs.getString(5));
					sp.setSer_p_matricula(rs.getString(6));
					sp.setSer_p_funcao(rs.getString(7));
					sp.setSer_p_facebook(rs.getString(8));

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
		ServidorPublico sp = new ServidorPublico();
		List<ServidorPublico> lista = new ArrayList<>();
		lista = sp.ListarServidorPublicoCodigo(Conexao.abrirConexao());

		DefaultTableModel tbm = (DefaultTableModel) ConsultarServidorPublico.Tabela
				.getModel();
		while (tbm.getRowCount() > 0) {
			tbm.removeRow(0);

		}

		int i = 0;
		for (ServidorPublico tab : lista) {
			tbm.addRow(new String[i]);
			ConsultarServidorPublico.Tabela.setValueAt(tab.getSer_p_id(), i, 0);
			ConsultarServidorPublico.Tabela.setValueAt(tab.getSer_p_nome(), i,
					1);
			ConsultarServidorPublico.Tabela.setValueAt(tab.getSer_p_telefone(),
					i, 2);
			ConsultarServidorPublico.Tabela.setValueAt(tab.getSer_p_email(), i,
					3);

			ConsultarServidorPublico.Tabela.setValueAt(tab.getSer_p_lotacao(),
					i, 4);
			ConsultarServidorPublico.Tabela.setValueAt(
					tab.getSer_p_matricula(), i, 5);
			ConsultarServidorPublico.Tabela.setValueAt(tab.getSer_p_funcao(),
					i, 6);
			ConsultarServidorPublico.Tabela.setValueAt(tab.getSer_p_facebook(),
					i, 7);

			i++;
		}
		Conexao.FecharConeao(Conexao.abrirConexao());
	}

	/**** METODO DE LISTAR SERVIDOR PUBLICO POR NOME DIGITADO ****/
	public List<ServidorPublico> ListarServidorPublicoNome(Connection con,
			String nome) {
		String sql = "select pub_id, nome,email,telefone,"
				+ "lotacao,matricula,funcao,facebook from serv_p where nome like '"
				+ nome + "%'";
		List<ServidorPublico> lista = new ArrayList<ServidorPublico>();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					ServidorPublico sp = new ServidorPublico();
					sp.setSer_p_id(rs.getInt(1));
					sp.setSer_p_nome(rs.getString(2));
					sp.setSer_p_email(rs.getString(3));
					sp.setSer_p_telefone(rs.getString(4));
					sp.setSer_p_lotacao(rs.getString(5));
					sp.setSer_p_matricula(rs.getString(6));
					sp.setSer_p_funcao(rs.getString(7));
					sp.setSer_p_facebook(rs.getString(8));

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
		ServidorPublico sp = new ServidorPublico();
		List<ServidorPublico> lista = new ArrayList<>();
		String nome = ConsultarServidorPublico.campo.getText();
		lista = sp.ListarServidorPublicoNome(Conexao.abrirConexao(), nome);

		if (nome.equals("")) {
			JOptionPane.showMessageDialog(null, "Digite o nome a pesquisar",
					"Coordenadoria da Juventude", JOptionPane.ERROR_MESSAGE);

		} else {
			DefaultTableModel tbm = (DefaultTableModel) ConsultarServidorPublico.Tabela
					.getModel();
			while (tbm.getRowCount() > 0) {
				tbm.removeRow(0);

			}

			int i = 0;
			for (ServidorPublico tab : lista) {
				tbm.addRow(new String[i]);
				ConsultarServidorPublico.Tabela.setValueAt(tab.getSer_p_id(),
						i, 0);
				ConsultarServidorPublico.Tabela.setValueAt(tab.getSer_p_nome(),
						i, 1);
				ConsultarServidorPublico.Tabela.setValueAt(
						tab.getSer_p_telefone(), i, 2);
				ConsultarServidorPublico.Tabela.setValueAt(
						tab.getSer_p_email(), i, 3);
				ConsultarServidorPublico.Tabela.setValueAt(
						tab.getSer_p_lotacao(), i, 4);
				ConsultarServidorPublico.Tabela.setValueAt(
						tab.getSer_p_matricula(), i, 5);
				ConsultarServidorPublico.Tabela.setValueAt(
						tab.getSer_p_funcao(), i, 6);
				ConsultarServidorPublico.Tabela.setValueAt(
						tab.getSer_p_facebook(), i, 7);
				i++;

			}
			Conexao.FecharConeao(Conexao.abrirConexao());
		}
	}

	/**** METODO DE LISTAR SERVIDOR PUBLICO POR ORDEM ALFABETICA ****/
	public List<ServidorPublico> ListarServidorPublicoOrdem(Connection con) {
		String sql = "select pub_id,nome,email,telefone,"
				+ "lotacao,matricula,funcao,facebook from serv_p OrDER BY nome ASC";
		List<ServidorPublico> lista = new ArrayList<ServidorPublico>();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					ServidorPublico sp = new ServidorPublico();
					sp.setSer_p_id(rs.getInt(1));
					sp.setSer_p_nome(rs.getString(2));
					sp.setSer_p_email(rs.getString(3));
					sp.setSer_p_telefone(rs.getString(4));
					sp.setSer_p_lotacao(rs.getString(5));
					sp.setSer_p_matricula(rs.getString(6));
					sp.setSer_p_funcao(rs.getString(7));
					sp.setSer_p_facebook(rs.getString(8));

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
		ServidorPublico sp = new ServidorPublico();
		List<ServidorPublico> lista = new ArrayList<>();
		lista = sp.ListarServidorPublicoOrdem(Conexao.abrirConexao());

		DefaultTableModel tbm = (DefaultTableModel) ConsultarServidorPublico.Tabela
				.getModel();
		while (tbm.getRowCount() > 0) {
			tbm.removeRow(0);

		}

		int i = 0;
		for (ServidorPublico tab : lista) {
			tbm.addRow(new String[i]);
			ConsultarServidorPublico.Tabela.setValueAt(tab.getSer_p_id(), i, 0);
			ConsultarServidorPublico.Tabela.setValueAt(tab.getSer_p_nome(), i,
					1);
			ConsultarServidorPublico.Tabela.setValueAt(tab.getSer_p_telefone(),
					i, 2);
			ConsultarServidorPublico.Tabela.setValueAt(tab.getSer_p_email(), i,
					3);
			ConsultarServidorPublico.Tabela.setValueAt(tab.getSer_p_lotacao(),
					i, 4);
			ConsultarServidorPublico.Tabela.setValueAt(
					tab.getSer_p_matricula(), i, 5);
			ConsultarServidorPublico.Tabela.setValueAt(tab.getSer_p_funcao(),
					i, 6);
			ConsultarServidorPublico.Tabela.setValueAt(tab.getSer_p_facebook(),
					i, 7);
			i++;

		}
		Conexao.FecharConeao(Conexao.abrirConexao());
	}

	/**** METODO DE LISTAR SERVIDOR PUBLICO POR LOTACAO ****/
	public List<ServidorPublico> ListarServidorPublicoLotacao(Connection con,
			String lotacao) {
		String sql = "select pub_id,nome,email,telefone,"
				+ "lotacao,matricula,funcao,facebook from serv_p where lotacao like '"
				+ lotacao + "%'";
		List<ServidorPublico> lista = new ArrayList<ServidorPublico>();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					ServidorPublico sp = new ServidorPublico();
					sp.setSer_p_id(rs.getInt(1));
					sp.setSer_p_nome(rs.getString(2));
					sp.setSer_p_email(rs.getString(3));
					sp.setSer_p_telefone(rs.getString(4));
					sp.setSer_p_lotacao(rs.getString(5));
					sp.setSer_p_matricula(rs.getString(6));
					sp.setSer_p_funcao(rs.getString(7));
					sp.setSer_p_facebook(rs.getString(8));

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
		ServidorPublico sp = new ServidorPublico();
		List<ServidorPublico> lista = new ArrayList<>();
		String lotacao = ConsultarServidorPublico.comboLotacao
				.getSelectedItem().toString();
		lista = sp
				.ListarServidorPublicoLotacao(Conexao.abrirConexao(), lotacao);
		if (lotacao.equals("")) {
			JOptionPane.showMessageDialog(null, "Selecione uma lotação",
					"Coordenadoria da Juventude", JOptionPane.ERROR_MESSAGE);

		} else {

			DefaultTableModel tbm = (DefaultTableModel) ConsultarServidorPublico.Tabela
					.getModel();
			while (tbm.getRowCount() > 0) {
				tbm.removeRow(0);

			}

			int i = 0;
			for (ServidorPublico tab : lista) {
				tbm.addRow(new String[i]);
				ConsultarServidorPublico.Tabela.setValueAt(tab.getSer_p_id(),
						i, 0);
				ConsultarServidorPublico.Tabela.setValueAt(tab.getSer_p_nome(),
						i, 1);
				ConsultarServidorPublico.Tabela.setValueAt(
						tab.getSer_p_telefone(), i, 2);
				ConsultarServidorPublico.Tabela.setValueAt(
						tab.getSer_p_email(), i, 3);
				ConsultarServidorPublico.Tabela.setValueAt(
						tab.getSer_p_lotacao(), i, 4);
				ConsultarServidorPublico.Tabela.setValueAt(
						tab.getSer_p_matricula(), i, 5);
				ConsultarServidorPublico.Tabela.setValueAt(
						tab.getSer_p_funcao(), i, 6);
				ConsultarServidorPublico.Tabela.setValueAt(
						tab.getSer_p_facebook(), i, 7);
				i++;

			}
			Conexao.FecharConeao(Conexao.abrirConexao());
		}
	}

	/****
	 * AÇÃO DO BOTAO VOLTAR CONSULTAR SERVIDOR PUBLICO
	 * 
	 * @throws ParseException
	 ****/
	public void BotaoVoltarConsultarServidorPublico() {
		new MenuServidorPublico().setVisible(true);
		ConsultarServidorPublico.Tela.setVisible(false);
	}

	/**** METODOS REFERENTES A TELA DE DELETAR ****/
	/**** METODO DE LISTAR COMBO SERVIDOR PUBLICO ****/
	public List<ServidorPublico> ListarComboServidorPublico(
			ServidorPublico sp2, Connection con) {
		String lotacao = DeletarServidorPublico.combo.getSelectedItem()
				.toString();
		sp2.setSer_p_lotacao(lotacao);
		String sql = "Select * from serv_p where lotacao = ? OrDER BY nome ASC";
		List<ServidorPublico> lista = new ArrayList<>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, sp2.getSer_p_lotacao());
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					ServidorPublico sp = new ServidorPublico();
					sp.setSer_p_nome(rs.getString(2));
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
		String lotacao = DeletarServidorPublico.combo.getSelectedItem()
				.toString();
		if (lotacao.equals("")) {
			JOptionPane.showMessageDialog(null, "Selecione uma lotação",
					"Coordenadoria da Juventude", JOptionPane.ERROR_MESSAGE);
		} else {
			ServidorPublico sp = new ServidorPublico();
			DeletarServidorPublico.combo1.removeAllItems();
			List<ServidorPublico> lista = new ArrayList<>();
			lista = sp.ListarComboServidorPublico(sp, Conexao.abrirConexao());
			DeletarServidorPublico.combo1.addItem("");

			for (ServidorPublico a : lista) {

				DeletarServidorPublico.combo1.addItem(a.getSer_p_nome());

			}
		}
		Conexao.FecharConeao(Conexao.abrirConexao());
	}

	/**** METODO PARA DELETAR SERVIDOR PUBLICO ****/
	public void ExcluirServidorPublico(Connection con, ServidorPublico sp) {
		String nome = DeletarServidorPublico.combo1.getSelectedItem()
				.toString();

		sp.setSer_p_nome(nome);
		String sql = "delete from serv_p where nome =?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, sp.getSer_p_nome());
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

	/**** ACAO DO BOTAO DELETAR SERVIDOR PUBLICO ****/
	public void AcaodoBotaoDeletarServidorPublico() {
		try {
			ServidorPublico sp = new ServidorPublico();
			String nome = DeletarServidorPublico.combo1.getSelectedItem()
					.toString();
			String lotacao = DeletarServidorPublico.combo.getSelectedItem()
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
					sp.ExcluirServidorPublico(Conexao.abrirConexao(), sp);
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
	 * AÇÃO DO BOTAO VOLTAR DELETAR SERVIDOR PUBLICO
	 * 
	 * @throws ParseException
	 ****/
	public void BotaoVoltarDeletarServidorPublico() {
		new MenuServidorPublico().setVisible(true);
		DeletarServidorPublico.Tela.setVisible(false);
	}
}