import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import peasy.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class sketch_2540 extends PApplet {


int[] heightsaver = new int[100000];

PeasyCam cam;

public void setup()
{
  
  frameRate(1000);
  cam = new PeasyCam(this, 1000);
  cam.setMinimumDistance(50);
  cam.setMaximumDistance(500);
  generateHeights(10, 10, 10);
}

public void draw()
{
  background(0);
  generateWorld(20, 100);
}

public void generateHeights(int maxHeight, int worldWidth, int worldDepth)
{
  for (int heighterizer = 0; heighterizer < ((worldWidth * worldDepth)-1); heighterizer++)
  {
    heightsaver [heighterizer] = (int) random(0, maxHeight);
  }
}

public void generateWorld(int worldWidth, int worldDepth)
{
  int heightindex = 1;
  for (int generateWidth = 1; generateWidth < worldWidth; generateWidth++)
  {
    for (int generateDepth = 1; generateDepth < worldDepth; generateDepth++)
    {
      heightindex += 1;
      println(heightindex);
      pushMatrix();
      translate(generateWidth, generateDepth, 0);
      box(1, 1, random(0, heightsaver [heightindex]));
      popMatrix();
    }
  }
}
// Class blox
//
// void buildBlox(int worldHeight)
// {
//
// }
  public void settings() {  fullScreen(P3D); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "sketch_2540" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
