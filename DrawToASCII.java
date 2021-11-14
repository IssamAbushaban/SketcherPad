import java.io.*;
import java.util.*;

public class DrawToASCII {
    public static void main(String[] args) { 
        try {
            int res = 0;
            res = Integer.parseInt(args[0]);
            new Sketcher_Pad(res);
        } catch (Exception e) {
            System.out.println(e.toString());
            System.exit(0);
        }
    }
}