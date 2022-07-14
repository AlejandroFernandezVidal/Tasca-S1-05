package n1exercici1;

import java.io.File;
import java.util.Arrays;

public class ListaDirectorios {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File archivos = new File(args[0]);
		String[] listaDirectorios = archivos.list();
		if (listaDirectorios != null) {
			Arrays.sort(listaDirectorios);
			for(int i = 0; i < listaDirectorios.length; i++){
				System.out.println(listaDirectorios[i]);
			}	
		}else {
			System.out.println("La ruta no es correcta");
		}
	}
}