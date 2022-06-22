package app;

import java.util.Scanner;

import cuenta.Cuenta;
import cuenta.CuentaAdmin;
import cuenta.CuentaLight;
import cuenta.CuentaPro;
import tren.Tren;

public class Menu {
	
	public void visualMenuAdmin()
	{
		Terminal nuevaTerminal = new Terminal();
		Scanner teclado=new Scanner(System.in);
		int opcion=1;
		int subOpcion=1;
		System.out.println("1.Administrar terminal");
		System.out.println("\n2.Administrar trenes");
		System.out.println("\n3.Administrar cuentas");
		System.out.println("\n4.Administrar destinos");
		///inicar viaje
		///terminar viaje
		System.out.println("\n0.Salir");
		opcion=teclado.nextInt();
		nuevaTerminal = FileUtiles.leerTerminal();
		while(opcion!=0)
		{
			switch(opcion)
			{
			case 1:
				while(subOpcion!=0)
				{
					System.out.println("1.Mostrar la terminal por pantalla");
					//System.out.println("\n2.Agregar una nueva terminal");
					System.out.println("\n2.Editar la terminal");
					//System.out.println("\n3.Eliminar una terminal");
					System.out.println("\n0.Atras");
					subOpcion=teclado.nextInt();
					switch(subOpcion)
					{
					case 1:
						System.out.println(nuevaTerminal.toString());
						break;
					case 2:
						String buffer="";
						teclado.nextLine();
						System.out.println("Ingrese el nuevo nombre de la terminal: ");
						buffer=teclado.nextLine();
						nuevaTerminal.setNombre(buffer);
						System.out.println("Ingrese la nueva direccion: ");
						buffer=teclado.nextLine();
						nuevaTerminal.setDireccion(buffer);
						FileUtiles.grabarTerminal(nuevaTerminal);
						break;
					case 0:
						return;
					default:
						System.out.println("Ingrese una opcion correcta!");
						break;
					}
				}
				break;
			case 2:
				while(subOpcion!=0)
				{
					System.out.println("1.Mostrar todos los trenes por pantalla");
					System.out.println("\n2.Dar de alta un nuevo tren");
					System.out.println("\n3.Modificar un tren");
					System.out.println("\n4.Dar de baja un tren");
					System.out.println("\n0.Atras");
					subOpcion=teclado.nextInt();
					int indice=0;
					switch(subOpcion)
					{
					case 1:
						System.out.println(nuevaTerminal.getListaDeTrenes());
						break;
					case 2:
						Tren nuevo=new Tren();
						teclado.nextLine();
						System.out.println("Ingrese el nombre del modelo: ");
						nuevo.setModelo(teclado.nextLine());
						System.out.println("Ingrese el año de fabricacion: ");
						nuevo.setAnioFabricacion(teclado.nextInt());
						System.out.println("Ingrese la distancia maxima que recorre este modelo: ");
						nuevo.setDistanciaMaxima(teclado.nextDouble());
						System.out.println("Ingrese precio por kilometro: ");
						nuevo.setPrecioPorKilometro(teclado.nextInt());
						nuevaTerminal.getListaDeTrenes().add(nuevo);
						FileUtiles.grabarTerminal(nuevaTerminal);
						break;
					case 3:
						System.out.println("Ingrese el indice del tren que quiere modificar: ");
						indice=teclado.nextInt();
						teclado.nextLine();
						System.out.println("Ingrese el nuevo modelo del tren: ");
						nuevaTerminal.getListaDeTrenes().get(indice).setModelo(teclado.nextLine());
						System.out.println("Ingrese el año de fabricacion: ");
						nuevaTerminal.getListaDeTrenes().get(indice).setAnioFabricacion(teclado.nextInt());
						System.out.println("Ingrese la distancia maxima: ");
						nuevaTerminal.getListaDeTrenes().get(indice).setDistanciaMaxima(teclado.nextDouble());
						System.out.println("Ingrese el precio por kilometro: ");
						nuevaTerminal.getListaDeTrenes().get(indice).setPrecioPorKilometro(teclado.nextInt());
						FileUtiles.grabarTerminal(nuevaTerminal);
						break;
					case 4:
						System.out.println("Ingrese el indice del tren que quiere modificar: ");
						indice=teclado.nextInt();
						nuevaTerminal.getListaDeTrenes().remove(indice);
						FileUtiles.grabarTerminal(nuevaTerminal);
						break;
					case 0:
						return;
					default:
						System.out.println("Ingrese una opcion correcta!");
						break;
					}
				}
				break;
			case 3:
				while(subOpcion!=0)
				{
					System.out.println("1.Mostrar todas las cuentas por pantalla");
					System.out.println("\n2.Registrar una nueva cuenta");
					System.out.println("\n3.Editar datos de una cuenta");
					System.out.println("\n4.Dar de baja una cuenta");
					System.out.println("\n0.Atras");
					subOpcion=teclado.nextInt();
					switch(subOpcion)
					{
					case 1:
						//
						break;
					case 0:
						return;
					default:
						System.out.println("Ingrese una opcion correcta!");
						break;
					}
				}
				break;
			case 4:
				while(subOpcion!=0)
				{
					System.out.println("1.Mostrar todos los destinos por pantalla");
					System.out.println("\n2.Agregar un nuevo destino");
					System.out.println("\n3.Modificar un destino");
					System.out.println("\n4.Eliminar un destino");
					System.out.println("\n0.Atras");
					subOpcion=teclado.nextInt();
					switch(subOpcion)
					{
					case 1:
						//
						break;
					case 0:
						return;
					default:
						System.out.println("Ingrese una opcion correcta!");
						break;
					}
				}
				break;
			case 0:
				return;
			default:
				System.out.println("Ingrese una opcion correcta!");
				break;

			}
		}
	}
	
