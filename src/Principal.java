import java.awt.*;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) throws IOException, InterruptedException {
		Integer numeroMonedadOriginal = null;
		Integer numeroMonedadDestino = null;
		String nombreMonedaOriginal=null;
		String nombreMonedaDestino = null;
		double tasaDeCambio = 0;
		double cantidadAConvertir=0;
		double resultado = 0;
		MenuPrincipal.lanzarMensaje();

		while (true){
			System.out.println("Selecciona una moneda: ");
			Scanner teclado = new Scanner(System.in);
			try{
				numeroMonedadOriginal = (Integer) teclado.nextInt();
				if(numeroMonedadOriginal <1 || numeroMonedadOriginal>6){
					System.out.println(" --- Ingresa una opcion valida --- ");
					continue;
				}
				switch (numeroMonedadOriginal){
					case 1:
						nombreMonedaOriginal = "MXN";
						break;
					case 2:
						nombreMonedaOriginal = "ARS";
						break;
					case 3:
						nombreMonedaOriginal = "USD";
						break;
					case 4:
						nombreMonedaOriginal = "EUR";
						break;
					case 5:
						nombreMonedaOriginal = "COP";
						break;
					case 6:
						nombreMonedaOriginal = "CAD";
						break;
				}
			} catch (InputMismatchException e){
				System.out.println("Entrada no valida");
				continue;
			}

			System.out.println("Selecciona una moneda destino: ");
			Scanner teclado2 = new Scanner(System.in);
			try{
				numeroMonedadDestino = (Integer) teclado.nextInt();
				if(numeroMonedadDestino <1 || numeroMonedadDestino>6){
					System.out.println(" --- Ingresa una opcion valida --- ");
					continue;
				}
				switch (numeroMonedadDestino){
					case 1:
						nombreMonedaDestino = "MXN";
						break;
					case 2:
						nombreMonedaDestino = "ARS";
						break;
					case 3:
						nombreMonedaDestino = "USD";
						break;
					case 4:
						nombreMonedaDestino = "EUR";
						break;
					case 5:
						nombreMonedaDestino = "COP";
						break;
					case 6:
						nombreMonedaDestino = "CAD";
						break;
				}
			} catch (InputMismatchException e){
				System.out.println("Entrada no valida");
				continue;
			}

			System.out.println("Ingresa la cantidad de dinero que vas a cambiar de (" + nombreMonedaOriginal +"): ");
			Scanner teclado3 = new Scanner(System.in);
			try {
				cantidadAConvertir = teclado3.nextDouble();
			} catch (InputMismatchException e){
				System.out.println("ERROR Cantidad no valida");
				continue;
			}
			tasaDeCambio = ConsultaMonedas.buscarMoneda(nombreMonedaOriginal,nombreMonedaDestino);
			resultado = (tasaDeCambio * cantidadAConvertir);

			System.out.println(" --- Realizando conversion ---");
			System.out.println(cantidadAConvertir + nombreMonedaOriginal + " Equivalen a: " + new DecimalFormat("#.##").format(resultado) + " " + nombreMonedaDestino);
			System.out.println("Desea realizar otra conversion?: Y/N ");
			String opcionSalida = null;
			Scanner teclado4 = new Scanner(System.in);
			opcionSalida = teclado4.nextLine();
			if(opcionSalida.equals("Y")){
				MenuPrincipal.lanzarMensaje();
				continue;
			} else if (opcionSalida.equals("N")) {
				break;
			} else{
				System.out.println("Opcion no valida");
				break;
			}
		}
	}
}
