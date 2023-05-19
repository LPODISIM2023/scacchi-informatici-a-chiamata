package it.univaq.disim.lpo.Service.ServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import it.univaq.disim.lpo.Model.PartitaModel;
import it.univaq.disim.lpo.Model.PezzoModel;
import it.univaq.disim.lpo.Model.ScacchieraModel;
import it.univaq.disim.lpo.Service.Partita;

public class PartitaServiceImpl extends PartitaModel implements  Partita{
	

	public PartitaServiceImpl(String nomePartita) {
		super(nomePartita);
		// TODO Auto-generated constructor stub
	}


	@Override
	public void inzia() {

		scegliGiocatori();
		inizializzaScacchiera();

	}
	
	
	void inizializzaScacchiera() {

		// Sezione Creazione della scacchiera e Dei Pezzi
		Table<Integer, Character, PezzoModel> scacchiera = HashBasedTable.create();
		ScacchieraModel scacchieraDaGioco = new ScacchieraModel(scacchiera);
		// PedoneModel
		List<PezzoModel> pezzi = new ArrayList<>();
		PezzoModel pedoneB1 = new PedoneServiceImpl("PB1",true);
		PezzoModel pedoneB2 = new PedoneServiceImpl("PB2", true);
		PezzoModel pedoneB3 = new PedoneServiceImpl("PB3", true);
		PezzoModel pedoneB4 = new PedoneServiceImpl("PB4", true);
		PezzoModel pedoneB5 = new PedoneServiceImpl("PB5", true);
		PezzoModel pedoneB6 = new PedoneServiceImpl("PB6", true);
		PezzoModel pedoneB7 = new PedoneServiceImpl("PB7", true);
		PezzoModel pedoneB8 = new PedoneServiceImpl("PB8", true);

		// PedoneService

		// Add
		pezzi.add(pedoneB1);
		pezzi.add(pedoneB2);
		pezzi.add(pedoneB3);
		pezzi.add(pedoneB4);
		pezzi.add(pedoneB5);
		pezzi.add(pedoneB6);
		pezzi.add(pedoneB7);
		pezzi.add(pedoneB8);

	
		// AlfiereModel
		PezzoModel alfiereB1 = new AlfiereServiceImpl("AB1", true);
		PezzoModel alfiereB2 = new AlfiereServiceImpl("AB2", true);
		
		
		// AlfiereService
		
		// Add
		pezzi.add(alfiereB1);
		pezzi.add(alfiereB2);
		
		// TorreModel
		PezzoModel torreB1 = new TorreServiceImpl("TB1", true);
		PezzoModel torreB2 = new TorreServiceImpl("TB2", true);
		
		// TorreService
		// Add
		pezzi.add(torreB1);
		pezzi.add(torreB2);
		
		// ReModel
		PezzoModel reB = new ReServiceImpl("RB1",true);
	
		// ReService
	
		// Add
		pezzi.add(reB);
		
		// ReginaModel
		PezzoModel reginaB = new ReginaServiceImpl("rB1", true);
		
		// ReginaService
	// Add
		pezzi.add(reginaB);

		// CavalloModel
		PezzoModel cavalloB1 = new CavalloServiceImpl("CB1",true);

	
		PezzoModel cavalloB2 = new CavalloServiceImpl("CB2",true);
		
		// CavalloService
		
		// Add
		pezzi.add(cavalloB1);
		pezzi.add(cavalloB2);

		// PedoneModel

		PezzoModel pedoneN1 = new PedoneServiceImpl("PN1",true);
		PezzoModel pedoneN2 = new PedoneServiceImpl("PN2", true);
		PezzoModel pedoneN3 = new PedoneServiceImpl("PN3", true);
		PezzoModel pedoneN4 = new PedoneServiceImpl("PN4", true);
		PezzoModel pedoneN5 = new PedoneServiceImpl("PN5", true);
		PezzoModel pedoneN6 = new PedoneServiceImpl("PN6", true);
		PezzoModel pedoneN7 = new PedoneServiceImpl("PN7", true);
		PezzoModel pedoneN8 = new PedoneServiceImpl("PN8", true);

		// PedoneService

		// Add
		pezzi.add(pedoneN1);
		pezzi.add(pedoneN2);
		pezzi.add(pedoneN3);
		pezzi.add(pedoneN4);
		pezzi.add(pedoneN5);
		pezzi.add(pedoneN6);
		pezzi.add(pedoneN7);
		pezzi.add(pedoneN8);

	
		// AlfiereModel
		PezzoModel alfiereN1 = new AlfiereServiceImpl("AN1", true);
		PezzoModel alfiereN2 = new AlfiereServiceImpl("AN2", true);
		
		
		// AlfiereService
		
		// Add
		pezzi.add(alfiereN1);
		pezzi.add(alfiereN2);
		
		// TorreModel
		PezzoModel torreN1 = new TorreServiceImpl("TN1", true);
		PezzoModel torreN2 = new TorreServiceImpl("TN2", true);
		
		// TorreService
		// Add
		pezzi.add(torreN1);
		pezzi.add(torreN2);
		
		// ReModel
		PezzoModel reN = new ReServiceImpl("RN1",true);
	
		// ReService
	
		// Add
		pezzi.add(reN);
		
		// ReginaModel
		PezzoModel reginaN = new ReginaServiceImpl("rN1", true);
		
		// ReginaService
	// Add
		pezzi.add(reginaN);

		// CavalloModel
		PezzoModel cavalloN1 = new CavalloServiceImpl("CN1",true);

	
		PezzoModel cavalloN2 = new CavalloServiceImpl("CN2",true);
		
		// CavalloService
		
		// Add
		pezzi.add(cavalloN1);
		pezzi.add(cavalloN2);
		scacchieraDaGioco.creaScacchiera(pezzi);
		scacchieraDaGioco.stampaScacchiera();

		// Chiamata Funzione turno(Giocatore) che in GiocatoreServiceImpl chiamerà
		// questa funzione
		scegliPezzo(scacchieraDaGioco);

	}

