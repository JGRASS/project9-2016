package test.serija;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import serija.Epizoda;

public class EpizodaTest {
	Epizoda ep;
	@Before
	public void setUp() throws Exception {
		ep=new Epizoda("","","","");
	}

	@After
	public void tearDown() throws Exception {
		ep=null;
	}
	@Test
	public void testGetNaziv() {
		ep.setNaziv("Naziv epizode");
		String naziv=ep.getNaziv();
		assertEquals("Naziv epizode", naziv);
	}
	@Test
	public void testSetNazivSveOk() {
		String naziv="Naziv epizode";
		ep.setNaziv(naziv);
		assertEquals(naziv, ep.getNaziv());
	}
	@Test (expected= java.lang.RuntimeException.class)
	public void testSetNazivNull(){
		ep.setNaziv(null);
	}

	@Test
	public void testGetSxe() {
		ep.setSxe("Sxe");
		String Sxe=ep.getSxe();
		assertEquals("Sxe", Sxe);
	}

	@Test
	public void testSetSxeSveOk() {
		String Sxe="s x e";
		ep.setSxe(Sxe);
		assertEquals(Sxe, ep.getSxe());
	}
	@Test (expected= java.lang.RuntimeException.class)
	public void testSetSxeNull(){
		ep.setSxe(null);
	}

	@Test
	public void testGetStatus() {
		ep.setStatus("Status");
		String Status=ep.getStatus();
		assertEquals("Status", Status);
	}

	@Test
	public void testSetStatusSveOk() {
		String Status="status";
		ep.setStatus(Status);
		assertEquals(Status, ep.getStatus());
	}
	@Test (expected= java.lang.RuntimeException.class)
	public void testSetStatusNull(){
		ep.setStatus(null);
	}

	@Test
	public void testGetDatum() {
		ep.setDatum("Datum");
		String Datum=ep.getDatum();
		assertEquals("Datum", Datum);
	}

	@Test
	public void testSetDatumSveOk() {
		String Datum="Datum";
		ep.setDatum(Datum);
		assertEquals(Datum, ep.getDatum());
	}
	@Test (expected= java.lang.RuntimeException.class)
	public void testSetDatumNull(){
		ep.setDatum(null);
	}
	
	@Test
	public void testToString() {
		ep.setNaziv("Naziv");
		ep.setSxe("s x e");
		ep.setStatus("Status");
		ep.setDatum("Datum");
		String string=ep.toString();
		assertEquals("Naziv s x e Status Datum", string);
	}

}
