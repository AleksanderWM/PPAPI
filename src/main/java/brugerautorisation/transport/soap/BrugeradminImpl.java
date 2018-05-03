package brugerautorisation.transport.soap;

import brugerautorisation.data.Bruger;
import brugerautorisation.server.Brugerdatabase;
import javax.jws.WebService;


@WebService(endpointInterface = "brugerautorisation.transport.soap.Brugeradmin")
public class BrugeradminImpl implements Brugeradmin {
	Brugerdatabase db;

	@Override
	public Bruger hentBruger(String brugernavn, String adgangskode) {
		return db.hentBruger(brugernavn, adgangskode);
	}

	@Override
	public Bruger ændrAdgangskode(String brugernavn, String glAdgangskode, String nyAdgangskode) {
		Bruger b = db.hentBruger(brugernavn, glAdgangskode);
    if (nyAdgangskode.isEmpty()) throw new IllegalArgumentException("Tom adgangskode");
    if (nyAdgangskode.contains("\"") || nyAdgangskode.contains("'")) throw new IllegalArgumentException("Ugyldige tegn i adgangskoden");
		b.adgangskode = nyAdgangskode;
		db.gemTilFil(false);
		return b;
	}

	@Override
	public void sendEmail(String brugernavn, String adgangskode, String emne, String tekst) {
		
	}

	@Override
	public void sendGlemtAdgangskodeEmail(String brugernavn, String supplerendeTekst) {
		
	}

	@Override
	public Object getEkstraFelt(String brugernavn, String adgangskode, String feltnavn) {
		return db.hentBruger(brugernavn, adgangskode).ekstraFelter.get(feltnavn);
	}

	@Override
	public void setEkstraFelt(String brugernavn, String adgangskode, String feltnavn, Object værdi) {
		db.hentBruger(brugernavn, adgangskode).ekstraFelter.put(feltnavn, værdi);
		db.gemTilFil(false);
	}
}
