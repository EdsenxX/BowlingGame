package bowlinggame;

import java.util.Scanner;

public class Game {

    public static void main(String[] args) {
        Game juego = new Game();
        int[] tiros = juego.ingresarTiros();
        BowlingGame game = new BowlingGame(tiros);
        game.mostrarFrame();
        game.puntiacionTotal();
    }

    public static int[] ingresarTiros() {
        int contadorFrame = 1;
        int contadorPosicion = 1;
        int[] tiros = new int[21];
        Scanner leer = new Scanner(System.in);
        System.out.println("-------------------------------------");
        System.out.println("\tIngresa los tiros");
        for (int i = 0; i < 21; i++) {
            System.out.print("Frame " + contadorFrame + ", posicion: " + "[" + contadorPosicion + "]: ");
            tiros[i] = leer.nextInt();
            contadorPosicion++;
            if (i % 2 != 0) {
                contadorFrame++;
                contadorPosicion = 1;
                if(i==19){
                    contadorFrame--;
                    contadorPosicion = 3;
                }
            }
        }
        return tiros;
    }

}
