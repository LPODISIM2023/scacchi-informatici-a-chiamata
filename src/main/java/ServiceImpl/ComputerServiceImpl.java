package ServiceImpl;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import Service.ILogic;
import it.univaq.disim.lpo.Model.Giocatore;
import it.univaq.disim.lpo.Model.Partita;
import it.univaq.disim.lpo.Model.Pedone;
import it.univaq.disim.lpo.Model.Pezzo;
import it.univaq.disim.lpo.Model.Re;
import it.univaq.disim.lpo.Model.Scacchiera;

public class ComputerServiceImpl extends Giocatore implements ILogic {
	public ComputerServiceImpl(String nomeGiocatore, List<Pezzo> pezzi, Re re, List<Pezzo> pedoni) {
		super(nomeGiocatore, re, pedoni, pezzi);
	}

	@Override
	public void turno(Giocatore giocatore2, ScacchieraServiceImpl scacchiera, PartitaServiceImpl partita) {
		List<Pezzo> pezzi = new ArrayList<>();
		pezzi = this.getPezzi();
		if (Partita.contatoreMosse >= 50) {
			partita.patta();
		} else {

			Re re = (Re) this.getRe();
			if (re != null) {
				String posizioneRe = scacchiera.getColonnaPezzoFromScacchiera(re.getNome()) + ""
						+ scacchiera.getRigaPezzoFromScacchiera(re.getNome());
				if (re.scacco(scacchiera, posizioneRe, giocatore2) == true) {
					if (partita.scaccoMatto(scacchiera, giocatore2, this) == true) {
						partita.fine(giocatore2);
					}
					System.out.println("Il tuo " + this.getRe().getNome() + " e' andato in scacco. Risolvi questo problema");
				}
			}
			scegliPezzo(scacchiera, giocatore2, partita, pezzi);

		}

	}

	@Override
	public void scegliPezzo(ScacchieraServiceImpl scacchiera, Giocatore giocatore, PartitaServiceImpl partita,
			List<Pezzo> pezzi) {
		try {
			
				Random random = new Random();
				Pezzo pezzo;
				pezzo = scacchiera.getPezzoFromScacchieraByValue(pezzi.get(random.nextInt(pezzi.size())).getNome());
				if (pezzo != null) {
					System.out.println(this.getNomeGiocatore() + ": " + "Ho scelto il pezzo " + pezzo.getNome());
					List<String> mosseValide = pezzo.mosseValide(scacchiera);
					scegliMossa(scacchiera, mosseValide, pezzo, giocatore, partita);
				} else {
					throw new NullPointerException();
				}
			
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void scegliMossa(ScacchieraServiceImpl scacchiera, List<String> mosseValide, Pezzo pezzo,
			Giocatore giocatore2, PartitaServiceImpl partita) {
		Random random = new Random();
		if (!mosseValide.isEmpty()) {
			String posizione = mosseValide.get(random.nextInt(0, mosseValide.size()));
			ScacchieraServiceImpl scacchieraNuova = this.muovi(pezzo, scacchiera, posizione, partita, giocatore2);
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			((ILogic) giocatore2).turno(this, scacchieraNuova, partita);
		} else {
			System.out.println("Lista mosse per il pezzo " + pezzo.getNome() + "e' vuota");
			this.scegliPezzo(scacchiera, giocatore2, partita, this.getPezzi());
		}
	}

	@Override
	public ScacchieraServiceImpl muovi(Pezzo pezzo, ScacchieraServiceImpl scacchiera, String input,
			PartitaServiceImpl partita, Giocatore giocatore) {
		Table<Integer, Character, Pezzo> table = HashBasedTable.create(scacchiera.getScacchiera());
		Integer posizioneRigaAttuale = scacchiera.getRigaPezzoFromScacchiera(pezzo.getNome());
		Character posizioneColonnaAttuale = scacchiera.getColonnaPezzoFromScacchiera(pezzo.getNome());

		char carattereNumerico = input.charAt(1);
		int posizioneRigaNuova = Character.getNumericValue(carattereNumerico);
		Character posizioneColonnaNuova = (char) input.charAt(0);
		Pezzo pezzoMorto = table.get(posizioneRigaNuova, posizioneColonnaNuova);
		String posizioneNuova = posizioneColonnaNuova + "" + posizioneRigaNuova;
		if (pezzoMorto != null) {
			pezzoMorto.setAlive(false);

			System.out.println("Ho mangiato il pezzo: " + table.get(posizioneRigaNuova, posizioneColonnaNuova).getNome()
					+ " utilizzando " + pezzo.getNome());

			table.put(posizioneRigaNuova, posizioneColonnaNuova, pezzo);

			table.remove(posizioneRigaAttuale, posizioneColonnaAttuale);

			// Aggiornamento lista pezzi nel caso in cui si è rimosso un pezzo

			List<Pezzo> pezzi = new ArrayList<>();
			pezzi = giocatore.getPezzi();
			pezzi.remove(pezzoMorto);
			giocatore.setPezzi(pezzi);

			Partita.contatoreMosse = 0;
			System.out.println(Partita.contatoreMosse);

		} else {

			table.put(posizioneRigaNuova, posizioneColonnaNuova, pezzo);
			System.out.println(this.getNomeGiocatore() + ": " + "Ho mosso il pezzo " + pezzo.getNome()
					+ " in posizione " + posizioneColonnaNuova + "" + posizioneRigaNuova);
			
				if ((this.getPedoni().contains(pezzo))) {
					Partita.contatoreMosse = 0;
					System.out.println(Partita.contatoreMosse);
				}

			Partita.contatoreMosse++;
			System.out.println(Partita.contatoreMosse);
			table.remove(posizioneRigaAttuale, posizioneColonnaAttuale);

		}
		// Verifica se dopo aver spostato un pezzo il re è andato sottoscacco oppure si
		// è tolto dallo scacco
		ScacchieraServiceImpl scacchieraCopia = new ScacchieraServiceImpl(table);
		
			Re pezzoRe = (Re) this.getRe();
			
			try {
				if(pezzoRe == null) {
					throw new NullPointerException();
				}
				Integer posizioneRigaRe = scacchieraCopia.getRigaPezzoFromScacchiera(pezzoRe.getNome());
				Character posizioneColonnaRe = scacchieraCopia.getColonnaPezzoFromScacchiera(pezzoRe.getNome());
				String posizioneRe = posizioneColonnaRe + "" + posizioneRigaRe;
				// Il giocatore rappresenta giocatore2;
				if (pezzoRe.scacco(scacchieraCopia, posizioneRe, giocatore) == true) {
					System.out.println("Il tuo ReB è ancora sotto scacco. Scegli un altro pezzo oppure muovi il re");
					Partita.contatoreMosse--;
					scacchiera.stampaScacchiera(scacchiera);
					scegliPezzo(scacchiera, giocatore, partita, this.getPezzi());
				} else {
					scacchiera.setScacchiera(table);
					scacchiera.salvaMossa(posizioneNuova, pezzo);
					scacchiera.stampaScacchiera(scacchiera);

					return scacchiera;

				}
			} catch (NullPointerException e) {
				System.out.println("Il reB ha un riferimento nullo anche se non dovrebbe succedere");
			}

		return null;
	}


}
