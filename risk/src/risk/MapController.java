
package risk;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;



public class MapController implements Initializable {
    
    /// For ALL
    @FXML
    private ImageView flag_id;
    @FXML
    private ImageView attack_id;
    @FXML
    private ImageView choose_id;
    @FXML 
    private ImageView exit_id;
    @FXML 
    private TextField input_id;
    @FXML 
    private Label inputLabel_id;
    
    /// ATTACK
    @FXML
    private void changeAttackStyle(){
        attack_id.setImage(new Image(getClass().getResource("/assets2/attack2.png").toString()));
        planetTouched("jan");
       
    }
      @FXML
    private void returnAttackStyle(){
        attack_id.setImage(new Image(getClass().getResource("/assets2/attack.png").toString()));

    }
    @FXML
    private void attackClicked(){
        match.addToButtonList("attack");

    }
   /// EXIT
    @FXML
    private void changeExitStyle(){
        exit_id.setImage(new Image(getClass().getResource("/assets2/exit2.png").toString()));
        planetTouched("jan");
       
    }
      @FXML
    private void returnExitkStyle(){
        exit_id.setImage(new Image(getClass().getResource("/assets2/exit.png").toString()));

    }
    @FXML
    private void exitClicked(){
        match.addToButtonList("exit");
     }
    
    /// CHOOSE
    @FXML
    private void changeChooseStyle(){
        choose_id.setImage(new Image(getClass().getResource("/assets2/choose2.png").toString()));
       
    }
      @FXML
    private void returnChooseStyle(){
        choose_id.setImage(new Image(getClass().getResource("/assets2/choose.png").toString()));

    }
        @FXML
    private void chooseClicked(){
        match.addToButtonList("choose");

    }
    
    // GETTING IMAGEVIEWS IDs #49
    @FXML
    private ImageView jan_id;
    @FXML
    private ImageView feb_id;
    @FXML
    private ImageView mars_id;
    @FXML
    private ImageView april_id;
    @FXML
    private ImageView may_id;
    @FXML
    private ImageView june_id;
    @FXML
    private ImageView july_id;
    @FXML
    private ImageView august_id;
    @FXML
    private ImageView sept_id;
    @FXML
    private ImageView oct_id;
    @FXML
    private ImageView nov_id;
    @FXML
    private ImageView dec_id;
    @FXML
    private ImageView sat_id;
    @FXML
    private ImageView sun_id;
    @FXML
    private ImageView mon_id;
    @FXML
    private ImageView tue_id;
    @FXML
    private ImageView wed_id;
    @FXML
    private ImageView fri_id;
    
    // GETTING SHIPS IMAGEVIEW
    @FXML
    private ImageView jan_ship;
    @FXML
    private ImageView feb_ship;
    @FXML
    private ImageView mars_ship;
    @FXML
    private ImageView april_ship;
    @FXML
    private ImageView may_ship;
    @FXML
    private ImageView june_ship;
    @FXML
    private ImageView july_ship;
    @FXML
    private ImageView august_ship;
    @FXML
    private ImageView sept_ship;
    @FXML
    private ImageView oct_ship;
    @FXML
    private ImageView nov_ship;
    @FXML
    private ImageView dec_ship;
    @FXML
    private ImageView sat_ship;
    @FXML
    private ImageView sun_ship;
    @FXML
    private ImageView mon_ship;
    @FXML
    private ImageView tue_ship;
    @FXML
    private ImageView wed_ship;
    @FXML
    private ImageView fri_ship;
    
    /// JAN
    @FXML
    private void changeJanStyle(){
        jan_id.setImage(new Image(getClass().getResource("/assets2/janglow.png").toString()));
        planetTouched("jan");
       
    }
      @FXML
    private void returnJanStyle(){
        jan_id.setImage(new Image(getClass().getResource("/assets2/jan.png").toString()));

    }
    /// FEB
    @FXML
    private void changeFebStyle(){
        feb_id.setImage(new Image(getClass().getResource("/assets2/febglow.png").toString()));
               planetTouched("feb");
    }
      @FXML
    private void returnFebStyle(){
        feb_id.setImage(new Image(getClass().getResource("/assets2/feb.png").toString()));
       
    }
    
    /// MARS
    @FXML
    private void changeMarsStyle(){
        mars_id.setImage(new Image(getClass().getResource("/assets2/marsglow.png").toString()));
               planetTouched("mars");
    }
      @FXML
    private void returnMarsStyle(){
        mars_id.setImage(new Image(getClass().getResource("/assets2/mars.png").toString()));
       
    }
    
