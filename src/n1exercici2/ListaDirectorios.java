package n1exercici2;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;

public class ListaDirectorios {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File archivos = new File(args[0]);
		listarArbolDirectorios(archivos);
	}

	public static void listarArbolDirectorios(File archivos) {
		File[] listaDirectorios = archivos.listFiles();
		SimpleDateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");
		if (listaDirectorios != null) {
			Arrays.sort(listaDirectorios);
			for (File archivo : listaDirectorios)
				if (archivo.isFile()) {
					System.out.println(archivo.getName() + " " + "F" + " " + fecha.format(archivo.lastModified()));
				} else if (archivo.isDirectory()) {
					System.out.println(archivo.getName() + " " + "D" + " " + fecha.format(archivo.lastModified()));
					listarArbolDirectorios(archivo);
				}

		} else {
			System.out.println("La ruta no es correcta");
		}
	}
}