package Models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

@SuppressWarnings("serial")
public class ListaOrdenada<E> extends ArrayList<E> {

	// Dlecaracion de constantes y variables

	private Comparator<E> comp;

	public ListaOrdenada(Comparator<E> comp) {
		super();
		this.comp = comp;
	}

	// Sobreescribimos los metodos necesarios para nuestro comportamiento
	/**
	 * Añadimos un elemento y ordenamos despues.
	 */
	@Override
	public boolean add(E element) {
		boolean a;
		a = super.add(element);
		Collections.sort(this, comp);
		return a;

	}

	/**
	 * Añadimos una coleccion y ordenamos.
	 */
	@Override
	public boolean addAll(Collection<? extends E> collection) {

		boolean e;
		e = super.addAll(collection);
		Collections.sort(this, comp);
		return e;

	}

	/**
	 * Añade un objeto en un indice concreto y ordena la lista despues
	 */
	@Override
	public void add(int index, E element) {

		super.add(index, element);
		Collections.sort(this, comp);
	}

	/**
	 * Añade una coleccion a partir de un indice concreto y ordena despues
	 */
	@Override
	public boolean addAll(int index, Collection<? extends E> c)  {
		boolean i;
				i=super.addAll(index, c);
				Collections.sort(this, comp);
				return i;
				
	}

}