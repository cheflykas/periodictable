import java.io.*;
import java.util.*;
import javax.swing.JFrame;	
import apcs.Window;

public class main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Window.size(812, 500);
		Scanner sc = new Scanner(new File("Periodic Table.txt"));
		String[] data = new String[10];
		for(int r = 0; r < 118; r++) {
			for(int c = 0; c < 10; c++) {
				String input = sc.next();
//				System.out.print(input + "; ");
				data[c] = input;
			}
			Element element = new Element(data);
			element.add();
		}
	}

}
