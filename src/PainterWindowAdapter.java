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
    int temp;
    
    public PainterWindowAdapter(PainterFrame painterFrame)
    {
        this.painterFrame=painterFrame;
    }
    
    @Override public void windowClosing(WindowEvent evt)
    {
        System.exit(0);
    }
    
    /*@Override public void windowStateChanged(WindowEvent e) 
    {
        System.out.println("windows State Changed");
            //System.out.print(e.getNewState());
            if(painterFrame.getExtendedState()==0)
            { 
                //Рисует только 1 раз...не понятно почему...при 1ом развертывнии причем потом обратно непонятным образом затирается
                //RedrawImage();
               // repaint ();
            }
            if(painterFrame.getExtendedState() == 1)
                painterFrame.RedrawImage();
    }
    
    @Override
          public void windowDeiconified(WindowEvent e )   
          {
            System.out.println("Windows Deiconfied - returned to normal size");
            if (e.getSource() == painterFrame)
                painterFrame.RedrawImage();              
           }
          @Override
    public void windowOpened(WindowEvent we) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("Window Opened");
        //RedrawImage();
    }

    @Override
    public void windowIconified(WindowEvent we) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("windows Iconified - minimized");
    }

    @Override
    public void windowActivated(WindowEvent we) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        /*if(temp!=0)
            painterFrame.RedrawImage();
        temp++;
        System.out.println("window Activated");
    }

    @Override
    public void windowDeactivated(WindowEvent we) 
    {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("Window Deactivated");
    }*/
  
}

