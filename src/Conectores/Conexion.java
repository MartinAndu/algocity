package Conectores;

import Edificios.Construccion;
import Edificios.Reconstruible;
import Planos.Plano;

public abstract class Conexion extends Construccion implements Reconstruible{
	abstract void proveerServicioZona(Plano unPlano);
}
