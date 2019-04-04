
/*
 * Author: Ali Kýzýlcan
 * ID: 041601001
 * Date: February 17, 2018
 * Explanation: This program draws nine circles and fills whole page with random points, if the points are inside the circles, the color will be different.
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Assignment01 extends Application {

	public void start(Stage primaryStage) { 

		long scene_w = 600;       // width of scene
		long scene_h = 600;       // height of scene

		Pane pane = new Pane();   // create a pane

		Scene scene = new Scene(pane, scene_w, scene_h);

		primaryStage.setScene(scene);

		int[][] circles = {                // defined an array which holds the properties of the circles ( x , y positions and radius values)

				{ 100, 100, 50 },          

				{ 300, 100, 20 },

				{ 500, 100, 50 },

				{ 100, 300, 20 },

				{ 300, 300, 150 },

				{ 500, 300, 20 },

				{ 100, 500, 50 },

				{ 300, 500, 20 },

				{ 500, 500, 50 } };

		for (int i = 0; i < 9; i++) {           // used for loop to check all elements of array    

			Circle circle = new Circle();       // create a circle

			double x = circles[i][0];           // assigns the elements in the first column to x
			double y = circles[i][1];           // assigns the elements in the second column to y
			double radius = circles[i][2];      // assign the elements in the thirth column to radius
            
			// circle drawing code
			circle.setCenterX(x);               // makes x variables the x coordinates of circles
			circle.setCenterY(y);				// makes y variables the y coordinates of circles
			circle.setRadius(radius);           // assigns the radius variables' as a radius of circles
            
			circle.setStroke(Color.RED);
			circle.setStrokeWidth(1);
			circle.setFill(Color.WHITE);

			pane.getChildren().add(circle);     // adds circle to pane

		}

		for (int i = 0; i < 500000; i++) {         // used to determine the density of random points

			Circle randomCircles = new Circle();   // create a circle
            
			//Randomly determines x and y positions of points
			double a = Math.random() * scene_h;     
			double b = Math.random() * scene_w;     
            
			// circle drawing code
			randomCircles.setCenterX(a);  // makes a variables the x coordinates of random points
			randomCircles.setCenterY(b);  // makes b variables the y coordinates of random points
			randomCircles.setRadius(1);   // determine what the radius value of random points

			double[] distance = new double[9];       // defined an array which has 9 parameters 
			
			for (int j = 0; j < 9; j++) {            // used for loop to check all elements of array

				distance[j] = Math.pow(Math.pow(a - circles[j][0], 2) + Math.pow(b - circles[j][1], 2), 0.5);  // calculates distances between random points and center of circles
				
				//checks if the random points are in the circles, if they are makes them red, if they aren't make them light grey
				if (distance[0] < circles[0][2] || distance[1] < circles[1][2] || distance[2] < circles[2][2]              
						|| distance[3] < circles[3][2] || distance[4] < circles[4][2] || distance[5] < circles[5][2]
								|| distance[6] < circles[6][2] || distance[7] < circles[7][2] || distance[8] < circles[8][2]) {
					
					
					randomCircles.setStroke(Color.RED);  
					randomCircles.setFill(Color.RED);
				}

				else {
					
					randomCircles.setStroke(Color.LIGHTGREY);
					randomCircles.setFill(Color.LIGHTGREY);
				}
			}
			pane.getChildren().add(randomCircles);    // adds circles ( points ) to pane
		}

		primaryStage.setTitle("Circle drawing and filling whole page with random points.");         // Set the stage title
		primaryStage.setScene(scene);             // Place the scene in the stage
		primaryStage.show();                  // Display the stage
		
	}
	public static void main(String[] args) {            
		Application.launch(args);
	}
}
