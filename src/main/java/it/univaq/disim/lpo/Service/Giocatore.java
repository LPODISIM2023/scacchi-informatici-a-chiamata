package it.univaq.disim.lpo.Service;

import java.io.FileOutputStream;
import java.io.Serializable;
import java.util.List;

import it.univaq.disim.lpo.Model.GiocatoreModel;
import it.univaq.disim.lpo.Model.PartitaModel;
import it.univaq.disim.lpo.Model.PezzoModel;
import it.univaq.disim.lpo.Model.ScacchieraModel;

public interface Giocatore extends Serializable {
	
	
	void scegliPezzo(ScacchieraModel scacchiera, GiocatoreModel giocatore, PartitaModel partita, String pathLog);
	void turno(GiocatoreModel giocatore, ScacchieraModel scacchiera, PartitaModel partita, String pathLog);
// Essendo che computer sarà sempre nero, possiamo omettere il metodo muoviB dall'interfaccia Giocatore;
//	void muoviB(PezzoModel pezzo, ScacchieraModel scacchiera, String input, PartitaModel partita,
//			GiocatoreModel giocatore);
	public void scegliMossa(ScacchieraModel scacchiera, List<String> mosseValide, PezzoModel pezzo,
			GiocatoreModel giocatore2, PartitaModel partita, String pathLog);
	public ScacchieraModel muovi(PezzoModel pezzo, ScacchieraModel scacchiera, String input, PartitaModel partita,
			GiocatoreModel giocatore, String pathLog);
}