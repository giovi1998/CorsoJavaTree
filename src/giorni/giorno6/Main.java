package giorni.giorno6;

public class Main {
    public static void main(String[] args) {
        Iterable miaStringa= new MiaStringa("jasdjhdsa");
        System.out.println(miaStringa);
        int [ ] array ={3,4,6,1};
        Iterable lista =new ListaDiInteri(array);
        System.out.println(lista);
        for (int i:array) {
            if( lista.hasNext()) {
                lista.next();
                System.out.println(lista);
            }
        }
        lista.reset();
        System.out.println(lista);

    }
}
