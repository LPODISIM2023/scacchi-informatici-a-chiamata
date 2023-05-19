package it.univaq.disim.lpo.Service;

import java.util.List;

import it.univaq.disim.lpo.Model.GiocatoreModel;
import it.univaq.disim.lpo.Model.ScacchieraModel;

public interface Giocatore {
	
	
	public void turno(GiocatoreModel giocatore, ScacchieraModel scacchiera);
	public void scegliPezzo(ScacchieraModel scacchiera, GiocatoreModel giocatore);
	

}