package EsThread.letturaFile;

public class Main {
    public static void main(String[] args) {

        Thread t1=new Thread(new LetturaFile("nord","covid"));
        Thread t2=new Thread(new LetturaFile("centro","covid"));
        Thread t3=new Thread(new LetturaFile("sud","covid"));

       t1.start();
       t2.start();
       t3.start();
       try{
           System.out.println("sono nel try");
           t1.join();
           t2.join();
           t3.join();
       }catch (InterruptedException e) {
           e.printStackTrace();
       }
        System.out.println("fine");
       /*String line="ciao;a;tutti";
        System.out.println(line.split(";").length);
*/
    }
}
