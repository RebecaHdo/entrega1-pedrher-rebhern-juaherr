package amazingCo.paquete;

import static org.junit.Assert.*;

import java.time.LocalTime;

import org.junit.Test;
import es.uva.inf.poo.maps.GPSCoordinate;

/*
 * Batería de pruebas de la clase PackageLocker.
 * @author juaherr
 * @author rebhern
 * @author pedrher
 * 
 */
public class PackageLockerTest {
	/*
	 * Prueba válida del generador con opción de operativo. Todos los argumentos introducidos son válidos.
	 * id = 0000000000
	 * ubicacion = (41.6551455, -4.7381979)
	 */
	@Test
	public void testPackageLockerConOpcionOperativo() {
		LocalTime[][] horario = { { LocalTime.of(8, 0), LocalTime.of(14, 0) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(9, 30), LocalTime.of(21, 10) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(6, 30), LocalTime.of(21, 0) },
				{ LocalTime.of(5, 45), LocalTime.of(15, 50) }, { LocalTime.of(2, 15), LocalTime.of(23, 00) } };
		GPSCoordinate gps = new GPSCoordinate(41.6551455, -4.7381979);
		PackageLocker t = new PackageLocker("0000000000", gps, horario, 1, true);
		assertNotNull(t);
		assertEquals(t.getId(), "0000000000");
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 2; j++) {
				assertEquals(t.getHorarioDia(i)[j], horario[i][j]);

			}
		}
		assertEquals(t.getNumeroTaquillas(), 1);
		assertTrue(t.getOperativo());
		assertEquals(t.getUbicacion(), gps);
	}

	@Test
	public void testPackageLockerOperativoDirectamente() {
		LocalTime[][] horario = { { LocalTime.of(8, 0), LocalTime.of(14, 0) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(9, 30), LocalTime.of(21, 10) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(6, 30), LocalTime.of(21, 0) },
				{ LocalTime.of(5, 45), LocalTime.of(15, 50) }, { LocalTime.of(2, 15), LocalTime.of(23, 00) } };
		GPSCoordinate gps = new GPSCoordinate(41.6551455, -4.7381979);
		PackageLocker t = new PackageLocker("0000000000", gps, horario, 1, true);
		assertNotNull(t);
		assertEquals(t.getId(), "0000000000");
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 2; j++) {
				assertEquals(t.getHorarioDia(i)[j], horario[i][j]);

			}
		}
		assertEquals(t.getNumeroTaquillas(), 1);
		assertTrue(t.getOperativo());
		assertEquals(t.getUbicacion(), gps);

	}

	@Test(expected = IllegalArgumentException.class)
	public void testPackageLockerConOpcionOperativoIdNull() {
		LocalTime[][] horario = { { LocalTime.of(8, 0), LocalTime.of(14, 0) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(9, 30), LocalTime.of(21, 10) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(6, 30), LocalTime.of(21, 0) },
				{ LocalTime.of(5, 45), LocalTime.of(15, 50) }, { LocalTime.of(2, 15), LocalTime.of(23, 00) } };
		GPSCoordinate gps = new GPSCoordinate(41.6551455, -4.7381979);
		PackageLocker t = new PackageLocker(null, gps, horario, 1, true);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testPackageLockerConOpcionOperativoGpsNull() {
		LocalTime[][] horario = { { LocalTime.of(8, 0), LocalTime.of(14, 0) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(9, 30), LocalTime.of(21, 10) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(6, 30), LocalTime.of(21, 0) },
				{ LocalTime.of(5, 45), LocalTime.of(15, 50) }, { LocalTime.of(2, 15), LocalTime.of(23, 00) } };
		PackageLocker t = new PackageLocker("0000000000", null, horario, 1, true);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testPackageLockerConOpcionOperativoHorarioNull() {
		GPSCoordinate gps = new GPSCoordinate(41.6551455, -4.7381979);
		PackageLocker t = new PackageLocker("0000000000", gps, null, 1, true);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testPackageLockerConOpcionOperativoHorarioOchoDias() {
		LocalTime[][] horario = { { LocalTime.of(8, 0), LocalTime.of(14, 0) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(9, 30), LocalTime.of(21, 10) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(6, 30), LocalTime.of(21, 0) },
				{ LocalTime.of(5, 45), LocalTime.of(15, 50) }, { LocalTime.of(2, 15), LocalTime.of(23, 00) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) } };
		GPSCoordinate gps = new GPSCoordinate(41.6551455, -4.7381979);
		PackageLocker t = new PackageLocker("0000000000", gps, horario, 1, true);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testPackageLockerConOpcionOperativoSeisDias() {
		LocalTime[][] horario = { { LocalTime.of(8, 0), LocalTime.of(14, 0) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(9, 30), LocalTime.of(21, 10) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(6, 30), LocalTime.of(21, 0) },
				{ LocalTime.of(5, 45), LocalTime.of(15, 50) } };
		GPSCoordinate gps = new GPSCoordinate(41.6551455, -4.7381979);
		PackageLocker t = new PackageLocker("0000000000", gps, horario, 1, true);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testPackageLockerConOpcionOperativoPrimerDiaNull() {
		LocalTime[][] horario = { null, { LocalTime.of(7, 15), LocalTime.of(20, 20) },
				{ LocalTime.of(9, 30), LocalTime.of(21, 10) }, { LocalTime.of(7, 15), LocalTime.of(20, 20) },
				{ LocalTime.of(6, 30), LocalTime.of(21, 0) }, { LocalTime.of(5, 45), LocalTime.of(15, 50) },
				{ LocalTime.of(2, 15), LocalTime.of(23, 00) } };
		GPSCoordinate gps = new GPSCoordinate(41.6551455, -4.7381979);
		PackageLocker t = new PackageLocker("0000000000", gps, horario, 1, true);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testPackageLockerConOpcionOperativoUltimoDiaNull() {
		LocalTime[][] horario = { { LocalTime.of(8, 0), LocalTime.of(14, 0) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(9, 30), LocalTime.of(21, 10) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(6, 30), LocalTime.of(21, 0) },
				{ LocalTime.of(5, 45), LocalTime.of(15, 50) }, null };
		GPSCoordinate gps = new GPSCoordinate(41.6551455, -4.7381979);
		PackageLocker t = new PackageLocker("0000000000", gps, horario, 1, true);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testPackageLockerConOpcionOperativoHoraAperturaPrimerDiaNull() {
		LocalTime[][] horario = { { null, LocalTime.of(14, 0) }, { LocalTime.of(7, 15), LocalTime.of(20, 20) },
				{ LocalTime.of(9, 30), LocalTime.of(21, 10) }, { LocalTime.of(7, 15), LocalTime.of(20, 20) },
				{ LocalTime.of(6, 30), LocalTime.of(21, 0) }, { LocalTime.of(5, 45), LocalTime.of(15, 50) },
				{ LocalTime.of(2, 15), LocalTime.of(23, 00) } };
		GPSCoordinate gps = new GPSCoordinate(41.6551455, -4.7381979);
		PackageLocker t = new PackageLocker("0000000000", gps, horario, 1, true);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testPackageLockerConOpcionOperativoHoraCierrePrimerDiaNull() {
		LocalTime[][] horario = { { LocalTime.of(8, 0), null }, { LocalTime.of(7, 15), LocalTime.of(20, 20) },
				{ LocalTime.of(9, 30), LocalTime.of(21, 10) }, { LocalTime.of(7, 15), LocalTime.of(20, 20) },
				{ LocalTime.of(6, 30), LocalTime.of(21, 0) }, { LocalTime.of(5, 45), LocalTime.of(15, 50) },
				{ LocalTime.of(2, 15), LocalTime.of(23, 00) } };
		GPSCoordinate gps = new GPSCoordinate(41.6551455, -4.7381979);
		PackageLocker t = new PackageLocker("0000000000", gps, horario, 1, true);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testPackageLockerConOpcionOperativoHoraAperturaUltimoDiaNull() {
		LocalTime[][] horario = { { LocalTime.of(8, 0), LocalTime.of(14, 0) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(9, 30), LocalTime.of(21, 10) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(6, 30), LocalTime.of(21, 0) },
				{ LocalTime.of(5, 45), LocalTime.of(15, 50) }, { null, LocalTime.of(23, 00) } };
		GPSCoordinate gps = new GPSCoordinate(41.6551455, -4.7381979);
		PackageLocker t = new PackageLocker("0000000000", gps, horario, 1, true);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testPackageLockerConOpcionOperativoHoraCierreUltimoDiaNull() {
		LocalTime[][] horario = { { LocalTime.of(8, 0), LocalTime.of(14, 0) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(9, 30), LocalTime.of(21, 10) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(6, 30), LocalTime.of(21, 0) },
				{ LocalTime.of(5, 45), LocalTime.of(15, 50) }, { LocalTime.of(2, 15), null } };
		GPSCoordinate gps = new GPSCoordinate(41.6551455, -4.7381979);
		PackageLocker t = new PackageLocker("0000000000", gps, horario, 1, true);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testPackageLockerConOpcionOperativoPrimerDiaTresHoras() {
		LocalTime[][] horario = { { LocalTime.of(3, 30), LocalTime.of(8, 0), LocalTime.of(14, 0) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(9, 30), LocalTime.of(21, 10) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(6, 30), LocalTime.of(21, 0) },
				{ LocalTime.of(5, 45), LocalTime.of(15, 50) }, { LocalTime.of(2, 15), LocalTime.of(23, 00) } };
		GPSCoordinate gps = new GPSCoordinate(41.6551455, -4.7381979);
		PackageLocker t = new PackageLocker("0000000000", gps, horario, 1, true);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testPackageLockerConOpcionOperativoPrimerDiaUnaHora() {
		LocalTime[][] horario = { { LocalTime.of(14, 0) }, { LocalTime.of(7, 15), LocalTime.of(20, 20) },
				{ LocalTime.of(9, 30), LocalTime.of(21, 10) }, { LocalTime.of(7, 15), LocalTime.of(20, 20) },
				{ LocalTime.of(6, 30), LocalTime.of(21, 0) }, { LocalTime.of(5, 45), LocalTime.of(15, 50) },
				{ LocalTime.of(2, 15), LocalTime.of(23, 00) } };
		GPSCoordinate gps = new GPSCoordinate(41.6551455, -4.7381979);
		PackageLocker t = new PackageLocker("0000000000", gps, horario, 1, true);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testPackageLockerConOpcionOperativoUltimoDiaTresHoras() {
		LocalTime[][] horario = { { LocalTime.of(8, 0), LocalTime.of(14, 0) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(9, 30), LocalTime.of(21, 10) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(6, 30), LocalTime.of(21, 0) },
				{ LocalTime.of(5, 45), LocalTime.of(15, 50) },
				{ LocalTime.of(1, 0), LocalTime.of(2, 15), LocalTime.of(23, 00) } };
		GPSCoordinate gps = new GPSCoordinate(41.6551455, -4.7381979);
		PackageLocker t = new PackageLocker("0000000000", gps, horario, 1, true);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testPackageLockerConOpcionOperativoUltimoDiaUnaHora() {
		LocalTime[][] horario = { { LocalTime.of(8, 0), LocalTime.of(14, 0) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(9, 30), LocalTime.of(21, 10) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(6, 30), LocalTime.of(21, 0) },
				{ LocalTime.of(5, 45), LocalTime.of(15, 50) }, { LocalTime.of(2, 15) } };
		GPSCoordinate gps = new GPSCoordinate(41.6551455, -4.7381979);
		PackageLocker t = new PackageLocker("0000000000", gps, horario, 1, true);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testPackageLockerConOpcionOperativoPrimerDiaHorasMalIntroducidas() {
		LocalTime[][] horario = { { LocalTime.of(23, 0), LocalTime.of(14, 0) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(9, 30), LocalTime.of(21, 10) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(6, 30), LocalTime.of(21, 0) },
				{ LocalTime.of(5, 45), LocalTime.of(15, 50) }, { LocalTime.of(2, 15), LocalTime.of(23, 00) } };
		GPSCoordinate gps = new GPSCoordinate(41.6551455, -4.7381979);
		PackageLocker t = new PackageLocker("0000000000", gps, horario, 1, true);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testPackageLockerConOpcionOperativoUltimoDiaHorasMalIntroducidas() {
		LocalTime[][] horario = { { LocalTime.of(8, 0), LocalTime.of(14, 0) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(9, 30), LocalTime.of(21, 10) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(6, 30), LocalTime.of(21, 0) },
				{ LocalTime.of(5, 45), LocalTime.of(15, 50) }, { LocalTime.of(23, 15), LocalTime.of(23, 00) } };
		GPSCoordinate gps = new GPSCoordinate(41.6551455, -4.7381979);
		PackageLocker t = new PackageLocker("0000000000", gps, horario, 1, true);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testPackageLockerConOpcionOperativoTaquillasNegativas() {
		LocalTime[][] horario = { { LocalTime.of(8, 0), LocalTime.of(14, 0) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(9, 30), LocalTime.of(21, 10) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(6, 30), LocalTime.of(21, 0) },
				{ LocalTime.of(5, 45), LocalTime.of(15, 50) }, { LocalTime.of(2, 15), LocalTime.of(23, 00) } };
		GPSCoordinate gps = new GPSCoordinate(41.6551455, -4.7381979);
		PackageLocker t = new PackageLocker("0000000000", gps, horario, -1, true);

	}

	@Test(expected = IllegalArgumentException.class)
	public void testPackageLockerConOpcionOperativoTaquillasCero() {
		LocalTime[][] horario = { { LocalTime.of(8, 0), LocalTime.of(14, 0) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(9, 30), LocalTime.of(21, 10) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(6, 30), LocalTime.of(21, 0) },
				{ LocalTime.of(5, 45), LocalTime.of(15, 50) }, { LocalTime.of(2, 15), LocalTime.of(23, 00) } };
		GPSCoordinate gps = new GPSCoordinate(41.6551455, -4.7381979);
		PackageLocker t = new PackageLocker("0000000000", gps, horario, 0, true);

	}

//TODO aqui
	@Test(expected = IllegalArgumentException.class)
	public void testPackageLockerOperativoDirectamenteIdNull() {
		LocalTime[][] horario = { { LocalTime.of(8, 0), LocalTime.of(14, 0) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(9, 30), LocalTime.of(21, 10) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(6, 30), LocalTime.of(21, 0) },
				{ LocalTime.of(5, 45), LocalTime.of(15, 50) }, { LocalTime.of(2, 15), LocalTime.of(23, 00) } };
		GPSCoordinate gps = new GPSCoordinate(41.6551455, -4.7381979);
		PackageLocker t = new PackageLocker(null, gps, horario, 1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testPackageLockerOperativoDirectamenteGpsNull() {
		LocalTime[][] horario = { { LocalTime.of(8, 0), LocalTime.of(14, 0) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(9, 30), LocalTime.of(21, 10) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(6, 30), LocalTime.of(21, 0) },
				{ LocalTime.of(5, 45), LocalTime.of(15, 50) }, { LocalTime.of(2, 15), LocalTime.of(23, 00) } };
		PackageLocker t = new PackageLocker("0000000000", null, horario, 1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testPackageLockerOperativoDirectamenteHorarioNull() {
		GPSCoordinate gps = new GPSCoordinate(41.6551455, -4.7381979);
		PackageLocker t = new PackageLocker("0000000000", gps, null, 1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testPackageLockerOperativoDirectamenteHorarioOchoDias() {
		LocalTime[][] horario = { { LocalTime.of(8, 0), LocalTime.of(14, 0) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(9, 30), LocalTime.of(21, 10) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(6, 30), LocalTime.of(21, 0) },
				{ LocalTime.of(5, 45), LocalTime.of(15, 50) }, { LocalTime.of(2, 15), LocalTime.of(23, 00) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) } };
		GPSCoordinate gps = new GPSCoordinate(41.6551455, -4.7381979);
		PackageLocker t = new PackageLocker("0000000000", gps, horario, 1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testPackageLockerOperativoDirectamenteSeisDias() {
		LocalTime[][] horario = { { LocalTime.of(8, 0), LocalTime.of(14, 0) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(9, 30), LocalTime.of(21, 10) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(6, 30), LocalTime.of(21, 0) },
				{ LocalTime.of(5, 45), LocalTime.of(15, 50) } };
		GPSCoordinate gps = new GPSCoordinate(41.6551455, -4.7381979);
		PackageLocker t = new PackageLocker("0000000000", gps, horario, 1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testPackageLockerOperativoDirectamentePrimerDiaNull() {
		LocalTime[][] horario = { null, { LocalTime.of(7, 15), LocalTime.of(20, 20) },
				{ LocalTime.of(9, 30), LocalTime.of(21, 10) }, { LocalTime.of(7, 15), LocalTime.of(20, 20) },
				{ LocalTime.of(6, 30), LocalTime.of(21, 0) }, { LocalTime.of(5, 45), LocalTime.of(15, 50) },
				{ LocalTime.of(2, 15), LocalTime.of(23, 00) } };
		GPSCoordinate gps = new GPSCoordinate(41.6551455, -4.7381979);
		PackageLocker t = new PackageLocker("0000000000", gps, horario, 1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testPackageLockerOperativoDirectamenteUltimoDiaNull() {
		LocalTime[][] horario = { { LocalTime.of(8, 0), LocalTime.of(14, 0) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(9, 30), LocalTime.of(21, 10) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(6, 30), LocalTime.of(21, 0) },
				{ LocalTime.of(5, 45), LocalTime.of(15, 50) }, null };
		GPSCoordinate gps = new GPSCoordinate(41.6551455, -4.7381979);
		PackageLocker t = new PackageLocker("0000000000", gps, horario, 1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testPackageLockerOperativoDirectamenteHoraAperturaPrimerDiaNull() {
		LocalTime[][] horario = { { null, LocalTime.of(14, 0) }, { LocalTime.of(7, 15), LocalTime.of(20, 20) },
				{ LocalTime.of(9, 30), LocalTime.of(21, 10) }, { LocalTime.of(7, 15), LocalTime.of(20, 20) },
				{ LocalTime.of(6, 30), LocalTime.of(21, 0) }, { LocalTime.of(5, 45), LocalTime.of(15, 50) },
				{ LocalTime.of(2, 15), LocalTime.of(23, 00) } };
		GPSCoordinate gps = new GPSCoordinate(41.6551455, -4.7381979);
		PackageLocker t = new PackageLocker("0000000000", gps, horario, 1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testPackageLockerOperativoDirectamenteHoraCierrePrimerDiaNull() {
		LocalTime[][] horario = { { LocalTime.of(8, 0), null }, { LocalTime.of(7, 15), LocalTime.of(20, 20) },
				{ LocalTime.of(9, 30), LocalTime.of(21, 10) }, { LocalTime.of(7, 15), LocalTime.of(20, 20) },
				{ LocalTime.of(6, 30), LocalTime.of(21, 0) }, { LocalTime.of(5, 45), LocalTime.of(15, 50) },
				{ LocalTime.of(2, 15), LocalTime.of(23, 00) } };
		GPSCoordinate gps = new GPSCoordinate(41.6551455, -4.7381979);
		PackageLocker t = new PackageLocker("0000000000", gps, horario, 1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testPackageLockerOperativoDirectamenteHoraAperturaUltimoDiaNull() {
		LocalTime[][] horario = { { LocalTime.of(8, 0), LocalTime.of(14, 0) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(9, 30), LocalTime.of(21, 10) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(6, 30), LocalTime.of(21, 0) },
				{ LocalTime.of(5, 45), LocalTime.of(15, 50) }, { null, LocalTime.of(23, 00) } };
		GPSCoordinate gps = new GPSCoordinate(41.6551455, -4.7381979);
		PackageLocker t = new PackageLocker("0000000000", gps, horario, 1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testPackageLockerOperativoDirectamenteHoraCierreUltimoDiaNull() {
		LocalTime[][] horario = { { LocalTime.of(8, 0), LocalTime.of(14, 0) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(9, 30), LocalTime.of(21, 10) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(6, 30), LocalTime.of(21, 0) },
				{ LocalTime.of(5, 45), LocalTime.of(15, 50) }, { LocalTime.of(2, 15), null } };
		GPSCoordinate gps = new GPSCoordinate(41.6551455, -4.7381979);
		PackageLocker t = new PackageLocker("0000000000", gps, horario, 1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testPackageLockerOperativoDirectamentePrimerDiaTresHoras() {
		LocalTime[][] horario = { { LocalTime.of(3, 30), LocalTime.of(8, 0), LocalTime.of(14, 0) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(9, 30), LocalTime.of(21, 10) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(6, 30), LocalTime.of(21, 0) },
				{ LocalTime.of(5, 45), LocalTime.of(15, 50) }, { LocalTime.of(2, 15), LocalTime.of(23, 00) } };
		GPSCoordinate gps = new GPSCoordinate(41.6551455, -4.7381979);
		PackageLocker t = new PackageLocker("0000000000", gps, horario, 1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testPackageLockerOperativoDirectamentePrimerDiaUnaHora() {
		LocalTime[][] horario = { { LocalTime.of(14, 0) }, { LocalTime.of(7, 15), LocalTime.of(20, 20) },
				{ LocalTime.of(9, 30), LocalTime.of(21, 10) }, { LocalTime.of(7, 15), LocalTime.of(20, 20) },
				{ LocalTime.of(6, 30), LocalTime.of(21, 0) }, { LocalTime.of(5, 45), LocalTime.of(15, 50) },
				{ LocalTime.of(2, 15), LocalTime.of(23, 00) } };
		GPSCoordinate gps = new GPSCoordinate(41.6551455, -4.7381979);
		PackageLocker t = new PackageLocker("0000000000", gps, horario, 1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testPackageLockerOperativoDirectamenteUltimoDiaTresHoras() {
		LocalTime[][] horario = { { LocalTime.of(8, 0), LocalTime.of(14, 0) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(9, 30), LocalTime.of(21, 10) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(6, 30), LocalTime.of(21, 0) },
				{ LocalTime.of(5, 45), LocalTime.of(15, 50) },
				{ LocalTime.of(1, 0), LocalTime.of(2, 15), LocalTime.of(23, 00) } };
		GPSCoordinate gps = new GPSCoordinate(41.6551455, -4.7381979);
		PackageLocker t = new PackageLocker("0000000000", gps, horario, 1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testPackageLockerOperativoDirectamenteUltimoDiaUnaHora() {
		LocalTime[][] horario = { { LocalTime.of(8, 0), LocalTime.of(14, 0) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(9, 30), LocalTime.of(21, 10) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(6, 30), LocalTime.of(21, 0) },
				{ LocalTime.of(5, 45), LocalTime.of(15, 50) }, { LocalTime.of(2, 15) } };
		GPSCoordinate gps = new GPSCoordinate(41.6551455, -4.7381979);
		PackageLocker t = new PackageLocker("0000000000", gps, horario, 1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testPackageLockerOperativoDirectamentePrimerDiaHorasMalIntroducidas() {
		LocalTime[][] horario = { { LocalTime.of(23, 0), LocalTime.of(14, 0) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(9, 30), LocalTime.of(21, 10) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(6, 30), LocalTime.of(21, 0) },
				{ LocalTime.of(5, 45), LocalTime.of(15, 50) }, { LocalTime.of(2, 15), LocalTime.of(23, 00) } };
		GPSCoordinate gps = new GPSCoordinate(41.6551455, -4.7381979);
		PackageLocker t = new PackageLocker("0000000000", gps, horario, 1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testPackageLockerOperativoDirectamenteUltimoDiaHorasMalIntroducidas() {
		LocalTime[][] horario = { { LocalTime.of(8, 0), LocalTime.of(14, 0) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(9, 30), LocalTime.of(21, 10) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(6, 30), LocalTime.of(21, 0) },
				{ LocalTime.of(5, 45), LocalTime.of(15, 50) }, { LocalTime.of(23, 15), LocalTime.of(23, 00) } };
		GPSCoordinate gps = new GPSCoordinate(41.6551455, -4.7381979);
		PackageLocker t = new PackageLocker("0000000000", gps, horario, 1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testPackageLockerOperativoDirectamenteTaquillasNegativas() {
		LocalTime[][] horario = { { LocalTime.of(8, 0), LocalTime.of(14, 0) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(9, 30), LocalTime.of(21, 10) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(6, 30), LocalTime.of(21, 0) },
				{ LocalTime.of(5, 45), LocalTime.of(15, 50) }, { LocalTime.of(2, 15), LocalTime.of(23, 00) } };
		GPSCoordinate gps = new GPSCoordinate(41.6551455, -4.7381979);
		PackageLocker t = new PackageLocker("0000000000", gps, horario, -1, true);

	}

	@Test(expected = IllegalArgumentException.class)
	public void testPackageLockerOperativoDirectamenteTaquillasCero() {
		LocalTime[][] horario = { { LocalTime.of(8, 0), LocalTime.of(14, 0) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(9, 30), LocalTime.of(21, 10) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(6, 30), LocalTime.of(21, 0) },
				{ LocalTime.of(5, 45), LocalTime.of(15, 50) }, { LocalTime.of(2, 15), LocalTime.of(23, 00) } };
		GPSCoordinate gps = new GPSCoordinate(41.6551455, -4.7381979);
		PackageLocker t = new PackageLocker("0000000000", gps, horario, 0, true);

	}

	@Test
	public void testOperatividadDeOperativoAFueraDeServicio() {
		LocalTime[][] horario = { { LocalTime.of(8, 0), LocalTime.of(14, 0) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(9, 30), LocalTime.of(21, 10) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(6, 30), LocalTime.of(21, 0) },
				{ LocalTime.of(5, 45), LocalTime.of(15, 50) }, { LocalTime.of(2, 15), LocalTime.of(23, 00) } };
		GPSCoordinate gps = new GPSCoordinate(41.6551455, -4.7381979);
		PackageLocker t = new PackageLocker("0000000000", gps, horario, 1, true);
		t.operatividad();
		assertFalse(t.getOperativo());
	}

	@Test
	public void testOperatividadDeFueraDeServicioAOperativo() {
		LocalTime[][] horario = { { LocalTime.of(8, 0), LocalTime.of(14, 0) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(9, 30), LocalTime.of(21, 10) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(6, 30), LocalTime.of(21, 0) },
				{ LocalTime.of(5, 45), LocalTime.of(15, 50) }, { LocalTime.of(2, 15), LocalTime.of(23, 00) } };
		GPSCoordinate gps = new GPSCoordinate(41.6551455, -4.7381979);
		PackageLocker t = new PackageLocker("0000000000", gps, horario, 1, false);
		t.operatividad();
		assertTrue(t.getOperativo());
	}

	@Test
	public void testGetNumeroTaquillas() {
		LocalTime[][] horario = { { LocalTime.of(8, 0), LocalTime.of(14, 0) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(9, 30), LocalTime.of(21, 10) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(6, 30), LocalTime.of(21, 0) },
				{ LocalTime.of(5, 45), LocalTime.of(15, 50) }, { LocalTime.of(2, 15), LocalTime.of(23, 00) } };
		GPSCoordinate gps = new GPSCoordinate(41.6551455, -4.7381979);
		PackageLocker t = new PackageLocker("0000000000", gps, horario, 1);
		assertEquals(t.getNumeroTaquillas(), 1);
	}

	@Test
	public void testGetNumeroTaquillasLlenasTaquilleroVacio() {
		LocalTime[][] horario = { { LocalTime.of(8, 0), LocalTime.of(14, 0) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(9, 30), LocalTime.of(21, 10) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(6, 30), LocalTime.of(21, 0) },
				{ LocalTime.of(5, 45), LocalTime.of(15, 50) }, { LocalTime.of(2, 15), LocalTime.of(23, 00) } };
		GPSCoordinate gps = new GPSCoordinate(41.6551455, -4.7381979);
		PackageLocker t = new PackageLocker("0000000000", gps, horario, 1);
		assertEquals(t.getNumeroTaquillasLlenas(), 0);
	}

	@Test
	public void testGetNumeroTaquillasLlenasTaquilleroDeUno() {
		LocalTime[][] horario = { { LocalTime.of(8, 0), LocalTime.of(14, 0) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(9, 30), LocalTime.of(21, 10) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(6, 30), LocalTime.of(21, 0) },
				{ LocalTime.of(5, 45), LocalTime.of(15, 50) }, { LocalTime.of(2, 15), LocalTime.of(23, 00) } };
		GPSCoordinate gps = new GPSCoordinate(41.6551455, -4.7381979);
		Package p = new Package("0000000000");
		PackageLocker t = new PackageLocker("0000000000", gps, horario, 1);
		t.asignaPaquete(p);
		assertEquals(t.getNumeroTaquillasLlenas(), 1);
	}

	@Test
	public void testGetNumeroTaquillasLlenasTaquilleroLleno() {
		LocalTime[][] horario = { { LocalTime.of(8, 0), LocalTime.of(14, 0) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(9, 30), LocalTime.of(21, 10) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(6, 30), LocalTime.of(21, 0) },
				{ LocalTime.of(5, 45), LocalTime.of(15, 50) }, { LocalTime.of(2, 15), LocalTime.of(23, 00) } };
		GPSCoordinate gps = new GPSCoordinate(41.6551455, -4.7381979);
		Package p = new Package("0000000000");
		Package p2 = new Package("0000000011");

		PackageLocker t = new PackageLocker("0000000000", gps, horario, 2);
		t.asignaPaquete(p);
		t.asignaPaquete(p2);
		assertEquals(t.getNumeroTaquillasLlenas(), 2);
	}

	@Test
	public void testGetNumeroTaquillasVaciasTaquilleroVacio() {
		LocalTime[][] horario = { { LocalTime.of(8, 0), LocalTime.of(14, 0) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(9, 30), LocalTime.of(21, 10) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(6, 30), LocalTime.of(21, 0) },
				{ LocalTime.of(5, 45), LocalTime.of(15, 50) }, { LocalTime.of(2, 15), LocalTime.of(23, 00) } };
		GPSCoordinate gps = new GPSCoordinate(41.6551455, -4.7381979);
		PackageLocker t = new PackageLocker("0000000000", gps, horario, 1);
		assertEquals(t.getNumeroTaquillasVacias(), 1);
	}

	@Test
	public void testGetNumeroTaquillasVaciasTaquilleroUno() {
		LocalTime[][] horario = { { LocalTime.of(8, 0), LocalTime.of(14, 0) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(9, 30), LocalTime.of(21, 10) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(6, 30), LocalTime.of(21, 0) },
				{ LocalTime.of(5, 45), LocalTime.of(15, 50) }, { LocalTime.of(2, 15), LocalTime.of(23, 00) } };
		GPSCoordinate gps = new GPSCoordinate(41.6551455, -4.7381979);
		Package p = new Package("0000000000");
		PackageLocker t = new PackageLocker("0000000000", gps, horario, 1);
		t.asignaPaquete(p);
		assertEquals(t.getNumeroTaquillasVacias(), 0);
	}

	@Test
	public void testGetNumeroTaquillasVaciasTaquilleroLleno() {
		LocalTime[][] horario = { { LocalTime.of(8, 0), LocalTime.of(14, 0) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(9, 30), LocalTime.of(21, 10) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(6, 30), LocalTime.of(21, 0) },
				{ LocalTime.of(5, 45), LocalTime.of(15, 50) }, { LocalTime.of(2, 15), LocalTime.of(23, 00) } };
		GPSCoordinate gps = new GPSCoordinate(41.6551455, -4.7381979);
		Package p = new Package("0000000000");
		Package p2 = new Package("0000000011");

		PackageLocker t = new PackageLocker("0000000000", gps, horario, 2);
		t.asignaPaquete(p);
		t.asignaPaquete(p2);
		assertEquals(t.getNumeroTaquillasLlenas(), 2);
	}

	@Test
	public void testGetUbicacion() {
		LocalTime[][] horario = { { LocalTime.of(8, 0), LocalTime.of(14, 0) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(9, 30), LocalTime.of(21, 10) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(6, 30), LocalTime.of(21, 0) },
				{ LocalTime.of(5, 45), LocalTime.of(15, 50) }, { LocalTime.of(2, 15), LocalTime.of(23, 00) } };
		GPSCoordinate gps = new GPSCoordinate(41.6551455, -4.7381979);
		PackageLocker t = new PackageLocker("0000000000", gps, horario, 1);
		assertEquals(t.getUbicacion(), gps);
	}

	@Test
	public void testLocaclizaPaquetePrimeraPosicion() {
		LocalTime[][] horario = { { LocalTime.of(8, 0), LocalTime.of(14, 0) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(9, 30), LocalTime.of(21, 10) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(6, 30), LocalTime.of(21, 0) },
				{ LocalTime.of(5, 45), LocalTime.of(15, 50) }, { LocalTime.of(2, 15), LocalTime.of(23, 00) } };
		GPSCoordinate gps = new GPSCoordinate(41.6551455, -4.7381979);
		Package p = new Package("0000000000");
		PackageLocker t = new PackageLocker("0000000000", gps, horario, 1);
		t.asignaPaquete(p);
		assertEquals(t.locaclizaPaquete("0000000000"), 0);
	}

	@Test
	public void testLocaclizaPaqueteUltimaPosicion() {
		LocalTime[][] horario = { { LocalTime.of(8, 0), LocalTime.of(14, 0) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(9, 30), LocalTime.of(21, 10) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(6, 30), LocalTime.of(21, 0) },
				{ LocalTime.of(5, 45), LocalTime.of(15, 50) }, { LocalTime.of(2, 15), LocalTime.of(23, 00) } };
		GPSCoordinate gps = new GPSCoordinate(41.6551455, -4.7381979);
		Package p = new Package("0000000000");
		Package p2 = new Package("0000000011");

		PackageLocker t = new PackageLocker("0000000000", gps, horario, 2);
		t.asignaPaquete(p);
		t.asignaPaquete(p2);
		assertEquals(t.locaclizaPaquete("0000000011"), 1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testLocaclizaPaqueteIdNull() {
		LocalTime[][] horario = { { LocalTime.of(8, 0), LocalTime.of(14, 0) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(9, 30), LocalTime.of(21, 10) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(6, 30), LocalTime.of(21, 0) },
				{ LocalTime.of(5, 45), LocalTime.of(15, 50) }, { LocalTime.of(2, 15), LocalTime.of(23, 00) } };
		GPSCoordinate gps = new GPSCoordinate(41.6551455, -4.7381979);
		Package p = new Package("0000000000");
		PackageLocker t = new PackageLocker("0000000000", gps, horario, 1);
		t.asignaPaquete(p);
		t.locaclizaPaquete(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testLocaclizaPaqueteIdNoEnLasTaquillas() {
		LocalTime[][] horario = { { LocalTime.of(8, 0), LocalTime.of(14, 0) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(9, 30), LocalTime.of(21, 10) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(6, 30), LocalTime.of(21, 0) },
				{ LocalTime.of(5, 45), LocalTime.of(15, 50) }, { LocalTime.of(2, 15), LocalTime.of(23, 00) } };
		GPSCoordinate gps = new GPSCoordinate(41.6551455, -4.7381979);
		Package p = new Package("0000000000");
		PackageLocker t = new PackageLocker("0000000000", gps, horario, 1);
		t.asignaPaquete(p);
		t.locaclizaPaquete("0000000001");
	}

	@Test
	public void testAsignaPaquete() {
		LocalTime[][] horario = { { LocalTime.of(8, 0), LocalTime.of(14, 0) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(9, 30), LocalTime.of(21, 10) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(6, 30), LocalTime.of(21, 0) },
				{ LocalTime.of(5, 45), LocalTime.of(15, 50) }, { LocalTime.of(2, 15), LocalTime.of(23, 00) } };
		GPSCoordinate gps = new GPSCoordinate(41.6551455, -4.7381979);
		Package p = new Package("0000000000");
		PackageLocker t = new PackageLocker("0000000000", gps, horario, 1);
		t.asignaPaquete(p);
		assertEquals(t.locaclizaPaquete("0000000000"), 0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAsignaPaqueteNull() {
		LocalTime[][] horario = { { LocalTime.of(8, 0), LocalTime.of(14, 0) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(9, 30), LocalTime.of(21, 10) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(6, 30), LocalTime.of(21, 0) },
				{ LocalTime.of(5, 45), LocalTime.of(15, 50) }, { LocalTime.of(2, 15), LocalTime.of(23, 00) } };
		GPSCoordinate gps = new GPSCoordinate(41.6551455, -4.7381979);
		PackageLocker t = new PackageLocker("0000000000", gps, horario, 1);
		t.asignaPaquete(null);
	}

	@Test(expected = IllegalStateException.class)
	public void testAsignaPaqueteTaquilleroLleno() {
		LocalTime[][] horario = { { LocalTime.of(8, 0), LocalTime.of(14, 0) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(9, 30), LocalTime.of(21, 10) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(6, 30), LocalTime.of(21, 0) },
				{ LocalTime.of(5, 45), LocalTime.of(15, 50) }, { LocalTime.of(2, 15), LocalTime.of(23, 00) } };
		GPSCoordinate gps = new GPSCoordinate(41.6551455, -4.7381979);
		Package p = new Package("0000000000");
		Package p2 = new Package("0000000011");

		PackageLocker t = new PackageLocker("0000000000", gps, horario, 1);
		t.asignaPaquete(p);
		t.asignaPaquete(p2);
	}

	@Test(expected = IllegalStateException.class)
	public void testAsignaPaqueteIdRepetida() {
		LocalTime[][] horario = { { LocalTime.of(8, 0), LocalTime.of(14, 0) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(9, 30), LocalTime.of(21, 10) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(6, 30), LocalTime.of(21, 0) },
				{ LocalTime.of(5, 45), LocalTime.of(15, 50) }, { LocalTime.of(2, 15), LocalTime.of(23, 00) } };
		GPSCoordinate gps = new GPSCoordinate(41.6551455, -4.7381979);
		Package p = new Package("0000000000");
		Package p2 = new Package("0000000000");

		PackageLocker t = new PackageLocker("0000000000", gps, horario, 2);
		t.asignaPaquete(p);
		t.asignaPaquete(p2);
	}

	@Test
	public void testSacaPaquete() {
		LocalTime[][] horario = { { LocalTime.of(8, 0), LocalTime.of(14, 0) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(9, 30), LocalTime.of(21, 10) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(6, 30), LocalTime.of(21, 0) },
				{ LocalTime.of(5, 45), LocalTime.of(15, 50) }, { LocalTime.of(2, 15), LocalTime.of(23, 00) } };
		GPSCoordinate gps = new GPSCoordinate(41.6551455, -4.7381979);
		Package p = new Package("0000000000");
		PackageLocker t = new PackageLocker("0000000000", gps, horario, 1);
		t.asignaPaquete(p);
		assertEquals(t.sacaPaquete(0).getId(), "0000000000");

	}

	@Test
	public void testSacaPaqueteVarios() {
		LocalTime[][] horario = { { LocalTime.of(8, 0), LocalTime.of(14, 0) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(9, 30), LocalTime.of(21, 10) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(6, 30), LocalTime.of(21, 0) },
				{ LocalTime.of(5, 45), LocalTime.of(15, 50) }, { LocalTime.of(2, 15), LocalTime.of(23, 00) } };
		GPSCoordinate gps = new GPSCoordinate(41.6551455, -4.7381979);
		Package p = new Package("0000000000");
		Package p2 = new Package("0000000011");
		PackageLocker t = new PackageLocker("0000000000", gps, horario, 2);
		t.asignaPaquete(p);
		t.asignaPaquete(p2);
		assertEquals(t.sacaPaquete(1).getId(), "0000000011");

	}

	@Test(expected = IllegalArgumentException.class)
	public void testSacaPaqueteMenorCero() {
		LocalTime[][] horario = { { LocalTime.of(8, 0), LocalTime.of(14, 0) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(9, 30), LocalTime.of(21, 10) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(6, 30), LocalTime.of(21, 0) },
				{ LocalTime.of(5, 45), LocalTime.of(15, 50) }, { LocalTime.of(2, 15), LocalTime.of(23, 00) } };
		GPSCoordinate gps = new GPSCoordinate(41.6551455, -4.7381979);
		Package p = new Package("0000000000");
		PackageLocker t = new PackageLocker("0000000000", gps, horario, 1);
		t.asignaPaquete(p);
		t.sacaPaquete(-1);

	}

	@Test(expected = IllegalArgumentException.class)
	public void testSacaPaqueteMayorNumeroTaquillas() {
		LocalTime[][] horario = { { LocalTime.of(8, 0), LocalTime.of(14, 0) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(9, 30), LocalTime.of(21, 10) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(6, 30), LocalTime.of(21, 0) },
				{ LocalTime.of(5, 45), LocalTime.of(15, 50) }, { LocalTime.of(2, 15), LocalTime.of(23, 00) } };
		GPSCoordinate gps = new GPSCoordinate(41.6551455, -4.7381979);
		Package p = new Package("0000000000");
		PackageLocker t = new PackageLocker("0000000000", gps, horario, 1);
		t.asignaPaquete(p);
		t.sacaPaquete(1);

	}

	@Test(expected = IllegalStateException.class)
	public void testSacaPaqueteTaquillaVacia() {
		LocalTime[][] horario = { { LocalTime.of(8, 0), LocalTime.of(14, 0) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(9, 30), LocalTime.of(21, 10) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(6, 30), LocalTime.of(21, 0) },
				{ LocalTime.of(5, 45), LocalTime.of(15, 50) }, { LocalTime.of(2, 15), LocalTime.of(23, 00) } };
		GPSCoordinate gps = new GPSCoordinate(41.6551455, -4.7381979);
		PackageLocker t = new PackageLocker("0000000000", gps, horario, 1);
		t.sacaPaquete(0);

	}
	// TODO revisar fechaaaaaaas

	@Test
	public void testDevuelvePaquete() {
		LocalTime[][] horario = { { LocalTime.of(8, 0), LocalTime.of(14, 0) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(9, 30), LocalTime.of(21, 10) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(6, 30), LocalTime.of(21, 0) },
				{ LocalTime.of(5, 45), LocalTime.of(15, 50) }, { LocalTime.of(2, 15), LocalTime.of(23, 00) } };
		GPSCoordinate gps = new GPSCoordinate(41.6551455, -4.7381979);
		Package p = new Package("0000000000");
		PackageLocker t = new PackageLocker("0000000000", gps, horario, 1);
		t.asignaPaquete(p);
		assertEquals(t.devuelvePaquete(0).getId(), "0000000000");

	}

	@Test
	public void testDevuelvePaqueteVarios() {
		LocalTime[][] horario = { { LocalTime.of(8, 0), LocalTime.of(14, 0) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(9, 30), LocalTime.of(21, 10) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(6, 30), LocalTime.of(21, 0) },
				{ LocalTime.of(5, 45), LocalTime.of(15, 50) }, { LocalTime.of(2, 15), LocalTime.of(23, 00) } };
		GPSCoordinate gps = new GPSCoordinate(41.6551455, -4.7381979);
		Package p = new Package("0000000000");
		Package p2 = new Package("0000000011");
		PackageLocker t = new PackageLocker("0000000000", gps, horario, 2);
		t.asignaPaquete(p);
		t.asignaPaquete(p2);
		assertEquals(t.devuelvePaquete(1).getId(), "0000000011");

	}

	@Test(expected = IllegalArgumentException.class)
	public void testDevuelvePaqueteMenorCero() {
		LocalTime[][] horario = { { LocalTime.of(8, 0), LocalTime.of(14, 0) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(9, 30), LocalTime.of(21, 10) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(6, 30), LocalTime.of(21, 0) },
				{ LocalTime.of(5, 45), LocalTime.of(15, 50) }, { LocalTime.of(2, 15), LocalTime.of(23, 00) } };
		GPSCoordinate gps = new GPSCoordinate(41.6551455, -4.7381979);
		Package p = new Package("0000000000");
		PackageLocker t = new PackageLocker("0000000000", gps, horario, 1);
		t.asignaPaquete(p);
		t.devuelvePaquete(-1);

	}

	@Test(expected = IllegalArgumentException.class)
	public void testDevuelvePaqueteMayorNumeroTaquillas() {
		LocalTime[][] horario = { { LocalTime.of(8, 0), LocalTime.of(14, 0) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(9, 30), LocalTime.of(21, 10) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(6, 30), LocalTime.of(21, 0) },
				{ LocalTime.of(5, 45), LocalTime.of(15, 50) }, { LocalTime.of(2, 15), LocalTime.of(23, 00) } };
		GPSCoordinate gps = new GPSCoordinate(41.6551455, -4.7381979);
		Package p = new Package("0000000000");
		PackageLocker t = new PackageLocker("0000000000", gps, horario, 1);
		t.asignaPaquete(p);
		t.devuelvePaquete(1);

	}

	@Test(expected = IllegalStateException.class)
	public void testDevuelvePaqueteTaquillaVacia() {
		LocalTime[][] horario = { { LocalTime.of(8, 0), LocalTime.of(14, 0) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(9, 30), LocalTime.of(21, 10) },
				{ LocalTime.of(7, 15), LocalTime.of(20, 20) }, { LocalTime.of(6, 30), LocalTime.of(21, 0) },
				{ LocalTime.of(5, 45), LocalTime.of(15, 50) }, { LocalTime.of(2, 15), LocalTime.of(23, 00) } };
		GPSCoordinate gps = new GPSCoordinate(41.6551455, -4.7381979);
		PackageLocker t = new PackageLocker("0000000000", gps, horario, 1);
		t.devuelvePaquete(0);

	}

}