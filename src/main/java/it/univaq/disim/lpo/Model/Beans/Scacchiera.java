package it.univaq.disim.lpo.Model.Beans;

import java.io.Serializable;

import com.google.common.collect.Table;


public class Scacchiera implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2841724450382372184L;
	private Table<Integer, Character, Pezzo> scacchiera;

	public Scacchiera(Table<Integer, Character, Pezzo> scacchiera) {
		super();
		this.scacchiera = scacchiera;
	
	}

	public Scacchiera() {
		super();
	}


	public Table<Integer, Character, Pezzo> getScacchiera() {
		return this.scacchiera;
	}

	public void setScacchiera(Table<Integer, Character, Pezzo> scacchiera) {
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
		Scacchiera other = (Scacchiera) obj;
		if (scacchiera == null) {
			if (other.scacchiera != null)
				return false;
		} else if (!scacchiera.equals(other.scacchiera))
			return false;
		return true;
	}



}
