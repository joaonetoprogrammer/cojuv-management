package Visao.Principal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import Controle.ControlePrincipal;
import Modelo.Administrador;
import Modelo.Lembrete;

public class TelaDeLembrete extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static JPanel PainelTabela;
	public static JLabel t;
	public static JButton b;

	// Tabela
	public static JTable Tabela;
	public static JLabel i;
	public static JLabel lo;

	// Scroll
	public static JScrollPane Scroll;
	// Criação dos JLabels

	public static JLabel titulo;
	public static JLabel titulo2;
	public static JLabel rodape;

	public static JTextField form;

	// Font
	Font minhafont;
	Font minhafont2;
	Font minhafont3;

	// Inserção de Imagens

	public JLabel PlanodeFundo;
	public JLabel barra;
	public JLabel barra2;
	public JLabel barra3;
	public JLabel barra4;

	public static JFrame Tela;

	public TelaDeLembrete() {

		Container f = getContentPane();
		setLayout(null);
		Tela = this;
		setSize(650, 560);
		setResizable(false);
		setLocationRelativeTo(null);

		minhafont = new Font("Eras Bold ITC", Font.BOLD, 30);
		minhafont2 = new Font("arial", Font.PLAIN, 25);
		minhafont3 = new Font("Eras Bold ITC", Font.BOLD | Font.ITALIC, 25);
		// Imagens

		// Plano de Fundo
		PlanodeFundo = new JLabel(new ImageIcon("Imagens/PlanodeFundo.jpg"));
		f.add(PlanodeFundo);
		PlanodeFundo.setBounds(0, 00, 1200, 700);
		PlanodeFundo.setLayout(null);

		// Barra1

		barra = new JLabel(new ImageIcon("Imagens/barra.png"));
		PlanodeFundo.add(barra);
		barra.setBounds(0, 10, 1200, 15);

		// Barra2

		barra2 = new JLabel(new ImageIcon("Imagens/barra.png"));
		PlanodeFundo.add(barra2);
		barra2.setBounds(0, 90, 1200, 15);

		// Barra3

		barra3 = new JLabel(new ImageIcon("Imagens/barra2.png"));
		PlanodeFundo.add(barra3);
		barra3.setBounds(0, 460, 1200, 15);

		// Barra4

		barra4 = new JLabel(new ImageIcon("Imagens/barra2.png"));
		PlanodeFundo.add(barra4);
		barra4.setBounds(0, 510, 1200, 15);

		// Insercao dos Jlabel

		// Ttitulo1

		PlanodeFundo.add(titulo = new JLabel("Hoje tem Lembretes!!!"));
		titulo.setFont(minhafont2);
		Dimension sizetitulo = titulo.getPreferredSize();
		titulo.setBounds(200, 30, sizetitulo.width, sizetitulo.height);

		// Titulo2
		PlanodeFundo.add(titulo2 = new JLabel("Coordenadoria de Juventude"));
		titulo2.setFont(minhafont2);
		Dimension sizetitulo2 = titulo2.getPreferredSize();
		titulo2.setBounds(150, 60, sizetitulo2.width, sizetitulo2.height);

		// Rodape
		PlanodeFundo.add(rodape = new JLabel("Prefeitura de Maranguape"));
		rodape.setFont(minhafont2);
		Dimension sizerodape = rodape.getPreferredSize();
		rodape.setBounds(180, 480, sizerodape.width, sizerodape.height);

		// Incializando
		PainelTabela = new JPanel(new BorderLayout());
		PainelTabela.setBorder(new TitledBorder("Lista de Lembretes"));
		PainelTabela.setFont(minhafont);
		Scroll = new JScrollPane();

		DefaultTableModel Modelo = new DefaultTableModel(new String[] {
				"Título", "Dia", "Descrição", "Mes", "Ano", "Hora" }, 0) {
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
		Tabela.getColumnModel().getColumn(0).setPreferredWidth(403);
		Tabela.getColumnModel().getColumn(0).setResizable(false);
		Tabela.getColumnModel().getColumn(0).setCellRenderer(linhadireita2);

		// Coluna 1
		Tabela.getColumnModel().getColumn(1).setPreferredWidth(40);
		Tabela.getColumnModel().getColumn(1).setResizable(false);

		Tabela.getColumnModel().getColumn(1).setCellRenderer(linhadireita2);

		// Coluna 2
		Tabela.getColumnModel().getColumn(2).setPreferredWidth(300);
		Tabela.getColumnModel().getColumn(2).setResizable(false);

		Tabela.getColumnModel().getColumn(2).setCellRenderer(linhadireita2);

		// Coluna 3
		Tabela.getColumnModel().getColumn(3).setPreferredWidth(200);
		Tabela.getColumnModel().getColumn(3).setResizable(false);

		Tabela.getColumnModel().getColumn(3).setCellRenderer(linhadireita2);

		// Coluna 4
		Tabela.getColumnModel().getColumn(4).setPreferredWidth(70);
		Tabela.getColumnModel().getColumn(4).setResizable(false);

		Tabela.getColumnModel().getColumn(4).setCellRenderer(linhadireita2);

		// Coluna 4
		Tabela.getColumnModel().getColumn(5).setPreferredWidth(100);
		Tabela.getColumnModel().getColumn(5).setResizable(false);

		Tabela.getColumnModel().getColumn(5).setCellRenderer(linhadireita2);

		PlanodeFundo.add(form = new JTextField(""));
		form.setBounds(1000, 100, 100, 50);
		PlanodeFundo.add(t = new JLabel("Sua lista de lembretes"));
		t.setFont(minhafont);
		t.setBounds(130, 100, 650, 50);

		PlanodeFundo.add(b = new JButton());
		b.setFont(minhafont);
		b.setBounds(230, 400, 180, 40);
		i = new JLabel(new ImageIcon("Imagens/fechar.png"));
		b.setLayout(null);
		b.add(i);
		i.setBounds(1, 1, 178, 38);
		i.setLayout(null);
		i.add(lo = new JLabel("Fechar"));
		lo.setBounds(46, 8, 100, 20);
		lo.setFont(minhafont3);

		PlanodeFundo.add(PainelTabela);

		Tabela.getTableHeader().setReorderingAllowed(false);
		Tabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		Scroll.setViewportView(Tabela);
		PainelTabela.setBounds(10, 150, 630, 240);
		Scroll.setBounds(15, 20, 603, 190);
		PainelTabela.add(Scroll);
		Tabela.setBackground(Color.DARK_GRAY);
		Tabela.setForeground(Color.black);
		Tabela.setCellSelectionEnabled(true);
		Tabela.setBackground(Color.getHSBColor(0, 342, 180));

		Administrador a = new Administrador();
		a.AtualizarData2();

		Lembrete l = new Lembrete();
		l.AtualizaTable();

		ControlePrincipal c = new ControlePrincipal();
		b.addActionListener(c);

	}

}
