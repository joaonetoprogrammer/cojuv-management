package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

import Visao.Principal.TelaLogin;

public class Conexao {
	/**** METODO PARA ABRIR CONEXAO *****/
	public static Connection abrirConexao() {
   		Connection con = null;
		try {
			String url = "jdbc:mysql://localhost/c_j";
			con = DriverManager.getConnection(url, "root", "1010");

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Não foi possível conectar",
					"Cordenadoria da Juventude", JOptionPane.ERROR_MESSAGE);

		}
		return con;

	}

	/**** METODO PARA FECHAR CONEXAO *****/
	public static void FecharConeao(Connection con) {
		try {
			con.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	public static void main(String[] args) {
		new TelaLogin().setVisible(true);
	}

}
