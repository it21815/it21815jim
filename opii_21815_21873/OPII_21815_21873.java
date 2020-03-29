/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opii_21815_21873;

import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;


public class OPII_21815_21873 {
    
    public static void main(String[] args) throws IOException {
       
        Traveller t1 = new Traveller(null,0,null,0,0,null,null,null,null,null);
        City city1 = new City(null,null,null,null,null,0.0,0.0,null);                                                
        
        System.out.println("1. Traveller\n2. Business\n3. Tourist\n4. Free Ticket");
        System.out.println("Please pick a number");
           
        Scanner input = new Scanner(System.in);        
              
        ArrayList<String> uname = new ArrayList<String>();
        ArrayList<Integer> uage = new ArrayList<Integer>();               
                
        ArrayList<String> cityname = new ArrayList<String>();
        ArrayList<String> countrycode = new ArrayList<String>();
        
        ArrayList<Integer> ucriteria = new ArrayList<Integer>();
        ArrayList<String> criteria = new ArrayList<String>();                
        ArrayList<City> cities = new ArrayList<City>();
        ArrayList<City> cities_excluded = new ArrayList<City>();
        
        String city=null;
        int age;
        int citynum = 0;
        int acity=0;
        char c;
        
        
        
        int type;
        type = input.nextInt();             
        switch (type) {   
            case 1:    
                System.out.println("Traveller");
                int i=0;
                String name;
                do {
                    System.out.println("What is your name?");
                    Scanner scanner = new Scanner(System.in);
                    name = input.next();
                    if (!name.matches("[a-zA-Z_]+")) {
                        System.out.println("Invalid name, please enter a correct one.");
                    }else {
                        i++;
                    }
                    t1.name = name;
                }while (i==0);
                uname.add(name);
                
                               
                do {
                    System.out.println("What is your age?");
                    age =input.nextInt();
                    if (age<=0 || age>100) {
                        System.out.println("This is not an acceptable age, please give a correct one");
                    }              
                    t1.age = age;
                }while (age<=0 || age>100);
                uage.add(age);
                
                
                
                do {
                                 
                    System.out.println("Please enter a city you would like to visit following by the countrys 2 letter country code in the following format: athens, gr.");        
                                         
                    city = input.next();
                    if(city.indexOf(',')==-1){
                        System.out.print("the format is City,AB(country code)\n");
                        break;
                    
                    }
                    String[] cityList = city.split(",");
                    
                    cityname.add(cityList [0]);
                    try{
                        countrycode.add(cityList [1]);
                        System.out.print("You have entered the country code corrrectly\n");

                    }catch(NullPointerException e){
                        System.out.println("Exception caught in Catch block"); 
                    
                    }
                    
                   //////////////////////////////////////////
                    city1.ExtractData(cityname.get(citynum),countrycode.get(citynum));                    
                   

                    if(city1.city_weather.equals("Rain")){
                            t1.CompareCities(Boolean.TRUE);
                            cities_excluded.add(city1);
                            cities_excluded.add(new City(city1.city_name,city1.city_transportation,city1.city_museum,city1.city_CafeRestaurantBar,city1.city_weather,city1.city_lat,city1.city_lon,city1.city_landscape));                    
                            citynum++; 
                    }else{
                        t1.CompareCities(Boolean.FALSE);        
                        cities.add( new City(city1.city_name,city1.city_transportation,city1.city_museum,city1.city_CafeRestaurantBar,city1.city_weather,city1.city_lat,city1.city_lon,city1.city_landscape));                    
                        citynum++;  
                    }                    
                    
                    System.out.println("Press 1 to enter another city or 2 to continue.");            
                    acity=0;
                    acity = input.nextInt();
                    if (citynum < 2 ) {                
                        System.out.println("Please enter at least two cities.");
                        acity = 1;
                    }
                            
                } while(acity == 1);                                
                                              
                int critnum;
                int c1num;                                
                
                System.out.println("These are the available criteria:\n1. Transportation\n2. Weather\n3. Museum\n4. CafeRestaurantBar\n5. Landscape");
                System.out.println("Pick a number according to the criteria you would like to be used");
                int acrit;
                do {
                    
                    critnum = input.nextInt();
                    switch( critnum ) {
                        case 1:
                            
                            if(ucriteria.contains(1)) {
                                System.out.println("You can not choose the same criteria twice.");
                            } else {
                                ucriteria.add(1);
                                System.out.println("Transportation:\n1. Metro\n2. Bus\n3. Airport");
                                System.out.println("Pick a number to choose");
                                
                                c1num = input.nextInt();
                                switch (c1num) {
                                    case 1:
                                        //t1.transportation = "Metro";
                                        criteria.add("Metro");
                                        break;
                                    case 2:
                                        //t1.transportation = "Bus";
                                        criteria.add("Bus");
                                        break;
                                    case 3:         
                                        //t1.transportation = "Metro";
                                        criteria.add("Airport");
                                        break;
                                    default:
                                        System.out.println("PLease pick a number between 1-3!");
                                        break;
                                }
                            }
                                                       
                            break;
                        case 2:
                                                        
                            if(ucriteria.contains(2)) {
                                System.out.println("You can not choose the same criteria twice.");
                            } else {
                                ucriteria.add(2);
                                System.out.println("Weather:\n1. Clouds\n2. Clear\n3. Rain\n4. Snow");
                                System.out.println("Pick a number to choose");
                                c1num = 0;
                                c1num = input.nextInt();                                
                                switch (c1num) {
                                    case 1:
                                        //t1.weather = "Clouds";
                                        criteria.add("Clouds");
                                        break;
                                    case 2:
                                        //t1.weather = "Clear";
                                        criteria.add("Clear");
                                        break;
                                    case 3:
                                        //t1.weather = "Rain";
                                        criteria.add("Rain");
                                        break;
                                    case 4:
                                        //t1.weather = "Snow";
                                        criteria.add("Snow");
                                    default:
                                        System.out.println("PLease pick a number between 1-4!");
                                        break;
                                }
                                
                            }
                            
                            break;
                        case 3:
                            
                            if(ucriteria.contains(3)) {
                                System.out.println("You can not choose the same criteria twice.");
                            } else {
                                ucriteria.add(3);
                                System.out.println("Museum:\n1. Archaeology museum\n2. Art museum\n3. Military and war museum");
                                System.out.println("Pick a number to choose");
                                
                                c1num = input.nextInt();
                                switch (c1num) {
                                    case 1:
                                        //t1.museum = "Archaeology museum";
                                        criteria.add("Archaeology museum");
                                        break;
                                    case 2:
                                         //t1.museum = "Art museum";
                                        criteria.add("Art museum");
                                        break;
                                    case 3:
                                        // t1.museum = "Military and war museum";
                                        criteria.add("Military and war museum");
                                        break;
                                    default:
                                        System.out.println("PLease pick a number between 1-3!");
                                        break;
                                }                                                                
                            }
                            
                            break;
                        case 4:
                            
                            if(ucriteria.contains(4)) {
                                System.out.println("You can not choose the same criteria twice.");
                            } else {
                                ucriteria.add(4);
                                System.out.println("CafeRestaurantBar:\n1. cafe\n2. restaurant\n3. bar");
                                System.out.println("Pick a number to choose");
                                
                                c1num = input.nextInt();
                                switch (c1num) {
                                    case 1:
                                       // t1.CafeRestaurantBar = "cafe";
                                        criteria.add("cafe");
                                        break;
                                    case 2:
                                        //t1.CafeRestaurantBar = "restaurant";
                                        criteria.add("restaurant");
                                        break;
                                    case 3:
                                        //t1.CafeRestaurantBar = "bar";
                                        criteria.add("bar");
                                        break;
                                    default:
                                        System.out.println("PLease pick a number between 1-3!");
                                        break;
                                }
                                
                            }
                            
                            break;
                        case 5:
                        
                            if(ucriteria.contains(5)) {
                                System.out.println("You can not choose the same criteria twice.");
                            } else {
                                ucriteria.add(5);
                                System.out.println("Landscapes:\n1. Valley\n2. Mount\n3. Desert\n4. Forest\n5. Glacier");
                                System.out.println("Pick a number to choose");
                                
                                c1num = input.nextInt();
                                switch (c1num) {
                                    case 1:
                                        //t1.landscape = "Valley";
                                        criteria.add("Valley");
                                        break;
                                    case 2:
                                        //t1.landscape = "Mount";
                                        criteria.add("Mount");
                                        break;
                                    case 3:
                                        //t1.landscape = "Desert";
                                        criteria.add("Desert");
                                        break;
                                    case 4:
                                        //t1.landscape = "Forest";
                                        criteria.add("Forest");
                                        break;
                                    case 5:
                                        //t1.landscape = "Glacier";
                                        criteria.add("Glacier");
                                        break;
                                    default:
                                        System.out.println("PLease pick a number between 1-5!");
                                        break;
                                }                                                                
                            }
                            
                            break;                        
                        default: 
                        
                            System.out.println("Please enter a number between 1-5!");
                            break;
                    }
                    
                    do {
                        System.out.println("Press 1 to choose another criteria or press 2 to continue.");
                        acrit =input.nextInt();
                        if (acrit != 1 && acrit != 2) {
                            System.out.println("This is not an acceptable answer, please pick between 1 and 2.");                            
                        }                        
                    }while (acrit != 1 && acrit != 2);
                    
                }while (acrit != 2);
                
                //t1.CompareCities(Boolean.TRUE);                         
                String Answer = t1.CompareCities(cities,criteria); 
                System.out.print("\nThe city that best matches your choice, based on given criteria, is: \n************************\n"+Answer+"\n");
                
                    break;
            case 2:
                System.out.println("Business");                        
                Business businessman = new Business(null,0,null,0.0,0.0,null,null,null,null,null);
                i=0;
                 do {
                    System.out.println("What is your name?");
                    Scanner scanner = new Scanner(System.in);
                    name = input.next();
                    if (!name.matches("[a-zA-Z_]+")) {
                        System.out.println("Invalid name, please enter a correct one.");
                    }else {
                        i++;
                    }
                    
                }while (i==0);
                uname.add(name);
                
                               
                do {
                    System.out.println("What is your age?");
                    age =input.nextInt();
                    if (age<=0 || age>100) {
                        System.out.println("This is not an acceptable age, please give a correct one");
                    }                        
                }while (age<=0 || age>100);
                uage.add(age);
                    System.out.print("Please provide the unit of latitude and longtitude (such as Kilometers and Nautic miles).");
                    Scanner kilo_nautic = new Scanner(System.in);
                    String unit=kilo_nautic.next();
                    criteria.add(unit);
                    System.out.println("Please provide your coordinates:\n"+"First Latitude:");
                    double coords =input.nextDouble();
                    businessman.current_lan = coords;
                    System.out.println("Now provide the Longtitude:");
                    coords = input.nextDouble();
                    businessman.current_lon = coords;                                                              
                                        
                do {
                                 
                    System.out.println("Please enter a city you would like to visit following by the countrys 2 letter country code in the following format: athens, gr.");        
                                         
                    city = input.next();
                    if(city.indexOf(',')==-1){
                        System.out.print("the format is City,AB(country code)\n");
                        break;
                    
                    }
                    String[] cityList = city.split(",");
                    
                    cityname.add(cityList [0]);
                    try{
                        countrycode.add(cityList [1]);
                        System.out.print("You hsve entered the country code corrrectly\n");

                    }catch(NullPointerException e){
                        System.out.println("Exception caught in Catch block"); 
                    
                    }
                    
                   
                    city1.ExtractData(cityname.get(citynum),countrycode.get(citynum));                    
                    

                    if(city1.city_weather.equals("Rain")){
                            businessman.CompareCities(Boolean.TRUE);
                            cities_excluded.add(city1);
                            cities_excluded.add(new City(city1.city_name,city1.city_transportation,city1.city_museum,city1.city_CafeRestaurantBar,city1.city_weather,city1.city_lat,city1.city_lon,city1.city_landscape));                    
                            citynum++; 
                    }else{
                        businessman.CompareCities(Boolean.FALSE);        
                        cities.add( new City(city1.city_name,city1.city_transportation,city1.city_museum,city1.city_CafeRestaurantBar,city1.city_weather,city1.city_lat,city1.city_lon,city1.city_landscape));                    
                        citynum++;  
                    }                    
                    
                    //System.out.println("Weather: "+city1.city_weather+"\nLAN: "+city1.city_lat+"\nLON: "+city1.city_lon+"\nMuseums: "+city1.city_museum+"\nLandScape: "+city1.city_landscape+"\nCAFESRESTAURANTBAR: "+ city1.city_CafeRestaurantBar+"\nTransportation: "+city1.city_transportation);
                    //cities.add(new City(city1.city_name,city1.city_transportation,city1.city_museum,city1.city_CafeRestaurantBar,city1.city_weather,city1.city_lat,city1.city_lon,city1.city_landscape));
                                      
                    //System.out.println("----"+city1.city_name+"----"+city1.city_weather+"----"+city1.city_landscape+"----"+city1.city_CafeRestaurantBar+"----"+city1.city_transportation+"----"+city1.city_museum);
                    System.out.println("Press 1 to enter another city or 2 to continue.");            
                    acity=0;
                    acity = input.nextInt();
                    if (citynum < 2 ) {
                
                        System.out.println("Please enter at least two cities.");
                        acity = 1;
                    }
                
            
                } while(acity == 1);                                                                                                      
                
                //t1.CompareCities(Boolean.TRUE);                         
                String BAnswer = businessman.CompareCities(cities,criteria); 
                System.out.print("The city that best matches your choice, based on given criteria, is: \n************************\n"+BAnswer+"\n");
               
                    break;
                
            case 3:    
                System.out.println("Tourist");
                Tourist tourist = new Tourist(null,0,null,0.0,0.0,null,null,null,null,null);
                
                int j=0;
                
                do {
                    System.out.println("What is your name?");
                    Scanner scanner = new Scanner(System.in);
                    name = input.next();
                    if (!name.matches("[a-zA-Z_]+")) {
                        System.out.println("Invalid name, please enter a correct one.");
                    }else {
                        j++;
                    }
                    
                }while (j==0);
                uname.add(name);
                
                               
                do {
                    System.out.println("What is your age?");
                    age =input.nextInt();
                    if (age<=0 || age>100) {
                        System.out.println("This is not an acceptable age, please give a correct one");
                    }                        
                }while (age<=0 || age>100);
                uage.add(age);                                                                                                   
                
                do {
                                 
                    System.out.println("Please enter a city you would like to visit following by the countrys 2 letter country code in the following format: athens, gr.");        
                                         
                    city = input.next();
                    if(city.indexOf(',')==-1){
                        System.out.print("the format is City,AB(country code)\n");
                        break;
                    
                    }
                    String[] cityList = city.split(",");
                    
                    cityname.add(cityList [0]);
                    try{
                        countrycode.add(cityList [1]);
                        System.out.print("You hsve entered the country code corrrectly\n");

                    }catch(NullPointerException e){
                        System.out.println("Exception caught in Catch block"); 
                    
                    }
                   //////////////////////////////////////////
                    city1.ExtractData(cityname.get(citynum),countrycode.get(citynum));                    

                    if(city1.city_weather.equals("Rain")){
                            tourist.CompareCities(Boolean.TRUE);
                            cities_excluded.add(city1);
                            cities_excluded.add(new City(city1.city_name,city1.city_transportation,city1.city_museum,city1.city_CafeRestaurantBar,city1.city_weather,city1.city_lat,city1.city_lon,city1.city_landscape));                    
                            citynum++; 
                    }else{
                        tourist.CompareCities(Boolean.FALSE);        
                        cities.add( new City(city1.city_name,city1.city_transportation,city1.city_museum,city1.city_CafeRestaurantBar,city1.city_weather,city1.city_lat,city1.city_lon,city1.city_landscape));                    
                        citynum++;  
                    }                    
                    System.out.println("Press 1 to enter another city or 2 to continue.");            
                    acity=0;
                    acity = input.nextInt();
                    if (citynum < 2 ) {
                
                        System.out.println("Please enter at least two cities.");
                        acity = 1;
                    }                            
                } while(acity == 1);                                
                
              System.out.println("These are the available criteria:\n1. Transportation\n2. Weather\n3. Museum\n4. CafeRestaurantBar\n5. Landscape");
                System.out.println("Pick a number according to the criteria you would like to be used");
                acrit=0;
                do {
                    
                    critnum = input.nextInt();
                    switch( critnum ) {
                        case 1:
                            
                            if(ucriteria.contains(1)) {
                                System.out.println("You can not choose the same criteria twice.");
                            } else {
                                ucriteria.add(1);
                                System.out.println("Transportation:\n1. Metro\n2. Bus\n3. Airport");
                                System.out.println("Pick a number to choose");
                                
                                c1num = input.nextInt();
                                switch (c1num) {
                                    case 1:
                                        tourist.transportation = "Metro";
                                        criteria.add("Metro");
                                        break;
                                    case 2:
                                        tourist.transportation = "Bus";
                                        criteria.add("Bus");
                                        break;
                                    case 3:         
                                        tourist.transportation = "Metro";
                                        criteria.add("Airport");
                                        break;
                                    default:
                                        System.out.println("PLease pick a number between 1-3!");
                                        break;
                                }
                            }
                                                       
                            break;
                        case 2:
                                                        
                            if(ucriteria.contains(2)) {
                                System.out.println("You can not choose the same criteria twice.");
                            } else {
                                ucriteria.add(2);
                                System.out.println("Weather:\n1. Clouds\n2. Clear\n3. Rain\n4. Snow");
                                System.out.println("Pick a number to choose");
                                c1num = 0;
                                c1num = input.nextInt();                                
                                switch (c1num) {
                                    case 1:
                                        tourist.weather = "Clouds";
                                        criteria.add("Clouds");
                                        break;
                                    case 2:
                                        tourist.weather = "Clear";
                                        criteria.add("Clear");
                                        break;
                                    case 3:
                                        tourist.weather = "Rain";
                                        criteria.add("Rain");
                                        break;
                                    case 4:
                                        tourist.weather = "Snow";
                                        criteria.add("Snow");
                                    default:
                                        System.out.println("PLease pick a number between 1-4!");
                                        break;
                                }
                                
                            }
                            
                            break;
                        case 3:
                            
                            if(ucriteria.contains(3)) {
                                System.out.println("You can not choose the same criteria twice.");
                            } else {
                                ucriteria.add(3);
                                System.out.println("Museum:\n1. Archaeology museum\n2. Art museum\n3. Military and war museum");
                                System.out.println("Pick a number to choose");
                                
                                c1num = input.nextInt();
                                switch (c1num) {
                                    case 1:
                                        tourist.museum = "Archaeology museum";
                                        criteria.add("Archaeology museum");
                                        break;
                                    case 2:
                                         tourist.museum = "Art museum";
                                        criteria.add("Art museum");
                                        break;
                                    case 3:
                                         tourist.museum = "Military and war museum";
                                        criteria.add("Military and war museum");
                                        break;
                                    default:
                                        System.out.println("PLease pick a number between 1-3!");
                                        break;
                                }
                                
                                
                            }
                            
                            break;
                        case 4:
                            
                            if(ucriteria.contains(4)) {
                                System.out.println("You can not choose the same criteria twice.");
                            } else {
                                ucriteria.add(4);
                                System.out.println("CafeRestaurantBar:\n1. cafe\n2. restaurant\n3. bar");
                                System.out.println("Pick a number to choose");
                                
                                c1num = input.nextInt();
                                switch (c1num) {
                                    case 1:
                                        tourist.CafeRestaurantBar = "cafe";
                                        criteria.add("cafe");
                                        break;
                                    case 2:
                                        tourist.CafeRestaurantBar = "restaurant";
                                        criteria.add("restaurant");
                                        break;
                                    case 3:
                                        tourist.CafeRestaurantBar = "bar";
                                        criteria.add("bar");
                                        break;
                                    default:
                                        System.out.println("PLease pick a number between 1-3!");
                                        break;
                                }
                                
                            }
                            
                            break;
                        case 5:
                        
                            if(ucriteria.contains(5)) {
                                System.out.println("You can not choose the same criteria twice.");
                            } else {
                                ucriteria.add(5);
                                System.out.println("Landscapes:\n1. Valley\n2. Mount\n3. Desert\n4. Forest\n5. Glacier");
                                System.out.println("Pick a number to choose");
                                
                                c1num = input.nextInt();
                                switch (c1num) {
                                    case 1:
                                        tourist.landscape = "Valley";
                                        criteria.add("Valley");
                                        break;
                                    case 2:
                                        tourist.landscape = "Mount";
                                        criteria.add("Mount");
                                        break;
                                    case 3:
                                        tourist.landscape = "Desert";
                                        criteria.add("Desert");
                                        break;
                                    case 4:
                                        tourist.landscape = "Forest";
                                        criteria.add("Forest");
                                        break;
                                    case 5:
                                        tourist.landscape = "Glacier";
                                        criteria.add("Glacier");
                                        break;
                                    default:
                                        System.out.println("PLease pick a number between 1-5!");
                                        break;
                                }
                                
                                
                            }
                            
                            break;                        
                        default: 
                        
                            System.out.println("Please enter a number between 1-5!");
                            break;
                    }
                    
                    
                    do {
                        System.out.println("Press 1 to choose another criteria or press 2 to continue.");
                        acrit =input.nextInt();
                        if (acrit != 1 && acrit != 2) {
                            System.out.println("This is not an acceptable answer, please pick between 1 and 2.");                            
                        }                        
                    }while (acrit != 1 && acrit != 2);
                    
                }while (acrit != 2);                                                       
                String TAnswer = tourist.CompareCities(cities,criteria); 
                System.out.print("The city that best matches your choice, based on given criteria, is: \n************************\n"+TAnswer+"\n");               
                break;
            case 4:
                //Gia to 3
                Traveller[] Ntravellers = new Traveller[5];
                Ntravellers[0]= new Business("Nikos",19,"Metro",37.98,27.92,"Clouds","Archeological museums","cafe","Glacier","London,UK Athens,GR ");
                Ntravellers[1]= new Tourist("Eleni",44,"Bus",37.03,22.11,"Clear","Archeological museums","restaurant","Desert","Cairo,EG Barcelona,ES");
                Ntravellers[2]= new Tourist("Panos",21,"Airport",24.98,23.54,"Clouds","Military and war museums","bar","Mount","Madrid,ES Casablanca,MA");
                Ntravellers[3]= new Traveller("Maria",36,"Airport",40.64,22.94,"Snow","Art museums","cafe","Mount","Berlin,DE Cairo,EG");
                final String free = "Cairo,EG";
                String[] cityList;
                int number=0;
                for(int k=0;k<Ntravellers.length-1;k++){
                    if(!Ntravellers[k].cities.contains(free)){
                        System.out.println("NO MATCH FOR FREE TICKET\n");
                        
                    }else{                                                
                        String[] substring = Ntravellers[k].getCities().split(" ");                                       
                        cityList = substring[0].split(",");                                                  
                        cityname.add(cityList [0]);                   
                        countrycode.add(cityList [1]);
                        criteria.add(Ntravellers[k].getTransportation() + Ntravellers[k].getWeather() + Ntravellers[k].getMuseum()+Ntravellers[k].CafeRestaurantBar+Ntravellers[k].getLandscape());                                    
                        
                        city1.ExtractData(cityname.get(number),countrycode.get(number)); 
                        cities.add( new City(city1.city_name,city1.city_transportation,city1.city_museum,city1.city_CafeRestaurantBar,city1.city_weather,city1.city_lat,city1.city_lon,city1.city_landscape));                                            
                        number++;                    
                    }                    
                }
                
                int position=0;
                double max_traveller =0.0,user;
                
                for(int n=0;n< criteria.size(); n++ ){                                  
                    
                    user=Ntravellers[n].Similarity(cities.get(n), criteria);
                    
                    if(max_traveller <= user){
                        
                        max_traveller = user;
                        position=n;                        
                    }                     
                }               
                System.out.println("The winner is: "+Ntravellers[position].name);
                
                break;
        }                                   
    }                  
}
