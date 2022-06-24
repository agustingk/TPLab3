package tren;

import java.io.Serializable;

import org.json.JSONException;
import org.json.JSONObject;

import Inter.Jsoneable;

///Simple clase Tren que tiene un nombre de modelo, a�o de fabricacion, distancia maxima posible y un estado "enViaje" que se modifica por la CuentaAdmin cuando se inicia un viaje con el mismo.
public class Tren implements Serializable, Jsoneable{
	private String modelo;
	private int precioPorKilometro;
	private int anioFabricacion;
	private double distanciaMaxima;
	private boolean enViaje;

	public Tren() {
		///
	}

	public Tren(String modelo, int anioFabricacion, double distanciaMaxima, int precioPorKilometro){
		this.precioPorKilometro = precioPorKilometro;
		this.anioFabricacion = anioFabricacion;
		this.modelo = modelo;
		this.distanciaMaxima = distanciaMaxima;
		this.enViaje = false;
	}

	public int getPrecioPorKilometro() {
		return precioPorKilometro;
	}

	public void setPrecioPorKilometro(int precioPorKilometro) {
		this.precioPorKilometro = precioPorKilometro;
	}

	public void setDistanciaMaxima(double distanciaMaxima) {
		this.distanciaMaxima = distanciaMaxima;
	}
	
	@Override
	public String toString() {
		return getClass().getName() + " {\n\tmodelo: " + modelo + "\n\tprecioPorKilometro: " + precioPorKilometro
				+ "\n\tanioFabricacion: " + anioFabricacion + "\n\tdistanciaMaxima: " + distanciaMaxima
				+ "\n\tenViaje: " + enViaje + "\n}";
	}

	public void setEnViaje(boolean enViaje) {
		this.enViaje = enViaje;
	}

	public boolean getEnViaje() {
		return this.enViaje;
	}
	
	public String getModelo() {
		return this.modelo;
	}

	public int getAnioFabricacion() {
		return anioFabricacion;
	}

	public void setAnioFabricacion(int anioFabricacion) {
		this.anioFabricacion = anioFabricacion;
	}

	public double getDistanciaMaxima() {
		return distanciaMaxima;
	}

	public void setDistanciaMaxima(int distanciaMaxima) {
		this.distanciaMaxima = distanciaMaxima;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	@Override
	public boolean equals(Object obj) {
		Tren nuevoTren = (Tren)obj;
		if(nuevoTren.getModelo().equals(this.getModelo()) && nuevoTren.getAnioFabricacion() == this.getAnioFabricacion()) {
			return true;
		}
		else {
			return false;
		}
			
	}

	@Override
	public JSONObject toJson() {
		JSONObject nuevoTren = new JSONObject();
		try {
			nuevoTren.put("modelo", this.modelo);
			nuevoTren.put("anioDeFabricacion", this.anioFabricacion);
			nuevoTren.put("distanciaMaxima", this.distanciaMaxima);
			nuevoTren.put("enViaje", this.enViaje);
		} catch (JSONException e) {	
			e.printStackTrace();
		}
		return nuevoTren;
	}
	
}
