/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wormgame.gui;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import wormgame.domain.Apple;
import wormgame.domain.Piece;
import wormgame.game.WormGame;

/**
 *
 * @author CraciunA2
 */
public class DrawingBoard extends JPanel implements Updatable{

    private WormGame wormGame;
    private final int pieceLength;
    
    public DrawingBoard(WormGame wormGame, int pieceLength){
        this.wormGame = wormGame;
        this.pieceLength = pieceLength;
    }
    
    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        graphics.setColor(Color.BLACK);
        for( Piece p : wormGame.getWorm().getPieces()){
            graphics.fill3DRect(p.getX()*pieceLength, p.getY()*pieceLength, this.pieceLength, this.pieceLength, true);
        }
        
        graphics.setColor(Color.red);
        Apple apple = wormGame.getApple();
        graphics.fillOval(apple.getX()*this.pieceLength, apple.getY()*this.pieceLength, this.pieceLength, this.pieceLength);
        
    }

    @Override
    public void update() {
        repaint();
    }
    
    
}
