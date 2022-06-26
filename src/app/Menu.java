package app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.json.JSONException;
import org.json.JSONObject;

import cuenta.Cuenta;
import cuenta.CuentaAdmin;
import cuenta.CuentaLight;
import cuenta.CuentaPro;
import exception.TerminalException;
import json.JsonUtiles;
import tren.Tren;
import tren.TrenBala;

public class Menu {
	
	public void visualMenuAdmin() throws TerminalException
	{
		
		Terminal nuevaTerminal = new Terminal();
		Scanner teclado=new Scanner(System.in);
		int opcion=1, opcionJson=0;
		int subOpcion=1;
		while(opcion!=0)
		{
			subOpcion=1;
			System.out.println("---------- "+ "Menu Cuenta Admin" + " ----------");
			System.out.println("1.Administrar terminal");
			System.out.println("2.Administrar trenes");
			System.out.println("3.Administrar cuentas");
			System.out.println("4.Administrar destinos");
			System.out.println("5.Menu JSON");
			//System.out.println("\n5.Ingresar como usuario demo");
			///inicar viaje
			///terminar viaje
			System.out.println("\n0.Cerrar sesion");
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
					Tren trenAIniciarViaje = new Tren();
					Tren trenATerminarViaje = new Tren();
					ArrayList<Tren> trenesDisp = new ArrayList<Tren>();
					int opcionDestinoViaje=0, opcionTrenViaje=0, indiceTrenReal=0;
					System.out.println("---------- "+ "Menu Terminal" + " ----------");
					System.out.println("1.Mostrar la terminal por pantalla");
					//System.out.println("\n2.Agregar una nueva terminal"); rebundante
					System.out.println("2.Editar la terminal");
					//System.out.println("\n3.Eliminar una terminal"); inecesariamente destructivo
					System.out.println("3.Iniciar viaje");
					System.out.println("4.Terminar viaje");
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
					case 3:
						if(nuevaTerminal.getListaDeDestinos().size() == 0 || nuevaTerminal.getListaDeTrenes().size() == 0) {
							System.out.println("Hacen faltan trenes en la terminal o destinos a los cual ir. Agregue mas desde el menu de admin.");
						}
						else {
							System.out.println("---------- "+ "Menu Inicio de Viaje" + " ----------");
							System.out.println("---------- "+ "Lista de Destinos" + " ----------");
							for(int i =0; i < nuevaTerminal.getListaDeDestinos().size(); i++) {
								System.out.println("["+i+"]"+nuevaTerminal.getListaDeDestinos().get(i)+ "\n");
							}					
							System.out.println("Elija el [INDICE] del destino para inicar el viaje");
							
							try {
								opcionDestinoViaje = teclado.nextInt();
							}
							catch(InputMismatchException e) {
								System.out.println("Ingrese un [INDICE] correcto.");
							}
							
							if(opcionDestinoViaje <= nuevaTerminal.getListaDeDestinos().size() - 1) {
								for(int i = 0; i < nuevaTerminal.getListaDeTrenes().size(); i++) {
									if(nuevaTerminal.getListaDeTrenes().get(i).getDistanciaMaxima() > nuevaTerminal.getListaDeDestinos().get(opcionDestinoViaje).getDistanciaEnKilometros() && !nuevaTerminal.getListaDeTrenes().get(i).getEnViaje()) {
										trenesDisp.add(nuevaTerminal.getListaDeTrenes().get(i));
									}
								}
								
								if(trenesDisp.size() > 0) {
									System.out.println("---------- "+ "Lista de Trenes" + " ----------");
									for(int i = 0; i < trenesDisp.size(); i++) {
										System.out.println("["+i+"]" + trenesDisp.get(i)+"\n");
									}
									System.out.println("Elija el [INDICE] del tren para inicar el viaje a "+nuevaTerminal.getListaDeDestinos().get(opcionDestinoViaje).getNombreDeDestino());
									
									try {
										opcionTrenViaje = teclado.nextInt();
									}
									catch(InputMismatchException e) {
										System.out.println("Ingrese un [INDICE] correcto.");
									}
									
									if(opcionTrenViaje <= trenesDisp.size() - 1) {
										trenAIniciarViaje = trenesDisp.get(opcionTrenViaje);
										for(int i = 0; i < nuevaTerminal.getListaDeTrenes().size(); i++) {
											if(trenAIniciarViaje.equals(nuevaTerminal.getListaDeTrenes().get(i))) {
												indiceTrenReal = i;
												nuevaTerminal.getListaDeTrenes().get(indiceTrenReal).setEnViaje(true);
											}
										}
										for(HashMap.Entry<String, Cuenta> entry : nuevaTerminal.getMapDeCuentas().entrySet()) {
											for(int i = 0; i < entry.getValue().getListaDeBoletos().size(); i++) {
												if(entry.getValue().getListaDeBoletos().get(i).getIndiceTren() == indiceTrenReal) {
													if(entry.getValue().getListaDeBoletos().get(i).getDestinoDelViaje() == nuevaTerminal.getListaDeDestinos().get(opcionDestinoViaje)) {
														entry.getValue().getListaDeBoletos().get(i).setVencido(true);
													}
												}
											}
										}
										FileUtiles.grabarTerminal(nuevaTerminal);
										System.out.println("El tren "+trenAIniciarViaje.getModelo()+" a iniciado viaje con destino a "+nuevaTerminal.getListaDeDestinos().get(opcionDestinoViaje).getNombreDeDestino());
									}
									else {
										System.out.println("Ingrese un [INDICE] correcto...");
									}
								}
								else {
									System.out.println("No hay trenes disponibles que alcanzen esa distancia por el momento.");
								}
								
							}
							else {
								System.out.println("Ingrese un [INDICE] correcto...");
							}
						}
						break;
					case 4:
						if(nuevaTerminal.getListaDeTrenes().size() != 0) {
							for(int i = 0; i < nuevaTerminal.getListaDeTrenes().size(); i++) {
								if(nuevaTerminal.getListaDeTrenes().get(i).getEnViaje()) {
									trenesDisp.add(nuevaTerminal.getListaDeTrenes().get(i));
								}
							}
							if(trenesDisp.size() > 0) {
								System.out.println("---------- "+ "Menu Terminado de Viaje" + " ----------");
								for(int i = 0; i < trenesDisp.size(); i++) {
									System.out.println("["+i+"]"+trenesDisp.get(i)+"\n");
								}
								
								System.out.println("Elija el [INDICE] del tren que finalizara su viaje.");
								
								try {
									opcionTrenViaje = teclado.nextInt();
								}
								catch(InputMismatchException e) {
									System.out.println("Ingrese un [INDICE] correcto.");
								}
								
								if(opcionTrenViaje <= trenesDisp.size() - 1) {
									trenATerminarViaje = trenesDisp.get(opcionTrenViaje);
									for(int i = 0; i < nuevaTerminal.getListaDeTrenes().size(); i++) {
										if(trenATerminarViaje.equals(nuevaTerminal.getListaDeTrenes().get(i))) {
											nuevaTerminal.getListaDeTrenes().get(i).setEnViaje(false);
										}
									}
									FileUtiles.grabarTerminal(nuevaTerminal);
									System.out.println("Viaje del tren "+trenATerminarViaje.getModelo()+" a finalizado.");
								}
								else {
									System.out.println("Ingrese un [INDICE] correcto...");
								}
							}
							else {
								System.out.println("No hay viajes en el momento.");
							}
						}
						else {
							System.out.println("No hay viajes en el momento.");
						}
						break;
					case 0:
						break;
					default:
						System.out.println("Ingrese una opcion correcta!");
						break;
					}
				}
				break;
			case 2:
				while(subOpcion!=0)
				{
					Tren trenAModificarNuevo = new Tren();
					Tren trenAModificarActual = new Tren();
					System.out.println("---------- "+ "Menu Trenes" + " ----------");
					System.out.println("1.Mostrar todos los trenes por pantalla");
					System.out.println("2.Dar de alta un nuevo tren");
					System.out.println("3.Modificar un tren");
					System.out.println("4.Dar de baja un tren");
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
						if(nuevaTerminal.getListaDeTrenes().size() > 0) {
							System.out.println("---------- "+ "Lista de Trenes" + " ----------");
							System.out.println(nuevaTerminal.getListaDeTrenes());
						}
						else {
							System.out.println("No hay trenes cargados en la base de datos actual.");
						}
						break;
					case 2:
						Tren nuevo=new TrenBala();
						System.out.println("---------- "+ "Menu Alta de Tren" + " ----------");
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
						if(nuevaTerminal.getListaDeTrenes().contains(nuevo)) {
							System.out.println("Ya existe este tren en la terminal.");
						}
						else {
							nuevaTerminal.getListaDeTrenes().add(nuevo);
							FileUtiles.grabarTerminal(nuevaTerminal);
							System.out.println("°°El tren fue creado con exito°°");
						}
						break;
					case 3:
						if(nuevaTerminal.getListaDeTrenes().size() > 0) {
							System.out.println("---------- "+ "Lista de Trenes" + " ----------");
							for(int case3 = 0; case3 < nuevaTerminal.getListaDeTrenes().size(); case3++) {
								System.out.println("["+case3+"]"+nuevaTerminal.getListaDeTrenes().get(case3));
								System.out.println("\n");
							}
							System.out.println("Ingrese el [INDICE] del tren que quiere modificar: ");
							try {
								indice=teclado.nextInt();
							}
							catch(InputMismatchException c) {
								System.out.println("Ingrese el tipo de dato correcto");
							}
							if(indice <= nuevaTerminal.getListaDeTrenes().size() - 1) {
								trenAModificarActual = nuevaTerminal.getListaDeTrenes().get(indice);
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
								
								trenAModificarNuevo = nuevaTerminal.getListaDeTrenes().get(indice);
								
								for(HashMap.Entry<String, Cuenta> entry : nuevaTerminal.getMapDeCuentas().entrySet()) {
									for(int i = 0; i < entry.getValue().getListaDeBoletos().size(); i++) {
										if(entry.getValue().getListaDeBoletos().get(i).getTrenSeleccionado().equals(trenAModificarActual)) {
											entry.getValue().getListaDeBoletos().get(i).setTrenSeleccionado(trenAModificarNuevo);
										}
									}
								}
		
								FileUtiles.grabarTerminal(nuevaTerminal);
								System.out.println("°°El tren fue modificado con exito°°");
							}
							else {
								System.out.println("Ingrese un [INDICE] correcto...");
							}
						}
						else {
							System.out.println("No hay trenes cargados en la base de datos actual.");
						}
						break;
					case 4:
						if(nuevaTerminal.getListaDeTrenes().size() > 0) {
							for(int case3 = 0; case3 < nuevaTerminal.getListaDeTrenes().size(); case3++) {
								System.out.println("["+case3+"]"+nuevaTerminal.getListaDeTrenes().get(case3));
								System.out.println("\n");
							}
							System.out.println("Ingrese el [INDICE] del tren que quiere eliminar del sistema: ");
							try {
							indice=teclado.nextInt();
							}
							catch(InputMismatchException h) {
								System.out.println("Ingrese el tipo de dato correcto");
							}
							if(indice <= nuevaTerminal.getListaDeTrenes().size()){
								nuevaTerminal.getListaDeTrenes().remove(indice);
								for(HashMap.Entry<String, Cuenta> entry : nuevaTerminal.getMapDeCuentas().entrySet()) {
									for(int cont=0; cont < entry.getValue().getListaDeBoletos().size(); cont++) {
										if(entry.getValue().getListaDeBoletos().get(cont).getIndiceTren() == indice) {
											entry.getValue().getListaDeBoletos().get(cont).setVencido(true);
										}
									}		
								}
								FileUtiles.grabarTerminal(nuevaTerminal);
								System.out.println("°°El tren fue eliminado con exito°°");
							}
							else {
								System.out.println("Ingrese un [INDICE] correcto...");
							}
						}
						else {
							System.out.println("No hay trenes cargados en la base de datos actual");
						}
						break;
					case 0:
						break;
					default:
						System.out.println("Ingrese una opcion correcta!");
						break;
					}
				}
				break;
			case 3:
				while(subOpcion!=0)
				{
					System.out.println("---------- "+ "Menu Cuentas Registradas" + " ----------");
					System.out.println("1.Mostrar todas las cuentas por pantalla");
					System.out.println("2.Registrar una nueva cuenta");
					//System.out.println("\n3.Editar datos de una cuenta"); Para respetar la privacidad del usuario se prescinde de la opcion
					System.out.println("3.Dar de baja una cuenta");
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
						if(nuevaTerminal.getMapDeCuentas().size() > 0) {
							System.out.println("---------- "+ "Lista de Cuentas" + " ----------");
							System.out.println(nuevaTerminal.getMapDeCuentas());
						}
						else {
							System.out.println("No hay cuentas cargadas en la base de datos actual.");
						}
						break;
					case 2:
						nuevaTerminal.registrarCuenta();
						FileUtiles.grabarTerminal(nuevaTerminal);
						System.out.println("°°La cuenta fue registrada con exito°°");
						break;
					case 3:
						if(nuevaTerminal.getMapDeCuentas().size() > 0) {
							System.out.println("Ingrese el nombre de usuario de la cuenta que desea eliminar:");
							buscado=teclado.next();
							nuevaTerminal.getAdmin().eliminarCuenta(nuevaTerminal.getMapDeCuentas(), buscado);
							FileUtiles.grabarTerminal(nuevaTerminal);
						}
						else {
							System.out.println("No hay cuentas cargadas en la base de datos actual.");
						}
						break;
					case 0:
						break;
					default:
						System.out.println("Ingrese una opcion correcta!");
						break;
					}
				}
				break;
			case 4:
				while(subOpcion!=0)
				{
					Destino destinoActual = new Destino();
					Destino destinoNuevo = new Destino();
					System.out.println("---------- "+ "Menu Destinos" + " ----------");
					System.out.println("1.Mostrar todos los destinos por pantalla");
					System.out.println("2.Agregar un nuevo destino");
					System.out.println("3.Modificar un destino");
					System.out.println("4.Eliminar un destino");
					System.out.println("\n0.Atras");
					subOpcion=teclado.nextInt();
					int buscado=0;
					boolean exito=false;
					switch(subOpcion)
					{
					case 1:
						if(nuevaTerminal.getListaDeDestinos().size() > 0) {
							System.out.println(nuevaTerminal.getListaDeDestinos());
						}
						else {
							System.out.println("No hay destinos cargados en la base de datos actual");
						}
						break;
					case 2:
						Destino nuevo=new Destino();
						System.out.println("---------- "+ "Menu Alta de Destino" + " ----------");
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
						
						if(nuevaTerminal.getListaDeDestinos().contains(nuevo)) {
							System.out.println("Este destino ya se encuentra cargado.");
						}
						else {
							nuevaTerminal.getListaDeDestinos().add(nuevo);
							FileUtiles.grabarTerminal(nuevaTerminal);
							System.out.println("°°El destino fue creado con exito°°");
						}
						
						break;
					case 3:
						if(nuevaTerminal.getListaDeDestinos().size() > 0) {
							for(int case3 = 0; case3 < nuevaTerminal.getListaDeDestinos().size(); case3++) {
								System.out.println("["+case3+"]"+nuevaTerminal.getListaDeDestinos().get(case3));
								System.out.println("\n");
							}
							System.out.println("Ingrese el [INDICE] del destino que quiere modificar");
							try {
							buscado=teclado.nextInt();
							}
							catch(InputMismatchException e) {
								System.out.println("Ingrese un tipo de dato correcto");
							}
							if(buscado <= nuevaTerminal.getListaDeDestinos().size() - 1) {
								destinoActual = nuevaTerminal.getListaDeDestinos().get(buscado);
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
								
								destinoNuevo = nuevaTerminal.getListaDeDestinos().get(buscado);
								
								for(HashMap.Entry<String, Cuenta> entry : nuevaTerminal.getMapDeCuentas().entrySet()) {
									for(int i = 0; i < entry.getValue().getListaDeBoletos().size(); i++) {
										if(entry.getValue().getListaDeBoletos().get(i).getDestinoDelViaje().equals(destinoActual)) {
											entry.getValue().getListaDeBoletos().get(i).setDestinoDelViaje(destinoNuevo);
										}
									}
								}
								
								FileUtiles.grabarTerminal(nuevaTerminal);
								System.out.println("°°El destino fue modificado con exito°°");
							}
							else {
								System.out.println("Ingrese un [INDICE] correcto...");
							}
						}
						else {
							System.out.println("No hay destinos cargados en la base de datos actual");
						}
						break;
					case 4:
						if(nuevaTerminal.getListaDeDestinos().size() > 0) {
							for(int i = 0; i < nuevaTerminal.getListaDeDestinos().size(); i++) {
								System.out.println("["+i+"]"+nuevaTerminal.getListaDeDestinos().get(i));
							}
							
							System.out.println("Ingrese el [INDICE] del destino que quiere eliminar: ");
							try
							{
								buscado=teclado.nextInt();
							}
							catch(InputMismatchException e) {
								System.out.println("Ingrese un tipo de dato correcto");
							}
							if(buscado <= nuevaTerminal.getListaDeDestinos().size() - 1) {
								nuevaTerminal.getListaDeDestinos().remove(buscado);
								FileUtiles.grabarTerminal(nuevaTerminal);
								System.out.println("°°El destino fue eliminado con exito°°");	
							}
							else {
								System.out.println("Elija un [INDICE] correcto...");
							}
						}
						else {
							System.out.println("No hay destinos cargados en la base de datos actual");
						}
						break;
					case 0:
						break;
					default:
						System.out.println("Ingrese una opcion correcta!");
						break;
					}
				}
				break;
			case 5:
				System.out.println("---------- "+ "Menu JSON" + " ----------");
				System.out.println("Que desea exportar a .json?");
				System.out.println("1.Trenes");
				System.out.println("2.Cuentas");
				System.out.println("\n0.Salir");
				try {
					opcionJson = teclado.nextInt();
					switch(opcionJson) {
					case 1:
						nuevaTerminal.getAdmin().exportarFileJsonDeTrenes(nuevaTerminal.getListaDeTrenes());
						FileUtiles.grabarTerminal(nuevaTerminal);
						System.out.println("Archivo de trenes creado satisfactoriamente.");
						break;
					case 2:
						nuevaTerminal.getAdmin().exportarFileJsonDeCuentas(nuevaTerminal.getMapDeCuentas());
						FileUtiles.grabarTerminal(nuevaTerminal);
						System.out.println("Archivo de cuentas creado satisfactoriamente.");
						break;
					case 0:
						break;
					default:
						System.out.println("Debe elegir una opcion correcta.");
					}
				}
				catch(InputMismatchException h) {
					System.out.println("Ingrese el tipo de dato correcto");
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
	
	public void menuMain() throws TerminalException
	{
		Terminal nuevaTerminal = new Terminal();
		Scanner teclado=new Scanner(System.in);
		int opcion=1;
		while(opcion!=0)
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
			System.out.println("\n0.Salir");
			try {
				opcion = teclado.nextInt();
			}
			catch(InputMismatchException e) {
				System.out.println("\nIngrese una opcion correcta!");
			}
			switch(opcion) {
			case 1:
				nuevaTerminal.login();
				break;
			case 2:
				nuevaTerminal.registrarCuenta();
				FileUtiles.grabarTerminal(nuevaTerminal);
				break;
			case 0:
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
		int opcion=1, opcionSaldo;
		while(opcion!=0)
		{
			opcionSaldo=1;
			nuevaTerminal = FileUtiles.leerTerminal();
			
			System.out.println("---------- "+ "Menu Cuenta" + " ----------");
			System.out.println("Hola "+cuentaIngresada.getUser()+"!, que deseas hacer?...\n");
			System.out.println("1.Comprar un Boleto");
			System.out.println("2.Saldo");
			System.out.println("3.Boletos");
			System.out.println("4.Ver Datos");
			System.out.println("5.Actualizar Datos");
			System.out.println("\n0.Cerrar sesion");
			
			opcion = teclado.nextInt();
			switch(opcion) {
			case 1:
				nuevaTerminal = FileUtiles.leerTerminal();
				nuevaTerminal.setRecaudacion(nuevaTerminal.getMapDeCuentas().get(cuentaIngresada.getUser()).sacarBoleto(nuevaTerminal.getListaDeTrenes(), nuevaTerminal.getListaDeDestinos()));
				FileUtiles.grabarTerminal(nuevaTerminal);
				break;
			case 2:
				while(opcionSaldo!=0) {
					nuevaTerminal = FileUtiles.leerTerminal();
					System.out.println("---------- "+ "Menu Saldo" + " ----------");
					System.out.println("1.Ver saldo");
					System.out.println("2.Cargar saldo");
					System.out.println("\n0.Salir");
					opcionSaldo=teclado.nextInt();
					switch(opcionSaldo) {
					case 1:
						System.out.println("Su saldo es de $"+nuevaTerminal.getMapDeCuentas().get(cuentaIngresada.getUser()).getSaldo());
						break;
					case 2:
						nuevaTerminal.getMapDeCuentas().get(cuentaIngresada.getUser()).agregarSaldo();
						FileUtiles.grabarTerminal(nuevaTerminal);
						break;
					case 0:
						break;
					default:
						System.out.println("Ingrese una opcion valida.");
						break;
					}					
				}
				break;
			case 3:
				nuevaTerminal = FileUtiles.leerTerminal();
				if(nuevaTerminal.getMapDeCuentas().get(cuentaIngresada.getUser()).getListaDeBoletos().size() > 0) {
					System.out.println("---------- "+ "Menu Boletos de Cuenta" + " ----------");
					System.out.println(nuevaTerminal.getMapDeCuentas().get(cuentaIngresada.getUser()).mostrarListaDeBoletos());					
				}
				else {
					System.out.println("No tiene boletos comprados por el momento.");
				}
				break;
			case 4:
				System.out.println("---------- "+ "Datos de la Cuenta" + " ----------");
				System.out.println(nuevaTerminal.getMapDeCuentas().get(cuentaIngresada.getUser()).toString());
				break;
			case 5:
				nuevaTerminal = FileUtiles.leerTerminal();
				System.out.println("---------- "+ "Modificacion de Datos de la Cuenta" + " ----------");
				nuevaTerminal.getMapDeCuentas().get(cuentaIngresada.getUser()).cambiarDatosDeUsuario();
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

	public void visualMenuUsuarioPro(CuentaPro cuentaIngresada)
	{
		Terminal nuevaTerminal = new Terminal();
		Scanner teclado=new Scanner(System.in);
		int opcion=1, opcionSaldo;
		while(opcion!=0)
		{
			opcionSaldo=1;
			nuevaTerminal = FileUtiles.leerTerminal();
			
			System.out.println("---------- "+ "Menu Cuenta" + " ----------");
			System.out.println("Hola "+cuentaIngresada.getUser()+"!, que deseas hacer?...\n");
			System.out.println("1.Comprar un Boleto");
			System.out.println("2.Saldo");
			System.out.println("3.Boletos");
			System.out.println("4.Ver Datos");
			System.out.println("5.Actualizar Datos");
			System.out.println("6.Kilometros Ganados");
			System.out.println("\n0.Cerrar sesion");
			
			opcion = teclado.nextInt();
			switch(opcion) {
			case 1:
				nuevaTerminal = FileUtiles.leerTerminal();
				nuevaTerminal.setRecaudacion(nuevaTerminal.getMapDeCuentas().get(cuentaIngresada.getUser()).sacarBoleto(nuevaTerminal.getListaDeTrenes(), nuevaTerminal.getListaDeDestinos()));
				FileUtiles.grabarTerminal(nuevaTerminal);
				break;
			case 2:
				while(opcionSaldo!=0) {
					nuevaTerminal = FileUtiles.leerTerminal();
					System.out.println("---------- "+ "Menu Saldo" + " ----------");
					System.out.println("1.Ver saldo");
					System.out.println("2.Cargar saldo");
					System.out.println("\n0.Salir");
					opcionSaldo=teclado.nextInt();
					switch(opcionSaldo) {
					case 1:
						System.out.println("Su saldo es de $"+nuevaTerminal.getMapDeCuentas().get(cuentaIngresada.getUser()).getSaldo());
						break;
					case 2:
						nuevaTerminal.getMapDeCuentas().get(cuentaIngresada.getUser()).agregarSaldo();
						FileUtiles.grabarTerminal(nuevaTerminal);
						break;
					case 0:
						break;
					default:
						System.out.println("Ingrese una opcion valida.");
						break;
					}					
				}
				break;
			case 3:
				nuevaTerminal = FileUtiles.leerTerminal();
				if(nuevaTerminal.getMapDeCuentas().get(cuentaIngresada.getUser()).getListaDeBoletos().size() > 0) {
					System.out.println("---------- "+ "Menu Boletos de Cuenta" + " ----------");
					System.out.println(nuevaTerminal.getMapDeCuentas().get(cuentaIngresada.getUser()).mostrarListaDeBoletos());					
				}
				else {
					System.out.println("No tiene boletos comprados por el momento.");
				}
				break;
			case 4:
				System.out.println("---------- "+ "Datos de la Cuenta" + " ----------");
				System.out.println(nuevaTerminal.getMapDeCuentas().get(cuentaIngresada.getUser()).toString());
				break;
			case 5:
				nuevaTerminal = FileUtiles.leerTerminal();
				System.out.println("---------- "+ "Modificacion de Datos de la Cuenta" + " ----------");
				nuevaTerminal.getMapDeCuentas().get(cuentaIngresada.getUser()).cambiarDatosDeUsuario();
				FileUtiles.grabarTerminal(nuevaTerminal);
				break;
			case 6:
				nuevaTerminal = FileUtiles.leerTerminal();
				System.out.println("---------- "+ "Menu Kilometros Ganados" + " ----------");
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
