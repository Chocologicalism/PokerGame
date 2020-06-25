public class PokerGame {
    public final static char[] value = { '2', '3','4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K', 'A'};
    public final static char[] type = {'D','C','H','S'};
    public final static String[] strength = {"散牌","对子","两对","三条","顺子","同花","同花顺"};

    public boolean isFlush(Poker p_poker){
        boolean r_result = false;
        for(int i = 0;i < p_poker.pokers.length - 1;i++){
            char tempType1 = p_poker.pokers[i].charAt(1);
            char tempType2 = p_poker.pokers[i + 1].charAt(1);
            if(tempType1 == tempType2){
                r_result = true;
            }else{
                r_result = false;
                break;
            }
        }
        if(r_result){
            p_poker.setStrength(5);
            isStraightFlush(p_poker);
        }
        return r_result;
    }
    public boolean isStraight(Poker p_poker){
        boolean r_result = false;
        for(int i = 0;i < p_poker.pokers.length - 1;i++){
            char tempValue1 = p_poker.pokers[i].charAt(0);
            char tempValue2 = p_poker.pokers[i+1].charAt(0);
            if(getIndexFromValue(tempValue1)
                    == getIndexFromValue(tempValue2) + 1){
                r_result = true;
            }else{
                r_result = false;
                break;
            }
        }
        if(r_result){
            p_poker.setStrength(4);
        }
        return r_result;
    }
    public boolean isStraightFlush(Poker p_flushPoker){
        boolean r_result = false;
        if(isStraight(p_flushPoker)){
            r_result = true;
            p_flushPoker.setStrength(6);
        }
        return r_result;
    }
    public boolean isOnePair(Poker p_poker){
        boolean r_result = false;
        for(int i = 0;i < p_poker.pokers.length - 1;i++){
            char tempValue1 = p_poker.pokers[i].charAt(0);
            char tempValue2 = p_poker.pokers[i+1].charAt(0);
            if( tempValue1 == tempValue2){
                r_result = true;
                break;
            }else{
                r_result = false;
            }
        }
        if(r_result){
            p_poker.setStrength(1);
            isTwoPair(p_poker);
            isThreeOfAKind(p_poker);
        }
        return r_result;
    }
    public boolean isTwoPair(Poker p_poker){
        boolean r_result = false;
        char[] tempValue = new char[p_poker.pokers.length];
        for(int i = 0;i < p_poker.pokers.length;i++){
            tempValue[i] = p_poker.pokers[i].charAt(0);
        }
        if((tempValue[1] == tempValue[2])&&(tempValue[3] == tempValue[4])){
            r_result = true;
        }else{
            if((tempValue[0] == tempValue[1])&&(tempValue[3] == tempValue[4])){
                r_result = true;
            }else{
                if((tempValue[0] == tempValue[1])&&(tempValue[2] == tempValue[3])){
                    r_result = true;
                }
            }
        }
        if(r_result){
            p_poker.setStrength(2);
        }
        return r_result;
    }
    public boolean isThreeOfAKind(Poker p_poker){
        boolean r_result = false;
        for(int i = 0;i < p_poker.pokers.length - 2;i++){
            char tempValue1 = p_poker.pokers[i].charAt(0);
            char tempValue2 = p_poker.pokers[i+1].charAt(0);
            char tempValue3 = p_poker.pokers[i+2].charAt(0);
            if( (tempValue1 == tempValue2)&&(tempValue2 == tempValue3) ){
                r_result = true;
                break;
            }else{
                r_result = false;
            }
        }
        if(r_result){
            p_poker.setStrength(3);
        }
        return r_result;
    }
    public String compare(String p_pokers1,String p_pokers2){
        String r_result = "";
        //p_pokers1.
        return r_result;
    }
    public String compare(String p_pokers){
        String r_result = "";

        String[] strs = p_pokers.split(" ");
        String[] tempPlayerName = {strs[0].replace(":",""),strs[6].replace(":","")};
        String[][] tempPokers = {{strs[1],strs[2],strs[3],strs[4],strs[5]},
                {strs[7],strs[8],strs[9],strs[10],strs[11]}};
        Poker poker1 = new Poker(tempPlayerName[0],tempPokers[0]);
        Poker poker2 = new Poker(tempPlayerName[1],tempPokers[1]);
        pokerSort(poker1);
        pokerSort(poker2);
        if(!isFlush(poker1)){
            isOnePair(poker1);
        }
        if(!isFlush(poker2)){
            isOnePair(poker2);
        }
        if(poker1.strength != poker2.strength){
            if(poker1.strength > poker2.strength) {
                r_result = poker1.playerName + " wins";
            }else{
                r_result = poker2.playerName + " wins";
            }
            //System.out.println(r_result);
        }else{
            String tempResult = compareWhenSameStrength(poker1,poker2);
            if(tempResult != "Tie"){
                r_result = tempResult + " wins";
            }else{
                r_result = tempResult;
            }
        }
        return r_result;
    }
    public String compareWhenSameStrength(Poker p_poker1,Poker p_poker2){
        String r_result = "Tie";
        if((p_poker1.strength <=3 )||(p_poker1.strength == 5)){
            for(int i = 0;i < p_poker1.pokers.length;i++){
                if(compareSingleCard(p_poker1.pokers[i],p_poker2.pokers[i]) == 1){
                    r_result = p_poker1.playerName;
                    return r_result;
                }else{
                    if(compareSingleCard(p_poker1.pokers[i],p_poker2.pokers[i]) == -1) {
                        r_result = p_poker2.playerName;
                        return r_result;
                    }
                }
            }
        }else{
            if(compareSingleCard(p_poker1.pokers[0],p_poker2.pokers[0]) == 1){
                r_result = p_poker1.playerName;
                return r_result;
            }else{
                if(compareSingleCard(p_poker1.pokers[0],p_poker2.pokers[0]) == -1){
                    r_result = p_poker2.playerName;
                    return r_result;
                }
            }
        }
        return r_result;
    }
    public int compareSingleCard(String p_card1, String p_card2){
        int r_result = 0;
        int tempValue1 = getIndexFromValue(p_card1.charAt(0));
        int tempValue2 = getIndexFromValue(p_card2.charAt(0));
        if(tempValue1 != tempValue2){
            if(tempValue1 > tempValue2){
                r_result = 1;
            }else{
                r_result = -1;
            }
        }else{
            if(p_card1.charAt(1) != p_card2.charAt(1)){
                if(getIndexFromType(p_card1.charAt(1))
                        > getIndexFromType(p_card2.charAt(1))){
                    r_result = 1;
                }else{
                    r_result = -1;
                }
            }
        }
        return r_result;
    }
    public void pokerSort(Poker p_poker){

        int tempIndex = 0;
        while(tempIndex < p_poker.pokers.length - 1){
            for(int i = 0;i < p_poker.pokers.length - 1 - tempIndex;i++){
                if(getIndexFromValue(p_poker.pokers[i].charAt(0))
                        < getIndexFromValue(p_poker.pokers[i + 1].charAt(0))){
                    String tempPoker = p_poker.pokers[i];
                    p_poker.pokers[i] =  p_poker.pokers[i + 1];
                    p_poker.pokers[i + 1] = tempPoker;
                }
            }
            tempIndex++;
        }
    }
    public int getIndexFromValue(char p_value){
        int r_index = -1;
        int i = 0;
        while(r_index < 0){
            if(value[i] == p_value){
                r_index = i;
            }
            i++;
        }
        return r_index;
    }
    public int getIndexFromType(char p_type){
        int r_index = -1;
        int i = 0;
        while(r_index < 0){
            if(type[i] == p_type){
                r_index = i;
            }
            i++;
        }
        return r_index;
    }

}
class Poker {
    String playerName;
    String[] pokers;
    int strength = 0;
    public Poker(){
    }
    public Poker(String p_playerName,String[] p_pokers){
        this.playerName = p_playerName;
        this.pokers = p_pokers;
    }
    public void setStrength(int p_strength){
        if(p_strength > this.strength){
            this.strength = p_strength;
        }
    }
}