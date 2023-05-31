package it.univaq.disim.lpo.Model;

import java.util.List;

import ServiceImpl.ScacchieraServiceImpl;

public abstract class Pezzo {
	private String nome;
	private Integer valore;

	public Integer getValore() {
		return valore;
	}



	public void setValore(Integer valore) {
		this.valore = valore;
	}



	public Pezzo(String nome, Integer valore) {
		super();
		this.nome = nome;
		this.valore = valore;
	}

	

	public String getNome() {
		return nome;
	}

	
	public void setNome(String nome) {
		this.nome = nome;
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
		Pezzo other = (Pezzo) obj;
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
	
	abstract public List<String> mosseValide(ScacchieraServiceImpl scacchiera);

}
