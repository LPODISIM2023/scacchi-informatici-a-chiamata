package ServiceImpl;

import java.util.Comparator;

public class PartiteSortNumPezziServiceImpl <T extends PartitaServiceImpl> implements Comparator<T> {

	public PartiteSortNumPezziServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
	// Ordinamento decrescente;

	@Override
	public int compare(T o1, T o2) {
		 Integer valore = o1.getNumeroPezzi()> o2.getNumeroPezzi()? -1 : 1; 
			
		 if(o1.getNumeroPezzi() == o2.getNumeroPezzi()) {
			 return 0;
		 }
		 
		 return valore;
	}

}
