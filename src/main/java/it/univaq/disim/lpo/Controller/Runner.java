package it.univaq.disim.lpo.Controller;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import ServiceImpl.PartitaServiceImpl;
import ServiceImpl.PartiteSortMosseServiceImpl;
import ServiceImpl.PartiteSortNumPezziServiceImpl;
import ServiceImpl.PartiteSortPunteggioServiceImpl;
import ServiceImpl.ScacchieraServiceImpl;
import it.univaq.disim.lpo.Model.Beans.ContainerPartite;

public class Runner implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5655076700094621901L;

	public static void main(String[] args) {

		try (Scanner scanner = new Scanner(System.in)) {

			try {
				System.setOut(new java.io.PrintStream(System.out, true, "UTF-8"));
				System.setErr(new java.io.PrintStream(System.err, true, "UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}

			// Eliminazione file log mosse per far si che venga rimpiazzato con uno nuovo.
			File file;
			String logPath = new File("src/main/resources/files/log.txt").getAbsolutePath();
			file = new File(logPath);
			if (file.exists()) {
				file.delete();
			}

			System.out.println("Cosa vuoi fare? \n 1-Nuova Partita; \n 2-Carica Partita");
			Integer input = scanner.nextInt();

			if (input == 2) {
				scegliPartita();

			} else if (input == 1) {
				LocalDateTime data = LocalDateTime.now();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				String dataFormattata = data.format(formatter);

				PartitaServiceImpl partita = new PartitaServiceImpl("Partita-" + dataFormattata, 0, null, null, null, 0,
						null, null, null, 0, false);
				partita.scegliTipologiaPartita();
			} else {
				throw new NoSuchElementException();
			}

		} catch (NoSuchElementException e) {
			System.out.println("Input Sbagliato, riavvia il programma");
		}

	}

	public static void scegliPartita() {

		List<PartitaServiceImpl> partite = new ArrayList<>();
		String partitaPath = new File("src/main/resources/files/partite.txt").getAbsolutePath();
		try (Scanner scanner = new Scanner(System.in);
				FileInputStream inputStream = new FileInputStream(partitaPath);
				ObjectInputStream objectStream = new ObjectInputStream(inputStream);) {

			ContainerPartite obj;
			while (inputStream.available() > 0) {
				obj = (ContainerPartite) objectStream.readObject();
				partite.addAll(obj.getListaPartite());
				System.out.println(obj.getListaPartite());
			}

		

		List<PartitaServiceImpl> partiteSort = new ArrayList<>();

			System.out.println(
					"In base a quale ordine vuoi ordinare le partite? \n 1-In base al numero di mosse della partita; "
							+ "\n 2-In base al numero complessivo dei pezzi sulla scacchiera; "
							+ "\n 3-In base al peso complessivo dei pezzi sulla scacchiera");

			Integer input = scanner.nextInt();
			if (input == 1) {

				Collections.sort(partite, new PartiteSortMosseServiceImpl<PartitaServiceImpl>());

				int cont = 0;
				for (PartitaServiceImpl p : partite) {
					cont += 1;
					p.setIdPartita(cont);
					System.out.printf("%d-" + p.getNomePartita() + " Numero mosse: " + p.getContatoreMosse() + "\n",
							p.getIdPartita());
					partiteSort.add(p);
				}

			} else if (input == 2) {

				Collections.sort(partite, new PartiteSortNumPezziServiceImpl<PartitaServiceImpl>());
				int cont = 0;
				for (PartitaServiceImpl p : partite) {
					cont += 1;
					p.setIdPartita(cont);
					System.out.printf("%d-" + p.getNomePartita() + " Numero Pezzi: " + p.getNumeroPezzi() + "\n",
							p.getIdPartita());
					partiteSort.add(p);
				}

			} else if (input == 3) {

				Collections.sort(partite, new PartiteSortPunteggioServiceImpl<PartitaServiceImpl>());
				int cont = 0;
				for (PartitaServiceImpl p : partite) {
					cont += 1;
					p.setIdPartita(cont);
					System.out.printf("%d-" + p.getNomePartita() + " Punteggio: " + p.getPunteggio() + "\n",
							p.getIdPartita());
					partiteSort.add(p);
				}

			} else {
				throw new NoSuchElementException();
			}

			System.out.println("Adesso scegli la partita da voler caricare.\nDigita un numero tra quelli visibili");
			input = scanner.nextInt();
			caricaPartita(input, partiteSort);

		} catch (NoSuchElementException e) {

			System.out.println("Non è stato inserito alcun input, riavvia il programma");

		} catch (EOFException e) {
			System.out.println("Il file è vuoto.");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	public static <E extends PartitaServiceImpl> void caricaPartita(Integer idPartita, List<E> lista) {

		try {
			for (E p : lista) {
				if (idPartita == p.getIdPartita()) {
					ScacchieraServiceImpl scacchiera = p.getScacchiera();
					scacchiera.stampaScacchiera(scacchiera);
					p.getGiocatore1().turno(p.getGiocatore2(), p.getScacchiera(), p);
				}
			}
		} catch (NoSuchElementException e) {
			System.out.println("L'input è sbagliato. Riavvia il programma");

		}
	}
}