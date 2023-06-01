package it.univaq.disim.lpo.Model.Beans;

import java.io.Serializable;
import java.util.List;

import ServiceImpl.PartitaServiceImpl;

public class ContainerPartite implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6994320030686351568L;
	private List<PartitaServiceImpl> listaPartite;
	public ContainerPartite() {
		
	}
	
	public ContainerPartite(List<PartitaServiceImpl> listaPartite) {
		this.listaPartite = listaPartite;
		
	}

	public List<PartitaServiceImpl> getListaPartite() {
		return listaPartite;
	}

	public void setListaPartite(List<PartitaServiceImpl> listaPartite) {
		this.listaPartite = listaPartite;
	}
}
