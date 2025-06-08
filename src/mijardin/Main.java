package mijardin;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner read = new Scanner(System.in);
        Planta[] jardin = new Planta[8];
        boolean cantidad = false;
        boolean jugar;
        int plantsTotal = 0;
        int agregarPlantas = 0;
        int plantasSanas = 0;
        int plantasMarchitas = 0;
        int plantasMuertas = 0;

        //Inicio (Bienvenida)
        System.out.print("Ingresa tu nombre de usuario: ");
        String user = read.nextLine();
        System.out.println("Deseas agregar alguna planta a tu jardin? (y/n)");
        String choice = read.next().toLowerCase();

        if (choice.equals("y")) {
            System.out.println("Cuantas plantas deseas agregar? (Capacidad Maxima: 8)!");
            agregarPlantas = read.nextInt();
            read.nextLine();
            cantidad = (agregarPlantas > 0 && agregarPlantas <= 8);
        }

        if (!cantidad) {
            System.out.println("Cantidad invalida para agregar plantas a tu jardin!");
            jugar = false;
        } else {
            for (int i = 0; i < agregarPlantas; i++) {
                System.out.print("\nNombre de la planta " + (i + 1) + ": ");
                String nombre = read.nextLine();
                System.out.print("Especie de la planta: ");
                String especie = read.nextLine();
                int ultimoRiego = 0;
                int crecimiento = 0;
                String estado = "Sana";
                Planta semilla = new Planta(nombre, especie, ultimoRiego, crecimiento, estado);
                jardin[i] = semilla;
                System.out.println(semilla.getNombre() + " agregada a tu jardin exitosamente");
                plantsTotal++;
                plantasSanas++;
            }
            jugar = true;
        }

        if (jugar) {
            Jugador player = new Jugador(user, plantsTotal, plantasSanas, plantasMarchitas, plantasMuertas);

            System.out.println("\n------------- MI JARDIN -------------");
            System.out.println(player.toString());

            // Menu de Acciones
            int dias = 1;
            while (jugar) {
                System.out.println("\n--> Dia #" + dias);
                player.estadoPlantas(jardin, player.getPlantsTotal());
                System.out.println("------------- ACCIONES -------------");
                System.out.println("1- Regar Plantas");
                System.out.println("2- Siguiente Dia");
                System.out.println("3- Resumen de Plantas");
                System.out.println("4- Salir del Juego");
                System.out.print("Que accion deseas realizar: ");
                char accion = read.next().charAt(0);

                switch (accion) {
                    case '1':
                        System.out.print("Que planta desearias regar? \nEscribe el numero de la planta: ");
                        int plantaRegar = read.nextInt();
                        if (plantaRegar >= 1 && plantaRegar <= jardin.length) {
                            jardin[plantaRegar - 1].regar();
                            System.out.println("Has regado la planta: " + jardin[plantaRegar - 1].getNombre());
                        }
                        break;
                    case '2':
                        for (int i = 0; i < player.getPlantsTotal(); i++) {
                            jardin[i].nextDay();
                        }
                        dias++;
                        int contMuertas = 0;
                        for (int i = 0; i < player.getPlantsTotal(); i++) {
                            String estadoActual = jardin[i].getEstado();
                            if (estadoActual.equalsIgnoreCase("muerta")) {
                                contMuertas++;
                            }
                        }
                        if (contMuertas == player.getPlantsTotal()) {
                            jugar = false;
                            System.out.println("\n-----------------------------\nTodas tus plantas han muerto! \n--------- GAME OVER ---------");
                        }
                        break;
                    case '3':
                        for (int i = 0; i < player.getPlantsTotal(); i++) {
                            System.out.println("\nPlanta " + (i + 1) + ": ");
                            System.out.println(jardin[i].toString());
                        }
                        break;
                    case '4':
                        System.out.println("Saliste del Jardin...");
                        jugar = false;
                        break;
                    default:
                        System.out.println("Accion No Valida!");
                        break;
                }
            }
        }
    }

}
