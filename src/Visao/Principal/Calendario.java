package Visao.Principal;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Calendario extends JFrame implements ItemListener {

	private static final long serialVersionUID = 1L;

	public static JFrame Tela;

	public static JLabel planodefundo;
	public static JLabel barra;
	public static JLabel barra2;

	public static JLabel titulo;
	public static JLabel titulo3;

	public static JButton j1;

	public static JLabel imagem;
	ImageIcon[] imagens = { new ImageIcon("Imagens/janeiro.png"),
			new ImageIcon("Imagens/fevereiro.png"),
			new ImageIcon("Imagens/março.png"),
			new ImageIcon("Imagens/abril.png"),
			new ImageIcon("Imagens/maio.png"),
			new ImageIcon("Imagens/junho.png"),
			new ImageIcon("Imagens/julho.png"),
			new ImageIcon("Imagens/agosto.png"),
			new ImageIcon("Imagens/setembro.png"),
			new ImageIcon("Imagens/outubro.png"),
			new ImageIcon("Imagens/novembro.png"),
			new ImageIcon("Imagens/dezembro.png") };

	public static JComboBox<String> combo;

	public static Font f;

	public Calendario() {
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

		planodefundo.add(titulo = new JLabel(
				"Coordenadoria de Juventude - Calendários!!!"));
		titulo.setBounds(130, 25, 600, 30);
		titulo.setFont(f);

		planodefundo.add(combo = new JComboBox<String>());
		combo.setBounds(410, 90, 350, 30);
		combo.setFont(f);

		planodefundo.add(imagem = new JLabel(imagens[0]));
		imagem.setBounds(50, 130, 702, 502);

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
		// combo.setForeground(Color.getHSBColor(0, 342, 1800));

		combo.addItemListener(this);

		planodefundo
				.add(titulo3 = new JLabel("Selecione o mês a Visualizar: "));
		titulo3.setBounds(40, 90, 700, 30);
		titulo3.setFont(f);

	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			imagem.setIcon(imagens[combo.getSelectedIndex()]);

		}

	}

}
