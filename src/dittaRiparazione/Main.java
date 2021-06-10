package dittaRiparazione;

public class Main {
     public static void main(String[] args) {
          Tecnico[] tecnici = new Tecnico[5];
          tecnici[0] = new Tecnico("Mario",StatoTecnico.libero);
          tecnici[1] = new Tecnico("Daniele",StatoTecnico.libero);
          tecnici[2] = new Tecnico("Mario",StatoTecnico.libero);
          tecnici[3] = new Tecnico("Giovanni",StatoTecnico.libero);
          tecnici[4] = new Tecnico("Francesco",StatoTecnico.libero);

          Riparazione[] riparazioni = new Riparazione[3];
          riparazioni[0] = new Riparazione("viale delle vittorie",1,StatoRiparazione.inAttesa);
          riparazioni[1] = new Riparazione("via delle marche",3,StatoRiparazione.inAttesa);
          riparazioni[2] = new Riparazione("Casa pozzuoli",5,StatoRiparazione.completata);

          DittaRiparazioni ditta = new DittaRiparazioni(tecnici,riparazioni);
          ditta.aggiungiTecnico(new Tecnico("Franco",StatoTecnico.libero));
          ditta.aggiungiRiparazione(new Riparazione("via pesciolone",4,StatoRiparazione.inAttesa));
          ditta.concludiRiparazioni(riparazioni[0]);
          ditta.stampaRiparazioneMaggiorePriorita();
     }
}
