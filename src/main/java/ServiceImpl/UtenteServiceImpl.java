package ServiceImpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import Service.ILogic;
import it.univaq.disim.lpo.Model.Re;
import it.univaq.disim.lpo.Model.Beans.Giocatore;
import it.univaq.disim.lpo.Model.Beans.Partita;
import it.univaq.disim.lpo.Model.Beans.Pezzo;

public class UtenteServiceImpl extends Giocatore implements ILogic, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5505047248762770722L;

	public UtenteServiceImpl() {
		super();
	}

	public UtenteServiceImpl(String nomeGiocatore, List<Pezzo> pezzi, Re re, List<Pezzo> pedoni) {
		super(nomeGiocatore, re, pedoni, pezzi);
	}

	@Override
	public void turno(Giocatore giocatore2, ScacchieraServiceImpl scacchiera, PartitaServiceImpl partita) {
		int patta = 50;

		if (partita.isFine()) {
			return;
		}
		try (Scanner scanner = new Scanner(System.in)) {

			Re re = (Re) this.getRe();
			if (re != null) {
				String posizioneRe = scacchiera.getColonnaPezzoFromScacchiera(re.getNome()) + ""
						+ scacchiera.getRigaPezzoFromScacchiera(re.getNome());
				if (re.scacco(scacchiera, posizioneRe, giocatore2) == true) {
					if (partita.scaccoMatto(scacchiera, giocatore2, this) == true) {
						throw new InterruptedException(
								"Partita finita, ha vinto il giocatore " + giocatore2.getNomeGiocatore());
					}
					System.out.println(
							"Il tuo " + this.getRe().getNome() + " e' andato in scacco. Risolvi questo problema");
				}
			}

			System.out.println(
					"Cosa vuoi fare? \n 1-Arrenditi; \n 2-SalvaPartita; \n 3-TornaIndietro; \n Oppure digita qualsiasi numero per andare alla scelta del pezzo(Es. 4,5,6...)");
			Integer input = scanner.nextInt();

			if (input == 1) {
				throw new InterruptedException("Il " + this.getNomeGiocatore() + " si è arreso");

			} else if (input == 2) {
				partita.salvaPartita(partita, scacchiera, this, giocatore2);
				throw new InterruptedException("Partita Salvata!");

			} else if (input == 3) {
				ScacchieraServiceImpl scacchieraVecchia = partita.rifaiMossa();
				partita.setScacchiera(scacchieraVecchia);
				scacchieraVecchia.stampaScacchiera(scacchieraVecchia);
				this.turno(giocatore2, scacchieraVecchia, partita);

			}

			if (!partita.isFine()) {
				List<Pezzo> pezzi = new ArrayList<>();
				pezzi = this.getPezzi();
				if (Partita.contatorePatta == patta) {
					throw new InterruptedException("La partita è finita in patta.");
				} else {
					scegliPezzo(scacchiera, giocatore2, partita, pezzi);
				}
			}
		} catch (InterruptedException e) {
			if (!partita.isFine()) {
				System.out.println(e.getMessage());
				partita.setFine(true);
				return;
			}

		}
	}

	@Override
	public void scegliPezzo(ScacchieraServiceImpl scacchiera, Giocatore giocatore, PartitaServiceImpl partita,
			List<Pezzo> pezzi) {
		List<String> mosseValide;
		pezzi = this.getPezzi();
		try (Scanner scanner = new Scanner(System.in)) {
			List<String> nomePezzi = new ArrayList<>();
			List<Pezzo> pezziValidi = new ArrayList<>();
			for (Pezzo p : pezzi) {
				if(!(p.mosseValide(scacchiera).isEmpty())) {
				nomePezzi.add(p.getNome());
				pezziValidi.add(p);
				}
			}
			System.out.println(this.getNomeGiocatore() + ": "
					+ "Digita il nome del pezzo che puoi usare. I pezzi sono i seguenti: " + "\n" + nomePezzi);

			String input = scanner.nextLine();

			if (presenzaScelta(input, pezziValidi) == true) {

				System.out.println("Sei sicuro di voler scegliere questo pezzo?: S/N ");
				String risposta = scanner.nextLine();

				if (risposta.equals("N")) {
					scegliPezzo(scacchiera, giocatore, partita, pezzi);
				}

				Pezzo pezzo = scacchiera.getPezzoFromScacchieraByValue(input);
				mosseValide = pezzo.mosseValide(scacchiera);
				scegliMossa(scacchiera, mosseValide, pezzo, giocatore, partita);

			} else {
				throw new IllegalArgumentException();
			}

		} catch (IllegalArgumentException e) {
			System.out.println(
					"Il PezzoScelto non è presente oppure si è sbagliato a digitare l'input, si prega di riavviare il programma."
							+ " Errore: " + e.getCause());
		}
	}

	public boolean presenzaScelta(String input, List<Pezzo> pezziValidi) {

		for (Pezzo p : pezziValidi) {
			if (p.getNome().equals(input)) {
				return true;
			}

		}

		return false;
	}

	@Override
	public void scegliMossa(ScacchieraServiceImpl scacchiera, List<String> mosseValide, Pezzo pezzo,
			Giocatore giocatore2, PartitaServiceImpl partita) {

		try (Scanner scanner = new Scanner(System.in)) {
			boolean trovato = false;
			System.out.println("Scegli la Mossa da eseguire: ");
			System.out.println(mosseValide);

			String input = scanner.nextLine();

			try {
				for (String s : mosseValide) {
					if (s.equals(input)) {
						ScacchieraServiceImpl scacchieraNuova = this.muovi(pezzo, scacchiera, input, partita,
								giocatore2);
						trovato = true;
						giocatore2.turno(this, scacchieraNuova, partita);

					}
				}

				if (trovato == false) {
					throw new IllegalArgumentException();
				}

			} catch (IllegalArgumentException e) {
				System.out.println("Mossa non valida, riavvia il programma " + e.getCause());
			}
		}

	}

	@Override
	public ScacchieraServiceImpl muovi(Pezzo pezzo, ScacchieraServiceImpl scacchiera, String input,
			PartitaServiceImpl partita, Giocatore giocatore2) {



		Table<Integer, Character, Pezzo> table = HashBasedTable.create(scacchiera.getScacchiera());
		Integer contatoreMosse = partita.getContatoreMosse();
		Integer punteggio;
		Integer posizioneRigaAttuale = scacchiera.getRigaPezzoFromScacchiera(pezzo.getNome());
		Character posizioneColonnaAttuale = scacchiera.getColonnaPezzoFromScacchiera(pezzo.getNome());

		char carattereNumerico = input.charAt(1);
		int posizioneRigaNuova = Character.getNumericValue(carattereNumerico);
		Character posizioneColonnaNuova = (char) input.charAt(0);
		Pezzo pezzoMorto = table.get(posizioneRigaNuova, posizioneColonnaNuova);
		String posizioneNuova = posizioneColonnaNuova + "" + posizioneRigaNuova;

		if (pezzoMorto != null) {

			System.out.println("Ho mangiato il pezzo: " + table.get(posizioneRigaNuova, posizioneColonnaNuova).getNome()
					+ " utilizzando " + pezzo.getNome());

			table.put(posizioneRigaNuova, posizioneColonnaNuova, pezzo);

			table.remove(posizioneRigaAttuale, posizioneColonnaAttuale);

			// Aggiornamento lista pezzi nel caso in cui si è rimosso un pezzo
			List<Pezzo> pezzi = new ArrayList<>();
			pezzi = giocatore2.getPezzi();
			pezzi.remove(pezzoMorto);
			giocatore2.setPezzi(pezzi);

			// Aggiornamento valori della partita dopo aver mangiato
			Partita.contatorePatta = 0;
			System.out.println(Partita.contatorePatta);
			partita.setContatoreMosse(++contatoreMosse);
			partita.setNumeroPezzi(this.getPezzi().size() + giocatore2.getPezzi().size());
			punteggio = partita.punteggioTotale(this.getPezzi(), giocatore2.getPezzi());
			partita.setPunteggio(punteggio);
		} else {

			table.put(posizioneRigaNuova, posizioneColonnaNuova, pezzo);
			System.out.println(this.getNomeGiocatore() + ": " + "Ho mosso il pezzo " + pezzo.getNome()
					+ " in posizione " + posizioneColonnaNuova + "" + posizioneRigaNuova);

			if ((this.getPedoni().contains(pezzo))) {
				Partita.contatorePatta = 0;
				System.out.println("Contatore Patta: " + Partita.contatorePatta);
				partita.setContatoreMosse(contatoreMosse + 1);
				table.remove(posizioneRigaAttuale, posizioneColonnaAttuale);

			} else {
				Partita.contatorePatta++;
				System.out.println("Contatore Patta: " + Partita.contatorePatta);
				partita.setContatoreMosse(contatoreMosse + 1);
				table.remove(posizioneRigaAttuale, posizioneColonnaAttuale);

			}

		}
		// Verifica se dopo aver spostato un pezzo il re è andato sottoscacco oppure si
		// è tolto dallo scacco
		ScacchieraServiceImpl scacchieraCopia = new ScacchieraServiceImpl(table);

		Re pezzoRe = (Re) this.getRe();

		try {
			if (pezzoRe == null) {
				throw new NullPointerException();
			}
			Integer posizioneRigaRe = scacchieraCopia.getRigaPezzoFromScacchiera(pezzoRe.getNome());
			Character posizioneColonnaRe = scacchieraCopia.getColonnaPezzoFromScacchiera(pezzoRe.getNome());
			String posizioneRe = posizioneColonnaRe + "" + posizioneRigaRe;
			
			if (pezzoRe.scacco(scacchieraCopia, posizioneRe, giocatore2) == true) {
				System.out.println("Il tuo ReB è ancora sotto scacco. Scegli un altro pezzo oppure muovi il re");
				Partita.contatorePatta--;
				partita.setContatoreMosse(contatoreMosse--);
				scacchiera.stampaScacchiera(scacchiera);
				scegliPezzo(scacchiera, giocatore2, partita, this.getPezzi());
			} else {
				ScacchieraServiceImpl nuovaScacchiera = new ScacchieraServiceImpl(scacchiera.getScacchiera());
				nuovaScacchiera.setScacchiera(table);
				partita.addElementToList(nuovaScacchiera);
				partita.salvaMossa(posizioneNuova, pezzo, this);
				nuovaScacchiera.stampaScacchiera(nuovaScacchiera);
				return nuovaScacchiera;

			}
		} catch (NullPointerException e) {
			System.out.println("Il reB ha un riferimento nullo anche se non dovrebbe succedere");
		}

		return null;
	}
}
