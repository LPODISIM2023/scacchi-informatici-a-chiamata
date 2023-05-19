package it.univaq.disim.lpo.Service;

import java.util.List;

import it.univaq.disim.lpo.Model.GiocatoreModel;
import it.univaq.disim.lpo.Model.ScacchieraModel;

public interface Partita {

	void resa();
	void scaccoMatto();
	boolean patta();
	void scegliTipologiaPartita();
	 
	
}