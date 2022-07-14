package n1exercici4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Arrays;

public class ListaDirectorios {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File archivos = new File(args[0]);
		listarArbolDirectoriosGuardar(archivos);
		leerArchivoTxt(archivos);
	
	}
	public static void listarArbolDirectoriosGuardar(File archivos) {
		File[] listaDirectorios = archivos.listFiles();
		SimpleDateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");
		if (listaDirectorios != null) {
			Arrays.sort(listaDirectorios);
			for (File archivo : listaDirectorios)
				if (archivo.isFile()) {
					String archivoObtenido = archivo.getName() + " " + "F" + " " + fecha.format(archivo.lastModified());
					escribirEnArchivo(archivoObtenido);
				} else if (archivo.isDirectory()) {
					String archivoObtenido = archivo.getName() + " " + "D" + " " + fecha.format(archivo.lastModified());
					escribirEnArchivo(archivoObtenido);
					listarArbolDirectoriosGuardar(archivo);
				}

		} else {
			System.out.println("La ruta no es correcta");
		}
	}

	public static void escribirEnArchivo(String archivoObtenido) {
		try {
			File archivoWrite = new File("/Users/alexfernandez/eclipse-workspace/Tasca S1.05/src/registro.txt");
			FileWriter escribir = new FileWriter(archivoWrite.getAbsoluteFile(),true);
			escribir.write(archivoObtenido + "\n");
			escribir.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void leerArchivoTxt(File archivos) {
		try {
			FileReader archivoLeer = new FileReader(archivos);
			BufferedReader lectura = new BufferedReader(archivoLeer);
			String linea;
			while((linea = lectura.readLine()) != null && !linea.isEmpty()) {
				System.out.println(linea);
			}lectura.close();	
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}