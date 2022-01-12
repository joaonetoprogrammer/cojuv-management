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

import Visao.Atualizar.AtualizarGrupos;
import Visao.Cadastrar.CadastrarGrupos;
import Visao.Consultar.ConsultarGrupos;
import Visao.Deletar.DeletarGrupos;
import Visao.Principal.MenuGrupos;

public class Grupos {

	private int id;
	private String grupo;
	private String identidade;
	private String fundacao;
	private String diasDeEncontro;
	private String horarioDeEncontro;
	private String local;
	private String bairro;
	private String comunidade;
	private String entidade;
	private String responsavel;
	private String telefone_res;
	private String coordenador;
	private String email;
	private String facebook;
	private String cel_Coordenador;
	private String atividades;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public String getIdentidade() {
		return identidade;
	}

	public void setIdentidade(String identidade) {
		this.identidade = identidade;
	}

	public String getFundacao() {
		return fundacao;
	}

	public void setFundacao(String fundacao) {
		this.fundacao = fundacao;
	}

	public String getDiasDeEncontro() {
		return diasDeEncontro;
	}

	public void setDiasDeEncontro(String diasDeEncontro) {
		this.diasDeEncontro = diasDeEncontro;
	}

	public String getHorarioDeEncontro() {
		return horarioDeEncontro;
	}

