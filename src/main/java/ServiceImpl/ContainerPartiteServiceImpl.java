package ServiceImpl;

import java.io.Serializable;
import java.util.List;

public class ContainerPartiteServiceImpl implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6994320030686351568L;
	private List<PartitaServiceImpl> listaPartite;
	public ContainerPartiteServiceImpl() {
		
	}
	
	public ContainerPartiteServiceImpl(List<PartitaServiceImpl> listaPartite) {
		this.listaPartite = listaPartite;
		
	}

	public List<PartitaServiceImpl> getListaPartite() {
		return listaPartite;
	}

	public void setListaPartite(List<PartitaServiceImpl> listaPartite) {
		this.listaPartite = listaPartite;
	}
}
