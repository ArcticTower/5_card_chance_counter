public class Board {

    private Card[] hand = new Card[5];

    public void fill(Card[] cards){
        for(int i =0;i<5;i++){
            hand[i]=cards[i];
        }
    }

    public int getCombination(){

    int res = 10;

        //9 - pair
        for (int i =0;i<5;i++){
            for (int j=i;j<5;j++){
                if(i!=j && hand[i].rank==hand[j].rank){
                    if(res > 9) res = 9;



                    //2x2
                    if(res > 8) {
                        for (int k = 0; k < 5; k++) {
                            if (k != i && k != j && hand[k].rank != hand[i].rank) {
                                for (int l = k; k < 5; k++) {

                                    if (l != k && hand[k].rank == hand[l].rank) {
                                        res = 8;
                                    }

                                }
                            }
                        }
                    }


                    //3 card
                    if(res >7) {
                        for (int k = j; k < 5; k++) {
                            if (k != i && k != j && hand[k].rank == hand[i].rank) {
                                if (res > 7) res = 7;


                                //care
                                if(res >6) {
                                    for (int l = k; l < 5; l++) {
                                        if (l != k && l != i && l != i && hand[l].rank == hand[k].rank) {
                                            res = 6;
                                        }
                                    }
                                }

                                //fh
                                if(res >5) {
                                    for (int l = 0; l < 5; l++) {
                                        for (int p = l; p < 5; p++) {
                                            if (l != p && l != i && l != j && l != k && p != i && p != j && p != k && hand[l].rank == hand[p].rank) {
                                                res = 5;
                                            }
                                        }
                                    }
                                }

                            }
                        }
                    }



                }
            }
        }







        //1 - flesh royal
        for(int suit = 1;suit<=4;suit++) {
            if (contains(suit, 1) && contains(suit, 10) && contains(suit, 11) && contains(suit, 12) && contains(suit, 13)) {
                res = 1;
            }

            //3 - street
            if(res >3) {
                for (int rank = 1; rank <= 10; rank++) {
                    if (contains(0, rank) && contains(0, rank + 1) && contains(0, rank + 2) && contains(0, rank + 3) && contains(0, rank + 4)) {
                        //2 - street - flash
                        if (res > 2) {
                            if (hand[0].suit == hand[1].suit &&
                                    hand[0].suit == hand[2].suit &&
                                    hand[0].suit == hand[3].suit &&
                                    hand[0].suit == hand[4].suit) {
                                 res = 2;
                            }
                        }
                        if(res >3) res = 3;
                    }
                }
            }

        }
            if(res>4) {
                //4 - flash
                if (hand[0].suit == hand[1].suit &&
                        hand[0].suit == hand[2].suit &&
                        hand[0].suit == hand[3].suit &&
                        hand[0].suit == hand[4].suit) {
                    res = 4;
                }
            }

            return res;
        }


    private boolean contains(int suit, int rank){
        for(Card c : hand){
            if(c.rank == rank && c.suit==suit || (c.rank == rank && suit == 0)){
                return true;
            }
        }
        return false;
    }

}
