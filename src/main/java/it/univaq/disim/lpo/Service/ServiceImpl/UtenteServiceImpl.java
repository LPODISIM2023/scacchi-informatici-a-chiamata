package it.univaq.disim.lpo.Service.ServiceImpl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import com.google.common.collect.Table;

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
	public void turno(GiocatoreModel giocatore2, ScacchieraModel scacchiera, PartitaModel partita) {
		if (this.getNomeGiocatore().equals("giocatore1")) {
			PezzoModel pezzo = scacchiera.getPezzoFromScacchieraByValue("RB1");
			ReServiceImpl re = (ReServiceImpl) pezzo;
			String posizioneRe = scacchiera.getColonnaPezzoFromScacchiera(re.getNome()) + ""
					+ scacchiera.getRigaPezzoFromScacchiera(re.getNome());
			if (re.scaccoB(scacchiera, posizioneRe) == true) {
				if (partita.scaccoMatto(scacchiera, this) == true) {
					partita.fine(giocatore2);
					return;
				} else {
					System.out.println("Il tuo re è sotto scacco. Muovi il re oppure proteggilo con un altro pezzo");
				}
			}
			scegliPezzo(scacchiera, giocatore2, partita);
		} else

		{
			PezzoModel pezzo = scacchiera.getPezzoFromScacchieraByValue("RN1");
			ReServiceImpl re = (ReServiceImpl) pezzo;
			String posizioneRe = scacchiera.getColonnaPezzoFromScacchiera(re.getNome()) + ""
					+ scacchiera.getRigaPezzoFromScacchiera(re.getNome());
			if (re.scaccoN(scacchiera, posizioneRe) == true) {
				if (partita.scaccoMatto(scacchiera, this) == true) {
					partita.fine(giocatore2);
					return;
				} else {
					System.out.println("Il tuo re è sotto scacco. Muovi il re oppure proteggilo con un altro pezzo");

				}

			}
			scegliPezzo(scacchiera, giocatore2, partita);
		}

	}

	@Override
	public void scegliPezzo(ScacchieraModel scacchiera, GiocatoreModel giocatore, PartitaModel partita) {
		List<String> mosseValide;
		List<PezzoModel> pezzi = scacchiera.getPezziFromScacchiera();

		if (this.getNomeGiocatore().equals("giocatore1")) {
			try (Scanner scanner = new Scanner(System.in)) {

				System.out.println(this.getNomeGiocatore() + ": "
						+ "Digita il nome del pezzo che vuoi usare. I pezzi sono i seguenti:"
						+ "\n -Pedoni Bianchi: PB1...PB8" + "\n -Torri Bianche: TB1, TB2"
						+ "\n -Cavalli Bianchi: CB1, CB2" + "\n -Alfieri Bianchi: AB1, AB2" + "\n -Re Bianco: RB1"
						+ "\n -Regina Bianca: rB1");

				String input = scanner.nextLine();

				if (input.isEmpty()) {
					System.out.println("Non e' stato inserito alcun input.");
					scegliPezzo(scacchiera, giocatore, partita);
				}
				if (input.length() != 3) {
					System.out.println(
							"L'input deve essere lungo 3 caratteri e non deve contenere spazi (Es. l'input deve essere digitato in questo modo: 'PB1'");
					scegliPezzo(scacchiera, giocatore, partita);
				}
				if (presenzaSceltaB(input, pezzi) != true) {
					System.out.println(
							"Il PezzoScelto non è presente oppure si è sbagliato a digitare l'input, si prega di scegliere un altro pezzo.");
					scegliPezzo(scacchiera, giocatore, partita);

				} else {
					System.out.println("Sei sicuro di voler scegliere questo pezzo?: S/N ");
					String risposta = scanner.nextLine();
					if (risposta.equals("N")) {
						scegliPezzo(scacchiera, giocatore, partita);
					}
					PezzoModel pezzo = scacchiera.getPezzoFromScacchieraByValue(input);
					mosseValide = pezzo.mosseValideB(scacchiera);
					if (mosseValide.isEmpty()) {
						System.out.println("Non sono presenti mosse valide per " + pezzo.getNome()
								+ ". \n Si prega di scegliere unaltro pezzo.");
						scegliPezzo(scacchiera, giocatore, partita);
					}
					System.out.println("Posizioni Valide " + pezzo.getNome() + ": ");
					System.out.println(mosseValide);
					scegliMossa(scacchiera, mosseValide, pezzo, giocatore, partita);
				}

			} catch (NullPointerException e) {
				e.printStackTrace();
			}
		}
		if (this.getNomeGiocatore().equals("giocatore2")) {
			try (Scanner scanner = new Scanner(System.in)) {

				System.out.println(this.getNomeGiocatore() + ": "
						+ "Digita il nome del pezzo che vuoi usare. I pezzi sono i seguenti:"
						+ "\n -Pedoni Neri: PN1...PN8" + "\n -Torri Nere: TN1, TN2" + "\n -Cavalli Neri: CN1, CN2"
						+ "\n -Alfieri Neri: AN1, AN2" + "\n -Re Nero: RN1" + "\n -Regina Nera: rN1"
						+ "\n si prega di scrivere il nome del pezzo IN MAIUSCOLO (Es. PB1).");

				String input = scanner.nextLine();
				if (input.isEmpty()) {
					System.out.println("Non e' stato inserito alcun input.");
					scegliPezzo(scacchiera, giocatore, partita);
				}
				if (input.length() != 3) {
					System.out.println(
							"L'input deve essere lungo 3 caratteri e non deve contenere spazi (Es. l'input deve essere digitato in questo modo: 'PB1'");
					scegliPezzo(scacchiera, giocatore, partita);
				}
				if (presenzaSceltaN(input, pezzi) != true) {

					System.out.println(
							"Il PezzoScelto non è presente oppure si è sbagliato a digitare l'input, si prega di scegliere un altro pezzo.");
					scegliPezzo(scacchiera, giocatore, partita);

				} else {
					System.out.println("Sei sicuro di voler scegliere questo pezzo?: S/N ");
					String risposta = scanner.nextLine();
					if (risposta.equals("N")) {
						scegliPezzo(scacchiera, giocatore, partita);
					}
					PezzoModel pezzo = scacchiera.getPezzoFromScacchieraByValue(input);
					mosseValide = pezzo.mosseValideN(scacchiera);
					if (mosseValide.isEmpty()) {
						System.out.println("Non sono presenti mosse valide per " + pezzo.getNome()
								+ ". \n Si prega di scegliere unaltro pezzo.");
						scegliPezzo(scacchiera, giocatore, partita);
					}
					System.out.println("Posizioni Valide " + pezzo.getNome() + ": ");
					System.out.println(mosseValide);
					scegliMossa(scacchiera, mosseValide, pezzo, giocatore, partita);
				}

			} catch (NoSuchElementException e) {
				e.printStackTrace();
			}
		}
	}

	public boolean presenzaSceltaB(String input, List<PezzoModel> pezzi) {
		if (input.charAt(1) == 'B') {
			for (PezzoModel p : pezzi) {
				if (p.getNome().equals(input)) {
					return true;
				}

			}

		}
		return false;
	}

	public boolean presenzaSceltaN(String input, List<PezzoModel> pezzi) {
		if (input.charAt(1) == 'N') {
			for (PezzoModel p : pezzi) {
				if (p.getNome().equals(input)) {
					return true;
				}
			}

		}
		return false;
	}

	@Override
	public void scegliMossa(ScacchieraModel scacchiera, List<String> mosseValide, PezzoModel pezzo,
			GiocatoreModel giocatore2, PartitaModel partita) {

		try (Scanner scanner = new Scanner(System.in)) {
			boolean trovato = false;
			System.out.println("Scegli la Mossa da eseguire: ");

			String input = scanner.nextLine();

			try {
				for (String s : mosseValide) {
					if (s.equals(input)) {
						if (this.getNomeGiocatore().equals("giocatore1")) {
							ScacchieraModel scacchieraNuova = this.muovi(pezzo, scacchiera, input, partita, giocatore2);
							trovato = true;
							giocatore2.turno(this, scacchieraNuova, partita);
						} else {
							trovato = true;
							ScacchieraModel scacchieraNuova = this.muovi(pezzo, scacchiera, input, partita, giocatore2);
							giocatore2.turno(this, scacchieraNuova, partita);
						}
					}
				}

				if (trovato == false) {
					System.out.println("Mossa Non Valida, scegli un'altra mossa");
					scegliMossa(scacchiera, mosseValide, pezzo, giocatore2, partita);
				}

			} catch (NoSuchElementException e) {
				e.printStackTrace();

			}
		}

	}

	@Override
	public ScacchieraModel muovi(PezzoModel pezzo, ScacchieraModel scacchiera, String input, PartitaModel partita,
			GiocatoreModel giocatore) {

		Table<Integer, Character, PezzoModel> table = scacchiera.getScacchiera();
		Integer posizioneRigaAttuale = scacchiera.getRigaPezzoFromScacchiera(pezzo.getNome());
		Character posizioneColonnaAttuale = scacchiera.getColonnaPezzoFromScacchiera(pezzo.getNome());

		char carattereNumerico = input.charAt(1);
		int posizioneRigaNuova = Character.getNumericValue(carattereNumerico);
		System.out.println(posizioneRigaNuova);
		Character posizioneColonnaNuova = (char) input.charAt(0);
		PezzoModel pezzoMorto = table.get(posizioneRigaNuova, posizioneColonnaNuova);
		if (pezzoMorto != null) {
			pezzoMorto.setAlive(false);

			table.put(posizioneRigaNuova, posizioneColonnaNuova, pezzo);
			table.remove(posizioneRigaAttuale, posizioneColonnaAttuale);

		} else {
			
			table.put(posizioneRigaNuova, posizioneColonnaNuova, pezzo);

			table.remove(posizioneRigaAttuale, posizioneColonnaAttuale);
			System.out.println(table.get(posizioneRigaAttuale, posizioneColonnaAttuale));

		}
		// Verifica se dopo aver spostato un pezzo il re è andato sottoscacco oppure si
		// è tolto dallo scacco
		ScacchieraModel scacchieraCopia = new ScacchieraServiceImpl(table);
		if (this.getNomeGiocatore().equals("giocatore1")) {
			PezzoModel pezzoRe = scacchieraCopia.getPezzoFromScacchieraByValue("RB1");
			ReServiceImpl re = (ReServiceImpl) pezzoRe;
			Integer posizioneRigaRe = scacchieraCopia.getRigaPezzoFromScacchiera(re.getNome());
			Character posizioneColonnaRe = scacchieraCopia.getColonnaPezzoFromScacchiera(re.getNome());
			String posizioneRe = posizioneColonnaRe + "" + posizioneRigaRe;

			if (re.scaccoB(scacchieraCopia, posizioneRe) == true) {
				System.out.println("Il tuo Re è ancora sotto scacco. Scegli un altro pezzo oppure muovi il re");
				scegliPezzo(scacchiera, giocatore, partita);
			} else {
				scacchiera.setScacchiera(table);
				scacchiera.stampaScacchiera(scacchiera);
				return scacchiera;
			}
		} else {
			PezzoModel pezzoRe = scacchieraCopia.getPezzoFromScacchieraByValue("RN1");
			ReServiceImpl re = (ReServiceImpl) pezzoRe;
			Integer posizioneRigaRe = scacchieraCopia.getRigaPezzoFromScacchiera(re.getNome());
			Character posizioneColonnaRe = scacchieraCopia.getColonnaPezzoFromScacchiera(re.getNome());
			String posizioneRe = posizioneColonnaRe + "" + posizioneRigaRe;

			if (re.scaccoN(scacchieraCopia, posizioneRe) == true) {
				System.out.println(
						"Il tuo Re è ancora sotto scacco oppure Potrebbe andarci se sposti quel pezzo. Scegli un altro pezzo oppure muovi il re");
				scegliPezzo(scacchiera, giocatore, partita);
			} else {
				scacchiera.setScacchiera(table);
				scacchiera.stampaScacchiera(scacchiera);
				return scacchiera;
			}
		}
		return null;

	}
}
