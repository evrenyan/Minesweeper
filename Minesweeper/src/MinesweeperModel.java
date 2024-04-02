import java.util.*;


class Minesweepermodel {
    private int rader, kolonner;
    private int[][] rutenett;
    private int antallBommber = 0;
    public Minesweepermodel(int antRader, int antKolonner) {
        rader = antRader;
        kolonner = antKolonner;
        rutenett = new int[rader][kolonner];
    }
    public  int[][] hentRutenett() {
        return rutenett;
    }
    public int antallBomber() {
        return antallBommber;
    }
    public void lagRutenett() {
        Random rand = new Random();
        for (int rad = 0; rad < rader; rad++) {
            for (int kol = 0; kol < kolonner; kol++) {
                int verdi = rand.nextInt(9);
                rutenett[rad][kol] = verdi;
                if (verdi == 0) antallBommber++;
            }
        }
    }
}