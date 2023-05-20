package it.univaq.disim.lpo.Model;

import java.util.List;

import com.google.common.collect.Table;

import it.univaq.disim.lpo.Service.ScacchieraService;



public abstract class ScacchieraModel implements ScacchieraService{

	private Table<Integer, Character, PezzoModel> scacchiera;

	public ScacchieraModel(Table<Integer, Character, PezzoModel> scacchiera) {
		this.scacchiera = scacchiera;
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
