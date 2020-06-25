public class PokerGameTest {
    public static boolean expectedResult1(){
        boolean r_isPass = false;
        PokerGame pg = new PokerGame();
        String tempPokers = "Black: 2H 3D 5S 9C KD White: 2C 3H 4S 8C AH";
        String tempResult = pg.compare(tempPokers);
        if(tempResult.equals("White wins")){
            r_isPass = true;
        }
        return r_isPass;
    }
    public static boolean expectedResult2(){
        boolean r_isPass = false;
        PokerGame pg = new PokerGame();
        String tempPokers = "Black: 2H 4S 4C 2D 4H White: 2S 8S AS QS 3S";
        String tempResult = pg.compare(tempPokers);
        if(tempResult.equals("White wins")){
            r_isPass = true;
        }
        return r_isPass;
    }
    public static boolean expectedResult3(){
        boolean r_isPass = false;
        PokerGame pg = new PokerGame();
        String tempPokers = "Black: 2H 3H 5H 9H KH White: 2C 3H 4S 5C 6H";
        String tempResult = pg.compare(tempPokers);
        if(tempResult.equals("Black wins")){
            r_isPass = true;
        }
        return r_isPass;
    }
    public static boolean expectedResult4(){
        boolean r_isPass = false;
        PokerGame pg = new PokerGame();
        String tempPokers = "Black: 2H 3H 4H 5H 6H White: 2C 3C 4C 5C 6C";
        String tempResult = pg.compare(tempPokers);
        if(tempResult.equals("Black wins")){
            r_isPass = true;
        }
        return r_isPass;
    }
    public static boolean expectedResult5(){
        boolean r_isPass = false;
        PokerGame pg = new PokerGame();
        String tempPokers = "Black: 2D 3H 5C 9S KH White: 2D 3H 5C 9S KH";
        String tempResult = pg.compare(tempPokers);
        if(tempResult.equals("Tie")){
            r_isPass = true;
        }
        return r_isPass;
    }
    public static void main(String[] args){
        System.out.println(expectedResult1());
        System.out.println(expectedResult2());
        System.out.println(expectedResult3());
        System.out.println(expectedResult4());
        System.out.println(expectedResult5());
    }
}
