package it.univaq.disim.lpo.Service;

import java.util.List;

import com.google.common.collect.HashBasedTable;

import it.univaq.disim.lpo.Model.PezzoModel;
import it.univaq.disim.lpo.Model.ScacchieraModel;

public interface Pezzo {


	void muovi(PezzoModel pezzo, HashBasedTable<Integer, Integer, PezzoModel> scacchiera, String posizione);
	 public List<String> mosseValide(ScacchieraModel scacchiera);


}
