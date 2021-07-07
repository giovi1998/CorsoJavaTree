package gsonExample;

//TUTORIAL https://www.youtube.com/watch?v=y96VcLgOJqA
import com.google.gson.*;
import org.codehaus.jackson.map.ObjectMapper;
import java.io.File;
import java.io.IOException;


//trovato pojo per trasformare json->java object
//poi ho instalato Jackson
public class Main {

    public static void main(String[] args) throws IOException {

        String json = "{\"brand\":\"Jeep\", " +
                "\"doors\": 3}";

        Gson gson = new Gson();

        Car car = gson.fromJson(json, Car.class);
        Car car1 = new Car();
        car1.brand = "Toyata";
        car1.doors = 4;
        String json1 = gson.toJson(car1);
        System.out.println(json);
        System.out.println(json1);
        System.out.println(car);
        System.out.println(car1);


        //Stringa da internet
        /*String json2 = "{ \"title\": \"Computing and Information systems\"," +
                "\" id \" :1, " +
                "\" children \" :true, " +
                "\" groups \": [{\"\"title\":\"Level one CIS\", \"id\":2, \"children\":true,]}" +
                "\"groups\":[{\"title\":\"Intro To Computing and Internet\", \"id\":3, \"children\":false,]}" +
                "\"groups\":[{}]}";

        String json2 =
                "{"
                        + "'title': 'Computing and Information systems',"
                        + "'id' : 1,"
                        + "'children' : 'true',"
                        + "'groups' : [{"
                        + "'title' : 'Level one CIS',"
                        + "'id' : 2,"
                        + "'children' : 'true',"
                        + "'groups' : [{"
                        + "'title' : 'Intro To Computing and Internet',"
                        + "'id' : 3,"
                        + "'children': 'false',"
                        + "'groups':[]"
                        + "}]"
                        + "}]"
                        + "}";


        Data data = new Gson().fromJson(json2, Data.class);
        String json4 = gson.toJson(data);*/

        //in questo modo ci vuole sia la classe che il file JSON
        ObjectMapper mapper = new ObjectMapper();
        try {
            File jsonInputFile = new File("C:\\Users\\Giovanni\\IdeaProjects\\CorsoJavaTree\\src\\gsonExample\\JsonInput");
            Staff emp = mapper.readValue(jsonInputFile, Staff.class);
            System.out.println(emp);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }
}
