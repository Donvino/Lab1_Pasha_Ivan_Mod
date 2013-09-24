/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.event.*;
/**
 *
 * @author Ilya
 */
public class PainterWindowAdapter extends WindowAdapter
{
    PainterFrame painterFrame;
    
    public PainterWindowAdapter(PainterFrame painterFrame)
    {
        this.painterFrame=painterFrame;
    }
    
    @Override public void windowClosing(WindowEvent evt)
    {
        System.exit(0);
    }
}

