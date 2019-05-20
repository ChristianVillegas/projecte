import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ProjecteMain {

	String seleccio;
	
	public static String menu() {
		System.out.println("PROJECTE MANTENIMENT NOTES ASSIGNATURA\n\nMenú:\n\na-Afegir.\nm-Mostrar.\nt-Aprovar.\nn-Canviar nom.\nc-Canviar nota.\nQ-Ajuda.\nx-Sortir.\n");
		System.out.println("Quina opció vols escollir? ");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String A = reader.readLine();
		seleccio = Integer.parseInt(A);
      
    global dades
    global alumnes
    global total
    
    	if (seleccio == "a") {
    		alumnes = pregunta();
    		inserir(alumnes,dades,eval_1,eval_2,eval_3);
    	}

    	if (seleccio == "m") {
    		if (total != 0) {
    			mostrar(total,dades,eval_1,eval_2,eval_3);
    		} else {
    			System.out.println("Error! No hi han dades a mostrar.\n");
    		}
    	}
    
    	if (seleccio == "t") {
    		if (total != 0) {
    			aprovar(eval_1,eval_2,eval_3);
    			mostrar(total,dades,eval_1,eval_2,eval_3);
    		} else {
    			System.out.println("Error! No hi han notes per aprovar.\n");
    		}
    	}
    
    	if (seleccio == "n") {
    		try {
    			index = buscar(dades);
    			renombrar(dades,index);
    		} catch (NameErrorException nominc) {
				System.out.println("Error! Aquest alumne no està afegit.\n");
    		}
    	}
    		
    	if (seleccio == "c") {
    		try {
    			index = buscar(dades);
    			notes = evaluacio();
    			canvi(index,notes);
    		} catch (NameErrorException nominc) {
    			System.out.println("Error! Aquest alumne no està afegit.\n");
    		}
    	}
        
    	if (seleccio == "Q") {
    		ajuda(seleccio);
    	}
        
    	return seleccio;
    		
	}
    
	public static Alumne pregunta() {
		while (True) {
			try {
				//Este paso con dar el número de valores totales del ArrayList es suficioente.
				System.out.println("Quants alumnes tens? ");
				String n1 = reader.readLine();
				A = Integer.parseInt(n1);
				while (Alumne <1 || Alumne >50) {
					System.out.println("Error! El número d'alumnes ha de ser entre 1 i 50.");
					System.out.println("Quants alumnes tens? ");
				}
				return Alumne;
			} catch (NameErrorException numinc) {
					System.out.println("Error! Has d'afegir un número d'alumnes.");
			} catch (Exception n) {
					System.out.println("Error! Has d'afegir un número d'alumnes.");
			}
		}
	}
    
	public static void inserir(Alumne,dades) {
		//Método asociado a la clase Alumne, recogerá los datos introducidos.
		for (i=0; i < Alumne.size(); i++) {
			correctName = False;
			while (correctName == False) {
				try {
					System.out.println("Introdueix el nom de l'alumne: ");
					String n1 = reader.readLine();
					A = Integer.parseInt(n1);
					dades.add(nom);
					correctName = True;
				} catch (SyntaxErrorException maladada) {
					System.out.println("Error! Has d'afegir un nom.");
				} catch (Exception n) {
					System.out.println("Error! Has d'afegir un nom.");
				}
			}
		correct1 = False;
		correct2 = False;
		correct3 = False;
		while correct1 == False:
			try:
				n1 = input("Introdueix la nota de la primera evaluació: ")
				while n1 < 0 or n1 > 10:
					print ("Error! La nota ha de ser entre 0 i 10.")
					n1 = input("Introdueix la nota de la primera evaluació: ")
				eval_1.append(n1)
				correct1 = True
		
			except NameError:
				print ("Error! Has d'introduir un número.")
			except:
				print ("Error! Has d'introduir un número.")
		
		while correct2 == False:
			try:  
				n2 = input("Introdueix la nota de la segona evaluació: ")
				while n2 < 0 or n2 > 10:
					print ("Error! La nota ha de ser entre 0 i 10.")
					n2 = input("Introdueix la nota de la segona evaluació: ")
				eval_2.append(n2)
				correct2 = True
			
			except NameError:
				print ("Error! Has d'introduir un número.")
			except:
				print ("Error! Has d'introduir un número.")
			
		while correct3 == False:
			try:
				n3 = input("Introdueix la nota de la tercera evaluació: ")
				while n3 < 0 or n3 > 10:
					print ("Error! La nota ha de ser entre 0 i 10.")
					n3 = input("Introdueix la nota de la tercera evaluació: ")
				eval_3.append(n3)
				correct3 = True
			
			except NameError:
				print ("Error! Has d'introduir un número.")
			except:
				print ("Error! Has d'introduir un número.")
			
    print("Ja estan totes les dades desades." + "\n")
    global total
    total += alumnes
		}
	}
	
    public static void mostrar(total,dades,eval_1,eval_2,eval_3) {
    	del resultats[:]
    	for i in range (total):
    		final = (eval_1[i] + eval_2[i] + eval_3[i]) / 3
    		resultats.append(str(dades[i]) + "\t\t\t" + str(eval_1[i]) + "\t\t" + str(eval_2[i]) + "\t\t" + str(eval_3[i]) + "\t\t" + str(float(final)))
                
    		System.out.println("alumnes			1ra		2na		3ra		final");
    		System.out.println("------------------------------------------------------------------------------");
    	for i in resultats:
    		System.out.println((i) + "\n");
    
    public static void aprovar(eval_1,eval_2,eval_3) {
    	for i in range(len(eval_1)):
    		if eval_1[i] < 5:
    			eval_1[i] = 5
    	for i in range(len(eval_2)):
    		if eval_2[i] < 5:
    			eval_2[i] = 5
    	for i in range(len(eval_3)):
    		if eval_3[i] < 5:
    			eval_3[i] = 5
    }
    
    public static int buscar(dades) {
    	posicio = raw_input("De quin alumne vols fer canvis? ")
    	for i in range(len(dades)):
    		if posicio == dades[i]:
    			index = i
    			return index
    	while posicio != dades[i]:
    		System.out.println("Error! Aquest alumne no està registrat.");
    		buscar(dades)
    }
			
    public static int renombrar(dades,index) {
			nom2 = raw_input("Quin nou nom li vols possar? ")
			dades[index] = nom2
			return dades;
    }
 
    public static int evaluacio() {
    	notes = raw_input("La nota de quina evaluació vols canviar? (1, 2, 3): ")
    	while notes != "1" and notes != "2" and notes != "3":
    		System.out.println("Error! Aquesta evaluació no existeix.");
    		notes = raw_input("La nota de quina evaluació vols canviar? ")
    	return notes;
    }

    public static void canvi(index,notes) {    
    	nova = input("Introdueix la nova nota: ")
    	while nova < 0 or nova > 10:
    		System.out.println("Error! Les notes han de ser entre 0 i 10.");
        	nova = input("Introdueix la nova nota: ")
        if notes == "1":
        	eval_1[index] = nova
        if notes == "2":
        	eval_2[index] = nova
        if notes == "3":
        	eval_3[index] = nova
    }
    
    public static void ajuda(Q) {
    	System.out.println("\nAJUDA DEL MENÚ:\n\n(a-Afegir) Afegeix el nom de l'alumne i les notes de cada evaluació.\n(m-Mostrar) Mostra per pantalla les dades de tots els alumnes amb les notes de cada evaluació i la seva mitjana final.\n(t-Aprovar) Puja a 5 les notes de totes les evaluacions suspeses.\n(n-Canviar nom) Canvia el nom d'algun alumne existent.\n(c-Canviar nota) Canvia la nota d'alguna avaluació d'un alumne concret.\n(x-Sortir) Surt del programa." + "\n");
    }
    
dades=[]
eval_1=[]
eval_2=[]
eval_3=[]
resultats=[]
alumnes = 0
total = 0

	seleccio = menu()
	if (seleccio != "a" || seleccio != "m" || seleccio != "t" || seleccio != "c" || seleccio != "n" || seleccio != "Q") {
		System.out.println("Error! Aquest valor no selecciona cap acció del menú.\n");
	}
	while (seleccio != "x") {
		seleccio = menu();
	System.out.println("\nFi del programa");
	}
}