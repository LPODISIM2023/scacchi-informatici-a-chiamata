package it.univaq.disim.lpo.Service.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.Table;

import it.univaq.disim.lpo.Model.PezzoModel;
import it.univaq.disim.lpo.Model.ScacchieraModel;

public class CavalloServiceImpl extends PezzoModel {

	public CavalloServiceImpl(String nome, boolean isAlive) {
		super(nome, isAlive);
		// TODO Auto-generated constructor stub
	}

	public boolean aggiungiMossa(int riga, char colonna, List<String> mosse, Table<Integer, Character, PezzoModel> t,
			boolean blocco) {

		PezzoModel temp = t.get(riga, colonna);
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

	@Override
	public List<String> mosseValide(ScacchieraModel scacchiera) {
		List<String> mosseValide = new ArrayList<>();
		try {
			Table<Integer, Character, PezzoModel> table = scacchiera.getScacchiera();
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
