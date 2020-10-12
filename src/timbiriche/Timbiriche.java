package timbiriche;

import java.util.Random;
import java.util.Scanner;

public class Timbiriche {
	static Scanner in;
	static Grafo g = new Grafo(25);
	static String[] conexiones = new String[40];
	static String[] casillaJugador = new String[18];
	static String turno = "M";
	static int nTiros = 0;
	static boolean[] casillasGanadas = new boolean[19];
	
	
	public static void inicializarConexiones() {
		for (int i = 0; i < conexiones.length; i++) {
			conexiones[i] = "  ";
		}
	}
	public static void inicializarCasillasJugadores() {
		for (int i = 0; i < casillaJugador.length; i++) {
			casillaJugador[i] = " ";
		}
	}
	
	public static void imprimirCuadricula() {
		System.out.println(" ---      ---      ---      ---      ---");
		System.out.println("| 0 | " + conexiones[0] + " | 1 | " + conexiones[1] + " | 2 | " + conexiones[2] + " | 3 | " + conexiones[3] + " | 4 |");
		System.out.println(" ---      ---      ---      ---      ---");
		System.out.println("  " + conexiones[4] + "   " + casillaJugador[0] + "    " + conexiones[6] + "   " + casillaJugador[1] + "   " + conexiones[8] + "   " + casillaJugador[2] + "   " + conexiones[10] + "   " + casillaJugador[3] + "   " + conexiones[12]);
		System.out.println(" ---      ---      ---      ---      ---");
		System.out.println("| 5 | " + conexiones[5] + " | 6 | " + conexiones[7] + " | 7 | " + conexiones[9] + " | 8 | " + conexiones[11] + " | 9 |");
		System.out.println(" ---      ---      ---      ---      ---");
		System.out.println("  " + conexiones[13] + "   " + casillaJugador[4] + "    " + conexiones[15] + "    " + casillaJugador[5] + "   " + conexiones[17] + "   " + casillaJugador[6] + "   " + conexiones[19] + "   " + casillaJugador[7] + "   " + conexiones[21]);
		System.out.println(" ---      ---      ---      ---      ---");
		System.out.println("| 10| " + conexiones[14] + " | 11| " + conexiones[16] + " | 12| " + conexiones[18] + " | 13| " + conexiones[20] + " | 14|");
		System.out.println(" ---      ---      ---      ---      ---");
		System.out.println("  " + conexiones[22] + "   " + casillaJugador[8] + "    " + conexiones[24] + "    " + casillaJugador[9] + "   " + conexiones[26] + "   " + casillaJugador[10] + "   " + conexiones[28] + "   " + casillaJugador[11] + "   " + conexiones[30]);
		System.out.println(" ---      ---      ---      ---      ---");
		System.out.println("| 15| " + conexiones[23] + " | 16| " + conexiones[25] + " | 17| " + conexiones[27] + " | 18| " + conexiones[29] + " | 19|");
		System.out.println(" ---      ---      ---      ---      ---");
		System.out.println("  " + conexiones[31] + "   " + casillaJugador[12] + "    " + conexiones[33] + "    " + casillaJugador[13] + "   " + conexiones[35] + "   " + casillaJugador[14] + "   " + conexiones[37] + "   " + casillaJugador[15] + "   " + conexiones[39]);
		System.out.println(" ---      ---      ---      ---      ---");
		System.out.println("| 20| " + conexiones[32] + " | 21| " + conexiones[34] + " | 22| " + conexiones[36] + " | 23| " + conexiones[38] + " | 24|");
		System.out.println(" ---      ---      ---      ---      ---");
	}
	
	public static boolean verificarCuadriculas() {
		boolean otroTurno = false;
		
		for (int i = 0; i < 19; i++) {
			if((casillasGanadas[i] == false) && ((g.estanConectados(i, i+1) && (g.estanConectados(i+1, i+6)) && (g.estanConectados(i, i+5)) && (g.estanConectados(i+5, i+6))))) {
				if(i<=4)
					casillaJugador[i] = turno;
					casillasGanadas[i] = true;
				if(i>4 && i<=8)
					casillaJugador[i-1] = turno;
					casillasGanadas[i] = true;
				if(i>8 && i<=12)
					casillaJugador[i-2] = turno;
					casillasGanadas[i] = true;
				if(i>12)
					casillaJugador[i-3] = turno;
					casillasGanadas[i] = true;
				otroTurno = true;
				break;
			}		
		}
		return otroTurno;
	}
	
