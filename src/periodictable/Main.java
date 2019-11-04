package periodictable;
import java.io.*;
import java.util.*;
import javax.swing.*;

import apcs.Window;

public class Main {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(new File("Periodic Table.txt"));
		String[][] data = new String[118][10];
		
		for(int r = 0; r < 118; r++) {
			for(int c = 0; c < 10; c++) {
				String input = sc.next();
				data[r][c] = input;
			}
		}
		
		Element.setValues(data);
		
		Element element = new Element();
		for(int r = 0; r < data.length; r++) {
			System.out.println(element.console(r));
		}
		sc.close();
	}

}
