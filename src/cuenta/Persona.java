package cuenta;

public abstract class Persona {
	private int edad;
	private String dni;
	private String nombre;
	private String apellido;
	private char genero;///m o f
	
	public Persona() {
		
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

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

}
