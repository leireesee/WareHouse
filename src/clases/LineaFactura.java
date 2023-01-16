package clases;

public class LineaFactura {
	
	//ATRIBUTOS
	private int numero;
	private Articulo articulo;
	private int cantidad;
	
	//CONSTRUCTOR
	public LineaFactura () {}
	
	public LineaFactura(int numero, Articulo articulo, int cantidad) {
		this.numero = numero;
		this.articulo = articulo;
		this.cantidad = cantidad;
	}
	
	//METODOS
	public double precioTotal() {
		return articulo.precioTotal() * cantidad;
	}
	
	//GETTERS / SETTERS
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public Articulo getArticulo() {
		return articulo;
	}
	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
}
