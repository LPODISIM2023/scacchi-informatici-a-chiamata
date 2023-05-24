package it.univaq.disim.lpo.Service.ServiceImpl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import it.univaq.disim.lpo.Model.GiocatoreModel;
import it.univaq.disim.lpo.Model.PartitaModel;
import it.univaq.disim.lpo.Model.PezzoModel;
import it.univaq.disim.lpo.Model.ScacchieraModel;

public class PartitaServiceImpl extends PartitaModel {
	public PartitaServiceImpl(String nomePartita) {
		super(nomePartita);
		// TODO Auto-generated constructor stub
	}

	ScacchieraModel inizializzaScacchiera() {

		// Sezione Creazione della scacchiera e Dei Pezzi
		Table<Integer, Character, PezzoModel> scacchiera = HashBasedTable.create();
		ScacchieraModel scacchieraDaGioco = new ScacchieraServiceImpl(scacchiera);
		// PedoneModel
		List<PezzoModel> pezzi = new ArrayList<>();
		PezzoModel pedoneB1 = new PedoneServiceImpl("PB1", true);
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
		PezzoModel reB = new ReServiceImpl("RB1", true);

		// ReService

		// Add
		pezzi.add(reB);

		// ReginaModel
		PezzoModel reginaB = new ReginaServiceImpl("rB1", true);

		// ReginaService
		// Add
		pezzi.add(reginaB);

		// CavalloModel
		PezzoModel cavalloB1 = new CavalloServiceImpl("CB1", true);

		PezzoModel cavalloB2 = new CavalloServiceImpl("CB2", true);

		// CavalloService

		// Add
		pezzi.add(cavalloB1);
		pezzi.add(cavalloB2);

		// PedoneModel

		PezzoModel pedoneN1 = new PedoneServiceImpl("PN1", true);
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
		PezzoModel reN = new ReServiceImpl("RN1", true);

		// ReService

		// Add
		pezzi.add(reN);

		// ReginaModel
		PezzoModel reginaN = new ReginaServiceImpl("rN1", true);

		// ReginaService
		// Add
		pezzi.add(reginaN);

		// CavalloModel
		PezzoModel cavalloN1 = new CavalloServiceImpl("CN1", true);

		PezzoModel cavalloN2 = new CavalloServiceImpl("CN2", true);

		// CavalloService

		// Add
		pezzi.add(cavalloN1);
		pezzi.add(cavalloN2);
		scacchieraDaGioco.creaScacchiera(pezzi);

		return scacchieraDaGioco;
		// Chiamata Funzione turno(Giocatore) che in GiocatoreServiceImpl chiamerà
		// questa funzione

	}

	// Metodo Da inserire nella Classe Giocatore.
	// E' stato implementato qui solo per prova.

	@Override
	public void scegliTipologiaPartita() {
		LocalDateTime dataOra = LocalDateTime.now();
		DateTimeFormatter formattazioneData = DateTimeFormatter.ofPattern("dd-MM-yyyy-HH-mm-ss");
		String dataFormattata = dataOra.format(formattazioneData);
		String path = "src/main/resources/files/";
		String log = "Log-" + dataFormattata + ".txt";
		try (Scanner scanner = new Scanner(System.in)) {

			System.out.println("Scegli la tipologia della partita:" + "\n" + " 0 - Giocatore1 vs Giocatore 2;"
					+ "\n 1 - Giocatore1 vs Computer;" + "\n 2 - Computer vs Computer");

			String input = scanner.nextLine();

			if (input.equals("0")) {

				GiocatoreModel giocatore1 = new UtenteServiceImpl("giocatore1");
				GiocatoreModel giocatore2 = new UtenteServiceImpl("giocatore2");
				ScacchieraModel scacchiera = inizializzaScacchiera();
				scacchiera.stampaScacchiera(scacchiera);
				giocatore1.turno(giocatore2, scacchiera, this);

			} else if (input.equals("1")) {

				GiocatoreModel giocatore1 = new UtenteServiceImpl("giocatore1");
				GiocatoreModel giocatore2 = new ComputerServiceImpl("computer");
				ScacchieraModel scacchiera = inizializzaScacchiera();
				scacchiera.stampaScacchiera(scacchiera);
				giocatore1.turno(giocatore2, scacchiera, this);

			} else if ((input.equals("2"))) {

				GiocatoreModel giocatore1 = new ComputerServiceImpl("computer1");
				GiocatoreModel giocatore2 = new ComputerServiceImpl("computer2");
				ScacchieraModel scacchiera = inizializzaScacchiera();
				giocatore1.turno(giocatore2, scacchiera, this);

			} else if (input.isEmpty()) {
				System.out.println("Non è stato inserito alcun input");
				this.scegliTipologiaPartita();
			}

		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void resa() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean scaccoMatto(ScacchieraModel scacchiera, GiocatoreModel giocatore) {
		if (giocatore.getNomeGiocatore().equals("giocatore1")) {
			PezzoModel re = scacchiera.getPezzoFromScacchieraByValue("RB1");
			List<String> temp = re.mosseValide(scacchiera);
			if (temp.isEmpty()) {
				return true;
			}

		} else {
			PezzoModel re = scacchiera.getPezzoFromScacchieraByValue("RN1");
			List<String> temp = re.mosseValide(scacchiera);
			if (temp.isEmpty()) {
				return true;
			}
		}

		return false;
	}

	@Override
	public void patta() {

		System.out.println("La partita è finita in patta. Non c'e' nessun vincitore");
		System.exit(0);
	}

	@Override
	public void fine(GiocatoreModel giocatore) {
		System.out.println("Partita Finita, ha vinto il giocatore: " + giocatore.getNomeGiocatore());
		System.exit(0);
	}

}