	public static void verificarConexiones() {
		
		for (int i = 0; i < 4; i++)
			if(g.estanConectados(i, i+1))
				conexiones[i] = "——";
	
		for (int i = 0, j = 4;  i < 5; i++, j=j+2)
			if(g.estanConectados(i, i+5))
				conexiones[j] = "| ";
		
		for (int i = 5, j = 5; i < 9; i++, j=j+2)
			if(g.estanConectados(i, i+1))
				conexiones[j] = "——";
		
		for (int i = 10, j = 14; i < 14; i++, j=j+2)
			if(g.estanConectados(i, i+1))
				conexiones[j] = "——";
		
		for (int i = 15, j = 23; i < 19; i++, j=j+2)
			if(g.estanConectados(i, i+1))
				conexiones[j] = "——";
		
		for (int i = 20, j = 32; i < 24; i++, j=j+2)
			if(g.estanConectados(i, i+1))
				conexiones[j] = "——";
		
		for (int i = 5, j = 13;  i < 10; i++, j=j+2)
			if(g.estanConectados(i, i+5))
				conexiones[j] = "| ";
		
		for (int i = 10, j = 22;  i < 15; i++, j=j+2)
			if(g.estanConectados(i, i+5))
				conexiones[j] = "| ";
		
		for (int i = 15, j = 31;  i < 20; i++, j=j+2)
			if(g.estanConectados(i, i+5))
				conexiones[j] = "| ";
	}
	
	public static String ganador() {
		int contUsuario = 0;
		int contMaquina = 0;
		for (int i = 0; i < casillaJugador.length; i++) {
			if(casillaJugador[i] == "U")
				contUsuario++;
			if(casillaJugador[i] == "M")
				contMaquina++;
		}
		if(contUsuario > contMaquina)
			return "Usuario";
		
		return "Maquina";
	}
	
	public static void maxMin(boolean fn) {
		if(fn) {
			maximizar();
		}else {
			minimizar();
		}
	}
	
	private static void minimizar() {
		Random num = new Random();
		int nuevoNodo = num.nextInt(25);
			g.unir2Puntos(nuevoNodo, nuevoNodo+1);
		
	}
	
	public static void maximizar() {
		for (int i = 0; i < 19; i++) {
			if( g.estanConectados2(i, i+1) + g.estanConectados2(i+1, i+6) + g.estanConectados2(i, i+5) + g.estanConectados2(i+5, i+6) == 3) {
				if(g.estanConectados(i, i+1) && g.estanConectados(i+1, i+6) && g.estanConectados(i,	i+5)) {
					g.unir2Puntos(i+5, i+6); return;
				}if(g.estanConectados(i, i+1) && g.estanConectados(i+1, i+6) && g.estanConectados(i+6, i+5)) {
					g.unir2Puntos(i, i+5); return;
				}if(g.estanConectados(i, i+1) && g.estanConectados(i, i+5) && g.estanConectados(i+5, i+6)) {
					g.unir2Puntos(i+1, i+6); return;
				}if(g.estanConectados(i, i+5) && g.estanConectados(i+5, i+6) && g.estanConectados(i+6, i+1)) {
					g.unir2Puntos(i, i+1);
				}
			}
		}
		maxMin(false); 
	}
	
	public static void main(String[] args) {
		in = new Scanner(System.in);
		boolean otroTurno = false;
		
		inicializarConexiones();
		inicializarCasillasJugadores();
		
		System.out.println("________________TIMBIRICHE_________________");
		imprimirCuadricula();
		while(nTiros != 40) {
			System.out.println("Turno para: " + turno);
			if(turno == "M") {
				//Turno para la máquina
				Random r = new Random();
				maxMin(true);
			} else {
				//Turno para el usuario
				System.out.println("Para unir dos puntos introduzca los números de los puntos.");
				System.out.println("Punto 1: ");
				int p1 = in.nextInt();
				System.out.println("Punto 2: ");
				int p2 = in.nextInt();
				
				g.unir2Puntos(p1, p2);
			}
			verificarConexiones();
			otroTurno = verificarCuadriculas();
			imprimirCuadricula();
			if(otroTurno){
				
			} else {
				if(turno == "M") {
					turno = "U";
				} else {
					turno = "M";
				}
			}
			nTiros++;
			
		}
		System.out.println(ganador() + " gana el juego!");
		
	}
}
