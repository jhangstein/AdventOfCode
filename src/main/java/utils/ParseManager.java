package utils;

import io.github.cdimascio.dotenv.Dotenv;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ParseManager {


    public ArrayList<String> transformFileToListOfStrings(String filename){
        Dotenv dotenv = Dotenv.load();
        String path = dotenv.get("FILE_PATH");
        ArrayList<String> list = new ArrayList<>();
        File file = new File(path + filename);
        String st;
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));
            while ((st = br.readLine()) != null){
                list.add(st);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        return list;
    }
}
