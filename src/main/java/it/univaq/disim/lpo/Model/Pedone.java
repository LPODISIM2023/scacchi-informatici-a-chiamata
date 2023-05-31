package it.univaq.disim.lpo.Model;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.Table;

import ServiceImpl.ScacchieraServiceImpl;
import it.univaq.disim.lpo.Model.Pezzo;
import it.univaq.disim.lpo.Model.Scacchiera;

public class Pedone extends Pezzo {

	public Pedone(String nome, boolean isAlive, char colore) {
		super(nome, isAlive, colore);
		// TODO Auto-generated constructor stub
	}


<<<<<<< HEAD:src/main/java/it/univaq/disim/lpo/Model/Pedone.java
=======
	@Override
>>>>>>> 4c59298aef891a7f400a9272fc50384910487c85:src/main/java/it/univaq/disim/lpo/Service/ServiceImpl/PedoneServiceImpl.java
	public List<String> mosseValide(ScacchieraServiceImpl scacchiera) {
		List<String> mosseValide = new ArrayList<>();
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

			if (this.getIsAlive() && this.getNome().charAt(0) == 'P') {
				if (this.getNome().charAt(1) == 'B') {
					blocco = false;
					dRiga++;
					dCol = (char) (dCol + 1);
					if (dRiga <= 8 && dCol <= 'H') {
						blocco = mossaPedoneObliquo(dRiga, dCol, mosseValide, table, blocco);
					}
				} else {
					blocco = false;
					dRiga--;
					dCol = (char) (dCol + 1);
					if (dRiga >= 1 && dCol <= 'H') {
						blocco = mossaPedoneObliquo(dRiga, dCol, mosseValide, table, blocco);
					}
				}
				dRiga = posizionePezzoRiga;
				dCol = posizionePezzoColonna;
				if (this.getNome().charAt(1) == 'B') {
					blocco = false;
					dRiga++;
					dCol = (char) (dCol - 1);
					if (dRiga <= 8 && dCol >= 'A') {
						blocco = mossaPedoneObliquo(dRiga, dCol, mosseValide, table, blocco);
					}
				} else {
					blocco = false;
					dRiga--;
					dCol = (char) (dCol - 1);
					if (dRiga >= 1 && dCol >= 'A') {
						blocco = mossaPedoneObliquo(dRiga, dCol, mosseValide, table, blocco);
					}
				}

				// MOVIMENTI VERTICALI
				dRiga = posizionePezzoRiga;
				dCol = posizionePezzoColonna;

				if (this.getNome().charAt(1) == 'B') {            
					blocco = false;
					dRiga++;
					if (dRiga <= 8) {
						blocco = aggiungiMossa(dRiga, dCol, mosseValide, table, blocco);
					}
				} else {
					blocco = false;
					dRiga--;
					if (dRiga >= 1) {
						blocco = aggiungiMossa(dRiga, dCol, mosseValide, table, blocco);
					}
				}

			}
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mosseValide;

	}

	public boolean mossaPedoneObliquo(int riga, char colonna, List<String> mosse,
			Table<Integer, Character, Pezzo> t, boolean blocco) {
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
			blocco = true;
			return blocco;
		}

	}

	public boolean aggiungiMossa(int riga, char colonna, List<String> mosse, Table<Integer, Character, Pezzo> t,
			boolean blocco) {

		Pezzo temp = t.get(riga, colonna);
		if (temp != null) {
			if (this.getNome().charAt(1) != temp.getNome().charAt(1)) {
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

}
