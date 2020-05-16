package com.dilip.exoplanetcatalogue.util;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonFormatter {
	private static HttpURLConnection getConnection(String url) throws IOException{
		URL urlForGetRequest = new URL(url);

		HttpURLConnection connection = (HttpURLConnection) urlForGetRequest.openConnection(); 
		return connection;
	}
	
	public static Object parseUrl(String url) throws IOException, ParseException{

		HttpURLConnection conection =  getConnection(url); 
		String readLine = null;
		int responseCode = conection.getResponseCode();
		if (responseCode == HttpURLConnection.HTTP_OK) {
			BufferedReader in = new BufferedReader(
					new InputStreamReader(conection.getInputStream()));
			StringBuffer response = new StringBuffer();
			while ((readLine = in .readLine()) != null) {
				response.append(readLine+"\n");
			} in .close();
			JSONParser parser = new JSONParser();
			return  parser.parse(response.toString());
		} else {
			return null;
		}
	}
	
	public static Object parseFile(String filePath) throws IOException, ParseException{

		File file = new File(filePath);
		if(!file.exists())
			return null;
		
		String readLine = null;
			BufferedReader in = new BufferedReader(
					new InputStreamReader(new FileInputStream(file)));
			StringBuffer response = new StringBuffer();
			while ((readLine = in .readLine()) != null) {
				response.append(readLine+"\n");
			} in .close();
			JSONParser parser = new JSONParser();
			return  parser.parse(response.toString());
	}
	

}
