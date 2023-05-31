package ServiceImpl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.Table;

import it.univaq.disim.lpo.Model.Pezzo;
import it.univaq.disim.lpo.Model.Scacchiera;

public class ScacchieraServiceImpl extends Scacchiera implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6974402625519565886L;

	public ScacchieraServiceImpl() {
		super();
	}
	public ScacchieraServiceImpl(Table<Integer, Character, Pezzo> scacchiera) {
		super(scacchiera);
		// TODO Auto-generated constructor stub
	}

	public Integer getRigaPezzoFromScacchiera(String nomePezzo) {

		try {
			for (Integer riga = 1; riga <= 8; riga++) {
				for (Pezzo p : this.getScacchiera().row(riga).values()) {
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
				for (Pezzo p : this.getScacchiera().column(colonna).values()) {
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

	public Pezzo getPezzoFromScacchieraByValue(String nomePezzo) {
		try {
			for (Integer riga = 1; riga <= 8; riga++) {
				for (Pezzo p : this.getScacchiera().row(riga).values()) {
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

	public ScacchieraServiceImpl creaScacchiera(List<Pezzo> pezziB, List<Pezzo> pezziN) {
		try {
			List<Pezzo> pezzi = new ArrayList<>();
			pezzi.addAll(pezziB);
			pezzi.addAll(pezziN);
			// pedoniB
			this.getScacchiera().put(2, 'A', pezzi.get(0));
			this.getScacchiera().put(2, 'B', pezzi.get(1));
			this.getScacchiera().put(2, 'C', pezzi.get(2));
			this.getScacchiera().put(2, 'D', pezzi.get(3));
			this.getScacchiera().put(2, 'E', pezzi.get(4));
			this.getScacchiera().put(2, 'F', pezzi.get(5));
			this.getScacchiera().put(2, 'G', pezzi.get(6));
			this.getScacchiera().put(2, 'H', pezzi.get(7));

			// alfiereB
			this.getScacchiera().put(1, 'C', pezzi.get(8));
			this.getScacchiera().put(1, 'F', pezzi.get(9));
			// torreB
			this.getScacchiera().put(1, 'A', pezzi.get(10));
			this.getScacchiera().put(1, 'H', pezzi.get(11));
			// REGINAB
			this.getScacchiera().put(1, 'D', pezzi.get(13));
			// rEB
			this.getScacchiera().put(1, 'E', pezzi.get(12));
			// cavalloB
			this.getScacchiera().put(1, 'B', pezzi.get(14));
			this.getScacchiera().put(1, 'G', pezzi.get(15));
			// pedoneN
			this.getScacchiera().put(7, 'A', pezzi.get(16));
			this.getScacchiera().put(7, 'B', pezzi.get(17));
			this.getScacchiera().put(7, 'C', pezzi.get(18));
			this.getScacchiera().put(7, 'D', pezzi.get(19));
			this.getScacchiera().put(7, 'E', pezzi.get(20));
			this.getScacchiera().put(7, 'F', pezzi.get(21));
			this.getScacchiera().put(7, 'G', pezzi.get(22));
			this.getScacchiera().put(7, 'H', pezzi.get(23));
			// alfiereN
			this.getScacchiera().put(8, 'C', pezzi.get(24));
			this.getScacchiera().put(8, 'F', pezzi.get(25));
			// torreN
			this.getScacchiera().put(8, 'A', pezzi.get(26));
			this.getScacchiera().put(8, 'H', pezzi.get(27));
			// REGINAN
			this.getScacchiera().put(8, 'D', pezzi.get(29));
			// reN
			this.getScacchiera().put(8, 'E', pezzi.get(28));
			// cavalloN
			this.getScacchiera().put(8, 'B', pezzi.get(30));
			this.getScacchiera().put(8, 'G', pezzi.get(31));

			return this;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
			e.getCause();
		}
		return null;
	}

//  METODO PER LA STAMPA DELLA SCACCHIERA. DA VERIFICARE SE SI AGGIORNA 

	public void stampaScacchiera(Scacchiera scacchiera) {
		try {
			for (int riga = 1; riga <= 8; riga++) {

				System.out.printf(riga + " ");

				for (char colonna = 'A'; colonna <= 'H'; colonna++) {

					Pezzo pezzo = scacchiera.getScacchiera().get(riga, colonna);
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
			System.out.println(e.getCause());
			System.out.println(e.getMessage());
		}
	}

	public List<Pezzo> getPezziFromScacchiera() {
		Table<Integer, Character, Pezzo> table = this.getScacchiera();
		List<Pezzo> pezzi = new ArrayList<>();
		for (int i = 1; i <= 8; i++) {
			for (Pezzo p : table.row(i).values()) {
				pezzi.add(p);
			}
		}
		return pezzi;
	}

	public void salvaMossa(String mossa, Pezzo pezzo) {
		String logPath = new File("src/main/resources/files/log.txt").getAbsolutePath();
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(logPath, true));) {
			writer.write("Mosso il pezzo " + pezzo.getNome() + " in posizione " + mossa + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

/*
 * Ho due file log e partita log si crea ogni volta che runno il codie. Dentro
 * deve contenere le scacchiere. Partita.txt ha il nome della partita e l'ultima
 * scacchiera. partita è collegata col log. La classe Mossa mi serve per gestire
 * il log;
 * 
 * Nel metodo muovi faccio il salvataggio della mossa;
 * 
 */
