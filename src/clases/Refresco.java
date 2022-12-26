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
	public void visualizarPropiedades() {
		
	}
	
	public boolean esSaludable() {
		
	}
	
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
