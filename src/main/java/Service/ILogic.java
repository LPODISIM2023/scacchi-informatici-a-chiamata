package Service;

import java.util.List;

import ServiceImpl.PartitaServiceImpl;
import ServiceImpl.ScacchieraServiceImpl;
import it.univaq.disim.lpo.Model.Giocatore;
import it.univaq.disim.lpo.Model.Partita;
import it.univaq.disim.lpo.Model.Pezzo;
import it.univaq.disim.lpo.Model.Scacchiera;

public interface ILogic {
	void turno(Giocatore giocatore2, ScacchieraServiceImpl scacchiera, PartitaServiceImpl partita);



	

	void scegliMossa(ScacchieraServiceImpl scacchiera, List<String> mosseValide, Pezzo pezzo, Giocatore giocatore2,
			PartitaServiceImpl partita);

	void scegliPezzo(ScacchieraServiceImpl scacchiera, Giocatore giocatore, PartitaServiceImpl partita,
			List<Pezzo> pezzi);


	ScacchieraServiceImpl muovi(Pezzo pezzo, ScacchieraServiceImpl scacchiera, String input, PartitaServiceImpl partita,
			Giocatore giocatore);

}