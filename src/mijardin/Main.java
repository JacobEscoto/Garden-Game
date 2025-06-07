package mijardin;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner read = new Scanner(System.in);
        Planta[] jardin = new Planta[8];
        boolean cantidad = false;
        boolean jugar = false;
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
                System.out.print("Nombre de la planta " + (i+1) + ": ");
                String nombre = read.nextLine();
                System.out.print("Especie de la planta:");
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
            System.out.println("Jugador: " + player.getUsuario());
            System.out.println("Plantas en Jardin: " + player.getPlantsTotal() + "/8");
            System.out.println("Plantas Sanas: " + player.getSanas() + "/" + player.getPlantsTotal());
            System.out.println("Plantas Marchitas: " + player.getMarchitas() + "/" + player.getPlantsTotal());
            System.out.println("Plantas Muertas: " + player.getMuertas() + "/" + player.getPlantsTotal());
            
            // Menu de Acciones
            while (jugar) {
                int dias = 1;
                System.out.println("\n------------- ACCIONES -------------");
                System.out.println("1- Regar Plantas");
                System.out.println("2- Siguiente Dia");
                System.out.println("3- Resumen de Jardin");
                char accion = read.next().charAt(0);
                
                switch (accion) {
                    case '1':
                        System.out.print("Que planta desearias regar? \nEscribe el numero de la planta:");
                        int plantaRegar = read.nextInt();
                        if (plantaRegar >= 1 && plantaRegar <= jardin.length) {
                            jardin[plantaRegar - 1].regar();
                            System.out.println("Has regado la" + jardin[plantaRegar - 1].getNombre());
                        }
                        
                        break;
                    case '2':
                        for (int i = 0; i < player.getPlantsTotal(); i++) {
                            
                        }
                }
            }
        }
    }

}
