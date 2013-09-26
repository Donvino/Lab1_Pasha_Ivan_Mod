/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.*;

/**
 *
 * @author Ilya
 */

//NOT USED!!!!!!!!

class PainterMouseAdapter extends MouseAdapter{

    PainterFrame painterFrame;
    Color color = Color.black;
    int last_x, last_y;

    
    public PainterMouseAdapter(PainterFrame aThis) 
    {
        this.painterFrame=aThis;
    }
    
    @Override public void mousePressed(MouseEvent evt)
    {
        //if(painterFrame.contains(evt.getX(), evt.getY()))
        //{    
            last_x = evt.getX();
            last_y = evt.getY();
        //}   
    }
    
    @Override public void mouseDragged(MouseEvent evt)
    {   
        Graphics g = painterFrame.getGraphics();
        //will evt.getXY change in this function if mouse moves?
        //if (painterFrame.contains(evt.getX(), evt.getY()))
        //{
            g.setColor(color);
            g.drawLine(last_x, last_y, evt.getX(), evt.getY());
            last_x = evt.getX();
            last_y = evt.getY();
        //}
     }
    
     public void SetColor(Color _color)
     {   
         color=_color;
     }
       
}
