package n2exercici1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Properties;

public class ListaDirectorios {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
		Properties directorio = new Properties();
		directorio.load(new FileInputStream("/Users/alexfernandez/eclipse-workspace/Tasca S1.05/src/n2exercici1/n2exercici1.properties"));
		File archivos = new File(directorio.getProperty("DirectorioLectura"));
		listarArbolDirectoriosGuardar(archivos);
		}catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}

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
			Properties ruta = new Properties();
			ruta.load(new FileInputStream("/Users/alexfernandez/eclipse-workspace/Tasca S1.05/src/n2exercici1/n2exercici1.properties"));
			File archivoWrite = new File(ruta.getProperty("NombreyDirectorioTxt"));
			FileWriter escribir = new FileWriter(archivoWrite.getAbsoluteFile(),true);
			escribir.write(archivoObtenido + "\n");
			escribir.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}