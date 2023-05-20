package it.univaq.disim.lpo.Model;

import it.univaq.disim.lpo.Service.PezzoService;

public abstract class PezzoModel implements PezzoService{
	private String nome;
	private boolean isAlive;

	public PezzoModel(String nome, boolean isAlive) {
		super();
		this.nome = nome;
		this.isAlive = isAlive;
	}

	
	public String getNome() {
		return nome;
	}

	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean getIsAlive() {
		return this.isAlive;
	}

	
	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}
	
	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PezzoModel other = (PezzoModel) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PezzoModel [nome=" + nome + ", getNome()=" + getNome() + ", hashCode()=" + hashCode() + ", getClass()="
				+ getClass() + "]";

	}

	
}
