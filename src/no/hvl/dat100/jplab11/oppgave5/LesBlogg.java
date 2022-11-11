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
		Scanner leser = null;
		try {
			leser = new Scanner(new FileReader(filnavn));
			int antallInnlegg = Integer.parseInt(leser.nextLine());
			blogg = new Blogg(antallInnlegg);
			Innlegg i;
			while (leser.hasNextLine()) {
				if (leser.nextLine().equals(TEKST)) {
					int id = leser.nextInt();
					String navn = leser.nextLine();
					String dato = leser.nextLine();
					int likes = leser.nextInt();
					String tekst = leser.nextLine();
					i = new Tekst(id, navn, dato, likes, tekst);
				} 
				else {
					int id = leser.nextInt();
					String navn = leser.nextLine();
					String dato = leser.nextLine();
					int likes = leser.nextInt();
					String tekst = leser.nextLine();
					String url = leser.nextLine();
					i = new Bilde(id, navn, dato, likes, tekst, url);
				}
				blogg.leggTil(i);		
			}
		
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch(IOException ioe) {
		     System.out.println(ioe);
		} finally {
			if (leser != null ) {
				leser.close();
			}
		}
		
		return blogg;
	}
}
