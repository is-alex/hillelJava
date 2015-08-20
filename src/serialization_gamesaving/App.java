package serialization_gamesaving;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.*;

public class App {
    public static void main(String[] args) throws IOException, JsonIOException, JsonSyntaxException {
        CharacterType elf = new CharacterType("elf","blue");
        CharacterType ork = new CharacterType("ork","green");
        Writer writer = null;
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Type listOfGameCharacters = new TypeToken<List<GameCharacter>>(){}.getType();
//save
//        GameCharacter firstPlayer =
//                new GameCharacter(100,"Legolas", elf,new String[]{"sword", "bow"});
//        GameCharacter secondPlayer =
//                new GameCharacter(85,"Ork", ork, new String[]{"hands", "axe"});
//
//        List<GameCharacter> list = new ArrayList<>();
//        list.add(firstPlayer);
//        list.add(secondPlayer);
//        String json = gson.toJson(list, listOfGameCharacters);
//
//        try {
//            FileOutputStream out = new FileOutputStream("save.json");
//            writer = new OutputStreamWriter(out);
//            writer.write(json);
//
//        } catch(IOException e) {
//            System.err.println("Can't write to disk!");
//            e.printStackTrace();
//
//        } finally {
//            if (writer != null) {
//                try {
//                    writer.close();
//                }
//                catch (IOException e){
//                    e.printStackTrace();
//                }
//            }
//        }

//restore
        GameCharacter restoredFirstPlayer = null;
        GameCharacter restoredSecondPlayer = null;
        Reader reader = null;
        List<GameCharacter> list2 = null;

        try {
            reader = new InputStreamReader(new FileInputStream("save.json"));
            list2 = gson.fromJson(reader, listOfGameCharacters);

        } catch (JsonIOException e) {
            e.printStackTrace();

        } catch (JsonSyntaxException e) {
            e.printStackTrace();

        } finally {

            if (reader != null) {
                try {
                    reader.close();
                }
                catch (IOException e){
                    e.printStackTrace();
                }
            }
        }

        if (!list2.isEmpty()) {
            restoredFirstPlayer = list2.get(0);
            restoredSecondPlayer = list2.get(1);
        }
        System.out.println(restoredFirstPlayer);
        System.out.println(restoredSecondPlayer);
    }

}