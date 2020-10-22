import java.io.*;
import java.util.*;

public class DrawToASCII {
    public static void main(String[] args) {
        int res = 0;
        try {
           res = Integer.parseInt(args[0]);
        } catch (Exception e) {
            System.out.println(e.toString());
            System.exit(0);
        }
        new Sketcher_Pad(res,res);
    }
}