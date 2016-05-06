package test.serija;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import serija.Epizoda;
import serija.Glumac;
import serija.Serija;

public class SerijaTest {
	Serija serija;
	@Before
	public void setUp() throws Exception {
		serija=new Serija("", "", null, "", null);
	}

	@After
	public void tearDown() throws Exception {
		serija=null;
	}

	@Test
	public void testGetNaziv() {
		serija.setNaziv("Naziv");
		String Naziv=serija.getNaziv();
		assertEquals("Naziv", Naziv);
	}

	@Test
	public void testSetNazivSveOk() {
		String Naziv="Naziv";
		serija.setNaziv(Naziv);
		assertEquals(Naziv, serija.getNaziv());
	}
	@Test (expected= java.lang.RuntimeException.class)
	public void testSetNazivNull(){
		serija.setNaziv(null);
	}
	@Test
	public void testGetOpis() {
		serija.setOpis("Opis");
		String Opis=serija.getOpis();
		assertEquals("Opis", Opis);
	}

	@Test
	public void testSetOpisSveOk() {
		String Opis="Opis";
		serija.setOpis(Opis);
		assertEquals(Opis, serija.getOpis());
	}
	@Test (expected= java.lang.RuntimeException.class)
	public void testSetOpisNull(){
		serija.setOpis(null);
	}

	@Test
	public void testGetPostava() {
		LinkedList<Glumac> pom=new LinkedList<>();
		pom.add(new Glumac("Pera Peric", "21.02.1876.", "Beograd"));
		pom.add(new Glumac("Zika Zikic", "17.3.1994.", "Novi Sad"));
		serija.setPostava(pom);
		LinkedList<Glumac> pom2=new LinkedList<>();
		pom2=serija.getPostava();
		assertEquals("Pera Peric",pom2.get(0).getImePrezime());
		assertEquals("21.02.1876.",pom2.get(0).getDatumRodjenja());
		assertEquals("Beograd",pom2.get(0).getMestoRodjenja());
		assertEquals("Zika Zikic",pom2.get(1).getImePrezime());
		assertEquals("17.3.1994.",pom2.get(1).getDatumRodjenja());
		assertEquals("Novi Sad",pom2.get(1).getMestoRodjenja());
	}

	@Test
	public void testSetPostavaSveOk() {
		LinkedList<Glumac> pom=new LinkedList<>();
		pom.add(new Glumac("Pera Peric", "21.02.1876.", "Beograd"));
		pom.add(new Glumac("Zika Zikic", "17.3.1994.", "Novi Sad"));
		serija.setPostava(pom);
		assertEquals("Pera Peric",serija.getPostava().get(0).getImePrezime());
		assertEquals("21.02.1876.",serija.getPostava().get(0).getDatumRodjenja());
		assertEquals("Beograd",serija.getPostava().get(0).getMestoRodjenja());
		assertEquals("Zika Zikic",serija.getPostava().get(1).getImePrezime());
		assertEquals("17.3.1994.",serija.getPostava().get(1).getDatumRodjenja());
		assertEquals("Novi Sad",serija.getPostava().get(1).getMestoRodjenja());
	}
	@Test (expected= java.lang.RuntimeException.class)
	public void testSetPostavaNull(){
		serija.setPostava(null);
	}

	@Test
	public void testGetGodina() {
		serija.setGodina("godina");
		String godina=serija.getGodina();
		assertEquals("godina", godina);
	}

	@Test
	public void testSetGodinaSveOk() {
		String godina="godina";
		serija.setGodina(godina);
		assertEquals(godina, serija.getGodina());
	}
	
	@Test (expected= java.lang.RuntimeException.class)
	public void testSetGodinaNull(){
		serija.setGodina(null);
	}

	@Test
	public void testGetEpizode() {
		LinkedList<Epizoda> pom=new LinkedList<>();
		pom.add(new Epizoda("epizoda 1", "sezona 1", "nije pregledana", "4.5.2016."));
		pom.add(new Epizoda("epizoda 2", "sezona 1", "nije pregledana", "5.5.2016."));
		serija.setEpizode(pom);
		LinkedList<Epizoda> pom2=new LinkedList<>();
		pom2=serija.getEpizode();
		assertEquals("epizoda 1",pom2.get(0).getNaziv());
		assertEquals("sezona 1",pom2.get(0).getSxe());
		assertEquals("nije pregledana",pom2.get(0).getStatus());
		assertEquals("4.5.2016.",pom2.get(0).getDatum());
		assertEquals("epizoda 2",pom2.get(1).getNaziv());
		assertEquals("sezona 1",pom2.get(1).getSxe());
		assertEquals("nije pregledana",pom2.get(1).getStatus());
		assertEquals("5.5.2016.",pom2.get(1).getDatum());
	}

	@Test
	public void testSetEpizodeSveOk() {
		LinkedList<Epizoda> pom=new LinkedList<>();
		pom.add(new Epizoda("epizoda 1", "sezona 1", "nije pregledana", "4.5.2016."));
		pom.add(new Epizoda("epizoda 2", "sezona 1", "nije pregledana", "5.5.2016."));
		serija.setEpizode(pom);
		assertEquals("epizoda 1",serija.getEpizode().get(0).getNaziv());
		assertEquals("sezona 1",serija.getEpizode().get(0).getSxe());
		assertEquals("nije pregledana",serija.getEpizode().get(0).getStatus());
		assertEquals("4.5.2016.",serija.getEpizode().get(0).getDatum());
		assertEquals("epizoda 2",serija.getEpizode().get(1).getNaziv());
		assertEquals("sezona 1",serija.getEpizode().get(1).getSxe());
		assertEquals("nije pregledana",serija.getEpizode().get(1).getStatus());
		assertEquals("5.5.2016.",serija.getEpizode().get(1).getDatum());
	}
	@Test (expected= java.lang.RuntimeException.class)
	public void testSetEpizodeNull(){
		serija.setEpizode(null);
	}

}
