package it.univaq.disim.lpo.Service.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.Table;

import it.univaq.disim.lpo.Model.PezzoModel;
import it.univaq.disim.lpo.Model.ScacchieraModel;

public class ScacchieraServiceImpl extends ScacchieraModel {

	public ScacchieraServiceImpl(Table<Integer, Character, PezzoModel> scacchiera) {
		super(scacchiera);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Integer getRigaPezzoFromScacchiera(String nomePezzo) {

		try {
			for (Integer riga = 1; riga <= 8; riga++) {
				for (PezzoModel p : this.getScacchiera().row(riga).values()) {
					if (p != null) {
						if (p.getNome().equals(nomePezzo)) {
							return riga;
						}
					}
				}
			}

		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Character getColonnaPezzoFromScacchiera(String nomePezzo) {

		try {
			for (Character colonna = 'A'; colonna <= 'H'; colonna++) {
				for (PezzoModel p : this.getScacchiera().column(colonna).values()) {
					if (p != null) {
						if (p.getNome().equals(nomePezzo)) {
							return colonna;
						}
					}
				}
			}

		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public PezzoModel getPezzoFromScacchieraByValue(String nomePezzo) {
		try {
			for (Integer riga = 1; riga <= 8; riga++) {
				for (PezzoModel p : this.getScacchiera().row(riga).values()) {
					if (p != null) {
						if (p.getNome().equals(nomePezzo)) {
							return p;
						}
					}
				}
			}

		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void creaScacchiera(List<PezzoModel> pezzi) {

		try {
			for (PezzoModel p : pezzi) {
				if (p.getNome().equals("PB1")) {

					this.getScacchiera().put(2, 'A', p);

				} else if (p.getNome().equals("PB2")) {
					this.getScacchiera().put(2, 'B', p);
				} else if (p.getNome().equals("PB3")) {

					this.getScacchiera().put(2, 'C', p);

				} else if (p.getNome().equals("PB4")) {
					this.getScacchiera().put(2, 'D', p);
				} else if (p.getNome().equals("PB5")) {

					this.getScacchiera().put(2, 'E', p);

				} else if (p.getNome().equals("PB6")) {
					this.getScacchiera().put(2, 'F', p);
				} else if (p.getNome().equals("PB7")) {

					this.getScacchiera().put(2, 'G', p);

				} else if (p.getNome().equals("PB8")) {
					this.getScacchiera().put(2, 'H', p);
				} else

				if (p.getNome().equals("PN1")) {

					this.getScacchiera().put(7, 'A', p);

				} else if (p.getNome().equals("PN2")) {
					this.getScacchiera().put(7, 'B', p);
				} else if (p.getNome().equals("PN3")) {

					this.getScacchiera().put(7, 'C', p);

				} else if (p.getNome().equals("PN4")) {
					this.getScacchiera().put(7, 'D', p);
				} else if (p.getNome().equals("PN5")) {

					this.getScacchiera().put(7, 'E', p);

				} else if (p.getNome().equals("PN6")) {
					this.getScacchiera().put(7, 'F', p);
				} else if (p.getNome().equals("PN7")) {

					this.getScacchiera().put(7, 'G', p);

				} else if (p.getNome().equals("PN8")) {
					this.getScacchiera().put(7, 'H', p);
				} else if (p.getNome().equals("AB1")) {

					this.getScacchiera().put(1, 'C', p);
				} else if (p.getNome().equals("AB2")) {
					this.getScacchiera().put(1, 'F', p);

				} else

				if (p.getNome().equals("AN1")) {
					this.getScacchiera().put(8, 'C', p);
				} else if (p.getNome().equals("AN2")) {
					this.getScacchiera().put(8, 'F', p);

				} else

				if (p.getNome().equals("CB1")) {
					this.getScacchiera().put(1, 'B', p);
				} else if (p.getNome().equals("CB2")) {
					this.getScacchiera().put(1, 'G', p);

				} else

				if (p.getNome().equals("CN1")) {
					this.getScacchiera().put(8, 'B', p);
				} else if (p.getNome().equals("CN2")) {
					this.getScacchiera().put(8, 'G', p);

				} else

				if (p.getNome().equals("TB1")) {
					this.getScacchiera().put(1, 'A', p);
				} else if (p.getNome().equals("TB2")) {
					this.getScacchiera().put(1, 'H', p);

				} else

				if (p.getNome().equals("TN1")) {
					this.getScacchiera().put(8, 'A', p);
				} else if (p.getNome().equals("TN2")) {
					this.getScacchiera().put(8, 'H', p);
				} else

				if (p.getNome().equals("rB1")) {
					this.getScacchiera().put(1, 'D', p);
				} else if (p.getNome().equals("rN1")) {
					this.getScacchiera().put(8, 'D', p);
				} else

				if (p.getNome().equals("RB1")) {
					this.getScacchiera().put(1, 'E', p);
				} else if (p.getNome().equals("RN1")) {
					this.getScacchiera().put(8, 'E', p);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
			e.getCause();
		}

	}

//  METODO PER LA STAMPA DELLA SCACCHIERA. DA VERIFICARE SE SI AGGIORNA 
	@Override
	public void stampaScacchiera() {
		try {
			for (int riga = 1; riga <= 8; riga++) {

				System.out.printf(riga + " ");

				for (char colonna = 'A'; colonna <= 'H'; colonna++) {

					PezzoModel pezzo = this.getScacchiera().get(riga, colonna);
					if (pezzo == null) {
						System.out.print("--" + "  ");
					} else {
						String simbolo = pezzo.getNome();
						System.out.print(simbolo + " ");
					}
				}
				System.out.println();
			}
			System.out.println("  A   B   C   D   E   F   G   H");
		} catch (Exception e) {
			e.getCause();
			e.getMessage();
		}
	}
	@Override
	public List<PezzoModel> getPezziFromScacchiera() {
		Table<Integer, Character, PezzoModel> table = this.getScacchiera();
		List<PezzoModel> pezzi = new ArrayList<>();
		for (int i = 1; i <= 8; i++) {
			for (PezzoModel p : table.row(i).values()) {
				pezzi.add(p);
			}
		}
		return pezzi;
	}
	
}
