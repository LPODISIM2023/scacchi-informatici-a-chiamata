
package it.univaq.disim.lpo.Service.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import it.univaq.disim.lpo.Model.AlfiereModel;
import it.univaq.disim.lpo.Model.PezzoModel;
import it.univaq.disim.lpo.Model.ScacchieraModel;
import it.univaq.disim.lpo.Service.PezzoService;

public class AlfiereServiceImpl extends AlfiereModel implements PezzoService {
	public AlfiereServiceImpl(String nome, boolean isAlive) {
		super(nome, isAlive);
	}

	@Override
	public List<String> mosseValide(ScacchieraModel scacchiera) {

		List<String> mosseValide = new ArrayList<>();
		try {
			Table<Integer, Character, PezzoService> table = scacchiera.getScacchiera();
			if (this.getNome() != null && this.getIsAlive() != false) {
				Integer posizionePezzoRiga = scacchiera.getRigaPezzoFromScacchiera(this.getNome());
				Character posizionePezzoColonna = scacchiera.getColonnaPezzoFromScacchiera(this.getNome());

				if (this.getNome().equals("AB1") || this.getNome().equals("AB2")) {
					boolean trovato = false;
					int tempRiga = posizionePezzoRiga;
					char tempColonna = posizionePezzoColonna;

					while (trovato == false) {

						int posizioneNuovaRiga = ++tempRiga;
						char posizioneNuovaColonna = (char) (--tempColonna);
						if (posizioneNuovaRiga <= 8 && posizioneNuovaColonna >= 'A') {
							PezzoService temp = table.get(posizioneNuovaRiga, posizioneNuovaColonna);
							if (temp != null) {
								if (temp.getNome().charAt(2) == 'N') {
									String posizione = "Riga: " + posizioneNuovaRiga + " " + "Colonna "
											+ posizioneNuovaColonna;
									mosseValide.add(posizione);
									trovato = true;
								} else {
									trovato = true;

								}
							} else {
								// Debug
								String posizione = "Riga: " + posizioneNuovaRiga + " " + "Colonna "
										+ posizioneNuovaColonna;
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
						int posizioneNuovaRiga = --tempRiga;
						char posizioneNuovaColonna = (char) (--tempColonna);
						if (posizioneNuovaRiga >= 1 && posizioneNuovaColonna >= 'A') {
							PezzoService temp = table.get(posizioneNuovaRiga, posizioneNuovaColonna);
							if (temp != null) {
								if (temp.getNome().charAt(2) == 'B') {
									String posizione = "Riga: " + posizioneNuovaRiga + " " + "Colonna "
											+ posizioneNuovaColonna;
									mosseValide.add(posizione);
									trovato = true;
								} else {

									trovato = true;
								}
							} else {
								String posizione = "Riga: " + posizioneNuovaRiga + " " + "Colonna "
										+ posizioneNuovaColonna;
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
						int posizioneNuovaRiga = ++tempRiga;
						char posizioneNuovaColonna = (char) (++tempColonna);
						if (posizioneNuovaRiga <= 8 && posizioneNuovaColonna <= 'H') {
							PezzoService temp = table.get(posizioneNuovaRiga, posizioneNuovaColonna);
							if (temp != null) {
								System.out.println(temp.toString());
								if (temp.getNome().charAt(2) == 'B') {
									String posizione = "Riga: " + posizioneNuovaRiga + " " + "Colonna "
											+ posizioneNuovaColonna;
									mosseValide.add(posizione);
									trovato = true;
								} else {
									System.out.println(temp.getNome());

									trovato = true;

								}
							} else {
								String posizione = "Riga: " + posizioneNuovaRiga + " " + "Colonna "
										+ posizioneNuovaColonna;

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
						int posizioneNuovaRiga = --tempRiga;
						char posizioneNuovaColonna = (char) (++tempColonna);
						if (posizioneNuovaRiga >= 1 && posizioneNuovaColonna >= 'A') {
							PezzoService temp = table.get(posizioneNuovaRiga, posizioneNuovaColonna);
							if (temp != null) {
								if (temp.getNome().charAt(2) == 'B') {
									String posizione = "Riga: " + posizioneNuovaRiga + " " + "Colonna "
											+ posizioneNuovaColonna;
									mosseValide.add(posizione);
									trovato = true;
								} else {

									trovato = true;
								}
							} else {
								String posizione = "Riga: " + posizioneNuovaRiga + " " + "Colonna "
										+ posizioneNuovaColonna;
								mosseValide.add(posizione);

							}

						} else {
							trovato = true;
						}
					}
				}

				if (this.getNome().equals("AN1") || this.getNome().equals("AN2")) {
					boolean trovato = false;
					int tempRiga = posizionePezzoRiga;
					char tempColonna = posizionePezzoColonna;

					while (tempRiga >= 1 && tempColonna >= 'A' && trovato == false) {

						int posizioneNuovaRiga = --tempRiga;
						char posizioneNuovaColonna = (char) (--tempColonna);
						if (posizioneNuovaRiga >= 1 && posizioneNuovaColonna >= 'A') {
							PezzoService temp = table.get(posizioneNuovaRiga, posizioneNuovaColonna);
							if (temp != null) {
								if (temp.getNome().charAt(2) == 'B') {
									String posizione = "Riga: " + posizioneNuovaRiga + " " + "Colonna "
											+ posizioneNuovaColonna;
									mosseValide.add(posizione);
									trovato = true;
								} else {
									trovato = true;

								}
							} else {
								// Debug
								String posizione = "Riga: " + posizioneNuovaRiga + " " + "Colonna "
										+ posizioneNuovaColonna;
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
						int posizioneNuovaRiga = ++tempRiga;
						char posizioneNuovaColonna = (char) (--tempColonna);
						if (posizioneNuovaRiga <= 8 && posizioneNuovaColonna >= 'A') {
							PezzoService temp = table.get(posizioneNuovaRiga, posizioneNuovaColonna);
							if (temp != null) {
								if (temp.getNome().charAt(2) == 'B') {
									String posizione = "Riga: " + posizioneNuovaRiga + " " + "Colonna "
											+ posizioneNuovaColonna;
									mosseValide.add(posizione);
									trovato = true;
								} else {

									trovato = true;
								}
							} else {
								String posizione = "Riga: " + posizioneNuovaRiga + " " + "Colonna "
										+ posizioneNuovaColonna;
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
						int posizioneNuovaRiga = --tempRiga;
						char posizioneNuovaColonna = (char) (++tempColonna);
						if (posizioneNuovaRiga >= 1 && posizioneNuovaColonna <= 'H') {
							PezzoService temp = table.get(posizioneNuovaRiga, posizioneNuovaColonna);
							if (temp != null) {
								System.out.println(temp.toString());
								if (temp.getNome().charAt(2) == 'B') {
									String posizione = "Riga: " + posizioneNuovaRiga + " " + "Colonna "
											+ posizioneNuovaColonna;
									mosseValide.add(posizione);
									trovato = true;
								} else {
									System.out.println(temp.getNome());

									trovato = true;

								}
							} else {
								String posizione = "Riga: " + posizioneNuovaRiga + " " + "Colonna "
										+ posizioneNuovaColonna;

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
						int posizioneNuovaRiga = ++tempRiga;
						char posizioneNuovaColonna = (char) (++tempColonna);
						if (posizioneNuovaRiga <= 8 && posizioneNuovaColonna >= 'A') {
							PezzoService temp = table.get(posizioneNuovaRiga, posizioneNuovaColonna);
							if (temp != null) {
								if (temp.getNome().charAt(2) == 'B') {
									String posizione = "Riga: " + posizioneNuovaRiga + " " + "Colonna "
											+ posizioneNuovaColonna;
									mosseValide.add(posizione);
									trovato = true;
								} else {

									trovato = true;
								}
							} else {
								String posizione = "Riga: " + posizioneNuovaRiga + " " + "Colonna "
										+ posizioneNuovaColonna;
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
	public void muovi(PezzoModel pezzo, HashBasedTable<Integer, Integer, PezzoModel> scacchiera) {
		// TODO Auto-generated method stub
		
	}

}
