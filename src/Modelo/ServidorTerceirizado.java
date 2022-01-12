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

import Visao.Atualizar.AtualizarServidorTerceirizado;
import Visao.Cadastrar.CadastrarServidorTerceirizado;
import Visao.Consultar.ConsultarServidorTerceirizado;
import Visao.Deletar.DeletarServidorTerceirizado;
import Visao.Principal.MenuServidorTerceirizado;

public class ServidorTerceirizado {

	/**** VARIAVEIS ENCAPSULADAS REFERENTES AO BANCO DE DADODS ****/
	private int Ser_t_id;
	private String Ser_t_nome;
	private String Ser_t_email;
	private String Ser_t_telefone;
	private String Ser_t_lotacao;
	private String Ser_t_matricula;
	private String Ser_t_funcao;
	private String Ser_t_emp_terce;
	private String Ser_t_facebook;


	/**** METODOS GETERES E SETERES REFERENTES AS VARIAVEIS ENCAPSULADAS ****/
	public int getSer_t_id() {
		return Ser_t_id;
	}

	public void setSer_t_id(int ser_t_id) {
		Ser_t_id = ser_t_id;
	}

	public String getSer_t_nome() {
		return Ser_t_nome;
	}

	public void setSer_t_nome(String ser_t_nome) {
		Ser_t_nome = ser_t_nome;
	}

	public String getSer_t_email() {
		return Ser_t_email;
	}

	public void setSer_t_email(String ser_t_email) {
		Ser_t_email = ser_t_email;
	}

	public String getSer_t_telefone() {
		return Ser_t_telefone;
	}

	public void setSer_t_telefone(String ser_t_telefone) {
		Ser_t_telefone = ser_t_telefone;
	}

	public String getSer_t_lotacao() {
		return Ser_t_lotacao;
	}

	public void setSer_t_lotacao(String ser_t_lotacao) {
		Ser_t_lotacao = ser_t_lotacao;
	}

	public String getSer_t_matricula() {
		return Ser_t_matricula;
	}

	public void setSer_t_matricula(String ser_t_matricula) {
		Ser_t_matricula = ser_t_matricula;
	}

	public String getSer_t_funcao() {
		return Ser_t_funcao;
	}

	public void setSer_t_funcao(String ser_t_funcao) {
		Ser_t_funcao = ser_t_funcao;
	}

	public String getSer_t_emp_terce() {
		return Ser_t_emp_terce;
	}

	public void setSer_t_emp_terce(String ser_t_emp_terce) {
		Ser_t_emp_terce = ser_t_emp_terce;
	}
	
	public String getSer_t_facebook() {
		return Ser_t_facebook;
	}

	public void setSer_t_facebook(String ser_t_facebook) {
		Ser_t_facebook = ser_t_facebook;
	}

