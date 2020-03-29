/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opii_21815_21873;

import java.util.ArrayList;

public class Traveller {
    public String name;
    int age;
    public String transportation;
    public double current_lan;
    public double current_lon;
    private static int Ntravellers; 
    public String weather;
    public String museum;
    public String CafeRestaurantBar;
    public String landscape;
    public String cities;
    
    
    
    public Traveller(String name, int age, String transportation,double current_lan, double current_lon, String weather, String museum, String CafeRestaurantBar,String landscape, String cities) {
        this.name = name;
        this.age = age;
        this.transportation= transportation;
        this.current_lan = current_lan;
        this.current_lon = current_lon;
        this.weather = weather;
        this.museum = museum;
        this.CafeRestaurantBar = CafeRestaurantBar;
        this.landscape= landscape;
        this.cities=cities;
    }

    public String getCities() {
        return cities;
    }

    public void setCities(String cities) {
        this.cities = cities;
    }

    Traveller() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public double Similarity(City temp_city,ArrayList<String> criteria){
       double similarity=1;
       double sum_similarity = 0;
       //System.out.println("Weather: "+temp_city.city_weather+"\nLAN: "+temp_city.city_lat+"\nLON: "+temp_city.city_lon+"\nMuseums: "+temp_city.city_museum+"\nLandScape: "+temp_city.city_landscape+"\nCAFESRESTAURANTBAR: "+ temp_city.city_CafeRestaurantBar+"\nTransportation: "+temp_city.city_transportation);       
       
       //Transport                
        if(criteria.contains("Metro") ){
            try{
                if ( temp_city.city_transportation.contains("metro")){
                    similarity++;
                
                }
            }catch(NullPointerException e){
                System.out.print("Could not find all the given criteria in :" +temp_city.city_name);            }    
        } else if (criteria.contains("Bus")) {
            try{
                if ( temp_city.city_transportation.contains("bus")){
                    similarity++;                
                
                }
            }catch(NullPointerException e){
                System.out.print("Could not find all the given criteria in :" +temp_city.city_name);            }    
           
        }else if(criteria.contains("Airport")){
            try{  
                if ( temp_city.city_transportation.contains("airport")){
                    similarity++;
                
                }
            }catch(NullPointerException e){
                System.out.print("Could not find all the given criteria in :" +temp_city.city_name);            }    
        }
        
        //WEATHER       
       if(criteria.contains("Clear") ){
            if ( temp_city.city_weather.contains("Clear")){
                similarity++;
                
                }
               
        } else if (criteria.contains("Clouds")) {
            
                if ( temp_city.city_weather.contains("Clouds")){
                similarity++;
                
                }
               
           
        }else if(criteria.contains("Snow")){
             
                if ( temp_city.city_weather.contains("Snow")){
                similarity++;
                
                }
            
        }                          
               
        //MUSEUM
       if(criteria.contains("Archaeology museum") ){
            try{
                if ( temp_city.city_museum.contains("archaeology museum")){
                similarity++;
                
                }
            }catch(NullPointerException e){
                System.out.print("Could not find all the given criteria in :" +temp_city.city_name);            }    
        } else if (criteria.contains("Art museum")) {
            try {
                if ( temp_city.city_museum.contains("art museum")){
                similarity++;
                
                }
            }catch(NullPointerException e){
                System.out.print("Could not find all the given criteria in :" +temp_city.city_name);            }    
           
        }else if(criteria.contains("Military and war museum")){
            try{  
                if ( temp_city.city_museum.contains("military and war museum")){
                similarity++;
                
                }
            }catch(NullPointerException e){
                System.out.print("Could not find all the given criteria in :" +temp_city.city_name);            }    
        }  
       
       //CAFERESTAURANTBAR
       if(criteria.contains("cafe") ){
            try{
                if ( temp_city.city_CafeRestaurantBar.contains("cafe")){
                similarity++;
                
                }
            }catch(NullPointerException e){
                System.out.print("Could not find all the given criteria in :" +temp_city.city_name);            }    
        } else if (criteria.contains("restaurant")) {
            try{
                if ( temp_city.city_CafeRestaurantBar.contains("restaurant")){
                similarity++;
                
                }
            }catch(NullPointerException e){
                System.out.print("Could not find all the given criteria in :" +temp_city.city_name);            }    
           
        }else if(criteria.contains("bar")){
            try{  
                if ( temp_city.city_CafeRestaurantBar.contains("bar")){
                similarity++;
                
                }
            }catch(NullPointerException e){
                System.out.print("Could not find all the given criteria in :" +temp_city.city_name);            }    
        }  
        
       //LandScape
        if(criteria.contains("Valley") ){
            try{
                if ( temp_city.city_landscape.contains("valley")){
                similarity++;
                
                }
            }catch(NullPointerException e){
                System.out.print("Could not find all the given criteria in :" +temp_city.city_name);            }
        } else if (criteria.contains("Mount")) {
            try{
                if ( temp_city.city_landscape.contains("Mount")){
                similarity++;
                
                }
            }catch(NullPointerException e){
                System.out.print("Could not find all the given criteria in :" +temp_city.city_name);
            }
        }else if(criteria.contains("Desert")){
            try  {
                if ( temp_city.city_landscape.contains("desert")){
                    similarity++;                
                }
            }catch(NullPointerException e){
                System.out.print("Could not find all the given criteria in :" +temp_city.city_name);            }
        } else if (criteria.contains("Forest")) {
            try{
                if ( temp_city.city_landscape.contains("forest")){
                similarity++;
                
                }
            }catch(NullPointerException e){
                System.out.print("Could not find all the given criteria in :" +temp_city.city_name);            }    
           
        }else if(criteria.contains("Glacier")){
              
            try {
                if ( temp_city.city_landscape.contains("glacier")){
                similarity++;
                
                }
            }catch(NullPointerException e){
                System.out.print("Could not find all the given criteria in :" +temp_city.city_name);            }    
        }  
       
        sum_similarity = similarity / (criteria.size());
        return sum_similarity;              
     
    }

