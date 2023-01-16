package clases;

public abstract class Articulo {
	
	//ATRIBUTOS
	protected String code;
	protected String name;
	protected String mark;
	protected int capacidadBotella;
	protected double precio;
	protected int stock;
	
	//CONSTRUCTOR
	public Articulo() {}
	
	public Articulo(String code, String name, String mark, int capacidadBotella, double precio, int stock) {
		this.code = code;
		this.name = name;
		this.mark = mark;
		this.capacidadBotella = capacidadBotella;
		this.precio = precio;
		this.stock = stock;
	}
	
	
	
	@Override
	public String toString() {
		return code + ";" + name + ";" + mark + ";" + capacidadBotella + ";" + precio + ";" + stock;
	}

	//METODOS
	public void incrementarStock(int cantidad) {
		stock = stock + cantidad;
	}
	
	public void disminuirStock(int cantidad) {
		stock = stock - cantidad;	
	}
	
	public abstract void visualizarArticulo();
	
	public abstract boolean saludable();
	
	public abstract double precioTotal();
	
	//GETTERS / SETTERS
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
	public int getCapacidadBotella() {
		return capacidadBotella;
	}
	public void setCapacidadBotella(int capacidadBotella) {
		this.capacidadBotella = capacidadBotella;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
}
