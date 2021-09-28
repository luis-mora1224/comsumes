package com.example.demo.services.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Service;

import com.example.demo.services.IHttpConsumes;

@Service
public class IHttpConsumesImpl implements IHttpConsumes{

	@Override
	public String sendGet() {
		String respuesta = "";
		try{

		String USER_AGENT = "Mozilla/5.0";
		System.out.println("Hola mundo");
		String url = "http://www.google.com/search?q=mkyong";
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		// el valor predeterminado es get
		con.setRequestProperty("User-Agent", USER_AGENT);
		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : "+ url);
		System.out.println("Response Code : "+ responseCode);
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
		while((inputLine = in.readLine()) != null){
			response.append(inputLine);
		}
		in.close();

		//imprime el resultado

		respuesta = response.toString();
		}catch(IOException ex){
			ex.printStackTrace();
		}
		return respuesta;
	}

}