    /// APRIL
    @FXML
    private void changeAprilStyle(){
        april_id.setImage(new Image(getClass().getResource("/assets2/aprilglow.png").toString()));
                planetTouched("april");
    }
      @FXML
    private void returnAprilStyle(){
        april_id.setImage(new Image(getClass().getResource("/assets2/april.png").toString()));
       
    }
     /// MAY
    @FXML
    private void changeMayStyle(){
        may_id.setImage(new Image(getClass().getResource("/assets2/mayglow.png").toString()));
               planetTouched("may");
    }
      @FXML
    private void returnMayStyle(){
        may_id.setImage(new Image(getClass().getResource("/assets2/may.png").toString()));
       
    }
    
    /// JUNE
    @FXML
    private void changeJuneStyle(){
        june_id.setImage(new Image(getClass().getResource("/assets2/juneglow.png").toString()));
               planetTouched("june");
    }
      @FXML
    private void returnJuneStyle(){
       june_id.setImage(new Image(getClass().getResource("/assets2/june.png").toString()));
       
    }
    
    /// JULY
    @FXML
    private void changeJulyStyle(){
       july_id.setImage(new Image(getClass().getResource("/assets2/julyglow.png").toString()));
               planetTouched("july");
    }
      @FXML
    private void returnJulyStyle(){
        july_id.setImage(new Image(getClass().getResource("/assets2/july.png").toString()));
       
    }
    
    /// AUGUST
    @FXML
    private void changeAugustStyle(){
        august_id.setImage(new Image(getClass().getResource("/assets2/augustglow.png").toString()));
               planetTouched("august");
    }
      @FXML
    private void returnAugustStyle(){
        august_id.setImage(new Image(getClass().getResource("/assets2/august.png").toString()));
       
    }
    
    /// SEPT
    @FXML
    private void changeSeptStyle(){
        sept_id.setImage(new Image(getClass().getResource("/assets2/septglow.png").toString()));
               planetTouched("sept");
    }
      @FXML
    private void returnSeptStyle(){
        sept_id.setImage(new Image(getClass().getResource("/assets2/sept.png").toString()));
       
    }
    
    /// OCT
    @FXML
    private void changeOctStyle(){
        oct_id.setImage(new Image(getClass().getResource("/assets2/octglow.png").toString()));
               planetTouched("oct");
    }
      @FXML
    private void returnOctStyle(){
        oct_id.setImage(new Image(getClass().getResource("/assets2/oct.png").toString()));
       
    }
    
    /// NOV
    @FXML
    private void changeNovStyle(){
        nov_id.setImage(new Image(getClass().getResource("/assets2/novglow.png").toString()));
               planetTouched("nov");
    }
      @FXML
    private void returnNovStyle(){
        nov_id.setImage(new Image(getClass().getResource("/assets2/nov.png").toString()));
       
    }
    
    /// DEC
    @FXML
    private void changeDecStyle(){
        dec_id.setImage(new Image(getClass().getResource("/assets2/decglow.png").toString()));
               planetTouched("dec");
    }
      @FXML
    private void returnDecStyle(){
        dec_id.setImage(new Image(getClass().getResource("/assets2/dec.png").toString()));
       
    }
    
    /// SAT
    @FXML
    private void changeSatStyle(){
        sat_id.setImage(new Image(getClass().getResource("/assets2/satglow.png").toString()));
               planetTouched("sat");
    }
    @FXML
    private void returnSatStyle(){
        sat_id.setImage(new Image(getClass().getResource("/assets2/sat.png").toString()));
       
    }
    
    /// SUN
    @FXML
    private void changeSuntyle(){
        sun_id.setImage(new Image(getClass().getResource("/assets2/sunglow.png").toString()));
               planetTouched("sun");
    }
      @FXML
    private void returnSunStyle(){
        sun_id.setImage(new Image(getClass().getResource("/assets2/sun.png").toString()));
       
    }
    
    /// MON
     @FXML
    private void changeMonStyle(){
        mon_id.setImage(new Image(getClass().getResource("/assets2/monglow.png").toString()));
               planetTouched("mon");
    }
      @FXML
    private void returnMonStyle(){
        mon_id.setImage(new Image(getClass().getResource("/assets2/mon.png").toString()));
       
    }
    
    /// TUE
    @FXML
    private void changeTueStyle(){
       tue_id.setImage(new Image(getClass().getResource("/assets2/tueglow.png").toString()));
               planetTouched("tue");
    }
      @FXML
    private void returnTueStyle(){
        tue_id.setImage(new Image(getClass().getResource("/assets2/tue.png").toString()));
       
    }
    
