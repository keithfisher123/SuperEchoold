/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keithfisher.superecho;

import org.apache.commons.codec.binary.Base64;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

/**
 *
 * @author 
 */
public class Insteon {
    private String hubIP;
    private String hubPort;
    private String hubPass;
    private String hubUser;
    private final HttpClient httpclient = HttpClientBuilder.create().build();
    private final String USER_AGENT = "Mozilla/5.0";

 
    public Insteon(String hubIP, String hubPort, String hubPass, String hubUser){
        this.hubIP=hubIP;
        this.hubPass=hubPass;
        this.hubPort=hubPort;
        this.hubUser=hubUser;
    }
    
    public void authenticate(){
    
    }
    
    public void setDevice(String device, int Status) throws IOException{
        
   // admin:firefly@http://192.168.1.110:25105/3?02621dcd69 
    
   // 0F1300=I=3 off
   // 0F11FF=I=3 on
        
        
    
        String url = "http://admin:firefly1@192.168.1.110:25105/3?02621dcd69";
       if (Status==1){
            url = url+"0F11FF=I=3";
       }
       if (Status==2){
            url = url+"0F1300=I=3";
       }
       
 
		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet(url);
 
		// add request header
		request.addHeader("User-Agent", USER_AGENT);
 
		HttpResponse response = client.execute(request);
 
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + 
                       response.getStatusLine().getStatusCode());
 
		BufferedReader rd = new BufferedReader(
                       new InputStreamReader(response.getEntity().getContent()));
 
		StringBuffer result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}
 
		System.out.println(result.toString());
 
	}
        
        
    
}
