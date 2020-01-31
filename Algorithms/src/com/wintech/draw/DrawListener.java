/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wintech.draw;

/**
 *
 * @author Prabu
 */
public interface DrawListener {
    public void mousePressed (double x, double y);
    public void mouseDragged (double x, double y);
    public void mouseReleased(double x, double y);
    public void keyTyped(char c);
}