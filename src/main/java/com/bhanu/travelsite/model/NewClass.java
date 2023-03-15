/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bhanu.travelsite.model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;


public class NewClass {
    public static JSONObject function() throws Exception {
        try {
            URL url = new URL("https://parseapi.back4app.com/classes/Car_Model_List?limit=100000&excludeKeys=Year");
            HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
            urlConnection.setRequestProperty("X-Parse-Application-Id", "hlhoNKjOvEhqzcVAJ1lxjicJLZNVv36GdbboZj3Z"); // This is the fake app's application id
            urlConnection.setRequestProperty("X-Parse-Master-Key", "SNMJJF0CZZhTPhLDIqGhTlUNV9r60M2Z5spyWfXW"); // This is the fake app's readonly master key
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                StringBuilder stringBuilder = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    stringBuilder.append(line);
                }
                return new JSONObject(stringBuilder.toString()); // Here you have the data that you need
            } finally {
                urlConnection.disconnect();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
        return null;
    }
}
