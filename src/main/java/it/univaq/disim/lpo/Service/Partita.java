package it.univaq.disim.lpo.Service;

import java.util.List;

import it.univaq.disim.lpo.Model.GiocatoreModel;
import it.univaq.disim.lpo.Model.ScacchieraModel;

public interface Partita {

	void inzia();
	void resa();
	void scaccoMatto();
	void scegliTipologiaPartita(ScacchieraModel scacchiera);
	boolean patta();
	 
	
}