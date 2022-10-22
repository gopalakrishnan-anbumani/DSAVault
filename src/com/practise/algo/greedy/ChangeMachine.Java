//Greedt Algo : Change Machine Problem. It's not the CoinChange problem which belogs to DP
//Eduactive Problem
class ChangeMachine 
{
  // a public collection of available coins
  public static int [] coins = {25, 10, 5, 1}; 

  public static  ArrayList<Integer> getMinCoins(int amount)  // function to recieve change in the form of coins
  {
    ArrayList<Integer> change = new ArrayList<Integer>();
    
    for(int coin : coins){
        int count = amount/coin;
        if(count!=0){
          for(int i=0;i<count;i++){
            change.add(coin);
          }
        }
        amount = amount % coin;
    }
    return change;
  }
