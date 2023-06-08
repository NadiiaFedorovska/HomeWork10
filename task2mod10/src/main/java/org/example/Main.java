package org.example;

import com.google.gson.Gson;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final String PATH_FILE = "D:\\My_folder\\GoIT\\modul10\\task2mod10\\src\\resource\\file2.txt";
    private static final String PATH_FILE_JSON = "D:\\My_folder\\GoIT\\modul10\\task2mod10\\src\\resource\\user.json";
    public static void main(String[] args) {
        Gson gson = new Gson();

        File file = new File(PATH_FILE);
        File file2 = new File(PATH_FILE_JSON);
        List<User> users = new ArrayList<>();
        String[] parts = new String[2];

        if (!file.exists()){
            throw new RuntimeException("File with name " + file.getName() + " is not exist!");
        }

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String header = bufferedReader.readLine();
            String line;

            while ((line = bufferedReader.readLine()) != null){
                    parts = line.split(" ");
                    String name = parts[0];
//                    System.out.println(name);
                    int age = Integer.parseInt(parts[1]);
//                    System.out.println(age);
                    User user = new User(name, age);
                    users.add(user);
            }

//            String json = gson.toJson(users);
//            System.out.println(json);

        } catch (IOException e){
            System.out.println(e.getMessage());
        }

        if (!file2.exists()){
            file2.getParentFile().mkdirs();
            try {
                file2.createNewFile();
            }catch (IOException t){
                System.out.println(t.getMessage());
            }
        }

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file2))){
            bufferedWriter.write(gson.toJson(users));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}