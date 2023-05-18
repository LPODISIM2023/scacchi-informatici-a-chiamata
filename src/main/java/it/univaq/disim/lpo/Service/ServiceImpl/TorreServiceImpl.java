package it.univaq.disim.lpo.Service.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import it.univaq.disim.lpo.Model.PezzoModel;
import it.univaq.disim.lpo.Model.ScacchieraModel;
import it.univaq.disim.lpo.Model.TorreModel;
import it.univaq.disim.lpo.Service.PezzoService;

public class TorreServiceImpl extends TorreModel implements PezzoService {

	public TorreServiceImpl(String nome, boolean isAlive) {
		super(nome, isAlive);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<String> mosseValide(ScacchieraModel scacchiera) {

		List<String> mosseValide = new ArrayList<>();
		try {
			Table<Integer, Character, PezzoService> table = scacchiera.getScacchiera();
			if (this != null) {
				Integer posizionePezzoRiga = scacchiera.getRigaPezzoFromScacchiera(this.getNome());
				Character posizionePezzoColonna = scacchiera.getColonnaPezzoFromScacchiera(this.getNome());

				if (this.getNome().equals("TB1") || this.getNome().equals("TB2")) {
					boolean trovato = false;
					int tempRiga = posizionePezzoRiga;
					char tempColonna = posizionePezzoColonna;
///  SEZIONE MOVIMENTI VERTICALI E ORIZZONTALI
					while (tempRiga <= 8 && trovato == false) {
						int posizioneNuovaRiga = ++tempRiga;
					//	char posizioneNuovaColonna = (char) (++tempColonna);
						if (posizioneNuovaRiga <= 8) {
							PezzoService temp = table.get(posizioneNuovaRiga, tempColonna);
							if (temp != null) {
								if (temp.getNome().charAt(2) == 'N') {
									String posizione = "Riga: " + posizioneNuovaRiga + " " + "Colonna "
											+ tempColonna;
									mosseValide.add(posizione);
									trovato = true;
								} else {

									trovato = true;
								}
							} else {
								String posizione = "Riga: " + posizioneNuovaRiga + " " + "Colonna "
										+ tempColonna;
								mosseValide.add(posizione);

							}
							
						} else {
							trovato = true;
						}
					}
					tempRiga = posizionePezzoRiga;
					tempColonna = posizionePezzoColonna;
					trovato = false;
					
					while (tempRiga >= 1 && trovato == false) {
						int posizioneNuovaRiga = --tempRiga;
					//	char posizioneNuovaColonna = (char) (++tempColonna);
						if (posizioneNuovaRiga >= 8) {
							PezzoService temp = table.get(posizioneNuovaRiga, tempColonna);
							if (temp != null) {
								if (temp.getNome().charAt(2) == 'N') {
									String posizione = "Riga: " + posizioneNuovaRiga + " " + "Colonna "
											+ tempColonna;
									mosseValide.add(posizione);
									trovato = true;
								} else {

									trovato = true;
								}
							} else {
								String posizione = "Riga: " + posizioneNuovaRiga + " " + "Colonna "
										+ tempColonna;
								mosseValide.add(posizione);

							}
							
						} else {
							trovato = true;
						}
					}
					tempRiga = posizionePezzoRiga;
					tempColonna = posizionePezzoColonna;
					trovato = false;
					while (tempColonna <= 'H' && trovato == false) {
					//	int posizioneNuovaRiga = --tempRiga;
						char posizioneNuovaColonna = (char) (++tempColonna);
						if (posizioneNuovaColonna <= 'H') {
							PezzoService temp = table.get(tempRiga, posizioneNuovaColonna);
							if (temp != null) {
								if (temp.getNome().charAt(2) == 'N') {
									String posizione = "Riga: " + tempRiga + " " + "Colonna "
											+ posizioneNuovaColonna;
									mosseValide.add(posizione);
									trovato = true;
								} else {

									trovato = true;
								}
							} else {
								String posizione = "Riga: " + tempRiga + " " + "Colonna "
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
					while (tempColonna <= 'H' && trovato == false) {
					//	int posizioneNuovaRiga = --tempRiga;
						char posizioneNuovaColonna = (char) (--tempColonna);
						if (posizioneNuovaColonna >= 'A') {
							PezzoService temp = table.get(tempRiga, posizioneNuovaColonna);
							if (temp != null) {
								if (temp.getNome().charAt(2) == 'N') {
									String posizione = "Riga: " + tempRiga + " " + "Colonna "
											+ posizioneNuovaColonna;
									mosseValide.add(posizione);
									trovato = true;
								} else {

									trovato = true;
								}
							} else {
								String posizione = "Riga: " + tempRiga + " " + "Colonna "
										+ posizioneNuovaColonna;
								mosseValide.add(posizione);

							}
							
						} else {
							trovato = true;
						}
					}
				}

				if (this.getNome().equals("TN1") || this.getNome().equals("TN2")) {
					boolean trovato = false;
					int tempRiga = posizionePezzoRiga;
					char tempColonna = posizionePezzoColonna;
					while (tempRiga <= 8 && tempColonna <= 'H' && trovato == false) {
						int posizioneNuovaRiga = ++tempRiga;
					//	char posizioneNuovaColonna = (char) (++tempColonna);
						if (posizioneNuovaRiga <= 8) {
							PezzoService temp = table.get(posizioneNuovaRiga, tempColonna);
							if (temp != null) {
								if (temp.getNome().charAt(2) == 'B') {
									String posizione = "Riga: " + posizioneNuovaRiga + " " + "Colonna "
											+ tempColonna;
									mosseValide.add(posizione);
									trovato = true;
								} else {

									trovato = true;
								}
							} else {
								String posizione = "Riga: " + posizioneNuovaRiga + " " + "Colonna "
										+ tempColonna;
								mosseValide.add(posizione);

							}
							
						} else {
							trovato = true;
						}

						
					}
					
					tempRiga = posizionePezzoRiga;
					tempColonna = posizionePezzoColonna;
					trovato = false;
					while (tempRiga >= 1 && trovato == false) {
						int posizioneNuovaRiga = --tempRiga;
					//	char posizioneNuovaColonna = (char) (++tempColonna);
						if (posizioneNuovaRiga >= 1) {
							PezzoService temp = table.get(posizioneNuovaRiga, tempColonna);
							if (temp != null) {
								if (temp.getNome().charAt(2) == 'B') {
									String posizione = "Riga: " + posizioneNuovaRiga + " " + "Colonna "
											+ tempColonna;
									mosseValide.add(posizione);
									trovato = true;
								} else {

									trovato = true;
								}
							} else {
								String posizione = "Riga: " + posizioneNuovaRiga + " " + "Colonna "
										+ tempColonna;
								mosseValide.add(posizione);

							}
							
						} else {
							trovato = true;
						}
					}
					tempRiga = posizionePezzoRiga;
					tempColonna = posizionePezzoColonna;
					trovato = false;
					
					while (tempRiga >= 1 && trovato == false) {
					//	int posizioneNuovaRiga = --tempRiga;
						char posizioneNuovaColonna = (char) (--tempColonna);
						if (posizioneNuovaColonna >= 'A') {
							PezzoService temp = table.get(tempRiga, posizioneNuovaColonna);
							if (temp != null) {
								if (temp.getNome().charAt(2) == 'B') {
									String posizione = "Riga: " + tempRiga + " " + "Colonna "
											+ tempColonna;
									mosseValide.add(posizione);
									trovato = true;
								} else {

									trovato = true;
								}
							} else {
								String posizione = "Riga: " + tempRiga + " " + "Colonna "
										+ tempColonna;
								mosseValide.add(posizione);

							}
							
						} else {
							trovato = true;
						}
					}
					tempRiga = posizionePezzoRiga;
					tempColonna = posizionePezzoColonna;
					trovato = false;
					while (tempColonna <= 'H' && trovato == false) {
					//	int posizioneNuovaRiga = --tempRiga;
						char posizioneNuovaColonna = (char) (++tempColonna);
						if (posizioneNuovaColonna <= 'H') {
							PezzoService temp = table.get(tempRiga, posizioneNuovaColonna);
							if (temp != null) {
								if (temp.getNome().charAt(2) == 'B') {
									String posizione = "Riga: " + tempRiga + " " + "Colonna "
											+ posizioneNuovaColonna;
									mosseValide.add(posizione);
									trovato = true;
								} else {

									trovato = true;
								}
							} else {
								String posizione = "Riga: " + tempRiga + " " + "Colonna "
										+ posizioneNuovaColonna;
								mosseValide.add(posizione);

							}
							
						} else {
							trovato = true;
						}
					}

				}

			}

			
		}catch(

	NullPointerException e)
	{
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
