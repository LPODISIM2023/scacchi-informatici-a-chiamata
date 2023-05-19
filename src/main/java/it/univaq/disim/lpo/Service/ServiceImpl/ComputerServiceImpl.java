package it.univaq.disim.lpo.Service.ServiceImpl;

import java.util.List;
import java.util.Random;

import it.univaq.disim.lpo.Model.GiocatoreModel;
import it.univaq.disim.lpo.Model.PezzoModel;
import it.univaq.disim.lpo.Model.ScacchieraModel;

public class ComputerServiceImpl extends GiocatoreModel {

	public ComputerServiceImpl(String nomeGiocatore) {
		super(nomeGiocatore);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void turno(GiocatoreModel giocatore, ScacchieraModel scacchiera) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void scegliPezzo(ScacchieraModel scacchiera, GiocatoreModel giocatore) {
	
		String[] pezzi = { "PN1", "PN2", "PN3", "PN4", "PN5", "PN6", "PN7", "PN8", "AN1", "AN2", "CN1", "CN2",
				"TN1", "TN2", "RN1", "rN1" };
		Random random = new Random();
		PezzoModel pezzo;
		pezzo = scacchiera.getPezzoFromScacchieraByValue(pezzi[random.nextInt(0, pezzi.length)]);
		List<String> mosseValide = pezzo.mosseValideN(scacchiera);
		scegliMossa(scacchiera, mosseValide, pezzo);
		
	}
	public void scegliMossa(ScacchieraModel scacchiera, List<String> mosseValide, PezzoModel pezzo) {

		Random random = new Random();
		String posizione = mosseValide.get(random.nextInt(0, mosseValide.size()));
		pezzo.muovi(pezzo, scacchiera, posizione);
	
	}
}
