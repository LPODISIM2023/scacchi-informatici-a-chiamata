package it.univaq.disim.lpo.Service;

import java.util.List;

import it.univaq.disim.lpo.Model.GiocatoreModel;
import it.univaq.disim.lpo.Model.PartitaModel;
import it.univaq.disim.lpo.Model.PezzoModel;
import it.univaq.disim.lpo.Model.ScacchieraModel;

public interface PezzoService {

	
	List<String> mosseValideB(ScacchieraModel scacchiera);
	
	public List<String> mosseValideN(ScacchieraModel scacchiera);

	public ScacchieraModel muoviB(PezzoModel pezzo, ScacchieraModel scacchiera, String input, PartitaModel partita);
	public ScacchieraModel muoviN(PezzoModel pezzo, ScacchieraModel scacchiera, String input, PartitaModel partita);



}
