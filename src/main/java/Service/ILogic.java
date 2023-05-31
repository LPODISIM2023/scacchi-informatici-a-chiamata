package Service;

import java.util.List;

import ServiceImpl.ContainerPartite;
import ServiceImpl.PartitaServiceImpl;
import ServiceImpl.ScacchieraServiceImpl;
import it.univaq.disim.lpo.Model.Giocatore;
import it.univaq.disim.lpo.Model.Pezzo;

public interface ILogic {

	void scegliMossa(ScacchieraServiceImpl scacchiera, List<String> mosseValide, Pezzo pezzo, Giocatore giocatore2,
			PartitaServiceImpl partita, ContainerPartite container);

	ScacchieraServiceImpl muovi(Pezzo pezzo, ScacchieraServiceImpl scacchiera, String input, PartitaServiceImpl partita,
			Giocatore giocatore, ContainerPartite container);

	void scegliPezzo(ScacchieraServiceImpl scacchiera, Giocatore giocatore, PartitaServiceImpl partita,
			List<Pezzo> pezzi, ContainerPartite container);

}