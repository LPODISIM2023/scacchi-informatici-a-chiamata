package ServiceImpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import Service.ILogic;
import it.univaq.disim.lpo.Model.Re;
import it.univaq.disim.lpo.Model.Beans.Giocatore;
import it.univaq.disim.lpo.Model.Beans.Partita;
import it.univaq.disim.lpo.Model.Beans.Pezzo;

public class ComputerServiceImpl extends Giocatore implements ILogic, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -17276626306650323L;

	public ComputerServiceImpl(String nomeGiocatore, Pezzo re, List<Pezzo> pedoni, List<Pezzo> pezzi) {
		super(nomeGiocatore, re, pedoni, pezzi);
		// TODO Auto-generated constructor stub
	}

	public ComputerServiceImpl() {
		super();
	}

	@Override
	public void turno(Giocatore giocatore2, ScacchieraServiceImpl scacchiera, PartitaServiceImpl partita) {
		int patta = 50;
		try {
			List<Pezzo> pezzi = new ArrayList<>();
			pezzi = this.getPezzi();
			if (Partita.contatorePatta >= patta) {
				throw new InterruptedException("La partita è finita in patta.");

			} else {

				Re re = (Re) this.getRe();
				if (re != null) {
					String posizioneRe = scacchiera.getColonnaPezzoFromScacchiera(re.getNome()) + ""
							+ scacchiera.getRigaPezzoFromScacchiera(re.getNome());
					if (re.scacco(scacchiera, posizioneRe, giocatore2) == true) {
						if (partita.scaccoMatto(scacchiera, giocatore2, this) == true) {
							throw new InterruptedException(
									"Partita finita, ha vinto il giocatore " + giocatore2.getNomeGiocatore());
						}
						System.out.println(
								"Il tuo " + this.getRe().getNome() + " e' andato in scacco. Risolvi questo problema");
					}
				}
				scegliPezzo(scacchiera, giocatore2, partita, pezzi);

			}

		} catch (InterruptedException e) {
			if (!partita.isFine()) {
				System.out.println(e.getMessage());
				partita.setFine(true);
			}
		}
	}

	@Override
	public void scegliPezzo(ScacchieraServiceImpl scacchiera, Giocatore giocatore, PartitaServiceImpl partita,
			List<Pezzo> pezzi) {
		try {

			Random random = new Random();
			Pezzo pezzo;
			pezzo = scacchiera.getPezzoFromScacchieraByValue(pezzi.get(random.nextInt(pezzi.size())).getNome());
			if (pezzo != null) {
				System.out.println(this.getNomeGiocatore() + ": " + "Ho scelto il pezzo " + pezzo.getNome());
				List<String> mosseValide = pezzo.mosseValide(scacchiera);
				scegliMossa(scacchiera, mosseValide, pezzo, giocatore, partita);
			} else {
				throw new NullPointerException();
			}

		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void scegliMossa(ScacchieraServiceImpl scacchiera, List<String> mosseValide, Pezzo pezzo,
			Giocatore giocatore2, PartitaServiceImpl partita) {
		Random random = new Random();
		if (!mosseValide.isEmpty()) {
			String posizione = mosseValide.get(random.nextInt(0, mosseValide.size()));
			ScacchieraServiceImpl scacchieraNuova = this.muovi(pezzo, scacchiera, posizione, partita, giocatore2);
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			giocatore2.turno(this, scacchieraNuova, partita);
		} else {
			System.out.println("Lista mosse per il pezzo " + pezzo.getNome() + "e' vuota");
			this.scegliPezzo(scacchiera, giocatore2, partita, this.getPezzi());
		}
	}

	@Override
	public ScacchieraServiceImpl muovi(Pezzo pezzo, ScacchieraServiceImpl scacchiera, String input,
			PartitaServiceImpl partita, Giocatore giocatore) {

		

		Table<Integer, Character, Pezzo> table = HashBasedTable.create(scacchiera.getScacchiera());
		List<ScacchieraServiceImpl> list = partita.getScacchiere();
		Integer contatoreMosse = partita.getContatoreMosse();
		Integer punteggio;
		Integer posizioneRigaAttuale = scacchiera.getRigaPezzoFromScacchiera(pezzo.getNome());
		Character posizioneColonnaAttuale = scacchiera.getColonnaPezzoFromScacchiera(pezzo.getNome());

		char carattereNumerico = input.charAt(1);
		int posizioneRigaNuova = Character.getNumericValue(carattereNumerico);
		Character posizioneColonnaNuova = (char) input.charAt(0);
		Pezzo pezzoMorto = table.get(posizioneRigaNuova, posizioneColonnaNuova);
		String posizioneNuova = posizioneColonnaNuova + "" + posizioneRigaNuova;

		if (pezzoMorto != null) {

			System.out.println("Ho mangiato il pezzo: " + table.get(posizioneRigaNuova, posizioneColonnaNuova).getNome()
					+ " utilizzando " + pezzo.getNome());

			table.put(posizioneRigaNuova, posizioneColonnaNuova, pezzo);

			table.remove(posizioneRigaAttuale, posizioneColonnaAttuale);

			// Aggiornamento lista pezzi nel caso in cui si è rimosso un pezzo
			List<Pezzo> pezzi = new ArrayList<>();
			pezzi = giocatore.getPezzi();
			pezzi.remove(pezzoMorto);
			giocatore.setPezzi(pezzi);

			// Aggiornamento valori della partita dopo aver mangiato
			Partita.contatorePatta = 0;
			System.out.println(Partita.contatorePatta);
			partita.setContatoreMosse(++contatoreMosse);
			partita.setNumeroPezzi(this.getPezzi().size() + giocatore.getPezzi().size());
			punteggio = partita.punteggioTotale(this.getPezzi(), giocatore.getPezzi());
			partita.setPunteggio(punteggio);
		} else {

			table.put(posizioneRigaNuova, posizioneColonnaNuova, pezzo);
			System.out.println(this.getNomeGiocatore() + ": " + "Ho mosso il pezzo " + pezzo.getNome()
					+ " in posizione " + posizioneColonnaNuova + "" + posizioneRigaNuova);

			if ((this.getPedoni().contains(pezzo))) {
				Partita.contatorePatta = 0;
				System.out.println("Contatore Patta: " + Partita.contatorePatta);
				partita.setContatoreMosse(contatoreMosse + 1);
				table.remove(posizioneRigaAttuale, posizioneColonnaAttuale);

			} else {
				Partita.contatorePatta++;
				System.out.println("Contatore Patta: " + Partita.contatorePatta);
				partita.setContatoreMosse(contatoreMosse + 1);
				table.remove(posizioneRigaAttuale, posizioneColonnaAttuale);

			}

		}
		// Verifica se dopo aver spostato un pezzo il re è andato sottoscacco oppure si
		// è tolto dallo scacco
		ScacchieraServiceImpl scacchieraScacco = new ScacchieraServiceImpl(table);

		Re pezzoRe = (Re) this.getRe();

		try {
			if (pezzoRe == null) {
				throw new NullPointerException();
			}
			Integer posizioneRigaRe = scacchieraScacco.getRigaPezzoFromScacchiera(pezzoRe.getNome());
			Character posizioneColonnaRe = scacchieraScacco.getColonnaPezzoFromScacchiera(pezzoRe.getNome());
			String posizioneRe = posizioneColonnaRe + "" + posizioneRigaRe;
			// Il giocatore rappresenta giocatore2;
			if (pezzoRe.scacco(scacchieraScacco, posizioneRe, giocatore) == true) {
				System.out.println("Il tuo ReB è ancora sotto scacco. Scegli un altro pezzo oppure muovi il re");
				Partita.contatorePatta--;
				partita.setContatoreMosse(contatoreMosse--);
				scacchiera.stampaScacchiera(scacchiera);
				scegliPezzo(scacchiera, giocatore, partita, this.getPezzi());
			} else {
				ScacchieraServiceImpl nuovaScacchiera = new ScacchieraServiceImpl(scacchiera.getScacchiera());
			    nuovaScacchiera.setScacchiera(table);
				list.add(nuovaScacchiera);
				partita.setScacchiere(list);
			    partita.salvaMossa(posizioneNuova, pezzo, this);
			    nuovaScacchiera.stampaScacchiera(nuovaScacchiera);
			    return nuovaScacchiera;

			}
		} catch (NullPointerException e) {
			System.out.println("Il reB ha un riferimento nullo anche se non dovrebbe succedere");
		}

		return null;
	}

	
}
