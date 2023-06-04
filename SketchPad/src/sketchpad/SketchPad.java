package sketchpad;

import botoes.*;
import ferramentas.*;
import ferramentas.Cor;


public class SketchPad {
    private final Tela tela = new Tela();
    private final MouseInfo mouseInfo = new MouseInfo();
    private final Pincel paint = new Pincel();

  
    // Declarando variáveis para representar a última localização do mouse
    private int lastMouseX;
    private int lastMouseY;
    private CorCaneta[] penColorButtons = new CorCaneta[24];
    private int margem = 30;
    private int numCirc = 500;
    private int minR = 10;
    private int maxR = 30;
    private int buttonSideLength = 20;
    private int numButtons = 24;
    private int colorButtonStartY = 5;
    
          

    // Declarando e inicializando uma variável para o botão limpar
    private BotaoLimpar botaoLimpar = new BotaoLimpar(5, 5, 20, Cor.WHITE);

    public void drawBackground() {
      tela.setBackgroundColor(Cor.CYAN);
            
        for (int circleNumber = 0; circleNumber < numCirc; circleNumber++) {
            drawRandomCircle();
        }
    }

    public void drawInterior() {
        paint.setFillColor(Cor.WHITE);
        paint.drawRect(margem, 
                       margem, 
                       tela.getWidth() - 2 * margem, 
                       tela.getHeight() - 2 * margem);
    }

    public void drawButtons() {
        botaoLimpar.drawSelf();
        int startX = (tela.getWidth() - buttonSideLength * penColorButtons.length) / 2;
        penColorButtons[0] = new CorCaneta(startX, colorButtonStartY, buttonSideLength, Cor.BLACK);
        penColorButtons[0].drawSelf();
        for (int i = 1; i < penColorButtons.length; i++) {
            float hue = 1f / penColorButtons.length * i;
            startX += buttonSideLength;
            penColorButtons[i] = new CorCaneta(startX, colorButtonStartY, buttonSideLength, new Cor(hue));
            penColorButtons[i].drawSelf();
        }        
    }

    public void initialLaunch() {
        drawBackground();
        drawInterior();
        drawButtons();
        
       
    }

  

    public void update() {
       
        // Se o mouse acabou de ser clicado, atualiza os últimos dados de localização do mouse
        if (mouseInfo.isMousePressed()) {
            lastMouseX = mouseInfo.getX();
            lastMouseY = mouseInfo.getY();
        }

       // Só desenha linhas se o mouse foi arrastado e estiver dentro da superfície interior do esboço
        if (mouseInfo.isMouseDragged() &&
            mouseInfo.getX() >= 30 &&
            mouseInfo.getX() <= 570 &&
            mouseInfo.getY() >= 30 &&
            mouseInfo.getY() <= 370) {

            paint.drawLine(mouseInfo.getX(), mouseInfo.getY(), lastMouseX, lastMouseY);
            lastMouseX = mouseInfo.getX();
            lastMouseY = mouseInfo.getY();
        }

        // Pede ao botaoLimpar para executar seu método de atualização
        botaoLimpar.update();
      for (CorCaneta button : penColorButtons) {
        button.update();
      }
    }
    
    public void drawRandomCircle() {
        int x = Generator.randomInt(600);
        int y = Generator.randomInt(400);
        int radius = Generator.randomInt(10, 30);
        int r = Generator.randomInt(255);
        int g = Generator.randomInt(255);
        int b = Generator.randomInt(255);
        paint.setFillColor(r, g, b);
        paint.drawCircle(x, y, radius);
    }
 
          
  }

        
   
 