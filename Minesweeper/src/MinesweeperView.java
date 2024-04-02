import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class MinesweeperView {
    private MinesweeperController kontroll;
    private int rader, kolonner;
    private JFrame vindu;
    private JPanel panelRutenett;
    private JPanel panelInfo;
    private JLabel tekstPoeng;
    public MinesweeperView(MinesweeperController kontroll, int rader, int kolonner) {
        this.kontroll = kontroll;
        this.rader = rader;
        vindu = new JFrame("Minesweeper");
        vindu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vindu.setLayout(new BorderLayout());

        leggTilInfo();
        leggTilKnapper();

        vindu.pack();
        vindu.setVisible(true);
    }
    public void oppdaterPoeng() {
        tekstPoeng.setText("Poeng: " + kontroll.hentAntallPoeng());
    }
    public void leggTilInfo() {
        panelInfo = new JPanel();
        panelInfo.setLayout(new GridLayout(1,4));
        JLabel tekstBomber = new JLabel("Bomber: " + kontroll.antallBomber());
        tekstBomber.setFont(new Font("Arial", Font.BOLD, 25));
        panelInfo.add(tekstBomber);
        tekstPoeng = new JLabel("Poeng: " + kontroll.hentAntallPoeng());
        tekstPoeng.setFont(new Font("Arial", Font.BOLD, 25));
        panelInfo.add(tekstPoeng);
        vindu.add(panelInfo, BorderLayout.NORTH);
    }
    public void leggTilKnapper() {
        panelRutenett = new JPanel();
        panelRutenett.setLayout(new GridLayout(rader, kolonner));
        int[][] rutenett = kontroll.hentRutenett();
        class MinesweeperKnapp extends JButton {
            private int verdi;
            public MinesweeperKnapp(int verdi) {
                super("?");
                super.addActionListener(new KnappBehandler());
            }
            class KnappBehandler implements  ActionListener {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (kontroll.erFerdig) return;
                    setText(""+verdi);
                    kontroll.leggTilPoeng(verdi);
                    if (verdi == 0) {
                        setBackground(Color.RED);
                        kontroll.erFerdig = true;
                    } else {
                        setBackground(Color.GREEN);
                    }
                }
            }
        }
        for (int rad = 0; rad < rader; rad++) {
            for (int kol = 0; kol < kolonner; kol++) {
                int verdi = rutenett[rad][kol];
                MinesweeperKnapp rutenettknapp = new MinesweeperKnapp(verdi);
                panelRutenett.add(rutenettknapp);
            }
        }
        vindu.add(panelRutenett, BorderLayout.CENTER);
    }
}
