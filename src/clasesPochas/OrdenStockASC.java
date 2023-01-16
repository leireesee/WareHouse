package clasesPochas;

import java.util.Comparator;

import clases.Articulo;

public class OrdenStockASC implements Comparator<Articulo>{

	@Override
	public int compare(Articulo o1, Articulo o2) {
		// TODO Auto-generated method stub
		return o1.getStock() - o2.getStock();
	}

}
