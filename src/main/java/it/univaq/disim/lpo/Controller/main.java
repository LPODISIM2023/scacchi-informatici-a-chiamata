package it.univaq.disim.lpo.Controller;

import it.univaq.disim.lpo.Model.PartitaModel;
import it.univaq.disim.lpo.Service.ServiceImpl.PartitaServiceImpl;

public class main {

	public static void main(String[] args) {
		PartitaModel partita = new PartitaServiceImpl("Partita1");
		partita.inzia();

	}

}
