package it.univaq.disim.lpo.Service.ServiceImpl;

import java.util.List;
import java.util.Random;

import com.google.common.collect.HashBasedTable;
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

		if (PartitaModel.contatoreMosse == 50) {
			PartitaModel.contatoreMosse = 0;
			partita.patta();
		} else {
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
					scegliPezzo(scacchiera, giocatore2, partita);

				
			}

		}
	}

	@Override
	public void scegliPezzo(ScacchieraModel scacchiera, GiocatoreModel giocatore, PartitaModel partita) {
		try {
			if (this.getNomeGiocatore().equals("computer1")) {
				List<PezzoModel> pezzi = scacchiera.getPezziFromScacchiera();
				Random random = new Random();
				PezzoModel pezzo;
				pezzo = scacchiera.getPezzoFromScacchieraByValue(pezzi.get(random.nextInt(pezzi.size())).getNome());
				if (pezzo != null && pezzo.getNome().charAt(1) == 'B') {
					System.out.println(this.getNomeGiocatore() + ": " + "Ho scelto il pezzo " + pezzo.getNome());
					List<String> mosseValide = pezzo.mosseValide(scacchiera);
					scegliMossa(scacchiera, mosseValide, pezzo, giocatore, partita);
				} else if (pezzo != null && pezzo.getNome().charAt(1) == 'N') {
					scegliPezzo(scacchiera, giocatore, partita);
				} else {
					System.out.println("Sto avendo problemi con la scelta del pezzo, sono il " + this.getNomeGiocatore()
							+ " e ho tentato di prendere il pezzo " + pezzo.getNome());
					System.out.println(pezzi);
				}
			} else {
				List<PezzoModel> pezzi = scacchiera.getPezziFromScacchiera();

				Random random = new Random();
				PezzoModel pezzo;
				pezzo = scacchiera.getPezzoFromScacchieraByValue(pezzi.get(random.nextInt(pezzi.size())).getNome());
				if (pezzo != null && pezzo.getNome().charAt(1) == 'N') {
					System.out.println(this.getNomeGiocatore() + ": " + "Ho scelto il pezzo " + pezzo.getNome());
					List<String> mosseValide = pezzo.mosseValide(scacchiera);
					scegliMossa(scacchiera, mosseValide, pezzo, giocatore, partita);
				} else if (pezzo != null && pezzo.getNome().charAt(1) == 'B') {
					scegliPezzo(scacchiera, giocatore, partita);
				} else if (pezzo == null) {
					System.out.println("Pezzo non valido");
					this.scegliPezzo(scacchiera, giocatore, partita);

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void scegliMossa(ScacchieraModel scacchiera, List<String> mosseValide, PezzoModel pezzo,
			GiocatoreModel giocatore2, PartitaModel partita) {
		Random random = new Random();
		if (!mosseValide.isEmpty()) {
			String posizione = mosseValide.get(random.nextInt(0, mosseValide.size()));
			ScacchieraModel scacchieraNuova = this.muovi(pezzo, scacchiera, posizione, partita, giocatore2);
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			giocatore2.turno(this, scacchieraNuova, partita);
		} else {
			System.out.println("Lista mosse per il pezzo " + pezzo.getNome() + "e' vuota");
			this.scegliPezzo(scacchiera, giocatore2, partita);
		}
	}

	@Override
	public ScacchieraModel muovi(PezzoModel pezzo, ScacchieraModel scacchiera, String input, PartitaModel partita,
			GiocatoreModel giocatore) {


		Table<Integer, Character, PezzoModel> table = HashBasedTable.create(scacchiera.getScacchiera());
		Integer posizioneRigaAttuale = scacchiera.getRigaPezzoFromScacchiera(pezzo.getNome());
		Character posizioneColonnaAttuale = scacchiera.getColonnaPezzoFromScacchiera(pezzo.getNome());

		char carattereNumerico = input.charAt(1);
		int posizioneRigaNuova = Character.getNumericValue(carattereNumerico);
		Character posizioneColonnaNuova = (char) input.charAt(0);
		PezzoModel pezzoMorto = table.get(posizioneRigaNuova, posizioneColonnaNuova);

		if (pezzoMorto != null) {
			pezzoMorto.setAlive(false);

			System.out.println("Ho mangiato il pezzo: " + table.get(posizioneRigaNuova, posizioneColonnaNuova).getNome()
					+ " utilizzando " + pezzo.getNome());

			table.put(posizioneRigaNuova, posizioneColonnaNuova, pezzo);

			table.remove(posizioneRigaAttuale, posizioneColonnaAttuale);

			PartitaModel.contatoreMosse = 0;
			System.out.println(PartitaModel.contatoreMosse);

		} else {

			table.put(posizioneRigaNuova, posizioneColonnaNuova, pezzo);
			System.out.println(this.getNomeGiocatore() + ": " + "Ho mosso il pezzo " + pezzo.getNome()
					+ " in posizione " + posizioneColonnaNuova + "" + posizioneRigaNuova);

			if (!(table.get(posizioneRigaNuova, posizioneColonnaNuova) instanceof PedoneServiceImpl)) {
				PartitaModel.contatoreMosse++;
				System.out.println(PartitaModel.contatoreMosse);
			} else {
				PartitaModel.contatoreMosse = 0;
				System.out.println(PartitaModel.contatoreMosse);

			}

			table.remove(posizioneRigaAttuale, posizioneColonnaAttuale);

		}
		// Verifica se dopo aver spostato un pezzo il re è andato sottoscacco oppure si
		// è tolto dallo scacco
		ScacchieraModel scacchieraCopia = new ScacchieraServiceImpl(table);
		if (this.getNomeGiocatore().equals("computer1")) {
			PezzoModel pezzoRe = scacchieraCopia.getPezzoFromScacchieraByValue("RB1");
			try {
				ReServiceImpl reB = (ReServiceImpl) pezzoRe;
				Integer posizioneRigaRe = scacchieraCopia.getRigaPezzoFromScacchiera(reB.getNome());
				Character posizioneColonnaRe = scacchieraCopia.getColonnaPezzoFromScacchiera(reB.getNome());
				String posizioneRe = posizioneColonnaRe + "" + posizioneRigaRe;

				if (reB.scaccoB(scacchieraCopia, posizioneRe) == true) {
					System.out.println("Il tuo ReB è ancora sotto scacco. Scegli un altro pezzo oppure muovi il re");
					PartitaModel.contatoreMosse--;
					scacchiera.stampaScacchiera(scacchiera);
					scegliPezzo(scacchiera, giocatore, partita);
				} else {
					scacchiera.setScacchiera(table);
					scacchiera.stampaScacchiera(scacchiera);

					return scacchiera;

				}
			} catch (NullPointerException e) {
				System.out.println("Il reB ha un riferimento nullo anche se non dovrebbe succedere");
				e.getLocalizedMessage();
			}
		} else {
			PezzoModel pezzoRe = scacchieraCopia.getPezzoFromScacchieraByValue("RN1");

			try {
				ReServiceImpl reN = (ReServiceImpl) pezzoRe;

				Integer posizioneRigaRe = scacchieraCopia.getRigaPezzoFromScacchiera(reN.getNome());
				Character posizioneColonnaRe = scacchieraCopia.getColonnaPezzoFromScacchiera(reN.getNome());
				String posizioneRe = posizioneColonnaRe + "" + posizioneRigaRe;

				if (reN.scaccoN(scacchieraCopia, posizioneRe) == true) {
					System.out.println(
							"Il tuo ReN è ancora sotto scacco oppure Potrebbe andarci se sposti quel pezzo. Scegli un altro pezzo oppure muovi il re");
					PartitaModel.contatoreMosse--;
					scacchiera.stampaScacchiera(scacchiera);
					scegliPezzo(scacchiera, giocatore, partita);
				} else {
					scacchiera.setScacchiera(table);
					scacchiera.stampaScacchiera(scacchiera);
					return scacchiera;
				}

			} catch (NullPointerException e) {
				System.out.println("Il reN ha un riferimento nullo anche se non dovrebbe succedere");
				e.getLocalizedMessage();
			}
		}

		return null;

	}
}
