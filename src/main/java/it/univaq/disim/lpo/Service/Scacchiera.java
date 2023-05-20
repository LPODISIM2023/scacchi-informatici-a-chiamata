package it.univaq.disim.lpo.Service;

import java.util.List;

import it.univaq.disim.lpo.Model.PezzoModel;
import it.univaq.disim.lpo.Model.ScacchieraModel;

public interface Scacchiera {

	Integer getRigaPezzoFromScacchiera(String nomePezzo);

	Character getColonnaPezzoFromScacchiera(String nomePezzo);

	PezzoModel getPezzoFromScacchieraByValue(String nomePezzo);
	
	public List<PezzoModel> getPezziFromScacchiera();

	void creaScacchiera(List<PezzoModel> pezzi);

	//  METODO PER LA STAMPA DELLA SCACCHIERA. DA VERIFICARE SE SI AGGIORNA 
	void stampaScacchiera(ScacchieraModel scacchiera);

}