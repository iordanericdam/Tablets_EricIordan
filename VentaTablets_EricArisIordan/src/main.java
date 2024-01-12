
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
		int opcion = 0, atempError;
		String opcionS, contador, dni, pregAgregarDni, tabletVender, consultarCliente, IDClienteVendido;
		char tabletDisponible;
		boolean opcionC, tabletDisponibleBool, agregarDni, agregarIDTablet, stockTablets, existenciaClientes = false, existenciaVentas, ventaRealizada = false;

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

		clientes[0][0] = "ID";
		clientes[0][1] = "DNI";
		clientes[0][2] = "Nombre";
		clientes[0][3] = "Apellidos";

		ventas[0][0] = "ID";
		ventas[0][1] = "ID_Tablet";
		ventas[0][2] = "ID_Cliente";

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
					dni = sc.next().toUpperCase();
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
				atempError = 0;

//				Futuro metodo
				stockTablets = false;
				for (int i = 0; i < tablets.length; i++) {
					if (tablets[i][1] != null && tablets[i][5] == "true") {
						stockTablets = true;
					}

				}
//				Fin metodo
//				Futuro metodo
				existenciaClientes = false;
				for (int i = 1; i < clientes.length; i++) {
					if (clientes[i][1] != null) {
						existenciaClientes = true;
					}

				}
				
//				Fin metodo

				if (stockTablets && existenciaClientes) {

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
					
					ventaRealizada = false;
					for (int i = 0; i < tablets.length; i++) {
						if (tabletVender.equals(tablets[i][0])) {
							for (int n = 0; n < ventas.length; n++) {
								if (ventas[n][1] == null) {
									if (existenciaClientes) {
										for (int l = 0; l < clientes.length; l++) {
											for (int j = 0; j < clientes[l].length; j++) {
												if (clientes[l][1] != null) {
													if (clientes[l][j] == null) {
														System.out.print(clientes[l][j] + " |");
													} else {
														System.out.print(clientes[l][j] + " |");
													}
													if (j + 1 >= clientes[l].length) {
														System.out.println();
													}
												}
											}

										}
										do {
											System.out.print("Introduce el ID del cliente al que se lo ha vendido: ");
											IDClienteVendido = sc.next();
											atempError += 1;
											for (int e = 0; e< clientes.length; e++ ) {
												if (IDClienteVendido.equals(clientes[i][0]) && clientes[i][1] != null) {
													ventas[n][1] = tabletVender;
													ventas[n][2] = IDClienteVendido;
													ventaRealizada = true;
													tablets[i][5] = "false";
													System.out.println("La tablet se ha quedado sin stock");
													e = clientes.length;
												} 
												
											}
											if (atempError == 3) {
												System.out.println("Has superado el limite de intentos :(");
												ventaRealizada = true;
												
											}
											n = ventas.length;
										} while (!ventaRealizada);
									}
								}
							}
						}

					}

				} 
				
				if (!stockTablets) {
					System.out.println("Lo sentimos no hay stock");
				}
				
				if ( stockTablets && !existenciaClientes) {
					System.out.println("Antes de realizar una venta debes tener minimo 1 cliene");
				}
				
				if(stockTablets && existenciaClientes && !ventaRealizada) {
					System.out.println("Vaya! parece que alguno de los datos introducidos no son correctos, si considera que ha sido un error vuelva a intentarlo");
				}

				break;
			case 4:
				
				stockTablets = false;
				for (int i = 0; i < tablets.length; i++) {
					if (tablets[i][1] != null && tablets[i][5] == "true") {
						stockTablets = true;
					}

				}
				
				if (stockTablets) {
					System.out.println();
					for (int i = 0; i < tablets.length; i++) {
						for (int j = 1; j < (tablets[i].length - 1); j++) {
							if (tablets[i][5] == "true" || tablets[i][5] == "Stock") {
								if (tablets[i][1] == null) {
									System.out.print(tablets[i][j] + " |");
								} else {
									System.out.print(tablets[i][j] + " |");
								}
								if (j + 2 >= tablets[i].length) {
									System.out.println();
								}
							}
						}
					}
					
				} else {
					System.out.println("Vaya, parece que no tenemos stock");
				}
				break;
			case 5:
				
				existenciaVentas = false;
				for (int i = 1; i < ventas.length; i++) {
					if (ventas[i][1] != null) {
						existenciaVentas = true;
					}

				}
				if (existenciaVentas) {
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
					System.out.println("Introduce el ID del cliente que desea consultar:");
					consultarCliente = sc.next();

					for (int i = 0; i < ventas.length; i++) {
						if (Objects.equals(ventas[i][1], consultarCliente) || tablets[i][5] == "Stock") {
							if (Objects.equals(ventas[i][2], tablets[i][0]) || tablets[i][5] == "Stock") {
								for (int j = 1; j < 5; j++) {
									if (tablets[i][1] != null) {
										if (tablets[i][j] == null) {
											System.out.print(tablets[i][j] + " |");
										} else {
											System.out.print(tablets[i][j] + " |");
										}
										if (j + 2 >= tablets[i].length) {
											System.out.println();
										}
									}
								}

							}
						}

					}		
				} else {
					System.out.println("Vaya parece que no se ha realizada ninguna venta todia, vuelva en unos dias");
				}
				
				break;
			case 6:
				System.out.println("Nos vemos pronto ;)");
				break;
				
			case 7:
				for (int l = 0; l < clientes.length; l++) {
					for (int j = 0; j < clientes[l].length; j++) {
						
							if (clientes[l][j] == null) {
								System.out.print(clientes[l][j] + " |");
							} else {
								System.out.print(clientes[l][j] + " |");
							}
							if (j + 1 >= clientes[l].length) {
								System.out.println();
							}
					}

				}
				
			case 8:
				for (int l = 0; l < ventas.length; l++) {
					for (int j = 0; j < ventas[l].length; j++) {
						if (ventas[l][1] != null) {
							if (ventas[l][j] == null) {
								System.out.print(ventas[l][j] + " |");
							} else {
								System.out.print(ventas[l][j] + " |");
							}
							if (j + 1 >= ventas[l].length) {
								System.out.println();
							}
						}
					}

				}
			
			default:
				System.out.println(
						"La opcion que ha seleccionado no es correcta por favor vuelva a probar o salga pulsando el 6");

			}

		} while (opcion != 6);

	}

}
