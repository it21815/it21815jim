/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opii_21815_21873;

import java.io.IOException;
import java.util.ArrayList;
import static opii_21815_21873.OpenData.RetrieveData;

/**
 *
 * @author jimge
 */
public class City {
    String city_name;
    String city_transportation;
    String city_museum;
    String city_CafeRestaurantBar;
    String city_weather;
    double city_lat;
    double city_lon;
    String city_landscape;

    public City(String city_name, String city_transportation, String city_museum, String city_CafeRestaurantBar, String city_weather, double city_lat, double city_lon, String city_landscape) {
        this.city_name = city_name;
        this.city_transportation = city_transportation;
        this.city_museum = city_museum;
        this.city_CafeRestaurantBar = city_CafeRestaurantBar;
        this.city_weather = city_weather;
        this.city_lat = city_lat;
        this.city_lon = city_lon;
        this.city_landscape = city_landscape;
    }
    
    public void ExtractData(String cityname,String countrycode ) throws IOException{
    final String appid = "e27f01b38bd82529d49eaf427bb6d307";
    ArrayList<String> STR  = new ArrayList<String>();
    STR.clear();  
    System.out.print("Please wait while we try to retreive the necessary information...\n ");
    try {
        
        STR = RetrieveData(cityname,countrycode,appid);                              
        //Weather (Clouds), lat/lon , Article wiki gia city kai to size tou arthrou
        System.out.println ("\nSuccess");
        }catch(NullPointerException e){
            System.out.print("Could not find information for the requested city!The proccess was not successfull\n");
            
        }             
    
        this.city_name=cityname;
        this.city_weather = STR.get(0);        
        this.city_lat = Double.parseDouble(STR.get(1));
        this.city_lon = Double.parseDouble(STR.get(2));        
       
        try{
            this.city_museum = STR.get(4).substring(STR.get(4).indexOf("Museums")/*,STR.get(4).lastIndexOf("museum")*/);
            //this.city_transportation = STR.get(4).substring(STR.get(4).indexOf("Transportarion")/*,STR.get(4).lastIndexOf("airport")*/);
            if (STR.get(4).contains("Transportartion")){
                this.city_transportation = STR.get(4).substring(STR.get(4).indexOf("Transportation"),STR.get(4).lastIndexOf("airport"));
            }else{
                this.city_transportation = STR.get(4).substring(STR.get(4).indexOf("Transport"),STR.get(4).lastIndexOf("airport"));
            }
            if(STR.get(4).contains("reastaurant")){
                  this.city_CafeRestaurantBar = STR.get(4).substring(STR.get(4).indexOf("restaurants")/*,STR.get(4).lastIndexOf("bars")*/);            
            }else if(STR.get(4).contains("cafe")){
                this.city_CafeRestaurantBar = STR.get(4).substring(STR.get(4).indexOf("cafe")/*,STR.get(4).lastIndexOf("bars")*/);            
            }else if(STR.get(4).contains("bar")){
                this.city_CafeRestaurantBar = STR.get(4).substring(STR.get(4).indexOf("bar")/*,STR.get(4).lastIndexOf("bars")*/);                                        
            }
            if(STR.get(4).contains("Geography")){
                this.city_landscape = STR.get(4).substring(STR.get(4).indexOf("Geography"),STR.get(4).lastIndexOf("Climate")); 
            }else if(STR.get(4).contains("Plain")){
                    this.city_landscape = STR.get(4).substring(STR.get(4).indexOf("Plain"),STR.get(4).lastIndexOf("Climate"));                                          
            }        
            
            
        }catch(StringIndexOutOfBoundsException e){
            System.out.print("Could not retreive all the data for the given city. Something went. Wrong 404!!!\n");
        }catch(NullPointerException e){
            System.out.print("Could not resort the given city. For more info do not contact us!\n");        
        }catch(IndexOutOfBoundsException e){
            System.out.print("Could not resort the given city.\n");     
        }  
        
        
       
    }    
    
    
    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public String getCity_Transportation() {
        return city_transportation;
    }

    public void setCity_Transportation(String city_transportation) {
        this.city_transportation = city_transportation;
    }

    public String getCity_museum() {
        return city_museum;
    }

    public void setCity_museum(String city_museum) {
        this.city_museum = city_museum;
    }

    public String getCity_CafeRestaurantBar() {
        return city_CafeRestaurantBar;
    }

    public void setCity_CafeRestaurantBar(String city_CafeRestaurantBar) {
        this.city_CafeRestaurantBar = city_CafeRestaurantBar;
    }

    public String getCity_weather() {
        return city_weather;
    }

    public void setCity_weather(String city_weather) {
        this.city_weather = city_weather;
    }

    public double getCity_lat() {
        return city_lat;
    }

    public void setCity_lat(double city_lat) {
        this.city_lat = city_lat;
    }

    public double getCity_lon() {
        return city_lon;
    }

    public void setCity_lon(double city_lon) {
        this.city_lon = city_lon;
    }

    public String getCity_landscape() {
        return city_landscape;
    }

    public void setCity_landscape(String city_landscape) {
        this.city_landscape = city_landscape;
    }

    
    
    
   
    
    
    
    
    
    
    
}
