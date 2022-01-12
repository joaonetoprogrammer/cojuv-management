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

import Visao.Atualizar.AtualizarEmpresa;
import Visao.Cadastrar.CadastrarEmpresa;
import Visao.Consultar.ConsultarEmpresa;
import Visao.Deletar.DeletarEmpresa;
import Visao.Principal.MenuEmpresa;

public class Empresa {

	/**** VARIAVEIS ENCAPSULADAS REFERENTES AO BANCO DE DADODS ****/
	private int Emp_id;
	private String Emp_nome_fantasia;
	private String Emp_razao_social;
	private String Emp_cnpj;
	private String Emp_telefone;
	private String Emp_email_empresa;
	private String Emp_ramo;
	private String Emp_responsavel;
	private String Emp_tel_responsavel;
	private String Emp_email_responsavel;

	/**** METODOS GETERES E SETERES REFERENTES AS VARIAVEIS ENCAPSULADAS ****/
	public int getEmp_id() {
		return Emp_id;
	}

	public void setEmp_id(int emp_id) {
		Emp_id = emp_id;
	}

	public String getEmp_nome_fantasia() {
		return Emp_nome_fantasia;
	}

	public void setEmp_nome_fantasia(String emp_nome_fantasia) {
		Emp_nome_fantasia = emp_nome_fantasia;
	}

	public String getEmp_razao_social() {
		return Emp_razao_social;
	}

	public void setEmp_razao_social(String emp_razao_social) {
		Emp_razao_social = emp_razao_social;
	}

	public String getEmp_cnpj() {
		return Emp_cnpj;
	}

	public void setEmp_cnpj(String emp_cnpj) {
		Emp_cnpj = emp_cnpj;
	}

	public String getEmp_telefone() {
		return Emp_telefone;
	}

	public void setEmp_telefone(String emp_telefone) {
		Emp_telefone = emp_telefone;
	}

	public String getEmp_email_empresa() {
		return Emp_email_empresa;
	}

	public void setEmp_email_empresa(String emp_email_empresa) {
		Emp_email_empresa = emp_email_empresa;
	}

	public String getEmp_ramo() {
		return Emp_ramo;
	}

	public void setEmp_ramo(String emp_ramo) {
		Emp_ramo = emp_ramo;
	}

	public String getEmp_responsavel() {
		return Emp_responsavel;
	}

	public void setEmp_responsavel(String emp_responsavel) {
		Emp_responsavel = emp_responsavel;
	}

	public String getEmp_tel_responsavel() {
		return Emp_tel_responsavel;
	}

	public void setEmp_tel_responsavel(String emp_tel_responsavel) {
		Emp_tel_responsavel = emp_tel_responsavel;
	}

	public String getEmp_email_responsavel() {
		return Emp_email_responsavel;
	}

	public void setEmp_email_responsavel(String emp_email_responsavel) {
		Emp_email_responsavel = emp_email_responsavel;
	}

