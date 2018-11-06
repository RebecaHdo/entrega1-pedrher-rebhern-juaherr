package amazingCo.paquete;

import java.time.LocalTime;
import java.util.ArrayList;
import es.uva.inf.poo.maps.GPSCoordinate;

/**
 * 
 * @author juaherr
 * @author rebhern
 * @author pedrher
 * 
 *  Administra los taquilleros, pudiendo añiadir o
 *   eliminarlos, ver los operativos y fuera de servicio,
 *   encontrar los que hay en un radio dado y ver cuales
 *   tienen taquillas vacias.
 */
public class PickingPointsSystem {
	
	/**
	 * 
	 * Crear y guarda el taquillero con la id, ubicación, horario semanal, número de
	 * taquillas y operatividad dados.
	 * 
	 * @param id              id de la taquilla.
	 * @param ubicacion       ubicación de la taquilla.
	 * @param horario         tabla en la que se representa el día de la semana y la
	 *                        hora de apertura y cierre de cada día. Esquema:
	 *                        [[LocalTime (apertura),Localtime
	 *                        (cierre)],...,[LocalTime,Localtime]]
	 * @param numeroTaquillas número de taquillas que tiene el taquillero.
	 * @param operativo       indica si el taquillero está operativo desde el
	 *                        momento creado o no.
	 */
	public void crearPackageLocker(String id, GPSCoordinate ubicacion, LocalTime[][] horario, int numeroTaquillas,
			boolean operativo) {
		
	}
	/**
	 * 
	 * Crear y guarda el taquillero operativo con la id, ubicación, horario semanal y
	 * número de taquillas.
	 * 
	 * @param id              id de la taquilla.
	 * @param ubicacion       ubicación de la taquilla.
	 * @param horario         tabla en la que se representa el día de la semana y la
	 *                        hora de apertura y cierre de cada día. Esquema:
	 *                        [[LocalTime (apertura),Localtime
	 *                        (cierre)],...,[LocalTime,Localtime]]
	 * @param numeroTaquillas número de taquillas que tiene el taquillero.
	 */
	public void crearPackageLocker(String id, GPSCoordinate ubicacion, LocalTime[][] horario, int numeroTaquillas) {
		//TODO ids unicas
	}
	/**
	 * Elimina un PackageLocker por id.
	 * @param id del PackageLocker a borrar.
	 */
	public void eliminarPackageLocker(String id) {
		
	}
	/**
	 * Devuelve un array de PackageLockers operativos.
	 * @return array de PackageLockers operativos.
	 */
	public PackageLocker[] PackageLockerOperativos() {
		
	}
	/**
	 * Devuelve un array de PackageLockers fuera de servicio.
	 * @return array de PackageLockers fuera de servicio.
	 */
	public PackageLocker[] PackageLockerFueraDeServicio() {
		
	}
	/**
	 * Devuelve un array de PackagerLockers ordenados por orden de cercania que 
	 * estén dentro del randio dado a la ubicación dada.
	 * @param ubicacion zona desde la que se genera el radio. 
	 * @param radio distancia desde la ubicación que se quiere abarcar.
	 * @return
	 */
	public PackageLocker[] PackageLockerEnZona(GPSCoordinate ubicacion, double radio) {
			
	}
	/**
	 * Devuelve un array de PackageLockers con taquillas vacias.
	 * @return array de PackageLockers con taquillas vacias.
	 */
	public PackageLocker[] PackageLockerConTaquillasVacias() {
		
	}
	
}
