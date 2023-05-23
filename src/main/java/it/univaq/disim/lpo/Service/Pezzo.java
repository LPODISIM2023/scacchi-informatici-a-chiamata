package it.univaq.disim.lpo.Service;

import java.util.List;

import it.univaq.disim.lpo.Model.ScacchieraModel;

public interface Pezzo {

	// iF PEDONE NERO = *-1, ELSE NON FAI NIENTE;
	public List<String> mosseValide(ScacchieraModel scacchiera);


	


}
