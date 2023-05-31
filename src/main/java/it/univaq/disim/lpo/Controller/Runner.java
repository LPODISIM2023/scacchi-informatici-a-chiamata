package it.univaq.disim.lpo.Controller;

import ServiceImpl.PartitaServiceImpl;
import it.univaq.disim.lpo.Model.Partita;

public class Runner {

	public static void main(String[] args) {
		PartitaServiceImpl partita = new PartitaServiceImpl("Partita1");		
		partita.scegliTipologiaPartita();
	}

}
