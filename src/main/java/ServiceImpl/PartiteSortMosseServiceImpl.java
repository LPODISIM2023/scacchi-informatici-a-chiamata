package ServiceImpl;

import java.util.Comparator;

public class PartiteSortMosseServiceImpl<T extends PartitaServiceImpl> implements Comparator<T> {

	public PartiteSortMosseServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	// Ordinamento decrescente

	@Override
	public int compare(T o1, T o2) {
		 
		 Integer valore = o1.getContatoreMosse()>o2.getContatoreMosse()? -1 : 1; 
		
		 if(o1.getContatoreMosse() == o2.getContatoreMosse()) {
			 return 0;
		 }
		 
		 return valore;
	}
}
