package no.hvl.dat100.jplab11.oppgave5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave1.*;
import no.hvl.dat100.jplab11.oppgave2.*;
import no.hvl.dat100.jplab11.oppgave3.*;

import javax.swing.JOptionPane;

public class LesBlogg {

	private static String TEKST = "TEKST";
	private static String BILDE = "BILDE";

	public static Blogg les(String mappe, String filnavn) {
		Blogg blogg = null;
		BufferedReader leser = null ;
		try {
			leser = new BufferedReader(new FileReader(mappe + filnavn));
			String linje = leser.readLine();
			int antallInnlegg = Integer.parseInt(linje);
			blogg = new Blogg(antallInnlegg);
			Innlegg i = null;
			while (antallInnlegg > 0) {
				linje = leser.readLine();
				int id = Integer.parseInt(leser.readLine());
				String navn = leser.readLine();
				String dato = leser.readLine();
				int likes = Integer.parseInt(leser.readLine());
				String tekst = leser.readLine();
				i = new Tekst(id, navn, dato, likes, tekst);
				if (linje.equals(BILDE)) {
					String bilde = leser.readLine();
                    i = new Bilde(id, navn, dato, likes, tekst, bilde);
                } else if (linje.equals(TEKST)) {
                    i = new Tekst(id, navn, dato, likes, tekst);
                } else {
                    System.out.println("Det har skjedd en feil");
                }	
                blogg.leggTil(i);
                antallInnlegg--;
			}
			leser.close();
		
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch(IOException ioe) {
		     System.out.println(ioe);
		}
		return blogg;
	}
}
