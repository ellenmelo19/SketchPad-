package botoes;

import ferramentas.Cor;
import ferramentas.Pincel;

public class BotaoLimpar extends BotaoQuadrado {
    private final Pincel paint = new Pincel();

    public BotaoLimpar (int incomingX, int incomingY, int incomingSize, Cor incomingCor) {
        super(incomingX, incomingY, incomingSize, incomingCor);
    }

    @Override
    public void drawSelf() {
        //BotaoQuadrado se desenha 
        super.drawSelf();

       // Adiciona uma diagonal vermelha por cima do quadrado 
        paint.setLineColor(ferramentas.Cor.RED);
        paint.drawLine(getLeftX(), getTopY() + getSize(), getLeftX() + getSize(), getTopY());
    }

    @Override
    public void performAction() {
        // Desenha um novo retângulo sobre o interior para limpar a tela
        paint.setFillColor(Cor.WHITE);
        paint.drawRect(30, 30, 540, 340);
    }
}
