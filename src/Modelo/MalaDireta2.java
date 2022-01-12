package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Visao.Principal.MalaDireta;

public class MalaDireta2 {

	private String emails;
	private String emils2;
	private String emails3;
	private String emails4;

	public String getEmils2() {
		return emils2;
	}

	public void setEmils2(String emils2) {
		this.emils2 = emils2;
	}

	public String getEmails() {
		return emails;
	}

	public void setEmails(String emails) {
		this.emails = emails;
	}

	public String getEmails3() {
		return emails3;
	}

	public void setEmails3(String emails3) {
		this.emails3 = emails3;
	}

	public String getEmails4() {
		return emails4;
	}

	public void setEmails4(String emails4) {
		this.emails4 = emails4;
	}

	public List<MalaDireta2> ListarEmail(Connection con) {
		String sql = "select email from serv_p";
		List<MalaDireta2> lista = new ArrayList<MalaDireta2>();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					MalaDireta2 m = new MalaDireta2();
					m.setEmails(rs.getString(1));

					lista.add(m);
				}
				return lista;
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(),
					"Coordenadoria da Juventude", JOptionPane.ERROR_MESSAGE);
		}
		return lista;
	}

	/**** METODO PARA ATUALIZAR TABLE ****/
	public void AtualizaTable() {
		MalaDireta2 m = new MalaDireta2();
		List<MalaDireta2> lista = new ArrayList<>();
		lista = m.ListarEmail(Conexao.abrirConexao());

		DefaultTableModel tbm = (DefaultTableModel) MalaDireta.Tabela
				.getModel();
		while (tbm.getRowCount() > 0) {
			tbm.removeRow(0);

		}

		int i = 0;
		for (MalaDireta2 tab : lista) {
			tbm.addRow(new String[i]);
			MalaDireta.Tabela.setValueAt(tab.getEmails(), i, 0);
			i++;
		}
		Conexao.FecharConeao(Conexao.abrirConexao());
	}

	// SERVIDOR TERCEIRIZADO
	public List<MalaDireta2> ListarEmail2(Connection con) {
		String sql = "select email from serv_t";
		List<MalaDireta2> lista = new ArrayList<MalaDireta2>();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					MalaDireta2 m = new MalaDireta2();
					m.setEmils2(rs.getString(1));

					lista.add(m);
				}
				return lista;
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(),
					"Coordenadoria da Juventude", JOptionPane.ERROR_MESSAGE);
		}
		return lista;
	}

	/**** METODO PARA ATUALIZAR TABLE ****/
	public void AtualizaTable2() {
		MalaDireta2 m = new MalaDireta2();
		List<MalaDireta2> lista = new ArrayList<>();
		lista = m.ListarEmail2(Conexao.abrirConexao());

		DefaultTableModel tbm = (DefaultTableModel) MalaDireta.Tabela2
				.getModel();
		while (tbm.getRowCount() > 0) {
			tbm.removeRow(0);

		}

		int i = 0;
		for (MalaDireta2 tab : lista) {
			tbm.addRow(new String[i]);
			MalaDireta.Tabela2.setValueAt(tab.getEmils2(), i, 0);
			i++;
		}
		Conexao.FecharConeao(Conexao.abrirConexao());
	}

	/**** METODO DE LISTAR SERVIDOR PUBLICO POR LOTACAO ****/
	public List<MalaDireta2> ListarServidorPublicoLotacao(Connection con,
			String lotacao) {
		String sql = "select email from serv_p where lotacao like '" + lotacao
				+ "%'";
		List<MalaDireta2> lista = new ArrayList<MalaDireta2>();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					MalaDireta2 m = new MalaDireta2();
					m.setEmails(rs.getString(1));

					lista.add(m);
				}
				return lista;
			}

		} catch (SQLException e) {
			return null;
		}
		return lista;
	}

	/**** METODO PARA ATUALIZAR TABLE POR LOTACAO SELECIONADA ****/
	public void AtualizaTableLotacao() {
		MalaDireta2 m = new MalaDireta2();
		List<MalaDireta2> lista = new ArrayList<>();
		String lotacao = MalaDireta.comboLotacao.getSelectedItem().toString();
		lista = m.ListarServidorPublicoLotacao(Conexao.abrirConexao(), lotacao);
		if (lotacao.equals("")) {
			JOptionPane.showMessageDialog(null, "Selecione uma lotação",
					"Coordenadoria da Juventude", JOptionPane.ERROR_MESSAGE);

		} else {

			DefaultTableModel tbm = (DefaultTableModel) MalaDireta.Tabela
					.getModel();
			while (tbm.getRowCount() > 0) {
				tbm.removeRow(0);

			}

			int i = 0;
			for (MalaDireta2 tab : lista) {
				tbm.addRow(new String[i]);
				MalaDireta.Tabela.setValueAt(tab.getEmails(), i, 0);
				i++;

			}
			Conexao.FecharConeao(Conexao.abrirConexao());
		}
	}

	/**** METODO DE LISTAR SERVIDOR PUBLICO POR LOTACAO ****/
	public List<MalaDireta2> ListarServidorPublicoLotacao2(Connection con,
			String lotacao) {
		String sql = "select email from serv_t where lotacao like '" + lotacao
				+ "%'";
		List<MalaDireta2> lista = new ArrayList<MalaDireta2>();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					MalaDireta2 m = new MalaDireta2();
					m.setEmils2(rs.getString(1));

					lista.add(m);
				}
				return lista;
			}

		} catch (SQLException e) {
			return null;
		}
		return lista;
	}

	/**** METODO PARA ATUALIZAR TABLE POR LOTACAO SELECIONADA ****/
	public void AtualizaTableLotacao2() {
		MalaDireta2 m = new MalaDireta2();
		List<MalaDireta2> lista = new ArrayList<>();
		String lotacao = MalaDireta.comboLotacao.getSelectedItem().toString();
		lista = m
				.ListarServidorPublicoLotacao2(Conexao.abrirConexao(), lotacao);
		if (lotacao.equals("")) {

		} else {

			DefaultTableModel tbm = (DefaultTableModel) MalaDireta.Tabela2
					.getModel();
			while (tbm.getRowCount() > 0) {
				tbm.removeRow(0);

			}

			int i = 0;
			for (MalaDireta2 tab : lista) {
				tbm.addRow(new String[i]);
				MalaDireta.Tabela2.setValueAt(tab.getEmils2(), i, 0);
				i++;

			}
			Conexao.FecharConeao(Conexao.abrirConexao());
		}
	}

	// ATUALIZAR TABLE GRUPOS
	public List<MalaDireta2> ListarEmailGrupo(Connection con) {
		String sql = "select email from gru";
		List<MalaDireta2> lista = new ArrayList<MalaDireta2>();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					MalaDireta2 m = new MalaDireta2();
					m.setEmails3(rs.getString(1));

					lista.add(m);
				}
				return lista;
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(),
					"Coordenadoria da Juventude", JOptionPane.ERROR_MESSAGE);
		}
		return lista;
	}

	/**** METODO PARA ATUALIZAR TABLE ****/
	public void AtualizaTableGrupos() {
		MalaDireta2 m = new MalaDireta2();
		List<MalaDireta2> lista = new ArrayList<>();
		lista = m.ListarEmailGrupo(Conexao.abrirConexao());

		DefaultTableModel tbm = (DefaultTableModel) MalaDireta.Tabela3
				.getModel();
		while (tbm.getRowCount() > 0) {
			tbm.removeRow(0);

		}

		int i = 0;
		for (MalaDireta2 tab : lista) {
			tbm.addRow(new String[i]);
			MalaDireta.Tabela3.setValueAt(tab.getEmails3(), i, 0);
			i++;
		}
		Conexao.FecharConeao(Conexao.abrirConexao());
	}

	public List<MalaDireta2> ListarEmailContatosGeral(Connection con) {
		String sql = "select cg_email from cgeral";
		List<MalaDireta2> lista = new ArrayList<MalaDireta2>();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					MalaDireta2 m = new MalaDireta2();
					m.setEmails4(rs.getString(1));

					lista.add(m);
				}
				return lista;
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(),
					"Coordenadoria da Juventude", JOptionPane.ERROR_MESSAGE);
		}
		return lista;
	}

	/**** METODO PARA ATUALIZAR TABLE ****/
	public void AtualizaTableContatosGeral() {
		MalaDireta2 m = new MalaDireta2();
		List<MalaDireta2> lista = new ArrayList<>();
		lista = m.ListarEmailContatosGeral(Conexao.abrirConexao());

		DefaultTableModel tbm = (DefaultTableModel) MalaDireta.Tabela4
				.getModel();
		while (tbm.getRowCount() > 0) {
			tbm.removeRow(0);

		}

		int i = 0;
		for (MalaDireta2 tab : lista) {
			tbm.addRow(new String[i]);
			MalaDireta.Tabela4.setValueAt(tab.getEmails4(), i, 0);
			i++;
		}
		Conexao.FecharConeao(Conexao.abrirConexao());
	}

	/**** METODO DE LISTAR CONTATOS GERAL POR LOTACAO ****/
	public List<MalaDireta2> ListarContatosLotacao(Connection con,
			String lotacao) {
		String sql = "select cg_email from cgeral where cg_lotacao like '"
				+ lotacao + "%'";
		List<MalaDireta2> lista = new ArrayList<MalaDireta2>();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					MalaDireta2 m = new MalaDireta2();
					m.setEmails4(rs.getString(1));

					lista.add(m);
				}
				return lista;
			}

		} catch (SQLException e) {
			return null;
		}
		return lista;
	}

	/**** METODO PARA ATUALIZAR TABLE POR LOTACAO SELECIONADA ****/
	public void AtualizaTableContatosLotacao() {
		MalaDireta2 m = new MalaDireta2();
		List<MalaDireta2> lista = new ArrayList<>();
		String lotacao = MalaDireta.comboOutrosContatos.getSelectedItem()
				.toString();
		lista = m.ListarContatosLotacao(Conexao.abrirConexao(), lotacao);
		if (lotacao.equals("")) {
			JOptionPane.showMessageDialog(null, "Selecione uma Categoria",
					"Coordenadoria da Juventude", JOptionPane.ERROR_MESSAGE);

		} else {

			DefaultTableModel tbm = (DefaultTableModel) MalaDireta.Tabela4
					.getModel();
			while (tbm.getRowCount() > 0) {
				tbm.removeRow(0);

			}

			int i = 0;
			for (MalaDireta2 tab : lista) {
				tbm.addRow(new String[i]);
				MalaDireta.Tabela4.setValueAt(tab.getEmails4(), i, 0);
				i++;

			}
			Conexao.FecharConeao(Conexao.abrirConexao());
		}
	}

}
