package com.poo.brincandisedivertindis.util;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;

public class JsonPP {

    public JsonPP(){

    }

    public void escreverJson(String caminho){

    }

    public void lerJson(String caminho){
        JSONParser parser = new JSONParser();

        try (Reader reader = new FileReader(caminho)) {

            JSONObject jsonObject = (JSONObject) parser.parse(reader);

            // loop array
            JSONArray msg = (JSONArray) jsonObject.get("veiculos");
            Iterator<String> iterator = msg.iterator();

            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void criarArquivo(String caminho, String json){
        try {
            FileWriter writeFile = new FileWriter(caminho);
            writeFile.write(json);
            writeFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
