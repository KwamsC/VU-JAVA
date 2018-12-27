package test;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class LonelyInteger {
	PrintStream out;
	int [] row;
	static final int[] ROW= {6, 2, 4, 2, 6, 7, 7, 1,3,5,1,3,5,4, 9};
	
	public LonelyInteger() {
		out= new PrintStream(System.out);
		row = ROW;
	}
	
	int lonelyInteger(){		
        int result = 0;
        
        for(int i : row) {
            result = result^i;
        }
        
        return result;
	}
	
	void start(){
		out.printf("%d", lonelyInteger() );
	}

	public static void main(String[] args) {
		new LonelyInteger().start();

	}

}

