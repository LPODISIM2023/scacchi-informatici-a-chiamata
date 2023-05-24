package it.univaq.disim.lpo.Service;

import java.io.Serializable;
import java.util.List;

import it.univaq.disim.lpo.Model.ScacchieraModel;

public interface Pezzo extends Serializable{

	// iF PEDONE NERO = *-1, ELSE NON FAI NIENTE;
	public List<String> mosseValide(ScacchieraModel scacchiera);


	


}
