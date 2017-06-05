package Models;

import java.util.Date;

public class Vehiculo {
	//ATRIBUTOS
	protected Date FechaEntrada;
	protected Date FechaSalida;
	protected String matricula;
	protected double dinero;
	
	// CONSTRUCTOR 
	public Vehiculo(Date fechaEntrada, String matricula) {
		super();
		this.FechaEntrada = fechaEntrada;
		this.matricula = matricula;
		this.dinero= setDinero(dinero);
		this.FechaSalida=setFechaSalida(FechaSalida);
		
	}
// GETTERS AND SETTERS

	public Date getFechaEntrada() {
		return FechaEntrada;
	}


	public void setFechaEntrada(Date fechaEntrada) {
		FechaEntrada = fechaEntrada;
	}


	public Date getFechaSalida() {
		return FechaSalida;
	}


	public Date setFechaSalida(Date fechaSalida) {
		return FechaSalida = fechaSalida;
	}


	public String getMatricula() {
		return matricula;
	}


	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}


	public double getDinero() {
		return dinero;
	}


	public double setDinero(double dinero2) {
		return this.dinero = dinero2;
	}
	
	

}

