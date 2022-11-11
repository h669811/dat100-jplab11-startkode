package no.hvl.dat100.jplab11.oppgave2;

import no.hvl.dat100.jplab11.common.TODO;

public class Bilde extends Tekst {
	
	protected String url;
	
	public Bilde(int id, String bruker, String dato, String tekst, String url) {
		super(id, bruker, dato, 0, tekst);
		this.url = url;
	}

	public Bilde(int id, String bruker, String dato, int likes, String tekst, String url) {
		super(id, bruker, dato, likes, tekst);
		this.url = url;
	}
	
	public String getUrl() {
		return this.url;

	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		String txt = "BILDE\n" + super.getId() + "\n" + super.getBruker() + "\n" + super.getDato() + "\n" + super.getLikes() + "\n" + super.getTekst()+ "\n" + this.url + "\n";
		return txt;

	}

	// Metoden nedenfor er kun for valgfri oppgave 6
	public String toHTML() {
		String txt = super.toHTML();
		txt += "\t\t<iframe src=\"" + this.url + "\" height=600 width=800></iframe><hr>\n";
		return txt;
				
	}
}
