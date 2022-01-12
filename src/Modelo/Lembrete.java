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

import Visao.Cadastrar.CadastrarLembrete;
import Visao.Principal.MenuPrincipal;
import Visao.Principal.TelaDeLembrete;
import Visao.Principal.VisualizarLista;

public class Lembrete {

	private int id_Lembrete;
	private String titulo;
	private String descricao;
	private String data;
	private String hora;
	private String dia;
	private String mes;
	private String ano;

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public int getId_Lembrete() {
		return id_Lembrete;
	}

	public void setId_Lembrete(int id_Lembrete) {
		this.id_Lembrete = id_Lembrete;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	/**** METODO DE CADASTRO DE LEMBRETE ****/
	public void InserirLembrete(Lembrete l, Connection con) {

		String sql = "insert into lemb values(0,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, l.getTitulo());
			ps.setString(2, l.getDescricao());
			ps.setString(3, l.getData());
			ps.setString(4, l.getHora());
			ps.setString(5, l.getDia());
			ps.setString(6, l.getMes());
			ps.setString(7, l.getAno());

			if (ps.executeUpdate() > 0) {
				JOptionPane.showMessageDialog(null,
						"Cadastro Realizado com Sucesso",
						"Coordenadoria da Juventude",
						JOptionPane.INFORMATION_MESSAGE);

				Conexao.FecharConeao(Conexao.abrirConexao());
				CadastrarLembrete.titulolembrete1.setText("");
				CadastrarLembrete.area.setText("");
				CadastrarLembrete.data1.setText("");
				CadastrarLembrete.hora1.setText("");
				CadastrarLembrete.mes1.setSelectedItem("");
				CadastrarLembrete.ano2.setSelectedItem("");
				CadastrarLembrete.dia.setSelectedItem("");

			} else {
				JOptionPane.showMessageDialog(null, "Erro ao Inserir");
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,
					"Você excedeu o número de caracteres");
		}

	}

	/**** AÇÃO DO BOTAO SALVAR LEMBRETE ****/
	public void BotaoSalvarLambrete() {
		String titulo = CadastrarLembrete.titulolembrete1.getText();
		String descricao = CadastrarLembrete.area.getText();
		String data = CadastrarLembrete.data1.getText();
		String hora = CadastrarLembrete.hora1.getText();
		String dia = CadastrarLembrete.dia.getSelectedItem().toString();
		String mes = CadastrarLembrete.mes1.getSelectedItem().toString();
		String ano = CadastrarLembrete.ano2.getSelectedItem().toString();

		if (titulo.equals("") || dia.equals("") || mes.equals("")
				|| ano.equals("") || descricao.equals("")
				|| data.equals("             /  /    ")
				|| hora.equals("             :  ")) {
			JOptionPane.showMessageDialog(null,
					"Nenhum campo pode estar vazio",
					"Coordenadoria da Juventude", JOptionPane.WARNING_MESSAGE);

		} else {
			Lembrete lem = new Lembrete();
			lem.setTitulo(titulo);
			lem.setDescricao(descricao);
			lem.setData(data);
			lem.setHora(hora);
			lem.setDia(dia);
			lem.setMes(mes);
			lem.setAno(ano);

			lem.InserirLembrete(lem, Conexao.abrirConexao());

		}

	}

	/****
	 * AÇÃO DO SAIR LEMBRETE
	 * 
	 * @throws ParseException
	 ****/
	public void BotaoSairCadastrarLembrete() {
		new MenuPrincipal().setVisible(true);
		CadastrarLembrete.Tela.setVisible(false);
	}

