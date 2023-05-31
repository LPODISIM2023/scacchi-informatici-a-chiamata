package it.univaq.disim.lpo.Model;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.Table;

import ServiceImpl.ScacchieraServiceImpl;

public class Pedone extends Pezzo {

	public Pedone(String nome, Integer valore) {
		super(nome, valore);
		// TODO Auto-generated constructor stub
	}




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

			if (this.getNome().charAt(0) == 'P') {
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