	public void setHorarioDeEncontro(String horarioDeEncontro) {
		this.horarioDeEncontro = horarioDeEncontro;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getComunidade() {
		return comunidade;
	}

	public void setComunidade(String comunidade) {
		this.comunidade = comunidade;
	}

	public String getEntidade() {
		return entidade;
	}

	public void setEntidade(String entidade) {
		this.entidade = entidade;
	}

	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	public String getTelefone_res() {
		return telefone_res;
	}

	public void setTelefone_res(String telefone_res) {
		this.telefone_res = telefone_res;
	}

	public String getCoordenador() {
		return coordenador;
	}

	public void setCoordenador(String coordenador) {
		this.coordenador = coordenador;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public String getCel_Coordenador() {
		return cel_Coordenador;
	}

	public void setCel_Coordenador(String cel_Coordenador) {
		this.cel_Coordenador = cel_Coordenador;
	}

	public String getAtividades() {
		return atividades;
	}

	public void setAtividades(String atividades) {
		this.atividades = atividades;
	}

	/** ---------------METODOS REFERERENTES A TELA DE CADASTRAR--------------- **/
	/**** METODO DE CADASTRO DE GRUPOS ****/
	public void InserirGrupo(Grupos g, Connection con) {

		String sql = "insert into gru values(0,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, g.getGrupo());
			ps.setString(2, g.getFundacao());
			ps.setString(3, g.getIdentidade());
			ps.setString(4, g.getDiasDeEncontro());
			ps.setString(5, g.getHorarioDeEncontro());
			ps.setString(6, g.getLocal());
			ps.setString(7, g.getBairro());
			ps.setString(8, g.getComunidade());
			ps.setString(9, g.getEntidade());
			ps.setString(10, g.getResponsavel());
			ps.setString(11, g.getTelefone_res());
			ps.setString(12, g.getCoordenador());
			ps.setString(13, g.getEmail());
			ps.setString(14, g.getFacebook());
			ps.setString(15, g.getCel_Coordenador());
			ps.setString(16, g.getAtividades());

			if (ps.executeUpdate() > 0) {
				JOptionPane.showMessageDialog(null,
						"Cadastro Realizado com Sucesso",
						"Coordenadoria da Juventude",
						JOptionPane.INFORMATION_MESSAGE);

				Conexao.FecharConeao(Conexao.abrirConexao());
				CadastrarGrupos.tgrupo.setText("");
				CadastrarGrupos.tfundacao.setText("");
				CadastrarGrupos.tidentidade.setText("");
				CadastrarGrupos.tdiasDeEncontro.setText("");
				CadastrarGrupos.tHorarioDeEncontro.setText("");
				CadastrarGrupos.tlocal.setText("");
				CadastrarGrupos.tbairro.setText("");
				CadastrarGrupos.tcomunidade.setText("");
				CadastrarGrupos.tentidade.setText("");
				CadastrarGrupos.tresponsavel.setText("");
				CadastrarGrupos.ttel_responsavel.setText("");
				CadastrarGrupos.tcoordenador.setText("");
				CadastrarGrupos.temail.setText("");
				CadastrarGrupos.tfacebook.setText("");
				CadastrarGrupos.tcel_coordenador.setText("");
				CadastrarGrupos.tatividade.setText("");

			} else {
				JOptionPane.showMessageDialog(null, "Erro ao Inserir");
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,
					e.getMessage());
		}

	}

	/****
	 * AÇÃO DO BOTAO CONFIRMAR CADSATRAR GRUPOS
	 * 
	 * @throws ParseException
	 ****/
	public void BotaoCadastrarGrupo() {
		String grupo = CadastrarGrupos.tgrupo.getText();
		String fundacao = CadastrarGrupos.tfundacao.getText();
		String identidade = CadastrarGrupos.tidentidade.getText();
		String dias = CadastrarGrupos.tdiasDeEncontro.getText();
		String hora = CadastrarGrupos.tHorarioDeEncontro.getText();
		String local = CadastrarGrupos.tlocal.getText();
		String bairro = CadastrarGrupos.tbairro.getText();
		String comunidade = CadastrarGrupos.tcomunidade.getText();
		String entidade = CadastrarGrupos.tentidade.getText();
		String res = CadastrarGrupos.tresponsavel.getText();
		String tel_res = CadastrarGrupos.ttel_responsavel.getText();
		String coordenador = CadastrarGrupos.tcoordenador.getText();
		String email = CadastrarGrupos.temail.getText();
		String facebook = CadastrarGrupos.tfacebook.getText();
		String cel = CadastrarGrupos.tcel_coordenador.getText();
		String atividade = CadastrarGrupos.tatividade.getText();

		if (grupo.equals("") || fundacao.equals("              /  /    ")
				|| identidade.equals("") || dias.equals("")
				|| hora.equals("         :  ") || local.equals("")
				|| bairro.equals("") || comunidade.equals("")
				|| entidade.equals("") || res.equals("")
				|| tel_res.equals("(  )    -    ") || coordenador.equals("")
				|| email.equals("") || facebook.equals("")
				|| cel.equals("(  )    -    ") || atividade.equals("")) {
			JOptionPane.showMessageDialog(null,
					"Nenhum campo pode estar vazio",
					"Coordenadoria da Juventude", JOptionPane.WARNING_MESSAGE);

		} else {

			Grupos g = new Grupos();
			g.setGrupo(grupo);
			g.setFundacao(fundacao);
			g.setIdentidade(identidade);
			g.setDiasDeEncontro(dias);
			g.setHorarioDeEncontro(hora);
			g.setLocal(local);
			g.setBairro(bairro);
			g.setComunidade(comunidade);
			g.setEntidade(entidade);
			g.setResponsavel(res);
			g.setTelefone_res(tel_res);
			g.setCoordenador(coordenador);
			g.setEmail(email);
			g.setFacebook(facebook);
			g.setCel_Coordenador(cel);
			g.setAtividades(atividade);

			g.InserirGrupo(g, Conexao.abrirConexao());

		}

	}

	// AÇÃO DO BOTAO VOLTAR CADASTRAR GRUPOS
	public void BotaoVoltarCadastrarGrupos() {
		new MenuGrupos().setVisible(true);
		CadastrarGrupos.Tela.setVisible(false);
	}

	/** ---------------METODOS REFERERENTES A TELA DE ATUALIZAR--------------- **/
	/**** METODO PARA TESTAR GRUPOS ****/
	public boolean TestarGrupos(Connection con) {
		String co = AtualizarGrupos.codigo1.getText();
		int cod = Integer.parseInt(co);
		boolean resultado = false;
		try {
			String sql = "select * from gru where gru_id = " + cod + "";
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

	/**** METODO PARA CAPTURAR GRUPOS ****/
	public void CapturarGrupo(Grupos g, Connection con) {
		String co = AtualizarGrupos.codigo1.getText();
		int cod = Integer.parseInt(co);
		String sql = "select * from gru where gru_id =" + cod + "";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					g.setId(rs.getInt(1));
					g.setGrupo(rs.getString(2));
					g.setFundacao(rs.getString(3));
					g.setIdentidade(rs.getString(4));
					g.setDiasDeEncontro(rs.getString(5));
					g.setHorarioDeEncontro(rs.getString(6));
					g.setLocal(rs.getString(7));
					g.setBairro(rs.getString(8));
					g.setComunidade(rs.getString(9));
					g.setEntidade(rs.getString(10));
					g.setResponsavel(rs.getString(11));
					g.setTelefone_res(rs.getString(12));
					g.setCoordenador(rs.getString(13));
					g.setEmail(rs.getString(14));
					g.setFacebook(rs.getString(15));
					g.setCel_Coordenador(rs.getString(16));
					g.setAtividades(rs.getString(17));

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

	/**** METODO PARA ALTERAR GRUPOS ****/
	@SuppressWarnings("deprecation")
	public void AlterarGrupo(Grupos g, Connection con) {
		String sql = "update gru set grupo=?,fund=?,ident=?,"
				+ "dias=?,hora=?,local=?,bairro=?,comu=?,"
				+ "enti=?,resp=?,tel_res=?,coord=?,email=?,"
				+ "face=?,cel=?,ati=? where gru_id = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, g.getGrupo());
			ps.setString(2, g.getFundacao());
			ps.setString(3, g.getIdentidade());
			ps.setString(4, g.getDiasDeEncontro());
			ps.setString(5, g.getHorarioDeEncontro());
			ps.setString(6, g.getLocal());
			ps.setString(7, g.getBairro());
			ps.setString(8, g.getComunidade());
			ps.setString(9, g.getEntidade());
			ps.setString(10, g.getResponsavel());
			ps.setString(11, g.getTelefone_res());
			ps.setString(12, g.getCoordenador());
			ps.setString(13, g.getEmail());
			ps.setString(14, g.getFacebook());
			ps.setString(15, g.getCel_Coordenador());
			ps.setString(16, g.getAtividades());
			ps.setInt(17, g.getId());

			if (ps.executeUpdate() > 0) {

				JOptionPane.showMessageDialog(null,
						"Atualização realizada com sucesso",
						"Coordenadoria da Juventude",
						JOptionPane.INFORMATION_MESSAGE);
				Conexao.FecharConeao(Conexao.abrirConexao());
				AtualizarGrupos.tgrupo.setText("");
				AtualizarGrupos.tfundacao.setText("");
				AtualizarGrupos.tidentidade.setText("");
				AtualizarGrupos.tdiasDeEncontro.setText("");
				AtualizarGrupos.tHorarioDeEncontro.setText("");
				AtualizarGrupos.tlocal.setText("");
				AtualizarGrupos.tbairro.setText("");
				AtualizarGrupos.tcomunidade.setText("");
				AtualizarGrupos.tentidade.setText("");
				AtualizarGrupos.tresponsavel.setText("");
				AtualizarGrupos.ttel_responsavel.setText("");
				AtualizarGrupos.tcoordenador.setText("");
				AtualizarGrupos.temail.setText("");
				AtualizarGrupos.tfacebook.setText("");
				AtualizarGrupos.tcel_coordenador.setText("");
				AtualizarGrupos.tatividade.setText("");

				AtualizarGrupos.codigo1.setText("");
				AtualizarGrupos.codigo1.enable();
				AtualizarGrupos.tgrupo.disable();
				AtualizarGrupos.tfundacao.disable();
				AtualizarGrupos.tidentidade.disable();
				AtualizarGrupos.tdiasDeEncontro.disable();
				AtualizarGrupos.tHorarioDeEncontro.disable();
				AtualizarGrupos.tlocal.disable();
				AtualizarGrupos.tbairro.disable();
				AtualizarGrupos.tcomunidade.disable();
				AtualizarGrupos.tentidade.disable();
				AtualizarGrupos.tresponsavel.disable();
				AtualizarGrupos.ttel_responsavel.disable();
				AtualizarGrupos.tcoordenador.disable();
				AtualizarGrupos.temail.disable();
				AtualizarGrupos.tfacebook.disable();
				AtualizarGrupos.tcel_coordenador.disable();
				AtualizarGrupos.tatividade.disable();

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

	/**** METODO PARA INSERIR DADOS GRUPOS ****/
	@SuppressWarnings("deprecation")
	public void InseririDadosGrupo(Grupos g) {
		AtualizarGrupos.tgrupo.enable();
		AtualizarGrupos.tfundacao.enable();
		AtualizarGrupos.tidentidade.enable();
		AtualizarGrupos.tdiasDeEncontro.enable();
		AtualizarGrupos.tHorarioDeEncontro.enable();
		AtualizarGrupos.tlocal.enable();
		AtualizarGrupos.tbairro.enable();
		AtualizarGrupos.tcomunidade.enable();
		AtualizarGrupos.tentidade.enable();
		AtualizarGrupos.tresponsavel.enable();
		AtualizarGrupos.ttel_responsavel.enable();
		AtualizarGrupos.tcoordenador.enable();
		AtualizarGrupos.temail.enable();
		AtualizarGrupos.tfacebook.enable();
		AtualizarGrupos.tcel_coordenador.enable();
		AtualizarGrupos.tatividade.enable();

		AtualizarGrupos.tgrupo.setText("" + g.getGrupo());
		AtualizarGrupos.tfundacao.setText("" + g.getFundacao());
		AtualizarGrupos.tidentidade.setText("" + g.getIdentidade());
		AtualizarGrupos.tdiasDeEncontro.setText("" + g.getDiasDeEncontro());
		AtualizarGrupos.tHorarioDeEncontro.setText(""
				+ g.getHorarioDeEncontro());
		AtualizarGrupos.tlocal.setText("" + g.getLocal());
		AtualizarGrupos.tbairro.setText("" + g.getBairro());
		AtualizarGrupos.tcomunidade.setText("" + g.getComunidade());
		AtualizarGrupos.tentidade.setText("" + g.getEntidade());
		AtualizarGrupos.tresponsavel.setText("" + g.getResponsavel());
		AtualizarGrupos.ttel_responsavel.setText("" + g.getTelefone_res());
		AtualizarGrupos.tcoordenador.setText("" + g.getCoordenador());
		AtualizarGrupos.temail.setText("" + g.getEmail());
		AtualizarGrupos.tfacebook.setText("" + g.getFacebook());
		AtualizarGrupos.tcel_coordenador.setText("" + g.getCel_Coordenador());
		AtualizarGrupos.tatividade.setText("" + g.getAtividades());

	}

	/**** ACAO DO BOTAO OK ****/
	@SuppressWarnings("deprecation")
	public void AcaoDoBotaoOkGrupos() {
		String ok = AtualizarGrupos.codigo1.getText();
		Grupos g = new Grupos();
		try {
			if (ok.equals("")) {
				JOptionPane.showMessageDialog(null,
						"Digite o código para atualizar",
						"Coordenadoria da Juventude",
						JOptionPane.WARNING_MESSAGE);
			} else if (g.TestarGrupos(Conexao.abrirConexao()) == false) {
				JOptionPane
						.showMessageDialog(null, "Código não encontrado",
								"Coordenadoria da Juventude",
								JOptionPane.ERROR_MESSAGE);
				Conexao.FecharConeao(Conexao.abrirConexao());

			} else if (g.TestarGrupos(Conexao.abrirConexao()) == true) {
				AtualizarGrupos.tgrupo.setText("");
				AtualizarGrupos.tfundacao.setText("");
				AtualizarGrupos.tidentidade.setText("");
				AtualizarGrupos.tdiasDeEncontro.setText("");
				AtualizarGrupos.tHorarioDeEncontro.setText("");
				AtualizarGrupos.tlocal.setText("");
				AtualizarGrupos.tbairro.setText("");
				AtualizarGrupos.tcomunidade.setText("");
				AtualizarGrupos.tentidade.setText("");
				AtualizarGrupos.tresponsavel.setText("");
				AtualizarGrupos.ttel_responsavel.setText("");
				AtualizarGrupos.tcoordenador.setText("");
				AtualizarGrupos.temail.setText("");
				AtualizarGrupos.tfacebook.setText("");
				AtualizarGrupos.tcel_coordenador.setText("");
				AtualizarGrupos.tatividade.setText("");
				g.CapturarGrupo(g, Conexao.abrirConexao());
				Conexao.FecharConeao(Conexao.abrirConexao());
				g.InseririDadosGrupo(g);

				AtualizarGrupos.codigo1.disable();
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "O código só possui números",
					"Coordenadoria da Juventude", JOptionPane.WARNING_MESSAGE);

		}
	}

	/**** ACAO DO BOTAO ALTERAR SERVIDOR PUBLICO ****/
	public void AcaoDoBotaoAlterarGrupos() {

		String codigo = AtualizarGrupos.codigo1.getText();
		String grupo = AtualizarGrupos.tgrupo.getText();
		String fundacao = AtualizarGrupos.tfundacao.getText();
		String identidade = AtualizarGrupos.tidentidade.getText();
		String dias = AtualizarGrupos.tdiasDeEncontro.getText();
		String hora = AtualizarGrupos.tHorarioDeEncontro.getText();
		String local = AtualizarGrupos.tlocal.getText();
		String bairro = AtualizarGrupos.tbairro.getText();
		String comunidade = AtualizarGrupos.tcomunidade.getText();
		String entidade = AtualizarGrupos.tentidade.getText();
		String res = AtualizarGrupos.tresponsavel.getText();
		String tel_res = AtualizarGrupos.ttel_responsavel.getText();
		String coordenador = AtualizarGrupos.tcoordenador.getText();
		String email = AtualizarGrupos.temail.getText();
		String facebook = AtualizarGrupos.tfacebook.getText();
		String cel = AtualizarGrupos.tcel_coordenador.getText();
		String atividade = AtualizarGrupos.tatividade.getText();

		if (grupo.equals("") || fundacao.equals("              /  /    ")
				|| identidade.equals("") || dias.equals("")
				|| hora.equals("         :  ") || local.equals("")
				|| bairro.equals("") || comunidade.equals("")
				|| entidade.equals("") || res.equals("")
				|| tel_res.equals("(  )    -    ") || coordenador.equals("")
				|| email.equals("") || facebook.equals("")
				|| cel.equals("(  )    -    ") || atividade.equals("")) {
			JOptionPane.showMessageDialog(null,
					"Nenhum campo pode estar vazio",
					"Coordenadoria da Juventude", JOptionPane.WARNING_MESSAGE);

		} else {
			int cod = Integer.parseInt(codigo);
			Grupos g = new Grupos();
			g.setId(cod);
			g.setGrupo(grupo);
			g.setFundacao(fundacao);
			g.setIdentidade(identidade);
			g.setDiasDeEncontro(dias);
			g.setHorarioDeEncontro(hora);
			g.setLocal(local);
			g.setBairro(bairro);
			g.setComunidade(comunidade);
			g.setEntidade(entidade);
			g.setResponsavel(res);
			g.setTelefone_res(tel_res);
			g.setCoordenador(coordenador);
			g.setEmail(email);
			g.setFacebook(facebook);
			g.setCel_Coordenador(cel);
			g.setAtividades(atividade);

			g.AlterarGrupo(g, Conexao.abrirConexao());

		}
	}

	// AÇÃO DO BOTAO VOLTAR ATUALIZAR GRUPOS

	public void BotaoVoltarAtualizarGrupos() {
		new MenuGrupos().setVisible(true);
		AtualizarGrupos.Tela.setVisible(false);
	}

	/***** METODOS REFERENTES A TELA DE CONSULTARR ******/
	/**** METODO DE LISTAR GRUPOS POR CODIGO ****/
	public List<Grupos> ListarGruposCodigo(Connection con) {
		String sql = "select gru_id,grupo,fund,ident,"
				+ "dias,hora,local,bairro,comu,"
				+ "enti,resp,tel_res,coord,email," + "face,cel,ati from gru";
		List<Grupos> lista = new ArrayList<Grupos>();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					Grupos g = new Grupos();
					g.setId(rs.getInt(1));
					g.setGrupo(rs.getString(2));
					g.setFundacao(rs.getString(3));
					g.setIdentidade(rs.getString(4));
					g.setDiasDeEncontro(rs.getString(5));
					g.setHorarioDeEncontro(rs.getString(6));
					g.setLocal(rs.getString(7));
					g.setBairro(rs.getString(8));
					g.setComunidade(rs.getString(9));
					g.setEntidade(rs.getString(10));
					g.setResponsavel(rs.getString(11));
					g.setTelefone_res(rs.getString(12));
					g.setCoordenador(rs.getString(13));
					g.setEmail(rs.getString(14));
					g.setFacebook(rs.getString(15));
					g.setCel_Coordenador(rs.getString(16));
					g.setAtividades(rs.getString(17));

					lista.add(g);
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
		Grupos g = new Grupos();
		List<Grupos> lista = new ArrayList<>();
		lista = g.ListarGruposCodigo(Conexao.abrirConexao());

		DefaultTableModel tbm = (DefaultTableModel) ConsultarGrupos.Tabela
				.getModel();
		while (tbm.getRowCount() > 0) {
			tbm.removeRow(0);

		}

		int i = 0;
		for (Grupos tab : lista) {
			tbm.addRow(new String[i]);
			ConsultarGrupos.Tabela.setValueAt(tab.getId(), i, 0);
			ConsultarGrupos.Tabela.setValueAt(tab.getGrupo(), i, 1);
			ConsultarGrupos.Tabela.setValueAt(tab.getFundacao(), i, 2);
			ConsultarGrupos.Tabela.setValueAt(tab.getIdentidade(), i, 3);
			ConsultarGrupos.Tabela.setValueAt(tab.getDiasDeEncontro(), i, 4);
			ConsultarGrupos.Tabela.setValueAt(tab.getHorarioDeEncontro(), i, 5);
			ConsultarGrupos.Tabela.setValueAt(tab.getLocal(), i, 6);
			ConsultarGrupos.Tabela.setValueAt(tab.getBairro(), i, 7);
			ConsultarGrupos.Tabela.setValueAt(tab.getComunidade(), i, 8);
			ConsultarGrupos.Tabela.setValueAt(tab.getEntidade(), i, 9);
			ConsultarGrupos.Tabela.setValueAt(tab.getResponsavel(), i, 10);
			ConsultarGrupos.Tabela.setValueAt(tab.getTelefone_res(), i, 11);
			ConsultarGrupos.Tabela.setValueAt(tab.getCoordenador(), i, 12);
			ConsultarGrupos.Tabela.setValueAt(tab.getEmail(), i, 13);
			ConsultarGrupos.Tabela.setValueAt(tab.getFacebook(), i, 14);
			ConsultarGrupos.Tabela.setValueAt(tab.getCel_Coordenador(), i, 15);
			ConsultarGrupos.Tabela.setValueAt(tab.getAtividades(), i, 16);

			i++;
		}
		Conexao.FecharConeao(Conexao.abrirConexao());
	}

	/**** METODO DE LISTAR GRUPOS POR NOME DIGITADO ****/
	public List<Grupos> ListarGruposNome(Connection con, String grupo) {
		String sql = "select gru_id,grupo,fund,ident,"
				+ "dias,hora,local,bairro,comu,"
				+ "enti,resp,tel_res,coord,email,"
				+ "face,cel,ati from gru where grupo like '" + grupo + "%'";
		List<Grupos> lista = new ArrayList<Grupos>();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					Grupos g = new Grupos();
					g.setId(rs.getInt(1));
					g.setGrupo(rs.getString(2));
					g.setFundacao(rs.getString(3));
					g.setIdentidade(rs.getString(4));
					g.setDiasDeEncontro(rs.getString(5));
					g.setHorarioDeEncontro(rs.getString(6));
					g.setLocal(rs.getString(7));
					g.setBairro(rs.getString(8));
					g.setComunidade(rs.getString(9));
					g.setEntidade(rs.getString(10));
					g.setResponsavel(rs.getString(11));
					g.setTelefone_res(rs.getString(12));
					g.setCoordenador(rs.getString(13));
					g.setEmail(rs.getString(14));
					g.setFacebook(rs.getString(15));
					g.setCel_Coordenador(rs.getString(16));
					g.setAtividades(rs.getString(17));

					lista.add(g);
				}
				return lista;
			} else {
				return null;
			}

		} catch (SQLException e) {
			return null;
		}
	}

	/**** METODO PARA ATUALIZAR TABLE POR GRUPO DIGITADO ****/
	public void AtualizaTableGrupo() {
		Grupos g = new Grupos();
		List<Grupos> lista = new ArrayList<>();
		String grupo = ConsultarGrupos.campo.getText();
		lista = g.ListarGruposNome(Conexao.abrirConexao(), grupo);

		if (grupo.equals("")) {
			JOptionPane.showMessageDialog(null, "Digite o nome a pesquisar",
					"Coordenadoria da Juventude", JOptionPane.ERROR_MESSAGE);

		} else {
			DefaultTableModel tbm = (DefaultTableModel) ConsultarGrupos.Tabela
					.getModel();
			while (tbm.getRowCount() > 0) {
				tbm.removeRow(0);

			}

			int i = 0;
			for (Grupos tab : lista) {
				tbm.addRow(new String[i]);
				ConsultarGrupos.Tabela.setValueAt(tab.getId(), i, 0);
				ConsultarGrupos.Tabela.setValueAt(tab.getGrupo(), i, 1);
				ConsultarGrupos.Tabela.setValueAt(tab.getFundacao(), i, 2);
				ConsultarGrupos.Tabela.setValueAt(tab.getIdentidade(), i, 3);
				ConsultarGrupos.Tabela
						.setValueAt(tab.getDiasDeEncontro(), i, 4);
				ConsultarGrupos.Tabela.setValueAt(tab.getHorarioDeEncontro(),
						i, 5);
				ConsultarGrupos.Tabela.setValueAt(tab.getLocal(), i, 6);
				ConsultarGrupos.Tabela.setValueAt(tab.getBairro(), i, 7);
				ConsultarGrupos.Tabela.setValueAt(tab.getComunidade(), i, 8);
				ConsultarGrupos.Tabela.setValueAt(tab.getEntidade(), i, 9);
				ConsultarGrupos.Tabela.setValueAt(tab.getResponsavel(), i, 10);
				ConsultarGrupos.Tabela.setValueAt(tab.getTelefone_res(), i, 11);
				ConsultarGrupos.Tabela.setValueAt(tab.getCoordenador(), i, 12);
				ConsultarGrupos.Tabela.setValueAt(tab.getEmail(), i, 13);
				ConsultarGrupos.Tabela.setValueAt(tab.getFacebook(), i, 14);
				ConsultarGrupos.Tabela.setValueAt(tab.getCel_Coordenador(), i,
						15);
				ConsultarGrupos.Tabela.setValueAt(tab.getAtividades(), i, 16);


				i++;

			}
			Conexao.FecharConeao(Conexao.abrirConexao());
		}
	}

	/**** METODO DE LISTAR GRUPOS POR ORDEM ALFABETICA ****/
	public List<Grupos> ListarGrupoOrdem(Connection con) {
		String sql = "select gru_id,grupo,fund,ident,"
				+ "dias,hora,local,bairro,comu,"
				+ "enti,resp,tel_res,coord,email,"
				+ "face,cel,ati from gru OrDER BY grupo ASC";
		List<Grupos> lista = new ArrayList<Grupos>();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					Grupos g = new Grupos();
					g.setId(rs.getInt(1));
					g.setGrupo(rs.getString(2));
					g.setFundacao(rs.getString(3));
					g.setIdentidade(rs.getString(4));
					g.setDiasDeEncontro(rs.getString(5));
					g.setHorarioDeEncontro(rs.getString(6));
					g.setLocal(rs.getString(7));
					g.setBairro(rs.getString(8));
					g.setComunidade(rs.getString(9));
					g.setEntidade(rs.getString(10));
					g.setResponsavel(rs.getString(11));
					g.setTelefone_res(rs.getString(12));
					g.setCoordenador(rs.getString(13));
					g.setEmail(rs.getString(14));
					g.setFacebook(rs.getString(15));
					g.setCel_Coordenador(rs.getString(16));
					g.setAtividades(rs.getString(17));

					lista.add(g);
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
		Grupos g = new Grupos();
		List<Grupos> lista = new ArrayList<>();
		lista = g.ListarGrupoOrdem(Conexao.abrirConexao());

		DefaultTableModel tbm = (DefaultTableModel) ConsultarGrupos.Tabela
				.getModel();
		while (tbm.getRowCount() > 0) {
			tbm.removeRow(0);

		}

		int i = 0;
		for (Grupos tab : lista) {
			tbm.addRow(new String[i]);
			ConsultarGrupos.Tabela.setValueAt(tab.getId(), i, 0);
			ConsultarGrupos.Tabela.setValueAt(tab.getGrupo(), i, 1);
			ConsultarGrupos.Tabela.setValueAt(tab.getFundacao(), i, 2);
			ConsultarGrupos.Tabela.setValueAt(tab.getIdentidade(), i, 3);
			ConsultarGrupos.Tabela.setValueAt(tab.getDiasDeEncontro(), i, 4);
			ConsultarGrupos.Tabela.setValueAt(tab.getHorarioDeEncontro(), i, 5);
			ConsultarGrupos.Tabela.setValueAt(tab.getLocal(), i, 6);
			ConsultarGrupos.Tabela.setValueAt(tab.getBairro(), i, 7);
			ConsultarGrupos.Tabela.setValueAt(tab.getComunidade(), i, 8);
			ConsultarGrupos.Tabela.setValueAt(tab.getEntidade(), i, 9);
			ConsultarGrupos.Tabela.setValueAt(tab.getResponsavel(), i, 10);
			ConsultarGrupos.Tabela.setValueAt(tab.getTelefone_res(), i, 11);
			ConsultarGrupos.Tabela.setValueAt(tab.getCoordenador(), i, 12);
			ConsultarGrupos.Tabela.setValueAt(tab.getEmail(), i, 13);
			ConsultarGrupos.Tabela.setValueAt(tab.getFacebook(), i, 14);
			ConsultarGrupos.Tabela.setValueAt(tab.getCel_Coordenador(), i, 15);
			ConsultarGrupos.Tabela.setValueAt(tab.getAtividades(), i, 16);

			i++;

		}
		Conexao.FecharConeao(Conexao.abrirConexao());
	}

	/**** METODO DE LISTAR GRUPOS POR IDENTIDADE ****/
	public List<Grupos> ListarGrupoIdentidade(Connection con, String identidade) {
		String sql = "select gru_id,grupo,fund,ident,"
				+ "dias,hora,local,bairro,comu,"
				+ "enti,resp,tel_res,coord,email,"
				+ "face,cel,ati from gru where ident like '" + identidade
				+ "%'";
		List<Grupos> lista = new ArrayList<Grupos>();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					Grupos g = new Grupos();
					g.setId(rs.getInt(1));
					g.setGrupo(rs.getString(2));
					g.setFundacao(rs.getString(3));
					g.setIdentidade(rs.getString(4));
					g.setDiasDeEncontro(rs.getString(5));
					g.setHorarioDeEncontro(rs.getString(6));
					g.setLocal(rs.getString(7));
					g.setBairro(rs.getString(8));
					g.setComunidade(rs.getString(9));
					g.setEntidade(rs.getString(10));
					g.setResponsavel(rs.getString(11));
					g.setTelefone_res(rs.getString(12));
					g.setCoordenador(rs.getString(13));
					g.setEmail(rs.getString(14));
					g.setFacebook(rs.getString(15));
					g.setCel_Coordenador(rs.getString(16));
					g.setAtividades(rs.getString(17));

					lista.add(g);
				}
				return lista;
			} else {
				return null;
			}

		} catch (SQLException e) {
			return null;
		}
	}

