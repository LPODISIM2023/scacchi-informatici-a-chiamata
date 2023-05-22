package it.univaq.disim.lpo.Service;

import it.univaq.disim.lpo.Model.GiocatoreModel;
import it.univaq.disim.lpo.Model.ScacchieraModel;

public interface Partita {

	void resa();
	public boolean scaccoMatto(ScacchieraModel scacchiera, GiocatoreModel giocatore);
	public void patta();
	public void scegliTipologiaPartita();
	public void fine(GiocatoreModel giocatore);
	  
	
}