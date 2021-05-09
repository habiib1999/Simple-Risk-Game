
package risk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javafx.scene.image.ImageView;


public class Territory {
    private boolean blue;
    private String imgUrl;
    private int armies;
    private List<Territory> neighbours ;
    private int id;
    private String name;
    private ImageView imageView;
    private ImageView shipImageView;
    
    public Territory(boolean blue, String imgUrl, int id, String name , ImageView imageView , ImageView shipImageView) {
        this.blue = blue;
        this.imgUrl = imgUrl;
        this.id = id;
        this.name = name;
        this.imageView  = imageView;
        this.shipImageView = shipImageView;
    }
    
    public void setBlue(boolean blue) {
        this.blue = blue;
    }



    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public void setArmies(int armies) {
        this.armies = armies;
    }

    public void setNeighbours(List<Territory> neighbours) {
        //this.neighbours.addAll(neighbours);
        this.neighbours = new ArrayList<Territory>();
        this.neighbours.addAll(neighbours);
        //Collections.copy(this.neighbours, neighbours);
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isBlue() {
        return blue;
    }


    public String getImgUrl() {
        return imgUrl;
    }

    public int getArmies() {
        return armies;
    }

    public ImageView getImageView() {
        return imageView;
    }

    
    public List<Territory> getNeighbours() {
        return neighbours;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void printNeighbours(){
        for(Territory territory2 : neighbours ) {
            System.out.println( territory2.getName() );
          }
    }

    public boolean isANeighbour(String territoryName){
        boolean flag = false;
    for(Territory territory1 : neighbours) { 
      if(territory1.getName().equals(territoryName)){
                  flag = true;
                  break;
              }
         }
    return flag;
    }
    
    public void increamentArmies(int c){
        this.armies = this.armies +c;
    }
    public void zeroArmies(){
        this.armies = 0;
    }

    public ImageView getShipImageView() {
        return shipImageView;
    }
    
}
