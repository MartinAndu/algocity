package planoGeneral;

public class Hectarea {
	
	public String identi;

	public Hectarea() {
		
		this.identi = java.util.UUID.randomUUID().toString(); 
	}
	
	@Override
	public boolean equals (Object o) {
	    Hectarea x = (Hectarea) o;
	        if (x.identi == identi) return true;
	        return false;
	}


}
