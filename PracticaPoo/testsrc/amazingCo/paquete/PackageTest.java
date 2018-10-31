package amazingCo.paquete;

import static org.junit.Assert.*;

import org.junit.Test;
import java.time.LocalDate;

public class PackageTest {

	@Test
	public void testPackageDiezDigitos0() {
		Package p = new Package("0000000000");
		assertNotNull(p);
		assertEquals("0000000000", p.getId());
		LocalDate fecha = LocalDate.now().plusDays(7);
		assertEquals(fecha, p.getFecha());
	}

	@Test
	public void testPackageDiezDigitos9() {
		Package p = new Package("9999999991");
		assertNotNull(p);
		assertEquals("9999999991", p.getId());
		LocalDate fecha = LocalDate.now().plusDays(7);
		assertEquals(fecha, p.getFecha());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testPackageNueveDigitos() {
		Package p = new Package("012345678");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testPackageOnceDigitos() {
		Package p = new Package("01234567890");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testPackageIncumpleLaCondicion() {
		Package p = new Package("1111111111");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testPackagePrimeroNoEsDigito() {
		Package p = new Package("a111111111");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testPackageSegundoNoEsDigito() {
		Package p = new Package("1a11111111");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testPackageTerceroNoEsDigito() {
		Package p = new Package("11a1111111");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testPackageCuartoNoEsDigito() {
		Package p = new Package("111a111111");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testPackageQuintoNoEsDigito() {
		Package p = new Package("1111a11111");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testPackageSextoNoEsDigito() {
		Package p = new Package("11111a1111");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testPackageSeptimoNoEsDigito() {
		Package p = new Package("111111a111");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testPackageOctavoNoEsDigito() {
		Package p = new Package("1111111a11");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testPackageNovenoNoEsDigito() {
		Package p = new Package("11111111a1");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testPackageDecimoNoEsDigito() {
		Package p = new Package("111111111a");
	}

	@Test
	public void testGetFecha() {
		Package p = new Package("0000000000");
		assertNotNull(p);
		LocalDate fecha = LocalDate.now().plusDays(7);
		assertEquals(fecha, p.getFecha());
	}

	@Test
	public void testGetId() {
		Package p = new Package("0000000000");
		assertNotNull(p);
		assertEquals("0000000000", p.getId());
	}

	@Test
	public void testFechaPasadaNoPasada() {
		Package p = new Package("0000000000");
		LocalDate fecha = LocalDate.now().plusDays(7);
		assertFalse(p.fechaPasada(fecha));

	}

	@Test
	public void testFechaPasadaPasada() {
		Package p = new Package("0000000000");
		LocalDate fecha = LocalDate.now().plusDays(6);
		assertTrue(p.getFecha() + "<" + fecha, p.fechaPasada(fecha));

	}

	@Test(expected = NullPointerException.class)
	public void testFechaPasadaNull() {
		Package p = new Package("0000000000");
		LocalDate fecha = null;
		assertTrue(p.fechaPasada(fecha));

	}

	@Test
	public void testRecogidoValido() {
		Package p = new Package("0000000000");
		p.recogido();
		assertEquals(1, p.getEstado());
	}

	@Test(expected = IllegalStateException.class)
	public void testRecogidoRecogido() {
		Package p = new Package("0000000000");
		p.recogido();
		p.recogido();
	}

	@Test(expected = IllegalStateException.class)
	public void testRecogidoDevuelto() {
		Package p = new Package("0000000000");
		p.devuelto();
		p.recogido();
	}

	@Test
	public void testDevueltoValido() {
		Package p = new Package("0000000000");
		p.devuelto();
		assertEquals(2, p.getEstado());
	}

	@Test(expected = IllegalStateException.class)
	public void testDevueltoRecogido() {
		Package p = new Package("0000000000");
		p.devuelto();
		p.devuelto();
	}

	@Test(expected = IllegalStateException.class)
	public void testDevueltoDevuelto() {
		Package p = new Package("0000000000");
		p.recogido();
		p.devuelto();
	}

}
