import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

public class Sketcher_Pad implements MouseListener, MouseMotionListener {
    /* Global Variables =====================================================================*/
    JFrame window;
    JPanel gridPad;
    Container content;
    JLabel[][] gridLabels;
    static int[][] gridData;
    int resX, resY, currmX,currmY,prevmX,prevmY;
    Random randColor = new Random(255);
    /* =====================================================================================*/
    /* Main Functions ======================================================================*/
    /* Main Constructor */
    public Sketcher_Pad(int res) {
        resX = res;
        resY = res;
        //Prep Work
        gridPad = new JPanel();
        gridPad.setLayout(new GridLayout(resX,resY));
        gridData = new int[resX][resY];
        gridLabels = new JLabel[resX][resY];

        for (int i = 0; i < resX; i++) {
            for (int j = 0; j < resY; j++) {
                gridData[i][j] = i + j;
                gridLabels[i][j] = new JLabel();
                gridLabels[i][j].setName(i+","+j);
                gridLabels[i][j].setOpaque(true);
                gridLabels[i][j].addMouseListener(this);
                gridLabels[i][j].addMouseMotionListener(this);
                gridLabels[i][j].setBackground(new Color(i+j,i+j,i+j));
                gridPad.add(gridLabels[i][j]);
            }
        }
        
        //Layering
        window = new JFrame("Sketcher Pad");
        content = window.getContentPane();
        content.add(gridPad);
        window.setSize(450,450);

        // Display To User
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /* Main For Debugging */
    public static void main(String[] args) {
        int res = 10;
        try {
           //res = Integer.parseInt(args[0]);
        } catch (Exception e) {
            System.out.println(e.toString());
            System.exit(0);
        }
        new Sketcher_Pad(res);
    }
    
    /* =====================================================================================*/
    /* Event Listeners =====================================================================*/
    /* Mouse Listeners */
    public void mousePressed(MouseEvent e) {
        System.out.println(e.getComponent().getName() + " pressed");
     }
 
    public void mouseReleased(MouseEvent e) {
        System.out.println(e.getComponent().getName() + " released");
    }
 
    public void mouseEntered(MouseEvent e) {
        System.out.println(e.getComponent().getName() + " entered");
    }
 
    public void mouseExited(MouseEvent e) {
        System.out.println(e.getComponent().getName() + " exited");
    }

    public void mouseClicked(MouseEvent e) {
        reset();
        System.out.println(e.getComponent().getName() + " clicked");
    }

    public void mouseDragged(MouseEvent e) {
        String name = e.getComponent().getName();
        int i = Integer.parseInt(name.split(",")[0]);
        int j = Integer.parseInt(name.split(",")[1]);
        updateColor(i,j, randColor.nextInt(256),randColor.nextInt(256),randColor.nextInt(256));
        System.out.println(name + " dragged");
    }

    public void mouseMoved(MouseEvent e) {
        System.out.println(e.getComponent().getName() + " moved");
    }
    /* =====================================================================================*/
    /* Helper Functions ====================================================================*/
    public void updateColor(int i, int j, int rVal, int gVal, int bVal) {
        gridData[i][j] = rVal + gVal + bVal;
        gridLabels[i][j].setBackground(new Color(rVal, gVal, bVal));
    }
    
    public void reset() {
        for (int i = 0; i < resX; i++) {
            for (int j = 0; j < resY; j++) {
                gridData[i][j] = i + j;
                gridLabels[i][j].setBackground(new Color(i+j,i+j,i+j));
            }
        }
    }
    /* =====================================================================================*/
}