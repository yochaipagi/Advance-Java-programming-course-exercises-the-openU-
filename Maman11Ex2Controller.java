import java.util.Random;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;

public class Maman11Ex2Controller {
	final static int SIZE = 10;

    @FXML
    private Button btn1;

    @FXML
    private Canvas canv;
    
    private GraphicsContext gc;
    @FXML
    public void initialize() {
    	gc = canv.getGraphicsContext2D();
    }

    @FXML
    /*
    * draw a matrix and fill it with 10% squares
    *
    */
    void btn1Pressed(ActionEvent event) {
    	gc.clearRect(0,0, canv.getWidth(), canv.getHeight());//clear the canvas
    	for(int i = 0 ; i < canv.getWidth() ; i+=SIZE){//will draw lines from top to bottom in jumps of 10 pixels
    		gc.strokeLine(i, 0, i, canv.getHeight());
    		
    	}
    	for(int j = 0 ; j < canv.getHeight() ; j+=SIZE){//will draw lines from left to right in jumps of 10 pixels
    		gc.strokeLine(0, j , canv.getHeight(), j);
    	}
    	Random rand = new Random();
    	int numOfSquers = (int) (((canv.getHeight()/10) * (canv.getWidth()/10)))/10 ;//calculate 10% of squares in total
    	for(int i = 0 ; i<numOfSquers; i++) { //will run an fill 10% of the valid squares
    		int randomX1 = rand.nextInt((int) canv.getWidth());
    		int x1 = Math.round(randomX1/10)*10; //Generate valid (x,y) square in round 10 coordinate
    		int randomY1 = rand.nextInt((int) canv.getWidth());
    		int y1 = Math.round(randomY1/10)*10; //Generate valid (x,y) square in round 10 coordinate 
    		gc.setFill(Color.BLACK);
    		gc.fillRect(x1, y1, SIZE, SIZE);//the rect will be in the same size as a square and the coordinate is rounded to 10
    	}
    	
    	
    }

}
