package EsThread.letturaFile;

public class Thread extends java.lang.Thread {
    private LetturaFile myfiles;

    public Thread(LetturaFile myfile) {
        this.myfiles = myfile;
    }

    @Override
    public void run() {
       /*myfiles.letturaDiTuttoIlFile();*/
        myfiles.scriviTuttoIlFile();
    }

}
