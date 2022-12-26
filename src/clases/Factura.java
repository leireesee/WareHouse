package clases;

import java.security.PublicKey;
import java.util.Date;

public class Factura {
	
	//VARIABLES
	private static final int IVA = 21;
	private int numero;
	private String nombreEmpresa;
	private Date fecha;
	private String concepto;
	
	//CONSTRUCTOR
	public Factura() {}
	
	public Factura(final int IVA, int numero, String nombreEmpresa, Date fecha, String concepto) {
		this.numero = numero;
		this.nombreEmpresa = nombreEmpresa;
		this.fecha = fecha;
		this.concepto = concepto;
	}
	
	//METODOS
	public void addLinea(LineaFactura lineaFactura) {
		
	}
	
	public void eliminarLinea(int numeroLinea) {
		
	}

	public double precioTotal() {
		
	}
	
	public void mostrarEnPantalla() {
		
	}
	
	public void guardarEnFichero() {
		
	}
	
	//GETTERS / SETTERS
	public static int getIva() {
		return IVA;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getNombreEmpresa() {
		return nombreEmpresa;
	}
	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getConcepto() {
		return concepto;
	}
	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}
	
	
	
}
