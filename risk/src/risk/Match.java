
package risk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.Blend;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.Bloom;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 *
 * @author ABD-ELRAHMAN
 */
// CLASS MATCH CONTROL THE MATCH AND EACH MOVE OF THE PLAYERS
public class Match { 

    private Player bluePlayer; /// Always a human player
    private Player redPlayer; /// an Ai agent player
    private Player currentPlayer = null; // Works as a pointer on current player
    private ImageView flag;
    private boolean currentIsBlue = false; /// check the color of the current player
    private Map matchMap;
    private List<String> clickedPlanets =  new ArrayList<String>(2);
    private List<String> bonusPlanet =  new ArrayList<String>(1);
    private List<String> buttonList =  new ArrayList<String>(1);
    private List<String> turn =  new ArrayList<String>(1);
    //private String buttonCommand;
    private List<Territory> clickedPlanetsTerr =  new ArrayList<Territory>(2); // list of 2 clicked planet to proccess on 
    private List<Territory> bonusPlanetsTerr =  new ArrayList<Territory>(1); // list of 2 clicked planet to proccess on 
    private int totalArmies = 40;
    private int initialArmies = 20;
    private int initialArmiesBlue = 25;
    //private HashMap<String, ImageView> buttonMap = new HashMap<String, ImageView>();
    private Label inputLabel;
    private TextField inputTextField;
    private final ImageView attackButton;
    private final ImageView chooseButton;
    private int bonus = 0;
    private boolean placeBonus = true;
    Blend blend = new Blend();
    //private final ImageView yesButton;
    //private final ImageView noButton;
    //private final ImageView chooseButton;


    Match(Map matchMap, Player bluePlayer, Player redPlayer , ImageView flag 
            , ImageView attacButton, ImageView chooseButton , Label inputLabel , TextField inputTextField) {
        this.matchMap = matchMap;
        this.bluePlayer = bluePlayer;
        this.redPlayer = redPlayer;
        this.flag = flag;
        this.attackButton = attacButton;
        this.chooseButton = chooseButton;
        this.inputLabel = inputLabel;
        this.inputTextField = inputTextField;
        
    }
    


    public void startMatch(){
        divideTerritories();
        divideArmies();
        controlTurn();
    }
    
    public void divideArmies(){
       bluePlayer.setArmies(initialArmiesBlue);
       redPlayer.setArmies(initialArmies);
       bluePlayer.divideInitialArmies();
       redPlayer.divideInitialArmies();
       bluePlayer.showShips("blue");
       redPlayer.showShips("red");

    }
    public void divideTerritories(){
        
        List<Territory> territories = new ArrayList<Territory>();
        territories = matchMap.getTerritories();
                for(Territory territory1 : territories) { // GET ACTUAL TERRITOIES WITH THE NAME IN THE TEMP LIST FROM TERRITORIES LIST
                    if(territory1.isBlue() == true) {
                           bluePlayer.addTerritories(territory1);
                    }
                    else{
                            redPlayer.addTerritories(territory1);
                    }
                }
        
    }

    private void controlTurn() {

        List<Player> players = new ArrayList<Player>();
        players.add(bluePlayer);
        players.add(redPlayer);
        setCurrentPlayer(); /// Set current player initially to blue


    /// Game LOOP
    Thread t = new Thread(new Runnable(){
        public final CountDownLatch latch = new CountDownLatch(1);
        public void run() { 

       do  {
            showFlag();
            moveNext(); /// DO SOMETHING IF 2 PLANETS ARE CLICKED
            takeCommand(); /// DO SOMETHING WHEN THE USER CLICK THE BUTTON
            //latch.await();
            try {
                Thread.sleep(16);
            }
            catch(Exception e) {
                System.out.println("something wrong while running");
            }
        } while (currentPlayer.territoriesSize() != 18 );
       
    }

    });
    t.start();
        
    }
    
