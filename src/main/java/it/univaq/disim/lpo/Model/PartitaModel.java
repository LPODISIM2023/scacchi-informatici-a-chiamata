package it.univaq.disim.lpo.Model;

import java.io.Serializable;
import java.util.Objects;

import it.univaq.disim.lpo.Service.Partita;

public abstract class PartitaModel implements Partita, Serializable {
	public static int contatoreMosse = 0;
	private String nomePartita;
	private int id;

	public PartitaModel(String nomePartita, int id) {
		super();
		this.nomePartita = nomePartita;
		this.id = id;
	}

	public String getNomePartita() {
		return nomePartita;
	}

	public void setNomePartita(String nomePartita) {
		this.nomePartita = nomePartita;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nomePartita);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PartitaModel other = (PartitaModel) obj;
		return Objects.equals(nomePartita, other.nomePartita);
	}

	@Override
	public String toString() {
		return "PartitaModel [nomePartita=" + nomePartita + "]";
	}

	public int getId() {
		return id;
	}

	public int setId(int id) {
		return this.id = id;
	}
	
}