	public void menuMain()
	{
		Terminal nuevaTerminal = new Terminal();
		Scanner teclado=new Scanner(System.in);
		int opcion=1;
		while(opcion!=3)
		{
			nuevaTerminal = FileUtiles.leerTerminal();
	
			
			/*Destino destino1 = new Destino("Bariloche", 1443);
			nuevaTerminal.getListaDeDestinos().add(destino1);
			Destino destino2 = new Destino("CABA", 413.9);
			Tren tren1 = new Tren("Alstom 2000", 2006, 800, 3);
			nuevaTerminal.getListaDeDestinos().add(destino2);
			nuevaTerminal.getListaDeTrenes().add(tren1);
			FileUtiles.grabarTerminal(nuevaTerminal);*/
			
			
			nuevaTerminal = FileUtiles.leerTerminal();
			System.out.println("---------- "+ "Bienvenido a " + nuevaTerminal.getNombre() + " ----------");
			System.out.println("1.Loguearse");
			System.out.println("2.Registrarse");
			System.out.println("3.Salir");
			opcion = teclado.nextInt();
			switch(opcion) {
			case 1:
				nuevaTerminal.login();
				break;
			case 2:
				nuevaTerminal.registrarCuenta();
				FileUtiles.grabarTerminal(nuevaTerminal);
				break;
			case 3:
				return;				
			default:
				System.out.println("\nIngrese una opcion correcta!");
				break;
			}
		}
		teclado.close();
	}
	
	public void visualMenuUsuarioLight(CuentaLight cuentaIngresada)
	{
		Terminal nuevaTerminal = new Terminal();
		Scanner teclado=new Scanner(System.in);
		int opcion=1;
		while(opcion!=0)
		{
			nuevaTerminal = FileUtiles.leerTerminal();
			
			System.out.println("---------- "+ "Menu Cuenta" + " ----------");
			System.out.println("Hola "+cuentaIngresada.getUser()+"!, que deseas hacer?...\n");
			System.out.println("1.Comprar un boleto");
			System.out.println("2.Saldo");
			System.out.println("3.Boletos");
			System.out.println("0.Cerrar sesion");
			
			opcion = teclado.nextInt();
			switch(opcion) {
			case 1:
				nuevaTerminal = FileUtiles.leerTerminal();
				nuevaTerminal.setRecaudacion(nuevaTerminal.getMapDeCuentas().get(cuentaIngresada.getUser()).sacarBoleto(nuevaTerminal.getListaDeTrenes(), nuevaTerminal.getListaDeDestinos()));
				FileUtiles.grabarTerminal(nuevaTerminal);
				break;
			case 2:
				nuevaTerminal = FileUtiles.leerTerminal();
				
				nuevaTerminal.getMapDeCuentas().get(cuentaIngresada.getUser()).agregarSaldo();
				
				FileUtiles.grabarTerminal(nuevaTerminal);
				break;
			case 3:
				nuevaTerminal = FileUtiles.leerTerminal();
				System.out.println(nuevaTerminal.getMapDeCuentas().get(cuentaIngresada.getUser()).getListaDeBoletos());
				break;				
			case 0:
				return;
			default:
				System.out.println("\nIngrese una opcion correcta!");
				break;
			}
		}
		FileUtiles.grabarTerminal(nuevaTerminal);
	}

	public void visualMenuUsuarioPro(CuentaPro cuentaIngresada)
	{
		Terminal nuevaTerminal = new Terminal();
		Scanner teclado=new Scanner(System.in);
		int opcion=1;
		while(opcion!=0)
		{
			nuevaTerminal = FileUtiles.leerTerminal();
			
			System.out.println("---------- "+ "Menu Cuenta" + " ----------");
			System.out.println("Hola "+cuentaIngresada.getUser()+"!, que deseas hacer?...\n");
			System.out.println("1.Comprar un boleto");
			System.out.println("2.Saldo");
			System.out.println("3.Boletos");
			System.out.println("4.Kilometros ganados");
			System.out.println("0.Cerrar sesion");
			
			opcion = teclado.nextInt();
			switch(opcion) {
			case 1:
				nuevaTerminal = FileUtiles.leerTerminal();
				nuevaTerminal.setRecaudacion(nuevaTerminal.getMapDeCuentas().get(cuentaIngresada.getUser()).sacarBoleto(nuevaTerminal.getListaDeTrenes(), nuevaTerminal.getListaDeDestinos()));
				FileUtiles.grabarTerminal(nuevaTerminal);
				break;
			case 2:
				nuevaTerminal = FileUtiles.leerTerminal();
				nuevaTerminal.getMapDeCuentas().get(cuentaIngresada.getUser()).agregarSaldo();
				FileUtiles.grabarTerminal(nuevaTerminal);
				break;
			case 3:
				nuevaTerminal = FileUtiles.leerTerminal();
				System.out.println(nuevaTerminal.getMapDeCuentas().get(cuentaIngresada.getUser()).getListaDeBoletos());
				break;	
			case 4:
				nuevaTerminal = FileUtiles.leerTerminal();
				((CuentaPro) nuevaTerminal.getMapDeCuentas().get(cuentaIngresada.getUser())).canjearKilometrosGanados();
				FileUtiles.grabarTerminal(nuevaTerminal);
			case 0:
				return;
			default:
				System.out.println("\nIngrese una opcion correcta!");
				break;
			}
		}
		FileUtiles.grabarTerminal(nuevaTerminal);
	}
}
