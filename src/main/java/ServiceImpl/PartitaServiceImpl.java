package ServiceImpl;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import Service.ILogic;
import it.univaq.disim.lpo.Model.Alfiere;
import it.univaq.disim.lpo.Model.Cavallo;
import it.univaq.disim.lpo.Model.Giocatore;
import it.univaq.disim.lpo.Model.Partita;
import it.univaq.disim.lpo.Model.Pedone;
import it.univaq.disim.lpo.Model.Pezzo;
import it.univaq.disim.lpo.Model.Re;
import it.univaq.disim.lpo.Model.Regina;
import it.univaq.disim.lpo.Model.Torre;

public class PartitaServiceImpl extends Partita implements Serializable {
	public PartitaServiceImpl(String nomePartita) {
		super(nomePartita);
		// TODO Auto-generated constructor stub
	}

	ScacchieraServiceImpl inizializzaPartita(Giocatore giocatore1, Giocatore giocatore2) {

		// Sezione Creazione della scacchiera e Dei Pezzi
		Table<Integer, Character, Pezzo> scacchiera = HashBasedTable.create(8,8);
		ScacchieraServiceImpl scacchieraDaGioco = new ScacchieraServiceImpl(scacchiera);
		// PedoneModel
		List<Pezzo> pezziB = new ArrayList<>();
		List<Pezzo> pedoniB = new ArrayList<>();
		
		Pezzo pedoneB1 = new Pedone("PB1", true, 'B');
		Pezzo pedoneB2 = new Pedone("PB2", true, 'B');
		Pezzo pedoneB3 = new Pedone("PB3", true, 'B');
		Pezzo pedoneB4 = new Pedone("PB4", true, 'B');
		Pezzo pedoneB5 = new Pedone("PB5", true, 'B');
		Pezzo pedoneB6 = new Pedone("PB6", true, 'B');
		Pezzo pedoneB7 = new Pedone("PB7", true, 'B');
		Pezzo pedoneB8 = new Pedone("PB8", true, 'B');

		// PedoneService

		// Add
		pezziB.add(pedoneB1);
		pezziB.add(pedoneB2);
		pezziB.add(pedoneB3);
		pezziB.add(pedoneB4);
		pezziB.add(pedoneB5);
		pezziB.add(pedoneB6);
		pezziB.add(pedoneB7);
		pezziB.add(pedoneB8);

		pedoniB.add(pedoneB1);
		pedoniB.add(pedoneB2);
		pedoniB.add(pedoneB3);
		pedoniB.add(pedoneB4);
		pedoniB.add(pedoneB5);
		pedoniB.add(pedoneB6);
		pedoniB.add(pedoneB7);
		pedoniB.add(pedoneB8);

		giocatore1.setPedoni(pedoniB);
		// AlfiereModel
		Pezzo alfiereB1 = new Alfiere("AB1", true, 'B');
		Pezzo alfiereB2 = new Alfiere("AB2", true, 'B');

		// AlfiereService

		// Add
		pezziB.add(alfiereB1);
		pezziB.add(alfiereB2);

		// TorreModel
		Pezzo torreB1 = new Torre("TB1", true, 'B');
		Pezzo torreB2 = new Torre("TB2", true, 'B');

		// TorreService
		// Add
		pezziB.add(torreB1);
		pezziB.add(torreB2);

		// ReModel
		Pezzo reB = new Re("RB1", true, 'B');
		giocatore1.setRe(reB);
		// ReService

		// Add
		pezziB.add(reB);
		
		// ReginaModel
		Pezzo reginaB = new Regina("rB1", true, 'B');

		// ReginaService
		// Add
		pezziB.add(reginaB);

		// CavalloModel
		Pezzo cavalloB1 = new Cavallo("CB1", true, 'B');

		Pezzo cavalloB2 = new Cavallo("CB2", true, 'B');
		
		// CavalloService

		// Add
		pezziB.add(cavalloB1);
		pezziB.add(cavalloB2);
		
		giocatore1.setPezzi(pezziB);
		
		List<Pezzo> pezziN = new ArrayList<>();
		List<Pezzo> pedoniN = new ArrayList<>();
		
		// PedoneModel

		Pezzo pedoneN1 = new Pedone("PN1", true, 'N');
		Pezzo pedoneN2 = new Pedone("PN2", true, 'N');
		Pezzo pedoneN3 = new Pedone("PN3", true, 'N');
		Pezzo pedoneN4 = new Pedone("PN4", true, 'N');
		Pezzo pedoneN5 = new Pedone("PN5", true, 'N');
		Pezzo pedoneN6 = new Pedone("PN6", true, 'N');
		Pezzo pedoneN7 = new Pedone("PN7", true, 'N');
		Pezzo pedoneN8 = new Pedone("PN8", true, 'N');

		// PedoneService

		// Add
		pezziN.add(pedoneN1);
		pezziN.add(pedoneN2);
		pezziN.add(pedoneN3);
		pezziN.add(pedoneN4);
		pezziN.add(pedoneN5);
		pezziN.add(pedoneN6);
		pezziN.add(pedoneN7);
		pezziN.add(pedoneN8);

		pedoniN.add(pedoneN1);
		pedoniN.add(pedoneN2);
		pedoniN.add(pedoneN3);
		pedoniN.add(pedoneN4);
		pedoniN.add(pedoneN5);
		pedoniN.add(pedoneN6);
		pedoniN.add(pedoneN7);
		pedoniN.add(pedoneN8);

		giocatore2.setPedoni(pedoniN);
		// AlfiereModel
		Pezzo alfiereN1 = new Alfiere("AN1", true, 'N');
		Pezzo alfiereN2 = new Alfiere("AN2", true, 'N');

		// AlfiereService

		// Add
		pezziN.add(alfiereN1);
		pezziN.add(alfiereN2);

		// TorreModel
		Pezzo torreN1 = new Torre("TN1", true, 'N');
		Pezzo torreN2 = new Torre("TN2", true, 'N');

		// TorreService
		// Add
		pezziN.add(torreN1);
		pezziN.add(torreN2);

		// ReModel
		Pezzo reN = new Re("RN1", true, 'N');
		giocatore2.setRe(reN);
		// ReService

		// Add
		pezziN.add(reN);

		// ReginaModel
		Pezzo reginaN = new Regina("rN1", true, 'N');

		// ReginaService
		// Add
		pezziN.add(reginaN);

		// CavalloModel
		Pezzo cavalloN1 = new Cavallo("CN1", true, 'N');

		Pezzo cavalloN2 = new Cavallo("CN2", true, 'N');

		// CavalloService

		// Add
		pezziN.add(cavalloN1);
		pezziN.add(cavalloN2);
		giocatore2.setPezzi(pezziN);
		scacchieraDaGioco = scacchieraDaGioco.creaScacchiera(pezziB, pezziN);
		scacchieraDaGioco.stampaScacchiera(scacchieraDaGioco);
		return scacchieraDaGioco;
		// Chiamata Funzione turno(Giocatore) che in GiocatoreServiceImpl chiamerà
		// questa funzione

	}

