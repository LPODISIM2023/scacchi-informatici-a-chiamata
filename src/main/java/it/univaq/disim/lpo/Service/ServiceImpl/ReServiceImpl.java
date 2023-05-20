package it.univaq.disim.lpo.Service.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.Table;

import it.univaq.disim.lpo.Model.PezzoModel;
import it.univaq.disim.lpo.Model.ScacchieraModel;

public class ReServiceImpl extends PezzoModel {

	public ReServiceImpl(String nome, boolean isAlive) {
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

				if (this.getNome().equals("RB1")) {
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
									String posizione =posizioneNuovaColonna  + "" + posizioneNuovaRiga;									mosseValide.add(posizione);
									trovato = true;
								} else {
									trovato = true;

								}
							} else {
								// Debug
								String posizione =posizioneNuovaColonna  + "" + posizioneNuovaRiga;								mosseValide.add(posizione);
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
						char posizioneNuovaColonna = (char) (--tempColonna);
						if (posizioneNuovaRiga >= 1 && posizioneNuovaColonna >= 'A') {
							PezzoModel temp = table.get(posizioneNuovaRiga, posizioneNuovaColonna);
							if (temp != null) {
								if (temp.getNome().charAt(1) == 'N') {
									String posizione =posizioneNuovaColonna  + "" + posizioneNuovaRiga;
									mosseValide.add(posizione);
									trovato = true;
								} else {

									trovato = true;
								}
							} else {
								String posizione =posizioneNuovaColonna  + "" + posizioneNuovaRiga;
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
									String posizione =posizioneNuovaColonna  + "" + posizioneNuovaRiga;
									mosseValide.add(posizione);
									trovato = true;
								} else {
									System.out.println(temp.getNome());

									trovato = true;

								}
							} else {
								String posizione =posizioneNuovaColonna  + "" + posizioneNuovaRiga;


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
					while (tempRiga >= 1 && tempColonna <= 'H' && trovato == false) {
						int posizioneNuovaRiga = --tempRiga;
						char posizioneNuovaColonna = (char) (++tempColonna);
						if (posizioneNuovaRiga >= 1 && posizioneNuovaColonna >= 'A') {
							PezzoModel temp = table.get(posizioneNuovaRiga, posizioneNuovaColonna);
							if (temp != null) {
								if (temp.getNome().charAt(1) == 'N') {
									String posizione =posizioneNuovaColonna  + "" + posizioneNuovaRiga;

									mosseValide.add(posizione);
									trovato = true;
								} else {

									trovato = true;
								}
							} else {
								String posizione =posizioneNuovaColonna  + "" + posizioneNuovaRiga;

								mosseValide.add(posizione);
								trovato = true;

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
						// char posizioneNuovaColonna = (char) (++tempColonna);
						if (posizioneNuovaRiga <= 8) {
							PezzoModel temp = table.get(posizioneNuovaRiga, tempColonna);
							if (temp != null) {
								if (temp.getNome().charAt(1) == 'N') {
									String posizione =  tempColonna + "" + posizioneNuovaRiga;
									mosseValide.add(posizione);
									trovato = true;
								} else {

									trovato = true;
								}
							} else {
								String posizione =  tempColonna + "" + posizioneNuovaRiga;
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

					while (tempRiga >= 1 && trovato == false) {
						int posizioneNuovaRiga = --tempRiga;
						// char posizioneNuovaColonna = (char) (++tempColonna);
						if (posizioneNuovaRiga >= 8) {
							PezzoModel temp = table.get(posizioneNuovaRiga, tempColonna);
							if (temp != null) {
								if (temp.getNome().charAt(1) == 'N') {
									String posizione =  tempColonna + "" + posizioneNuovaRiga;
									mosseValide.add(posizione);
									trovato = true;
								} else {

									trovato = true;
								}
							} else {
								String posizione =  tempColonna + "" + posizioneNuovaRiga;
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
					while (tempColonna <= 'H' && trovato == false) {
						// int posizioneNuovaRiga = --tempRiga;
						char posizioneNuovaColonna = (char) (++tempColonna);
						if (posizioneNuovaColonna <= 'H') {
							PezzoModel temp = table.get(tempRiga, posizioneNuovaColonna);
							if (temp != null) {
								if (temp.getNome().charAt(1) == 'N') {
									String posizione =  posizioneNuovaColonna  + "" + tempRiga;
									mosseValide.add(posizione);
									trovato = true;
								} else {

									trovato = true;
								}
							} else {
								String posizione =  posizioneNuovaColonna  + "" + tempRiga;
								mosseValide.add(posizione);
								trovato = true;
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

		for (String s : mosseValide) {
			if (scaccoN(scacchiera, s) == true) {
				mosseValide.remove(s);
			}

		}
		return mosseValide;
	}

	@Override
	public List<String> mosseValideN(ScacchieraModel scacchiera) {
		List<String> mosseValide = new ArrayList<>();
		Table<Integer, Character, PezzoModel> table = scacchiera.getScacchiera();

		try {
			if (this != null) {
				Integer posizionePezzoRiga = scacchiera.getRigaPezzoFromScacchiera(this.getNome());
				Character posizionePezzoColonna = scacchiera.getColonnaPezzoFromScacchiera(this.getNome());

				if (this.getNome().equals("RN1")) {
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
									String posizione = posizioneNuovaColonna +""+ posizioneNuovaRiga;
								
									mosseValide.add(posizione);
									trovato = true;
								} else {
									trovato = true;

								}
							} else {
								// Debug
								String posizione = posizioneNuovaColonna +""+ posizioneNuovaRiga;
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
					while (tempRiga <= 8 && tempColonna >= 'A' && trovato == false) {
						int posizioneNuovaRiga = ++tempRiga;
						char posizioneNuovaColonna = (char) (--tempColonna);
						if (posizioneNuovaRiga <= 8 && posizioneNuovaColonna >= 'A') {
							PezzoModel temp = table.get(posizioneNuovaRiga, posizioneNuovaColonna);
							if (temp != null) {
								if (temp.getNome().charAt(1) == 'B') {
									String posizione = posizioneNuovaColonna +""+ posizioneNuovaRiga;

									mosseValide.add(posizione);
									trovato = true;
								} else {

									trovato = true;
								}
							} else {
								String posizione = posizioneNuovaColonna +""+ posizioneNuovaRiga;

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
					while (tempRiga >= 1 && tempColonna >= 'A' && trovato == false) {
						int posizioneNuovaRiga = --tempRiga;
						char posizioneNuovaColonna = (char) (++tempColonna);
						if (posizioneNuovaRiga >= 1 && posizioneNuovaColonna <= 'H') {
							PezzoModel temp = table.get(posizioneNuovaRiga, posizioneNuovaColonna);
							if (temp != null) {
								System.out.println(temp.toString());
								if (temp.getNome().charAt(1) == 'B') {
									String posizione = posizioneNuovaColonna +""+ posizioneNuovaRiga;

									mosseValide.add(posizione);
									trovato = true;
								} else {
									System.out.println(temp.getNome());

									trovato = true;

								}
							} else {
								String posizione = posizioneNuovaColonna +""+ posizioneNuovaRiga;


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
					while (tempRiga <= 8 && tempColonna <= 'H' && trovato == false) {
						int posizioneNuovaRiga = ++tempRiga;
						char posizioneNuovaColonna = (char) (++tempColonna);
						if (posizioneNuovaRiga <= 8 && posizioneNuovaColonna >= 'A') {
							PezzoModel temp = table.get(posizioneNuovaRiga, posizioneNuovaColonna);
							if (temp != null) {
								if (temp.getNome().charAt(1) == 'B') {
									String posizione = posizioneNuovaColonna +""+ posizioneNuovaRiga;

									mosseValide.add(posizione);
									trovato = true;
								} else {

									trovato = true;
								}
							} else {
								String posizione = posizioneNuovaColonna +""+ posizioneNuovaRiga;

								mosseValide.add(posizione);
								trovato = true;

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
									String posizione =tempColonna  +""+ posizioneNuovaRiga;
									mosseValide.add(posizione);
									trovato = true;
								} else {

									trovato = true;
								}
							} else {
								String posizione =tempColonna  +""+ posizioneNuovaRiga;
								mosseValide.add(posizione);
								trovato = true;

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
									String posizione =tempColonna  +""+ posizioneNuovaRiga;
									mosseValide.add(posizione);
									trovato = true;
								} else {

									trovato = true;
								}
							} else {
								String posizione =tempColonna  +""+ posizioneNuovaRiga;
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

					while (tempRiga >= 1 && trovato == false) {
						int posizioneNuovaRiga = --tempRiga;
						// char posizioneNuovaColonna = (char) (++tempColonna);
						if (posizioneNuovaRiga >= 8) {
							PezzoModel temp = table.get(posizioneNuovaRiga, tempColonna);
							if (temp != null) {
								if (temp.getNome().charAt(1) == 'B') {
									String posizione =tempColonna  +""+ posizioneNuovaRiga;
									mosseValide.add(posizione);
									trovato = true;
								} else {

									trovato = true;
								}
							} else {
								String posizione =tempColonna  +""+ posizioneNuovaRiga;
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
					while (tempColonna <= 'H' && trovato == false) {
						// int posizioneNuovaRiga = --tempRiga;
						char posizioneNuovaColonna = (char) (++tempColonna);
						if (posizioneNuovaColonna <= 'H') {
							PezzoModel temp = table.get(tempRiga, posizioneNuovaColonna);
							if (temp != null) {
								if (temp.getNome().charAt(1) == 'B') {
									String posizione =  posizioneNuovaColonna + "" + tempRiga;
									mosseValide.add(posizione);
									trovato = true;
								} else {

									trovato = true;
								}
							} else {
								String posizione =  posizioneNuovaColonna + "" + tempRiga;
								mosseValide.add(posizione);
								trovato = true;
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

		// Sezione che elimina le mosse che porta ad avere uno scacco;
		for (String s : mosseValide) {
			if (scaccoN(scacchiera, s) == true) {
				mosseValide.remove(s);
			}

		}
		return mosseValide;
	}

	public boolean scaccoN(ScacchieraModel scacchiera, String posizioneRe) {
		// Table<Integer, Character, PezzoModel> table = scacchiera.getScacchiera();
		List<PezzoModel> pezzi = scacchiera.getPezziFromScacchiera();
		for (PezzoModel p : pezzi) {
			if (p.getNome().charAt(1) == 'N') {
				List<String> temp = p.mosseValideB(scacchiera);
				if (!(pezzi.isEmpty())) {
					for (String s : temp) {
						if (s.equals(posizioneRe))
							;
						return true;
					}
				}
			}
		}
		return false;

	}

	public boolean scaccoB(ScacchieraModel scacchiera, String posizioneRe) {
		// Table<Integer, Character, PezzoModel> table = scacchiera.getScacchiera()
		List<PezzoModel> pezzi = scacchiera.getPezziFromScacchiera();
		for (PezzoModel p : pezzi) {
			if (p.getNome().charAt(1) == 'B') {

				List<String> temp = p.mosseValideN(scacchiera);
				if (!(temp.isEmpty())) {
					for (String s : temp) {
						if (s.equals(posizioneRe))
							;
						return true;
					}
				}
			}
		}

		return false;

	}

}
