package clases;

public class Cerveza extends Articulo implements Alcoholico{
	
	//ATRIBUTOS
	private String origen;
	private String cereales;
	private double gradosAlcohol;
	
	//CONSTRUCTOR
	public Cerveza() {}
	
	public Cerveza(String code, String name, String mark, int capacidadBotella, double precio, int stock, String origen, String cereales, double gradosAlcohol) {
		super(code, name, mark, capacidadBotella, precio, stock);
		this.origen = origen;
		this.cereales = cereales;
		this.gradosAlcohol = gradosAlcohol;
	}

	//METODOS
	@Override
	public void visualizarArticulo() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean saludable() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void precioTotal() {
		// TODO Auto-generated method stub
		
	}
	
	//METODOS FROM ALCOHOLICO
	public boolean esFuerte() {
			
	}
		
	public double calcularTasa() {
			
	}
	
	//GETTERS / SETTERS
	public String getOrigen() {
		return origen;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	public String getCereales() {
		return cereales;
	}
	public void setCereales(String cereales) {
		this.cereales = cereales;
	}
	public double getGradosAlcohol() {
		return gradosAlcohol;
	}
	public void setGradosAlcohol(double gradosAlcohol) {
		this.gradosAlcohol = gradosAlcohol;
	}
	
}
