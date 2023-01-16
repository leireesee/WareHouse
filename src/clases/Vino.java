package clases;

import interfaces.Alcoholico;

public class Vino extends Articulo implements Alcoholico{
	
	//ATRIBUTOS
	private String color;
	private String origen;
	private int anio;
	private String tipoDeUva;
	private double gradosAlcohol;
	
	//CONSTRUCTORES
	public Vino() {}
	
	public Vino(String code, String name, String mark, int capacidadBotella, double precio, int stock, String color, String origen, int anio, String tipoDeUva, double gradosAlcohol) {
		super(code, name, mark, capacidadBotella, precio, stock);
		this.color = color;
		this.origen = origen;
		this.anio = anio;
		this.tipoDeUva = tipoDeUva;
		this.gradosAlcohol = gradosAlcohol;
	}
	
	
	
	@Override
	public String toString() {
		return code + ";" + name + ";" + mark + ";" + capacidadBotella + ";" + precio + ";" + stock + ";" + color + ";" + origen + ";" + anio + ";" + tipoDeUva + ";" + gradosAlcohol;
	}

	//METODOS
	@Override
	public void visualizarArticulo() {
		// TODO Auto-generated method stub
		System.out.println("code -> " + super.code + ", name -> " + super.name + ", mark -> " + super.mark + ", capacidadBotella -> "
				+ super.capacidadBotella + ", precio -> " + super.precio + ", stock -> " + super.stock + "color -> " + color + ", origen -> " + origen + ", anio -> " + anio + ", tipoDeUva -> " + tipoDeUva
				+ ", gradosAlcohol -> " + gradosAlcohol);
	}

	@Override
	public boolean saludable() {
		// TODO Auto-generated method stub
		if (origen.equals("navarra")) {
			return true;
		}
		return false;
	}

	@Override
	public double precioTotal() {
		// TODO Auto-generated method stub
		return precio + precio * 0.21;
	}
	
	
	//METODOS FROM ALCOHOLICO
	@Override
	public boolean esFuerte() {
		// TODO Auto-generated method stub
		if (gradosAlcohol > 13.5) {
			return true;
		}
		return false;
	}

	@Override
	public double calcularTasa() {
		// TODO Auto-generated method stub
		return 0;
	}
	

	//GETTERS / SETTERS
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	public String getOrigen() {
		return origen;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	public int getAnio() {
		return anio;
	}
	public void setAnio(int anio) {
		this.anio = anio;
	}
	public String getTipoDeUva() {
		return tipoDeUva;
	}
	public void setTipoDeUva(String tipoDeUva) {
		this.tipoDeUva = tipoDeUva;
	}
	public double getGradosAlcohol() {
		return gradosAlcohol;
	}
	public void setGradosAlcohol(double gradosAlcohol) {
		this.gradosAlcohol = gradosAlcohol;
	}

	

}
