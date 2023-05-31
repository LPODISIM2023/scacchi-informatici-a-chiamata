package it.univaq.disim.lpo.Model;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.Table;

import ServiceImpl.ScacchieraServiceImpl;

public class Re extends Pezzo {

	public Re(String nome, boolean isAlive, char colore) {
		super(nome, isAlive, colore);
	}

<<<<<<< HEAD:src/main/java/it/univaq/disim/lpo/Model/Re.java
=======
	@Override
>>>>>>> 4c59298aef891a7f400a9272fc50384910487c85:src/main/java/it/univaq/disim/lpo/Service/ServiceImpl/ReServiceImpl.java
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
			if (this.getIsAlive() && this.getNome().charAt(0) == 'R') {
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

<<<<<<< HEAD:src/main/java/it/univaq/disim/lpo/Model/Re.java
	public boolean scacco(ScacchieraServiceImpl scacchiera, String posizioneRe, Giocatore giocatore2) {
=======
	public boolean scaccoN(ScacchieraServiceImpl scacchiera, String posizioneRe) {
		// Table<Integer, Character, PezzoModel> table = scacchiera.getScacchiera();
		List<PezzoModel> pezzi = scacchiera.getPezziFromScacchiera();
		for (PezzoModel p : pezzi) {
			if (p.getNome().charAt(1) == 'B') {
>>>>>>> 4c59298aef891a7f400a9272fc50384910487c85:src/main/java/it/univaq/disim/lpo/Service/ServiceImpl/ReServiceImpl.java

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
<<<<<<< HEAD:src/main/java/it/univaq/disim/lpo/Model/Re.java
}
=======

	public boolean scaccoB(ScacchieraServiceImpl scacchiera, String posizioneRe) {
		// Table<Integer, Character, PezzoModel> table = scacchiera.getScacchiera()
		List<PezzoModel> pezzi = scacchiera.getPezziFromScacchiera();

		for (PezzoModel p : pezzi) {
			if (p.getNome().charAt(1) == 'N') {

				List<String> temp = p.mosseValide(scacchiera);
				if (!(pezzi.isEmpty()) && temp != null) {
					for (String s : temp) {
						if (s.equals(posizioneRe)) {
							return true;

						}

					}
				}
			}
		}
		return false;

	}

}
>>>>>>> 4c59298aef891a7f400a9272fc50384910487c85:src/main/java/it/univaq/disim/lpo/Service/ServiceImpl/ReServiceImpl.java
