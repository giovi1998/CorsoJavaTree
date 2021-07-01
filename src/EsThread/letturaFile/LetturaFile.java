package EsThread.letturaFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LetturaFile {
    private final String fileNameInCuiScrivere;
    private final String fileNameDaCuiPrendoIDati;
    List<String> allLines;

    int countLines;

    //costruttore che passa il particolare
    public LetturaFile(String myFileName, String fileInCuiScrivere) {
        this.fileNameDaCuiPrendoIDati = "C:\\Users\\Giovanni\\IdeaProjects\\CorsoJavaTree\\src\\EsThread\\letturaFile\\" + myFileName + ".txt";
        this.fileNameInCuiScrivere = "C:\\Users\\Giovanni\\IdeaProjects\\CorsoJavaTree\\src\\EsThread\\letturaFile\\" + fileInCuiScrivere + ".txt";
        this.allLines = letturaDiTuttoIlFile();
    }

    public List<String> letturaDiTuttoIlFile() {

        List<String> result = new ArrayList<>();
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(fileNameDaCuiPrendoIDati));

            String line;
            while ((line = br.readLine()) != null) {
                if (allLines == null) {
                    countLines++;
                    if (checkCovid(line)) {
                        result.add(line);
                    }
                } else {
                    if (!allLines.contains(line)) {
                        countLines++;
                        if (checkCovid(line)) {
                            /*scriviRiga(line);*/
                            result.add(line);
                        }
                    }
                }

            }

            return result;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    public synchronized boolean checkCovid(String line) {
        /*
         * partiDellaStringa[0]==id Utente
         * partiDellaStringa[1]==temperatura
         * partiDellaStringa[2]==eta
         * partiDellaStringa[3]==GUSTO
         * partiDellaStringa[4]==TOsse
         * partiDellaStringa[5]==Debolezza
         * partiDellaStringa[6]==SItuazione
         */

        if (line.contains(";") && !(line.split(";").length <6)) { //splito
            String[] partiDellaStringa = line.split(";");
            double temperatura = Double.parseDouble(partiDellaStringa[1]);
            int eta = Integer.parseInt(partiDellaStringa[2]);
            boolean gusto = Boolean.parseBoolean(partiDellaStringa[3]);
            boolean tosse = Boolean.parseBoolean(partiDellaStringa[4]);
            boolean debolezza = Boolean.parseBoolean(partiDellaStringa[5]);
            String situazione = partiDellaStringa[6];





            if (temperatura >= 40) {
                return true;
            }else if (temperatura >= 38 && gusto && tosse && debolezza)
                return true;

            else if (situazione.equals("CRITICA")) return true;
            else if (temperatura >= 38.5 || gusto || tosse || debolezza) return true;
            else if (eta >= 50 && temperatura >= 37) return true;
            else return eta >= 60 &&((gusto && situazione.equals("CAUTELA"))||(tosse && situazione.equals("CRITICA")));
        }
        else return false;

    }

    @SuppressWarnings({})
    //troppo lenta
    /*public synchronized void scriviRiga(String line) {

        try (PrintStream out = new PrintStream(new FileOutputStream(fileNameInCuiScrivere, true))) {
            out.append("\n".concat(line));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
*/
    public synchronized void scriviTuttoIlFile() {

        try {
            FileWriter writer = new FileWriter(fileNameInCuiScrivere);
            for (String str : allLines) {
                writer.write(str + System.lineSeparator());
            }
            writer.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
