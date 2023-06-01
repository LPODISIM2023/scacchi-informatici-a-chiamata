package ServiceImpl;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

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

	/**
	 * 
	 */
	private static final long serialVersionUID = -3421389270663756285L;

	/**
	 * 
	 */

	/**
	 * 
	 */

	/**
	 * 
	 */
	public PartitaServiceImpl() {
		super();
	}

	public PartitaServiceImpl(String nomePartita, int idPartita, ScacchieraServiceImpl scacchiera, Giocatore giocatore1,
			Giocatore giocatore2, Integer contatoreMosse, Integer numeroPezzi, Integer punteggio) {
		super(nomePartita, idPartita, scacchiera, giocatore1, giocatore2, contatoreMosse, numeroPezzi, punteggio);
		// TODO Auto-generated constructor stub
	}

	ScacchieraServiceImpl inizializzaPartita(Giocatore giocatore1, Giocatore giocatore2) {

		// Sezione Creazione della scacchiera e Dei Pezzi
		int punteggioIniziale;
		Table<Integer, Character, Pezzo> scacchiera = HashBasedTable.create(8, 8);
		ScacchieraServiceImpl scacchieraDaGioco = new ScacchieraServiceImpl(scacchiera);

		// PedoneModel
		List<Pezzo> pezziB = new ArrayList<>();
		List<Pezzo> pedoniB = new ArrayList<>();

		Pezzo pedoneB1 = new Pedone("PB1", 1);
		Pezzo pedoneB2 = new Pedone("PB2", 1);
		Pezzo pedoneB3 = new Pedone("PB3", 1);
		Pezzo pedoneB4 = new Pedone("PB4", 1);
		Pezzo pedoneB5 = new Pedone("PB5", 1);
		Pezzo pedoneB6 = new Pedone("PB6", 1);
		Pezzo pedoneB7 = new Pedone("PB7", 1);
		Pezzo pedoneB8 = new Pedone("PB8", 1);

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
		Pezzo alfiereB1 = new Alfiere("AB1", 3);
		Pezzo alfiereB2 = new Alfiere("AB2", 3);

		// AlfiereService

		// Add
		pezziB.add(alfiereB1);
		pezziB.add(alfiereB2);

		// TorreModel
		Pezzo torreB1 = new Torre("TB1", 3);
		Pezzo torreB2 = new Torre("TB2", 3);

		// TorreService
		// Add
		pezziB.add(torreB1);
		pezziB.add(torreB2);

		// ReModel
		Pezzo reB = new Re("RB1", 0);
		giocatore1.setRe(reB);
		// ReService

		// Add
		pezziB.add(reB);

		// ReginaModel
		Pezzo reginaB = new Regina("rB1", 5);

		// ReginaService
		// Add
		pezziB.add(reginaB);

		// CavalloModel
		Pezzo cavalloB1 = new Cavallo("CB1", 3);

		Pezzo cavalloB2 = new Cavallo("CB2", 3);

		// CavalloService

		// Add
		pezziB.add(cavalloB1);
		pezziB.add(cavalloB2);

		giocatore1.setPezzi(pezziB);

		List<Pezzo> pezziN = new ArrayList<>();
		List<Pezzo> pedoniN = new ArrayList<>();

		// PedoneModel

		Pezzo pedoneN1 = new Pedone("PN1", 1);
		Pezzo pedoneN2 = new Pedone("PN2", 1);
		Pezzo pedoneN3 = new Pedone("PN3", 1);
		Pezzo pedoneN4 = new Pedone("PN4", 1);
		Pezzo pedoneN5 = new Pedone("PN5", 1);
		Pezzo pedoneN6 = new Pedone("PN6", 1);
		Pezzo pedoneN7 = new Pedone("PN7", 1);
		Pezzo pedoneN8 = new Pedone("PN8", 1);

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
		Pezzo alfiereN1 = new Alfiere("AN1", 3);
		Pezzo alfiereN2 = new Alfiere("AN2", 3);

		// AlfiereService

		// Add
		pezziN.add(alfiereN1);
		pezziN.add(alfiereN2);

		// TorreModel
		Pezzo torreN1 = new Torre("TN1", 3);
		Pezzo torreN2 = new Torre("TN2", 3);

		// TorreService
		// Add
		pezziN.add(torreN1);
		pezziN.add(torreN2);

		// ReModel
		Pezzo reN = new Re("RN1", 0);
		giocatore2.setRe(reN);
		// ReService

		// Add
		pezziN.add(reN);

		// ReginaModel
		Pezzo reginaN = new Regina("rN1", 5);

		// ReginaService
		// Add
		pezziN.add(reginaN);

		// CavalloModel
		Pezzo cavalloN1 = new Cavallo("CN1", 3);

		Pezzo cavalloN2 = new Cavallo("CN2", 3);

		// CavalloService

		// Add
		pezziN.add(cavalloN1);
		pezziN.add(cavalloN2);
		giocatore2.setPezzi(pezziN);

		// Creazione scacchiera e settaggio valori iniziali della partita
		scacchieraDaGioco = scacchieraDaGioco.creaScacchiera(pezziB, pezziN);
		scacchieraDaGioco.stampaScacchiera(scacchieraDaGioco);
		this.setNumeroPezzi(pezziB.size() + pezziN.size());
		punteggioIniziale = this.punteggioTotale(pezziB, pezziN);
		this.setPunteggio(punteggioIniziale);
		return scacchieraDaGioco;

	}

	// Metodo Da inserire nella Classe Giocatore.
	// E' stato implementato qui solo per prova.

	public int punteggioTotale(List<Pezzo> pezziB, List<Pezzo> pezziN) {
		List<Pezzo> pezziTotali = new ArrayList<>();
		int sum = 0;
		pezziTotali.addAll(pezziB);
		pezziTotali.addAll(pezziN);

		for (Pezzo p : pezziTotali) {
			sum += p.getValore();
		}

		return sum;
	}

	public void scegliTipologiaPartita() {

		
		List<PartitaServiceImpl> listaPartite = new ArrayList<>();
		ContainerPartiteServiceImpl container = new ContainerPartiteServiceImpl(listaPartite);

		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Scegli la tipologia della partita:" + "\n" + " 0 - Giocatore1 vs Giocatore 2;"
					+ "\n 1 - Giocatore1 vs Computer;" + "\n 2 - Computer vs Computer");

			String input = scanner.nextLine();

			if (input.equals("0")) {
				this.setIdPartita(this.hashCode());
				Giocatore giocatore1 = new UtenteServiceImpl("giocatore1", null, null, null);
				Giocatore giocatore2 = new UtenteServiceImpl("giocatore2", null, null, null);
				ScacchieraServiceImpl scacchiera = new ScacchieraServiceImpl(null);
				scacchiera = inizializzaPartita(giocatore1, giocatore2);
				scacchiera.stampaScacchiera(scacchiera);
				giocatore1.turno(giocatore2, scacchiera, this, container);

			} else if (input.equals("1")) {
				Giocatore giocatore1 = new UtenteServiceImpl("giocatore1", null, null, null);
				Giocatore giocatore2 = new ComputerServiceImpl("computer", null, null, null);
				ScacchieraServiceImpl scacchiera = new ScacchieraServiceImpl(null);
				scacchiera = inizializzaPartita(giocatore1, giocatore2);
				scacchiera.stampaScacchiera(scacchiera);
				giocatore1.turno(giocatore2, scacchiera, this, container);

			} else if ((input.equals("2"))) {

				Giocatore giocatore1 = new ComputerServiceImpl("computer1", null, null, null);
				Giocatore giocatore2 = new ComputerServiceImpl("computer2", null, null, null);
				ScacchieraServiceImpl scacchiera = new ScacchieraServiceImpl(null);
				scacchiera = inizializzaPartita(giocatore1, giocatore2);
				scacchiera.stampaScacchiera(scacchiera);
				giocatore1.turno(giocatore2, scacchiera, this, container);

			} else {
				System.out.println("input sbagliato");
				throw new IllegalArgumentException();
			}

		} catch (IllegalArgumentException e) {
			System.out.println("Non è stato digitato alcun input");
			System.out.println("L'input è: " + e.getMessage());

		}

	}

	public void resa(Giocatore giocatore) {
		System.out.println("Il giocatore " + giocatore.getNomeGiocatore() + " si è arreso");
		System.exit(0);
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
		if (file.exists()) {
			file.delete();
		}
		System.exit(0);
	}

	public void fine(Giocatore giocatore) {
		System.out.println("Partita Finita, ha vinto il giocatore: " + giocatore.getNomeGiocatore());
		File file;
		String logPath = new File("src/main/resources/files/log.txt").getAbsolutePath();
		file = new File(logPath);
		if (file.exists()) {
			file.delete();
		}
		System.exit(0);
	}

	public void salvaPartita(PartitaServiceImpl partita, ScacchieraServiceImpl scacchiera, Giocatore giocatore1,
			Giocatore giocatore2, ContainerPartiteServiceImpl container) {
		List<PartitaServiceImpl> lista = new ArrayList<>();
		lista = container.getListaPartite();
		partita.setScacchiera(scacchiera);
		partita.setGiocatore1(giocatore1);
		partita.setGiocatore2(giocatore2);
		lista.add(this);
		container.setListaPartite(lista);
		String partitaPath = new File("src/main/resources/files/partite.txt").getAbsolutePath();

		// Blocco di codice che serve per il merging delle liste vecchie con la lista
		// nuova.
		try (FileInputStream inputStream = new FileInputStream(partitaPath);
				ObjectInputStream objectStream = new ObjectInputStream(inputStream);) {

			while (inputStream.available() > 0) {
				container = (ContainerPartiteServiceImpl) objectStream.readObject();
				System.out.println("Nel file sono presenti altre partite, quindi aggiungerò questa partita assieme alle altre");

				lista.addAll(container.getListaPartite());
				container.setListaPartite(lista);

			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Il file delle partita è vuoto, salvataggio del file in corso...");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try (FileOutputStream serializzazione = new FileOutputStream(partitaPath);
				ObjectOutputStream serializzazioneOutput = new ObjectOutputStream(serializzazione)) {

			Thread.sleep(1500);

			serializzazioneOutput.writeObject(container);
			System.out.println("Partita Salvata!");

		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
