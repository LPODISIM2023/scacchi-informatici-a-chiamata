package it.univaq.disim.lpo.Service.ServiceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import it.univaq.disim.lpo.Model.GiocatoreModel;
import it.univaq.disim.lpo.Model.PartitaModel;
import it.univaq.disim.lpo.Model.PezzoModel;
import it.univaq.disim.lpo.Model.ScacchieraModel;
import it.univaq.disim.lpo.Service.Giocatore;

public class UtenteServiceImpl extends GiocatoreModel implements Giocatore {

	public UtenteServiceImpl(String nomeGiocatore) {
		super(nomeGiocatore);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void turno(GiocatoreModel giocatore, ScacchieraModel scacchiera, PartitaModel partita) {
		Table<Integer, Character, PezzoModel> table = scacchiera.getScacchiera();
		scegliPezzo(scacchiera, giocatore, partita);

	}

	@Override
	public void scegliPezzo(ScacchieraModel scacchiera, GiocatoreModel giocatore, PartitaModel partita) {
		List<String> mosseValide;

		if (this.getNomeGiocatore().equals("giocatore1")) {
			try (Scanner scanner = new Scanner(System.in)) {

				System.out.println("Digita il nome del pezzo che vuoi usare. I pezzi sono i seguenti:"
						+ "\n -Pedoni Bianchi: PB1...PB8" + "\n -Torri Bianche: TB1, TB2"
						+ "\n -Cavalli Bianchi: CB1, CB2" + "\n -Alfieri Bianchi: AB1, AB2" + "\n -Re Bianco: RB1"
						+ "\n -Regina Bianca: rB1");

				String input = scanner.nextLine();

				if (presenzaScelta(input) != true) {

					System.out.println("Il PezzoScelto non è presente, si prega di scegliere un altro pezzo.");
					scegliPezzo(scacchiera, giocatore, partita);

				} else {
					System.out.println("Sei sicuro di voler scegliere questo pezzo?: S/N ");
					String risposta = scanner.nextLine();
					if (risposta.equals("N")) {
						scegliPezzo(scacchiera, giocatore, partita);
					}
					PezzoModel pezzo = scacchiera.getPezzoFromScacchieraByValue(input);
					mosseValide = pezzo.mosseValideB(scacchiera);
					System.out.println("Posizioni Valide " + pezzo.getNome() + ": ");
					for (String s : mosseValide) {
						System.out.println(s);
					}
					scegliMossa(scacchiera, mosseValide, pezzo, giocatore, partita);
				}

			} catch (NullPointerException e) {
				e.printStackTrace();
			}
		}
		if (this.getNomeGiocatore().equals("giocatore2")) {
			try (Scanner scanner = new Scanner(System.in)) {

				System.out.println("Digita il nome del pezzo che vuoi usare. I pezzi sono i seguenti:"
						+ "\n -Pedoni Neri: PN1...PN8" + "\n -Torri Nere: TN1, TN2" + "\n -Cavalli Neri: CN1, CN2"
						+ "\n -Alfieri Neri: AN1, AN2" + "\n -Re Nero: RN1" + "\n -Regina Nera: rN1");

				String input = scanner.nextLine();

				if (presenzaScelta(input) == true) {

					System.out.println("Il PezzoScelto non è presente, si prega di scegliere un altro pezzo.");
					scegliPezzo(scacchiera, giocatore, partita);

				} else {
					System.out.println("Sei sicuro di voler scegliere questo pezzo?: S/N ");
					input = scanner.nextLine();
					if (input.equals("N")) {
						scegliPezzo(scacchiera, giocatore, partita);
					}
					PezzoModel pezzo = scacchiera.getPezzoFromScacchieraByValue(input);
					mosseValide = pezzo.mosseValideB(scacchiera);
					System.out.println("Posizioni Valide " + pezzo.getNome() + ": ");
					for (String s : mosseValide) {
						System.out.println(s);
					}
					scegliMossa(scacchiera, mosseValide, pezzo, giocatore, partita);
				}

			} catch (NullPointerException e) {
				e.printStackTrace();
			}
		}
	}

	public boolean presenzaScelta(String input) {
		String[] a = { "PB1", "PB2", "PB3", "PB4", "PB5", "PB6", "PB7", "PB8", "AB1", "AB2", "CB1", "CB2", "TB1", "TB2",
				"RB1", "rB1", "PN1", "PN2", "PN3", "PN4", "PN5", "PN6", "PN7", "PN8", "AN1", "AN2", "CN1", "CN2", "TN1",
				"TN2", "RN1", "rN1" };
		List<String> pezzi = new ArrayList<>();
		pezzi.addAll(Arrays.asList(a));

		try {

			for (String s : pezzi) {

				if (s.equals(input)) {
					return true;
				}
			}
		} catch (NoSuchElementException e) {
			e.getMessage();
		}
		return false;
	}

	public void scegliMossa(ScacchieraModel scacchiera, List<String> mosseValide, PezzoModel pezzo,
			GiocatoreModel giocatore, PartitaModel partita) {

		try (Scanner scanner = new Scanner(System.in)) {
			boolean trovato = false;
			System.out.println("Scegli la Mossa da eseguire: ");

			String input = scanner.nextLine();

			try {
				for (String s : mosseValide) {
					if (s.equals(input)) {
						if (this.getNomeGiocatore().equals("giocatore1")) {
							pezzo.muoviB(pezzo, scacchiera, input, partita);
							trovato = true;
						} else {
							pezzo.muoviN(pezzo, scacchiera, input, partita);
							trovato = true;
						}
					}
				}

				if (trovato == false) {
					System.out.println("Mossa Non Valida, scegli un'altra mossa");
					scegliMossa(scacchiera, mosseValide, pezzo, giocatore, partita);
				}
				this.turno(giocatore, scacchiera, partita);
			} catch (NoSuchElementException e) {
				e.printStackTrace();

			}
		}

	}

	

}