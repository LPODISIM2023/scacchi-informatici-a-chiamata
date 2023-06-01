package ServiceImpl;

import java.util.Comparator;

public class PartiteSortPunteggioServiceImpl<T extends PartitaServiceImpl> implements Comparator<T>{

	public PartiteSortPunteggioServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
	// Ordinamento crescente;

	@Override
	public int compare(T o1, T o2) {
		Integer valore = o1.getPunteggio()>o2.getPunteggio()? 1 : -1; 
		
		 if(o1.getPunteggio() == o2.getPunteggio()) {
			 return 0;
		 }
		 
		 return valore;
	}

}
