package ServiceImpl;

<<<<<<< HEAD:src/main/java/ServiceImpl/ScacchieraServiceImpl.java

import java.io.BufferedWriter;
import java.io.File;
=======
import java.io.File;
import java.io.FileInputStream;
>>>>>>> 4c59298aef891a7f400a9272fc50384910487c85:src/main/java/it/univaq/disim/lpo/Service/ServiceImpl/ScacchieraServiceImpl.java
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.Table;

import it.univaq.disim.lpo.Model.Pezzo;
import it.univaq.disim.lpo.Model.Scacchiera;

<<<<<<< HEAD:src/main/java/ServiceImpl/ScacchieraServiceImpl.java
public class ScacchieraServiceImpl extends Scacchiera {
=======
public class ScacchieraServiceImpl extends ScacchieraModel implements Serializable {
>>>>>>> 4c59298aef891a7f400a9272fc50384910487c85:src/main/java/it/univaq/disim/lpo/Service/ServiceImpl/ScacchieraServiceImpl.java

	public ScacchieraServiceImpl(Table<Integer, Character, Pezzo> scacchiera) {
		super(scacchiera);
		// TODO Auto-generated constructor stub
	}

<<<<<<< HEAD:src/main/java/ServiceImpl/ScacchieraServiceImpl.java
	
=======
>>>>>>> 4c59298aef891a7f400a9272fc50384910487c85:src/main/java/it/univaq/disim/lpo/Service/ServiceImpl/ScacchieraServiceImpl.java
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

<<<<<<< HEAD:src/main/java/ServiceImpl/ScacchieraServiceImpl.java
	
=======
>>>>>>> 4c59298aef891a7f400a9272fc50384910487c85:src/main/java/it/univaq/disim/lpo/Service/ServiceImpl/ScacchieraServiceImpl.java
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

<<<<<<< HEAD:src/main/java/ServiceImpl/ScacchieraServiceImpl.java
	
	public Pezzo getPezzoFromScacchieraByValue(String nomePezzo) {
=======
	public PezzoModel getPezzoFromScacchieraByValue(String nomePezzo) {
>>>>>>> 4c59298aef891a7f400a9272fc50384910487c85:src/main/java/it/univaq/disim/lpo/Service/ServiceImpl/ScacchieraServiceImpl.java
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

<<<<<<< HEAD:src/main/java/ServiceImpl/ScacchieraServiceImpl.java
	
	public ScacchieraServiceImpl creaScacchiera(List<Pezzo> pezziB, List<Pezzo> pezziN ) {
=======
	public void creaScacchiera(List<PezzoModel> pezzi) {
>>>>>>> 4c59298aef891a7f400a9272fc50384910487c85:src/main/java/it/univaq/disim/lpo/Service/ServiceImpl/ScacchieraServiceImpl.java
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
<<<<<<< HEAD:src/main/java/ServiceImpl/ScacchieraServiceImpl.java
	
	public void stampaScacchiera(Scacchiera scacchiera) {
=======
	public void stampaScacchiera(ScacchieraModel scacchiera) {
>>>>>>> 4c59298aef891a7f400a9272fc50384910487c85:src/main/java/it/univaq/disim/lpo/Service/ServiceImpl/ScacchieraServiceImpl.java
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

<<<<<<< HEAD:src/main/java/ServiceImpl/ScacchieraServiceImpl.java
	
	public List<Pezzo> getPezziFromScacchiera() {
		Table<Integer, Character, Pezzo> table = this.getScacchiera();
		List<Pezzo> pezzi = new ArrayList<>();
=======
	public List<PezzoModel> getPezziFromScacchiera() {
		Table<Integer, Character, PezzoModel> table = this.getScacchiera();
		List<PezzoModel> pezzi = new ArrayList<>();
>>>>>>> 4c59298aef891a7f400a9272fc50384910487c85:src/main/java/it/univaq/disim/lpo/Service/ServiceImpl/ScacchieraServiceImpl.java
		for (int i = 1; i <= 8; i++) {
			for (Pezzo p : table.row(i).values()) {
				pezzi.add(p);
			}
		}
		return pezzi;
	}

<<<<<<< HEAD:src/main/java/ServiceImpl/ScacchieraServiceImpl.java
	
	public void salvaMossa(String mossa, Pezzo pezzo) {
		String logPath = new File("src/main/resources/files/log.txt").getAbsolutePath();
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(logPath, true));) {			
			writer.write("Mosso il pezzo " + pezzo.getNome() + " in posizione " + mossa +"\n");
=======
	public void salvaScacchiera(ScacchieraServiceImpl scacchiera) {
		String scacchieraPath = new File("src/main/resources/files/log.txt").getAbsolutePath();
		try (FileOutputStream outputFile = new FileOutputStream(scacchieraPath, true);
				ObjectOutputStream oggettoOutput = new ObjectOutputStream(outputFile)) {

			oggettoOutput.writeObject(scacchiera);

>>>>>>> 4c59298aef891a7f400a9272fc50384910487c85:src/main/java/it/univaq/disim/lpo/Service/ServiceImpl/ScacchieraServiceImpl.java
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
	}

<<<<<<< HEAD:src/main/java/ServiceImpl/ScacchieraServiceImpl.java
	
	public void getUltimaScacchiera(String pathLog, Scacchiera scacchiera) {
		try (FileOutputStream outputFile = new FileOutputStream(pathLog);
=======
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

	public ScacchieraServiceImpl getScacchieraPrecedente() {
		String scacchieraPath = new File("src/main/resources/files/log.txt").getAbsolutePath();

		try (FileInputStream outputFile = new FileInputStream(scacchieraPath);
				ObjectInputStream oggettoOutput = new ObjectInputStream(outputFile)) {
			ScacchieraServiceImpl scacchieraTemp;
			rimuoviPrimoOggetto();
			scacchieraTemp = (ScacchieraServiceImpl) oggettoOutput.readObject();
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
		List<ScacchieraServiceImpl> scacchiere = new ArrayList<>();

		String scacchieraPath = new File("src/main/resources/files/log.txt").getAbsolutePath();
		try (FileInputStream outputFile = new FileInputStream(scacchieraPath);
				ObjectInputStream oggettoInput = new ObjectInputStream(outputFile)) {
			ScacchieraServiceImpl scacchieraTemp;
			boolean primoElemento = true;
			while ((scacchieraTemp = (ScacchieraServiceImpl) oggettoInput.readObject()) != null) {
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
>>>>>>> 4c59298aef891a7f400a9272fc50384910487c85:src/main/java/it/univaq/disim/lpo/Service/ServiceImpl/ScacchieraServiceImpl.java
				ObjectOutputStream oggettoOutput = new ObjectOutputStream(outputFile)) {

			for (ScacchieraModel s : scacchiere) {
				oggettoOutput.writeObject(s);

			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void eliminaLogScacchiere() {
		String scacchieraPath = new File("src/main/resources/files/log.txt").getAbsolutePath();
		File file = new File(scacchieraPath);
		if (file.exists()) {
			file.delete();
		}
	}
}
