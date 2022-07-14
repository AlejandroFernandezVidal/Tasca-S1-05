package n1exercici5;

import java.io.Serializable;

public class Coche implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Atributos
	private String marca;
	private String modelo;
	private double cilindrada;
	
	//Constructor
	public Coche(String marca, String modelo, double cilindrada) {
		this.marca = marca;
		this.modelo = modelo;
		this.cilindrada = cilindrada;
	}
	//Getter
	public String getMarca() {
		return this.marca;
	}
	public String getModelo() {
		return this.modelo;
	}
	public double getCilindrada() {
		return this.cilindrada;
	}
	//Setter
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public void setCilindrada(double cilindrada) {
		this.cilindrada = cilindrada;
	}
	@Override
	public String toString() {
		return this.marca+ " "+ this.modelo + " " + this.cilindrada;	
	}
}