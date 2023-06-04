package botoes;

import ferramentas.Cor;
import ferramentas.MouseInfo;
import ferramentas.Pincel;

public abstract class BotaoQuadrado {
    private final MouseInfo mouseInfo = new MouseInfo();
    private final Pincel paint = new Pincel();

    private final int leftX;
    private final int topY;
    private final int tam;
    private final Cor cor;

    public BotaoQuadrado(int incomingX, int incomingY, int incomingSize, Cor incomingColor) {
        leftX = incomingX;
        topY = incomingY;
        tam = incomingSize;
        cor = incomingColor;
    }

    public void update() {
        if (isPressed()) {
            performAction();
        }
    }

    public void drawSelf() {
        paint.setLineColor(Cor.BLACK);
        paint.setFillColor(cor);
        paint.drawRect(leftX, topY, tam, tam);
    }

    public boolean isPressed() {
        return mouseInfo.isMousePressed() &&
                mouseInfo.getX() >= leftX &&
                mouseInfo.getX() <= leftX + tam &&
                mouseInfo.getY() >= topY &&
                mouseInfo.getY() <= topY + tam;
    }

    public abstract void performAction();

    public Cor getCor() {
        return cor;
    }

    public int getLeftX() {
        return leftX;
    }

    public int getTopY() {
        return topY;
    }

    public int getSize() {
        return tam;
    }
}
