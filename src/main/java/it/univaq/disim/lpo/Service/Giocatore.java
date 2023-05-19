package it.univaq.disim.lpo.Service;

import it.univaq.disim.lpo.Model.GiocatoreModel;
import it.univaq.disim.lpo.Model.ScacchieraModel;
import it.univaq.disim.lpo.Service.ServiceImpl.PartitaServiceImpl;

public interface Giocatore {
	
	
	public void turno(GiocatoreModel giocatore, ScacchieraModel scacchiera, PartitaServiceImpl partita);
	public void scegliPezzo(ScacchieraModel scacchiera, GiocatoreModel giocatore);
	

}