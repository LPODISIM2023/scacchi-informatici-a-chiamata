package it.univaq.disim.lpo.Model;

import java.util.List;

<<<<<<< HEAD:src/main/java/it/univaq/disim/lpo/Model/Pezzo.java
import ServiceImpl.ScacchieraServiceImpl;

public abstract class Pezzo{
=======
import it.univaq.disim.lpo.Service.ServiceImpl.ScacchieraServiceImpl;

public abstract class PezzoModel{
>>>>>>> 4c59298aef891a7f400a9272fc50384910487c85:src/main/java/it/univaq/disim/lpo/Model/PezzoModel.java
	private String nome;
	private boolean isAlive;
	private char colore;

	public Pezzo(String nome, boolean isAlive, char colore) {
		super();
		this.nome = nome;
		this.isAlive = isAlive;
		this.colore = colore;
	}

	
	public char getColore() {
		return colore;
	}


	public void setColore(char colore) {
		this.colore = colore;
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
<<<<<<< HEAD:src/main/java/it/univaq/disim/lpo/Model/Pezzo.java
=======
	
	abstract public List<String> mosseValide(ScacchieraServiceImpl scacchiera);


>>>>>>> 4c59298aef891a7f400a9272fc50384910487c85:src/main/java/it/univaq/disim/lpo/Model/PezzoModel.java
	
	abstract public List<String> mosseValide(ScacchieraServiceImpl scacchiera);

}
