package app;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;



public class FileUtiles {
	
	public static void grabarTerminal(Terminal terminal) {
		DataOutputStream dataOutputStream = null;
		try {
			FileOutputStream fileOutputStream = new FileOutputStream("terminal.bin"); //bytes
			
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			
			objectOutputStream.writeObject(terminal);
			
			objectOutputStream.close();
		}
		
		catch (ClassCastException e)
		{
			System.out.println("Clase incorrecta");
		}
		catch (EOFException e) 
		{
			System.out.println("FIN de archivo");
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Terminal leerTerminal() {
		Terminal contenido = new Terminal();
		DataInputStream dataInputStream = null;
		
		try {
			FileInputStream fileInputStream = new FileInputStream("terminal.bin");
			
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
			
			int lectura = 1;
			
			while (lectura == 1)
			{
				Terminal terminal = (Terminal)objectInputStream.readObject();
				contenido = terminal;
			}
			
			objectInputStream.close();
		}
		
		catch (ClassCastException e)
		{
			System.out.println("Clase incorrecta");
		}
		catch (EOFException e) 
		{
			//System.out.println("FIN de archivo");
		}
		catch (FileNotFoundException e)/// si el archivo no se encuentra, lo crea con una terminal VACIA.
		{
			Terminal terminalVacia = new Terminal();
			FileUtiles.grabarTerminal(terminalVacia);
			//e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return contenido;
	}
}
