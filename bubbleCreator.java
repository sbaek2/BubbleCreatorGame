import processing.core.*;

public class bubbleCreator extends PApplet
{	
	PGraphics bubbles;
	PImage image1, image2, image3, image4;
	PFont myFont;
	int a, b, c, d=0;
	int numDrawn, score, sum1, sum2, sum3=0;
	int numPressed=0;
	boolean exitKey=false;
	gameController game;
	String startStatement = "To start the game press any key except for e!";
	
	public static void main(String[] args) 
	{
		PApplet.main("bubbleCreator");
	}

	public void setup() 
	{
		cursor(CROSS); 
		noStroke();
		myFont = createFont("Times New Roman", 48, true);
	    bubbles = createGraphics(width, height);
	    image1 = loadImage("image1.png");
	    image2 = loadImage("image2.png");
	    image3 = loadImage("image3.png");
	    image4 = loadImage("image4.png");
	    game = new gameController();
	}
	
	//when mouse is pressed it determines the x,y coordinates on the screen.
	public void mousePressed() 
	{
		 a=mouseX;
		 b=mouseY;
	}
    
	//if key is "1" draw small ellipses, if key is "2" draw medium ellipses, if key is "3" draw big ellipses
	//color is randomly chosen between RGB range from 0~255
	//big ellipses are 4 points, medium ellipses are 3 points, small ellipses are 2 points.
	public void mouseReleased()
	{
		 int color1 = game.colorSwitcher();
		 int color2 = game.colorSwitcher();
		 int color3 = game.colorSwitcher();
		 bubbles.beginDraw();
		 bubbles.fill(color1,color2,color3);
		 if (key=='3')
		 {
			 bubbles.ellipse(a, b, game.size3(), game.size3());
			 int id=4;
			 sum1 += game.getScore(id);
		 }
		 else if (key=='2')
		 {
			 bubbles.ellipse(a, b, game.size2(), game.size2());
			 int id=3;
			 sum2 += game.getScore(id);
		 }
		 else if (key=='1')
		 {
			 bubbles.ellipse(a, b, game.size1(), game.size1());
			 int id=2;
			 sum3 += game.getScore(id);
		 }
		 else
		 {
			 bubbles.ellipse(a, b, game.size1(), game.size1());
			 int id=2;
			 sum3 += game.getScore(id);
		 }
		 bubbles.endDraw();
		 numDrawn++;
		 //get the total score for the game
		 score = sum1+sum2+sum3;
	}
	
	//when key e is pressed game ends.
	public void keyPressed()
	{
		numPressed++;
		if (key=='e'||key=='E')
			exitKey=true;
	}
	
	//setting the size of the game window
	public void settings() 
	{
		 size(600,600);
	}

	public void draw()
	{
		 background(255);
		 textFont(myFont,30);
	     stroke(175);
		 fill(0);
		 textAlign(CENTER);
		 //start screen of the game
		 if (numPressed==0)
		 {
			 text(startStatement, width/2, 50);
		 	 textFont(myFont,15);
		 	 text("You can switch size of your bubbles:", width/2, height-50);
		 	 text("Press '1' for Small size, '2' for Middle size, '3' for Large size", width/2, height-20);
		 }
		 //game in process
		 else if (numPressed>0&&exitKey==false)
		 {
			 //print out the scores and the bubbles on the screen, exit when key 'e' or 'E' is pressed.
			 text("Score: " + score + " points", width/2, 60);
			 image(bubbles,0,0);
			 ellipse(a, b, c, d);
			 textFont(myFont,15);
			 text("Press '1' for Small size, '2' for Middle size, '3' for Large size", width/2, height-20);
		     text("To end the game press 'e'", width-100, 20);
		 }
		 //result screen of the game
		 else
		 {
			 background(255);
			 if (score==0)
			 {
				 //error message comes up when the user inputs 'e' before the game starts.
				 text("I told you not to press E!!!!!!!!!!!!!!!!!!!!!!", width/2, height/2);
			 }
			 else
			 {
				 text("Congrats! You have drawn " + numDrawn + " bubbles!!", width/2, 50);
				 //for every scores of 100, different images appear, and when score is over 400, fourth image continues to appear.
				 if (score<=100)
				 {
					 imageMode(CENTER);
					 image(image1,width/2,height/2,300,300);
				 }
				 else if (score>100&&score<=200)
				 {
					 imageMode(CENTER);
					 image(image2,width/2,height/2,300,300);
				 }
				 else if (score>200&&score<=300)
				 {
					 imageMode(CENTER);
					 image(image3,width/2,height/2,300,300);
				 }
				 else if (score>300)
				 {
					 imageMode(CENTER);
					 image(image4,width/2,height/2,300,300);
				 }
			 }
		 }
	}
}
