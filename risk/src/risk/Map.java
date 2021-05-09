/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package risk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author ABD-ELRAHMAN
 */
public class Map {
    
    private List<Territory> territories;
    private int totalArmies = 40;
    private int initialArmies = 20;
    HashMap<String ,List<String>> mapNeighboursString;
    HashMap<String, ImageView> mapStringImage;
    HashMap<String, ImageView> mapStringShip;

        public boolean randomBoolean(){
        return Math.random() < 0.5;
    }

    public Map(HashMap<String, List<String>> mapNeighboursString, HashMap<String, ImageView> mapStringImage, HashMap<String, ImageView> mapStringShip) {
        this.mapNeighboursString = mapNeighboursString;
        this.mapStringImage = mapStringImage;
        this.mapStringShip = mapStringShip;
    }
     
    public void createMap() {
        territories = new ArrayList<Territory>();
        int i = 1;
        
        for (java.util.Map.Entry<String, List<String>> me : mapNeighboursString.entrySet()) {
            String key = me.getKey();
            String imgURL =  "/assets2/"+ key +".png";
            ImageView imageView = mapStringImage.get(key);
            ImageView shipImageView = mapStringShip.get(key);
            Territory territory = new Territory(randomBoolean(), imgURL, i++ , key, imageView , shipImageView);
            territories.add(territory);
            imageView.setImage(new Image(getClass().getResource(imgURL).toString()));
            
        }  
        assignNeighbours(mapNeighboursString);

}
    
    public void assignNeighbours (HashMap<String ,List<String>> mapNeighboursString){
        // ITERATE ON TERRITORIES TO ASSIGN THEIR NEIGHBOURS
        List<String> tempName = new ArrayList<String>();
        List<Territory> tempTeritorries = new ArrayList<Territory>();
        for (Territory territory : territories)   // LOOP ON TERRITORIES ONE BY ONE TO ASSIGN NEIGHBOURS
        {
            tempName =  mapNeighboursString.get(territory.getName());
            for (String territoryName : tempName){ // STORE NAMES OF THE NEIGBOURS IN A TEMP LIST TO LOOP ON THEM

                for(Territory territory1 : territories) { // GET ACTUAL TERRITOIES WITH THE NAME IN THE TEMP LIST FROM TERRITORIES LIST
                    if(territory1.getName().equals(territoryName)) {
                        //System.out.println(territory.getName() + " : " + territoryName );
                        tempTeritorries.add(territory1);
                    }       
                }

            }

        territory.setNeighbours(tempTeritorries);
        tempTeritorries.clear();       
        
        } 

        
    }

    public void showDetails(String planetName) {
        for(Territory territory1 : territories) { // GET ACTUAL TERRITOIES WITH THE NAME IN THE TEMP LIST FROM TERRITORIES LIST
                    if(territory1.getName().equals(planetName)) {
                        System.out.println("territory color : " + territory1.isBlue() );
                        System.out.println("territory imgURL : " + territory1.getImgUrl() );
                        System.out.println("territory name : " + territory1.getName() );
                        System.out.println("territory neighbours : " );
                        territory1.printNeighbours();
                        System.out.println("territory id : " + territory1.getId() );
                        System.out.println("territory armies : " + territory1.getArmies() );
                    }       
                }
    }

    public List<Territory> getTerritories() {
        return this.territories;
    }

    public HashMap<String, ImageView> getMapStringShip() {
        return mapStringShip;
    }
    

    
}
