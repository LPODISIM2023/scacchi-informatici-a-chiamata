package it.univaq.disim.lpo.Service.ServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import it.univaq.disim.lpo.Model.PartitaModel;
import it.univaq.disim.lpo.Model.PedoneModel;
import it.univaq.disim.lpo.Model.PezzoModel;
import it.univaq.disim.lpo.Model.ReModel;
import it.univaq.disim.lpo.Model.ScacchieraModel;
import it.univaq.disim.lpo.Model.TorreModel;
import it.univaq.disim.lpo.Service.PartitaService;
import it.univaq.disim.lpo.Service.PezzoService;

public class PartitaServiceImpl extends PartitaModel implements  PartitaService{
	

	@Override
	public void inzia() {

		scegliGiocatori();
		inizializzaScacchiera();

	}
	public PartitaServiceImpl() {
		
	}
	
	void inizializzaScacchiera() {

		// Sezione Creazione della scacchiera e Dei Pezzi
		Table<Integer, Character, PezzoService> scacchiera = HashBasedTable.create();
		ScacchieraModel scacchieraDaGioco = new ScacchieraModel(scacchiera);
		// PedoneModel
		List<PezzoService> pezzi = new ArrayList<>();
		PezzoService pedoneB1 = new PedoneServiceImpl("PB1",true);
		PezzoService pedoneB2 = new PedoneServiceImpl("PB2", true);
		PezzoService pedoneB3 = new PedoneServiceImpl("PB3", true);
		PezzoService pedoneB4 = new PedoneServiceImpl("PB4", true);
		PezzoService pedoneB5 = new PedoneServiceImpl("PB5", true);
		PezzoService pedoneB6 = new PedoneServiceImpl("PB6", true);
		PezzoService pedoneB7 = new PedoneServiceImpl("PB7", true);
		PezzoService pedoneB8 = new PedoneServiceImpl("PB8", true);

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
		PezzoService alfiereB1 = new AlfiereServiceImpl("AB1", true);
		PezzoService alfiereB2 = new AlfiereServiceImpl("AB2", true);
		
		
		// AlfiereService
		
		// Add
		pezzi.add(alfiereB1);
		pezzi.add(alfiereB2);
		
		// TorreModel
		PezzoService torreB1 = new TorreServiceImpl("TB1", true);
		PezzoService torreB2 = new TorreServiceImpl("TB2", true);
		
		// TorreService
		// Add
		pezzi.add(torreB1);
		pezzi.add(torreB2);
		
		// ReModel
		PezzoService reB = new ReServiceImpl("RB1",true);
	
		// ReService
	
		// Add
		pezzi.add(reB);
		
		// ReginaModel
		PezzoService reginaB = new ReginaServiceImpl("rB1", true);
		
		// ReginaService
	// Add
		pezzi.add(reginaB);

		// CavalloModel
		PezzoService cavalloB1 = new CavalloServiceImpl("CB1",true);

	
		PezzoService cavalloB2 = new CavalloServiceImpl("CB2",true);
		
		// CavalloService
		
		// Add
		pezzi.add(cavalloB1);
		pezzi.add(cavalloB2);

		// PedoneModel

		PezzoService pedoneN1 = new PedoneServiceImpl("PN1",true);
		PezzoService pedoneN2 = new PedoneServiceImpl("PN2", true);
		PezzoService pedoneN3 = new PedoneServiceImpl("PN3", true);
		PezzoService pedoneN4 = new PedoneServiceImpl("PN4", true);
		PezzoService pedoneN5 = new PedoneServiceImpl("PN5", true);
		PezzoService pedoneN6 = new PedoneServiceImpl("PN6", true);
		PezzoService pedoneN7 = new PedoneServiceImpl("PN7", true);
		PezzoService pedoneN8 = new PedoneServiceImpl("PN8", true);

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
		PezzoService alfiereN1 = new AlfiereServiceImpl("AN1", true);
		PezzoService alfiereN2 = new AlfiereServiceImpl("AN2", true);
		
		
		// AlfiereService
		
		// Add
		pezzi.add(alfiereN1);
		pezzi.add(alfiereN2);
		
		// TorreModel
		PezzoService torreN1 = new TorreServiceImpl("TN1", true);
		PezzoService torreN2 = new TorreServiceImpl("TN2", true);
		
		// TorreService
		// Add
		pezzi.add(torreN1);
		pezzi.add(torreN2);
		
		// ReModel
		PezzoService reN = new ReServiceImpl("RN1",true);
	
		// ReService
	
		// Add
		pezzi.add(reN);
		
		// ReginaModel
		PezzoService reginaN = new ReginaServiceImpl("rN1", true);
		
		// ReginaService
	// Add
		pezzi.add(reginaN);

		// CavalloModel
		PezzoService cavalloN1 = new CavalloServiceImpl("CN1",true);

	
		PezzoService cavalloN2 = new CavalloServiceImpl("CN2",true);
		
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
			PezzoService pezzo = scacchiera.getPezzoFromScacchieraByValue(input);
		
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
