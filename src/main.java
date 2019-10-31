import java.io.*;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.JLabel;

import apcs.Window;

public class main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(new File("Periodic Table.txt"));
		String[][] data = new String[118][10];
		
		JFrame frame = new JFrame("Periodic Table");
		JLabel text;
		
		for(int r = 0; r < 118; r++) {
			for(int c = 0; c < 10; c++) {
				String input = sc.next();
//				System.out.print(input + "; ");
				data[r][c] = input;
			}
//			System.out.println();
		}
		
		Element element = new Element();
		element.setValues(data);
		for(int r = 0; r < data.length; r++) {
			System.out.println(element.add(r));
		}
	}

}
