package giorni.EsercizioLet;
//https://leetcode.com/problems/rotate-array/

class Solution {
    private int temp;
    private int [] vet;




    public void rotate(int[] nums, int k) {
        //salviamo dentro classe
        this.vet=nums;
        //qui sovrascrive
        for(int i=0;i<k;i++){
            vet=shiftaADestra();
            vet[0]=temp;
        }

    }
    public int [] shiftaADestra ()
    {
        temp=vet[vet.length-1];
        for(int i = vet.length-1; i>0; i--){
            vet[i]=vet[i-1];
        }

        vet[0]=temp;

        return vet;
    }

    public static void main(String[] args) {
        int [] nums={1,2,3};
        int k=2;
        Solution soluzione=new Solution();
        soluzione.rotate(nums,k);
    }
}