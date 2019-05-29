
public class Alumne {
	private String nom;
	private int eval1;
	private int eval2;
	private int eval3;

	public Alumne(String nom, int eval1, int eval2, int eval3) {
		super();
		this.nom = nom;
		this.eval1 = eval1;
		this.eval2 = eval2;
		this.eval3 = eval3;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public int getEval1() {
		return eval1;
	}
	
	public void setEval1(int eval1) {
		this.eval1 = eval1;
	}
	
	public int getEval2() {
		return eval2;
	}
	
	public void setEval2(int eval2) {
		this.eval2 = eval2;
	}
	
	public int getEval3() {
		return eval3;
	}
	
	public void setEval3(int eval3) {
		this.eval3 = eval3;
	}
	
	@Override
	public String toString() {
		return nom + "\t\t\t" + eval1 + "\t\t" + eval2 + "\t\t" + eval3 + "\t\t" + (eval1+eval2+eval3)/3;
	}
	
}
