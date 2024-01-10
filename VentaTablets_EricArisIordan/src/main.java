
//import java.util.Iterator;
import java.util.Objects;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {

//		Desarrollar una aplicación que me permita guardar diferentes tipos de tablets y venderlas a los clientes.
//		Debes de tener una o varias arrays para guardar las tables que están disponibles para vender y realizar las ventas a los clientes. Haz un menú para que el usuario vea las diferentes opciones que puede realizar:
//
//		1.- Dar de alta una tablet.
//
//		2.- Dar de alta un cliente.
//
//		3.- Vender una tablet a un cliente.
//
//		4.- Mostrar tablets disponibles para la venta.
//
//		5.- Mostrar tablets compradas por un cliente en concreto.
//
//		6.- Salir.

		Scanner sc = new Scanner(System.in);
		final String tablets[][] = new String[100][6];
		final String clientes[][] = new String[100][4];
		final String ventas[][] = new String[100][3];
		int opcion = 0;
		String opcionS, contador, dni, pregAgregarDni, tabletVender;
		char tabletDisponible;
		boolean opcionC, datoIntroducido, tabletDisponibleBool, agregarDni, agregarIDTablet;

		for (int i = 1; i < tablets.length; i++) {
			contador = Integer.toString(i);
			tablets[i][0] = contador;
			clientes[i][0] = contador;
			ventas[i][0] = contador;
		}
		tablets[0][0] = "ID";
		tablets[0][1] = "Marca";
		tablets[0][2] = "Modelo";
		tablets[0][3] = "Capacidad";
		tablets[0][4] = "Precio";
		tablets[0][5] = "Stock";

		ventas[0][0] = "ID";
		ventas[0][1] = "ID_Tablet";
		ventas[0][2] = "ID_Cliente";

		tablets[3][1] = "Samsung";
		tablets[3][2] = "Tab 3";
		tablets[3][3] = "254Gb";
		tablets[3][4] = "200€";
		tablets[3][5] = "true";

		tablets[1][1] = "Apple";
		tablets[1][2] = "Ipad Pro3";
		tablets[1][3] = "254Gb";
		tablets[1][4] = "200€";
		tablets[1][5] = "flase";

		tablets[2][1] = "Samsung";
		tablets[2][2] = "Tab 3";
		tablets[2][3] = "254Gb";
		tablets[2][4] = "400€";
		tablets[2][5] = "true";

		clientes[1][1] = "X9114660J";
		clientes[1][2] = "Eric Aris";
		clientes[1][3] = "Iordan";

		clientes[2][1] = "1234J";
		clientes[2][2] = "Edurne";
		clientes[2][3] = "Cerrada Uribesalgo";

		ventas[1][1] = "69";

		do {
			System.out.println("*******************************************");
			System.out.println("*              Menu de Opciones           *");
			System.out.println("*******************************************");
			System.out.println("1. Dar de alta una tablet.");
			System.out.println("2. Dar de alta un cliente.");
			System.out.println("3. Vender una tablet a un cliente.");
			System.out.println("4. Mostrar tablets disponibles para la venta.");
			System.out.println("5. Mostrar tablets compradas por un cliente en concreto.");
			System.out.println("6. Salir.");
			System.out.println("*******************************************");
			do {
				opcionS = sc.next();
				opcionC = false;
				try {
					opcion = Integer.parseInt(opcionS);
					opcionC = true;
				} catch (Exception e) {
					System.out.println("Debes introducir un numero del 0 al 6");
				}

			} while (!opcionC);

			switch (opcion) {
			case 1:
				for (int i = 0; i < tablets.length; i++) {
					if (tablets[i][1] == null) {

						Scanner consola = new Scanner(System.in);

						System.out.print("Introduce la marca de la tablet: ");
						tablets[i][1] = consola.nextLine();
						System.out.print("Introduce el modelo de la tablet: ");
						tablets[i][2] = consola.nextLine();
						System.out.print("Introduce la capacidad de la tablet: ");
						tablets[i][3] = consola.next();
						System.out.print("Introduce el precio de venta: ");
						tablets[i][4] = consola.next();
						do {
							tabletDisponibleBool = false;
							System.out.print("¿La tablet esta disponible?");
							tabletDisponible = consola.next().toLowerCase().charAt(0);
							if (tabletDisponible == 's') {
								tablets[i][5] = "true";
								tabletDisponibleBool = true;
							} else if (tabletDisponible == 'n') {
								tablets[i][5] = "false";
								tabletDisponibleBool = true;

							} else {
								System.out.println("Debes escribir si o no");
							}

						} while (!tabletDisponibleBool);
						i = tablets.length;
					}
				}

				break;

			case 2:
				do {
					Scanner scCliente = new Scanner(System.in);
					agregarDni = false;
					System.out.print("Introduce el DNI: ");
					dni = sc.next().toLowerCase();
					for (int i = 0; i < clientes.length; i++) {
						if (!Objects.equals(clientes[i][1], dni)) {
							if (clientes[i][1] == null || agregarDni) {
								clientes[i][1] = dni;
								System.out.print("Introduce el Nombre: ");
								clientes[i][2] = scCliente.nextLine().toLowerCase();
								System.out.print("Introduce los Apellidos: ");
								clientes[i][3] = scCliente.nextLine().toLowerCase();
								i = clientes.length;
								agregarDni = true;
							}
						} else {
							System.out.println("El Dni ya esta en la base de datos");
							break;
						}
					}
					if (!agregarDni) {
						System.out.println("Desea introducir otro DNI?");
						pregAgregarDni = sc.next().toLowerCase();
						String primerCaracterPregAgregarDni = Character.toString(pregAgregarDni.charAt(0));
						switch (primerCaracterPregAgregarDni) {
						case "s":
							break;
						case "n":
							agregarDni = true;
							break;
						default:
							System.out.println("Debe escribir s o n");
						}
					}
				} while (!agregarDni);
				break;
			case 3:
				System.out.println(
						"Le mostrare una lista con las tablets disponibles para la venta, a continuacion debe introducir el numero de la tablet que desea vender.");

				for (int i = 0; i < tablets.length; i++) {
					for (int j = 0; j < tablets[i].length; j++) {
						if (tablets[i][5] == "true" || tablets[i][5] == "Stock") {
							if (tablets[i][j] == null) {
								System.out.print(tablets[i][j] + " |");
							} else {
								System.out.print(tablets[i][j] + " |");
							}
							if (j + 1 >= tablets[i].length) {
								System.out.println();
							}
						}
					}
				}

				System.out.println();
				System.out.print("Y bien, que tablet desea vender: ");
				tabletVender = sc.next();

				agregarIDTablet = false;
				for (int i = 0; i < tablets.length; i++) {
					if (Objects.equals(clientes[i][0], tabletVender)) {
						for (int n = 0; n < ventas.length; n++) {
							if (tablets[n][1] == null) {

								ventas[n][1] = tabletVender;
								n = tablets.length;
							}

						}

					}
				}

				break;
			case 4:
				System.out.println();
				for (int i = 0; i < tablets.length; i++) {
					for (int j = 1; j < tablets[i].length; j++) {
						if (tablets[i][5] == "true" || tablets[i][5] == "Stock") {
							if (tablets[i][j] == null) {
								System.out.print(tablets[i][j] + " |");
							} else {
								System.out.print(tablets[i][j] + " |");
							}
							if (j + 1 >= tablets[i].length) {
								System.out.println();
							}
						}
					}
				}
				break;
			case 5:
			case 6:
				System.out.println("Nos vemos pronto ;)");
				break;
			case 7:
//				BORRAR CASE 7
				for (int i = 0; i < clientes.length; i++) {
					for (int j = 0; j < clientes[i].length; j++) {
						if (clientes[i][1] != null) {
							if (clientes[i][j] == null) {
								System.out.print(clientes[i][j] + " |");
							} else {
								System.out.print(clientes[i][j] + " |");
							}
							if (j + 1 >= clientes[i].length) {
								System.out.println();
							}
						}
					}

				}
				break;

			case 8:
//				BORRAR CASE 8
				for (int i = 0; i < ventas.length; i++) {
					for (int j = 0; j < ventas[i].length; j++) {
							if (ventas[i][j] == null) {
								System.out.print(ventas[i][j] + " |");
							} else {
								System.out.print(ventas[i][j] + " |");
							}
							if (j + 1 >= ventas[i].length) {
								System.out.println();
							}

						
					}

				}
				break;
			default:
				System.out.println(
						"La opcion que ha seleccionado no es correcta por favor vuelva a probar o salga pulsando el 6");

			}

		} while (opcion != 6);

	}

}