        public String CompareCities(ArrayList<City> cities,ArrayList<String> criteria){
        double similarity,user_max_similarity=0;                      
        String tmp_city = null;
        
        for(int i=0;i < cities.size();i++){            
            similarity=Similarity(cities.get(i),criteria);
            if(user_max_similarity <= similarity){
                user_max_similarity =  similarity;
                tmp_city =  cities.get(i).city_name;
                
            }            
        }
        
        return  tmp_city;
        
    }
    
   public void CompareCities(Boolean weather){
       if(weather){
           System.out.printf("City contains rain and therefore is excluded from picking.\n");
       }else{             
           System.out.printf("The city has been added succesully to the list!\n");           
       }                      
    }    
    
    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getMuseum() {
        return museum;
    }

    public void setMuseum(String museum) {
        this.museum = museum;
    }

    public  String getCafeRestaurantBar() {
        return CafeRestaurantBar;
    }

    public void setCafeRestaurantBar(String CafeRestaurantBar) {
        this.CafeRestaurantBar = CafeRestaurantBar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getCurrent_lan() {
        return current_lan;
    }

    public void setCurrent_lan(double current_lan) {
        this.current_lan = current_lan;
    }

    public double getCurrent_lon() {
        return current_lon;
    }

    public void setCurrent_lon(double current_lon) {
        this.current_lon = current_lon;
    }
        
    public static int getNTravellers() {
        return Ntravellers;
    }

    public static void setNTravellers(int Ntravellers) {
        Traveller.Ntravellers = Ntravellers;
    }
    
    public String getLandscape() {
        return landscape;
    }

    public void setLandscape(String landscape) {
        this.landscape = landscape;
    }
    /*public String getCity() {
        return cities;
    }

    public void setCity(String cities) {
        this.cities = cities;
    }*/
    public String getTransportation() {
        return transportation;
    }

    public void setTransportation(String transportation) {
        this.transportation = transportation;
    }

    private void printf(String city_contains_rain_and_therefore_is_exclu) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
