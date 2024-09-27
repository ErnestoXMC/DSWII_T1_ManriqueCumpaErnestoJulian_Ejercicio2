package main;

import java.util.Scanner;

import controller.FileController;

public class Main {
	static Scanner sc = new Scanner(System.in);	


	public static void main(String[] args) {

	    String folderPath = "C:\\Cibertec\\6toCiclo\\DSWII/";
	    FileController controller = new FileController(folderPath);

	    System.out.println("----MANEJO-DE-ARCHIVOS----");
	    boolean salir = false;
	    int opcion;

	    do {
	        System.out.println("1. Procesar cuentas del archivo JSON");
	        System.out.println("2. Salir");
	        System.out.println("Escribe una de las opcione: ");
	        opcion = sc.nextInt();
	        
	        switch (opcion) {
	            case 1:
	                System.out.println("Procesando cuentas del archivo JSON...");
	                controller.processAccountsFromJSON(folderPath + "/cuentasExamen.json");
	                break;
	            case 2:
	                System.out.println("Gracias!");
	                salir = true;
	                break;
	            default:
	                System.out.println("Solo números entre 1 y 2");
	        }
	    } while (!salir);
	}


}
