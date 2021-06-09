package giorni.giorno3;
import java.util.Arrays;

public class Es14 {

    public static void main(String[] args) {

        int [] nums = new int []{0,15,1,2,0,3,4,4,0,0};
        int i=0;
        int zero=0; //posizione zero

        Arrays.sort(nums);
        int max = Integer.MAX_VALUE;

        System.out.println("questo è " + max);


        //conta num zero=3
        for(i=0;i<nums.length;i++)
        {
            if(nums[i]==0)
            {
                zero++;
            }
        }

        System.out.println("contatore zeri "+ zero);



        for(i=0;i<nums.length-zero;i++)
        {
            nums[i]=nums[zero+i];
            nums[zero+i]=0;


        }
        for(i=0;i<nums.length;i++)
        {
            System.out.print(nums[i]);
        }


    }

}
