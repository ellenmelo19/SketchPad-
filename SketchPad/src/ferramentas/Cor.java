package ferramentas;

public class Cor {


  public static Cor BLACK = new Cor(0);
  public static Cor DARK_GRAY = new Cor(64);
  public static Cor GRAY = new Cor(128);
  public static Cor LIGHT_GRAY = new Cor(192);
  public static Cor WHITE = new Cor(255);

  
  public static Cor RED = new Cor(255, 0, 0);
  public static Cor GREEN = new Cor(0, 128, 0);
  public static Cor BLUE = new Cor(0, 0, 255);

  
  public static Cor LIME = new Cor(0, 255, 0);
  public static Cor YELLOW = new Cor(255, 255, 0);
  public static Cor CYAN = new Cor(0, 255, 255);
  public static Cor ORANGE = new Cor(255,165,0);
  public static Cor MAGENTA = new Cor(255, 0, 255);
  public static Cor PINK = new Cor(255, 192, 203);
  public static Cor MAROON = new Cor(128, 0, 0);
  public static Cor PURPLE = new Cor(128, 0, 128);
  public static Cor NAVY = new Cor(0, 0, 128);
  public static Cor BROWN = new Cor(165,42,42);


  private final int redValue;
  private final int greenValue;
  private final int blueValue;

  public Cor(int gray) {
    redValue = gray;
    greenValue = gray;
    blueValue = gray;
  }

  public Cor(int red, int green, int blue) {
    this.redValue = Math.max(0, Math.min(255, red));
    this.greenValue = Math.max(0, Math.min(255, green));
    this.blueValue = Math.max(0, Math.min(255, blue));
  }

  public Cor(float hue) {
    int rgb = java.awt.Color.HSBtoRGB(hue, 1, 1);
    redValue = (rgb >> 16) & 0xFF;
    greenValue = (rgb >> 8) & 0xFF;
    blueValue = rgb & 0xFF;
  }

  public int getRed() {
    return redValue;
  }

  public int getGreen() {
    return greenValue;
  }

  public int getBlue() {
    return blueValue;
  }


}