	/**** METODO PARA ATUALIZAR TABLE POR IDENTIDADE SELECIONADA ****/
	public void AtualizaTableIdentidade() {
		Grupos g = new Grupos();
		List<Grupos> lista = new ArrayList<>();
		String identidade = ConsultarGrupos.entidade.getText();
		lista = g.ListarGrupoIdentidade(Conexao.abrirConexao(), identidade);
		if (identidade.equals("")) {
			JOptionPane.showMessageDialog(null, "Digite a identidade do grupo",
					"Coordenadoria da Juventude", JOptionPane.ERROR_MESSAGE);

		} else {

			DefaultTableModel tbm = (DefaultTableModel) ConsultarGrupos.Tabela
					.getModel();
			while (tbm.getRowCount() > 0) {
				tbm.removeRow(0);

			}

			int i = 0;
			for (Grupos tab : lista) {
				tbm.addRow(new String[i]);
				ConsultarGrupos.Tabela.setValueAt(tab.getId(), i, 0);
				ConsultarGrupos.Tabela.setValueAt(tab.getGrupo(), i, 1);
				ConsultarGrupos.Tabela.setValueAt(tab.getFundacao(), i, 2);
				ConsultarGrupos.Tabela.setValueAt(tab.getIdentidade(), i, 3);
				ConsultarGrupos.Tabela
						.setValueAt(tab.getDiasDeEncontro(), i, 4);
				ConsultarGrupos.Tabela.setValueAt(tab.getHorarioDeEncontro(),
						i, 5);
				ConsultarGrupos.Tabela.setValueAt(tab.getLocal(), i, 6);
				ConsultarGrupos.Tabela.setValueAt(tab.getBairro(), i, 7);
				ConsultarGrupos.Tabela.setValueAt(tab.getComunidade(), i, 8);
				ConsultarGrupos.Tabela.setValueAt(tab.getEntidade(), i, 9);
				ConsultarGrupos.Tabela.setValueAt(tab.getResponsavel(), i, 10);
				ConsultarGrupos.Tabela.setValueAt(tab.getTelefone_res(), i, 11);
				ConsultarGrupos.Tabela.setValueAt(tab.getCoordenador(), i, 12);
				ConsultarGrupos.Tabela.setValueAt(tab.getEmail(), i, 13);
				ConsultarGrupos.Tabela.setValueAt(tab.getFacebook(), i, 14);
				ConsultarGrupos.Tabela.setValueAt(tab.getCel_Coordenador(), i,
						15);
				ConsultarGrupos.Tabela.setValueAt(tab.getAtividades(), i, 16);

				i++;

			}
			Conexao.FecharConeao(Conexao.abrirConexao());
		}
	}

