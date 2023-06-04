package botoes;
import ferramentas.Cor;
import ferramentas.Pincel;


// Construindo uma classe para representar um Botão que pode ser usado para mudar a cor da caneta


public class CorCaneta extends BotaoQuadrado {
    private final Pincel paint = new Pincel();

    public CorCaneta(int incomingX, int incomingY, int incomingSize, Cor incomingColor) {
        // Envia as informações necessárias para o construtor do pai
        super(incomingX, incomingY, incomingSize, incomingColor);
    }

    @Override
    public void performAction() {
        // Atualiza a cor da linha da ferramenta de pintura
        paint.setLineColor(getCor());
    }
}