    /// WED
    @FXML
    private void changeWedStyle(){
        wed_id.setImage(new Image(getClass().getResource("/assets2/wedglow.png").toString()));
               planetTouched("wed");
    }
      @FXML
    private void returnWedStyle(){
        wed_id.setImage(new Image(getClass().getResource("/assets2/wed.png").toString()));
       
    }
    
    /// FRI
    @FXML
    private void changeFriStyle(){
        fri_id.setImage(new Image(getClass().getResource("/assets2/friglow.png").toString()));
               planetTouched("fri");
    }
      @FXML
    private void returnFriStyle(){
        fri_id.setImage(new Image(getClass().getResource("/assets2/fri.png").toString()));
       
    }
    
   
    
    /// JAN
    @FXML
    private void janClicked(){
        //planetClicked("jan");
        clickedAmount++;
        System.out.println("i clicked jan");
        match.addToClickedPlanetsList("jan");
        match.addToBonusPlanetsList("jan");
    }
    /// FEB
    @FXML
    private void febClicked(){
     //planetClicked("feb");
    clickedAmount++;
    System.out.println("i clicked feb");  
    match.addToClickedPlanetsList("feb");
    match.addToBonusPlanetsList("feb");
    }
    /// MARS
    @FXML
    private void marsClicked(){
       //planetClicked("mars");
           clickedAmount++;
    System.out.println("i clicked mars");  
    match.addToClickedPlanetsList("mars");
    match.addToBonusPlanetsList("mars");
    }
    /// APRIL
    @FXML
    private void aprilClicked(){
              //planetClicked("april");
           clickedAmount++;
    System.out.println("i clicked april");  
    match.addToClickedPlanetsList("april");
    match.addToBonusPlanetsList("april");
    }
    /// MAY
    @FXML
    private void mayClicked(){
      // planetClicked("may");
                  clickedAmount++;
    System.out.println("i clicked may");  
    match.addToClickedPlanetsList("may");
    match.addToBonusPlanetsList("may");
    }
    /// JUNE
    @FXML
    private void juneClicked(){
      // planetClicked("june");
                       clickedAmount++;
    System.out.println("i clicked june");  
    match.addToClickedPlanetsList("june");
    match.addToBonusPlanetsList("june");
    }
    /// JULY
    @FXML
    private void julyClicked(){
      // planetClicked("july");
                       clickedAmount++;
    System.out.println("i clicked july");  
    match.addToClickedPlanetsList("july");
    match.addToBonusPlanetsList("july");
    }
    /// AUGUST
    @FXML
    private void augustClicked(){
      // planetClicked("august");
                       clickedAmount++;
    System.out.println("i clicked august");  
    match.addToClickedPlanetsList("august");
    match.addToBonusPlanetsList("august");
    }
    /// SEPT
    @FXML
    private void septClicked(){
       //planetClicked("sept");
                       clickedAmount++;
    System.out.println("i clicked sept");  
    match.addToClickedPlanetsList("sept");
    match.addToBonusPlanetsList("sept");
    }
    /// OCT
    @FXML
    private void octClicked(){
      // planetClicked("oct");
                       clickedAmount++;
    System.out.println("i clicked oct");  
    match.addToClickedPlanetsList("oct");
    match.addToBonusPlanetsList("oct");
    }
    /// NOV
    @FXML
    private void novClicked(){
       //planetClicked("nov");
                       clickedAmount++;
    System.out.println("i clicked nov");  
    match.addToClickedPlanetsList("nov");
     match.addToBonusPlanetsList("nov");
    }
    /// DEC
    @FXML
    private void decClicked(){
       //planetClicked("dec");
                       clickedAmount++;
    System.out.println("i clicked dec");  
    match.addToClickedPlanetsList("dec");
    match.addToBonusPlanetsList("dec");
    }
    /// SAT
    @FXML
    private void satClicked(){
       //planetClicked("sat");
                       clickedAmount++;
    System.out.println("i clicked sat");  
    match.addToClickedPlanetsList("sat");
    match.addToBonusPlanetsList("sat");
    }
    /// SUN
    @FXML
    private void sunClicked(){
      // planetClicked("sun");
                       clickedAmount++;
    System.out.println("i clicked sun");  
    match.addToClickedPlanetsList("sun");
    match.addToBonusPlanetsList("sun");
    }
    /// MON
    @FXML
    private void monClicked(){
      // planetClicked("mon");
                       clickedAmount++;
    System.out.println("i clicked mon");  
    match.addToClickedPlanetsList("mon");
    match.addToBonusPlanetsList("mon");
    }
    /// TUE
    @FXML
    private void tueClicked(){
      // planetClicked("tue");
                       clickedAmount++;
    System.out.println("i clicked tue");  
    match.addToClickedPlanetsList("tue");
    match.addToBonusPlanetsList("tue");
    }
    /// WED
    @FXML
    private void wedClicked(){
      // planetClicked("wed");
                       clickedAmount++;
    System.out.println("i clicked wed");  
    match.addToClickedPlanetsList("wed");
    match.addToBonusPlanetsList("wed");
    }
    /// FRI
    @FXML
    private void friClicked(){
     //  planetClicked("fri");
                       clickedAmount++;
    System.out.println("i clicked fri");  
    match.addToClickedPlanetsList("fri");
    match.addToBonusPlanetsList("fri");
    }

    
    
