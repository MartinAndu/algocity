package PlanoGeneral;

import PlanoDireccion.Direccion;

public class ZigZag {

	private int direccionInicial;
	private int zig;
	private int zag;
	private int direccionActual;

	public ZigZag(Direccion direccion) {
		direccionInicial = direccion.enInt();
		zig = this.validarZig();
		zag = this.validarZag();
		direccionActual = this.zig;
	}

	private int validarZag() {
		if ((direccionInicial - 1) == -1) {
			return 7;
		}
		return (direccionInicial - 1);
	}

	private int validarZig() {
		if ((direccionInicial + 1) == 8) {
			return 0;
		}
		return (direccionInicial + 1);
	}

	public int zigZagear() {
		
		if (direccionActual == zig) {
			this.direccionActual = this.zag;
			return zag;
		} else {
			this.direccionActual = this.zig;
			return zig;
		}
	}

}
