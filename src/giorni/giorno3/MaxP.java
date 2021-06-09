package giorni.giorno3;

public class MaxP {

    public static void main(String[] args)
    {
        int [] Prezzi ={7,1,5,3,6,4};
        System.out.println(maxProfit(Prezzi));
    }

    public static int maxProfit(int[] prezzo) {
        if(prezzo.length==0)
        {
            return  0;
        }
        int maxProfit = 0;
        for(int i=1;i<prezzo.length;i++)
        {
            //faccio la comparazione tra il minimo locale e il massimo
            if(prezzo[i]>prezzo[i-1])
            {
                maxProfit+= (prezzo[i]-prezzo[i-1]);
            }
        }
        return maxProfit;
    }
}

