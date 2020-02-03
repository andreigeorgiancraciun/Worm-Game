/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wormgame.domain;

import java.util.List;
import java.util.ArrayList;
import wormgame.Direction;

/**
 *
 * @author CraciunA2
 */
public class Worm {

    private Direction originalDirection;
    private int originalY;
    private int originalX;
    private List<Piece> pieceList = new ArrayList<Piece>();
    private boolean grow = false;

    public Worm(int originalX, int originalY, Direction originalDirection) {

        this.originalX = originalX;
        this.originalY = originalY;
        this.originalDirection = originalDirection;
        pieceList.add(new Piece(originalX, originalY));

    }

    public Direction getDirection() {
        return originalDirection;
    }

    public void setDirection(Direction dir) {
        this.originalDirection = dir;
    }

    public int getLength() {
        return this.pieceList.size();
    }

    public List<Piece> getPieces() {
        return this.pieceList;
    }

    public void move() {

        if (pieceList.size() < 3) {
            if (getDirection() == Direction.RIGHT) {
                originalX++;
            }
            if (getDirection() == Direction.LEFT) {
                originalX--;
            }
            if (getDirection() == Direction.DOWN) {
                originalY++;
            }
            if (getDirection() == Direction.UP) {
                originalY--;
            }

            pieceList.add(new Piece(originalX, originalY));

        } else {

            if (getDirection() == Direction.RIGHT) {
                originalX++;
            }
            if (getDirection() == Direction.LEFT) {
                originalX--;
            }
            if (getDirection() == Direction.DOWN) {
                originalY++;
            }
            if (getDirection() == Direction.UP) {
                originalY--;
            }

            if (grow == false) {
                pieceList.add(new Piece(originalX, originalY));
                pieceList.remove(0);

            } else if (grow == true) {
                pieceList.add(new Piece(originalX, originalY));
                grow = false;
            }

        }
    }

    public void grow() {
        if (pieceList.size() >= 3) {
            this.grow = true;
        }
    }

    public boolean runsInto(Piece piece) {
        for (Piece p : pieceList) {
            if (p.runsInto(piece)) {
                return true;
            }
        }

        return false;
    }

    public boolean runsIntoItself() {
        for (int i = 0; i < pieceList.size() - 1; i++) {
            if (pieceList.get(i).runsInto(pieceList.get(pieceList.size() - 1))) {
                return true;
            }
        }

        return false;
    }

}
