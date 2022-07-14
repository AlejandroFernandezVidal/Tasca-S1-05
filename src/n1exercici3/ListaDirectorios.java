package n1exercici3;

import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Arrays;

public class ListaDirectorios {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File archivos = new File(args[0]);
		listarArbolDirectoriosGuardar(archivos);
	}

	public static void listarArbolDirectoriosGuardar(File archivos) {
		File[] listaDirectorios = archivos.listFiles();
		SimpleDateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");
		if (listaDirectorios != null) {
			Arrays.sort(listaDirectorios);
			for (File archivo : listaDirectorios)
				if (archivo.isFile()) {
					String archivoObtenido = archivo.getName() + " " + "F" + " " + fecha.format(archivo.lastModified());
					//System.out.println(archivoObtenido);
					escribirEnArchivo(archivoObtenido);
				} else if (archivo.isDirectory()) {
					String archivoObtenido = archivo.getName() + " " + "D" + " " + fecha.format(archivo.lastModified());
					//System.out.println(archivoObtenido);
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
}