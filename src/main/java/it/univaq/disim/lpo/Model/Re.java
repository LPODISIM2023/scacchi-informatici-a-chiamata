package it.univaq.disim.lpo.Model;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.Table;

import ServiceImpl.ScacchieraServiceImpl;
import it.univaq.disim.lpo.Model.Beans.Giocatore;
import it.univaq.disim.lpo.Model.Beans.Pezzo;

public class Re extends Pezzo {

	/**
	 * 
	 */
	
	public Re(String nome, Integer valore) {
		super(nome, valore);
		// TODO Auto-generated constructor stub
	}

	public Re() {
		super();
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
				blocco = false;
				dRiga++;
				dCol = (char) (dCol + 1);
				if (dRiga <= 8 && dCol <= 'H') {
					blocco = aggiungiMossa(dRiga, dCol, mosseValide, table, blocco);
				}
				dRiga = posizionePezzoRiga;
				dCol = posizionePezzoColonna;
				blocco = false;
				dRiga--;
				dCol = (char) (dCol - 1);
				if (dRiga >= 1 && dCol >= 'A') {
					blocco = aggiungiMossa(dRiga, dCol, mosseValide, table, blocco);
				}

				dRiga = posizionePezzoRiga;
				dCol = posizionePezzoColonna;
				blocco = false;
				dRiga++;
				dCol = (char) (dCol - 1);
				if (dRiga <= 8 && dCol >= 'A') {
					blocco = aggiungiMossa(dRiga, dCol, mosseValide, table, blocco);

				}

				dRiga = posizionePezzoRiga;
				dCol = posizionePezzoColonna;
				blocco = false;
				dRiga--;
				dCol = (char) (dCol + 1);
				if (dRiga >= 1 && dCol <= 'H') {
					blocco = aggiungiMossa(dRiga, dCol, mosseValide, table, blocco);

				}
				// MOVIMENTI VERTICALI
				dRiga = posizionePezzoRiga;
				dCol = posizionePezzoColonna;
				blocco = false;
				dRiga++;
				if (dRiga <= 8) {
					blocco = aggiungiMossa(dRiga, dCol, mosseValide, table, blocco);
				}
				dRiga = posizionePezzoRiga;
				dCol = posizionePezzoColonna;
				blocco = false;
				dRiga--;
				if (dRiga >= 1) {
					blocco = aggiungiMossa(dRiga, dCol, mosseValide, table, blocco);
				}
				// MOVIMENTI ORIZZONTALI
				dRiga = posizionePezzoRiga;
				dCol = posizionePezzoColonna;
				blocco = false;
				dCol = (char) (dCol + 1);
				if (dCol <= 'H') {
					blocco = aggiungiMossa(dRiga, dCol, mosseValide, table, blocco);
				}

				dRiga = posizionePezzoRiga;
				dCol = posizionePezzoColonna;
				blocco = false;
				dCol = (char) (dCol - 1);
				if (dCol >= 'A') {
					blocco = aggiungiMossa(dRiga, dCol, mosseValide, table, blocco);
				}
			
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mosseValide;
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

	public boolean scacco(ScacchieraServiceImpl scacchiera, String posizioneRe, Giocatore giocatore2) {

		List<Pezzo> pezzi = giocatore2.getPezzi();
		for (Pezzo p : pezzi) {
			List<String> temp = p.mosseValide(scacchiera);
			if (!(pezzi.isEmpty()) && temp != null) {
				for (String s : temp) {
					if (s.equals(posizioneRe)) {
						return true;

					}

				}
			}
		}
		return false;
	}
}