package it.univaq.disim.lpo.Service;

import it.univaq.disim.lpo.Model.GiocatoreModel;
import it.univaq.disim.lpo.Model.PartitaModel;
import it.univaq.disim.lpo.Model.ScacchieraModel;

public interface GiocatoreService {
	
	
	void scegliPezzo(ScacchieraModel scacchiera, GiocatoreModel giocatore, PartitaModel partita);
	void turno(GiocatoreModel giocatore, ScacchieraModel scacchiera, PartitaModel partita);
	

}