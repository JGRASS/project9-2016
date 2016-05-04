package serija;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GlumacTest {
	Glumac glumac;
	@Before
	public void setUp() throws Exception {
		glumac=new Glumac("", "", "");
	}

	@After
	public void tearDown() throws Exception {
		glumac=null;
	}

	@Test
	public void testGetImePrezime() {
		glumac.setImePrezime("ime i prezime");
		String imePrezime=glumac.getImePrezime();
		assertEquals("ime i prezime", imePrezime);
	}

	@Test
	public void testSetImePrezimeSveOk() {
		String imePrezime="ime i prezime";
		glumac.setImePrezime(imePrezime);
		assertEquals(imePrezime, glumac.getImePrezime());
	}
	@Test (expected= java.lang.RuntimeException.class)
	public void testSetImePrezimeNull(){
		glumac.setImePrezime(null);
	}

	@Test
	public void testGetDatumRodjenja() {
		glumac.setDatumRodjenja("datum rodjenja");
		String datumRodjenja=glumac.getDatumRodjenja();
		assertEquals("datum rodjenja", datumRodjenja);
	}

	@Test
	public void testSetDatumRodjenjaSveOk() {
		String datumRodjenja="datum rodjenja";
		glumac.setDatumRodjenja(datumRodjenja);
		assertEquals(datumRodjenja, glumac.getDatumRodjenja());
	}
	@Test (expected= java.lang.RuntimeException.class)
	public void testSetDatumRodjenjaNull(){
		glumac.setDatumRodjenja(null);
	}
	
	@Test
	public void testGetMestoRodjenja() {
		glumac.setMestoRodjenja("Mesto rodjenja");
		String mestoRodjenja=glumac.getMestoRodjenja();
		assertEquals("Mesto rodjenja", mestoRodjenja);
	}

	@Test
	public void testSetMestoRodjenjaSveOk() {
		String mestoRodjenja="mesto rodjenja";
		glumac.setMestoRodjenja(mestoRodjenja);
		assertEquals(mestoRodjenja, glumac.getMestoRodjenja());
	}

}