	// Metodo Da inserire nella Classe Giocatore.
	// E' stato implementato qui solo per prova.

	public void scegliTipologiaPartita() {
		
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Scegli la tipologia della partita:" + "\n" + " 0 - Giocatore1 vs Giocatore 2;"
					+ "\n 1 - Giocatore1 vs Computer;" + "\n 2 - Computer vs Computer");

			String input = scanner.nextLine();

			if (input.equals("0")) {

				Giocatore giocatore1 = new UtenteServiceImpl("giocatore1", null, null, null);
				Giocatore giocatore2 = new UtenteServiceImpl("giocatore2", null, null, null);
				ScacchieraServiceImpl scacchiera = new ScacchieraServiceImpl(null);
				scacchiera = inizializzaPartita(giocatore1,giocatore2);
				((ILogic) giocatore1).turno(giocatore2, scacchiera, this);

			} else if (input.equals("1")) {
				Giocatore giocatore1 = new UtenteServiceImpl("giocatore1", null, null, null);
				Giocatore giocatore2 = new ComputerServiceImpl("computer", null, null, null);
				ScacchieraServiceImpl scacchiera = new ScacchieraServiceImpl(null);
				scacchiera = inizializzaPartita(giocatore1,giocatore2);
				scacchiera.stampaScacchiera(scacchiera);
				((ILogic) giocatore1).turno(giocatore2, scacchiera, this);

			} else if ((input.equals("2"))) {

				Giocatore giocatore1 = new ComputerServiceImpl("computer1", null, null, null);
				Giocatore giocatore2 = new ComputerServiceImpl("computer2", null, null, null);
				ScacchieraServiceImpl scacchiera = new ScacchieraServiceImpl(null);
				scacchiera = inizializzaPartita(giocatore1,giocatore2);
				scacchiera.stampaScacchiera(scacchiera);
				((ILogic) giocatore1).turno(giocatore2, scacchiera, this);

			}else {
				System.out.println("input sbagliato" );
				throw new IllegalArgumentException();
			}
				
			
		} catch (IllegalArgumentException e) {
			System.out.println("Non è stato digitato alcun input");
			System.out.println("L'input è: " + e.getMessage());

		}

	}

	
	public void resa() {
		// TODO Auto-generated method stub

	}

	
	public boolean scaccoMatto(ScacchieraServiceImpl scacchiera, Giocatore giocatore2, Giocatore giocatore1) {
		
			Re re = (Re) giocatore1.getRe();
			List<String> temp = re.mosseValide(scacchiera);
			
			// Elimino le mosse valide del re che possono portarlo in scacco
			try {
				Iterator<String> iterator = temp.iterator();
				while (iterator.hasNext()) {
					String s = iterator.next();
					if (re.scacco(scacchiera, s, giocatore2) == true) {
						iterator.remove();
					}
				}

			} catch (Exception e) {
				e.printStackTrace();
				e.getCause();
			}
		
		
			
			if (temp.isEmpty()) {
				return true;
			}
		

		return false;
	}

	
	public void patta() {

		System.out.println("La partita è finita in patta. Non c'e' nessun vincitore");
		File file; 
		String logPath = new File("src/main/resources/files/log.txt").getAbsolutePath();
		
		// Commentare se si vuole vedere il log delle mosse del computer.
		file = new File(logPath);
		if(file.exists()) {
			file.delete();
		}
		System.exit(0);	}

	
	public void fine(Giocatore giocatore) {
		System.out.println("Partita Finita, ha vinto il giocatore: " + giocatore.getNomeGiocatore());
		File file; 
		String logPath = new File("src/main/resources/files/log.txt").getAbsolutePath();
		file = new File(logPath);
		if(file.exists()) {
			file.delete();
		}
		System.exit(0);
	}

}
