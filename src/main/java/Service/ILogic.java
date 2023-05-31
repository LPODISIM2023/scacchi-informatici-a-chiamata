package Service;

import java.util.List;

import ServiceImpl.ContainerPartiteServiceImpl;
import ServiceImpl.PartitaServiceImpl;
import ServiceImpl.ScacchieraServiceImpl;
import it.univaq.disim.lpo.Model.Giocatore;
import it.univaq.disim.lpo.Model.Pezzo;

public interface ILogic {

	void scegliMossa(ScacchieraServiceImpl scacchiera, List<String> mosseValide, Pezzo pezzo, Giocatore giocatore2,
			PartitaServiceImpl partita, ContainerPartiteServiceImpl container);

	ScacchieraServiceImpl muovi(Pezzo pezzo, ScacchieraServiceImpl scacchiera, String input, PartitaServiceImpl partita,
			Giocatore giocatore, ContainerPartiteServiceImpl container);

	void scegliPezzo(ScacchieraServiceImpl scacchiera, Giocatore giocatore, PartitaServiceImpl partita,
			List<Pezzo> pezzi, ContainerPartiteServiceImpl container);

}