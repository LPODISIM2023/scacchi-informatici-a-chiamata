package it.univaq.disim.lpo.Controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import ServiceImpl.ContainerPartiteServiceImpl;
import ServiceImpl.PartitaServiceImpl;
import it.univaq.disim.lpo.Model.Giocatore;

public class Runner implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5655076700094621901L;

	/**
	 * 
	 */

	/**
	 * 
	 */

	/**
	 * 
	 */

	public static void main(String[] args) {
		
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Cosa vuoi fare? \n 1-Nuova Partita; \n 2-Carica Partita");
			Integer input = scanner.nextInt();
			
			if (input == 2) {
				menùPartita();
			} else if (input == 1) {
				LocalDateTime data = LocalDateTime.now();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				String dataFormattata = data.format(formatter);

				PartitaServiceImpl partita = new PartitaServiceImpl("Partita-" + dataFormattata, 0, null, null, null, 0, null, null);
				partita.scegliTipologiaPartita();
			} else {
				throw new NoSuchElementException();
			}

		} catch (NoSuchElementException e) {
			System.out.println("Input Sbagliato, riavvia il programma");
		}

	}

	public static void menùPartita() {

		List<PartitaServiceImpl> partite = new ArrayList<>();
		String partitaPath = new File("src/main/resources/files/partite.txt").getAbsolutePath();
		try (FileInputStream inputStream = new FileInputStream(partitaPath);
				ObjectInputStream objectStream = new ObjectInputStream(inputStream);) {

			ContainerPartiteServiceImpl obj;
			while (inputStream.available() > 0) {
				obj = (ContainerPartiteServiceImpl) objectStream.readObject();
				partite.addAll(obj.getListaPartite());
				System.out.println(obj.getListaPartite());
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try (Scanner scanner = new Scanner(System.in)) {

			System.out.println(
					"In base a quale ordine vuoi ordinare le partite? \n 1-In base al numero di mosse della partita; "
							+ "\n 2-In base al numero complessivo dei pezzi sulla scacchiera; "
							+ "\n 3-In base al peso complessivo dei pezzi sulla scacchiera");

			Integer input = scanner.nextInt();
			if (input == 1) {

				Collections.sort(partite, null);
				int cont = 0;
				
				for(PartitaServiceImpl p : partite) {
					System.out.printf("%d-"+ p.getNomePartita(), cont++);					
				}
				
			} else if (input == 2) {

				Collections.sort(partite, null);
				int cont = 0;
				for(PartitaServiceImpl p : partite) {
					System.out.printf("%d-"+ p.getNomePartita(), cont++);					
				}
				
			} else if (input == 3) {
				int cont = 0;
				Collections.sort(partite, null);
				for(PartitaServiceImpl p : partite) {
					System.out.printf("%d-"+ p.getNomePartita(), cont++);					
				}
				
			}
		}
	}

	public static void caricaPartita() {
		String partitaPath = new File("src/main/resources/files/partite.txt").getAbsolutePath();
		int idPartita = Integer.parseInt(input);
		try (FileInputStream deSerializzazione = new FileInputStream(partitaPath);
				ObjectInputStream deSerializzazioneInput = new ObjectInputStream(deSerializzazione)) {
			PartitaServiceImpl obj;
			while ((obj = (PartitaServiceImpl) deSerializzazioneInput.readObject()) != null) {

				if (idPartita == obj.getIdPartita()) {
					Giocatore giocatore1 = obj.getGiocatore1();
					Giocatore giocatore2 = obj.getGiocatore2();
					giocatore1.turno(giocatore2, obj.getScacchiera(), obj, container);

				}

			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
