package it.univaq.disim.lpo.Model;

import java.util.Objects;

public class PartitaModel {
	private String nomePartita;
	public static int contatoreMosse = 0;

	public PartitaModel(String nomePartita) {
		super();
		this.nomePartita = nomePartita;
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
	
}
