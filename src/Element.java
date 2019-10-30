
public class Element {

	private int atomicNumber;
	private String elementSymbol;
	private String elementName;
	private String group;
	private String period;
	private String atomicMass;
	private String melting;
	private String boiling;
	private String EN;
	
	public Element(String[] a) {
		// TODO Auto-generated constructor stub
		
		atomicNumber = Integer.parseInt(a[0]);
		elementSymbol = a[1];
		elementName = a[2];
		group = a[3];
		period = a[4];
		atomicMass = a[5];
		melting = a[6];
		boiling = a[7];
		EN = a[9];
		
	}
	
	public void add() {
		System.out.println(atomicNumber + "; "
						+  elementSymbol +"; "
						+  elementName +  "; "
						+  group	   +  "; "
						+  period +		  "; "
						+  atomicMass +   "; "
						+  melting + 	  "; "
						+  boiling + 	  "; "
						+  EN +			  "; ");
	}

}
