import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.Scene;

public class Controller {
	
    public void entityMove(nonPlayableChar[] list, int x, int y){
        for (int i = 0; i < list.length; i++){
            list[i].setxPos(list[i].getxPos() + x);
            list[i].setyPos(list[i].getyPos() + y);
        }
    }

    public void keyboardinput(Hamlet hamlet, nonPlayableChar[] list, background bg, Scene scene, Dialogue dia1){
        //if a key is pressed down
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent event) {

                //next four are for moving up, down, left, right (WASD)
                if (event.getCode() == KeyCode.A)
                {
                    bg.setX(bg.getxCoord() + 6);
                    entityMove(list,6,0 );
                    //hamlet.setxCoord(hamlet.getxCoord()-hamlet.getWalkingSpeed());
                    hamlet.setMoving(true);
                    hamlet.setReverse(false);
                }
                if (event.getCode() == KeyCode.D)
                {
                    bg.setX(bg.getxCoord() - 6);
                    entityMove(list,-6,0 );
                    //hamlet.setxCoord(hamlet.getxCoord() + hamlet.getWalkingSpeed());
                    hamlet.setMoving(true);
                    hamlet.setReverse(true);
                }
                if (event.getCode() == KeyCode.S)
                {
                    bg.setY(bg.getyCoord() - 6);
                    entityMove(list,0,-6 );
                    //hamlet.setyCoord(hamlet.getyCoord()+ hamlet.getWalkingSpeed());
                    hamlet.setMoving(true);
                }
                if (event.getCode() == KeyCode.W)
                {
                    bg.setY(bg.getyCoord() + 6);
                    entityMove(list,0,6);
                    //hamlet.setyCoord(hamlet.getyCoord() - hamlet.getWalkingSpeed());
                    hamlet.setMoving(true);
                }
                if (event.getCode() == KeyCode.T){
                    for (int i = 0; i < list.length; i++) {
                        if (hamlet.getxCoord() + 125 > list[i].getxPos() -100 && hamlet.getxCoord() + 125 <
                                list[i].getxPos() + 350 && hamlet.getyCoord()+125 > list[i].getyPos()- 100 &&
                                hamlet.getyCoord()+125 < list[i].getyPos() + 350)
                        {
                            if (hamlet.getxCoord() + 125 > list[i].getyPos() + 125){
                                list[i].setIsReverse(false);
                            }
                            if (hamlet.getxCoord() + 125 < list[i].getyPos() + 125){
                                list[i].setIsReverse(true);
                            }
                            
                            dia1.drawDialogue();
                            dia1.updateDialogue(i, scene);
                        }
                    }
                }
                if (event.getCode() == KeyCode.R)
                {
                    dia1.changeText();
                }
                
            }
        });

        //stop motion if a key is released
        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent event) {
                hamlet.setMoving(false);
                hamlet.setCounter(13);
            }
        });
    }


}
