package amazingCo.paquete;

import static org.junit.Assert.*;

import java.time.LocalTime;

import org.junit.Test;

public class PackageLockerTest {

	@Test
	public void testPackageLockerStringGPSCoordinateLocalTimeArrayArrayIntBoolean() {
		LocalTime[][] horario = { { LocalTime.of(8, 0), LocalTime.of(14, 0) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(9, 30), LocalTime.of(21, 10) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(6, 30), LocalTime.of(21, 0) },
				{ LocalTime.of(5, 45), LocalTime.of(15, 50) }, { LocalTime.of(2, 15), LocalTime.of(23, 00) } };

		PackageLocker t = new PackageLocker(0000000000, GPS, horario, 20, true);
		// TODO GPS
		assertEquals(t.getId(), 0000000000);
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 2; j++) {
				assertEquals(t.getHorarioDia(i)[j], horario[i][j]);

			}
		}
		assertEquals(t.getNumeroTaquillas(), 20);
		assertTrue(t.getOperativo());
	}

	@Test
	public void testPackageLockerStringGPSCoordinateLocalTimeArrayArrayInt() {
		LocalTime[][] horario = { { LocalTime.of(8, 0), LocalTime.of(14, 0) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(9, 30), LocalTime.of(21, 10) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(6, 30), LocalTime.of(21, 0) },
				{ LocalTime.of(5, 45), LocalTime.of(15, 50) }, { LocalTime.of(2, 15), LocalTime.of(23, 00) } };

		PackageLocker t = new PackageLocker(0000000000, GPS, horario, 20, true);
		// TODO GPS
		assertEquals(t.getId(), 0000000000);
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 2; j++) {
				assertEquals(t.getHorarioDia(i)[j], horario[i][j]);

			}
		}
		assertEquals(t.getNumeroTaquillas(), 20);
		assertTrue(t.getOperativo());

	}

	@Test
	public void testGetNumeroTaquillas() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetNumeroTaquillasLlenas() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetNumeroTaquillasVacias() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetUbicacion() {
		fail("Not yet implemented");
	}

	@Test
	public void testLocaclizaPaquete() {
		fail("Not yet implemented");
	}

	@Test
	public void testAsignaPaquete() {
		fail("Not yet implemented");
	}

	@Test
	public void testSacaPaquete() {
		fail("Not yet implemented");
	}

	@Test
	public void testDevuelvePaquete() {
		fail("Not yet implemented");
	}

}
