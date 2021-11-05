import java.util.ArrayList;

public class Player {
    private ArrayList<Card> m_cards;
    Player(){
        m_cards = new ArrayList<>();
    }
    public void SetCard(int num){
    	Card cc = new Card();
    	int val = num%13 + 1;
    	if(num <= 13)
    	{
    		cc.SetCardClass("Hearts");
    		cc.setCardval(val);
    	}
    	else if( num > 13 && num <= 26)
    	{
    		cc.SetCardClass("Spades");
    		cc.setCardval(val);
    	}
    	else if(num > 26 && num <= 39)
    	{
    		cc.SetCardClass("Clubs");
    		cc.setCardval(val);
    	}
    	else{
    		cc.SetCardClass("Diamonds");
    		cc.setCardval(val);
    	}
        m_cards.add(cc);
    }
    public int GetCardsSum(){
    	int m_localsum = 0;
        for(int i = 0; i < m_cards.size();i++){
            m_localsum += m_cards.get(i).GetCardval();
        }
        return m_localsum;
    }
    public String GetCardsSumString(){
    	String m_localsum = "";
        for(int i = 0; i < m_cards.size();i++){
            m_localsum += m_cards.get(i).GetCardval() + " "+ m_cards.get(i).GetCardClass() + ", ";
        }
        return m_localsum;
    }
}