	/**** METODO DE CADASTRO DE EMPRESA ****/
	public void InserirEmpresa(Empresa a, Connection con) {

		String sql = "insert into Emp values(0,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, a.getEmp_nome_fantasia());
			ps.setString(2, a.getEmp_razao_social());
			ps.setString(3, a.getEmp_cnpj());
			ps.setString(4, a.getEmp_telefone());
			ps.setString(5, a.getEmp_email_empresa());
			ps.setString(6, a.getEmp_ramo());
			ps.setString(7, a.getEmp_responsavel());
			ps.setString(8, a.getEmp_tel_responsavel());
			ps.setString(9, a.getEmp_email_responsavel());

			if (ps.executeUpdate() > 0) {
				JOptionPane.showMessageDialog(null,
						"Cadastro Realizado com Sucesso",
						"Coordenadoria da Juventude",
						JOptionPane.INFORMATION_MESSAGE);
				CadastrarEmpresa.nomefantasia1.setText("");
				CadastrarEmpresa.razaosocial1.setText("");
				CadastrarEmpresa.cnpj1.setText("");
				CadastrarEmpresa.telefoneempresa1.setText("");
				CadastrarEmpresa.emailempresa1.setText("");
				CadastrarEmpresa.ramo1.setText("");
				CadastrarEmpresa.nome1.setText("");
				CadastrarEmpresa.telefone1.setText("");
				CadastrarEmpresa.email1.setText("");

			} else {
				JOptionPane.showMessageDialog(null, "Erro ao Inserir");
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,
					"Você escedeu o número de caracteres");
		}

	}

	/**** AÇÃO DO BOTAO CONFIRMAR EMPRESA ****/
	public void BotaoCadastrarEmpresa() {
		String nomeFantasia = CadastrarEmpresa.nomefantasia1.getText();
		String razaoSocial = CadastrarEmpresa.razaosocial1.getText();
		String cnpj = CadastrarEmpresa.cnpj1.getText();
		String telefoneEmpresa = CadastrarEmpresa.telefoneempresa1.getText();
		String emailEmpresa = CadastrarEmpresa.emailempresa1.getText();
		String ramo = CadastrarEmpresa.ramo1.getText();
		String responsavel = CadastrarEmpresa.nome1.getText();
		String telResponsavel = CadastrarEmpresa.telefone1.getText();
		String emailResponsavel = CadastrarEmpresa.email1.getText();

		if (nomeFantasia.equals("") || razaoSocial.equals("")
				|| cnpj.equals("  .   .   /    -  ")
				|| telefoneEmpresa.equals("(  )    -    ")
				|| emailEmpresa.equals("") || ramo.equals("")
				|| responsavel.equals("")
				|| telResponsavel.equals("(  )    -    ")
				|| emailResponsavel.equals("")) {
			JOptionPane.showMessageDialog(null,
					"Nenhum campo pode estar vazio",
					"Coordenadoria da Juventude", JOptionPane.WARNING_MESSAGE);

		} else {
			Empresa emp = new Empresa();
			emp.setEmp_nome_fantasia(nomeFantasia);
			emp.setEmp_razao_social(razaoSocial);
			emp.setEmp_cnpj(cnpj);
			emp.setEmp_telefone(telefoneEmpresa);
			emp.setEmp_email_empresa(emailEmpresa);
			emp.setEmp_ramo(ramo);
			emp.setEmp_responsavel(responsavel);
			emp.setEmp_tel_responsavel(telResponsavel);
			emp.setEmp_email_responsavel(emailResponsavel);

			emp.InserirEmpresa(emp, Conexao.abrirConexao());
			Conexao.FecharConeao(Conexao.abrirConexao());

		}

	}

	/****
	 * AÇÃO DO BOTAO VOLTAR EMPRESA
	 * 
	 * @throws ParseException
	 ****/
	public void BotaoVoltarCadastrarEmpresa() {
		new MenuEmpresa().setVisible(true);
		CadastrarEmpresa.Tela.setVisible(false);
	}

	/** ---------------METODOS REFERERENTES A TELA DE ATUALIZAR--------------- **/
	/**** METODO PARA TESTAR EMPRESA ****/
	public boolean TestarEmpresa(Connection con) {
		String codigo = AtualizarEmpresa.codigo1.getText();
		int cod = Integer.parseInt(codigo);
		boolean resultado = false;
		try {
			String sql = "select * from Emp where Emp_id = " + cod + "";
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

	/**** METODO PARA CAPTURAR EMPRESA ****/
	public void CapturarEmpresa(Empresa emp, Connection con) {
		String codigo = AtualizarEmpresa.codigo1.getText();
		int cod = Integer.parseInt(codigo);
		String sql = "select * from Emp where Emp_id =" + cod + " ";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					emp.setEmp_id(rs.getInt(1));
					emp.setEmp_nome_fantasia(rs.getString(2));
					emp.setEmp_razao_social(rs.getString(3));
					emp.setEmp_cnpj(rs.getString(4));
					emp.setEmp_telefone(rs.getString(5));
					emp.setEmp_email_empresa(rs.getString(6));
					emp.setEmp_ramo(rs.getString(7));
					emp.setEmp_responsavel(rs.getString(8));
					emp.setEmp_tel_responsavel(rs.getString(9));
					emp.setEmp_email_responsavel(rs.getString(10));

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

	/**** METODO PARA ALTERAR EMPRESA ****/
	@SuppressWarnings("deprecation")
	public void AlterarEmpresa(Empresa emp, Connection con) {
		String sql = "update Emp set nome=?, razao_s=?,cnpj=?,"
				+ "telefone=?,email_e=?,ramo=?,resp=?,"
				+ "tel_resp=?, email_resp=? where Emp_id = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, emp.getEmp_nome_fantasia());
			ps.setString(2, emp.getEmp_razao_social());
			ps.setString(3, emp.getEmp_cnpj());
			ps.setString(4, emp.getEmp_telefone());
			ps.setString(5, emp.getEmp_email_empresa());
			ps.setString(6, emp.getEmp_ramo());
			ps.setString(7, emp.getEmp_responsavel());
			ps.setString(8, emp.getEmp_tel_responsavel());
			ps.setString(9, emp.getEmp_email_responsavel());
			ps.setInt(10, emp.getEmp_id());

			if (ps.executeUpdate() > 0) {
				JOptionPane.showMessageDialog(null,
						"Atualização realizada com sucesso",
						"Coordenadoria da Juventude",
						JOptionPane.INFORMATION_MESSAGE);
				AtualizarEmpresa.nomefantasia1.setText("");
				AtualizarEmpresa.razaosocial1.setText("");
				AtualizarEmpresa.cnpj1.setText("");
				AtualizarEmpresa.telefone1.setText("");
				AtualizarEmpresa.emailempresa1.setText("");
				AtualizarEmpresa.ramo1.setText("");
				AtualizarEmpresa.nome1.setText("");
				AtualizarEmpresa.email1.setText("");
				AtualizarEmpresa.telefoneempresa1.setText("");

				AtualizarEmpresa.codigo1.setText("");
				AtualizarEmpresa.codigo1.enable();

				AtualizarEmpresa.nomefantasia1.disable();
				AtualizarEmpresa.razaosocial1.disable();
				AtualizarEmpresa.cnpj1.disable();
				AtualizarEmpresa.telefone1.disable();
				AtualizarEmpresa.emailempresa1.disable();
				AtualizarEmpresa.ramo1.disable();
				AtualizarEmpresa.nome1.disable();
				AtualizarEmpresa.email1.disable();
				AtualizarEmpresa.telefoneempresa1.disable();
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
	public void InseririDadosEmpresa(Empresa emp2) {

		AtualizarEmpresa.nomefantasia1.enable();
		AtualizarEmpresa.razaosocial1.enable();
		AtualizarEmpresa.cnpj1.enable();
		AtualizarEmpresa.telefone1.enable();
		AtualizarEmpresa.emailempresa1.enable();
		AtualizarEmpresa.ramo1.enable();
		AtualizarEmpresa.nome1.enable();
		AtualizarEmpresa.email1.enable();
		AtualizarEmpresa.telefoneempresa1.enable();

		AtualizarEmpresa.atualizar.enable();

		AtualizarEmpresa.nomefantasia1
				.setText("" + emp2.getEmp_nome_fantasia());
		AtualizarEmpresa.razaosocial1.setText("" + emp2.getEmp_razao_social());
		AtualizarEmpresa.cnpj1.setText("" + emp2.getEmp_cnpj());
		AtualizarEmpresa.telefoneempresa1.setText("" + emp2.getEmp_telefone());
		AtualizarEmpresa.emailempresa1
				.setText("" + emp2.getEmp_email_empresa());
		AtualizarEmpresa.ramo1.setText("" + emp2.getEmp_ramo());
		AtualizarEmpresa.nome1.setText("" + emp2.getEmp_responsavel());
		AtualizarEmpresa.email1.setText("" + emp2.getEmp_email_responsavel());
		AtualizarEmpresa.telefone1.setText("" + emp2.getEmp_tel_responsavel());
		
		AtualizarEmpresa.codigo1.disable();


	}

	/**** ACAO DO BOTAO OK EMPRESA ****/
	public void AcaoDoBotaoOkEmpresa() {
		String ok = AtualizarEmpresa.codigo1.getText();
		Empresa emp = new Empresa();
		try {
			if (ok.equals("")) {
				JOptionPane.showMessageDialog(null,
						"Digite o código para atualizar",
						"Coordenadoria da Juventude",
						JOptionPane.WARNING_MESSAGE);

			} else if (emp.TestarEmpresa(Conexao.abrirConexao()) == false) {
				JOptionPane
						.showMessageDialog(null, "Código não encontrado",
								"Coordenadoria da Juventude",
								JOptionPane.ERROR_MESSAGE);
				Conexao.FecharConeao(Conexao.abrirConexao());

			} else if (emp.TestarEmpresa(Conexao.abrirConexao()) == true) {
				AtualizarEmpresa.nomefantasia1.setText("");
				AtualizarEmpresa.razaosocial1.setText("");
				AtualizarEmpresa.cnpj1.setText("");
				AtualizarEmpresa.telefoneempresa1.setText("");
				AtualizarEmpresa.emailempresa1.setText("");
				AtualizarEmpresa.ramo1.setText("");
				AtualizarEmpresa.nome1.setText("");
				AtualizarEmpresa.email1.setText("");
				AtualizarEmpresa.telefone1.setText("");

				emp.CapturarEmpresa(emp, Conexao.abrirConexao());
				Conexao.FecharConeao(Conexao.abrirConexao());
				emp.InseririDadosEmpresa(emp);

			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "O código só possui números",
					"Coordenadoria da Juventude", JOptionPane.WARNING_MESSAGE);

		}

	}

	/**** ACAO DO BOTAO ALTERAR EMPRESA ****/
	public void AcaoDoBotaoAlterarEmpresa() {
		String nomeFantasia = AtualizarEmpresa.nomefantasia1.getText();
		String razaoSocial = AtualizarEmpresa.razaosocial1.getText();
		String cnpj = AtualizarEmpresa.cnpj1.getText();
		String telefoneEmpresa = AtualizarEmpresa.telefoneempresa1.getText();
		String emailEmpresa = AtualizarEmpresa.emailempresa1.getText();
		String ramo = AtualizarEmpresa.ramo1.getText();
		String responsavel = AtualizarEmpresa.nome1.getText();
		String emailResponsavel = AtualizarEmpresa.email1.getText();
		String telefoneResponsavel = AtualizarEmpresa.telefone1.getText();
		String codigo = AtualizarEmpresa.codigo1.getText();

		if (nomeFantasia.equals("") || razaoSocial.equals("")
				|| cnpj.equals("") || telefoneEmpresa.equals("")
				|| emailEmpresa.equals("") || ramo.equals("")
				|| responsavel.equals("") || emailResponsavel.equals("")
				|| telefoneResponsavel.equals("")) {
			JOptionPane.showMessageDialog(null,
					"Nenhum campo pode estar vazio",
					"Coordenadoria da Juventude", JOptionPane.WARNING_MESSAGE);

		} else {
			Empresa emp = new Empresa();
			int cod = Integer.parseInt(codigo);
			emp.setEmp_nome_fantasia(nomeFantasia);
			emp.setEmp_razao_social(razaoSocial);
			emp.setEmp_cnpj(cnpj);
			emp.setEmp_telefone(telefoneEmpresa);
			emp.setEmp_email_empresa(emailEmpresa);
			emp.setEmp_ramo(ramo);
			emp.setEmp_responsavel(responsavel);
			emp.setEmp_email_responsavel(emailResponsavel);
			emp.setEmp_tel_responsavel(telefoneResponsavel);
			emp.setEmp_id(cod);

			emp.AlterarEmpresa(emp, Conexao.abrirConexao());
			Conexao.FecharConeao(Conexao.abrirConexao());

		}
	}

	/****
	 * AÇÃO DO BOTAO VOLTAR EMPRESA
	 * 
	 * @throws ParseException
	 ****/
	public void BotaoVoltarAtualizarEmpresa() {
		new MenuEmpresa().setVisible(true);
		AtualizarEmpresa.Tela.setVisible(false);
	}

	/***** METODOS REFERENTES A TELA DE CONSULTARR ******/
	/**** METODO DE LISTAR EMPRESA POR CODIGO ****/
	public List<Empresa> ListarEmpresaCodigo(Connection con) {
		String sql = "select Emp_id,nome,razao_s,cnpj,"
				+ "telefone,email_e,ramo,resp,"
				+ "tel_resp,email_resp from Emp";
		List<Empresa> lista = new ArrayList<Empresa>();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					Empresa emp = new Empresa();
					emp.setEmp_id(rs.getInt(1));
					emp.setEmp_nome_fantasia(rs.getString(2));
					emp.setEmp_razao_social(rs.getString(3));
					emp.setEmp_cnpj(rs.getString(4));
					emp.setEmp_telefone(rs.getString(5));
					emp.setEmp_email_empresa(rs.getString(6));
					emp.setEmp_ramo(rs.getString(7));
					emp.setEmp_responsavel(rs.getString(8));
					emp.setEmp_tel_responsavel(rs.getString(9));
					emp.setEmp_email_responsavel(rs.getString(10));

					lista.add(emp);
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
		Empresa emp = new Empresa();
		List<Empresa> lista = new ArrayList<>();
		lista = emp.ListarEmpresaCodigo(Conexao.abrirConexao());

		DefaultTableModel tbm = (DefaultTableModel) ConsultarEmpresa.Tabela
				.getModel();
		while (tbm.getRowCount() > 0) {
			tbm.removeRow(0);

		}

		int i = 0;
		for (Empresa tab : lista) {
			tbm.addRow(new String[i]);
			ConsultarEmpresa.Tabela.setValueAt(tab.getEmp_id(), i, 0);
			ConsultarEmpresa.Tabela
					.setValueAt(tab.getEmp_nome_fantasia(), i, 1);
			ConsultarEmpresa.Tabela.setValueAt(tab.getEmp_razao_social(), i, 2);
			ConsultarEmpresa.Tabela.setValueAt(tab.getEmp_cnpj(), i, 3);
			ConsultarEmpresa.Tabela.setValueAt(tab.getEmp_telefone(), i, 4);
			ConsultarEmpresa.Tabela
					.setValueAt(tab.getEmp_email_empresa(), i, 5);
			ConsultarEmpresa.Tabela.setValueAt(tab.getEmp_ramo(), i, 6);
			ConsultarEmpresa.Tabela.setValueAt(tab.getEmp_responsavel(), i, 7);
			ConsultarEmpresa.Tabela.setValueAt(tab.getEmp_tel_responsavel(), i,
					8);
			ConsultarEmpresa.Tabela.setValueAt(tab.getEmp_email_responsavel(),
					i, 9);
			i++;
		}
		Conexao.FecharConeao(Conexao.abrirConexao());
	}

	/**** METODO DE LISTAR EMPRESA POR NOME DIGITADO ****/
	public List<Empresa> ListarEmpresaNome(Connection con, String nome) {
		String sql = "select Emp_id,nome,razao_s,cnpj,"
				+ "telefone,email_e,ramo,resp,"
				+ "tel_resp,email_resp from Emp where nome like '" + nome
				+ "%'";
		List<Empresa> lista = new ArrayList<Empresa>();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					Empresa emp = new Empresa();
					emp.setEmp_id(rs.getInt(1));
					emp.setEmp_nome_fantasia(rs.getString(2));
					emp.setEmp_razao_social(rs.getString(3));
					emp.setEmp_cnpj(rs.getString(4));
					emp.setEmp_telefone(rs.getString(5));
					emp.setEmp_email_empresa(rs.getString(6));
					emp.setEmp_ramo(rs.getString(7));
					emp.setEmp_responsavel(rs.getString(8));
					emp.setEmp_tel_responsavel(rs.getString(9));
					emp.setEmp_email_responsavel(rs.getString(10));

					lista.add(emp);
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
	public void AtualizaTableNome() {
		Empresa emp = new Empresa();
		List<Empresa> lista = new ArrayList<>();
		String nome = ConsultarEmpresa.campo.getText();
		lista = emp.ListarEmpresaNome(Conexao.abrirConexao(), nome);
		if (nome.equals("")) {
			JOptionPane.showMessageDialog(null,
					"Digite o nome da empresa a pesquisar",
					"Coordenadoria da Juventude", JOptionPane.ERROR_MESSAGE);

		} else {
			DefaultTableModel tbm = (DefaultTableModel) ConsultarEmpresa.Tabela
					.getModel();
			while (tbm.getRowCount() > 0) {
				tbm.removeRow(0);

			}

			int i = 0;
			for (Empresa tab : lista) {
				tbm.addRow(new String[i]);
				ConsultarEmpresa.Tabela.setValueAt(tab.getEmp_id(), i, 0);
				ConsultarEmpresa.Tabela.setValueAt(tab.getEmp_nome_fantasia(),
						i, 1);
				ConsultarEmpresa.Tabela.setValueAt(tab.getEmp_razao_social(),
						i, 2);
				ConsultarEmpresa.Tabela.setValueAt(tab.getEmp_cnpj(), i, 3);
				ConsultarEmpresa.Tabela.setValueAt(tab.getEmp_telefone(), i, 4);
				ConsultarEmpresa.Tabela.setValueAt(tab.getEmp_email_empresa(),
						i, 5);
				ConsultarEmpresa.Tabela.setValueAt(tab.getEmp_ramo(), i, 6);
				ConsultarEmpresa.Tabela.setValueAt(tab.getEmp_responsavel(), i,
						7);
				ConsultarEmpresa.Tabela.setValueAt(
						tab.getEmp_tel_responsavel(), i, 8);
				ConsultarEmpresa.Tabela.setValueAt(
						tab.getEmp_email_responsavel(), i, 9);
				i++;
			}
			Conexao.FecharConeao(Conexao.abrirConexao());
		}
	}

	/**** METODO DE LISTAR EMPRESA POR ORDEM ALFABETICA ****/
	public List<Empresa> ListarEmpresaOrdem(Connection con) {
		String sql = "select Emp_id,nome,razao_s,cnpj,"
				+ "telefone,email_e,ramo,resp,"
				+ "tel_resp,email_resp from Emp ORDER BY nome ASC";
		List<Empresa> lista = new ArrayList<Empresa>();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					Empresa emp = new Empresa();
					emp.setEmp_id(rs.getInt(1));
					emp.setEmp_nome_fantasia(rs.getString(2));
					emp.setEmp_razao_social(rs.getString(3));
					emp.setEmp_cnpj(rs.getString(4));
					emp.setEmp_telefone(rs.getString(5));
					emp.setEmp_email_empresa(rs.getString(6));
					emp.setEmp_ramo(rs.getString(7));
					emp.setEmp_responsavel(rs.getString(8));
					emp.setEmp_tel_responsavel(rs.getString(9));
					emp.setEmp_email_responsavel(rs.getString(10));

					lista.add(emp);
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
	public void AtualizaTableOrdem() {
		Empresa emp = new Empresa();
		List<Empresa> lista = new ArrayList<>();
		lista = emp.ListarEmpresaOrdem(Conexao.abrirConexao());

		DefaultTableModel tbm = (DefaultTableModel) ConsultarEmpresa.Tabela
				.getModel();
		while (tbm.getRowCount() > 0) {
			tbm.removeRow(0);

		}

		int i = 0;
		for (Empresa tab : lista) {
			tbm.addRow(new String[i]);
			ConsultarEmpresa.Tabela.setValueAt(tab.getEmp_id(), i, 0);
			ConsultarEmpresa.Tabela
					.setValueAt(tab.getEmp_nome_fantasia(), i, 1);
			ConsultarEmpresa.Tabela.setValueAt(tab.getEmp_razao_social(), i, 2);
			ConsultarEmpresa.Tabela.setValueAt(tab.getEmp_cnpj(), i, 3);
			ConsultarEmpresa.Tabela.setValueAt(tab.getEmp_telefone(), i, 4);
			ConsultarEmpresa.Tabela
					.setValueAt(tab.getEmp_email_empresa(), i, 5);
			ConsultarEmpresa.Tabela.setValueAt(tab.getEmp_ramo(), i, 6);
			ConsultarEmpresa.Tabela.setValueAt(tab.getEmp_responsavel(), i, 7);
			ConsultarEmpresa.Tabela.setValueAt(tab.getEmp_tel_responsavel(), i,
					8);
			ConsultarEmpresa.Tabela.setValueAt(tab.getEmp_email_responsavel(),
					i, 9);
			i++;
		}
		Conexao.FecharConeao(Conexao.abrirConexao());

	}

	/****
	 * AÇÃO DO BOTAO VOLTAR CONSULTAR EMPRESA
	 * 
	 * @throws ParseException
	 ****/
	public void BotaoVoltarConsultarEmpresa() {
		new MenuEmpresa().setVisible(true);
		ConsultarEmpresa.Tela.setVisible(false);
	}

	/******* METODOS REFERENTES A TELA DE DELETAR ******/
	/**** METODO DE LISTAR COMBO EMPRESA ****/
	public List<Empresa> ListarComboeEmpresa(Connection con) {

		String sql = "Select nome from Emp ORDER BY nome ASC";
		List<Empresa> lista = new ArrayList<>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {

					Empresa emp2 = new Empresa();
					emp2.setEmp_nome_fantasia(rs.getString(1));
					lista.add(emp2);

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

		DeletarEmpresa.nome1.removeAllItems();
		DeletarEmpresa.nome1.addItem("");
		Empresa emp = new Empresa();
		List<Empresa> lista = new ArrayList<>();
		lista = emp.ListarComboeEmpresa(Conexao.abrirConexao());
		for (Empresa a : lista) {

			DeletarEmpresa.nome1.addItem(a.getEmp_nome_fantasia());

		}
		Conexao.FecharConeao(Conexao.abrirConexao());
	}

	/**** METODO PARA DELETAR EMPRESA ****/
	public void ExcluirEmpresa(Connection con, Empresa emp) {

		String nome = DeletarEmpresa.nome1.getSelectedItem().toString();
		emp.setEmp_nome_fantasia(nome);
		String sql = "delete from Emp where nome =?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, emp.getEmp_nome_fantasia());
			if (ps.executeUpdate() > 0) {
				JOptionPane.showMessageDialog(null, "Deletado com Sucesso",
						"Coordenadoria da Juventude",
						JOptionPane.INFORMATION_MESSAGE);
				// DeletarServidorPublico.combo1.removeAllItems();
				emp.MetodoDaTela();

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

	/**** ACAO DO BOTAO DELETAR EMPRESA ****/
	public void AcaodoBotaoDeletarEmpresa() {
		try {
			Empresa emp = new Empresa();
			String nome = DeletarEmpresa.nome1.getSelectedItem().toString();
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
					emp.ExcluirEmpresa(Conexao.abrirConexao(), emp);
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
	public void BotaoVoltarDeletarEmpresa() {
		new MenuEmpresa().setVisible(true);
		DeletarEmpresa.Tela.setVisible(false);
	}

}
