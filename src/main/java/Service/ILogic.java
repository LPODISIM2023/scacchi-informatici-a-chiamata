package Service;

import java.util.List;

import ServiceImpl.PartitaServiceImpl;
import ServiceImpl.ScacchieraServiceImpl;
import it.univaq.disim.lpo.Model.Beans.ContainerPartite;
import it.univaq.disim.lpo.Model.Beans.Giocatore;
import it.univaq.disim.lpo.Model.Beans.Pezzo;

public interface ILogic {


	ScacchieraServiceImpl muovi(Pezzo pezzo, ScacchieraServiceImpl scacchiera, String input, PartitaServiceImpl partita,
			Giocatore giocatore);

	void scegliMossa(ScacchieraServiceImpl scacchiera, List<String> mosseValide, Pezzo pezzo, Giocatore giocatore2,
			PartitaServiceImpl partita);

	void scegliPezzo(ScacchieraServiceImpl scacchiera, Giocatore giocatore, PartitaServiceImpl partita,
			List<Pezzo> pezzi);


}