package it.univaq.disim.lpo.Service;

import java.util.List;

import com.google.common.collect.HashBasedTable;

import it.univaq.disim.lpo.Model.GiocatoreModel;
import it.univaq.disim.lpo.Model.PezzoModel;
import it.univaq.disim.lpo.Model.ScacchieraModel;

public interface Pezzo {

	
	List<String> mosseValideB(ScacchieraModel scacchiera);
	
	public List<String> mosseValideN(ScacchieraModel scacchiera);

	void muovi(PezzoModel pezzo, ScacchieraModel scacchiera, String posizione);

}
