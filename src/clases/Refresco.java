package clases;

public class Refresco extends Articulo{
	
	//ATRIBUTOS
	private String sabor;
	private boolean zumo;
	private boolean gaseoso;
	private int cantidadAzucar;
	
	//CONSTRUCTORES
	public Refresco() {}
	
	public Refresco(String code, String name, String mark, int capacidadBotella, double precio, int stock, String sabor, boolean zumo, boolean gaseoso, int cantidadAzucar) {
		super(code, name, mark, capacidadBotella, precio, stock);
		this.sabor = sabor;
		this.zumo = zumo;
		this.gaseoso = gaseoso;
		this.cantidadAzucar = cantidadAzucar;
	}
	
	
	
	//METODOS
	
	@Override
	public String toString() {
		return code + ";" + name + ";" + mark + ";" + capacidadBotella + ";" + precio + ";" + stock + ";" + sabor + ";" + zumo + ";" + gaseoso + ";" + cantidadAzucar;
	}

	@Override
	public void visualizarArticulo() {
		// TODO Auto-generated method stub
		System.out.println("code -> " + super.code + ", name -> " + super.name + ", mark -> " + super.mark + ", capacidadBotella -> "
				+ super.capacidadBotella + ", precio -> " + super.precio + ", stock -> " + super.stock + "sabor -> " + sabor + ", zumo -> " + zumo + ", gaseoso -> " + gaseoso + ", cantidadAzucar -> "
				+ cantidadAzucar);
	}

	@Override
	public boolean saludable() {
		// TODO Auto-generated method stub
		if (cantidadAzucar < 20) {
			return true;
		}
		return false;
	}

	@Override
	public double precioTotal() {
		// TODO Auto-generated method stub
		return precio + precio * 0.21;
	}
	
	//GETTERS / SETTERS
	
	public String getSaborString() {
		return sabor;
	}
	public void setSaborString(String saborString) {
		this.sabor = saborString;
	}
	public boolean isZumo() {
		return zumo;
	}
	public void setZumo(boolean zumo) {
		this.zumo = zumo;
	}
	public boolean isGaseoso() {
		return gaseoso;
	}
	public void setGaseoso(boolean gaseoso) {
		this.gaseoso = gaseoso;
	}
	public int getCantidadAzucar() {
		return cantidadAzucar;
	}
	public void setCantidadAzucar(int cantidadAzucar) {
		this.cantidadAzucar = cantidadAzucar;
	}

}
