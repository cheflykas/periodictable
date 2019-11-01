package periodictable;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.border.Border;

public class Element{
	
	private JButton btn1;
	private JButton btn2;
	public int count = 0;
	private int numOfElements = 118;
	private int[] atomicNumber = new int[numOfElements];
	private String[] elementSymbol = new String[numOfElements];
	private String[] elementName = new String[numOfElements];
	private String[] group = new String[numOfElements];
	private String[] period = new String[numOfElements];
	private String[] atomicMass = new String[numOfElements];
	private String[] melting = new String[numOfElements];
	private String[] boiling = new String[numOfElements];
	private String[] HC = new String[numOfElements];
	private String[] EN = new String[numOfElements];
	
	public Element() {
		JFrame frame = new JFrame("Periodic Table");
		
		frame.setLayout(new BorderLayout());
		
		JToolBar toolbar = new JToolBar();
		JTextArea textArea = new JTextArea();
		JPanel panel = new JPanel();
		Dimension dim = new Dimension();
		dim.width = 300;
		textArea.setEditable(false);
		toolbar.setRollover(true);
		panel.setPreferredSize(dim);
		panel.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createEmptyBorder(5, 5, 5, 5), 
				BorderFactory.createTitledBorder("About Element")));
		
		btn1 = new JButton("Next Element");
		btn2 = new JButton("Other Button");
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
				textArea.append("*OTHER BUTTON*\n");
				count++;
			}
		});
		
		
		Container pane = frame.getContentPane();
		pane.add(panel, BorderLayout.WEST);
		pane.add(toolbar, BorderLayout.NORTH);
		pane.add(new JScrollPane(textArea), BorderLayout.CENTER);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1015, 625);
		frame.setVisible(true);
	}
	
	public void setValues(String[][] a) {
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
		}
	}
	
	public String add(int x) {
		String print = (atomicNumber[x] + "; "
				+  elementSymbol[x] +"; "
				+  elementName[x] +  "; "
				+  group[x]	   +  "; "
				+  period[x] +		  "; "
				+  atomicMass[x] +   "; "
				+  melting[x] + 	  "; "
				+  boiling[x] + 	  "; "
				+  HC[x] +            "; "
				+  EN[x]);
		return print;
	}

}