	// AÇÃO DO BOTAO VOLTAR CONSULTAR SERVIDOR PUBLICO

	public void BotaoVoltarConsultarGrupos() {
		new MenuGrupos().setVisible(true);
		ConsultarGrupos.Tela.setVisible(false);
	}

	/******* METODOS REFERENTES A TELA DE DELETAR ******/
	/**** METODO DE LISTAR COMBO GRUPOS ****/
	public List<Grupos> ListarComboeGrupos(Connection con) {

		String sql = "Select grupo from gru ORDER BY grupo ASC";
		List<Grupos> lista = new ArrayList<>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {

					Grupos g = new Grupos();
					g.setGrupo(rs.getString(1));
					lista.add(g);

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

		DeletarGrupos.nome1.removeAllItems();
		DeletarGrupos.nome1.addItem("");
		Grupos g = new Grupos();
		List<Grupos> lista = new ArrayList<>();
		lista = g.ListarComboeGrupos(Conexao.abrirConexao());
		for (Grupos g2 : lista) {

			DeletarGrupos.nome1.addItem(g2.getGrupo());

		}
		Conexao.FecharConeao(Conexao.abrirConexao());
	}

	/**** METODO PARA DELETAR GRUPOS ****/
	public void ExcluirGrupo(Connection con, Grupos g) {

		String nome = DeletarGrupos.nome1.getSelectedItem().toString();
		g.setGrupo(nome);
		String sql = "delete from gru where grupo =?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, g.getGrupo());
			if (ps.executeUpdate() > 0) {
				JOptionPane.showMessageDialog(null, "Deletado com Sucesso",
						"Coordenadoria da Juventude",
						JOptionPane.INFORMATION_MESSAGE);
				// DeletarServidorPublico.combo1.removeAllItems();
				g.MetodoDaTela();

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

	/**** ACAO DO BOTAO DELETAR GRUPO ****/
	public void AcaodoBotaoDeletarGrupo() {
		try {
			Grupos g = new Grupos();
			String nome = DeletarGrupos.nome1.getSelectedItem().toString();
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
					g.ExcluirGrupo(Conexao.abrirConexao(), g);
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
	 * AÇÃO DO BOTAO VOLTAR DELETAR EMPRESA
	 * 
	 * @throws ParseException
	 ****/
	public void BotaoVoltarDeletarGrupos() {
		new MenuGrupos().setVisible(true);
		DeletarGrupos.Tela.setVisible(false);
	}
}
