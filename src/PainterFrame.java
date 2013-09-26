/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * this project is developed by North Poeople, any use and coppy is extremly dangereous for you health and safety, please don't try it at home!
 */
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Panel;
import java.awt.Point;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;


public class PainterFrame extends Frame                                      
{
    //Menu class variables
    private Menu menu;
    private MenuBar menuBar;
    private Menu colorSubMenu;
    private MenuItem mSave;
    private Graphics g;    
    PainterWindowAdapter adapterWindow = new PainterWindowAdapter(this);
    Color color = Color.black;
    
    class CustomPanel extends Panel {
        public CustomPanel() {
            this.add(new CustomCanvas(new Dimension(320, 240)));
        }
        
        public CustomPanel (Dimension d)
        {
            this.add(new CustomCanvas (d));
        }
    }
    
    class CustomCanvas extends Canvas
    {
            private List<Point> locations = new ArrayList<>();
            private List<Color> ColorArray=new ArrayList<>();
            private List<Boolean> AreThePointConnected=new ArrayList<>();
            private Point sentinel = new Point();
            private MouseAdapter handler = new MouseHandler();
            private Dimension dimension;
            int temp=0;
            CustomCanvas(Dimension dimension) {
                this.dimension = dimension;
                this.setBackground(Color.white);
                this.addMouseListener(handler);
                this.addMouseMotionListener(handler);
                this.locations.add(sentinel);
            }
            
            @Override
            public Dimension getPreferredSize() {
                return dimension;
            }

            @Override
            public void paint(Graphics g) {
                //g.setColor(Color.blue);
                Point p1 = locations.get(0);
                for (Point p2 : locations.subList(1, locations.size())) {
                    g.setColor(ColorArray.get(locations.indexOf(p2)));
                    if(AreThePointConnected.get(locations.indexOf(p2)-1)==Boolean.TRUE){
                        g.drawLine(p1.x, p1.y, p2.x, p2.y);
                        p1 = p2;
                    }
                    else p1 = p2;
                }
            }

            @Override
            public void update(Graphics g) {
                paint(g);
               // temp=0;
                //g.clearRect(0, getHeight() - 24, 50, 20); // to background
                //g.setColor(Color.red);
                //g.drawString(String.valueOf(locations.size()), 8, getHeight() - 8);
            }
            
        private class MouseHandler extends MouseAdapter {

        @Override
        public void mousePressed(MouseEvent e) {
            if (locations.get(0) == sentinel) { // reference identity
                locations.set(0, new Point(e.getX(), e.getY()));
                ColorArray.add(color);
                AreThePointConnected.add(Boolean.TRUE);
                }
            
            }

        @Override
        public void mouseDragged(MouseEvent e) {
            locations.add(new Point(e.getX(), e.getY()));
            ColorArray.add(color);
            AreThePointConnected.add(Boolean.TRUE);
            repaint();
                }
        @Override
        public void mouseReleased(MouseEvent e){
            if (!locations.isEmpty()) {
                
                    //AreThePointConnected.get(locations.size()-1)=Boolean.FALSE;
                    AreThePointConnected.remove(locations.size()-1);
                    AreThePointConnected.add(Boolean.FALSE);
                
            }
        }
        }
    }

    public PainterFrame()
    {
        //super(title);
        
        CreateMenu();
        addWindowListener(adapterWindow);
        this.setSize(500, 350);
        this.add(new CustomPanel(this.getSize()));
    }
    
    private void CreateMenu()
    {
        menuBar = new MenuBar();
        menu = new Menu("File");
        mSave = new MenuItem("Save");
        colorSubMenu = new Menu("Choose Color...");
        
        final String[] colors = {"red","yellow","green","blue","magenta","black"};
        mSave.addActionListener(
                new ActionListener()
                {
                    @Override public void actionPerformed(ActionEvent e)
                    {
                        System.out.println("Saving file >_< Thanks,North People!!!");
                    }
                });
        for(int i=0;i<colors.length;i++)
        {
            final int ii = i;
            MenuItem m=new MenuItem(colors[i]);
            colorSubMenu.add(m);
            
            colorSubMenu.getItem(ii).addActionListener(
                                        new ActionListener()
                                                {
                                                    @Override public void actionPerformed(ActionEvent e)
                                                    {
                                                        
                                                        System.out.println("Chosen color is "+colors[ii]);
                                                        SetColor(colors[ii]);
                                                    }
                                                    
                                                 }
                                            );
        }
        
        menu.add(mSave);        
        menu.add(colorSubMenu);
        menuBar.add(menu);        
        setMenuBar(menuBar);
    }
    
    public void SetColor(String colr)
    {
        try {
            Field field = Class.forName("java.awt.Color").getField(colr);
            color = (Color)field.get(null);
        } catch (Exception ee) {
            color = null; // Not defined
        }
    }
    public static void saveCanvas(Canvas canvas) {

		BufferedImage image=new BufferedImage(canvas.getWidth(), canvas.getHeight(),BufferedImage.TYPE_INT_RGB);
		
		Graphics2D g2=(Graphics2D)image.getGraphics();
		
		
		canvas.paint(g2);
		try {
			ImageIO.write(image, "png", new File("/tmp/canvas.png"));
		} catch (Exception e) {
			
		}
	}

}


