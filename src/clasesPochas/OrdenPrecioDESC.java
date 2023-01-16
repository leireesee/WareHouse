package clasesPochas;

import java.util.Comparator;

import clases.Articulo;

public class OrdenPrecioDESC implements Comparator<Articulo>{

	@Override
	public int compare(Articulo o1, Articulo o2) {
		// TODO Auto-generated method stub
		if (o1.getPrecio() < o2.getPrecio()) {
			return 1;
		}
		return -1;
	}
	
}
