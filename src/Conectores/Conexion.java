package Conectores;

import planoGeneral.Plano;
import Edificios.Construccion;
import Edificios.Reconstruible;

public abstract class Conexion extends Construccion implements Reconstruible{
	 abstract void proveerServicioZona(Plano unPlano);
}
