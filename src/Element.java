import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class Element extends JFrame{

	private JButton btn;
	private JTextArea textArea;
	private JLabel text;
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
		super("Periodic Table");
		
		setLayout(new BorderLayout());
		
		btn = new JButton("Next Element");
		textArea = new JTextArea();
		
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea.append(add(count) + "\n");
				count++;
			}
		});
		
		add(new JScrollPane(textArea), BorderLayout.CENTER);
		add(btn, BorderLayout.SOUTH);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setSize(1015, 625);
		setSize(350, 500);
		setResizable(false);
		setVisible(true);
		
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
