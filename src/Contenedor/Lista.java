package Contenedor;

import java.util.ArrayList;

import Models.ListaOrdenada;
import Models.Vehiculo;

public class Lista {

	public static ListaOrdenada<Vehiculo> ListaVehiculo = new ListaOrdenada<Vehiculo>((Vehiculo a, Vehiculo b) -> b.getFechaEntrada().getHours() - a.getFechaEntrada().getHours());;
	

}
