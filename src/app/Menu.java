package app;

import java.util.Scanner;

public class Menu {
	
	public void visualMenuAdmin()
	{
		System.out.println("1.Administrar terminal");
		System.out.println("\n2.Administrar trenes");
		System.out.println("\n3.Administrar cuentas");
		System.out.println("\n4.Administrar destinos");
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
		Scanner teclado=new Scanner(System.in);
		System.out.println("Bienvenido a la terminal de Mar del Plata");
		int opcion=1;
		while(opcion!=0)
		{
			System.out.println("1.Loguearse");
			System.out.println("2.Registrarse");
			System.out.println("0.Salir");
			teclado.nextInt();
			switch(opcion) {
			case 1:
				//aca usaria las funciones de log in... SI TUVIESE AlGUNA (inserte meme de los padrinos magicos)
			case 2:
				//
			default:
				break;
			}
		}
		teclado.close();
	}
	
	public void visualMenuUsuario()
	{
		System.out.println("1.Comprar un nuevo viaje");
		System.out.println("\n2.Saldo");
		System.out.println("\n3.Historial de viajes");
		System.out.println("\n0.Salir");
	}
}
