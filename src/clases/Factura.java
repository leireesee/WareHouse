package clases;

import java.io.File;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class Factura {
	ArrayList<LineaFactura>lineasFactura = new ArrayList<>();
	
	//ATRIBUTOS
	private static final int IVA = 21;
	private int numero;
	private String nombreEmpresa;
	private Date fecha;
	private String concepto;
	
	
	private int numFichero = 1;
	
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
		lineasFactura.add(lineaFactura);
	}
	
	public void eliminarLinea(int numeroLinea) {
		Iterator<LineaFactura> it = lineasFactura.iterator();
		while (it.hasNext()) {
			LineaFactura lineaFactura = it.next();
			if (numeroLinea == lineaFactura.getNumero()) {
				it.remove();
			}
		}
	}

	public double precioTotal() {
		double precioTotalFactura = 0;
		for (LineaFactura lineaFactura : lineasFactura) {
			precioTotalFactura = precioTotalFactura + lineaFactura.precioTotal();
		}
		return precioTotalFactura;
	}
	
	public void mostrarEnPantalla() {
		System.out.println("-------------------------------FACTURA-------------------------------");
		System.out.println("Numero de factura: \t\t\t" + this.numero);
		System.out.println("Nombre de empresa: \t\t\t" + this.nombreEmpresa);
		System.out.println("Concepto de factura: \t\t\t" + this.concepto);
		System.out.println("Fecha: " + this.fecha != null ? new SimpleDateFormat("yyyy/MM/dd").format(this.fecha) : new Date());
		System.out.println(" ");
		System.out.println("\tNumero\t|\tCantidad\t|\tPrecio\t|\tArticulo\t");
		for (LineaFactura lineaFactura : lineasFactura) {
			System.out.println("\t" + lineaFactura.getNumero() + "\t\t"
					+ lineaFactura.getCantidad() + "\t\t\t" + new DecimalFormat("#.00").format(lineaFactura.precioTotal())  + 
					"\t\t\t" + lineaFactura.getArticulo().getName());
		}
		System.out.println("------------------------------------------------------------------------------------------------");
		System.out.println("Precio total: " + new DecimalFormat("#.00").format(precioTotal()));
	}
	
	public void guardarEnFichero() {
		String nombreFichero = generarNombreFichero();
		File file = new File("src/facturas/" + nombreFichero);
		
		if (file.exists()) {
			do {
				System.out.println("El archivo ya existe\nCambiando nombre...");
				nombreFichero = numFichero + "_" + (nombreFichero);
				numFichero ++;
			}while(new File("src/facturas/" + nombreFichero).exists());
			
		}
		
		try {
			PrintWriter pw = new PrintWriter("src/facturas/" + nombreFichero);
			pw.println("-------------------------------FACTURA-------------------------------");
			pw.println("Numero de factura: \t\t\t" + this.numero);
			pw.println("Nombre de empresa: \t\t\t" + this.nombreEmpresa);
			pw.println("Concepto de factura: \t\t\t" + this.concepto);
			pw.println("Fecha: " + this.fecha != null ? new SimpleDateFormat("yyyy/MM/dd").format(this.fecha) : new Date());
			pw.println("------------------------------------------------------------------------------------------------");
			pw.println("\tNumero\t|\tCantidad\t|\tPrecio Total\t|\tArticulo\t\t|");
			for (LineaFactura lineaFactura : lineasFactura) {
				pw.println("\t" + lineaFactura.getNumero() + "\t\t"
						+ lineaFactura.getCantidad() + "\t\t\t" + new DecimalFormat("#.00").format(lineaFactura.precioTotal()) + 
						"\t\t\t" + lineaFactura.getArticulo().getName());
			}
			pw.println("------------------------------------------------------------------------------------------------");
			pw.println("Precio total: " + new DecimalFormat("#.00").format(precioTotal()));
				
			pw.close();
			
		} catch (Exception e) {
			System.out.println("No se pudo crear el archivo");
		}
	}
	
	private String generarNombreFichero() {
		String nombreFichero = this.numero + "_" + (this.fecha != null ? new SimpleDateFormat("yyyy-MM-dd").format(this.fecha) 
				: new SimpleDateFormat("yyyy-MM-dd").format(new Date()))
				+ "_factura.txt";
		return nombreFichero;
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
