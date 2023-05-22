package it.univaq.disim.lpo.Service.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.Table;

import it.univaq.disim.lpo.Model.PezzoModel;
import it.univaq.disim.lpo.Model.ScacchieraModel;

public class AlfiereServiceImpl extends PezzoModel {
	public AlfiereServiceImpl(String nome, boolean isAlive) {
		super(nome, isAlive);
	}

	@Override
	public List<String> mosseValideB(ScacchieraModel scacchiera) {
		List<String> mosseValide = new ArrayList<>();
		try {
			Table<Integer, Character, PezzoModel> table = scacchiera.getScacchiera();
			if (this.getNome() != null && this.getIsAlive() != false) {
				Integer posizionePezzoRiga = scacchiera.getRigaPezzoFromScacchiera(this.getNome());
				Character posizionePezzoColonna = scacchiera.getColonnaPezzoFromScacchiera(this.getNome());
				int posizioneNuovaRiga;
				char posizioneNuovaColonna;
				if (this.getNome().equals("AB1") || this.getNome().equals("AB2")) {
					boolean trovato = false;
					int tempRiga = posizionePezzoRiga;
					char tempColonna = posizionePezzoColonna;

					while (trovato == false) {

						posizioneNuovaRiga = ++tempRiga;
						posizioneNuovaColonna = (char) (--tempColonna);
						if (posizioneNuovaRiga <= 8 && posizioneNuovaColonna >= 'A') {
							PezzoModel temp = table.get(posizioneNuovaRiga, posizioneNuovaColonna);
							if (temp != null) {
								if (temp.getNome().charAt(1) == 'N') {
									String posizione = posizioneNuovaColonna + "" + posizioneNuovaRiga;
									mosseValide.add(posizione);
									trovato = true;
								} else {
									trovato = true;

								}
							} else {
								// Debug
								String posizione = posizioneNuovaColonna + "" + posizioneNuovaRiga;
								mosseValide.add(posizione);

							}

						} else {
							trovato = true;
						}
					}
					tempRiga = posizionePezzoRiga;
					tempColonna = posizionePezzoColonna;
					trovato = false;
					while (trovato == false) {
						posizioneNuovaRiga = --tempRiga;
						posizioneNuovaColonna = (char) (--tempColonna);
						if (posizioneNuovaRiga >= 1 && posizioneNuovaColonna >= 'A') {
							PezzoModel temp = table.get(posizioneNuovaRiga, posizioneNuovaColonna);
							if (temp != null) {
								if (temp.getNome().charAt(1) == 'N') {
									String posizione = posizioneNuovaColonna + "" + posizioneNuovaRiga;
									mosseValide.add(posizione);
									trovato = true;
								} else {

									trovato = true;
								}
							} else {
								String posizione = posizioneNuovaColonna + "" + posizioneNuovaRiga;
								mosseValide.add(posizione);

							}

						} else {
							trovato = true;
						}
					}
					tempRiga = posizionePezzoRiga;
					tempColonna = posizionePezzoColonna;
					trovato = false;
					while (trovato == false) {
						posizioneNuovaRiga = ++tempRiga;
						posizioneNuovaColonna = (char) (++tempColonna);
						if (posizioneNuovaRiga <= 8 && posizioneNuovaColonna <= 'H') {
							PezzoModel temp = table.get(posizioneNuovaRiga, posizioneNuovaColonna);
							if (temp != null) {
								if (temp.getNome().charAt(1) == 'N') {
									String posizione = posizioneNuovaColonna + "" + posizioneNuovaRiga;
									mosseValide.add(posizione);
									trovato = true;
								} else {

									trovato = true;

								}
							} else {
								String posizione = posizioneNuovaColonna + "" + posizioneNuovaRiga;

								mosseValide.add(posizione);

							}

						} else {
							trovato = true;
						}
					}
					tempRiga = posizionePezzoRiga;
					tempColonna = posizionePezzoColonna;
					trovato = false;
					while (tempRiga >= 1 && tempColonna <= 'H' && trovato == false) {
						posizioneNuovaRiga = --tempRiga;
						posizioneNuovaColonna = (char) (++tempColonna);
						if (posizioneNuovaRiga >= 1 && posizioneNuovaColonna >= 'A') {
							PezzoModel temp = table.get(posizioneNuovaRiga, posizioneNuovaColonna);
							if (temp != null) {
								if (temp.getNome().charAt(1) == 'N') {
									String posizione = posizioneNuovaColonna + "" + posizioneNuovaRiga;
									mosseValide.add(posizione);
									trovato = true;
								} else {

									trovato = true;
								}
							} else {
								String posizione = posizioneNuovaColonna + "" + posizioneNuovaRiga;
								mosseValide.add(posizione);

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

	@Override
	public List<String> mosseValideN(ScacchieraModel scacchiera) {

		List<String> mosseValide = new ArrayList<>();
		try {
			Table<Integer, Character, PezzoModel> table = scacchiera.getScacchiera();
			if (this.getNome() != null && this.getIsAlive() != false) {
				Integer posizionePezzoRiga = scacchiera.getRigaPezzoFromScacchiera(this.getNome());
				Character posizionePezzoColonna = scacchiera.getColonnaPezzoFromScacchiera(this.getNome());
				int posizioneNuovaRiga;
				char posizioneNuovaColonna;
				if (this.getNome().equals("AN1") || this.getNome().equals("AN2")) {
					boolean trovato = false;
					int tempRiga = posizionePezzoRiga;
					char tempColonna = posizionePezzoColonna;

					while (tempRiga >= 1 && tempColonna >= 'A' && trovato == false) {

						posizioneNuovaRiga = --tempRiga;
						posizioneNuovaColonna = (char) (--tempColonna);
						if (posizioneNuovaRiga >= 1 && posizioneNuovaColonna >= 'A') {
							PezzoModel temp = table.get(posizioneNuovaRiga, posizioneNuovaColonna);
							if (temp != null) {
								if (temp.getNome().charAt(1) == 'B') {
									String posizione = posizioneNuovaColonna + "" + posizioneNuovaRiga;
									mosseValide.add(posizione);
									trovato = true;
								} else {
									trovato = true;

								}
							} else {
								// Debug
								String posizione = posizioneNuovaColonna + "" + posizioneNuovaRiga;
								mosseValide.add(posizione);

							}

						} else {
							trovato = true;
						}
					}
					tempRiga = posizionePezzoRiga;
					tempColonna = posizionePezzoColonna;
					trovato = false;
					while (tempRiga <= 8 && tempColonna >= 'A' && trovato == false) {
						posizioneNuovaRiga = ++tempRiga;
						posizioneNuovaColonna = (char) (--tempColonna);
						if (posizioneNuovaRiga <= 8 && posizioneNuovaColonna >= 'A') {
							PezzoModel temp = table.get(posizioneNuovaRiga, posizioneNuovaColonna);
							if (temp != null) {
								if (temp.getNome().charAt(1) == 'B') {
									String posizione = posizioneNuovaColonna + "" + posizioneNuovaRiga;
									mosseValide.add(posizione);
									trovato = true;
								} else {

									trovato = true;
								}
							} else {
								String posizione = posizioneNuovaColonna + "" + posizioneNuovaRiga;
								mosseValide.add(posizione);

							}

						} else {
							trovato = true;
						}
					}

					tempRiga = posizionePezzoRiga;
					tempColonna = posizionePezzoColonna;
					trovato = false;
					while (tempRiga >= 1 && tempColonna >= 'A' && trovato == false) {
						posizioneNuovaRiga = --tempRiga;
						posizioneNuovaColonna = (char) (++tempColonna);
						if (posizioneNuovaRiga >= 1 && posizioneNuovaColonna <= 'H') {
							PezzoModel temp = table.get(posizioneNuovaRiga, posizioneNuovaColonna);
							if (temp != null) {
								if (temp.getNome().charAt(1) == 'B') {
									String posizione = posizioneNuovaColonna + "" + posizioneNuovaRiga;
									mosseValide.add(posizione);
									trovato = true;
								} else {

									trovato = true;

								}
							} else {
								String posizione = posizioneNuovaColonna + "" + posizioneNuovaRiga;

								mosseValide.add(posizione);

							}

						} else {
							trovato = true;
						}
					}
					tempRiga = posizionePezzoRiga;
					tempColonna = posizionePezzoColonna;
					trovato = false;
					while (tempRiga <= 8 && tempColonna <= 'H' && trovato == false) {
						 posizioneNuovaRiga = ++tempRiga;
						 posizioneNuovaColonna = (char) (++tempColonna);
						if (posizioneNuovaRiga <= 8 && posizioneNuovaColonna >= 'A') {
							PezzoModel temp = table.get(posizioneNuovaRiga, posizioneNuovaColonna);
							if (temp != null) {
								if (temp.getNome().charAt(1) == 'B') {
									String posizione = posizioneNuovaColonna + "" + posizioneNuovaRiga;
									mosseValide.add(posizione);
									trovato = true;
								} else {

									trovato = true;
								}
							} else {
								String posizione = posizioneNuovaColonna + "" + posizioneNuovaRiga;
								mosseValide.add(posizione);

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
