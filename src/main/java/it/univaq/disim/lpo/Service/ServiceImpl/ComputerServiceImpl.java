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
		if (this.getNomeGiocatore().equals("giocatore1")) {
			PezzoModel pezzo = scacchiera.getPezzoFromScacchieraByValue("RN1");
			ReServiceImpl re = (ReServiceImpl) pezzo;
			String posizioneRe = scacchiera.getColonnaPezzoFromScacchiera(re.getNome()) + ""
					+ scacchiera.getRigaPezzoFromScacchiera(re.getNome());
			if (re.scaccoN(scacchiera, posizioneRe) == true) {
				if (partita.scaccoMatto(scacchiera, this) == true) {
					partita.fine(this);
				}

			}

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
		giocatore2.turno(this, scacchiera, partita);

	}


	@Override
	public void scegliPezzo(ScacchieraModel scacchiera, GiocatoreModel giocatore, PartitaModel partita) {
	
		String[] pezzi = { "PN1", "PN2", "PN3", "PN4", "PN5", "PN6", "PN7", "PN8", "AN1", "AN2", "CN1", "CN2",
				"TN1", "TN2", "RN1", "rN1" };
		Random random = new Random();
		PezzoModel pezzo;
		pezzo = scacchiera.getPezzoFromScacchieraByValue(pezzi[random.nextInt(0, pezzi.length)]);
		List<String> mosseValide = pezzo.mosseValideN(scacchiera);
		scegliMossa(scacchiera, mosseValide, pezzo,giocatore,partita);
		
	}
	@Override
	public void scegliMossa(ScacchieraModel scacchiera, List<String> mosseValide, PezzoModel pezzo,
			GiocatoreModel giocatore2, PartitaModel partita) {
		Random random = new Random();
		String posizione = mosseValide.get(random.nextInt(0, mosseValide.size()));
		this.muovi(pezzo, scacchiera, posizione,partita,giocatore2);
	
	}


	@Override
	public ScacchieraModel muovi(PezzoModel pezzo, ScacchieraModel scacchiera, String input, PartitaModel partita,
			GiocatoreModel giocatore) {
		
		Table<Integer, Character, PezzoModel> table = scacchiera.getScacchiera();
		Integer posizioneRigaAttuale = scacchiera.getRigaPezzoFromScacchiera(pezzo.getNome());
		Character posizioneColonnaAttuale = scacchiera.getColonnaPezzoFromScacchiera(pezzo.getNome());
		
		Integer posizioneRigaNuova = (int) input.charAt(0);
		Character posizioneColonnaNuova = (char) input.charAt(1);
		PezzoModel pezzoMorto = table.get(posizioneRigaNuova, posizioneColonnaNuova);
		if(pezzoMorto != null) {
			pezzoMorto.setAlive(false);
			table.remove(posizioneRigaNuova, posizioneColonnaNuova);
			table.put(posizioneRigaNuova, posizioneColonnaNuova, pezzo);
			table.remove(posizioneRigaAttuale, posizioneColonnaAttuale);
		}else {
			table.remove(posizioneRigaAttuale, posizioneColonnaAttuale);
			table.put(posizioneRigaNuova, posizioneColonnaNuova, pezzo);
			System.out.println(table.get(posizioneRigaNuova, posizioneColonnaNuova));						
			table.remove(posizioneRigaAttuale, posizioneColonnaAttuale);
			System.out.println(table.get(posizioneRigaAttuale, posizioneColonnaAttuale));
		}
		scacchiera.stampaScacchiera(scacchiera);
		scacchiera.setScacchiera(table);
		scacchiera.stampaScacchiera(scacchiera);
		return scacchiera;
		
	}
}   
