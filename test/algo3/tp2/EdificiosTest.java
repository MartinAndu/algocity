package algo3.tp2;

import junit.framework.Assert;
import org.junit.Test;

public class EdificiosTest {

	@Test
	public void edificioResidencialDevuelveCostoCorrecto(){
		
        Edificio unEdificioResidencial = new EdificioResidencial();
        int costo = unEdificioResidencial.devolverCosto();
        Assert.assertEquals(10, costo);

	}
}
