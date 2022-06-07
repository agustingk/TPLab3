package app;

import cuenta.Cuenta;
import cuenta.CuentaAdmin;
import cuenta.CuentaLight;
import cuenta.CuentaPro;
import tren.Tren;
import tren.TrenBala;

public class Main {

	public static void main(String[] args) {

		CuentaAdmin cuentaAdmin = new CuentaAdmin("Lucas", "Moreno", 43, "Lucas01", "1234", 'm', "25266511");
		Terminal terminal1 = new Terminal("MDQ", "San Juan 1234", cuentaAdmin);
		
		CuentaLight cuenta2 = new CuentaLight("Jose", "Perez", 17, "Jose05", "1234", 'm', "45222154");
		cuenta2.agregarSaldo(5000);
		
		Cuenta cuenta3 = new CuentaPro("Jose", "Perez", 17, "Jose05", "1234", 'm', "45222154");
		
		terminal1.agregarCuenta(cuenta2);
		terminal1.agregarCuenta(cuenta3);
		
		/////////////////////////////////////
		
		Destino destino1 = new Destino("Bariloche", 1443);
		Destino destino2 = new Destino("CABA", 413.9);
		terminal1.getAdmin().agregarDestino(destino1, terminal1.getListaDeDestinos());
		terminal1.getAdmin().agregarDestino(destino2, terminal1.getListaDeDestinos());
	
		/////////////////////////////////////
		
		terminal1.getAdmin().quitarDestino(0, terminal1.getListaDeDestinos());
		
		//////////////////////////////////////
		
		//System.out.println(terminal1.getListaDeDestinos());
		
		System.out.println("\n\n\n");
		
		//System.out.println(terminal1);
		
		//////////////////////////////////////
		
		Tren tren1 = new Tren("Alstom 2000", 2006, 800);
		Tren tren2 = new Tren("Tatra3", 2010, 450);
		
		cuentaAdmin.agregarTren(tren1, terminal1.getListaDeTrenes());
		cuentaAdmin.agregarTren(tren2, terminal1.getListaDeTrenes());
		
		//////////////////////////////////////
		
		System.out.println(cuenta2.mostrarListaDeDestinos(terminal1.getListaDeDestinos()));
		
		System.out.println(cuenta2.mostrarListaDeTrenes(terminal1.getListaDeTrenes()));
		
		//////////////////////////////////////
		
		cuentaAdmin.iniciarViaje(0, terminal1.getListaDeTrenes());
		
		System.out.println(terminal1.getListaDeTrenes());
		
	}
}
