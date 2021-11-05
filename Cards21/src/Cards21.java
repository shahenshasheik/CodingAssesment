import java.util.Scanner;

public class Cards21 {
	public static void main(String[] args){
		String numOfPlayersStr = args[0];
		Scanner sc = null;
		Player dealer = null;
		try{
			int numOfPlayers = Integer.parseInt(numOfPlayersStr);
			System.out.println("Starting with " + numOfPlayersStr + " players");
			CardDeck cd = new CardDeck();
			System.out.println("shuffling");
			cd.Shuffle();

			dealer = new Player();
			Player[] pls = new Player[numOfPlayers];
			for(int i = 0; i < numOfPlayers; i++){
				pls[i] = new Player();
				pls[i].SetCard(cd.GetCard());
				System.out.println("Dealing to player " + (i + 1) + ", card: " + pls[i].GetCardsSum());
			}
			dealer.SetCard(cd.GetCard());
			System.out.println("Dealing to computer, card: face down");
			sc = new Scanner(System.in);
			int index = 1;
			while(numOfPlayers > 0){
				System.out.print("Dealing to player "+index +", cards: "+pls[index-1].GetCardsSumString() +". Hit or Stand? >");
				String line = sc.nextLine();
				if(line.contains("stand")){
					numOfPlayers--;
					index++;
				}else{
					pls[index-1].SetCard(cd.GetCard());
				}
			}
			while(numOfPlayers == 0){
				System.out.print("Dealing to computer, cards: "+ dealer.GetCardsSumString()+". Hit or Stand? >");
				String line = sc.nextLine();
				if(line.contains("stand")){
					numOfPlayers--;
				}else{
					dealer.SetCard(cd.GetCard());
				}
			}
			sc.close();
			for(int i = 0; i < pls.length;i++)
			{
				if(pls[i].GetCardsSum() > 21)
				{
					if(dealer.GetCardsSum() > 21)
					{
						System.out.println("Scoring player " + (i + 1) + " is busted. Dealer also busted");
					}
					else{
						System.out.println("Scoring player " + (i + 1) + " is busted. Dealer wins");
					}
				}else {
					if(dealer.GetCardsSum() > 21)
					{
						System.out.println("Scoring player " + (i + 1) + " has " + pls[i].GetCardsSum() + ",dealer has " + dealer.GetCardsSum() + " Player " + (i + 1) + " wins");
					}
					else
					{
						if(pls[i].GetCardsSum() == dealer.GetCardsSum()){
							System.out.println("Scoring player " + (i + 1) + " has " + pls[i].GetCardsSum() + ",dealer has " + dealer.GetCardsSum() + " Dealer wins");
						}
						else if(pls[i].GetCardsSum() < dealer.GetCardsSum())
						{
							System.out.println("Scoring player " + (i + 1) + " has " + pls[i].GetCardsSum() + ",dealer has " + dealer.GetCardsSum() + " Dealer wins");
						}
						else{
							System.out.println("Scoring player " + (i + 1) + " has " + pls[i].GetCardsSum() + ",dealer has " + dealer.GetCardsSum() + " Player " + (i + 1) + " wins");
						}
					}
				}
			}
		}catch(Exception ex){
			System.out.println("Exception raised: "+ex.getMessage());
			sc.close();
		}
	}
}
