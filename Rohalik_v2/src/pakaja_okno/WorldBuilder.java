package pakaja_okno;

public class WorldBuilder {
    private int width;
    private int height;
    private Kletki[][] kletki;

    public WorldBuilder(int width, int height) {
        this.width = width;
        this.height = height;
        this.kletki = new Kletki[width][height];
    }

    public World build() {
        return new World(kletki);
    }
    
    //рандомизация клеток
    private WorldBuilder randomizekletki() {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                kletki[x][y] = Math.random() < 0.5 ? Kletki.FLOOR : Kletki.WALL;
            }
        }
        return this;
    }
    
    
    //сглаживание/оптимизация пещер
    private WorldBuilder smooth(int times) {
        Kletki[][] kletki2 = new Kletki[width][height];
        for (int time = 0; time < times; time++) {

         for (int x = 0; x < width; x++) {
             for (int y = 0; y < height; y++) {
              int floors = 0;
              int rocks = 0;

              for (int ox = -1; ox < 2; ox++) {
                  for (int oy = -1; oy < 2; oy++) {
                   if (x + ox < 0 || x + ox >= width || y + oy < 0
                        || y + oy >= height)
                       continue;

                   if (kletki[x + ox][y + oy] == Kletki.FLOOR)
                       floors++;
                   else
                       rocks++;
                  }
              }
              kletki2[x][y] = floors >= rocks ? Kletki.FLOOR : Kletki.WALL;
             }
         }
         kletki = kletki2;
        }
        return this;
    }
    
    public WorldBuilder makeCaves() {
        return randomizekletki().smooth(8);
    }


}