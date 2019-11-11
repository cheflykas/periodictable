package periodictable;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.RoundRectangle2D;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.Border;

public class Element{
	
	private JButton btn1;
	private JButton btn2;
	public int count = 0;
	public int index = 0;
	private static int numOfElements = 118;
	private JButton[] buttons = new JButton[numOfElements];
	private static int[] atomicNumber = new int[numOfElements];
	private static String[] elementSymbol = new String[numOfElements];
	private static String[] elementName = new String[numOfElements];
	private static String[] group = new String[numOfElements];
	private static String[] period = new String[numOfElements];
	private static String[] atomicMass = new String[numOfElements];
	private static String[] melting = new String[numOfElements];
	private static String[] boiling = new String[numOfElements];
	private static String[] HC = new String[numOfElements];
	private static String[] EN = new String[numOfElements];
	private static String[] category = new String[numOfElements];
	
	public static void setValues(String[][] a) {
		for(int r = 0; r < a.length; r++) {
			atomicNumber[r] = Integer.parseInt(a[r][0]);
			elementSymbol[r] = a[r][1];
			elementName[r] = a[r][2];
			group[r] = a[r][3];
			period[r] = a[r][4];
			atomicMass[r] = a[r][5];
			melting[r] = a[r][6];
			boiling[r] = a[r][7];
			HC[r] = a[r][8];
			EN[r] = a[r][9];
			category[r] = a[r][10];
		}
	}
	
	public String add(int x) {
		return (atomicNumber[x] + ": "
				+  elementName[x] + " ("
				+  elementSymbol[x] +  ") - "
				+  category[x] + "; "
				+  atomicMass[x] + "; " 
				+  EN[x]);
	}
	
	public String console(int x) {
		return (atomicNumber[x] + ": "
				+  elementName[x] + " ("
				+  elementSymbol[x] +  ") "
				+  group[x] + "; "
				+  period[x] + "; "
				+  atomicMass[x] + "; "
				+  melting[x] + "; "
				+  boiling[x] + "; "
				+  HC[x] + "; "
				+  EN[x] + "; " + category[x]);
	}


