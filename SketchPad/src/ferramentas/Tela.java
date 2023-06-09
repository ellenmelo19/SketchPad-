package ferramentas;

import sketchpad.Main;

public class Tela {
    private final Main applet = Main.applet;

    public int getWidth() {
        return applet.width;
    }

    public int getHeight() {
        return applet.height;
    }

    public void setBackgroundColor(Cor c) {
        applet.background(c);
    }

    public void setBackgroundColor(int red, int green, int blue) {
        applet.background(red, green, blue);
    }
}
