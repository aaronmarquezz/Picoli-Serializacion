package modelo;

import java.io.Serializable;
import java.util.ArrayList;

public class SectorNoPrioritario<T extends Ser> extends Sector<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	public SectorNoPrioritario(TipoPago tipo) {
			super(tipo.getNecesidadVital(),tipo.getPago(), tipo.getReduccionMaxima(),new ArrayList<T>());
	}

	@Override
	public T getFirst() {
		return ((ArrayList<T>)getMiembros()).getFirst();
	}

	@Override
	public void addLast(T t) {
		((ArrayList<T>)getMiembros()).addLast(t);
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}

}
