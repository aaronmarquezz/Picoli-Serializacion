package modelo;

import java.io.Serializable;
import java.util.Comparator;


public class ComparatorSerializable implements Comparator<Adulto>, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	@Override
	public int compare(Adulto o1, Adulto o2) {
		return o1.getPeriodosEnEstado() - o2.getPeriodosEnEstado();

	}

}