    private void showFlag() {
         String imgURL;
         if(currentPlayer.isBlue() == true)
             imgURL =  "/assets2/blueflag.png";
         else
             imgURL =  "/assets2/redflag.png";
         flag.setImage(new Image(getClass().getResource(imgURL).toString()));
   }

    public void setBluePlayer(Player bluePlayer) {
        this.bluePlayer = bluePlayer;
    }

     public void setRedPlayer(Player redPlayer) {
        this.redPlayer = redPlayer;
    }
    private void setCurrentPlayer() {
         if(currentIsBlue == false){
             currentPlayer = bluePlayer;
             currentIsBlue = true;
         }
         else{
             currentPlayer = redPlayer;
             currentIsBlue = false;
         }
         showFlag();
    }


    public void addToClickedPlanetsList(String planetName){
        if(placeBonus == false ){
            if( checkAttack(planetName) ){
               clickedPlanets.add(planetName);
               System.out.println("True Check for attack");
            }
            for (String country : clickedPlanets) {
                System.out.println("in array of strings : "+country); 
            }
        }
    }
    
    public void addToButtonList(String actionName ){
        System.out.println("risk.Match.addToButtonList()");
        buttonList.add(actionName);
    }
    void addToBonusPlanetsList(String planetName) {
        if(placeBonus == true ){
            if( checkBonus(planetName)){
               bonusPlanet.add(planetName);
               System.out.println("True Check for bonus");
            }
               System.out.println("in array of bonus : "+ bonusPlanet.get(0));
        }
    }
    
    
    void showSelected(Territory selectTerritory , boolean flag){
        if(flag){ /// Show selected
            blend.setMode(BlendMode.COLOR_BURN);
            selectTerritory.getImageView().setEffect(blend);
        }
        else{
            selectTerritory.getImageView().setEffect(null);
        }

    }

    private boolean checkBonus(String planetName) {
        boolean flag = false;
        for(Territory territory1 : currentPlayer.getTerritories()) { 
              if(territory1.getName().equals(planetName)){
                  flag = true;
                  bonusPlanetsTerr.add(territory1);
                  showSelected(territory1, true);
                  break;
              }
         }
         return flag;
     }
    public boolean checkAttack(String planetName) {
        boolean flag = false;
        Territory tempTerritory = null;
        
        /// FIRST PLANET
        if(clickedPlanets.isEmpty()){
        /// 1. check if the planet is the same color as the current player color
        for(Territory territory1 : currentPlayer.getTerritories()) { 
              if(territory1.getName().equals(planetName)){
                  //flag = true;
                  tempTerritory = territory1;
                  flag = true;
                  clickedPlanetsTerr.add(territory1);
                  showSelected(tempTerritory , true);
                  System.out.println("----1 after empty-----"+clickedPlanetsTerr.get(0).getName());
                  //System.out.println("---------"+clickedPlanetsTerr.get(1).getName());
                  break;
              }
         }
        if(flag){
        //2. Check the armies number to be more than 1
        if(tempTerritory.getArmies() <= 1 )
            flag =  false;
        }
        
        
        if(flag)
            tempTerritory.getImageView().setImage(new Image(getClass().getResource("/assets2/"+ planetName +"glow.png").toString()));
        
        
        }
        
        /// SECOND PLANET
        else{
            if(clickedPlanetsTerr.get(0).getName() == planetName){ /// select and disselect
                showSelected(clickedPlanetsTerr.get(0), false);
                clickedPlanetsTerr.clear();
                clickedPlanets.clear();
                return false;
            }
            
            setCurrentPlayer();
            /// 1.check if the color of the second planet is different from the first pik
            for(Territory territory1 : currentPlayer.getTerritories()) { 
              if(territory1.getName().equals(planetName)){
                  tempTerritory = territory1;
                  flag = true;     
                  clickedPlanetsTerr.add(tempTerritory);
                  showSelected(tempTerritory, true);
                  System.out.println("----1 in territory array-----"+clickedPlanetsTerr.get(0).getName());
                  System.out.println("-----2 in territory array----"+clickedPlanetsTerr.get(1).getName());
                  break;
              }
         }
         
            
         if(flag){
            /// 2.check if num of armies of first pik is greater than the second pik
          if(tempTerritory.getArmies() >= clickedPlanetsTerr.get(0).getArmies()-1)
              flag =  false;
          
          /// 2.check if iam a neighbour to the first pik
          if(!tempTerritory.isANeighbour(clickedPlanetsTerr.get(0).getName()))
              flag = false;
              
            
         }
         setCurrentPlayer();
        }
        
        return flag;
    }