	/**** METODO DE CADASTRO DE SERVIDOR TERCERIZADO ****/
	public void InserirServidorTercerizado(ServidorTerceirizado a,
			Connection con) {
		String sql = "insert into serv_t values(0,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, a.getSer_t_emp_terce());
			ps.setString(2, a.getSer_t_nome());
			ps.setString(3, a.getSer_t_email());
			ps.setString(4, a.getSer_t_telefone());
			ps.setString(5, a.getSer_t_lotacao());
			ps.setString(6, a.getSer_t_matricula());
			ps.setString(7, a.getSer_t_funcao());
			ps.setString(8, a.getSer_t_facebook());


			if (ps.executeUpdate() > 0) {
				JOptionPane.showMessageDialog(null,
						"Cadastro Realizado com Sucesso",
						"Coordenadoria da Juventude",
						JOptionPane.INFORMATION_MESSAGE);

				CadastrarServidorTerceirizado.campoNome.setText("");
				CadastrarServidorTerceirizado.campoEmail.setText("");
				CadastrarServidorTerceirizado.campoTelefone.setText("");
				CadastrarServidorTerceirizado.campoMatricula.setText("");
				CadastrarServidorTerceirizado.campoFuncao.setText("");
				CadastrarServidorTerceirizado.comboLotacao.setSelectedItem("");
				CadastrarServidorTerceirizado.campoEmpresaTercerizada.setText("");
				CadastrarServidorTerceirizado.campoFacebook.setText("");

			} else {
				JOptionPane.showMessageDialog(null, "Erro ao Inserir");
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,
					"Você excedeu o número de caracteres");
		}

	}

	/**** AÇÃO DO BOTAO CONFIRMAR SERVIDOR TERCERIZADO ****/
	public void BotaoCadastrarServidorTerceirizado() {
		String nome = CadastrarServidorTerceirizado.campoNome.getText();
		String email = CadastrarServidorTerceirizado.campoEmail.getText();
		String telefone = CadastrarServidorTerceirizado.campoTelefone.getText();
		String lotacao = CadastrarServidorTerceirizado.comboLotacao
				.getSelectedItem().toString();
		String matricula = CadastrarServidorTerceirizado.campoMatricula
				.getText();
		String funcao = CadastrarServidorTerceirizado.campoFuncao.getText();
		String facebook = CadastrarServidorTerceirizado.campoFacebook.getText();
		String empresa = CadastrarServidorTerceirizado.campoEmpresaTercerizada
				.getText();

		if (nome.equals("") || email.equals("")
				|| telefone.equals("(  )    -    ") || lotacao.equals("")|| facebook.equals("")
				|| matricula.equals("") || funcao.equals("")
				|| empresa.equals("")) {
			JOptionPane.showMessageDialog(null,
					"Nenhum campo pode estar vazio",
					"Coordenadoria da Juventude", JOptionPane.WARNING_MESSAGE);

		} else {
			ServidorTerceirizado ser = new ServidorTerceirizado();
			ser.setSer_t_emp_terce(empresa);
			ser.setSer_t_nome(nome);
			ser.setSer_t_email(email);
			ser.setSer_t_telefone(telefone);
			ser.setSer_t_lotacao(lotacao);
			ser.setSer_t_matricula(matricula);
			ser.setSer_t_funcao(funcao);
			ser.setSer_t_facebook(facebook);


			ser.InserirServidorTercerizado(ser, Conexao.abrirConexao());
			Conexao.FecharConeao(Conexao.abrirConexao());

		

		}

	}

	/****
	 * AÇÃO DO BOTAO VOLTAR SERVIDOR TERCERIZADO
	 * 
	 * @throws ParseException
	 ****/
	public void BotaoVoltarCadastrarServidorTerceirizado() {
		new MenuServidorTerceirizado().setVisible(true);
		CadastrarServidorTerceirizado.tela.setVisible(false);
	}

	/** ---------------METODOS REFERERENTES A TELA DE ATUALIZAR--------------- **/
	/**** METODO PARA TESTAR SERVIDOR TERCEIRIZADO ****/
	public boolean TestarServidorTerceirizado(Connection con) {
		String co = AtualizarServidorTerceirizado.codigo1.getText();
		int cod = Integer.parseInt(co);
		boolean resultado = false;
		try {
			String sql = "select * from serv_t where terc_id = " + cod + "";
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

	/**** METODO PARA CAPTURAR SERVIDOR TERCEIRIZADO ****/
	public void CapturarServidorTerceirizado(ServidorTerceirizado st,
			Connection con) {
		String co = AtualizarServidorTerceirizado.codigo1.getText();
		int cod = Integer.parseInt(co);
		String sql = "select * from serv_t where terc_id =" + cod + "";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					st.setSer_t_id(rs.getInt(1));
					st.setSer_t_emp_terce(rs.getString(2));
					st.setSer_t_nome(rs.getString(3));
					st.setSer_t_email(rs.getString(4));
					st.setSer_t_telefone(rs.getString(5));
					st.setSer_t_lotacao(rs.getString(6));
					st.setSer_t_matricula(rs.getString(7));
					st.setSer_t_funcao(rs.getString(8));
					st.setSer_t_facebook(rs.getString(9));


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

	/**** METODO PARA ALTERAR SERVIDOR TERCEIRIZADO ****/
	@SuppressWarnings("deprecation")
	public void AlterarServidorTerceirizado(ServidorTerceirizado sp,
			Connection con) {
		String sql = "update serv_t set empresa=?, nome=?,email=?,"
				+ "telefone=?,lotacao=?,matricula=?,"
				+ "funcao=?,facebook=? where terc_id = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, sp.getSer_t_emp_terce());
			ps.setString(2, sp.getSer_t_nome());
			ps.setString(3, sp.getSer_t_email());
			ps.setString(4, sp.getSer_t_telefone());
			ps.setString(5, sp.getSer_t_lotacao());
			ps.setString(6, sp.getSer_t_matricula());
			ps.setString(7, sp.getSer_t_funcao());
			ps.setString(8, sp.getSer_t_facebook());
			ps.setInt(9, sp.getSer_t_id());
			if (ps.executeUpdate() > 0) {

				JOptionPane.showMessageDialog(null,
						"Atualização realizada com sucesso",
						"Coordenadoria da Juventude",
						JOptionPane.INFORMATION_MESSAGE);

				Conexao.FecharConeao(Conexao.abrirConexao());
				AtualizarServidorTerceirizado.telefone1.setText("");
				AtualizarServidorTerceirizado.nome1.setText("");
				AtualizarServidorTerceirizado.funcao1.setText("");
				AtualizarServidorTerceirizado.matricula1.setText("");
				AtualizarServidorTerceirizado.email1.setText("");
				AtualizarServidorTerceirizado.combo.setSelectedItem("");
				AtualizarServidorTerceirizado.empresa1.setText("");
				AtualizarServidorTerceirizado.facebook1.setText("");


				AtualizarServidorTerceirizado.codigo1.setText("");
				AtualizarServidorTerceirizado.codigo1.disable();
				AtualizarServidorTerceirizado.nome1.disable();
				AtualizarServidorTerceirizado.email1.disable();
				AtualizarServidorTerceirizado.matricula1.disable();
				AtualizarServidorTerceirizado.funcao1.disable();
				AtualizarServidorTerceirizado.telefone1.disable();
				AtualizarServidorTerceirizado.combo.disable();
				AtualizarServidorTerceirizado.empresa1.disable();
				AtualizarServidorTerceirizado.facebook1.disable();
				AtualizarServidorTerceirizado.atualizar.disable();

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

	/**** METODO PARA INSERIR DADOS SERVIDOR TERCEIRIZADO ****/
	@SuppressWarnings("deprecation")
	public void InseririDadosServidorTerceirizado(ServidorTerceirizado st2) {

		AtualizarServidorTerceirizado.empresa1.enable();
		AtualizarServidorTerceirizado.nome1.enable();
		AtualizarServidorTerceirizado.email1.enable();
		AtualizarServidorTerceirizado.matricula1.enable();
		AtualizarServidorTerceirizado.funcao1.enable();
		AtualizarServidorTerceirizado.telefone1.enable();
		AtualizarServidorTerceirizado.facebook1.enable();
		AtualizarServidorTerceirizado.combo.enable();

		AtualizarServidorTerceirizado.empresa1.setText(""
				+ st2.getSer_t_emp_terce());
		AtualizarServidorTerceirizado.nome1.setText("" + st2.getSer_t_nome());
		AtualizarServidorTerceirizado.email1.setText("" + st2.getSer_t_email());
		AtualizarServidorTerceirizado.matricula1.setText(""
				+ st2.getSer_t_matricula());
		AtualizarServidorTerceirizado.funcao1.setText(""
				+ st2.getSer_t_funcao());
		AtualizarServidorTerceirizado.telefone1.setText(""
				+ st2.getSer_t_telefone());
		AtualizarServidorTerceirizado.facebook1.setText(""
				+ st2.getSer_t_facebook());
		AtualizarServidorTerceirizado.combo.setSelectedItem(""
				+ st2.getSer_t_lotacao());

	}

	/**** ACAO DO BOTAO OK SERVIDOR TERCEIRIZADO ****/
	@SuppressWarnings("deprecation")
	public void AcaoDoBotaoOkServidorTerceirizado() {
		String ok = AtualizarServidorTerceirizado.codigo1.getText();
		ServidorTerceirizado st = new ServidorTerceirizado();
		try {
			if (ok.equals("")) {
				JOptionPane.showMessageDialog(null,
						"Digite o código para atualizar",
						"Coordenadoria da Juventude",
						JOptionPane.WARNING_MESSAGE);

			} else if (st.TestarServidorTerceirizado(Conexao.abrirConexao()) == false) {
				JOptionPane
						.showMessageDialog(null, "Código não encontrado",
								"Coordenadoria da Juventude",
								JOptionPane.ERROR_MESSAGE);
				Conexao.FecharConeao(Conexao.abrirConexao());

			} else if (st.TestarServidorTerceirizado(Conexao.abrirConexao()) == true) {
				AtualizarServidorTerceirizado.telefone1.setText("");
				AtualizarServidorTerceirizado.empresa1.setText("");
				AtualizarServidorTerceirizado.nome1.setText("");
				AtualizarServidorTerceirizado.funcao1.setText("");
				AtualizarServidorTerceirizado.matricula1.setText("");
				AtualizarServidorTerceirizado.email1.setText("");
				AtualizarServidorTerceirizado.facebook1.setText("");
				AtualizarServidorTerceirizado.combo.setSelectedItem("");
				st.CapturarServidorTerceirizado(st, Conexao.abrirConexao());
				Conexao.FecharConeao(Conexao.abrirConexao());
				st.InseririDadosServidorTerceirizado(st);

				AtualizarServidorTerceirizado.codigo1.disable();

			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "O código só possui números",
					"Coordenadoria da Juventude", JOptionPane.WARNING_MESSAGE);
		}
	}

	/**** ACAO DO BOTAO ALTERAR SERVIDOR TERCEIRIZADO ****/
	public void AcaoDoBotaoAlterarServidorTerceirizado() {
		String telefone = AtualizarServidorTerceirizado.telefone1.getText();
		String codigo = AtualizarServidorTerceirizado.codigo1.getText();
		String nome = AtualizarServidorTerceirizado.nome1.getText();
		String funcao = AtualizarServidorTerceirizado.funcao1.getText();
		String matricula = AtualizarServidorTerceirizado.matricula1.getText();
		String email = AtualizarServidorTerceirizado.email1.getText();
		String facebook = AtualizarServidorTerceirizado.facebook1.getText();
		String lotacao = AtualizarServidorTerceirizado.combo.getSelectedItem()
				.toString();
		String empresa = AtualizarServidorTerceirizado.empresa1.getText();

		if (nome.equals("") || email.equals("") || funcao.equals("")|| facebook.equals("")
				|| matricula.equals("") || telefone.equals("")
				|| lotacao.equals("") || empresa.equals("")) {
			JOptionPane.showMessageDialog(null,
					"Nenhum campo pode estar vazio",
					"Coordenadoria da Juventude", JOptionPane.WARNING_MESSAGE);

		} else {
			ServidorTerceirizado st = new ServidorTerceirizado();
			int cod = Integer.parseInt(codigo);
			st.setSer_t_emp_terce(empresa);
			st.setSer_t_nome(nome);
			st.setSer_t_email(email);
			st.setSer_t_matricula(matricula);
			st.setSer_t_funcao(funcao);
			st.setSer_t_telefone(telefone);
			st.setSer_t_lotacao(lotacao);
			st.setSer_t_facebook(facebook);
			st.setSer_t_id(cod);

			st.AlterarServidorTerceirizado(st, Conexao.abrirConexao());
			Conexao.FecharConeao(Conexao.abrirConexao());

		}
	}

	/****
	 * AÇÃO DO BOTAO VOLTAR ATUALIZAR SERVIDOR TERCEIRIZADO
	 * 
	 * @throws ParseException
	 ****/
	public void BotaoVoltarAtualizarServidorTerceirizado() {
		new MenuServidorTerceirizado().setVisible(true);
		AtualizarServidorTerceirizado.Tela.setVisible(false);
	}

	/***** METODOS REFERENTES A TELA DE CONSULTARR ******/
	/**** METODO DE LISTAR SERVIDOR TERCEIRIZADO POR CODIGO ****/
	public List<ServidorTerceirizado> ListarServidorTerceirizadoCodigo(
			Connection con) {
		String sql = "select terc_id,empresa,nome,email,telefone,"
				+ "lotacao,matricula,funcao,facebook from serv_t";
		List<ServidorTerceirizado> lista = new ArrayList<ServidorTerceirizado>();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					ServidorTerceirizado sp = new ServidorTerceirizado();
					sp.setSer_t_id(rs.getInt(1));
					sp.setSer_t_emp_terce(rs.getString(2));
					sp.setSer_t_nome(rs.getString(3));
					sp.setSer_t_email(rs.getString(4));
					sp.setSer_t_telefone(rs.getString(5));
					sp.setSer_t_lotacao(rs.getString(6));
					sp.setSer_t_matricula(rs.getString(7));
					sp.setSer_t_funcao(rs.getString(8));
					sp.setSer_t_facebook(rs.getString(9));

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

	/**** METODO PARA ATUALIZAR TABLE ****/
	public void AtualizaTable() {
		ServidorTerceirizado sp = new ServidorTerceirizado();
		List<ServidorTerceirizado> lista = new ArrayList<>();
		lista = sp.ListarServidorTerceirizadoCodigo(Conexao.abrirConexao());

		DefaultTableModel tbm = (DefaultTableModel) ConsultarServidorTerceirizado.Tabela
				.getModel();
		while (tbm.getRowCount() > 0) {
			tbm.removeRow(0);

		}

		int i = 0;
		for (ServidorTerceirizado tab : lista) {
			tbm.addRow(new String[i]);
			ConsultarServidorTerceirizado.Tabela.setValueAt(tab.getSer_t_id(),
					i, 0);
			ConsultarServidorTerceirizado.Tabela.setValueAt(
					tab.getSer_t_emp_terce(), i, 1);
			ConsultarServidorTerceirizado.Tabela.setValueAt(
					tab.getSer_t_nome(), i, 2);
			ConsultarServidorTerceirizado.Tabela.setValueAt(
					tab.getSer_t_telefone(), i, 3);
			ConsultarServidorTerceirizado.Tabela.setValueAt(
					tab.getSer_t_email(), i, 4);

			ConsultarServidorTerceirizado.Tabela.setValueAt(
					tab.getSer_t_lotacao(), i, 5);
			ConsultarServidorTerceirizado.Tabela.setValueAt(
					tab.getSer_t_matricula(), i, 6);
			ConsultarServidorTerceirizado.Tabela.setValueAt(
					tab.getSer_t_funcao(), i, 7);
			ConsultarServidorTerceirizado.Tabela.setValueAt(
					tab.getSer_t_facebook(), i, 8);
			i++;
		}
		Conexao.FecharConeao(Conexao.abrirConexao());
	}

	/**** METODO DE LISTAR SERVIDOR TERCEIRIZADO POR NOME DIGITADO ****/
	public List<ServidorTerceirizado> ListarServidorTerceirizadoNome(
			Connection con, String nome) {
		String sql = "select terc_id,empresa,nome,email,telefone,"
				+ "lotacao,matricula,funcao,facebook from serv_t where nome like '"
				+ nome + "%'";
		List<ServidorTerceirizado> lista = new ArrayList<ServidorTerceirizado>();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					ServidorTerceirizado sp = new ServidorTerceirizado();
					sp.setSer_t_id(rs.getInt(1));
					sp.setSer_t_emp_terce(rs.getString(2));
					sp.setSer_t_nome(rs.getString(3));
					sp.setSer_t_email(rs.getString(4));
					sp.setSer_t_telefone(rs.getString(5));
					sp.setSer_t_lotacao(rs.getString(6));
					sp.setSer_t_matricula(rs.getString(7));
					sp.setSer_t_funcao(rs.getString(8));
					sp.setSer_t_facebook(rs.getString(9));

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
		ServidorTerceirizado sp = new ServidorTerceirizado();
		List<ServidorTerceirizado> lista = new ArrayList<>();
		String nome = ConsultarServidorTerceirizado.campo.getText();
		lista = sp.ListarServidorTerceirizadoNome(Conexao.abrirConexao(), nome);

		if (nome.equals("")) {
			JOptionPane.showMessageDialog(null, "Digite o nome a pesquisar",
					"Coordenadoria da Juventude", JOptionPane.ERROR_MESSAGE);

		} else {
			DefaultTableModel tbm = (DefaultTableModel) ConsultarServidorTerceirizado.Tabela
					.getModel();
			while (tbm.getRowCount() > 0) {
				tbm.removeRow(0);

			}

			int i = 0;
			for (ServidorTerceirizado tab : lista) {
				tbm.addRow(new String[i]);
				ConsultarServidorTerceirizado.Tabela.setValueAt(
						tab.getSer_t_id(), i, 0);
				ConsultarServidorTerceirizado.Tabela.setValueAt(
						tab.getSer_t_emp_terce(), i, 1);
				ConsultarServidorTerceirizado.Tabela.setValueAt(
						tab.getSer_t_nome(), i, 2);
				ConsultarServidorTerceirizado.Tabela.setValueAt(
						tab.getSer_t_telefone(), i, 3);
				ConsultarServidorTerceirizado.Tabela.setValueAt(
						tab.getSer_t_email(), i, 4);
				ConsultarServidorTerceirizado.Tabela.setValueAt(
						tab.getSer_t_lotacao(), i, 5);
				ConsultarServidorTerceirizado.Tabela.setValueAt(
						tab.getSer_t_matricula(), i, 6);
				ConsultarServidorTerceirizado.Tabela.setValueAt(
						tab.getSer_t_funcao(), i, 7);
				ConsultarServidorTerceirizado.Tabela.setValueAt(
						tab.getSer_t_facebook(), i, 8);
				i++;
			}
			Conexao.FecharConeao(Conexao.abrirConexao());
		}
	}

	/**** METODO DE LISTAR SERVIDOR TERCEIRIZADO POR LOTACAO ****/
	public List<ServidorTerceirizado> ListarServidorTerceirizadoLotacao(
			Connection con, String lotacao) {
		String sql = "select terc_id,empresa,nome,email,telefone,"
				+ "lotacao,matricula,funcao,facebook from serv_t where lotacao like '"
				+ lotacao + "%'";
		List<ServidorTerceirizado> lista = new ArrayList<ServidorTerceirizado>();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					ServidorTerceirizado sp = new ServidorTerceirizado();
					sp.setSer_t_id(rs.getInt(1));
					sp.setSer_t_emp_terce(rs.getString(2));
					sp.setSer_t_nome(rs.getString(3));
					sp.setSer_t_email(rs.getString(4));
					sp.setSer_t_telefone(rs.getString(5));
					sp.setSer_t_lotacao(rs.getString(6));
					sp.setSer_t_matricula(rs.getString(7));
					sp.setSer_t_funcao(rs.getString(8));
					sp.setSer_t_facebook(rs.getString(9));


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
		ServidorTerceirizado sp = new ServidorTerceirizado();
		List<ServidorTerceirizado> lista = new ArrayList<>();
		String lotacao = ConsultarServidorTerceirizado.comboLotacao
				.getSelectedItem().toString();
		lista = sp.ListarServidorTerceirizadoLotacao(Conexao.abrirConexao(),
				lotacao);
		if (lotacao.equals("")) {
			JOptionPane.showMessageDialog(null, "Selecione uma lotação",
					"Coordenadoria da Juventude", JOptionPane.ERROR_MESSAGE);

		} else {

			DefaultTableModel tbm = (DefaultTableModel) ConsultarServidorTerceirizado.Tabela
					.getModel();
			while (tbm.getRowCount() > 0) {
				tbm.removeRow(0);

			}

			int i = 0;
			for (ServidorTerceirizado tab : lista) {
				tbm.addRow(new String[i]);
				ConsultarServidorTerceirizado.Tabela.setValueAt(
						tab.getSer_t_id(), i, 0);
				ConsultarServidorTerceirizado.Tabela.setValueAt(
						tab.getSer_t_emp_terce(), i, 1);
				ConsultarServidorTerceirizado.Tabela.setValueAt(
						tab.getSer_t_nome(), i, 2);
				ConsultarServidorTerceirizado.Tabela.setValueAt(
						tab.getSer_t_telefone(), i, 3);
				ConsultarServidorTerceirizado.Tabela.setValueAt(
						tab.getSer_t_email(), i, 4);
				ConsultarServidorTerceirizado.Tabela.setValueAt(
						tab.getSer_t_lotacao(), i, 5);
				ConsultarServidorTerceirizado.Tabela.setValueAt(
						tab.getSer_t_matricula(), i, 6);
				ConsultarServidorTerceirizado.Tabela.setValueAt(
						tab.getSer_t_funcao(), i, 7);
				ConsultarServidorTerceirizado.Tabela.setValueAt(
						tab.getSer_t_facebook(), i, 8);
				i++;
			}
			Conexao.FecharConeao(Conexao.abrirConexao());
		}
	}

	/**** METODO DE LISTAR SERVIDOR TERCEIRIZADO POR ORDEM ALFABETICA ****/
	public List<ServidorTerceirizado> ListarServidorTerceirizadoOrdem(
			Connection con) {
		String sql = "select terc_id,empresa, nome,email,telefone,"
				+ "lotacao,matricula,funcao,facebook from serv_t ORDER BY nome ASC";
		List<ServidorTerceirizado> lista = new ArrayList<ServidorTerceirizado>();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					ServidorTerceirizado sp = new ServidorTerceirizado();
					sp.setSer_t_id(rs.getInt(1));
					sp.setSer_t_emp_terce(rs.getString(2));
					sp.setSer_t_nome(rs.getString(3));
					sp.setSer_t_email(rs.getString(4));
					sp.setSer_t_telefone(rs.getString(5));
					sp.setSer_t_lotacao(rs.getString(6));
					sp.setSer_t_matricula(rs.getString(7));
					sp.setSer_t_funcao(rs.getString(8));
					sp.setSer_t_facebook(rs.getString(9));


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

	/**** METODO PARA ATUALIZAR TABLE POR ORDEM ALFABETICA ****/
	public void AtualizaTableOrdem() {
		ServidorTerceirizado sp = new ServidorTerceirizado();
		List<ServidorTerceirizado> lista = new ArrayList<>();
		lista = sp.ListarServidorTerceirizadoOrdem(Conexao.abrirConexao());

		DefaultTableModel tbm = (DefaultTableModel) ConsultarServidorTerceirizado.Tabela
				.getModel();
		while (tbm.getRowCount() > 0) {
			tbm.removeRow(0);

		}

		int i = 0;
		for (ServidorTerceirizado tab : lista) {
			tbm.addRow(new String[i]);
			ConsultarServidorTerceirizado.Tabela.setValueAt(tab.getSer_t_id(),
					i, 0);
			ConsultarServidorTerceirizado.Tabela.setValueAt(
					tab.getSer_t_emp_terce(), i, 1);
			ConsultarServidorTerceirizado.Tabela.setValueAt(
					tab.getSer_t_nome(), i, 2);
			ConsultarServidorTerceirizado.Tabela.setValueAt(
					tab.getSer_t_telefone(), i, 3);
			ConsultarServidorTerceirizado.Tabela.setValueAt(
					tab.getSer_t_email(), i, 4);
			ConsultarServidorTerceirizado.Tabela.setValueAt(
					tab.getSer_t_lotacao(), i, 5);
			ConsultarServidorTerceirizado.Tabela.setValueAt(
					tab.getSer_t_matricula(), i, 6);
			ConsultarServidorTerceirizado.Tabela.setValueAt(
					tab.getSer_t_funcao(), i, 7);
			ConsultarServidorTerceirizado.Tabela.setValueAt(
					tab.getSer_t_facebook(), i, 8);
			i++;
		}
		Conexao.FecharConeao(Conexao.abrirConexao());
	}

	/****
	 * AÇÃO DO BOTAO VOLTAR CONSULTAR SERVIDOR TERCEIRIZADO
	 * 
	 * @throws ParseException
	 ****/
	public void BotaoVoltarConsultarServidorTerceirizado() {
		new MenuServidorTerceirizado().setVisible(true);
		ConsultarServidorTerceirizado.Tela.setVisible(false);
	}

	/**** METODOS REFERENTES A TELA DE DELETAR ****/
	/**** METODO DE LISTAR COMBO SERVIDOR TERCEIRIZADO ****/
	public List<ServidorTerceirizado> ListarComboServidorTerceirizado(
			ServidorTerceirizado st2, Connection con) {
		String lotacao = DeletarServidorTerceirizado.combo.getSelectedItem()
				.toString();
		st2.setSer_t_lotacao(lotacao);
		String sql = "Select nome from serv_t where lotacao = ?  ORDER BY nome ASC ";
		List<ServidorTerceirizado> lista = new ArrayList<>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, st2.getSer_t_lotacao());
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					ServidorTerceirizado st = new ServidorTerceirizado();
					st.setSer_t_nome(rs.getString(1));
					lista.add(st);

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
		String lotacao = DeletarServidorTerceirizado.combo.getSelectedItem()
				.toString();
		if (lotacao.equals("")) {
			JOptionPane.showMessageDialog(null, "Selecione uma lotação",
					"Coordenadoria da Juventude", JOptionPane.ERROR_MESSAGE);

		} else {
			ServidorTerceirizado st = new ServidorTerceirizado();
			DeletarServidorTerceirizado.combo1.removeAllItems();
			List<ServidorTerceirizado> lista = new ArrayList<>();
			lista = st.ListarComboServidorTerceirizado(st,
					Conexao.abrirConexao());
			DeletarServidorTerceirizado.combo1.addItem("");

			for (ServidorTerceirizado a : lista) {

				DeletarServidorTerceirizado.combo1.addItem(a.getSer_t_nome());

			}
		}
		Conexao.FecharConeao(Conexao.abrirConexao());
	}

	/**** METODO PARA DELETAR SERVIDOR TERCEIRIZADO ****/
	public void ExcluirServidorTerceirizado(Connection con,
			ServidorTerceirizado st) {
		String nome = DeletarServidorTerceirizado.combo1.getSelectedItem()
				.toString();

		st.setSer_t_nome(nome);
		String sql = "delete from serv_t where nome =?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, st.getSer_t_nome());
			if (ps.executeUpdate() > 0) {
				JOptionPane.showMessageDialog(null, "Deletado com Sucesso",
						"Coordenadoria da Juventude",
						JOptionPane.INFORMATION_MESSAGE);
				// DeletarServidorPublico.combo1.removeAllItems();
				st.AcaoBotaoOk();
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

	/**** ACAO DO BOTAO DELETAR SERVIDOR TERCEIRIZADO ****/
	public void AcaodoBotaoDeletarServidorTerceirizado() {
		try {
			ServidorTerceirizado st = new ServidorTerceirizado();
			String nome = DeletarServidorTerceirizado.combo1.getSelectedItem()
					.toString();
			String lotacao = DeletarServidorTerceirizado.combo
					.getSelectedItem().toString();
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
					st.ExcluirServidorTerceirizado(Conexao.abrirConexao(), st);
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
	 * AÇÃO DO BOTAO VOLTAR DELETAR SERVIDOR TERCEIRIZADO
	 * 
	 * @throws ParseException
	 ****/
	public void BotaoVoltarDeletarServidorTerceirizado() {
		new MenuServidorTerceirizado().setVisible(true);
		DeletarServidorTerceirizado.Tela.setVisible(false);
	}
}
