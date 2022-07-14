package n1exercici5;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Serializar
		try {
		//Creamos fichero
		FileOutputStream registro = new FileOutputStream("/Users/alexfernandez/eclipse-workspace/Tasca S1.05/src/n1exercici5/coches.ser");
		ObjectOutputStream salida = new ObjectOutputStream(registro);
		//Creamos objeto
		Coche coche1 = new Coche("Kia","Ceed",1.7);
		System.out.println(coche1.toString());
		//Escribimos objeto en archivo
		salida.writeObject(coche1);
		salida.close();
		//Capturamos posibles errores
		}catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
		}catch (IOException e) {
			System.out.println(e.getMessage());
		}	
		//Deserializar
		try {
			FileInputStream recibido = new FileInputStream("/Users/alexfernandez/eclipse-workspace/Tasca S1.05/src/n1exercici5/coches.ser");
			ObjectInputStream entrada = new ObjectInputStream(recibido);
			System.out.println(entrada.readObject());
			entrada.close();
		}catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}catch(ClassNotFoundException e) {
		 System.out.println(e.getMessage());
		}
	}
}