    public void moveNext(){
        //////// EL LE3B HENA
        if(clickedPlanets.size() == 2){
            System.out.println("YOU ARE A LEGEND for Attack");
            //inputLabel.setText("Enter the number of armies to attack");
            attackButton.setVisible(true);
            clickedPlanets.clear();
        }
        if(!bonusPlanet.isEmpty()){
            System.out.println("YOU ARE A LEGEND for Bonus");
            chooseButton.setVisible(true);
            bonusPlanet.clear();
        }
    }
    
    
    private void takeCommand() {
        if(!buttonList.isEmpty()){
            /// ATTACK
            if(buttonList.get(0) == "attack" && inputTextField.getText() != null ){
                int amount;  
                //inputTextField.setDisable(false);
                  amount = Integer.parseInt(inputTextField.getText());
                  System.out.println("current planet attack with num of : " + amount);
                  setCurrentPlayer();
                  currentPlayer.removeTerritories(clickedPlanetsTerr.get(1));
                  setCurrentPlayer();
                  currentPlayer.attack(clickedPlanetsTerr.get(0),clickedPlanetsTerr.get(1),amount,matchMap.getMapStringShip());
                  showSelected(clickedPlanetsTerr.get(0), false);
                  showSelected(clickedPlanetsTerr.get(1), false);
                  clickedPlanetsTerr.clear();
                  printPlayerTerritories();
                  System.out.println("I SHOULD SWITCH");
                  placeBonus = true;
                  attackButton.setVisible(false);
                  setCurrentPlayer();
                  printPlayerTerritories();
                  
            }
            if(buttonList.get(0) == "choose"){
                currentPlayer.setBonus(bonusPlanetsTerr.get(0) ,matchMap.getMapStringShip());
                showSelected(bonusPlanetsTerr.get(0), false);
                bonusPlanetsTerr.clear();
                chooseButton.setVisible(false);
                placeBonus = false;
            }
            if(buttonList.get(0) == "yes"){
               // currentPlayer.attack(clickedPlanetsTerr.get(1));
            }
            if(buttonList.get(0) == "no"){
                //currentPlayer.attack(clickedPlanetsTerr.get(1));
            }
            if(buttonList.get(0) == "exit"){
                Platform.exit();
                System.exit(0);
            }
            buttonList.clear();    
        }
    }
    public static boolean isNumeric(String str) { // check if number of armies in text field in a numeric value (not used yet)
        try {  
        Double.parseDouble(str);  
        return true;
        }  catch(NumberFormatException e){  
            return false;  
        }  
    }
    
    private void printPlayerTerritories() { /// print player terr to be easy to debug errors :)
               for(Territory territory1 : currentPlayer.getTerritories()) { // GET ACTUAL TERRITOIES WITH THE NAME IN THE TEMP LIST FROM TERRITORIES LIST
                    if(currentIsBlue) {
                        System.out.println("territory BLUE : ");
                        System.out.println("territory name : " + territory1.getName() );
                        System.out.println("territory armies : " + territory1.getArmies() );
                    }
                    else{
                        System.out.println("territory RED : ");
                        System.out.println("territory name : " + territory1.getName() );
                        System.out.println("territory armies : " + territory1.getArmies() );
                    }
                }
    }


}
