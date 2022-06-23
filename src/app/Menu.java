package app;

import java.util.InputMismatchException;
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
		//System.out.println("\n5.Ingresar como usuario demo");
		///inicar viaje
		///terminar viaje
		System.out.println("\n0.Salir");
		while(opcion!=0)
		{
			try {
		opcion=teclado.nextInt();
			}
			catch(InputMismatchException e)
			{
		System.out.println("Tampoco para mandarle fruta mi rey");
			}
		nuevaTerminal = FileUtiles.leerTerminal();
		
			switch(opcion)
			{
			case 1:
				while(subOpcion!=0)
				{
					System.out.println("1.Mostrar la terminal por pantalla");
					//System.out.println("\n2.Agregar una nueva terminal"); rebundante
					System.out.println("\n2.Editar la terminal");
					//System.out.println("\n3.Eliminar una terminal"); inecesariamente destructivo
					System.out.println("\n0.Atras");
					try {
					subOpcion=teclado.nextInt();
					}
					catch(InputMismatchException e) {
						System.out.println("Elija una opcion correcta");
					}
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
						System.out.println("°°La terminal fue modificada con exito°°");
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
					try {
					subOpcion=teclado.nextInt();
					}
					catch(InputMismatchException e) {
						System.out.println("Elija una opcion correcta");
					}
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
						try {
							nuevo.setAnioFabricacion(teclado.nextInt());
						}
						catch(InputMismatchException e) {
							System.out.println("Ingrese el tipo de dato correcto");
						}
						System.out.println("Ingrese la distancia maxima que recorre este modelo: ");
						try {
						nuevo.setDistanciaMaxima(teclado.nextDouble());
						}
						catch(InputMismatchException a) {
							System.out.println("Ingrese el tipo de dato correcto");
						}
						System.out.println("Ingrese precio por kilometro: ");
						try {
						nuevo.setPrecioPorKilometro(teclado.nextInt());
						}
						catch(InputMismatchException b) {
							System.out.println("Ingrese el tipo de dato correcto");
						}
						nuevaTerminal.getListaDeTrenes().add(nuevo);
						FileUtiles.grabarTerminal(nuevaTerminal);
						System.out.println("°°El tren fue creado con exito°°");
						break;
					case 3:
						System.out.println("Ingrese el indice del tren que quiere modificar: ");
						try {
						indice=teclado.nextInt();
						}
						catch(InputMismatchException c) {
							System.out.println("Ingrese el tipo de dato correcto");
						}
						teclado.nextLine();
						System.out.println("Ingrese el nuevo modelo del tren: ");
						nuevaTerminal.getListaDeTrenes().get(indice).setModelo(teclado.nextLine());
						System.out.println("Ingrese el año de fabricacion: ");
						try {
						nuevaTerminal.getListaDeTrenes().get(indice).setAnioFabricacion(teclado.nextInt());
						}
						catch(InputMismatchException d) {
							System.out.println("Ingrese el tipo de dato correcto");
						}
						System.out.println("Ingrese la distancia maxima: ");
						try {
						nuevaTerminal.getListaDeTrenes().get(indice).setDistanciaMaxima(teclado.nextDouble());
						}
						catch(InputMismatchException f) {
							System.out.println("Ingrese el tipo de dato correcto");
						}
						System.out.println("Ingrese el precio por kilometro: ");
						try {
						nuevaTerminal.getListaDeTrenes().get(indice).setPrecioPorKilometro(teclado.nextInt());
						}
						catch(InputMismatchException g) {
							System.out.println("Ingrese el tipo de dato correcto");
						}
						FileUtiles.grabarTerminal(nuevaTerminal);
						System.out.println("°°El tren fue modificado con exito°°");
						break;
					case 4:
						System.out.println("Ingrese el indice del tren que quiere modificar: ");
						try {
						indice=teclado.nextInt();
						}
						catch(InputMismatchException h) {
							System.out.println("Ingrese el tipo de dato correcto");
						}
						nuevaTerminal.getListaDeTrenes().remove(indice);
						FileUtiles.grabarTerminal(nuevaTerminal);
						System.out.println("°°El tren fue eliminado con exito°°");
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
					//System.out.println("\n3.Editar datos de una cuenta"); Para respetar la privacidad del usuario se prescinde de la opcion
					System.out.println("\n3.Dar de baja una cuenta");
					System.out.println("\n0.Atras");
					String buscado=new String();
					try {
					subOpcion=teclado.nextInt();
					}
					catch(InputMismatchException e) {
						System.out.println("Ingrese una opcion correcta");
					}
					switch(subOpcion)
					{
					case 1:
						System.out.println(nuevaTerminal.getMapDeCuentas());
						break;
					case 2:
						nuevaTerminal.registrarCuenta();
						FileUtiles.grabarTerminal(nuevaTerminal);
						System.out.println("°°La cuenta fue registrada con exito°°");
						break;
					case 3:
						System.out.println("Ingrese el usuario que desea eliminar");
						buscado=teclado.next();
						if(nuevaTerminal.getMapDeCuentas().containsKey(buscado))
						{
							nuevaTerminal.getMapDeCuentas().remove(buscado);
							FileUtiles.grabarTerminal(nuevaTerminal);
							System.out.println("°°La cuenta fue eliminada con exito°°");
						}
						else
						{
							System.out.println("El usuario es incorrecto o no existe");
						}
						
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
					int buscado=0;
					boolean exito=false;
					switch(subOpcion)
					{
					case 1:
						System.out.println(nuevaTerminal.getListaDeDestinos());
						break;
					case 2:
						Destino nuevo=new Destino();
						teclado.nextLine();
						System.out.println("Ingrese el nombre del destino: ");
						nuevo.setNombreDeDestino(teclado.nextLine());
						System.out.println("Especifique la distancia en kilometros del viaje: ");
						try
						{
							nuevo.setDistanciaEnKilometros(teclado.nextFloat());
						}
						catch(InputMismatchException e) {
							System.out.println("Ingrese un tipo de dato correcto");
						}
						nuevaTerminal.getListaDeDestinos().add(nuevo);
						FileUtiles.grabarTerminal(nuevaTerminal);
						System.out.println("°°El destino fue creado con exito°°");
						break;
					case 3:
						System.out.println("Ingrese el indice del destino que quiere modificar");
						try {
						buscado=teclado.nextInt();
						}
						catch(InputMismatchException e) {
							System.out.println("Ingrese un tipo de dato correcto");
						}
						teclado.nextLine();
						System.out.println("Ingrese el nuevo nombre del destino");
						nuevaTerminal.getListaDeDestinos().get(buscado).setNombreDeDestino(teclado.nextLine());
						System.out.println("Ingrese la distancia en kilometros del viaje");
						try
							{
							nuevaTerminal.getListaDeDestinos().get(buscado).setDistanciaEnKilometros(teclado.nextFloat());
							}
						catch(InputMismatchException e) {
								System.out.println("Ingrese un tipo de dato correcto");
							}
						FileUtiles.grabarTerminal(nuevaTerminal);
						System.out.println("°°El destino fue modificado con exito°°");
						break;
					case 4:
						//
						System.out.println("Ingrese el indice del destino que quiere eliminar: ");
						try
						{
							buscado=teclado.nextInt();
						}
						catch(InputMismatchException e) {
							System.out.println("Ingrese un tipo de dato correcto");
						}
						nuevaTerminal.getListaDeDestinos().remove(buscado);
						FileUtiles.grabarTerminal(nuevaTerminal);
						System.out.println("°°El destino fue eliminado con exito°°");
						break;
					case 0:
						return;
					default:
						System.out.println("Ingrese una opcion correcta!");
						break;
					}
				}
				break;
			/*case 5:
				CuentaLight admin=new CuentaLight("Admin","Admin",99,"admin","admin",'m',"CuentaDemo");
				admin.setSaldo(9999999);
				visualMenuUsuarioLight(admin);*/
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
}
