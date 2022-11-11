package no.hvl.dat100.jplab11.oppgave3;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave1.*;
import no.hvl.dat100.jplab11.oppgave2.*;

public class Blogg {
	
	protected Innlegg[] innleggtabell;
	protected int nesteledig;

	public Blogg() {
		innleggtabell = new Innlegg[20];
		nesteledig = 0;
	}

	public Blogg(int lengde) {
		innleggtabell = new Innlegg[lengde];
		nesteledig = 0;
	}

	public int getAntall() {
		return nesteledig;
	}
	
	public Innlegg[] getSamling() {
		return this.innleggtabell;

	}
	
	public int finnInnlegg(Innlegg innlegg) {
		boolean funnet = false;
		int pos = 0;
		while (!funnet && pos < nesteledig) {
			if (innleggtabell[pos].erLik(innlegg)) {
				funnet = true;
			} else {
				pos++;
			}
			
		}
		if (funnet) {
			return pos;
		} else {
			return -1;
		}
		
	}

	public boolean finnes(Innlegg innlegg) {
		boolean funnet = false;
		int pos = 0;
		while (!funnet && pos < nesteledig) {
			if (innleggtabell[pos].getId() == innlegg.getId()) {
				funnet = true;
			}
			else {
				pos++;
			}
		}
		return funnet;
	}

	public boolean ledigPlass() {
		boolean ledig = false;
		if (nesteledig < innleggtabell.length)
			ledig = true;
		return ledig;
	}
	
	public boolean leggTil(Innlegg innlegg) {
		boolean lagtTil = false;
		if (!finnes(innlegg) && ledigPlass())
			innleggtabell[nesteledig] = innlegg;
			lagtTil = true;
			nesteledig++;
		return lagtTil;
	}
	
	public String toString() {
		String txt = Integer.toString(nesteledig) + "\n";
		for (int i = 0; i < nesteledig; i++) {
			txt += innleggtabell[i].toString();

		}

		return txt;
		
	}

	// valgfrie oppgaver nedenfor
	
	public void utvid() {
		Innlegg[] dobbelTab = new Innlegg[innleggtabell.length*2];
		for (int i = 0; i < innleggtabell.length; i++) {
			dobbelTab[i] = innleggtabell[i];
		}
		this.innleggtabell = dobbelTab;
	}
	
	public boolean leggTilUtvid(Innlegg innlegg) {
		boolean lagtTil = false;
		if (!ledigPlass()) {
			utvid();
		} 
		if (!finnes(innlegg)) {
			innleggtabell[nesteledig] = innlegg;
			lagtTil = true;
		}
		
		return lagtTil;
		
	}
	
	public boolean slett(Innlegg innlegg) {
		boolean slettet = false;
		int pos = 0;
		//sjekker om innlegget finnes og finner dens posisjon
		if (finnInnlegg(innlegg) > -1) {
			pos = finnInnlegg(innlegg);
			//bytter ut det innlegget som skal slettes med det siste innlegget som ble lagt til
			innleggtabell[pos] = innleggtabell[nesteledig-1];
			nesteledig--;
			//setter det siste innlegget lik null
			innleggtabell[nesteledig] = null;
		} 
		return slettet;
		
	}
	
	public int[] search(String keyword) {
		int antall = 0;
		int[] idTab = new int[nesteledig];
		for (int i = 0; i < nesteledig; i++) {
			if (innleggtabell[i].toString().matches("TEKST")) {
				if (innleggtabell[i].toString().matches( "(.)*" + keyword + "(.)*"));
				idTab[antall] = innleggtabell[i].getId();
				antall++;
			}
			
		}
		
		
		return idTab;

	}
}