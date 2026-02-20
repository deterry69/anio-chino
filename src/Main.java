import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Introduce un año: ");
            if (!sc.hasNextInt()) {
                System.out.println("¡Error! Por favor, introduce un año válido (número entero).");
                sc.next();
                continue;
            }

            int year = sc.nextInt();
            calcularCiclo(year);
        }
    }

    public static void calcularCiclo(int year) {
        String[] elementos = {"Madera", "Fuego", "Tierra", "Metal", "Agua"};
        String[] animales = {"Rata", "Buey", "Tigre", "Conejo", "Dragón", "Serpiente",
                "Caballo", "Oveja", "Mono", "Gallo", "Perro", "Cerdo"};

        int baseYear = 1984;
        int diferencia = year - baseYear;
        int indiceAnimal = Math.floorMod(diferencia, 12);
        int indiceElemento = Math.floorMod(diferencia, 10) / 2;
        System.out.printf("El año %d corresponde a: %s %s%n", year, elementos[indiceElemento], animales[indiceAnimal]);
    }
}