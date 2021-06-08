package dittaRiparazione;

public class Main {
     public static void main (String args[]){
          Tecnico [] tecnici = new Tecnico[3];
          Riparazione [] riparazioni= new Riparazione[3];
          tecnici[0]=new Tecnico("Giovanni",21);
          tecnici[1]=new Tecnico("Maria",2127);
          tecnici[2]=new Tecnico("Yari",2216);

          riparazioni[0]= new Riparazione("via ada negri",2);
          riparazioni[1]= new Riparazione("via Roma",3);
          riparazioni[2]= new Riparazione("via Italia",1);



          DittaRiparazioni ditta=new DittaRiparazioni(tecnici, riparazioni);

          //ditta.stampaListaTecnici();

          //ditta.assegnaRiparazione();
          ditta.ordinaRipazioneInBaseAPriorita();
          ditta.ordinaRipazioneInBaseAPriorita();
          ditta.ordinaRipazioneInBaseAPriorita();
          ditta.stampaRiparazioni();

          ditta.aggiungiTecnico(new Tecnico("Daniele",2316));
          ditta.aggiungiRiparazione(new Riparazione("via sardegna",1));

         // ditta.stampaRiparazioni();
          //ditta.stampaRiparazioniAttesa();
     }
}
