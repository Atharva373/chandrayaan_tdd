package Chandrayaan;
import java.util.*;

public class Chandrayaan {
    //Data Member Constants:

    private static final int N=0;//Constant for North direction
    private static final int S=1;//Constant for South direction
    private static final int E=2;//Constant for East  direction
    private static final int W=3;//Constant for West  direction
    private static final int U=4;//Constant for Up    direction
    private static final int D=5;//Constant for Down  direction

    private static void goForward(int x,int y,int z,int direction){
        int d=direction;

        if(d==N) y++;
        else if(d==S)y--;
        else if(d==E)x++;
        else if(d==W)x--;
        else if(d==U)z++;
        else z--;

    }


}
