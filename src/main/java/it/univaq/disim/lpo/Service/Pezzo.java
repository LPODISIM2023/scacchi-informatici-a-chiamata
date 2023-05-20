package it.univaq.disim.lpo.Service;

import java.util.List;

import it.univaq.disim.lpo.Model.ScacchieraModel;

public interface Pezzo {

	
	List<String> mosseValideB(ScacchieraModel scacchiera);
	
	public List<String> mosseValideN(ScacchieraModel scacchiera);

	


}