	public List<Lembrete> ListarLista(Connection con) {
		String mes = VisualizarLista.combo.getSelectedItem().toString();
		String sql = "select tit,des,data,hora,dia,mes,ano from Lemb "
				+ "where mes ='" + mes + "' ORDER BY dia ASC";
		List<Lembrete> lista = new ArrayList<Lembrete>();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					Lembrete lem = new Lembrete();
					lem.setTitulo(rs.getString(1));
					lem.setDescricao(rs.getString(2));
					lem.setData(rs.getString(3));
					lem.setHora(rs.getString(4));
					lem.setDia(rs.getString(5));
					lem.setMes(rs.getString(6));
					lem.setAno(rs.getString(7));

					lista.add(lem);

				}
				return lista;
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(),
					"Coordenadoria da Juventude", JOptionPane.ERROR_MESSAGE);
		}
		return lista;
	}

	/****
	 * METODO PARA ATUALIZAR TABLE
	 * 
	 * @throws ParseException
	 ****/
	public void AtualizaTableLista() {
		Lembrete lem = new Lembrete();
		List<Lembrete> lista = new ArrayList<>();
		lista = lem.ListarLista(Conexao.abrirConexao());

		DefaultTableModel tbm = (DefaultTableModel) VisualizarLista.Tabela
				.getModel();
		while (tbm.getRowCount() > 0) {
			tbm.removeRow(0);

		}

		int i = 0;
		for (Lembrete tab : lista) {
			tbm.addRow(new String[i]);
			VisualizarLista.Tabela.setValueAt(tab.getDia(), i, 0);
			VisualizarLista.Tabela.setValueAt(tab.getHora(), i, 1);
			VisualizarLista.Tabela.setValueAt(tab.getDescricao(), i, 2);
			VisualizarLista.Tabela.setValueAt(tab.getTitulo(), i, 3);
			VisualizarLista.Tabela.setValueAt(tab.getAno(), i, 4);
			VisualizarLista.Tabela.setValueAt(tab.getMes(), i, 5);

			i++;
		}
		Conexao.FecharConeao(Conexao.abrirConexao());
	}

	public void Lembrete2(Connection con) {
		String data = MenuPrincipal.form.getText();
		String sql = "select tit,des,data,hora,dia,mes,ano from Lemb "
				+ "where data = '           " + data + "'";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				new TelaDeLembrete().setVisible(true);

			} else {

			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(),
					"Coordenadoria da Juventude", JOptionPane.ERROR_MESSAGE);
		}

	}

	public void AcaoFechar() {
		TelaDeLembrete.Tela.dispose();
	}

	public List<Lembrete> ListarLembrete(Connection con) {
		String data = TelaDeLembrete.form.getText();
		String sql = "select tit,des,data,hora,dia,mes,ano from Lemb "
				+ "where data = '           " + data + "'";
		List<Lembrete> lista = new ArrayList<Lembrete>();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					Lembrete lem = new Lembrete();
					lem.setTitulo(rs.getString(1));
					lem.setDescricao(rs.getString(2));
					lem.setData(rs.getString(3));
					lem.setHora(rs.getString(4));
					lem.setDia(rs.getString(5));
					lem.setMes(rs.getString(6));
					lem.setAno(rs.getString(7));

					lista.add(lem);

				}
				return lista;
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(),
					"Coordenadoria da Juventude", JOptionPane.ERROR_MESSAGE);
		}
		return lista;
	}

	/****
	 * METODO PARA ATUALIZAR TABLE
	 * 
	 * @throws ParseException
	 ****/
	public void AtualizaTable() {
		Lembrete lem = new Lembrete();
		List<Lembrete> lista = new ArrayList<>();
		lista = lem.ListarLembrete(Conexao.abrirConexao());

		DefaultTableModel tbm = (DefaultTableModel) TelaDeLembrete.Tabela
				.getModel();
		while (tbm.getRowCount() > 0) {
			tbm.removeRow(0);

		}

		int i = 0;
		for (Lembrete tab : lista) {
			tbm.addRow(new String[i]);
			TelaDeLembrete.Tabela.setValueAt(tab.getTitulo(), i, 0);
			TelaDeLembrete.Tabela.setValueAt(tab.getDia(), i, 1);
			TelaDeLembrete.Tabela.setValueAt(tab.getDescricao(), i, 2);
			TelaDeLembrete.Tabela.setValueAt(tab.getMes(), i, 3);
			TelaDeLembrete.Tabela.setValueAt(tab.getAno(), i, 4);
			TelaDeLembrete.Tabela.setValueAt(tab.getHora(), i, 5);


			i++;
		}
		Conexao.FecharConeao(Conexao.abrirConexao());
	}

}
