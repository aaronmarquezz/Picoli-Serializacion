package modelo;

import java.io.Serializable;
import java.util.PriorityQueue;

public class SectorPrioritario<T extends Adulto> extends Sector<T> implements Serializable{

	private static final long serialVersionUID = 1L;

	public SectorPrioritario(TipoPago tipo) {
		super(tipo.getNecesidadVital(), tipo.getPago(), tipo.getReduccionMaxima(),
				new PriorityQueue<T>(new ComparatorSerializable()));
	}

	@Override
	public T getFirst() {
		return ((PriorityQueue<T>) getMiembros()).poll();
	}

	@Override
	public void addLast(T t) {
		((PriorityQueue<T>) getMiembros()).offer(t);
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
