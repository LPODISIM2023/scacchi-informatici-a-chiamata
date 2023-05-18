package it.univaq.disim.lpo.Service;

import java.util.List;

import com.google.common.collect.HashBasedTable;

import it.univaq.disim.lpo.Model.PezzoModel;
import it.univaq.disim.lpo.Model.ScacchieraModel;

public interface PezzoService {
	String getNome();

	void setNome(String nome);

	boolean getIsAlive();

	void setAlive(boolean isAlive);

	int hashCode();

	boolean equals(Object obj);

	String toString();


	void muovi(PezzoModel pezzo, HashBasedTable<Integer, Integer, PezzoModel> scacchiera);
	 public List<String> mosseValide(ScacchieraModel scacchiera);


}
