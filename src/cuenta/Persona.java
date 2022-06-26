package cuenta;

import java.io.Serializable;

public abstract class Persona implements Serializable{
	private int edad;
	private String dni;
	private String nombre;
	private String apellido;
	private char genero;/// m o f

	public Persona() {
		///
	}

	public Persona(String nombre, String apellido, int edad, char genero, String dni) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.genero = genero;
	}

	public int getEdad() {
		return edad;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public char getGenero() {
		return genero;
	}

	public void setGenero(char genero) {
		this.genero = genero;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String mostrarPersona() {
		return getClass().getName() + " {\n\tedad: " + edad + "\n\tdni: " + dni + "\n\tnombre: " + nombre
				+ "\n\tapellido: " + apellido + "\n\tgenero: " + genero + "\n}";
	}

}
