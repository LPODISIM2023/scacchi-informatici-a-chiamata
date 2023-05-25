package it.univaq.disim.lpo.Service.ServiceImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.Table;

import it.univaq.disim.lpo.Model.PezzoModel;
import it.univaq.disim.lpo.Model.ScacchieraModel;

public class ScacchieraServiceImpl extends ScacchieraModel {

	public ScacchieraServiceImpl(Table<Integer, Character, PezzoModel> scacchiera, int idScacchiera, int idPartita) {
		super(scacchiera, idScacchiera, idPartita);
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
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
			e.getCause();
		}
	}

//  METODO PER LA STAMPA DELLA SCACCHIERA. DA VERIFICARE SE SI AGGIORNA 
	@Override
	public void stampaScacchiera(ScacchieraModel scacchiera) {
		try {
			for (int riga = 1; riga <= 8; riga++) {

				System.out.printf(riga + " ");

				for (char colonna = 'A'; colonna <= 'H'; colonna++) {

					PezzoModel pezzo = scacchiera.getScacchiera().get(riga, colonna);
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

	// Metodi di gestione a livello file di scacchiere.
	@Override
	public void salvaScacchiera(ScacchieraModel scacchiera) {
		String scacchieraPath = new File("src/main/resources/files/log.txt").getAbsolutePath();
		try (FileOutputStream outputFile = new FileOutputStream(scacchieraPath, true);
				ObjectOutputStream oggettoOutput = new ObjectOutputStream(outputFile)) {

			oggettoOutput.writeObject(scacchiera);

		} catch (IOException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ScacchieraModel getUltimaScacchiera() {
		String scacchieraPath = new File("src/main/resources/files/log.txt").getAbsolutePath();
		try (FileInputStream outputFile = new FileInputStream(scacchieraPath);
				ObjectInputStream oggettoOutput = new ObjectInputStream(outputFile)) {

			ScacchieraModel scacchieraTemp;
			scacchieraTemp = (ScacchieraModel) oggettoOutput.readObject();
			return scacchieraTemp;

		} catch (IOException e) {
			e.printStackTrace();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ScacchieraModel getScacchieraPrecedente() {
		String scacchieraPath = new File("src/main/resources/files/log.txt").getAbsolutePath();
		
		try (FileInputStream outputFile = new FileInputStream(scacchieraPath);
			ObjectInputStream oggettoOutput = new ObjectInputStream(outputFile)) {
			ScacchieraModel scacchieraTemp;
			rimuoviPrimoOggetto();
			scacchieraTemp = (ScacchieraModel) oggettoOutput.readObject();
			return scacchieraTemp;

		} catch (IOException e) {
			e.printStackTrace();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
	
	public void rimuoviPrimoOggetto() {
		List<ScacchieraModel> scacchiere = new ArrayList<>();

		String scacchieraPath = new File("src/main/resources/files/log.txt").getAbsolutePath();
		try (FileInputStream outputFile = new FileInputStream(scacchieraPath);		
			ObjectInputStream oggettoInput = new ObjectInputStream(outputFile)){ 
			ScacchieraModel scacchieraTemp;
			boolean primoElemento = true;
			while ((scacchieraTemp = (ScacchieraModel) oggettoInput.readObject()) != null) {
				if (!primoElemento) {
					scacchiere.add(scacchieraTemp);
				} else {
					primoElemento = false;
				}


			}
		} catch (IOException e) {
			e.printStackTrace();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try (FileOutputStream outputFile = new FileOutputStream(scacchieraPath);
				ObjectOutputStream oggettoOutput = new ObjectOutputStream(outputFile)) {
			
			for(ScacchieraModel s : scacchiere) {
                oggettoOutput.writeObject(s);

			}
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}

