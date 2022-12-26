package clases;

public class LineaFactura {
	
	//ATRIBUTOS
	private int numero;
	private String articulo;
	private int cantidad;
	
	//CONSTRUCTOR
	public LineaFactura () {}
	
	public LineaFactura(int numero, String articulo, int cantidad) {
		this.numero = numero;
		this.articulo = articulo;
		this.cantidad = cantidad;
	}
	
	//METODOS
	public double precioTotal() {
		
	}
	
	//GETTERS / SETTERS
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getArticulo() {
		return articulo;
	}
	public void setArticulo(String articulo) {
		this.articulo = articulo;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
}
