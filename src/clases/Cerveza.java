package clases;

import interfaces.Alcoholico;

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
	
	

	@Override
	public String toString() {
		return code + ";" + name + ";" + mark + ";" + capacidadBotella + ";" + precio + ";" + stock + ";" + origen + ";" + cereales + ";" + gradosAlcohol;
	}

	//METODOS
	@Override
	public void visualizarArticulo() {
		// TODO Auto-generated method stub
		System.out.println("code -> " + super.code + ", name -> " + super.name + ", mark -> " + super.mark + ", capacidadBotella -> "
				+ super.capacidadBotella + ", precio -> " + super.precio + ", stock -> " + super.stock + "origen -> " + origen + ", cereales -> " + cereales + ", gradosAlcohol -> " + gradosAlcohol);
	}
	
	@Override
	public boolean saludable() {
		// TODO Auto-generated method stub
		if (cereales.equals("lupulo")) {
			return true;
		}
		return false;
	}
	@Override
	public double precioTotal() {
		// TODO Auto-generated method stub
		return precio + precio * 0.21 + precio * calcularTasa() / 100; 
	}
	
	//METODOS FROM ALCOHOLICO
	@Override
	public boolean esFuerte() {
		// TODO Auto-generated method stub
		if (gradosAlcohol > 7) {
			return true;
		}
		return false;
	}

	@Override
	public double calcularTasa() {
		// TODO Auto-generated method stub
		if(esFuerte()) {
			return TASA_BEBIDAS_FUERTES;
		}
		return TASA_BEBIDAS_SUAVES;
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