	public void border(Component c, String text) {
		((JComponent) c).setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createEmptyBorder(5, 5, 5, 5), 
				BorderFactory.createTitledBorder(text)));
		
	}
	
	public Element() {
		
		JFrame frame = new JFrame("Periodic Table");
		Image image = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/resources/icon.PNG"));
		frame.setIconImage(image);
		frame.setLayout(new BorderLayout());
		
		
		JToolBar toolbar = new JToolBar();
		JTextArea textArea = new JTextArea();
		JPanel sidepanel = new JPanel();
		JPanel mainPanel = new JPanel();
		JPanel console = new JPanel();
		Dimension dimPanel = new Dimension();
		
		dimPanel.width = 275;
		textArea.setEditable(false);
		textArea.setFont(new Font("Consolas", Font.PLAIN, 12));
		toolbar.setRollover(true);
		sidepanel.setPreferredSize(dimPanel);
		console.setPreferredSize(new Dimension(1600, 150));
		console.setLayout(new BorderLayout());
		console.add(new JScrollPane(textArea), BorderLayout.CENTER);
		border(mainPanel, "Choose Element");
		border(sidepanel, "About Element");
		border(console, "Console Output");
		
		btn1 = new JButton("Next Element");
		btn2 = new JButton("Window Size");
		toolbar.add(btn1);
		toolbar.add(btn2);
		toolbar.setBorder(BorderFactory.createEtchedBorder());
		toolbar.addSeparator();
		
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea.append(add(count) + "\n");
				count++;
			}
		});

		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Dimension size = frame.getBounds().getSize();
				int w = size.width;
				int h = size.height;
				textArea.append("SIZE IS:" + w + " x " + h + "\n");
			}
		});

		ActionListener listener = new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            if (e.getSource() instanceof JButton) {
	                String text = ((JButton) e.getSource()).getText();
	                int indexOf = Arrays.asList(elementSymbol).indexOf(text);
	                String[] labels = {"About", "Element"};
	                String[][] data = {{"Atomic Number (Z)", Integer.toString(atomicNumber[indexOf])},
				                		{"Atomic Weight", atomicMass[indexOf]},
				                		{"Group", group[indexOf]},
				                		{"Period", period[indexOf]},
				                		{"Category", category[indexOf]},
				                		{"Melting Point (K)", melting[indexOf]},
				                		{"Boiling Point (K)", boiling[indexOf]},
				                		{"Electronegativity", EN[indexOf]}};
	                
	                textArea.append(add(indexOf) + "\n");
	                JButton about = new JButton(elementSymbol[indexOf]);
	                JLabel number = new JLabel(Integer.toString(atomicNumber[indexOf]));
	                JLabel name = new JLabel(elementName[indexOf]);
	                JTable info = new JTable(data, labels);
	                name.setFont(new Font("Arial", Font.BOLD, 15));
	    			number.setFont(new Font("Arial", Font.BOLD, 20));
	    			name.setHorizontalAlignment(SwingConstants.CENTER);
	    			number.setHorizontalAlignment(SwingConstants.CENTER);
	                about.setLayout(new BorderLayout());
	                about.setFont(new Font("Arial", Font.BOLD, 70));
	                about.setPreferredSize(new Dimension(150, 150));
	                about.setBackground(buttons[indexOf].getBackground());
	                about.add(number, BorderLayout.NORTH);
	                about.add(name, BorderLayout.SOUTH);
	                sidepanel.removeAll();
	                sidepanel.revalidate();
	                sidepanel.repaint();
	                sidepanel.add(about);
	                sidepanel.add(new JLabel(add(indexOf)));
	                sidepanel.add(info);
	                
	                frame.validate();
	            }
	        }
	    };
		
		Container pane = frame.getContentPane();
		pane.add(sidepanel, BorderLayout.WEST);
		pane.add(toolbar, BorderLayout.NORTH);
		pane.add(mainPanel, BorderLayout.CENTER);
		pane.add(console, BorderLayout.SOUTH);

		for(int i = 0; i < buttons.length; i++) {
			index = i;
			buttons[index] = new JButton(elementSymbol[i]);
			buttons[index].setLayout(new BorderLayout());
			buttons[index].setFont(new Font("Arial", Font.BOLD, 20));
			if(category[index].equals("NMetal")) {
				buttons[index].setBackground(new Color(240, 255, 140));
			} else if (category[index].equals("Alkali")) {
				buttons[index].setBackground(new Color(255, 100, 100));
			} else if (category[index].equals("AEarth")) {
				buttons[index].setBackground(new Color(255, 225, 175));
			} else if (category[index].equals("Lanthanide")) {
				buttons[index].setBackground(new Color(255, 190, 255));
			} else if (category[index].equals("Actinide")) {
				buttons[index].setBackground(new Color(255, 150, 200));
			} else if (category[index].equals("Trans")) {
				buttons[index].setBackground(new Color(255, 190, 190));
			} else if (category[index].equals("PostTr")) {
				buttons[index].setBackground(new Color(200, 200, 200));
			} else if (category[index].equals("MLoid")) {
				buttons[index].setBackground(new Color(200, 200, 150));
			} else if (category[index].equals("NobleG")) {
				buttons[index].setBackground(new Color(190, 255, 255));
			}  else {
				buttons[index].setBackground(new Color(230, 230, 230));
			}
			JLabel name = new JLabel(elementName[i]);
			JLabel number = new JLabel(Integer.toString(atomicNumber[i]));
			name.setFont(new Font("Arial", Font.PLAIN, 10));
			number.setFont(new Font("Arial", Font.PLAIN, 10));
			name.setHorizontalAlignment(SwingConstants.CENTER);
			number.setHorizontalAlignment(SwingConstants.CENTER);
			buttons[index].setPreferredSize(new Dimension(65, 65));
			buttons[index].add(name, BorderLayout.SOUTH);
			buttons[index].add(number, BorderLayout.NORTH);
			buttons[index].addActionListener(listener);
			mainPanel.add(buttons[index]);
		}

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1600, 900);
		frame.setVisible(true);
	}

}
