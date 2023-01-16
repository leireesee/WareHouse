package clases;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import clasesPochas.*;


public class Almacen {
	
	ArrayList<Articulo> articulos = new ArrayList<Articulo>();
	
	public void cargarDatos() throws FileNotFoundException {
		Scanner teclado = new Scanner(System.in);
		File file = new File("src/ficheros/datos.txt");
		Scanner sc = new Scanner(file);
		while (sc.hasNextLine()) {
			String linea[] = sc.nextLine().split(";");
			switch (linea[0].charAt(0)) {
			case '1': {
				Refresco refresco = new Refresco(linea[0], linea[1], linea[2], Integer.parseInt(linea[3]), Double.parseDouble(linea[4]), Integer.parseInt(linea[5]), linea[6], linea[7].equals("true") ? true : false, linea[8].equals("true") ? true : false, Integer.parseInt(linea[9]));
				
				articulos.add(refresco);
				
				break;
			}
			case '2': {
				Vino vino = new Vino(linea[0], linea[1], linea[2], Integer.parseInt(linea[3]), Double.parseDouble(linea[4]), Integer.parseInt(linea[5]), linea[6], linea[7], Integer.parseInt(linea[8]), linea[9], Double.parseDouble(linea[10]));
				
				articulos.add(vino);
				
				break;
			}
			case '3': {
				Cerveza cerveza = new Cerveza(linea[0], linea[1], linea[2], Integer.parseInt(linea[3]), Double.parseDouble(linea[4]), Integer.parseInt(linea[5]), linea[6], linea[7], Double.parseDouble(linea[8]));
				
				articulos.add(cerveza);
				
				break;
			}
			
			}
		}
	}
	
	public Articulo elMasCaro() {
		Articulo articulo = null;
		double articuloMasCaro = articulos.get(0).getPrecio(); 
		for (Articulo articuloRecorrido : articulos) {
			if (articuloRecorrido.getPrecio() > articuloMasCaro) {
				articuloMasCaro = articuloRecorrido.getPrecio();
				articulo = articuloRecorrido;
			}
		}
		
		return articulo;
		
	}
	
	public double precio(String codigoProducto) {
		Articulo articuloPrecio = buscarArticulo(codigoProducto);
		if (articuloPrecio != null) {
			return articuloPrecio.getPrecio();
		}
		
		return 0;
	}
	
	public boolean hayStock(String codigoProducto) {
		Articulo articuloStock = buscarArticulo(codigoProducto);
		if (articuloStock != null && articuloStock.getStock() > 0) {
			return true;
		}
		
		return false;
	}
	
	public ArrayList<Articulo> stockJusto(){
		ArrayList<Articulo> stockJustoArrayList = new ArrayList<>();
		for (Articulo articulo : articulos) {
			if (articulo.getStock() < 10) {
				stockJustoArrayList.add(articulo);
			}
		}
		
		return stockJustoArrayList;
	}
	
	public Articulo buscarArticulo(String codigoProducto) {
		for (Articulo articulo : articulos) {
			if (codigoProducto.equals(articulo.getCode())) {
				return articulo;
			}
		}
		return null;
	}
	
	public boolean disponibilidad(int cantidad, String codigoProducto) {
		Articulo articuloBuscado = buscarArticulo(codigoProducto);
		if (cantidad < articuloBuscado.getStock()) {
			return true;
		}
		
		return false;
	}
	
	public ArrayList<Articulo> equivalentes(Articulo articulo){
		ArrayList<Articulo> articulosEquivalentes = new ArrayList<>();
		double precioMax = articulo.getPrecio() + 0.20;
		double precioMin = articulo.getPrecio() - 0.20;
		for (Articulo articulo2 : articulosEquivalentes) {
			if (articulo2.getCode().charAt(0) == articulo.getCode().charAt(0)) {
				if (articulo2.getPrecio() > precioMin && articulo2.getPrecio() < precioMax) {
					articulosEquivalentes.add(articulo2);
				}
			}
		}
		return articulosEquivalentes;
	}
	
	public ArrayList<Articulo> ordenarPorPrecio(String orden){
		
		switch (orden) {
		case "DESC": {
			articulos.sort(new OrdenPrecioDESC());			
			break;
		}
		case "ASC": {
			articulos.sort(new OrdenPrecioASC());
			break;
		}
		
		}
		
		return articulos;
		
	}
	
	public void ordenarPorStock(String orden) {
		
		switch (orden) {
		case "DESC": {
			articulos.sort(new OrdenStockDESC());
			break;
		}
		case "ASC": {
			articulos.sort(new OrdenStockASC());
			break;
		}
		
		}
		
		for (Articulo articulo : articulos) {
			if (articulo instanceof Refresco) {
				((Refresco) articulo).visualizarArticulo();
			}
			if (articulo instanceof Vino) {
				((Vino) articulo).visualizarArticulo();
			}
			if (articulo instanceof Cerveza) {
				((Cerveza) articulo).visualizarArticulo();
			}
		}
		
	}

	public ArrayList<Articulo> getArticulos() {
		return articulos;
	}
	
	
}


	