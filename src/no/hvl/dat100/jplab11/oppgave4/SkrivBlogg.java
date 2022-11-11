package no.hvl.dat100.jplab11.oppgave4;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave3.*;

public class SkrivBlogg {

	public static boolean skriv(Blogg samling, String mappe, String filnavn) {
		
		boolean skrevet = false;

        PrintWriter printer = null;
        try {
            printer = new PrintWriter(mappe + filnavn);
            printer.print(samling.toString());
            printer.close();
            skrevet = true;
		}
		catch (FileNotFoundException e){
			System.out.println("noe gikk galt");
			
		}

		
		return skrevet;
	}
	
}
