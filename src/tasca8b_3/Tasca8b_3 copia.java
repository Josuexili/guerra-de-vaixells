package tasca8b_3;
import java.util.Scanner;
import java.util.Random;

public class Tasca8b_3 {

	public static void main(String[] args) {
		
		char tablero1 [][] = new char [5][5];
		char tablero2 [][] = new char [5][5];
		Scanner sc = new Scanner(System.in);
		Random random = new Random();
		// crear tablero (5x5)
		
		for (int i=0;i<5;i++) {
			for (int j=0;j<5;j++) {
				tablero1 [i][j] = '*';
				tablero2 [i][j] = '*';
			}
		}
		//tirada aleatoria de barcos
		for (int i=0; i<3; i++) {
			int fila = random.nextInt(5);
			int columna = random.nextInt(5);
			if (tablero1 [fila][columna] != 'B') {
				tablero1 [fila][columna] = 'B'; 
			} else {
				i--;
			}
		}
		//iniciar joc
		int intents = 0;
		int barcos = 2;
		
		while (barcos>0) {
			System.out.print("  ");
			//primera fila tablero
			for (int i=0; i<5; i++) {
				System.out.print(i+1 + " ");
				
				}
			//resta de tablero
			System.out.println();
			char filas[] = { 'A', 'B', 'C', 'D', 'E' };
            for (int i = 0; i < 5; i++) {
                System.out.print(filas[i] + " "); //lletres de les files
                for (int j = 0; j < 5; j++) {
                    System.out.print(tablero2[i][j] + " "); // ensenyar tablero
                }
                System.out.println();
            }
			
            //tirada jugador
            System.out.print("Juga!: ");
            String disparo1 = sc.nextLine().toUpperCase();
           
            if (disparo1.length() < 2 || disparo1.length()>2) {
            	System.out.println("tirada no vàlida. Torna-hi");
            	continue;
            }
            
            char tirada = disparo1.charAt(0);
            int fila = tirada - 'A';
            int columna = Character.getNumericValue(disparo1.charAt(1)) - 1;
            
            if (fila < 0 || fila >= 5 || columna < 0 || columna >= 5) {
            	
            	System.out.println("tirada no vàlida. Torna-hi");
            	continue;
            }
            	if (tablero2[fila][columna] == 'X' || tablero2[fila][columna] == 'A') {
                    System.out.println("ja has introduï aquestes coordenades. Torna-hi.");
                    continue;
            } 
            	intents++;
            	if (tablero1[fila][columna] == 'B') {
                    System.out.println("Tocat i enfonsat!");
                    
                    tablero2[fila][columna] = 'X'; // acerta
                    barcos--; // Reduir barcos per acert
                } else {
                    System.out.println("Aigua!!");
                    tablero2[fila][columna] = 'A'; // falla
           }
        }
			
		}
	

	}


