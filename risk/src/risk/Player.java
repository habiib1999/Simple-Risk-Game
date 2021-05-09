/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package risk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author ABD-ELRAHMAN
 */
public class Player {
     private boolean blue;
     private boolean red;
     private Strategy strategy;
     private List<Territory> territories = new ArrayList<Territory>();;
     private int armies;

    public Player(boolean blue, boolean red) {
        this.blue = blue;
        this.red = red;
        this.armies = armies;
    }



    public void setBlue(boolean blue) {
        this.blue = blue;
    }

    public void setRed(boolean red) {
        this.red = red;
    }

    public void setStrategy(Strategy strategy) {
        /// SET THE RIGHT STRATEGy
        this.strategy = strategy;
    }

    public boolean isBlue() {
        return blue;
    }

    public boolean isRed() {
        return red;
    }

    public List<Territory> getTerritories() {
        return territories;
    }

    public int getArmies() {
        return armies;
    }
    
    public int territoriesSize(){
        return territories.size();
    }
    public Strategy getStrategy() {
        return strategy;
    }
     
    void addTerritories(Territory territory){
        territories.add(territory);
    } 
    void removeTerritories(Territory get) {
        territories.remove(get);
    }
    void createPlayer() {
        
    }

    public void setArmies(int armies) {
        this.armies = armies;
    }
    
    public void divideInitialArmies(){
     /*  int tempNum = this.armies;
    Random rand = new Random();
       for(Territory territory1 : territories) {
            territory1.setArmies(rand.nextInt(tempNum));
            System.out.println(tempNum);
            tempNum = tempNum - territory1.getArmies();
        }*/
        //territories.get(0).increamentArmies(armies);
        Random rand = new Random();
        int divided = armies/territories.size();
        int dividedMod = armies % territories.size();
        for(Territory territory1 : territories) {
            territory1.setArmies(divided*rand.nextInt(3) +1);
        }
        /*for(int i=0; i<dividedMod ; i++){
            territories.get(i).increamentArmies(1);
        }*/
        territories.get(0).increamentArmies(dividedMod); // assign rest of armies to a single planet to work as a start point for each player
    }

    void showShips(String color) { //SHOW SHIPS ON SCREEN     
        for(Territory territory1 : territories) {
            String imgURL =  "/assets2/"+color+ "ship" + territory1.getArmies() +".png";
            territory1.getShipImageView().setImage(new Image(getClass().getResource(imgURL).toString()));
        }
        
    }
    
    public void attack(Territory myPlanet,Territory planetToBeAttacked, int amount , HashMap<String, ImageView> mapStringShip){
        int num = myPlanet.getArmies() - amount;
        //System.out.println(num);
        System.out.println(myPlanet.getName()+" will attack "+planetToBeAttacked.getName());
        myPlanet.increamentArmies(-amount);
        if(this.blue){
            mapStringShip.get(myPlanet.getName()).setImage(new Image(getClass().getResource("/assets2/blueship"+ num +".png").toString()));
            mapStringShip.get(planetToBeAttacked.getName()).setImage(new Image(getClass().getResource("/assets2/blueship"+ amount +".png").toString()));
        }
        else{
            mapStringShip.get(myPlanet.getName()).setImage(new Image(getClass().getResource("/assets2/redship"+ num +".png").toString()));
            mapStringShip.get(planetToBeAttacked.getName()).setImage(new Image(getClass().getResource("/assets2/redship"+ amount +".png").toString()));
        }
        planetToBeAttacked.setArmies(amount);
        this.territories.add(planetToBeAttacked);
    }
    public void setBonus(Territory bonusTerritory , HashMap<String, ImageView> mapStringShip){
        int bonus , total=0;
        bonus = calculateBonus();
        for(Territory territory1 : territories) { 
            if(territory1 == bonusTerritory){
                total = territory1.getArmies()+bonus;
                territory1.increamentArmies(bonus);
            }
        }
        if(this.blue){
            mapStringShip.get(bonusTerritory.getName()).setImage(new Image(getClass().getResource("/assets2/blueship"+ total +".png").toString()));
        }
        else{
            mapStringShip.get(bonusTerritory.getName()).setImage(new Image(getClass().getResource("/assets2/redship"+ total +".png").toString()));
        }
    }
    public void placeArmies(){
        
    }
    private int calculateBonus(){
        int bonus=0;
        bonus = territories.size()/3;
        if(bonus < 3)
            return 3;
        else
            return bonus;
    }


    
}
