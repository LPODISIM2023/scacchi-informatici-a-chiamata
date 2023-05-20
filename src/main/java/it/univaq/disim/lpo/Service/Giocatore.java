package it.univaq.disim.lpo.Service;

import java.util.List;

import it.univaq.disim.lpo.Model.GiocatoreModel;
import it.univaq.disim.lpo.Model.PartitaModel;
import it.univaq.disim.lpo.Model.PezzoModel;
import it.univaq.disim.lpo.Model.ScacchieraModel;

public interface Giocatore {
	
	
	void scegliPezzo(ScacchieraModel scacchiera, GiocatoreModel giocatore, PartitaModel partita);
	void turno(GiocatoreModel giocatore, ScacchieraModel scacchiera, PartitaModel partita);
// Essendo che computer sarà sempre nero, possiamo omettere il metodo muoviB dall'interfaccia Giocatore;
//	void muoviB(PezzoModel pezzo, ScacchieraModel scacchiera, String input, PartitaModel partita,
//			GiocatoreModel giocatore);
	public void scegliMossa(ScacchieraModel scacchiera, List<String> mosseValide, PezzoModel pezzo,
			GiocatoreModel giocatore2, PartitaModel partita);
	void muoviN(PezzoModel pezzo, ScacchieraModel scacchiera, String input, PartitaModel partita,
			GiocatoreModel giocatore);


}