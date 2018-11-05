package amazingCo.paquete;

import static org.junit.Assert.*;

import java.time.LocalTime;

import org.junit.Test;
import es.uva.inf.poo.maps.GPSCoordinate;

public class PackageLockerTest {

	@Test
	public void testPackageLockerConOpcionOperativo() {
		LocalTime[][] horario = { { LocalTime.of(8, 0), LocalTime.of(14, 0) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(9, 30), LocalTime.of(21, 10) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(6, 30), LocalTime.of(21, 0) },
				{ LocalTime.of(5, 45), LocalTime.of(15, 50) }, { LocalTime.of(2, 15), LocalTime.of(23, 00) } };
		GPSCoordinate gps = new GPSCoordinate(41.6551455,-4.7381979);
		PackageLocker t = new PackageLocker("0000000000", gps, horario, 20, true);
		assertEquals(t.getId(), "0000000000");
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 2; j++) {
				assertEquals(t.getHorarioDia(i)[j], horario[i][j]);

			}
		}
		assertEquals(t.getNumeroTaquillas(), 20);
		assertTrue(t.getOperativo());
		assertEquals(t.getUbicacion(),gps);
	}

	@Test
	public void testPackageLockerOperativoDirectamente() {
		LocalTime[][] horario = { { LocalTime.of(8, 0), LocalTime.of(14, 0) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(9, 30), LocalTime.of(21, 10) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(6, 30), LocalTime.of(21, 0) },
				{ LocalTime.of(5, 45), LocalTime.of(15, 50) }, { LocalTime.of(2, 15), LocalTime.of(23, 00) } };
		GPSCoordinate gps = new GPSCoordinate(41.6551455,-4.7381979);
		PackageLocker t = new PackageLocker("0000000000", gps, horario, 20, true);
		assertEquals(t.getId(), "0000000000");
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 2; j++) {
				assertEquals(t.getHorarioDia(i)[j], horario[i][j]);

			}
		}
		assertEquals(t.getNumeroTaquillas(), 20);
		assertTrue(t.getOperativo());
		assertEquals(t.getUbicacion(),gps);

	}
	@Test (expected = IllegalArgumentException.class)
	public void testPackageLockerConOpcionOperativoIdNull() {
		LocalTime[][] horario = { { LocalTime.of(8, 0), LocalTime.of(14, 0) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(9, 30), LocalTime.of(21, 10) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(6, 30), LocalTime.of(21, 0) },
				{ LocalTime.of(5, 45), LocalTime.of(15, 50) }, { LocalTime.of(2, 15), LocalTime.of(23, 00) } };
		GPSCoordinate gps = new GPSCoordinate(41.6551455,-4.7381979);
		PackageLocker t = new PackageLocker(null, gps, horario, 20, true);
	}
	@Test (expected = IllegalArgumentException.class)
	public void testPackageLockerConOpcionOperativoGpsNull() {
		LocalTime[][] horario = { { LocalTime.of(8, 0), LocalTime.of(14, 0) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(9, 30), LocalTime.of(21, 10) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(6, 30), LocalTime.of(21, 0) },
				{ LocalTime.of(5, 45), LocalTime.of(15, 50) }, { LocalTime.of(2, 15), LocalTime.of(23, 00) } };
		PackageLocker t = new PackageLocker("0000000000", null, horario, 20, true);
	}
	@Test (expected = IllegalArgumentException.class)
	public void testPackageLockerConOpcionOperativoHorarioNull() {
		GPSCoordinate gps = new GPSCoordinate(41.6551455,-4.7381979);
		PackageLocker t = new PackageLocker("0000000000", gps, null, 20, true);
	}
	@Test (expected = IllegalArgumentException.class)
	public void testPackageLockerConOpcionOperativoHorarioOchoDias() {
		LocalTime[][] horario = { { LocalTime.of(8, 0), LocalTime.of(14, 0) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(9, 30), LocalTime.of(21, 10) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(6, 30), LocalTime.of(21, 0) },
				{ LocalTime.of(5, 45), LocalTime.of(15, 50) }, { LocalTime.of(2, 15), LocalTime.of(23, 00) },
				{LocalTime.of(7, 15),LocalTime.of(20, 20)}};
		GPSCoordinate gps = new GPSCoordinate(41.6551455,-4.7381979);
		PackageLocker t = new PackageLocker("0000000000", gps, horario, 20, true);
	}
	@Test (expected = IllegalArgumentException.class)
	public void testPackageLockerConOpcionOperativoSeisDias() {
		LocalTime[][] horario = { { LocalTime.of(8, 0), LocalTime.of(14, 0) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(9, 30), LocalTime.of(21, 10) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(6, 30), LocalTime.of(21, 0) },
				{ LocalTime.of(5, 45), LocalTime.of(15, 50) } };
		GPSCoordinate gps = new GPSCoordinate(41.6551455,-4.7381979);
		PackageLocker t = new PackageLocker("0000000000", gps, horario, 20, true);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testPackageLockerConOpcionOperativoPrimerDiaNull() {
		LocalTime[][] horario = { null,
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(9, 30), LocalTime.of(21, 10) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(6, 30), LocalTime.of(21, 0) },
				{ LocalTime.of(5, 45), LocalTime.of(15, 50) }, { LocalTime.of(2, 15), LocalTime.of(23, 00) } };
		GPSCoordinate gps = new GPSCoordinate(41.6551455,-4.7381979);
		PackageLocker t = new PackageLocker("0000000000", gps, horario, 20, true);
	}
	@Test (expected = IllegalArgumentException.class)
	public void testPackageLockerConOpcionOperativoUltimoDiaNull() {
		LocalTime[][] horario = { { LocalTime.of(8, 0), LocalTime.of(14, 0) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(9, 30), LocalTime.of(21, 10) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(6, 30), LocalTime.of(21, 0) },
				{ LocalTime.of(5, 45), LocalTime.of(15, 50) }, null };
		GPSCoordinate gps = new GPSCoordinate(41.6551455,-4.7381979);
		PackageLocker t = new PackageLocker("0000000000", gps, horario, 20, true);
	}
	@Test (expected = IllegalArgumentException.class)
	public void testPackageLockerConOpcionOperativoHoraAperturaPrimerDiaNull() {
		LocalTime[][] horario = { {null, LocalTime.of(14, 0) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(9, 30), LocalTime.of(21, 10) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(6, 30), LocalTime.of(21, 0) },
				{ LocalTime.of(5, 45), LocalTime.of(15, 50) }, { LocalTime.of(2, 15), LocalTime.of(23, 00) } };
		GPSCoordinate gps = new GPSCoordinate(41.6551455,-4.7381979);
		PackageLocker t = new PackageLocker("0000000000", gps, horario, 20, true);
	}
	@Test (expected = IllegalArgumentException.class)
	public void testPackageLockerConOpcionOperativoHoraCierrePrimerDiaNull() {
		LocalTime[][] horario = { { LocalTime.of(8, 0),null },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(9, 30), LocalTime.of(21, 10) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(6, 30), LocalTime.of(21, 0) },
				{ LocalTime.of(5, 45), LocalTime.of(15, 50) }, { LocalTime.of(2, 15), LocalTime.of(23, 00) } };
		GPSCoordinate gps = new GPSCoordinate(41.6551455,-4.7381979);
		PackageLocker t = new PackageLocker("0000000000", gps, horario, 20, true);
	}
	@Test (expected = IllegalArgumentException.class)
	public void testPackageLockerConOpcionOperativoHoraAperturaUltimoDiaNull() {
		LocalTime[][] horario = { { LocalTime.of(8, 0), LocalTime.of(14, 0) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(9, 30), LocalTime.of(21, 10) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(6, 30), LocalTime.of(21, 0) },
				{ LocalTime.of(5, 45), LocalTime.of(15, 50) }, { null, LocalTime.of(23, 00) } };
		GPSCoordinate gps = new GPSCoordinate(41.6551455,-4.7381979);
		PackageLocker t = new PackageLocker("0000000000", gps, horario, 20, true);
	}
	@Test (expected = IllegalArgumentException.class)
	public void testPackageLockerConOpcionOperativoHoraCierreUltimoDiaNull() {
		LocalTime[][] horario = { { LocalTime.of(8, 0), LocalTime.of(14, 0) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(9, 30), LocalTime.of(21, 10) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(6, 30), LocalTime.of(21, 0) },
				{ LocalTime.of(5, 45), LocalTime.of(15, 50) }, { LocalTime.of(2, 15), null } };
		GPSCoordinate gps = new GPSCoordinate(41.6551455,-4.7381979);
		PackageLocker t = new PackageLocker("0000000000", gps, horario, 20, true);
	}
	@Test (expected = IllegalArgumentException.class)
	public void testPackageLockerConOpcionOperativoPrimerDiaTresHoras() {
		LocalTime[][] horario = { { LocalTime.of(3, 30), LocalTime.of(8, 0), LocalTime.of(14, 0) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(9, 30), LocalTime.of(21, 10) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(6, 30), LocalTime.of(21, 0) },
				{ LocalTime.of(5, 45), LocalTime.of(15, 50) }, { LocalTime.of(2, 15), LocalTime.of(23, 00) } };
		GPSCoordinate gps = new GPSCoordinate(41.6551455,-4.7381979);
		PackageLocker t = new PackageLocker("0000000000", gps, horario, 20, true);
	}
	@Test (expected = IllegalArgumentException.class)
	public void testPackageLockerConOpcionOperativoPrimerDiaUnaHora() {
		LocalTime[][] horario = { { LocalTime.of(14, 0) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(9, 30), LocalTime.of(21, 10) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(6, 30), LocalTime.of(21, 0) },
				{ LocalTime.of(5, 45), LocalTime.of(15, 50) }, { LocalTime.of(2, 15), LocalTime.of(23, 00) } };
		GPSCoordinate gps = new GPSCoordinate(41.6551455,-4.7381979);
		PackageLocker t = new PackageLocker("0000000000", gps, horario, 20, true);
	}
	@Test (expected = IllegalArgumentException.class)
	public void testPackageLockerConOpcionOperativoUltimoDiaTresHoras() {
		LocalTime[][] horario = { { LocalTime.of(8, 0), LocalTime.of(14, 0) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(9, 30), LocalTime.of(21, 10) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(6, 30), LocalTime.of(21, 0) },
				{ LocalTime.of(5, 45), LocalTime.of(15, 50) }, {LocalTime.of(1, 0), LocalTime.of(2, 15), LocalTime.of(23, 00) } };
		GPSCoordinate gps = new GPSCoordinate(41.6551455,-4.7381979);
		PackageLocker t = new PackageLocker("0000000000", gps, horario, 20, true);
	}
	@Test (expected = IllegalArgumentException.class)
	public void testPackageLockerConOpcionOperativoUltimoDiaUnaHora() {
		LocalTime[][] horario = { { LocalTime.of(8, 0), LocalTime.of(14, 0) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(9, 30), LocalTime.of(21, 10) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(6, 30), LocalTime.of(21, 0) },
				{ LocalTime.of(5, 45), LocalTime.of(15, 50) }, { LocalTime.of(2, 15)} };
		GPSCoordinate gps = new GPSCoordinate(41.6551455,-4.7381979);
		PackageLocker t = new PackageLocker("0000000000", gps, horario, 20, true);
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
