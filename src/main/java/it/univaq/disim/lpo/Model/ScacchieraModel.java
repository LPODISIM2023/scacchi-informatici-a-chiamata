package it.univaq.disim.lpo.Model;

import java.io.Serializable;

import com.google.common.collect.Table;

import it.univaq.disim.lpo.Service.Scacchiera;



public abstract class ScacchieraModel implements Scacchiera, Serializable{
	static int contatoreTurni;
	private Table<Integer, Character, PezzoModel> scacchiera;
	private int idScacchiera;
	private int idPartita;
	
	public ScacchieraModel(Table<Integer, Character, PezzoModel> scacchiera, int idScacchiera, int idPartita) {
		this.scacchiera = scacchiera;
		this.idScacchiera  = idScacchiera;
		this.idPartita = idPartita;
	}

	public int getIdScacchiera() {
		return idScacchiera;
	}

	public void setIdScacchiera(int idScacchiera) {
		this.idScacchiera = idScacchiera;
	}

	public int getIdPartita() {
		return idPartita;
	}

	public void setIdPartita(int idPartita) {
		this.idPartita = idPartita;
	}

	public Table<Integer, Character, PezzoModel> getScacchiera() {
		return this.scacchiera;
	}

	public void setScacchiera(Table<Integer, Character, PezzoModel> scacchiera) {
		this.scacchiera = scacchiera;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((scacchiera == null) ? 0 : scacchiera.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ScacchieraModel other = (ScacchieraModel) obj;
		if (scacchiera == null) {
			if (other.scacchiera != null)
				return false;
		} else if (!scacchiera.equals(other.scacchiera))
			return false;
		return true;
	}



}
