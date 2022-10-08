

import java.awt.image.BufferedImage;




public class ActorFactory {
     
    
    public static Actor createActors( Cell loc , BufferedImage img, String desc, Actor.Player player ){

        Actor actor = null;
        if(desc.equals("Cat")) {
             actor = new Cat(loc, img, desc, player);
        } else if(desc.equals("Dog")) {
            actor = new Dog(loc, img, desc, player);
        } else if(desc.equals("Bird")) {
            actor = new Bird(loc, img, desc, player);
          } else {
            System.err.println("Unsupported Actor: " + desc);
            System.exit(1);
          }
       return actor;
    }


}