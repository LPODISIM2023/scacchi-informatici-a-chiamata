package it.univaq.disim.lpo.Model;

import java.util.List;

import com.google.common.collect.Table;

import it.univaq.disim.lpo.Service.PezzoService;


public class ScacchieraModel {

	private Table<Integer, Character, PezzoService> scacchiera;

	public ScacchieraModel(Table<Integer, Character, PezzoService> scacchiera) {
		this.scacchiera = scacchiera;
	}

	public Table<Integer, Character, PezzoService> getScacchiera() {
		return this.scacchiera;
	}

	public Integer getRigaPezzoFromScacchiera(String nomePezzo) {

		try {
			for (Integer riga= 1; riga <= 8; riga++) {
				for (PezzoService p : this.scacchiera.row(riga).values()) {
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

	public Character getColonnaPezzoFromScacchiera(String nomePezzo) {

		try {
			for (Character colonna = 'A'; colonna <= 'H'; colonna++) {
				for (PezzoService p : this.scacchiera.column(colonna).values()) {
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

	
public PezzoService getPezzoFromScacchieraByValue(String nomePezzo) {
	try {
		for (Integer riga= 1; riga <= 8; riga++) {
			for (PezzoService p : this.scacchiera.row(riga).values()) {
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((scacchiera == null) ? 0 : scacchiera.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ScacchieraModel other = (ScacchieraModel) obj;
		if (scacchiera == null) {
			if (other.scacchiera != null)
				return false;
		} else if (!scacchiera.equals(other.scacchiera))
			return false;
		return true;
	}

	public void creaScacchiera(List<PezzoService> pezzi) {

		try {
			for (PezzoService
					p : pezzi) {
				if (p.getNome().equals("PB1")) {

					this.scacchiera.put(2, 'A', p);

				} else if (p.getNome().equals("PB2")) {
					this.scacchiera.put(2, 'B', p);
				} else if (p.getNome().equals("PB3")) {

					this.scacchiera.put(2, 'C', p);

				} else if (p.getNome().equals("PB4")) {
					this.scacchiera.put(2, 'D', p);
				} else if (p.getNome().equals("PB5")) {

					this.scacchiera.put(2, 'E', p);

				} else if (p.getNome().equals("PB6")) {
					this.scacchiera.put(2, 'F', p);
				} else if (p.getNome().equals("PB7")) {

					this.scacchiera.put(2, 'G', p);

				} else if (p.getNome().equals("PB8")) {
					this.scacchiera.put(2, 'H', p);
				} else

				if (p.getNome().equals("PN1")) {

					this.scacchiera.put(7, 'A', p);

				} else if (p.getNome().equals("PN2")) {
					this.scacchiera.put(7, 'B', p);
				} else if (p.getNome().equals("PN3")) {

					this.scacchiera.put(7, 'C', p);

				} else if (p.getNome().equals("PN4")) {
					this.scacchiera.put(7, 'D', p);
				} else if (p.getNome().equals("PN5")) {

					this.scacchiera.put(7, 'E', p);

				} else if (p.getNome().equals("PN6")) {
					this.scacchiera.put(7, 'F', p);
				} else if (p.getNome().equals("PN7")) {

					this.scacchiera.put(7, 'G', p);

				} else if (p.getNome().equals("PN8")) {
					this.scacchiera.put(7, 'H', p);
				} else if (p.getNome().equals("AB1")) {

					this.scacchiera.put(1, 'C', p);
				} else if (p.getNome().equals("AB2")) {
					this.scacchiera.put(1, 'F', p);

				} else

				if (p.getNome().equals("AN1")) {
					this.scacchiera.put(8, 'C', p);
				} else if (p.getNome().equals("AN2")) {
					this.scacchiera.put(8, 'F', p);

				} else

				if (p.getNome().equals("CB1")) {
					this.scacchiera.put(1, 'B', p);
				} else if (p.getNome().equals("CB2")) {
					this.scacchiera.put(1, 'G', p);

				} else

				if (p.getNome().equals("CN1")) {
					this.scacchiera.put(8, 'B', p);
				} else if (p.getNome().equals("CN2")) {
					this.scacchiera.put(8, 'G', p);

				} else

				if (p.getNome().equals("TB1")) {
					this.scacchiera.put(1, 'A', p);
				} else if (p.getNome().equals("TB2")) {
					this.scacchiera.put(1, 'H', p);

				} else

				if (p.getNome().equals("TN1")) {
					this.scacchiera.put(8, 'A', p);
				} else if (p.getNome().equals("TN2")) {
					this.scacchiera.put(8, 'H', p);
				} else

				if (p.getNome().equals("rB1")) {
					this.scacchiera.put(1, 'D', p);
				} else if (p.getNome().equals("rN1")) {
					this.scacchiera.put(8, 'D', p);
				} else

				if (p.getNome().equals("RB1")) {
					this.scacchiera.put(1, 'E', p);
				} else if (p.getNome().equals("RN1")) {
					this.scacchiera.put(8, 'E', p);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
			e.getCause();
		}

	}

//  METODO PER LA STAMPA DELLA SCACCHIERA. DA VERIFICARE SE SI AGGIORNA 
	public void stampaScacchiera() {
		try {
			for (int riga = 1; riga <= 8; riga++) {

				System.out.printf(riga + " ");
			
				for (char colonna = 'A'; colonna <= 'H'; colonna++) {

					PezzoService pezzo = this.scacchiera.get(riga, colonna);
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


}
