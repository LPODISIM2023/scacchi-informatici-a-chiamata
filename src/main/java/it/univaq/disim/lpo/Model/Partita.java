package it.univaq.disim.lpo.Model;

import java.util.Objects;

<<<<<<< HEAD:src/main/java/it/univaq/disim/lpo/Model/Partita.java
public abstract class Partita{
=======
public class PartitaModel {
>>>>>>> 4c59298aef891a7f400a9272fc50384910487c85:src/main/java/it/univaq/disim/lpo/Model/PartitaModel.java
	private String nomePartita;
	public static int contatoreMosse = 0;

	public Partita(String nomePartita) {
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
		Partita other = (Partita) obj;
		return Objects.equals(nomePartita, other.nomePartita);
	}

	@Override
	public String toString() {
		return "PartitaModel [nomePartita=" + nomePartita + "]";
	}
	
}
