package it.univaq.disim.lpo.Model.Beans;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import ServiceImpl.ScacchieraServiceImpl;

public class Partita implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4564750499651953524L;
	/**
	 * 
	 */
	private String nomePartita;
	private int idPartita;
	public static int contatorePatta = 0;
	private Integer contatoreMosse;
	private ScacchieraServiceImpl scacchiera;
	private Giocatore giocatore1;
	private Giocatore giocatore2;
	private Integer numeroPezzi;
	private Integer punteggio;
	private List<ScacchieraServiceImpl> scacchiere;
	private Integer contatoreUndo;
	private boolean fine;

	
	public Partita(String nomePartita, int idPartita, ScacchieraServiceImpl scacchiera, Giocatore giocatore1,
			Giocatore giocatore2, Integer contatoreMosse, Integer numeroPezzi, Integer punteggio,  List<ScacchieraServiceImpl> scacchiere,
			Integer contatoreUndo, boolean fine) {
		super();
		this.nomePartita = nomePartita;
		this.idPartita = idPartita;
		this.scacchiera = scacchiera;
		this.giocatore1 = giocatore1;
		this.giocatore2 = giocatore2;
		this.contatoreMosse = contatoreMosse;
		this.numeroPezzi = numeroPezzi;
		this.punteggio = punteggio;
		this.scacchiere = scacchiere;
		this.contatoreUndo = contatoreUndo;
		this.fine = fine;

	}
	public boolean isFine() {
		return fine;
	}
	public void setFine(boolean fine) {
		this.fine = fine;
	}
	public Integer getContatoreUndo() {
		return contatoreUndo;
	}

	public void setContatoreUndo(Integer contatoreUndo) {
		this.contatoreUndo = contatoreUndo;
	}

	public void setScacchiere(List<ScacchieraServiceImpl> scacchiere) {
		this.scacchiere = scacchiere;
	}

	public List<ScacchieraServiceImpl> getScacchiere() {
		return scacchiere;
	}
	

	public Partita() {

	}

	public Integer getPunteggio() {
		return punteggio;
	}

	public void setPunteggio(Integer punteggio) {
		this.punteggio = punteggio;
	}

	public Integer getNumeroPezzi() {
		return numeroPezzi;
	}

	public void setNumeroPezzi(Integer numeroPezzi) {
		this.numeroPezzi = numeroPezzi;
	}

	public Integer getContatoreMosse() {
		return contatoreMosse;
	}

	public void setContatoreMosse(Integer contatoreMosse) {
		this.contatoreMosse = contatoreMosse;
	}

	public Giocatore getGiocatore1() {
		return giocatore1;
	}

	public void setGiocatore1(Giocatore giocatore1) {
		this.giocatore1 = giocatore1;
	}

	public Giocatore getGiocatore2() {
		return giocatore2;
	}

	public void setGiocatore2(Giocatore giocatore2) {
		this.giocatore2 = giocatore2;
	}

	public ScacchieraServiceImpl getScacchiera() {
		return scacchiera;
	}

	public void setScacchiera(ScacchieraServiceImpl scacchiera) {
		this.scacchiera = scacchiera;
	}

	public int getIdPartita() {
		return idPartita;
	}

	public void setIdPartita(int idPartita) {
		this.idPartita = idPartita;
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