	void scegliGiocatori() {

	}

	// Metodo Da inserire nella Classe Giocatore.
	// E' stato implementato qui solo per prova.
	void scegliPezzo(ScacchieraModel scacchiera) {

		try (Scanner scanner = new Scanner(System.in)) {

			System.out.println("Digita il nome del pezzo che vuoi usare. I pezzi sono i seguenti:"
					+ "\n -Pedoni Bianchi: PB1...PB8" + "\n -Pedoni Neri: PN1...PN8" + "\n -Torri Bianche: TB1, TB2"
					+ "\n -Torri Nere: TN1, TN2" + "\n -Cavalli Bianchi: CB1, CB2" + "\n -Cavalli Neri: CN1, CN2"
					+ "\n -Alfieri Bianchi: AB1, AB2" + "\n -Alfieri Neri: AN1, AN2" + "\n -Re Bianco: RB1"
					+ "\n -Re Nero: RN1" + "\n -Regina Bianca: rB1" + "\n -Regina Nera: rN1");

			String input = scanner.nextLine();
			List<String> mosseValide = new ArrayList<>();
			PezzoModel pezzo = scacchiera.getPezzoFromScacchieraByValue(input);
		
			mosseValide = pezzo.mosseValide(scacchiera);

			if (mosseValide.isEmpty()) {
				System.out.println("Non sono presenti mosse valide per " + pezzo.getNome() + ", "
						+ "si prega di scegliere un altro pezzo.");
				scegliPezzo(scacchiera);

			} else {
				System.out.println("Posizioni Valide " + pezzo.getNome() + ": ");
				for (String s : mosseValide) {
					System.out.println(s);
				}

			}
		} catch (NoSuchElementException e) {
			e.getMessage();
		}

	}
}
