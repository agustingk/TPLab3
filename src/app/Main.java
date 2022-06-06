package app;

import cuenta.Cuenta;
import cuenta.CuentaAdmin;

public class Main {

	public static void main(String[] args) {

		CuentaAdmin cuenta1 = new CuentaAdmin("Lucas", "Moreno", 43, "Lucas01", "1234", 'm');
		Terminal terminal1 = new Terminal("MDQ", "San Juan 1234", cuenta1);
		
		Cuenta cuenta2 = new Cuenta("Jose", "Perez", 17, "Jose05", "1234", 'm');
		
		cuenta2.agregarSaldo(5000);
		
		/////////////////////////////////////
		
		Destino destino1 = new Destino("Bariloche", 1443);
		Destino destino2 = new Destino("CABA", 413.9);
		terminal1.getAdmin().agregarDestino(destino1, terminal1.getListaDeDestinos());
		terminal1.getAdmin().agregarDestino(destino2, terminal1.getListaDeDestinos());
	
		/////////////////////////////////////
		
		terminal1.getAdmin().quitarDestino(0, terminal1.getListaDeDestinos());
		
		//////////////////////////////////////
		
		System.out.println(terminal1.getListaDeDestinos());
		
		System.out.println("\n\n\n");
		
		System.out.println(terminal1);
		
		
		
	}
}
