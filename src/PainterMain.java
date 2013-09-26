
import java.awt.TrayIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ilya
 */
public class PainterMain {
    
    public static void main (String args[])
    {
        final PainterFrame frameWindow = new PainterFrame();
          
        
        /*frameWindow.addWindowStateListener(new WindowStateListener() {
        @Override
        public void windowStateChanged(WindowEvent e) {
            System.out.print(e.getNewState());
            if(e.getNewState()==0)
            { 
                //Рисует только 1 раз...не понятно почему...при 1ом развертывнии причем потом обратно непонятным образом затирается
                frameWindow.RedrawImage();
                
            }
            /*if (e.getNewState() == ICONIFIED) {
                try {
                    final TrayIcon trayIcon = new TrayIcon(new ImageIcon("/usr/share/icons/gnome/16x16/emotes/face-plain.png").getImage());
                    trayIcon.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            frameWindow.setVisible(true);
                            SystemTray.getSystemTray().remove(trayIcon);
                        }
                    });
                    SystemTray.getSystemTray().add(trayIcon);
                    frameWindow.setVisible(false);
                } catch (AWTException e1) {
                    e1.printStackTrace();
                }
            }
        }
        
    });*/
        
        frameWindow.setTitle("North People's Paint");
        frameWindow.setVisible(true);
    }
    
}
