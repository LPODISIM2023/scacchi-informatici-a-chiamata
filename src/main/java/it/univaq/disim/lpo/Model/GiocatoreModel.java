package it.univaq.disim.lpo.Model;


import java.util.List;
import java.util.Objects;

import it.univaq.disim.lpo.Service.ServiceImpl.PartitaServiceImpl;
import it.univaq.disim.lpo.Service.ServiceImpl.ScacchieraServiceImpl;

public abstract class GiocatoreModel {
	private String nomeGiocatore;

	public GiocatoreModel(String nomeGiocatore) {
		super();
		this.nomeGiocatore = nomeGiocatore;
	}

	public String getNomeGiocatore() {
		return nomeGiocatore;
	}

	public void setNomeGiocatore(String nomeGiocatore) {
		this.nomeGiocatore = nomeGiocatore;
	}


	@Override
	public int hashCode() {
		return Objects.hash(nomeGiocatore);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GiocatoreModel other = (GiocatoreModel) obj;
		return Objects.equals(nomeGiocatore, other.nomeGiocatore);
	}
	public abstract void scegliPezzo(ScacchieraServiceImpl scacchiera, GiocatoreModel giocatore, PartitaServiceImpl partita);
	public abstract void turno(GiocatoreModel giocatore, ScacchieraServiceImpl scacchiera, PartitaServiceImpl partita);
	abstract public void scegliMossa(ScacchieraServiceImpl scacchiera, List<String> mosseValide, PezzoModel pezzo,
			GiocatoreModel giocatore2, PartitaServiceImpl partita);
	abstract public ScacchieraServiceImpl muovi(PezzoModel pezzo, ScacchieraServiceImpl scacchiera, String input, PartitaServiceImpl partita,
			GiocatoreModel giocatore);
}
