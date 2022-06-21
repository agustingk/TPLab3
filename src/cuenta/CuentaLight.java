package cuenta;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import app.Boleto;
import app.Destino;
import tren.Tren;

////Esta cuenta vendria a ser la "estandar"
public class CuentaLight extends Cuenta {

	public CuentaLight() {
		super();
	}

	public CuentaLight(String nombre, String apellido, int edad, String user, String pass, char genero, String dni) {
		super(nombre, apellido, edad, user, pass, genero, dni);
	}

	@Override
	public double sacarBoleto(ArrayList<Tren> trenes, ArrayList<Destino> destinos) {/// Resta el costo del Boleto normalmente.
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void agregarSaldo() {
		int saldo=0;
		Scanner scan = new Scanner(System.in);
		System.out.println("Ingrese saldo a depositar: ");
		try {
			saldo = scan.nextInt();			
		}
		catch(InputMismatchException e) {
			System.out.println("Ingrese un dato correcto!");
		}
		
		this.setSaldo(this.getEdad() + saldo);
	}

}
