package it.univaq.disim.lpo.Service.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.Table;

import it.univaq.disim.lpo.Model.PezzoModel;
import it.univaq.disim.lpo.Model.ScacchieraModel;

public class PedoneServiceImpl extends PezzoModel {

	public PedoneServiceImpl(String nome, boolean isAlive) {
		super(nome, isAlive);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<String> mosseValideB(ScacchieraModel scacchiera) {

		List<String> mosseValide = new ArrayList<>();
		try {
			Table<Integer, Character, PezzoModel> table = scacchiera.getScacchiera();
			if (this != null) {
				Integer posizionePezzoRiga = scacchiera.getRigaPezzoFromScacchiera(this.getNome());
				Character posizionePezzoColonna = scacchiera.getColonnaPezzoFromScacchiera(this.getNome());

				if (this.getNome().equals("PB1") || this.getNome().equals("PB2") || this.getNome().equals("PB3")
						|| this.getNome().equals("PB4") || this.getNome().equals("PB5") || this.getNome().equals("PB6")
						|| this.getNome().equals("PB7") || this.getNome().equals("PB8")) {
					boolean trovato = false;
					int tempRiga = posizionePezzoRiga;

					while (trovato == false) {
						int posizioneNuovaRiga = tempRiga + 1;

						if (posizioneNuovaRiga <= 8) {

							if (table.get(posizioneNuovaRiga, posizionePezzoColonna) != null) {
								PezzoModel temp = table.get(posizioneNuovaRiga, posizionePezzoColonna);
								if (temp.getNome().charAt(1) == 'B') {
									trovato = true;
								} else {
									trovato = true;

								}
							} else {
								// Debug
								String posizione = posizionePezzoColonna + "" + posizioneNuovaRiga;
								mosseValide.add(posizione);
								trovato = true;

							}
							char tempColonna = posizionePezzoColonna;
							char posizioneNuovaColonna = tempColonna++;
							if (table.get(posizioneNuovaRiga, posizioneNuovaColonna) != null) {
								PezzoModel temp = table.get(posizioneNuovaRiga, posizionePezzoColonna);
								if (temp.getNome().charAt(1) == 'N') {
									String posizione = posizionePezzoColonna + "" + posizioneNuovaRiga;

									mosseValide.add(posizione);
									trovato = true;
								} else {
									trovato = true;
								}
							}

						} else {

							trovato = true;
						}
						char tempColonna = posizionePezzoColonna;
						char posizioneNuovaColonna = tempColonna--;
						if (table.get(posizioneNuovaRiga, posizioneNuovaColonna) != null) {
							PezzoModel temp = table.get(posizioneNuovaRiga, posizionePezzoColonna);
							if (temp.getNome().charAt(1) == 'N') {
								String posizione = posizionePezzoColonna + "" + posizioneNuovaRiga;
								mosseValide.add(posizione);
								trovato = true;
							} else {
								trovato = true;
							}
						} else {

							trovato = true;
						}

					}
				}
			}

		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mosseValide;
	}

	public List<String> mosseValideN(ScacchieraModel scacchiera) {

		List<String> mosseValide = new ArrayList<>();
		try {
			Table<Integer, Character, PezzoModel> table = scacchiera.getScacchiera();
			if (this != null) {
				Integer posizionePezzoRiga = scacchiera.getRigaPezzoFromScacchiera(this.getNome());
				Character posizionePezzoColonna = scacchiera.getColonnaPezzoFromScacchiera(this.getNome());

				if (this.getNome().equals("PN1") || this.getNome().equals("PN2") || this.getNome().equals("PN3")
						|| this.getNome().equals("PN4") || this.getNome().equals("PN5") || this.getNome().equals("PN6")
						|| this.getNome().equals("PN7") || this.getNome().equals("PN8")) {
					boolean trovato = false;
					int tempRiga = posizionePezzoRiga;

					while (trovato == false) {
						int posizioneNuovaRiga = tempRiga - 1;
						if (posizioneNuovaRiga >= 1) {

							if (table.get(posizioneNuovaRiga, posizionePezzoColonna) != null) {
								PezzoModel temp = table.get(posizioneNuovaRiga, posizionePezzoColonna);
								if (temp.getNome().charAt(1) == 'B') {
									trovato = true;
								} else {
									trovato = true;

								}
							} else {
								// Debug
								String posizione = posizionePezzoColonna + "" + posizioneNuovaRiga;
								mosseValide.add(posizione);
								trovato = true;

							}
							char tempColonna = posizionePezzoColonna;
							char posizioneNuovaColonna = (char)(tempColonna + 1);
							if (posizioneNuovaColonna <= 'H') {
								if (table.get(posizioneNuovaRiga, posizioneNuovaColonna) != null) {
									PezzoModel temp = table.get(posizioneNuovaRiga, posizioneNuovaColonna);
									if (temp.getNome().charAt(1) == 'B') {
										String posizione = posizioneNuovaColonna + "" + posizioneNuovaRiga;
										mosseValide.add(posizione);
										trovato = true;
									} else {
										trovato = true;
									}
								}

							}
						} else {

							trovato = true;
						}
						char tempColonna = posizionePezzoColonna;
						char posizioneNuovaColonna = (char)(tempColonna - 1);
						if (table.get(posizioneNuovaRiga, posizioneNuovaColonna) != null) {
							PezzoModel temp = table.get(posizioneNuovaRiga, posizioneNuovaColonna);
							if (temp.getNome().charAt(1) == 'N') {
								String posizione = posizioneNuovaColonna + "" + posizioneNuovaRiga;
								mosseValide.add(posizione);
								trovato = true;
							} else {
								trovato = true;
							}
						} else {

							trovato = true;
						}

					}
				}
			}

		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mosseValide;
	}

}
