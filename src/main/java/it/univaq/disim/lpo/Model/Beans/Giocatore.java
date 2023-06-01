package it.univaq.disim.lpo.Model.Beans;


import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import ServiceImpl.PartitaServiceImpl;
import ServiceImpl.ScacchieraServiceImpl;


public abstract class Giocatore implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3251441791103565264L;
	/**
	 * 
	 */
	/**
	 * 
	 */
	private String nomeGiocatore;
	private Pezzo re;
	private List<Pezzo> pedoni;
	private List<Pezzo> pezzi;
	
	public Giocatore(String nomeGiocatore, Pezzo re, List<Pezzo> pedoni, List<Pezzo> pezzi) {
		super();
		this.nomeGiocatore = nomeGiocatore;
		this.re = re;
		this.pedoni = pedoni;
		this.pezzi = pezzi;
	}

	public Giocatore() {
		super();
	}
	public List<Pezzo> getPedoni() {
		return pedoni;
	}


	public void setPedoni(List<Pezzo> pedoni2) {
		this.pedoni = pedoni2;
	}


	public Pezzo getRe() {
		return re;
	}


	public void setRe(Pezzo reN) {
		this.re = reN;
	}


	public List<Pezzo> getPezzi() {
		return pezzi;
	}


	public void setPezzi(List<Pezzo> pezzi) {
		this.pezzi = pezzi;
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
		Giocatore other = (Giocatore) obj;
		return Objects.equals(nomeGiocatore, other.nomeGiocatore);
	}




	abstract public void turno(Giocatore giocatore2, ScacchieraServiceImpl scacchiera, PartitaServiceImpl partita,
			ContainerPartite container);
		
	}




