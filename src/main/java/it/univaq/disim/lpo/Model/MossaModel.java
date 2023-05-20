package it.univaq.disim.lpo.Model;

import java.util.Map;

import it.univaq.disim.lpo.Service.Mossa;

public abstract class MossaModel implements Mossa{
	private Map<PezzoModel, String> mossa;
	
	public MossaModel(Map<PezzoModel,String> mossa) {
		this.mossa = mossa;
	}

	public Map<PezzoModel,String> getMossa() {
		return mossa;
	}
    
	public PezzoModel getChiave(String chiave) {
		
		try {
			for(PezzoModel p : this.mossa.keySet()) {
				if(p.getNome().equals(chiave))
					return p;
			}
			
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	public void setMossa(Map<PezzoModel,String> mossa) {
		this.mossa = mossa;
	}
	
	
	
}
