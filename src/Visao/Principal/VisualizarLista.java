package Visao.Principal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import Controle.ControleConsultar;

public class VisualizarLista extends JFrame {

	private static final long serialVersionUID = 1L;

	public static JFrame Tela;

	public static JLabel planodefundo;
	public static JLabel barra;
	public static JLabel barra2;

	public static JPanel PainelTabela;

	public JLabel barra3;
	public JLabel barra4;
	public static JLabel rodape;

	// Tabela
	public static JTable Tabela;

	// Scroll
	public static JScrollPane Scroll;
	public static JLabel titulo;
	public static JLabel titulo3;
	public static JLabel titulo4;

	public static JButton j1;

	public static JComboBox<String> combo;

	public static Font f;
	public static JButton ok;
	public static JLabel imagem;

	public VisualizarLista() {
		Container d = getContentPane();
		setLayout(null);
		Tela = this;
		setSize(800, 680);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		f = new Font("Arial", Font.BOLD, 26);
		planodefundo = new JLabel(new ImageIcon("Imagens/PlanodeFundo.jpg"));
		d.add(planodefundo);
		planodefundo.setBounds(1, 1, 800, 680);

		barra = new JLabel(new ImageIcon("Imagens/barra.png"));
		planodefundo.add(barra);
		barra.setBounds(0, 5, 900, 15);

		barra2 = new JLabel(new ImageIcon("Imagens/barra2.png"));
		planodefundo.add(barra2);
		barra2.setBounds(0, 60, 900, 15);

		// Barra3

		barra3 = new JLabel(new ImageIcon("Imagens/barra2.png"));
		planodefundo.add(barra3);
		barra3.setBounds(0, 580, 1200, 15);

		// Barra4

		barra4 = new JLabel(new ImageIcon("Imagens/barra2.png"));
		planodefundo.add(barra4);
		barra4.setBounds(0, 630, 1200, 15);

		planodefundo.add(rodape = new JLabel("Prefeitura de Maranguape"));
		rodape.setFont(f);
		Dimension sizerodape = rodape.getPreferredSize();
		rodape.setBounds(220, 600, sizerodape.width, sizerodape.height);
		planodefundo.add(titulo = new JLabel(
				"Coordenadoria de Juventude - Lembretes!!!"));
		titulo.setBounds(130, 25, 600, 30);
		titulo.setFont(f);

		planodefundo.add(combo = new JComboBox<String>());
		combo.setBounds(290, 90, 350, 30);
		combo.setFont(f);

		combo.addItem("" + "Janeiro");
		combo.addItem("Fevereiro");
		combo.addItem("Março");
		combo.addItem("Abril");
		combo.addItem("Maio");
		combo.addItem("Junho");
		combo.addItem("Julho");
		combo.addItem("Agosto");
		combo.addItem("Setembro");
		combo.addItem("Outubro");
		combo.addItem("Novembro");
		combo.addItem("Dezembro");
		combo.setBackground(Color.getHSBColor(0, 342, 4300));

		planodefundo.add(titulo3 = new JLabel("Selecione o mês: "));
		titulo3.setBounds(40, 90, 700, 30);
		titulo3.setFont(f);

		planodefundo.add(titulo4 = new JLabel("Sua Lista de Lembretes!!! "));
		titulo4.setBounds(220, 150, 700, 30);
		titulo4.setFont(f);

		planodefundo.add(ok = new JButton("Ok"));
		ok.setBounds(660, 90, 52, 32);
		imagem = new JLabel(new ImageIcon("Imagens/ok.png"));
		ok.setLayout(null);
		ok.add(imagem);
		imagem.setBounds(1, 1, 50, 30);

		PainelTabela = new JPanel(new BorderLayout());
		PainelTabela.setBorder(new TitledBorder("Lista de Lembretes"));
		PainelTabela.setFont(f);
		Scroll = new JScrollPane();

		DefaultTableModel Modelo = new DefaultTableModel(new String[] { "Dia","Hora",
				"Descrição", "Título", "Ano", "Mes" }, 0) {
			public boolean isCellEditable(int row, int col) {
				if (col == 0 || col == 1 || col == 2 || col == 3 || col == 4
						|| col == 5) {
					return false;
				}
				return true;
			}

			/**
							 * 
							 */
			private static final long serialVersionUID = 1L;
		};

		// Inciando Tabela
		Tabela = new JTable(Modelo);

		// Alinhar tabela a direita

		DefaultTableCellRenderer linhadireita2 = new DefaultTableCellRenderer();
		linhadireita2.setHorizontalAlignment(SwingConstants.CENTER);
		Tabela.getColumnModel().getColumn(0).setCellRenderer(linhadireita2);

		// Editando as colunas

		// Coluna 0
		Tabela.getColumnModel().getColumn(0).setPreferredWidth(40);
		Tabela.getColumnModel().getColumn(0).setResizable(false);
		Tabela.getColumnModel().getColumn(0).setCellRenderer(linhadireita2);

		// Coluna 1
		Tabela.getColumnModel().getColumn(1).setPreferredWidth(80);
		Tabela.getColumnModel().getColumn(1).setResizable(false);

		Tabela.getColumnModel().getColumn(1).setCellRenderer(linhadireita2);

		// Coluna 2
		Tabela.getColumnModel().getColumn(2).setPreferredWidth(350);
		Tabela.getColumnModel().getColumn(2).setResizable(false);

		Tabela.getColumnModel().getColumn(2).setCellRenderer(linhadireita2);

		// Coluna 3
		Tabela.getColumnModel().getColumn(3).setPreferredWidth(350);
		Tabela.getColumnModel().getColumn(3).setResizable(false);

		Tabela.getColumnModel().getColumn(3).setCellRenderer(linhadireita2);

		// Coluna 4
		Tabela.getColumnModel().getColumn(4).setPreferredWidth(50);
		Tabela.getColumnModel().getColumn(4).setResizable(false);

		Tabela.getColumnModel().getColumn(4).setCellRenderer(linhadireita2);

		// Coluna 4
		Tabela.getColumnModel().getColumn(5).setPreferredWidth(150);
		Tabela.getColumnModel().getColumn(5).setResizable(false);

		Tabela.getColumnModel().getColumn(5).setCellRenderer(linhadireita2);

		planodefundo.add(PainelTabela);

		Tabela.getTableHeader().setReorderingAllowed(false);
		Tabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		Scroll.setViewportView(Tabela);
		PainelTabela.setBounds(50, 200, 690, 350);
		Scroll.setBounds(15, 20, 653, 310);
		PainelTabela.add(Scroll);
		Tabela.setBackground(Color.DARK_GRAY);
		Tabela.setForeground(Color.black);
		Tabela.setCellSelectionEnabled(true);
		Tabela.setBackground(Color.getHSBColor(0, 342, 180));

		ControleConsultar c = new ControleConsultar();
		ok.addActionListener(c);
	}

}
