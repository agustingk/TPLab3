package app;

import java.util.Scanner;

import cuenta.Cuenta;
import cuenta.CuentaAdmin;
import tren.Tren;

public class Menu {
	
	public void visualMenuAdmin()
	{
		System.out.println("1.Administrar terminal");
		System.out.println("\n2.Administrar trenes");
		System.out.println("\n3.Administrar cuentas");
		System.out.println("\n4.Administrar destinos");
		///inicar viaje
		///terminar viaje
		System.out.println("\n0.Salir");
	}
	
	public void visualMenuAdminSub1()
	{
		System.out.println("1.Mostrar todas las terminales por pantalla");
		//System.out.println("\n2.Agregar una nueva terminal");
		System.out.println("\n2.Editar una terminal");
		System.out.println("\n3.Eliminar una terminal");
		System.out.println("\n0.Atras");
	}
	
	public void visualMenuAdminSub2()
	{
		System.out.println("1.Mostrar todos los trenes por pantalla");
		System.out.println("\n2.Dar de alta un nuevo tren");
		System.out.println("\n3.Modificar un tren");
		System.out.println("\n4.Dar de baja un tren");
		System.out.println("\n0.Atras");
	}
	
	public void visualMenuAdminSub3()
	{
		System.out.println("1.Mostrar todas las cuentas por pantalla");
		System.out.println("\n2.Registrar una nueva cuenta");
		System.out.println("\n3.Editar datos de una cuenta");
		System.out.println("\n4.Dar de baja una cuenta");
		System.out.println("\n0.Atras");
	}
	
	public void visualMenuAdminSub4()
	{
		System.out.println("1.Mostrar todos los destinos por pantalla");
		System.out.println("\n2.Agregar un nuevo destino");
		System.out.println("\n3.Modificar un destino");
		System.out.println("\n4.Eliminar un destino");
		System.out.println("\n0.Atras");
	}
	
	public void menuMain()
	{
		Terminal nuevaTerminal;
		Scanner teclado=new Scanner(System.in);
		int opcion=1;
		while(opcion!=3)
		{
			nuevaTerminal = FileUtiles.leerTerminal();
			System.out.println("---------- "+ "Bienvenido a " + nuevaTerminal.getNombre() + " ----------");
			System.out.println("1.Loguearse");
			System.out.println("2.Registrarse");
			System.out.println("3.Salir");
			//teclado.nextInt();
			opcion = teclado.nextInt();
			switch(opcion) {
			case 1:
				nuevaTerminal.login();
				break;
			case 2:
				nuevaTerminal.registrarCuenta();
				break;
			case 3:
				break;				
			default:
				System.out.println("\nIngrese una opcion correcta!");
				break;
			}
		}
		teclado.close();
	}
	
	public void visualMenuUsuario(Cuenta cuentaIngresada)
	{
		Terminal nuevaTerminal = new Terminal();
		Scanner teclado=new Scanner(System.in);
		int opcion=1;
		while(opcion!=4)
		{
			nuevaTerminal = FileUtiles.leerTerminal();
			
			////////
			Destino destino1 = new Destino("Bariloche", 1443);
			Destino destino2 = new Destino("CABA", 413.9);
			Tren tren1 = new Tren("Alstom 2000", 2006, 800);
			nuevaTerminal.getListaDeDestinos().add(destino1);
			nuevaTerminal.getListaDeDestinos().add(destino2);
			nuevaTerminal.getListaDeTrenes().add(tren1);
			FileUtiles.grabarTerminal(nuevaTerminal);
			////////
			
			System.out.println("---------- "+ "Menu Cuenta" + " ----------");
			System.out.println("Hola, "+cuentaIngresada.getNombre()+"!, que deseas hacer?...\n");
			System.out.println("1.Comprar un boleto");
			System.out.println("2.Saldo");
			System.out.println("3.Boletos");
			System.out.println("4.Salir");
			//teclado.nextInt();
			
			opcion = teclado.nextInt();
			switch(opcion) {
			case 1:
				nuevaTerminal = FileUtiles.leerTerminal();
				nuevaTerminal.setRecaudacion(nuevaTerminal.getMapDeCuentas().get(cuentaIngresada.getUser()).sacarBoleto(nuevaTerminal.getListaDeTrenes(), nuevaTerminal.getListaDeDestinos()));
				FileUtiles.grabarTerminal(nuevaTerminal);
				break;
			case 2:
				nuevaTerminal = FileUtiles.leerTerminal();
				if(cuentaIngresada instanceof CuentaAdmin) {
					nuevaTerminal.getAdmin().agregarSaldo();
				}
				else {
					nuevaTerminal.getMapDeCuentas().get(cuentaIngresada.getUser()).agregarSaldo();
					///System.out.println(nuevaTerminal.getMapDeCuentas().get(cuentaIngresada).getSaldo());
				}
				FileUtiles.grabarTerminal(nuevaTerminal);
				break;
			case 3:
				nuevaTerminal = FileUtiles.leerTerminal();
				System.out.println(nuevaTerminal.getMapDeCuentas().get(cuentaIngresada.getUser()).getListaDeBoletos());
				break;				
			case 4:
				break;
			default:
				System.out.println("\nIngrese una opcion correcta!");
				break;
			}
		}
		FileUtiles.grabarTerminal(nuevaTerminal);
	}
}
