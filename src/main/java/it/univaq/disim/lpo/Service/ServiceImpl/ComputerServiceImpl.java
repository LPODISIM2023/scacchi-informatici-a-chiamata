package it.univaq.disim.lpo.Service.ServiceImpl;

import java.util.List;
import java.util.Random;

import com.google.common.collect.Table;

import it.univaq.disim.lpo.Model.GiocatoreModel;
import it.univaq.disim.lpo.Model.PartitaModel;
import it.univaq.disim.lpo.Model.PezzoModel;
import it.univaq.disim.lpo.Model.ScacchieraModel;

public class ComputerServiceImpl extends GiocatoreModel {

	public ComputerServiceImpl(String nomeGiocatore) {
		super(nomeGiocatore);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void turno(GiocatoreModel giocatore2, ScacchieraModel scacchiera, PartitaModel partita) {
		if (this.getNomeGiocatore().equals("computer1")) {
			PezzoModel pezzo = scacchiera.getPezzoFromScacchieraByValue("RN1");
			ReServiceImpl re = (ReServiceImpl) pezzo;
			String posizioneRe = scacchiera.getColonnaPezzoFromScacchiera(re.getNome()) + ""
					+ scacchiera.getRigaPezzoFromScacchiera(re.getNome());
			if (re.scaccoN(scacchiera, posizioneRe) == true) {
				if (partita.scaccoMatto(scacchiera, this) == true) {
					partita.fine(this);
				}

			}
			scegliPezzo(scacchiera, giocatore2, partita);

		} else {
			PezzoModel pezzo = scacchiera.getPezzoFromScacchieraByValue("RB1");
			ReServiceImpl re = (ReServiceImpl) pezzo;
			String posizioneRe = scacchiera.getColonnaPezzoFromScacchiera(re.getNome()) + ""
					+ scacchiera.getRigaPezzoFromScacchiera(re.getNome());
			if (re.scaccoB(scacchiera, posizioneRe) == true) {
				if (partita.scaccoMatto(scacchiera, this) == true) {
					partita.fine(this);
				}

			}

		}

		scegliPezzo(scacchiera, giocatore2, partita);
	}

	@Override
	public void scegliPezzo(ScacchieraModel scacchiera, GiocatoreModel giocatore, PartitaModel partita) {
		if (this.getNomeGiocatore().equals("computer1")) {
			String[] pezzi = { "PB1", "PB2", "PB3", "PB4", "PB5", "PB6", "PB7", "PB8", "AB1", "AB2", "CB1", "CB2",
					"TB1", "TB2", "RB1", "rB1" };
			Random random = new Random();
			PezzoModel pezzo;
			pezzo = scacchiera.getPezzoFromScacchieraByValue(pezzi[random.nextInt(pezzi.length)]);
			if (pezzo != null) {
				System.out.println("Ho scelto il pezzo " + pezzo.getNome());
				List<String> mosseValide = pezzo.mosseValideB(scacchiera);
				scegliMossa(scacchiera, mosseValide, pezzo, giocatore, partita);
			}else {
				scegliPezzo(scacchiera, giocatore, partita);
			}
		} else {
			String[] pezzi = { "PN1", "PN2", "PN3", "PN4", "PN5", "PN6", "PN7", "PN8", "AN1", "AN2", "CN1", "CN2",
					"TN1", "TN2", "RN1", "rN1" };
			Random random = new Random();
			PezzoModel pezzo;
			pezzo = scacchiera.getPezzoFromScacchieraByValue(pezzi[random.nextInt(pezzi.length)]);
			if (pezzo != null) {
				System.out.println("Ho scelto il pezzo " + pezzo.getNome());
				List<String> mosseValide = pezzo.mosseValideN(scacchiera);
				scegliMossa(scacchiera, mosseValide, pezzo, giocatore, partita);
			} else {
				scegliPezzo(scacchiera, giocatore, partita);

			}
		}
	}

	@Override
	public void scegliMossa(ScacchieraModel scacchiera, List<String> mosseValide, PezzoModel pezzo,
			GiocatoreModel giocatore2, PartitaModel partita) {
		Random random = new Random();
		if (!mosseValide.isEmpty()) {
			String posizione = mosseValide.get(random.nextInt(0, mosseValide.size()));
			ScacchieraModel scacchieraNuova = this.muovi(pezzo, scacchiera, posizione, partita, giocatore2);
			System.out.println("Ho mosso il pezzo " + pezzo.getNome() + " in posizione " + posizione);
			giocatore2.turno(this, scacchieraNuova, partita);
		} else {
			this.scegliPezzo(scacchiera, giocatore2, partita);
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
		if (this.getNomeGiocatore().equals("computer1")) {
			PezzoModel pezzoRe = scacchieraCopia.getPezzoFromScacchieraByValue("RB1");
			ReServiceImpl reB = (ReServiceImpl) pezzoRe;
			Integer posizioneRigaRe = scacchieraCopia.getRigaPezzoFromScacchiera(reB.getNome());
			Character posizioneColonnaRe = scacchieraCopia.getColonnaPezzoFromScacchiera(reB.getNome());
			String posizioneRe = posizioneColonnaRe + "" + posizioneRigaRe;

			if (reB.scaccoB(scacchieraCopia, posizioneRe) == true) {
				System.out.println("Il tuo Re è ancora sotto scacco. Scegli un altro pezzo oppure muovi il re");
				scegliPezzo(scacchiera, giocatore, partita);
			} else {
				scacchiera.setScacchiera(table);
				scacchiera.stampaScacchiera(scacchiera);
				return scacchiera;
			}
		} else {
			PezzoModel pezzoRe = scacchieraCopia.getPezzoFromScacchieraByValue("RN1");
			ReServiceImpl reN = (ReServiceImpl) pezzoRe;
			Integer posizioneRigaRe = scacchieraCopia.getRigaPezzoFromScacchiera(reN.getNome());
			Character posizioneColonnaRe = scacchieraCopia.getColonnaPezzoFromScacchiera(reN.getNome());
			String posizioneRe = posizioneColonnaRe + "" + posizioneRigaRe;

			if (reN.scaccoN(scacchieraCopia, posizioneRe) == true) {
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
