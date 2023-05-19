package it.univaq.disim.lpo.Model;

import java.util.Objects;

import it.univaq.disim.lpo.Service.Giocatore;

public abstract class GiocatoreModel implements Giocatore {
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

}
