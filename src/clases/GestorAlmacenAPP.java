package clases;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class GestorAlmacenAPP {

	public void run() throws FileNotFoundException, ParseException {
		
		Scanner teclado = new Scanner(System.in); 
		
		Almacen almacen = new Almacen();
		almacen.cargarDatos();
		
		
		final int REALIZAR_VENTA = 1;
		final int REALIZAR_COMPRA = 2;
		final int ARTICULOS_SALUDABLES = 3;
		final int ARTICULO_MAS_CARO = 4;
		final int MENOS_STOCK_QUE = 5;
		final int SALIR = 0;
		
		final int AGREGAR_LINEA = 1;
		final int ELIMINAR_LINEA = 2;
		final int MOSTRAR_FACTURA = 3;
		final int GUARDAR_FACTURA = 4;
		final int SALIR2 = 0;

		Scanner scan = new Scanner(System.in);
		int opcion_menu;
		int opcion_menu2;

		do {
			System.out.println("------MENU-------");
			System.out.println(REALIZAR_VENTA + ". Realizar venta");
			System.out.println(REALIZAR_COMPRA + ". Realizar compra");
			System.out.println(ARTICULOS_SALUDABLES + ". Ver artículos saludables");
			System.out.println(ARTICULO_MAS_CARO + ". Ver artículo más caro");
			System.out.println(MENOS_STOCK_QUE + ". Ver artículos con menos stock que x");
			System.out.println(SALIR + ". Salir");
			System.out.println("Elije una de las opciones");
			opcion_menu = Integer.parseInt(scan.nextLine());

			switch (opcion_menu) {
			case REALIZAR_VENTA:
				System.out.println("Has seleccionado REALIZAR VENTA");
				//CREACION DE FACTURA
				Factura factura = new Factura();
				
				System.out.println("Introduce el numero de factura");
				int numeroFacturaIntroducido = Integer.parseInt(teclado.nextLine());
				
				System.out.println("Introduce el nombre de la empresa");
				String nombreEmpresaFacturaIntroducido = teclado.nextLine();
				
				System.out.println("Introduce la fecha");
				SimpleDateFormat formatoLectura1 = new SimpleDateFormat("dd.MM.yyyy");
				Date fechaLeida = formatoLectura1.parse(teclado.nextLine());

				System.out.println("Introduce el concepto");
				String conceptoFacturaIntroducido = teclado.nextLine();
				
				factura.setNumero(numeroFacturaIntroducido);
				factura.setNombreEmpresa(nombreEmpresaFacturaIntroducido);
				factura.setFecha(fechaLeida);
				factura.setConcepto(conceptoFacturaIntroducido);
				
				do {
					System.out.println("------MENU-------");
					System.out.println(AGREGAR_LINEA + ". Agregar linea");
					System.out.println(ELIMINAR_LINEA + ". Eliminar linea");
					System.out.println(MOSTRAR_FACTURA + ". Mostrar factura");
					System.out.println(GUARDAR_FACTURA + ". Guardar factura");
					System.out.println(SALIR + ". Salir");
					System.out.println("Elije una de las opciones");
					opcion_menu2 = Integer.parseInt(scan.nextLine());

					switch (opcion_menu2) {
					case AGREGAR_LINEA:
						System.out.println("Has elegido añadir una linea");
						LineaFactura lineaFactura = new LineaFactura();
												
						Articulo articulo = null;
						String codigoProducto;
						
						do {
							System.out.println("Introduce el código del artículo");
							codigoProducto = teclado.nextLine();
							
							articulo = almacen.buscarArticulo(codigoProducto);
							
							if (articulo == null) {
								System.out.println("El artículo no existe");
							}
							
						} while (articulo == null);
						
						
						int cantidad;
						boolean disponibilidad;
						
						do {
							System.out.println("Introduce la cantidad de artículos a vender");
							cantidad = Integer.parseInt(teclado.nextLine());
							
							disponibilidad = almacen.disponibilidad(cantidad, codigoProducto);
							
							if (!disponibilidad) {
								System.out.println("Stock insuficiente!");
							}
							
						} while (!disponibilidad);
						
						articulo.disminuirStock(cantidad);
												
						lineaFactura.setNumero(factura.lineasFactura.size() + 1);
						lineaFactura.setArticulo(articulo);
						lineaFactura.setCantidad(cantidad);
						
						factura.addLinea(lineaFactura);
						break;
					case ELIMINAR_LINEA:
						System.out.println("Has elegido eliminar una linea");
						System.out.println("Introduce el numero de la linea que quieres borrar");
						int numeroLinea = Integer.parseInt(teclado.nextLine());
						factura.eliminarLinea(numeroLinea);
						break;
					case MOSTRAR_FACTURA:
						System.out.println("Mostrando factura...");
						factura.mostrarEnPantalla();
						break;
					case GUARDAR_FACTURA:
						System.out.println("Guardando factura...");
						factura.guardarEnFichero();
						break;
					case SALIR:
						System.out.println("ADIOS");
						break;
					default:
						System.out.println("Opcion incorrecta!");
					}

				} while (opcion_menu2 != SALIR2);
				
				break;
			case REALIZAR_COMPRA:
				System.out.println("Has seleccionado REALIZAR COMPRA");
				System.out.println("Introduce el codigo del artículo");
				String codeIntroducido = teclado.nextLine();
				System.out.println("Introduce la cantidad a añadir de stock");
				int stockIntroducido = Integer.parseInt(teclado.nextLine());
				Articulo articuloIntroducido = almacen.buscarArticulo(codeIntroducido);
				if (articuloIntroducido != null) {
					articuloIntroducido.incrementarStock(stockIntroducido);
				}
				break;
			case ARTICULOS_SALUDABLES:
				System.out.println("Has seleccionado VER ARTÍCULOS SALUDABLES");
				for (Articulo articulo : almacen.articulos) {
					if (articulo.saludable()) {
						articulo.visualizarArticulo();
					}
				}
				break;
			case ARTICULO_MAS_CARO:
				System.out.println("Has seleccionado VER ARTÍCULO MÁS CARO");
				almacen.elMasCaro().visualizarArticulo();
				break;	
			case MENOS_STOCK_QUE:
				System.out.println("Has seleccionado VER ARTICULOS CON MENOS STOCK QUE X");
				System.out.println("Introduce una cantidad de stock");
				int stockComparar = Integer.parseInt(teclado.nextLine());
				for (Articulo articulo : almacen.articulos) {
					if (articulo.getStock() < stockComparar) {
						articulo.visualizarArticulo();
					}
				}
				break;		
			case SALIR:
				guardarDatos(almacen);
				System.out.println("ADIOS");
				break;
			default:
				System.out.println("Opcion incorrecta!");
			}

		} while (opcion_menu != SALIR);
		scan.close();
		
	}
	
	
	private void guardarDatos(Almacen almacen) throws FileNotFoundException {
		File file = new File("src/ficheros/datos.txt");
		PrintWriter writer = new PrintWriter(file);
		for (Articulo articulo : almacen.articulos) {
			writer.println(articulo);
		}
		
		writer.close();
	}

}
