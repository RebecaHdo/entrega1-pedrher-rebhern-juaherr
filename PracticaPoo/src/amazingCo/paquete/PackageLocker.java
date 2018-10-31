package amazingCo.paquete;

import GPSCoordinate;
/**
 * 
 * @author juaherr
 * @author rebhern
 * @author pedrher
 * 
 *  Permite la creación de taquilleros con su id, horario, ubicación y número de taquillas, también 
 *  controlar a los paquetes que tiene dicho taquillero.
 */
public class PackageLocker {
	
	public PackageLocker(String id,GPSCoordinate ubicacion, ) {
		
	}
	/**
	 * Devuelve el número de taquillas que tiene el taquillero.
	 * @return número de taquillas.
	 */
	public int numeroTaquillas() {
		
	}
	/**
	 * Devuelve el número de taquillas vacias que tiene el taquillero.
	 * @return número de taquillas vacias.
	 */
	public int numeroTaquillasVacias() {
		
	}
	/**
	 * Devuelve el número de taquillas llenas que tiene el taquillero.
	 * @return número de taquillas llenas.
	 */
	public int numeroTaquillasLlenas() {
		
	}
	/**
	 * Devuelve la ubicación geográfica del taquillero.
	 * @return la ubicación geográfica.
	 */
	public GPSCoordinate ubicacion() {
		
	}
	/**
	 * 
	 * @param idPaquete
	 * @return
	 */
	public int locaclizaPaquete(int idPaquete) {
		
	}
	/**
	 * Asigna el paquete dado a una taquilla.
	 * @param p el paquete a guardar.
	 */
	public void asignaPaquete(Package p) {
		
	}
	/**
	 * Saca el paquete de la taquilla dada.
	 * @param idTaquilla Número de la taquilla de la que sacar el paquete.
	 */
	public void sacaPaquete(int idTaquilla) {
		
	}
	/**
	 * Devuelve el paquete a fabrica de la taquilla dada.
	 * @param idTaquilla Número de la taquilla de la que se devuelve el paquete.
	 */
	public void devuelvePaquete(int idTaquilla) {
		
	}
}
