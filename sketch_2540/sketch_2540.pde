import peasy.*;
int[] heightsaver = new int[100000];

PeasyCam cam;

void setup()
{
  fullScreen(P3D);
  frameRate(1000);
  cam = new PeasyCam(this, 1000);
  cam.setMinimumDistance(50);
  cam.setMaximumDistance(500);
  generateHeights(10, 10, 10);
}

void draw()
{
  background(0);
  generateWorld(20, 100);
}

void generateHeights(int maxHeight, int worldWidth, int worldDepth)
{
  for (int heighterizer = 0; heighterizer < ((worldWidth * worldDepth)-1); heighterizer++)
  {
    heightsaver [heighterizer] = (int) random(0, maxHeight);
  }
}

void generateWorld(int worldWidth, int worldDepth)
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

Class blox
{
  float _xpos, _ypos, _zpos;
  blox(float x, float y, float z)
  {
    _xpos = x;
    _ypos = y;
    _zpos = z;
  }
}
