package it.univaq.disim.lpo.Model;


import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.Table;

import ServiceImpl.ScacchieraServiceImpl;
import it.univaq.disim.lpo.Model.Pezzo;
import it.univaq.disim.lpo.Model.Scacchiera;

public class Cavallo extends Pezzo {

	public Cavallo(String nome, boolean isAlive, char colore) {
		super(nome, isAlive, colore);
		// TODO Auto-generated constructor stub
	}

	public boolean aggiungiMossa(int riga, char colonna, List<String> mosse, Table<Integer, Character, Pezzo> t,
			boolean blocco) {

		Pezzo temp = t.get(riga, colonna);
		if (temp != null) {
			if (this.getNome().charAt(1) != temp.getNome().charAt(1)) {
				String posizione = colonna + "" + riga;
				mosse.add(posizione);
				blocco = true;
				return blocco;
			} else {
				blocco = true;
				return blocco;
			}
		} else {
			String posizione = colonna + "" + riga;
			mosse.add(posizione);
			blocco = true;
			return blocco;
		}
	}

<<<<<<< HEAD:src/main/java/it/univaq/disim/lpo/Model/Cavallo.java
	public List<String> mosseValide(ScacchieraServiceImpl scacchiera) {
	List<String> mosseValide = new ArrayList<>();
=======
	@Override
	public List<String> mosseValide(ScacchieraServiceImpl scacchiera) {
		List<String> mosseValide = new ArrayList<>();
>>>>>>> 4c59298aef891a7f400a9272fc50384910487c85:src/main/java/it/univaq/disim/lpo/Service/ServiceImpl/CavalloServiceImpl.java
		try {
			Table<Integer, Character, Pezzo> table = scacchiera.getScacchiera();
			Integer posizionePezzoRiga = scacchiera.getRigaPezzoFromScacchiera(this.getNome());
			Character posizionePezzoColonna = scacchiera.getColonnaPezzoFromScacchiera(this.getNome());
			boolean blocco = false;
			int dRiga = posizionePezzoRiga;
			char dCol = posizionePezzoColonna;
			if (posizionePezzoRiga == null || posizionePezzoColonna == null) {
				return mosseValide;
			}
			if (this.getIsAlive() && this.getNome().charAt(0) == 'C') {
				blocco = false;
				dRiga = dRiga + 2;
				dCol = (char)(dCol + 1);
				while (dRiga <= 8 && dCol <= 'H' && blocco == false) { 
					blocco = aggiungiMossa(dRiga, dCol, mosseValide, table, blocco);
					dRiga = dRiga + 2;
					dCol = (char) (dCol + 1);
				}
				dRiga = posizionePezzoRiga;
				dCol = posizionePezzoColonna;
				blocco = false;
				dRiga = dRiga + 2;
				dCol = (char)(dCol - 1);
				while (dRiga <= 8 && dCol >= 'A' && blocco == false) {
					blocco = aggiungiMossa(dRiga, dCol, mosseValide, table, blocco);
					dRiga = dRiga + 2;
					dCol = (char)(dCol - 1);
				}

				dRiga = posizionePezzoRiga;
				dCol = posizionePezzoColonna;
				blocco = false;
				dRiga = dRiga + 1;
				dCol = (char)(dCol + 2);
				while (dRiga <= 8 && dCol <= 'H' && blocco == false) {
					blocco = aggiungiMossa(dRiga, dCol, mosseValide, table, blocco);
					dRiga = dRiga + 1;
					dCol = (char)(dCol + 2);
				}

				dRiga = posizionePezzoRiga;
				dCol = posizionePezzoColonna;
				blocco = false;
				dRiga = dRiga + 1;
				dCol = (char)(dCol - 2);
				while (dRiga <= 8 && dCol >= 'A' && blocco == false) {
					blocco = aggiungiMossa(dRiga, dCol, mosseValide, table, blocco);
					dRiga = dRiga + 1;
					dCol = (char)(dCol + 2);
				}
				
				dRiga = posizionePezzoRiga;
				dCol = posizionePezzoColonna;
				blocco = false;
				dRiga = dRiga - 2;
				dCol = (char)(dCol + 2);
				while (dRiga >= 1 && dCol <= 'H' && blocco == false) {
					blocco = aggiungiMossa(dRiga, dCol, mosseValide, table, blocco);
					dRiga = dRiga - 2;
					dCol = (char)(dCol + 2);
				}
				
				dRiga = posizionePezzoRiga;
				dCol = posizionePezzoColonna;
				blocco = false;
				dRiga = dRiga - 2;
				dCol = (char)(dCol - 2);
				while (dRiga >= 1 && dCol >= 'A' && blocco == false) {
					blocco = aggiungiMossa(dRiga, dCol, mosseValide, table, blocco);
					dRiga = dRiga - 2;
					dCol = (char)(dCol - 2);
				}
				
				dRiga = posizionePezzoRiga;
				dCol = posizionePezzoColonna;
				blocco = false;
				dRiga = dRiga - 1;
				dCol = (char)(dCol + 2);
				while (dRiga >= 1 && dCol <= 'H' && blocco == false) {
					blocco = aggiungiMossa(dRiga, dCol, mosseValide, table, blocco);
					dRiga = dRiga - 1;
					dCol = (char)(dCol + 2);
				}
				
				dRiga = posizionePezzoRiga;
				dCol = posizionePezzoColonna;
				blocco = false;
				dRiga = dRiga - 1;
				dCol = (char)(dCol - 2);
				while (dRiga >= 1 && dCol >= 'A' && blocco == false) {
					blocco = aggiungiMossa(dRiga, dCol, mosseValide, table, blocco);
					dRiga = dRiga - 1;
					dCol = (char)(dCol - 2);
				}
			}
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mosseValide;
	
	}


}
