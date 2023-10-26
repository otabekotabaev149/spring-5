package org.javacoders;

import java.net.URI;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Main {
	private static URI COUNTRY_DATA_URL;

	public static void main(String[] args) {
//		String url = "https://rickandmortyapi.com/api/character/";
		String GLOBAL_DATA_URL = "http://localhost:8080/covid-19/global-data";
		
		try (CloseableHttpClient client = HttpClients.createDefault()){
			HttpGet globalDataRequest = new HttpGet(GLOBAL_DATA_URL);
			
			try (CloseableHttpResponse globalDataResponse = client.execute(globalDataRequest)){
				HttpEntity globalDataEntity = globalDataResponse.getEntity();
				
				if(globalDataEntity != null) {
					String result = EntityUtils.toString(globalDataEntity);
					JsonObject json = JsonParser.parseString(result).getAsJsonObject();
					System.out.println(json.get("recovered"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
//		
//		try (CloseableHttpClient client = HttpClients.createDefault()){
//		
//			HttpGet request = new HttpGet(url);
//			
//			try (CloseableHttpResponse response = client.execute(request)){
//			
//				HttpEntity entity = response.getEntity();
//				
//				if(entity != null) {
//				
//					String result = EntityUtils.toString(entity);
//					
//					JsonObject json = JsonParser.parseString(result).getAsJsonObject();
//					
//					JsonArray characters = json.getAsJsonArray("results");
//					
//					for(int i=0;i<characters.size();i++) {
//						JsonObject character = characters.get(i).getAsJsonObject();
//						String name = character.get("name").getAsString();
//						System.out.println(name);
//					}
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

//public class RickAndMortyApiDemo {
//
//    public static void main(String[] args) {
//        String url = "https://rickandmortyapi.com/api/character/";
//
//        try (CloseableHttpClient client = HttpClients.createDefault()) {
//            HttpGet request = new HttpGet(url);
//
//            try (CloseableHttpResponse response = client.execute(request)) {
//                HttpEntity entity = response.getEntity();
//                if (entity != null) {
//                    String result = EntityUtils.toString(entity);
//                    JsonObject json = JsonParser.parseString(result).getAsJsonObject();
//                    JsonArray characters = json.getAsJsonArray("results");
//
//                    for (int i = 0; i < characters.size(); i++) {
//                        JsonObject character = characters.get(i).getAsJsonObject();
//                        String name = character.get("name").getAsString();
//                        System.out.println(name);
//                    }
//                }
//            } catch (Exception e) {
//            	e.printStackTrace();
//			}
//        } catch (Exception e1) {
//        	e1.printStackTrace();}
//		}
//    }
//}
//
