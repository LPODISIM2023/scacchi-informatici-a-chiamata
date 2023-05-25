package it.univaq.disim.lpo.Controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import it.univaq.disim.lpo.Model.PartitaModel;
import it.univaq.disim.lpo.Service.ServiceImpl.PartitaServiceImpl;

public class main {

	public static void main(String[] args) {
		LocalDateTime dataOra = LocalDateTime.now();
		DateTimeFormatter formattazioneData = DateTimeFormatter.ofPattern("dd-MM-yyyy-HH-mm-ss");
		String dataFormattata = dataOra.format(formattazioneData);
		PartitaModel partita = new PartitaServiceImpl("Partita-"+ dataFormattata, 0);
	}

}
