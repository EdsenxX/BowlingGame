package bowlinggame;

public class BowlingGame {

    private int tiros[];
    private int frames[] = new int[10];

    public BowlingGame(int[] tiros) {
        this.tiros = tiros;
    }

    public void puntiacionTotal() {
        int puntuacion = 0;
        System.out.println("-------------------------------------");
        for (int i = 0; i < frames.length; i++) {
            puntuacion += frames[i];
        }
        System.out.println("Puntuacion Total: " + puntuacion);
    }

    public void mostrarFrame() {
        this.puntuacion();
        for (int i = 0; i < this.frames.length; i++) {
            System.out.print("Frame " + (i + 1) + ": ");
            System.out.println(this.frames[i]);
        }
    }

    private void puntuacion() {
        int[] tiros = this.tiros;
        int contadorFrame = 0;
        boolean allowed = false;
        System.out.println("-------------------------------------");
        for (int i = 0; i < tiros.length; i++) {
            int puntuacion = 0;
            if (i == 20) {
                this.frames[contadorFrame - 1] += tiros[i];
            } else if (i % 2 != 0 || (i == 20 && allowed)) {
                if (this.strike(i)) {
                    puntuacion += 10 + tiros[i - 1] + tiros[i];
                    allowed = true;
                } else if (this.spare(i)) {
                    puntuacion += 10 + tiros[i + 1];
                    allowed = true;
                } else {
                    puntuacion = tiros[i - 1] + tiros[i];
                }
                this.frames[contadorFrame] = puntuacion;
                contadorFrame++;
            }
        }
    }

    private boolean strike(int tiro) {
        return this.tiros[tiro - 1] == 10;
    }

    private boolean spare(int tiro) {
        return (this.tiros[tiro - 1] + this.tiros[tiro] == 10);
    }

}