   //MY 2 MAPS
    private HashMap <String,List<String>> mapNeighboursString = new HashMap<String, List<String>>();
    private HashMap<String, ImageView> mapStringImage = new HashMap<String, ImageView>();
    private HashMap<String, ImageView> mapStringShip = new HashMap<String, ImageView>();
    private HashMap<String, ImageView> buttons = new HashMap<String, ImageView>(); // store buttons imageView
    int clickedAmount = 0;
    Map matchMap; //CREATE THE MAP WITH THE PLANETS
    Match match;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        createMapforImageViews();          
          Player bluePlayer = new Player(true,false); // GENERATE THE FIRST PLAYER(BLUE PLAYER)
          Player redPlayer = new Player(false,true); // GENERATE THE SECOND PLAYER(RED PLAYER)
          matchMap = new Map(mapNeighboursString, mapStringImage, mapStringShip);
          matchMap.createMap();
          match = new Match(matchMap , bluePlayer, redPlayer, flag_id , attack_id ,choose_id , 
                    inputLabel_id , input_id);
          match.startMatch();
    } 
    
    
    public void planetTouched(String planetName){
        // TODO: WHEN A PLENET IS CLICKED 
        //matchMap.showDetails(planetName);
    }
   
    
    
    
    public void planetClicked(String planetName){
       // match.afterClick(planetName);
        
    
    }
   

    public void createMapforImageViews(){
        
        /// Buttons Map
        
        
        
        // JAN
        List<String> janNeighboursList = new ArrayList<String>();
        janNeighboursList.add("fri");
        janNeighboursList.add("mars");
        janNeighboursList.add("sept");
        
        // FEB
        List<String> febNeighboursList = new ArrayList<String>();
        febNeighboursList.add("fri");
        febNeighboursList.add("dec");
        febNeighboursList.add("july");
        
        // MARS
        List<String> marsNeighboursList = new ArrayList<String>();
        marsNeighboursList.add("jan");
        marsNeighboursList.add("wed");
        marsNeighboursList.add("oct");
        
        // APRIL
        List<String> aprilNeighboursList = new ArrayList<String>();
        aprilNeighboursList.add("august");
        aprilNeighboursList.add("may");
        
        // MAY
        List<String> mayNeighboursList = new ArrayList<String>();
        mayNeighboursList.add("mon");
        mayNeighboursList.add("june");
        mayNeighboursList.add("april");
        
        // JUNE
        List<String> juneNeighboursList = new ArrayList<String>();
        juneNeighboursList.add("may");
        juneNeighboursList.add("sun");
        juneNeighboursList.add("august");
        
        // JULY
        List<String> julyNeighboursList = new ArrayList<String>();
        julyNeighboursList.add("august");
        julyNeighboursList.add("sun");
        julyNeighboursList.add("feb");
        
        // AUGUST
        List<String> augustNeighboursList = new ArrayList<String>();
        augustNeighboursList.add("june");
        augustNeighboursList.add("july");
        augustNeighboursList.add("april");
        augustNeighboursList.add("dec");
        
        // SEPT
        List<String> septNeighboursList = new ArrayList<String>();
        septNeighboursList.add("jan");
        septNeighboursList.add("sat");
        septNeighboursList.add("wed");
        
        // OCT
        List<String> octNeighboursList = new ArrayList<String>();
        octNeighboursList.add("mars");
        octNeighboursList.add("wed");
        octNeighboursList.add("tue");
        
        // NOV
        List<String> novNeighboursList = new ArrayList<String>();
        novNeighboursList.add("sun");
        novNeighboursList.add("tue");
        novNeighboursList.add("wed");
        
        // DEC
        List<String> decNeighboursList = new ArrayList<String>();
        decNeighboursList.add("feb");
        decNeighboursList.add("august");
        
        // SAT
        List<String> satNeighboursList = new ArrayList<String>();
        satNeighboursList.add("sun");
        satNeighboursList.add("fri");
        satNeighboursList.add("sept");
        satNeighboursList.add("wed");
        
        // SUN
        List<String> sunNeighboursList = new ArrayList<String>();
        sunNeighboursList.add("june");
        sunNeighboursList.add("july");
        sunNeighboursList.add("sat");
        sunNeighboursList.add("nov");
        sunNeighboursList.add("mon");
        
        // MON
        List<String> monNeighboursList = new ArrayList<String>();
        monNeighboursList.add("tue");
        monNeighboursList.add("sun");
        monNeighboursList.add("may");
        
        // TUE
        List<String> tueNeighboursList = new ArrayList<String>();
        tueNeighboursList.add("nov");
        tueNeighboursList.add("mon");
        tueNeighboursList.add("oct");
        
        // WED
        List<String> wedNeighboursList = new ArrayList<String>();
        wedNeighboursList.add("oct");
        wedNeighboursList.add("mars");
        wedNeighboursList.add("sept");
        wedNeighboursList.add("nov");
        wedNeighboursList.add("sat");
        
        // FRI
        List<String> friNeighboursList = new ArrayList<String>();
        friNeighboursList.add("jan");
        friNeighboursList.add("sat");
        friNeighboursList.add("feb");
          
        // FILL FIRST MAP
        mapNeighboursString.put("jan",janNeighboursList);
        mapNeighboursString.put("feb",febNeighboursList);
        mapNeighboursString.put("mars",marsNeighboursList);
        mapNeighboursString.put("april",aprilNeighboursList);
        mapNeighboursString.put("may",mayNeighboursList);
        mapNeighboursString.put("june",juneNeighboursList);
        mapNeighboursString.put("july",julyNeighboursList);
        mapNeighboursString.put("august",augustNeighboursList);
        mapNeighboursString.put("sept",septNeighboursList);
        mapNeighboursString.put("oct",octNeighboursList);
        mapNeighboursString.put("nov",novNeighboursList);
        mapNeighboursString.put("dec",decNeighboursList);
        mapNeighboursString.put("sat",satNeighboursList);
        mapNeighboursString.put("sun",sunNeighboursList);
        mapNeighboursString.put("mon",monNeighboursList);
        mapNeighboursString.put("tue",tueNeighboursList);
        mapNeighboursString.put("wed",wedNeighboursList);
        mapNeighboursString.put("fri",friNeighboursList);
        
        // FILL SECOND MAP
        mapStringImage.put("jan", jan_id);
        mapStringImage.put("feb", feb_id);
        mapStringImage.put("mars", mars_id);
        mapStringImage.put("april", april_id);
        mapStringImage.put("may", may_id);
        mapStringImage.put("june", june_id);
        mapStringImage.put("july", july_id);
        mapStringImage.put("august", august_id);
        mapStringImage.put("sept", sept_id);
        mapStringImage.put("oct", oct_id);
        mapStringImage.put("nov", nov_id);
        mapStringImage.put("dec", dec_id);
        mapStringImage.put("sat", sat_id);
        mapStringImage.put("sun", sun_id);
        mapStringImage.put("mon", mon_id);
        mapStringImage.put("tue", tue_id);
        mapStringImage.put("wed", wed_id);
        mapStringImage.put("fri", fri_id);
        
        // FILL THIRD MAP
        mapStringShip.put("jan", jan_ship);
        mapStringShip.put("feb", feb_ship);
        mapStringShip.put("mars", mars_ship);
        mapStringShip.put("april", april_ship);
        mapStringShip.put("may", may_ship);
        mapStringShip.put("june", june_ship);
        mapStringShip.put("july", july_ship);
        mapStringShip.put("august", august_ship);
        mapStringShip.put("sept", sept_ship);
        mapStringShip.put("oct", oct_ship);
        mapStringShip.put("nov", nov_ship);
        mapStringShip.put("dec", dec_ship);
        mapStringShip.put("sat", sat_ship);
        mapStringShip.put("sun", sun_ship);
        mapStringShip.put("mon", mon_ship);
        mapStringShip.put("tue", tue_ship);
        mapStringShip.put("wed", wed_ship);
        mapStringShip.put("fri", fri_ship);

    }
    
}
