package periodictable;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

import javax.imageio.ImageIO;
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
				+  elementSymbol[x] +  ") - A "
				+  category[x]);
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
		
		dimPanel.width = 250;
		textArea.setEditable(false);
		textArea.setFont(new Font("Consolas", Font.PLAIN, 12));
		toolbar.setRollover(true);
		sidepanel.setPreferredSize(dimPanel);
		sidepanel.setLayout(new BorderLayout());
		console.setPreferredSize(new Dimension(1600, 150));
		console.setLayout(new BorderLayout());
		console.add(new JScrollPane(textArea), BorderLayout.CENTER);
		mainPanel.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createEmptyBorder(5, 5, 5, 5), 
				BorderFactory.createTitledBorder("Choose Element")));
		sidepanel.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createEmptyBorder(5, 5, 5, 5), 
				BorderFactory.createTitledBorder("About Element")));
		console.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createEmptyBorder(5, 5, 5, 5), 
				BorderFactory.createTitledBorder("Console Output")));
		
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
	                textArea.append(add(indexOf) + "\n");
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
			JLabel name = new JLabel(elementName[i]);
			JLabel number = new JLabel(Integer.toString(atomicNumber[i]));
			name.setFont(new Font("Arial", Font.PLAIN, 10));
			number.setFont(new Font("Arial", Font.PLAIN, 8));
			name.setHorizontalAlignment(SwingConstants.CENTER);
			number.setHorizontalAlignment(SwingConstants.CENTER);
			buttons[index].addActionListener(listener);
			buttons[index].setPreferredSize(new Dimension(65, 65));
			buttons[index].add(name, BorderLayout.SOUTH);
			buttons[index].add(number, BorderLayout.NORTH);
			mainPanel.add(buttons[index]);
		}

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1600, 900);
		frame.setVisible(true);
	}

}
