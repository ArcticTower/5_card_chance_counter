import java.math.BigDecimal;

public class Main {

    private final int BOARD = 5;
    Deck deck = new Deck();

    public static void main(String[] args){

        long iter = 1000000;
        double lc = 1000000;
        if(args.length>0){
             iter = Long.parseLong(args[0]);
             lc = (double) iter;

        }
        //double lc = 1000000;
        //long iter = 1000000;
        double fr_chance =0;
        double flash_royal=0;

        double street_flash =0;
        double sf_chance =0;

        double street =0;
        double s_chance =0;

        double flash =0;
        double fl_chance =0;

        double full_house =0;
        double fh_chance =0;

        double care =0;
        double c_chance =0;

        double tree =0;
        double t_chance =0;

        double twotwo =0;
        double tt_chance =0;

        double pare =0;
        double p_chance =0;

        double highcard =0;
        double hc_chance =0;

        while(iter>=0){

            Deck deck = new Deck();
            deck.fillDeck();
            deck.shuffle();

            Board board = new Board();

            board.fill(deck.deal());
            int res = board.getCombination();
            switch (res) {
                case 1 -> flash_royal++;
                case 2 -> street_flash++;
                case 3 -> street++;
                case 4 -> flash++;
                case 5 -> full_house++;
                case 6 -> care++;
                case 7 -> tree++;
                case 8 -> twotwo++;
                case 9 -> pare++;
                case 10 -> highcard++;
                default -> System.exit(99);
            }

            //System.out.println(res);
            iter--;
        }

        fr_chance=(double) flash_royal/(double)lc;
        sf_chance=(double)street_flash/(double)lc;
        s_chance=(double)street/(double)lc;
        fl_chance=(double)flash/(double)lc;
        fh_chance=(double)full_house/(double)lc;
        c_chance=(double)care/(double)lc;
        t_chance=(double)tree/(double)lc;
        tt_chance=(double)twotwo/(double)lc;
        p_chance=(double)pare/(double)lc;
        hc_chance=(double)highcard/(double)lc;

        System.out.println("Flash royal: \t"+String.format("%.8f", fr_chance));
        System.out.println("Street flash: \t"+String.format("%.8f", sf_chance));
        System.out.println("Street: \t"+String.format("%.8f", s_chance));
        System.out.println("Flash: \t\t"+String.format("%.8f", fl_chance));
        System.out.println("Full house: \t"+String.format("%.8f", fh_chance));
        System.out.println("Care: \t\t"+String.format("%.8f", c_chance));
        System.out.println("Tree: \t\t"+String.format("%.8f", t_chance));
        System.out.println("Two pairs: \t"+String.format("%.8f", tt_chance));
        System.out.println("Pair: \t\t"+String.format("%.8f", p_chance));
        System.out.println("High card: \t"+String.format("%.8f", hc_chance));

    }



}
