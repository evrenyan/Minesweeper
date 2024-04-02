class MinesweeperController {
    private Minesweepermodel model;
    private MinesweeperView view;
    private int antallPoeng = 0;
    boolean erFerdig = false;
    public MinesweeperController(int antRader, int antKolonner){
        model = new Minesweepermodel(antRader, antKolonner);
        model.lagRutenett();
        view = new MinesweeperView(this, antRader, antKolonner);
    }
    public int hentAntallPoeng() {
        return antallPoeng;
    }
    public void leggTilPoeng(int poeng) {
        antallPoeng += poeng;
        view.oppdaterPoeng();
    }
    public int antallBomber() {
        return model.antallBomber();
    }
    public int[][] hentRutenett() {
        return model.hentRutenett();
    }
}
