package app;

public class Menu {

	public void visualMenuAdmin()
	{
		System.out.println("1.Administrar terminal");
		System.out.println("2.Administrar trenes");
		System.out.println("3.Administrar cuentas");
		System.out.println("0.Salir");
	}
	
	public void visualMenuAdminSub1()
	{
		System.out.println("1.Mostrar todas las terminales por pantalla");
		System.out.println("2.Agregar una nueva terminal");
		System.out.println("3.Editar una terminal");
		System.out.println("4.Eliminar una terminal");
		System.out.println("0.Atras");
	}
	
	public void visualMenuAdminSub2()
	{
		System.out.println("1.Mostrar todos los trenes por pantalla");
		System.out.println("2.Dar de alta un nuevo tren");
		System.out.println("3.Modificar un tren");
		System.out.println("4.Dar de baja un tren");
		System.out.println("0.Atras");
	}
	
	public void visualMenuAdminSub3()
	{
		System.out.println("1.Mostrar todas las cuentas por pantalla");
		System.out.println("2.Registrar una nueva cuenta");
		System.out.println("3.Editar datos de una cuenta");
		System.out.println("4.Dar de baja una cuenta");
		System.out.println("0.Atras");
	}
	
	public void visualMenuUsuario()
	{
		System.out.println("1.Comprar un nuevo viaje");
		System.out.println("2.Saldo");
		System.out.println("3.Historial de viajes");
		System.out.println("0.Salir");
	}
}
