package Conectores;

import Edificios.Construccion;
import Edificios.Reconstruible;
import Plano.Plano;

public abstract class Conexion extends Construccion implements Reconstruible{
	abstract void proveerServicioZona(Plano unPlano);
}
