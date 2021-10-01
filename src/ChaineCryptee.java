
public class ChaineCryptee {

	private String chaine;
	private int decalage;
	
	public static ChaineCryptee deCryptee(String s, int d) {
		return new ChaineCryptee(s, d);
	}
	
	public static ChaineCryptee deEnClair(String s, int d) {
		return new ChaineCryptee(new ChaineCryptee(s,-1*d).encrypte(),d);
	}
	
	private ChaineCryptee (String s, int d) {
		chaine = s;
		decalage = d;
	}
	
	private static char decaleCaractere(char c, int decalage) {
	    return (c < 'A' || c > 'Z')? c : (char)(((c - 'A' + decalage) % 26) + 'A');
	}
	
	public String decrypte() {
		return chaine;
	}
	
	public String encrypte() {
		String chiffre = "";
		char tp; 
		for(int i = 0; i < chaine.length(); i++) {
			tp = chaine.charAt(i);
			chiffre += decaleCaractere(tp , this.decalage);
			
		}
		return chiffre;
	}
	
	public static void main(String[] args) {
		
		String a = "AB"; int cp = 3;
		
		ChaineCryptee c = ChaineCryptee.deEnClair(a,cp);
		
		c.decrypte();
		System.out.println(c.enclair);
	}
}
