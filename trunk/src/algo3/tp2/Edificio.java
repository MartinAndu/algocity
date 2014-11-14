package algo3.tp2;

public class Edificio extends Construccion implements Reconstruible, Destruible {
	public int consumoElectrico;

	public int devolverConsumo(){
		return consumoElectrico;
	}
}
