package clasesPochas;

import java.util.Comparator;

import clases.Articulo;

public class OrdenStockDESC  implements Comparator<Articulo>{

	@Override
	public int compare(Articulo o1, Articulo o2) {
		// TODO Auto-generated method stub
		return o2.getStock() - o1.getStock();
	}

}
