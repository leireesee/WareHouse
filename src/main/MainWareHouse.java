package main;

import java.io.FileNotFoundException;
import java.text.ParseException;

import clases.GestorAlmacenAPP;

public class MainWareHouse {
	public static void main (String[] args) throws FileNotFoundException, ParseException {
		
		GestorAlmacenAPP gestorAlmacenAPP = new GestorAlmacenAPP();
		gestorAlmacenAPP.run();
		
	}
}
