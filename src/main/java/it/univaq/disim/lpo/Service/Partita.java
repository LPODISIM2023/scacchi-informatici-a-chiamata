package it.univaq.disim.lpo.Service;

import it.univaq.disim.lpo.Model.ScacchieraModel;

public interface Partita {

	void resa();
	boolean scaccoB(ScacchieraModel scacchiera);
	boolean scaccoN(ScacchieraModel scacchiera);
	void scaccoMatto();
	boolean patta();
	void scegliTipologiaPartita();
	 
	
}