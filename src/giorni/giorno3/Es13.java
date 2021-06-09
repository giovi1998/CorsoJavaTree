package giorni.giorno3;

public class Es13 {

    public static void main(String[] args) {
        int[] nums1= {3,4,5,0,0,0};
        int m=3;
        int[] nums2 = {2,3,4};
        int n=3;

        //num1.lenght==m+n
        //nums2.length == n
        int temp=0;
        //unisce i due array
        for(int i=0;i<=n-1;i++)
        {
            nums1[m+i]=nums2[i];
        }

        //ordiniamo
        for(int j=0;j<m+n-1;j++)
        {
            //una riga
            for(int i=0;i<m+n-1;i++)
            {
                if(nums1[i]>=nums1[i+1])
                {
                    temp=nums1[i];
                    nums1[i]=nums1[i+1];
                    nums1[i]=temp;
                }
                System.out.print(nums1[i]);
            }



        }
    }
}

