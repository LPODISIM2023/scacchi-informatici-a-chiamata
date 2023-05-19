package it.univaq.disim.lpo.Service.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import it.univaq.disim.lpo.Model.PezzoModel;
import it.univaq.disim.lpo.Model.ScacchieraModel;

public class CavalloServiceImpl extends PezzoModel {

	public CavalloServiceImpl(String nome, boolean isAlive) {
		super(nome, isAlive);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<String> mosseValide(ScacchieraModel scacchiera) {
		List<String> mosseValide = new ArrayList<>();
		try {
			Table<Integer, Character, PezzoModel> table = scacchiera.getScacchiera();
			if (this != null) {
				Integer posizionePezzoRiga = scacchiera.getRigaPezzoFromScacchiera(this.getNome());
				Character posizionePezzoColonna = scacchiera.getColonnaPezzoFromScacchiera(this.getNome());

				if (this.getNome().equals("CB1") || this.getNome().equals("CB2")) {
					boolean trovato = false;
					int tempRiga = posizionePezzoRiga;
					char tempColonna = posizionePezzoColonna;

					// CONSIDERIAMO LO SPOSTAMENTO IN AVANTI DI 2 CASELLE VERTICALI E UNA
					// ORIZZONTALE
					// Bianchi:
					while (trovato == false) {
						int posizioneNuovaRiga = tempRiga + 2;
						char posizioneNuovaColonna = ++tempColonna;
						if (posizioneNuovaRiga <= 8 && posizioneNuovaColonna <= 'H') {
							if (table.get(posizioneNuovaRiga, posizioneNuovaColonna) != null) {
								PezzoModel temp = table.get(posizioneNuovaRiga, posizioneNuovaColonna);
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
								trovato = true;
							}

						} else {
							trovato = true;
						}
					}
					tempRiga = posizionePezzoRiga;
					tempColonna = posizionePezzoColonna;
					trovato = false;
					while (trovato == false) {
						int posizioneNuovaRiga = tempRiga + 2;
						char posizioneNuovaColonna = --tempColonna;
						if (posizioneNuovaRiga <= 8 && posizioneNuovaColonna >= 'A') {
							if (table.get(posizioneNuovaRiga, posizioneNuovaColonna) != null) {
								PezzoModel temp = table.get(posizioneNuovaRiga, posizioneNuovaColonna);
								if (temp.getNome().charAt(2) == 'N') {
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
								trovato = true;

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
						char posizioneNuovaColonna = (char) (tempColonna + 2);

						if (posizioneNuovaRiga <= 8 && posizioneNuovaColonna <= 'H') {
							if (table.get(posizioneNuovaRiga, posizioneNuovaColonna) != null) {
								PezzoModel temp = table.get(posizioneNuovaRiga, posizioneNuovaColonna);
								if (temp.getNome().charAt(2) == 'N') {
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
								trovato = true;

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
						char posizioneNuovaColonna = (char) (tempColonna - 2);

						if (posizioneNuovaRiga <= 8 && posizioneNuovaColonna >= 'A') {

							if (table.get(posizioneNuovaRiga, posizioneNuovaColonna) != null) {
								PezzoModel temp = table.get(posizioneNuovaRiga, posizioneNuovaColonna);
								if (temp.getNome().charAt(2) == 'N') {
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
								trovato = true;

							}

						} else {
							trovato = true;

						}
					}
					tempRiga = posizionePezzoRiga;
					tempColonna = posizionePezzoColonna;
					trovato = false;
					while (trovato == false) {
						int posizioneNuovaRiga = tempRiga - 2;
						char posizioneNuovaColonna = --tempColonna;
						if (posizioneNuovaRiga >= 1 && posizioneNuovaColonna >= 'A') {
							if (table.get(posizioneNuovaRiga, posizioneNuovaColonna) != null) {
								PezzoModel temp = table.get(posizioneNuovaRiga, posizioneNuovaColonna);
								if (temp.getNome().charAt(2) == 'N') {
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
								trovato = true;

							}

						} else {
							trovato = true;
						}
					}
					tempRiga = posizionePezzoRiga;
					tempColonna = posizionePezzoColonna;
					trovato = false;
					while (trovato == false) {
						int posizioneNuovaRiga = tempRiga - 2;
						char posizioneNuovaColonna = ++tempColonna;
						if (posizioneNuovaRiga >= 1 && posizioneNuovaColonna <= 'H') {
							if (table.get(posizioneNuovaRiga, posizioneNuovaColonna) != null) {
								PezzoModel temp = table.get(posizioneNuovaRiga, posizioneNuovaColonna);
								if (temp.getNome().charAt(2) == 'N') {
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
								trovato = true;

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
						char posizioneNuovaColonna = (char) (tempColonna + 2);

						if (posizioneNuovaRiga >= 1 && posizioneNuovaColonna <= 'H') {

							if (table.get(posizioneNuovaRiga, posizioneNuovaColonna) != null) {
								PezzoModel temp = table.get(posizioneNuovaRiga, posizioneNuovaColonna);
								if (temp.getNome().charAt(2) == 'N') {
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
								trovato = true;

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
						char posizioneNuovaColonna = (char) (tempColonna - 2);

						if (posizioneNuovaRiga >= 8 && posizioneNuovaColonna >= 'A') {

							if (table.get(posizioneNuovaRiga, posizioneNuovaColonna) != null) {
								PezzoModel temp = table.get(posizioneNuovaRiga, posizioneNuovaColonna);
								if (temp.getNome().charAt(2) == 'N') {
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
								trovato = true;

							}

						} else {
							trovato = true;

						}
					}

				}
				// Neri:
				if (this.getNome().equals("CN1") || this.getNome().equals("CN2")) {
					boolean trovato = false;
					int tempRiga = posizionePezzoRiga;
					char tempColonna = posizionePezzoColonna;

					// CONSIDERIAMO LO SPOSTAMENTO IN AVANTI DI 2 CASELLE VERTICALI E UNA
					// ORIZZONTALE
					// Bianchi:
					while (trovato == false) {
						int posizioneNuovaRiga = tempRiga - 2;

						char posizioneNuovaColonna = ++tempColonna;

						if (posizioneNuovaRiga >= 1 && posizioneNuovaColonna <= 'H') {
							if (table.get(posizioneNuovaRiga, posizioneNuovaColonna) != null) {
								PezzoModel temp = table.get(posizioneNuovaRiga, posizioneNuovaColonna);
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
								trovato = true;
							}

						} else {
							trovato = true;
						}
					}
					tempRiga = posizionePezzoRiga;
					tempColonna = posizionePezzoColonna;
					trovato = false;
					while (trovato == false) {
						int posizioneNuovaRiga = tempRiga - 2;
						char posizioneNuovaColonna = --tempColonna;
						if (posizioneNuovaRiga >= 1 && posizioneNuovaColonna >= 'A') {
							if (table.get(posizioneNuovaRiga, posizioneNuovaColonna) != null) {
								PezzoModel temp = table.get(posizioneNuovaRiga, posizioneNuovaColonna);
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
								trovato = true;

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
						char posizioneNuovaColonna = (char) (tempColonna + 2);

						if (posizioneNuovaRiga >= 1 && posizioneNuovaColonna <= 'H') {
							if (table.get(posizioneNuovaRiga, posizioneNuovaColonna) != null) {
								PezzoModel temp = table.get(posizioneNuovaRiga, posizioneNuovaColonna);
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
								trovato = true;

							}

						} else {
							trovato = true;
						}

					}
					tempRiga = posizionePezzoRiga;
					tempColonna = posizionePezzoColonna;
					trovato = false;
					while (trovato == false) {
						int posizioneNuovaRiga = tempRiga--;
						char posizioneNuovaColonna = (char) (tempColonna - 2);
						System.out.println(posizioneNuovaColonna);
						if (posizioneNuovaRiga >= 1 && posizioneNuovaColonna >= 'A') {

							if (table.get(posizioneNuovaRiga, posizioneNuovaColonna) != null) {
								PezzoModel temp = table.get(posizioneNuovaRiga, posizioneNuovaColonna);
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
								trovato = true;

							}

						} else {
							trovato = true;

						}
					}
					tempRiga = posizionePezzoRiga;
					tempColonna = posizionePezzoColonna;
					trovato = false;
					while (trovato == false) {
						int posizioneNuovaRiga = tempRiga + 2;
						char posizioneNuovaColonna = --tempColonna;
						if (posizioneNuovaRiga <= 8 && posizioneNuovaColonna >= 'A') {
							if (table.get(posizioneNuovaRiga, posizioneNuovaColonna) != null) {
								PezzoModel temp = table.get(posizioneNuovaRiga, posizioneNuovaColonna);
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
								trovato = true;

							}

						} else {
							trovato = true;
						}
					}
					tempRiga = posizionePezzoRiga;
					tempColonna = posizionePezzoColonna;
					trovato = false;
					while (trovato == false) {
						int posizioneNuovaRiga = tempRiga + 2;
						char posizioneNuovaColonna = ++tempColonna;
						if (posizioneNuovaRiga <= 8 && posizioneNuovaColonna >= 'H') {
							if (table.get(posizioneNuovaRiga, posizioneNuovaColonna) != null) {
								PezzoModel temp = table.get(posizioneNuovaRiga, posizioneNuovaColonna);
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
								trovato = true;

							}

						} else {
							trovato = true;
						}
					}
					tempRiga = posizionePezzoRiga;
					tempColonna = posizionePezzoColonna;
					trovato = false;
					while (trovato == false) {
						int posizioneNuovaRiga = tempRiga + 1;
						char posizioneNuovaColonna =(char)(tempColonna - 2);
						if (posizioneNuovaRiga <= 8 && posizioneNuovaColonna >= 'A') {
							if (table.get(posizioneNuovaRiga, posizioneNuovaColonna) != null) {
								PezzoModel temp = table.get(posizioneNuovaRiga, posizioneNuovaColonna);
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
								trovato = true;

							}

						} else {
							trovato = true;
						}
					}
					tempRiga = posizionePezzoRiga;
					tempColonna = posizionePezzoColonna;
					trovato = false;
					while (trovato == false) {
						int posizioneNuovaRiga = tempRiga + 1;
						char posizioneNuovaColonna = (char)(tempColonna+2);
						if (posizioneNuovaRiga <= 8 && posizioneNuovaColonna <= 'H') {
							if (table.get(posizioneNuovaRiga, posizioneNuovaColonna) != null) {
								PezzoModel temp = table.get(posizioneNuovaRiga, posizioneNuovaColonna);
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



	@Override
	public void muovi(PezzoModel pezzo, HashBasedTable<Integer, Integer, PezzoModel> scacchiera, String posizione) {
		// TODO Auto-generated method stub
		
	}

}
