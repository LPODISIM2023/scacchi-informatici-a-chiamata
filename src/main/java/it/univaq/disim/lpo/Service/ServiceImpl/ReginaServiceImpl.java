package it.univaq.disim.lpo.Service.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.Table;

import it.univaq.disim.lpo.Model.PezzoModel;
import it.univaq.disim.lpo.Model.ScacchieraModel;

public class ReginaServiceImpl extends PezzoModel {

	public ReginaServiceImpl(String nome, boolean isAlive) {
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

				if (this.getNome().equals("rB1")) {
					boolean trovato = false;
					int tempRiga = posizionePezzoRiga;
					char tempColonna = posizionePezzoColonna;
///// MOVIMENTI DIAGONALI		
					while (trovato == false) {

						int posizioneNuovaRiga = ++tempRiga;
						char posizioneNuovaColonna = (char) (--tempColonna);
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
					while ( trovato == false) {
						int posizioneNuovaRiga = --tempRiga;
						char posizioneNuovaColonna = (char) (--tempColonna);
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
						int posizioneNuovaRiga = ++tempRiga;
						char posizioneNuovaColonna = (char) (++tempColonna);
						if (posizioneNuovaRiga <= 8 && posizioneNuovaColonna <= 'H') {
							PezzoModel temp = table.get(posizioneNuovaRiga, posizioneNuovaColonna);
							if (temp != null) {
								System.out.println(temp.toString());
								if (temp.getNome().charAt(1) == 'N') {
									String posizione = posizioneNuovaColonna + "" + posizioneNuovaRiga;
									mosseValide.add(posizione);
									trovato = true;
								} else {
									System.out.println(temp.getNome());

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
						int posizioneNuovaRiga = --tempRiga;
						char posizioneNuovaColonna = (char) (++tempColonna);
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
//// FINE SEZIONE MOVIMENTI DIAGONALI BIANCHI
					}
///  SEZIONE MOVIMENTI VERTICALI E ORIZZONTALI
					tempRiga = posizionePezzoRiga;
					tempColonna = posizionePezzoColonna;
					trovato = false;
					while (tempRiga <= 8 && trovato == false) {
						int posizioneNuovaRiga = ++tempRiga;
					//	char posizioneNuovaColonna = (char) (++tempColonna);
						if (posizioneNuovaRiga <= 8) {
							PezzoModel temp = table.get(posizioneNuovaRiga, tempColonna);
							if (temp != null) {
								if (temp.getNome().charAt(1) == 'N') {
									String posizione = tempColonna + "" + posizioneNuovaRiga;
									mosseValide.add(posizione);
									trovato = true;
								} else {

									trovato = true;
								}
							} else {
								String posizione = tempColonna + "" + posizioneNuovaRiga;
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
							PezzoModel temp = table.get(posizioneNuovaRiga, tempColonna);
							if (temp != null) {
								if (temp.getNome().charAt(1) == 'N') {
									String posizione = tempColonna + "" + posizioneNuovaRiga;
									mosseValide.add(posizione);
									trovato = true;
								} else {

									trovato = true;
								}
							} else {
								String posizione = tempColonna + "" + posizioneNuovaRiga;
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
							PezzoModel temp = table.get(tempRiga, posizioneNuovaColonna);
							if (temp != null) {
								if (temp.getNome().charAt(1) == 'N') {
									String posizione = posizioneNuovaColonna + "" + tempRiga;
									mosseValide.add(posizione);
									trovato = true;
								} else {

									trovato = true;
								}
							} else {
								String posizione = posizioneNuovaColonna + "" + tempRiga;
								mosseValide.add(posizione);

							}
							
						} else {
							trovato = true;
						}
					}
				}
			
				}

			return mosseValide;
			}catch(NullPointerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

		}
		return null;
	}
	

	public List<String> mosseValideN(ScacchieraModel scacchiera) {
		List<String> mosseValide = new ArrayList<>();
		Table<Integer, Character, PezzoModel> table = scacchiera.getScacchiera();
		
		try {
			if (this != null) {
				Integer posizionePezzoRiga = scacchiera.getRigaPezzoFromScacchiera(this.getNome());
				Character posizionePezzoColonna = scacchiera.getColonnaPezzoFromScacchiera(this.getNome());
				if (this.getNome().equals("rN1")) {
					boolean trovato = false;
					int tempRiga = posizionePezzoRiga;
					char tempColonna = posizionePezzoColonna;
//// SEZIONE MOVIMENTI DIAGONALI NERO
					while (tempRiga >= 1 && tempColonna >= 'A' && trovato == false) {

						int posizioneNuovaRiga = --tempRiga;
						char posizioneNuovaColonna = (char) (--tempColonna);
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
						int posizioneNuovaRiga = ++tempRiga;
						char posizioneNuovaColonna = (char) (--tempColonna);
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
						int posizioneNuovaRiga = --tempRiga;
						char posizioneNuovaColonna = (char) (++tempColonna);
						if (posizioneNuovaRiga >= 1 && posizioneNuovaColonna <= 'H') {
							PezzoModel temp = table.get(posizioneNuovaRiga, posizioneNuovaColonna);
							if (temp != null) {
								System.out.println(temp.toString());
								if (temp.getNome().charAt(1) == 'B') {
									String posizione = posizioneNuovaColonna + "" + posizioneNuovaRiga;
									mosseValide.add(posizione);
									trovato = true;
								} else {
									System.out.println(temp.getNome());

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
						int posizioneNuovaRiga = ++tempRiga;
						char posizioneNuovaColonna = (char) (++tempColonna);
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
//// FINE SEZIONE MOVIMENTI DIAGONALI NERI

					}

//// SEZIONE MOVIMENTI VERTICALI E ORIZZONTALI
					tempRiga = posizionePezzoRiga;
					tempColonna = posizionePezzoColonna;
					trovato = false;
					while (tempRiga <= 8 && tempColonna <= 'H' && trovato == false) {
						int posizioneNuovaRiga = ++tempRiga;
						// char posizioneNuovaColonna = (char) (++tempColonna);
						if (posizioneNuovaRiga <= 8) {
							PezzoModel temp = table.get(posizioneNuovaRiga, tempColonna);
							if (temp != null) {
								if (temp.getNome().charAt(1) == 'B') {
									String posizione = tempColonna + "" + posizioneNuovaRiga;
									mosseValide.add(posizione);
									trovato = true;
								} else {

									trovato = true;
								}
							} else {

								String posizione = tempColonna + "" + posizioneNuovaRiga;
								mosseValide.add(posizione);

							}

						} else {
							trovato = true;
						}

					}
					/// MOVIMENTI VERTICALI E ORIZZONTALI
					tempRiga = posizionePezzoRiga;
					tempColonna = posizionePezzoColonna;
					trovato = false;
					while (tempRiga >= 1 && trovato == false) {
						int posizioneNuovaRiga = --tempRiga;
						// char posizioneNuovaColonna = (char) (++tempColonna);
						if (posizioneNuovaRiga >= 1) {
							PezzoModel temp = table.get(posizioneNuovaRiga, tempColonna);
							if (temp != null) {
								if (temp.getNome().charAt(1) == 'B') {

									String posizione = tempColonna + "" + posizioneNuovaRiga;
									mosseValide.add(posizione);
									trovato = true;
								} else {

									trovato = true;
								}
							} else {

								String posizione = tempColonna + "" + posizioneNuovaRiga;
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
						// char posizioneNuovaColonna = (char) (++tempColonna);
						if (posizioneNuovaRiga >= 8) {
							PezzoModel temp = table.get(posizioneNuovaRiga, tempColonna);
							if (temp != null) {
								if (temp.getNome().charAt(1) == 'B') {
									String posizione = "Riga: " + posizioneNuovaRiga + " " + "Colonna " + tempColonna;
									mosseValide.add(posizione);
									trovato = true;
								} else {

									trovato = true;
								}
							} else {
								String posizione = "Riga: " + posizioneNuovaRiga + " " + "Colonna " + tempColonna;
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
						// int posizioneNuovaRiga = --tempRiga;
						char posizioneNuovaColonna = (char) (++tempColonna);
						if (posizioneNuovaColonna <= 'H') {
							PezzoModel temp = table.get(tempRiga, posizioneNuovaColonna);
							if (temp != null) {
								if (temp.getNome().charAt(1) == 'B') {
									String posizione = posizioneNuovaColonna + "" + tempRiga;
									mosseValide.add(posizione);
									trovato = true;
								} else {

									trovato = true;
								}
							} else {
								String posizione = posizioneNuovaColonna + "" + tempRiga;

								mosseValide.add(posizione);

							}

						} else {
							trovato = true;
						}
					}

				}

			}

		} catch (

		NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return mosseValide;
	}



}
