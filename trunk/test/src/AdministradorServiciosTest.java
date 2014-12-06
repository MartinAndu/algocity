package src;

import org.junit.Test;

import Servicios.AccesoTransito;
import Servicios.AdministradorServicios;
import Servicios.Agua;
import Servicios.AltaTension;
import Servicios.BajaTension;
import Servicios.Tension;

import junit.framework.Assert;

public class AdministradorServiciosTest {

	@Test
	public void adminsitradorServiciosAgregaServicios() {
		AdministradorServicios adm = new AdministradorServicios();
		
		String idProveedor1 = java.util.UUID.randomUUID().toString(); 
		adm.agregarServicio(new Agua(idProveedor1));
		adm.agregarServicio(new BajaTension(idProveedor1));
		adm.agregarServicio(new AccesoTransito(idProveedor1));
		
		Assert.assertTrue(adm.poseeAgua());
		Assert.assertTrue(adm.poseeElectricidad());
		Assert.assertTrue(adm.poseeAccesoAlTransito());
		Assert.assertTrue(adm.poseeLosServiciosBasicos());
	}
	
	@Test
	public void administradorServiciosVerificaQueSoloSeAgregaUnMismoProveedorUnicaVez() {
		AdministradorServicios adm = new AdministradorServicios();
		String idProveedor1 = java.util.UUID.randomUUID().toString(); 
		Tension bajaTension1 = new BajaTension(idProveedor1);
		Tension bajaTension2 = new BajaTension(idProveedor1);
		adm.agregarServicio(bajaTension1);
		adm.agregarServicio(bajaTension2);
		
		adm.quitarServicio(bajaTension1);
		
		Assert.assertFalse(adm.poseeElectricidad());
		
	}
	
	@Test
	public void administradorServiciosVerificaQueSoloExistaUnProveedorDeBajaTension() {
		AdministradorServicios adm = new AdministradorServicios();
		String idProveedor1 = java.util.UUID.randomUUID().toString(); 
		String idProveedor2 = java.util.UUID.randomUUID().toString(); 
		Tension bajaTension1 = new BajaTension(idProveedor1);
		Tension bajaTension2 = new BajaTension(idProveedor2);
		adm.agregarServicio(bajaTension1);
		adm.agregarServicio(bajaTension2);
		
		adm.quitarServicio(bajaTension1);
		
		Assert.assertFalse(adm.poseeElectricidad());
		
	}
	
	@Test
	public void administradorServiciosSeVerificaQueAgregarAltaTensionNoConviveConAgregarBajaTension() {
		AdministradorServicios adm = new AdministradorServicios();
		String idProveedor1 = java.util.UUID.randomUUID().toString(); 
		String idProveedor2 = java.util.UUID.randomUUID().toString(); 
		Tension altaTension = new AltaTension(idProveedor1);
		Tension bajaTension = new BajaTension(idProveedor2);
		adm.agregarServicio(altaTension);
		adm.agregarServicio(bajaTension);
		
		adm.quitarServicio(altaTension);
		
		Assert.assertFalse(adm.poseeElectricidad());
		
	}
	
	@Test
	public void administradorServiciosSeVerificaQueAgregarBajaTensionConviveConAgregarAltaTensionPrimeraEtapa() {
		AdministradorServicios adm = new AdministradorServicios();
		String idProveedor1 = java.util.UUID.randomUUID().toString(); 
		String idProveedor2 = java.util.UUID.randomUUID().toString(); 
		Tension bajaTension = new BajaTension(idProveedor1);
		Tension altaTension = new AltaTension(idProveedor2);
		adm.agregarServicio(bajaTension);
		adm.agregarServicio(altaTension);
		
		adm.quitarServicio(altaTension);
		
		Assert.assertTrue(adm.poseeElectricidad());
		
		adm.quitarServicio(bajaTension);
		
		Assert.assertFalse(adm.poseeElectricidad());
		
	}
	
	@Test
	public void administradorServiciosSeVerificaQueAgregarBajaTensionConviveConAgregarAltaTensionSegundaEtapa() {
		AdministradorServicios adm = new AdministradorServicios();
		String idProveedor1 = java.util.UUID.randomUUID().toString(); 
		String idProveedor2 = java.util.UUID.randomUUID().toString(); 
		Tension bajaTension = new BajaTension(idProveedor1);
		Tension altaTension = new AltaTension(idProveedor2);
		adm.agregarServicio(bajaTension);
		adm.agregarServicio(altaTension);
		
		adm.quitarServicio(bajaTension);
		
		Assert.assertTrue(adm.poseeElectricidad());
		
		adm.quitarServicio(altaTension);
		
		Assert.assertFalse(adm.poseeElectricidad());
		
	}

	@Test
	public void administradorServiciosSeVerificaQueAgregarAltaTensionDeDosProveedoresPuedenConvivirPrimeraParte() {
		AdministradorServicios adm = new AdministradorServicios();
		String idProveedor1 = java.util.UUID.randomUUID().toString(); 
		String idProveedor2 = java.util.UUID.randomUUID().toString(); 
		Tension altaTension1 = new AltaTension(idProveedor1);
		Tension altaTension2 = new AltaTension(idProveedor2);
		adm.agregarServicio(altaTension1);
		adm.agregarServicio(altaTension2);
		
		adm.quitarServicio(altaTension1);
		
		Assert.assertTrue(adm.poseeElectricidad());
		
		adm.quitarServicio(altaTension2);
		
		Assert.assertFalse(adm.poseeElectricidad());
		
	}
	
	@Test
	public void administradorServiciosSeVerificaQueAgregarAltaTensionDeDosProveedoresPuedenConvivirSegundaParte() {
		AdministradorServicios adm = new AdministradorServicios();
		String idProveedor1 = java.util.UUID.randomUUID().toString(); 
		String idProveedor2 = java.util.UUID.randomUUID().toString(); 
		Tension altaTension1 = new AltaTension(idProveedor1);
		Tension altaTension2 = new AltaTension(idProveedor2);
		adm.agregarServicio(altaTension1);
		adm.agregarServicio(altaTension2);
		
		adm.quitarServicio(altaTension2);
		
		Assert.assertTrue(adm.poseeElectricidad());
		
		adm.quitarServicio(altaTension1);
		
		Assert.assertFalse(adm.poseeElectricidad());
		
	}
}
