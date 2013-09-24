/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.*;
import java.awt.event.*;
import java.awt.Color;

/**
 *
 * @author Ilya
 */
public class PainterFrame extends Frame implements MouseListener, 
                                                    WindowListener, 
                                                    MouseMotionListener
{

    //Menu class variables
    private Menu menu;
    private MenuBar menuBar;
    private Menu colorSubMenu;
    private MenuItem mSave;
    
    PainterWindowAdapter adapterWindow = new PainterWindowAdapter(this);
    Color color = Color.black;
    int last_x, last_y;
    
    public PainterFrame()
    {
        //super(title);
        CreateMenu();
        addWindowListener(adapterWindow);
        addMouseListener(this);
        addMouseMotionListener(this);
        //this.menuBar.
    }
    
    private void CreateMenu()
    {
        menuBar = new MenuBar();
        menu = new Menu("File");
        mSave = new MenuItem("Save");
        colorSubMenu = new Menu("Choose Color...");
        
        String[] colors = {"red","yellow","green","blue","purple","black"};
        for(int i=0;i<colors.length;i++)
        {
            final int ii = i;
            MenuItem m=new MenuItem(colors[i]);
            colorSubMenu.add(m);
            colorSubMenu.addActionListener(
                                        new ActionListener()
                                                {
                                                    @Override public void actionPerformed(ActionEvent e)
                                                    {
                                                        System.out.println("Changed color to"+colorSubMenu.getItem(ii));
                                                    }
                                                 }
                                            );
        }
        
        menu.add(mSave);        
        menu.add(colorSubMenu);
        menuBar.add(menu);        
        setMenuBar(menuBar);
    }
    
    
    /*public void SetColor(int red,int blue, int green)
    {
        Color c = new Color (red,green,blue);
        this.
        adapterMouse.SetColor(c);
    }
    */

    @Override
    public void mouseClicked(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override public void mousePressed(MouseEvent evt)
    {
        if(this.contains(evt.getX(), evt.getY()))
        {    
            last_x = evt.getX();
            last_y = evt.getY();
        }   
    }

    @Override public void mouseDragged(MouseEvent evt)
    {   
        Graphics g = getGraphics();
        //will evt.getXY change in this function if mouse moves?
        if (this.contains(evt.getX(), evt.getY()))
        {
            g.setColor(color);
            g.drawLine(last_x, last_y, evt.getX(), evt.getY());
            last_x = evt.getX();
            last_y = evt.getY();
        }
     }
        
    @Override
    public void mouseReleased(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowOpened(WindowEvent we) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowClosing(WindowEvent we) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowClosed(WindowEvent we) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowIconified(WindowEvent we) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowDeiconified(WindowEvent we) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowActivated(WindowEvent we) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowDeactivated(WindowEvent we) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseMoved(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}


