
public class Card {
	private String cardClass;
	private Integer cardval;
	public Card(){
		this.cardClass = "";
		this.cardval = 0;
	}
	public String GetCardClass(){
		return this.cardClass;
	}
	public int GetCardval(){
		return this.cardval;
	}
	public void SetCardClass(String cc){
		this.cardClass = cc;
	}
	public void setCardval(int val){
		this.cardval = val;
	}
}
