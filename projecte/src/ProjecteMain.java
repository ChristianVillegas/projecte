import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class ProjecteMain {
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static ArrayList<Alumne> institut = new ArrayList<>();
	
	public static void main(String[] args) throws IOException{
				
		int seleccio = 9;
		
		while(seleccio != 0){
		System.out.println("PROJECTE MANTENIMENT NOTES ASSIGNATURA");
		System.out.println("=======================================\n");
		System.out.println("Quina opció vols escollir?\n");
		System.out.println("1) Afegir alumne");
		System.out.println("2) Mostrar informe de notes");
		System.out.println("3) Aprovar a tots");
		System.out.println("4) Canviar el nom");
		System.out.println("5) Canviar la nota");
		System.out.println("6) Ajuda");
		System.out.println("0) Sortir");
		String num = reader.readLine();
		seleccio = Integer.parseInt(num);

		switch(seleccio){
		case 1:
			 if (afegirAlumne()) {
                    System.out.println("Alumne i notes afegides correctament.\n");
                } else {
                    System.out.println("Hi ha hagut un problema amb la inserció de l'alumne, torna-ho a provar.\n");
                }
			break;
		case 2:
			if (institut.isEmpty()) {
				System.out.println("No hi ha cap alumne enregistrat!\n");
			} else {
				System.out.println("alumnes\t\t\t1ra\t\t2na\t\t3ra\t\tfinal");
				System.out.println("------------------------------------------------------------------------------");
				Iterator<Alumne> iter = institut.iterator();
                while (iter.hasNext()) {
                    Alumne p = iter.next();
                    System.out.println(p.toString());
                }
                System.out.println(" ");
			}
			break;
		case 3:
			if (institut.isEmpty()) {
                System.out.println("No hi ha cap alumne enregistrat!\n");
            } else {
            	Iterator<Alumne> iter = institut.iterator();
                while (iter.hasNext()) {
                    Alumne p = iter.next();
                    if (p.getEval1() < 5) {
                    	p.setEval1(5);
                    }
                    if (p.getEval2() < 5) {
                    	p.setEval2(5);
                    }
                    if (p.getEval3() < 5) {
                    	p.setEval3(5);
                    }
                }
            }
			break;						
		case 4:
			if (institut.isEmpty()) {
                System.out.println("No hi ha cap alumne enregistrat!\n");
            } else {
            	Iterator<Alumne> iter = institut.iterator();
            	System.out.println("De quin alumne vols canviar el nom? ");
            	String nomAlumne = reader.readLine();
            	boolean nomCanviat = false;
            	
            	while (iter.hasNext() && nomCanviat == false) {
	                Alumne a = iter.next();

	            	if (nomAlumne.equals(a.getNom())) {
	                	System.out.println("Quin nou nom vols posar? ");
	                	String nomNou = reader.readLine();
	            		a.setNom(nomNou);
	            		System.out.println("Nom canviat correctament.\n");
	            		nomCanviat = true;
            		}
	            }
            	 if (nomCanviat == false) {
         			System.out.println("Error! Aquest alumne no està enregistrat.\n");
         		}
            }
			break;
		case 5:
			if (institut.isEmpty()) {
                System.out.println("No hi ha cap alumne enregistrat!\n");
            } else {
            	System.out.println("De quin alumne vols canviar les notes? ");
            	String nomAlumne = reader.readLine();
            	boolean notes = false;
            	
            	Iterator<Alumne> iter = institut.iterator();
                while (iter.hasNext() && notes == false) {
                Alumne a = iter.next();
       
	            	if (nomAlumne.equals(a.getNom())) {
	            		System.out.println("De quina evaluació vols fer el canvi (1, 2, 3)? ");
	            		String eval = reader.readLine();
	            		int evaluacio = Integer.parseInt(eval);
	            		if (evaluacio == 1) {
	            			System.out.println("Quina nota nova vols possar? ");
	            			String n1 = reader.readLine();
	            			int nova1 = Integer.parseInt(n1);
	            			a.setEval1(nova1);
	            			System.out.println("Nota canviada correctament.\n");
	            			notes = true;
	            		}
	            		if (evaluacio == 2) {
	            			System.out.println("Quina nota nova vols possar? ");
	            			String n2 = reader.readLine();
	            			int nova2 = Integer.parseInt(n2);
	            			a.setEval2(nova2);
	            			System.out.println("Nota canviada correctament.\n");
	            			notes = true;
	            		}
	            		if (evaluacio == 3) {
	            			System.out.println("Quina nota nova vols possar? ");
	            			String n3 = reader.readLine();
	            			int nova3 = Integer.parseInt(n3);
	            			a.setEval3(nova3);
	            			System.out.println("Nota canviada correctament.\n");
	            			notes = true;
	                    }
	            	
	            	}
                }
            	if (notes == false) {
                    System.out.println("Error! Aquest alumne no està enregistrat.\n");
                }
            }
			break;	
		case 6:
			System.out.println("\nAJUDA DEL MENÚ:\n\n(1-Afegir alumne) Afegeix el nom de l'alumne i les notes de cada evaluació.\n(2-Mostrar informe de notes) Mostra per pantalla les dades de tots els alumnes amb les notes de cada evaluació i la seva mitjana final.\n(3-Aprovar a tots) Puja a 5 les notes de totes les evaluacions suspeses.\n(4-Canviar el nom) Canvia el nom d'algun alumne existent.\n(5-Canviar la nota) Canvia la nota d'alguna avaluació d'un alumne concret.\n(0-Sortir) Surt del programa." + "\n");
			break;
		case 0:
			System.out.println("Adeu!");
			break;	
		default:
			System.out.println("OPCIO INCORRECTA!!!");
		}
		}
	}

	public static boolean afegirAlumne() {
		try{
			System.out.println("Quin és el nom de l'alumne?");
			String nom = reader.readLine();

			System.out.println("Quina és la nota de la primera evaluació?");
			String nota1 = reader.readLine();
			int eval1 = Integer.parseInt(nota1);


			System.out.println("Quina és la nota de la segona evaluació?");
			String nota2 = reader.readLine();
			int eval2 = Integer.parseInt(nota2);
			
			System.out.println("Quina és la nota de la tercera evaluació?");
			String nota3 = reader.readLine();
			int eval3 = Integer.parseInt(nota3);
			 
			Alumne alumne = new Alumne(nom, eval1, eval2, eval3);
			
			institut.add(alumne);

			return true;
		}
		catch(Exception e){
			return false;
		}
	}
			
}
