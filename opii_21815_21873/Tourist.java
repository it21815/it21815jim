/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opii_21815_21873;

import java.util.ArrayList;

public class Tourist extends Traveller {    

    public Tourist(String name, int age, String transportation, double current_lan, double current_lon, String weather, String museum, String CafeRestaurantBar, String landscape, String cities) {
        super(name, age, transportation, current_lan, current_lon, weather, museum, CafeRestaurantBar, landscape,cities);
    }
    
    /*@Override
    public void CompareCities(Boolean weather){
       if(weather){             
             System.out.printf("The city has been added succesully to the list!\n");
       }else{
             System.out.printf("City contains rain and therefore is excluded from picking.\n");           
       }                      
    }
    
    
    @Override
     public String CompareCities(ArrayList<City> cities,ArrayList<String> criteria){
        double user_max_similarity=0;
        
        System.out.printf("utfrxezyezr");
        String tmp_city = null;
        
        for(int i=0;i<=cities.size();i++){
                    System.out.printf("utfrxezyezr");

            if(user_max_similarity <= Similarity(cities.get(i),criteria)){
                user_max_similarity =  Similarity( cities.get(i),criteria);                
                tmp_city =  cities.get(i).city_name;                   
            }            
        }
        return  tmp_city;
        
    }*/
    /*H Similarity του Tourist υπολογίζεται με βάση το πλήθος των κοινών όρων επί την
συχνότητα εμφάνισης κάθε όρου στο αντικείμενο city.*/
    @Override
    public double Similarity(City temp_city,ArrayList<String> criteria){
        double similarity = 1;
        double sum_similarity = 0;
        int word,i;
        int count=0; 
        
       //Transport      
        if(criteria.contains("Metro") ){
            if ( temp_city.city_transportation.contains("Metro")){
                word =temp_city.city_transportation.indexOf("Metro");                
                for(i = 0; i < temp_city.city_transportation.length(); i++){
                    count++;
                    temp_city.city_transportation=temp_city.city_transportation.substring(word + 1);
                    word = temp_city.city_transportation.indexOf("Metro");
                }
                similarity = (similarity + (count/i));
            }
        } else if (criteria.contains("Bus")) {
            if ( temp_city.city_transportation.contains("Bus")){
                word =temp_city.city_transportation.indexOf("Bus");                
                for(i = 0; i < temp_city.city_transportation.length(); i++){
                    count++;
                    temp_city.city_transportation=temp_city.city_transportation.substring(word + 1);
                    word = temp_city.city_transportation.indexOf("Bus");
                }
                similarity = (similarity + (count/i));
            }
        }else if(criteria.contains("Airport")){
              
            if ( temp_city.city_transportation.contains("Airport")){
                word =temp_city.city_transportation.indexOf("Airport");                
                for(i = 0; i < temp_city.city_transportation.length(); i++){
                    count++;
                    temp_city.city_transportation=temp_city.city_transportation.substring(word + 1);
                    word = temp_city.city_transportation.indexOf("Airport");
                }
                similarity = (similarity + (count/i));
            }
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
            if ( temp_city.city_museum.contains("Archaeology museum")){
                word =temp_city.city_museum.indexOf("Archaeology museum");                
                for(i = 0; i < temp_city.city_museum.length(); i++){
                    count++;
                    temp_city.city_museum=temp_city.city_museum.substring(word + 1);
                    word = temp_city.city_museum.indexOf("Archaeology museum");
                }
               similarity = (similarity + (count/i));
            }
        } else if (criteria.contains("Art museum")) {
            if ( temp_city.city_museum.contains("Art museum")){
                word =temp_city.city_museum.indexOf("Art museum");                
                for(i = 0; i < temp_city.city_museum.length(); i++){
                    count++;
                    temp_city.city_museum=temp_city.city_museum.substring(word + 1);
                    word = temp_city.city_museum.indexOf("Art museum");
                }
                similarity = (similarity + (count/i));
            }
           
        }else if(criteria.contains("Military and war museum")){              
            if ( temp_city.city_museum.contains("Military and war museum")){
                word =temp_city.city_museum.indexOf("Military and war museum");                
                for(i = 0; i < temp_city.city_museum.length(); i++){
                    count++;
                    temp_city.city_museum=temp_city.city_museum.substring(word + 1);
                    word = temp_city.city_museum.indexOf("Military and war museum");
                }
                similarity = (similarity + (count/i));
            }
        }  
       
       //CAFERESTAURANTBAR
       if(criteria.contains("cafe") ){
            if ( temp_city.city_CafeRestaurantBar.contains("cafe")){
                word =temp_city.city_CafeRestaurantBar.indexOf("cafe");                
                for(i = 0; i < temp_city.city_CafeRestaurantBar.length(); i++){
                    count++;
                    temp_city.city_CafeRestaurantBar=temp_city.city_CafeRestaurantBar.substring(word + 1);
                    word = temp_city.city_CafeRestaurantBar.indexOf("cafe");
                }
                similarity = (similarity + (count/i));
            }
        } else if (criteria.contains("restaurant")) {
            if ( temp_city.city_CafeRestaurantBar.contains("restaurant")){
                word =temp_city.city_CafeRestaurantBar.indexOf("restaurant");                
                for(i = 0; i < temp_city.city_CafeRestaurantBar.length(); i++){
                    count++;
                    temp_city.city_CafeRestaurantBar=temp_city.city_CafeRestaurantBar.substring(word + 1);
                    word = temp_city.city_CafeRestaurantBar.indexOf("restaurant");
                }
                similarity = (similarity + (count/i));
            }
           
        }else if(criteria.contains("bar")){             
            if ( temp_city.city_CafeRestaurantBar.contains("bar")){
                word =temp_city.city_CafeRestaurantBar.indexOf("bar");                
                for(i = 0; i < temp_city.city_CafeRestaurantBar.length(); i++){
                    count++;
                    temp_city.city_CafeRestaurantBar=temp_city.city_CafeRestaurantBar.substring(word + 1);
                    word = temp_city.city_CafeRestaurantBar.indexOf("bar");
                }
                similarity = (similarity + (count/i));
            }           
        }  
        
       //LandScape
        if(criteria.contains("Valley") ){
            if ( temp_city.city_landscape.contains("Valley")){
                word =temp_city.city_landscape.indexOf("Valley");                
                for(i = 0; i < temp_city.city_landscape.length(); i++){
                    count++;
                    temp_city.city_landscape=temp_city.city_landscape.substring(word + 1);
                    word = temp_city.city_landscape.indexOf("Valley");
                }
                similarity = (similarity + (count/i));
            }
        } else if (criteria.contains("Mount")) {
          if ( temp_city.city_landscape.contains("Mount")){
                word =temp_city.city_landscape.indexOf("Mount");                
                for(i = 0; i < temp_city.city_landscape.length(); i++){
                    count++;
                    temp_city.city_landscape=temp_city.city_landscape.substring(word + 1);
                    word = temp_city.city_landscape.indexOf("Mount");
                }
                similarity = (similarity + (count/i));
            }
        }else if(criteria.contains("Desert")){
              
          if ( temp_city.city_landscape.contains("Desert")){
                word =temp_city.city_landscape.indexOf("Desert");                
                for(i = 0; i < temp_city.city_landscape.length(); i++){
                    count++;
                    temp_city.city_landscape=temp_city.city_landscape.substring(word + 1);
                    word = temp_city.city_landscape.indexOf("Desert");
                }
                similarity = (similarity + (count/i));
          }else{
               System.out.print("THE CITY DOES NOT HAVE DESERT");
          }
        } else if (criteria.contains("Forest")) {
            if ( temp_city.city_landscape.contains("Forest")){
                word =temp_city.city_landscape.indexOf("Forest");                
                for(i = 0; i < temp_city.city_landscape.length(); i++){
                    count++;
                    temp_city.city_landscape=temp_city.city_landscape.substring(word + 1);
                    word = temp_city.city_landscape.indexOf("Forest");
                }
                similarity = (similarity + (count/i));
            }
           
        }else if(criteria.contains("Glacier")){
              
          if ( temp_city.city_landscape.contains("Glacier")){
                word =temp_city.city_landscape.indexOf("Glacier");                
                for(i = 0; i < temp_city.city_landscape.length(); i++){
                    count++;
                    temp_city.city_landscape=temp_city.city_landscape.substring(word + 1);
                    word = temp_city.city_landscape.indexOf("Glacier");
                }
                similarity = (similarity + (count/i));
            }
           
        }  
        sum_similarity = similarity / (criteria.size());
        System.out.println("Similarity for Tourist:"+sum_similarity+"\n");        
        return sum_similarity; 
             
                
    }
}
