package Chandrayaan;
import java.util.*;


public class Chandrayaan{
    //Data Member Constants:
    private static final String N="North";//Constant for North direction
    private static final String S="South";//Constant for South direction
    private static final String E="East";//Constant for East  direction
    private static final String W="West";//Constant for West  direction
    private static final String U="Up";  //Constant for Up    direction
    private static final String D="Down";//Constant for Down  direction

    //Function to move in the forward direction for the given axis
    private static void goForward(int x,int y,int z,String init_dir){
        String d=init_dir;

        switch(d){
            case N:y++;break;
            case S:y--;break;
            case E:x++;break;
            case W:x--;break;
            case U:z++;break;
            case D:z--;break;
        }

    }
    
    //Function to move in the forward direction for the given axis
    private static void goBackward(int x,int y,int z,String init_dir){
        String d=init_dir;
        switch(d){
            case N:y--;break;
            case S:y++;break;
            case E:x--;break;
            case W:x++;break;
            case U:z--;break;
            case D:z++;break;
        }

    }
    private static String complement(String dir){
        switch(dir){
            case N:return S;
            case S:return N;
            case W:return E;
            case E:return W;
            case U:return D;
            case D:return U;
            default:return dir;
        }

    }
    private static void rotateLeft(String prevDir,String currDir){
        if(currDir==U || currDir==D){
            String temp=currDir;
            switch(prevDir){
                case N:currDir=W;break;
                case W:currDir=S;break;
                case S:currDir=E;break;
                case E:currDir=N;break;
            }
            prevDir=temp;
        }
        else{
            String temp=currDir;
            switch(currDir){
                case N:currDir=W;break;
                case W:currDir=S;break;
                case S:currDir=E;break;
                case E:currDir=N;break;
            }
            prevDir=temp;
        }
    }
    
    private static void rotateRight(String prevDir,String currDir){
        if(currDir==U || currDir==D){
            String temp=currDir;
            switch(prevDir){
                case N:currDir=E;break;
                case W:currDir=N;break;
                case S:currDir=W;break;
                case E:currDir=S;break;
            }
            prevDir=temp;
        }
        else{
            String temp=currDir;
            switch(currDir){
                case N:currDir=E;break;
                case W:currDir=N;break;
                case S:currDir=W;break;
                case E:currDir=S;break;
            }
            prevDir=temp;
        }
    }

    private static void rotateUp(String prevDir,String currDir){
        String temp=currDir;
        if(currDir==N || currDir==W || currDir==S || currDir==E){
            currDir=U;prevDir=temp;
        }
        else{
            if(currDir==U){
                currDir=complement(prevDir);
            }
            else{
                currDir=prevDir;
            }
            prevDir=temp;
        }
        
    }

    private static void rotateDown(String prevDir,String currDir){
        String temp=currDir;
        if(currDir==N || currDir==W || currDir==S || currDir==E){
            currDir=D;prevDir=temp;
        }
        else{
            if(currDir==U){
                currDir=prevDir;
            }
            else{
                currDir=complement(prevDir);
            }
            prevDir=temp;
        }
    }

    public static void main(String[] args){
        int x=0,y=0,z=0;
        String direction=N;
        String prevDirection=N;

        char[] sequence={'f','r','f','b','l','u','d'};
        for(char query:sequence){
            switch(query){
                case 'f':
                goForward(x, y, z, direction);
                break;

                case 'b':
                goBackward(x, y, z, direction);
                break;

                case 'l':
                rotateLeft(prevDirection, direction);
                break;

                case 'r':
                rotateRight(prevDirection, direction);
                break;

                case 'u':
                rotateUp(prevDirection,direction);
                break;

                case 'd':
                rotateDown(prevDirection, direction);
                break;
            }
        }
        System.out.println("Final coordinates:\n"+"x:"+x+"\ty:"+y+"\tz:"+z);
        System.out.println("Final Direction:"+direction);
    }


}
