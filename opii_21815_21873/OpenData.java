package opii_21815_21873;

import java.io.IOException;
import java.net.URL;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import weather.OpenWeatherMap;
import wikipedia.MediaWiki;

/**City description and weather information using OpenData with Jackson JSON processor.
* @since 29-2-2020
* @version 1.0
* @author John Violos */
public class OpenData {

/**Retrieves weather information, geotag (lan, lon) and a Wikipedia article for a given city.
* @param city The Wikipedia article and OpenWeatherMap city. 
* @param country The country initials (i.e. gr, it, de). 
* @param appid Your API key of the OpenWeatherMap. 
     * @return  
     * @throws java.io.IOException*/ 
    
 public static ArrayList RetrieveData(String city, String country, String appid) throws  IOException {
	 ObjectMapper mapper = new ObjectMapper(); 
         ArrayList <String> str = new ArrayList();
         str.clear();        
	 OpenWeatherMap weather_obj = mapper.readValue(new URL("http://api.openweathermap.org/data/2.5/weather?q="+city+","+country+"&APPID="+appid+""), OpenWeatherMap.class);	
         str.add((weather_obj.getWeather()).get(0).getMain()) ;         
         str.add(weather_obj.getCoord().getLat().toString());
         str.add(weather_obj.getCoord().getLon().toString());	 
	 try{
             MediaWiki mediaWiki_obj =  mapper.readValue(new URL("https://en.wikipedia.org/w/api.php?action=query&prop=extracts&titles="+city+"&format=json&formatversion=2"),MediaWiki.class);
             int tmp =mediaWiki_obj.getQuery().getPages().get(0).getExtract().length();
             str.add("Size of Article:"+tmp);
             str.add(city+" Wikipedia article: "+mediaWiki_obj.getQuery().getPages().get(0).getExtract());
         }catch(FileNotFoundException e){
             System.out.print("The given city does not match any data on wiki.\n");
         }             
         return str;                      
 }

        //System.out.println(city+" temperature: " + (weather_obj.getMain()).getTemp());
/*public static void main(String[] args) throws IOException {
	String appid ="";
	RetrieveData("Rome","it",appid);	
	RetrieveData("Athens","gr",appid);
	RetrieveData("Corfu","gr",appid);	
	RetrieveData("Berlin","de",appid);	
}*/

}