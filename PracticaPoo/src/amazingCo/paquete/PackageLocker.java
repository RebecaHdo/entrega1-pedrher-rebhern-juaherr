package amazingCo.paquete;

import es.uva.inf.poo.maps.GPSCoordinate;
import java.time.LocalTime;

/**
 * 
 * @author juaherr
 * @author rebhern
 * @author pedrher
 * 
 *         Permite la creación de taquilleros con su id, horario, ubicación y
 *         número de taquillas, también controlar a los paquetes que tiene dicho
 *         taquillero.
 */
public class PackageLocker {

	private String id;
	private GPSCoordinate ubicacion;
	private LocalTime[][] horario;
	private int numeroTaquillas;
	private int ocupadas;
	private boolean operativo;
	private Package[] taquillas;

	/**
	 * Inicializa el taquillero con la id, ubicación, horario semanal, número de
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
	public PackageLocker(String id, GPSCoordinate ubicacion, LocalTime[][] horario, int numeroTaquillas,
			boolean operativo) {
		this.id = id;
		this.ubicacion = ubicacion;
		this.horario = horario;
		this.numeroTaquillas = numeroTaquillas;
		this.operativo = operativo;
	}

	/**
	 * Inicializa el taquillero operativo con la id, ubicación, horario semanal y
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
	public PackageLocker(String id, GPSCoordinate ubicacion, LocalTime[][] horario, int numeroTaquillas) {
		this.id = id;
		this.ubicacion = ubicacion;
		this.horario = horario;
		this.numeroTaquillas = numeroTaquillas;
		this.operativo = true;
	}

	/**
	 * Devuelve el número de taquillas que tiene el taquillero.
	 * 
	 * @return número de taquillas.
	 */
	public int numeroTaquillas() {

	}

	/**
	 * Devuelve el número de taquillas vacias que tiene el taquillero.
	 * 
	 * @return número de taquillas vacias.
	 */
	public int numeroTaquillasVacias() {

	}

	/**
	 * Devuelve el número de taquillas llenas que tiene el taquillero.
	 * 
	 * @return número de taquillas llenas.
	 */
	public int numeroTaquillasLlenas() {

	}

	/**
	 * Devuelve la ubicación geográfica del taquillero.
	 * 
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
	 * 
	 * @param p el paquete a guardar.
	 */
	public void asignaPaquete(Package p) {

	}

	/**
	 * Saca el paquete de la taquilla dada.
	 * 
	 * @param idTaquilla Número de la taquilla de la que sacar el paquete.
	 */
	public void sacaPaquete(int idTaquilla) {

	}

	/**
	 * Devuelve el paquete a fabrica de la taquilla dada.
	 * 
	 * @param idTaquilla Número de la taquilla de la que se devuelve el paquete.
	 */
	public void devuelvePaquete(int idTaquilla) {

	}
}
