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
 *         Administra los taquilleros, pudiendo añiadir o eliminarlos, ver los
 *         operativos y fuera de servicio, encontrar los que hay en un radio
 *         dado y ver cuales tienen taquillas vacias.
 */
public class PickingPointsSystem {

	private ArrayList<PackageLocker> listaTaquilleros;

	/**
	 * Inicializa PickingPointsSystem
	 */
	public PickingPointsSystem() {
		listaTaquilleros = new ArrayList<PackageLocker>();
	}

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
		if (id == null || ubicacion == null || horario == null) {
			throw new IllegalArgumentException("Uno de los argumentos es null.");
		}
		for (int i = 0; i < listaTaquilleros.size(); i++) {
			if (id == listaTaquilleros.get(i).getId()) {
				throw new IllegalArgumentException("Ya existe un taquillero con la id indicada.");
			}
		}
		PackageLocker taquillero = new PackageLocker(id, ubicacion, horario, numeroTaquillas, operativo);

		listaTaquilleros.add(taquillero);
	}

	/**
	 * 
	 * Crear y guarda el taquillero operativo con la id, ubicación, horario semanal
	 * y número de taquillas.
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
		if (id == null || ubicacion == null || horario == null) {
			throw new IllegalArgumentException("Uno de los argumentos es null.");
		}
		for (int i = 0; i < listaTaquilleros.size(); i++) {
			if (id == listaTaquilleros.get(i).getId()) {
				throw new IllegalArgumentException("Ya existe un taquillero con la id indicada.");
			}
		}
		PackageLocker taquillero = new PackageLocker(id, ubicacion, horario, numeroTaquillas);

		listaTaquilleros.add(taquillero);
	}

	/**
	 * Elimina un PackageLocker por id.
	 * 
	 * @param id del PackageLocker a borrar.
	 */
	public void eliminarPackageLocker(String id) {
		if(listaTaquilleros.size() == 0) {
			throw new IllegalStateException("No hay taquilleros guardados.");
		}
		int i = 0;
		boolean encontrado = false;
		while (i < listaTaquilleros.size()) {
			if (id == listaTaquilleros.get(i).getId()) {
				listaTaquilleros.remove(i);
				i = listaTaquilleros.size();
				encontrado = true;
			} else {
				i++;

			}
		}
		if(!encontrado) {
			throw new IllegalArgumentException("No existe ningún taquillero con esa id.");

		}
	}

	/**
	 * Devuelve un array de PackageLockers operativos.
	 * 
	 * @return array de PackageLockers operativos.
	 */
	public PackageLocker[] PackageLockerOperativos() {
		if(listaTaquilleros.size() == 0) {
			throw new IllegalStateException("No hay taquilleros guardados.");
		}
		int contador = 0;
		for (int i = 0; i < listaTaquilleros.size(); i++) {
			if (listaTaquilleros.get(i).getOperativo()) {
				contador++;
			}
		}
		PackageLocker[] vector = new PackageLocker[contador];
		contador = 0;
		for (int i = 0; i < listaTaquilleros.size(); i++) {
			if (listaTaquilleros.get(i).getOperativo()) {
				vector[contador] = listaTaquilleros.get(i);
				contador++;
			}
		}
		return vector;
	}

	/**
	 * Devuelve un array de PackageLockers fuera de servicio.
	 * 
	 * @return array de PackageLockers fuera de servicio.
	 */
	public PackageLocker[] PackageLockerFueraDeServicio() {
		if(listaTaquilleros.size() == 0) {
			throw new IllegalStateException("No hay taquilleros guardados.");
		}
		int contador = 0;
		for (int i = 0; i < listaTaquilleros.size(); i++) {
			if (!listaTaquilleros.get(i).getOperativo()) {
				contador++;
			}
		}
		PackageLocker[] vector = new PackageLocker[contador];
		contador = 0;
		for (int i = 0; i < listaTaquilleros.size(); i++) {
			if (!listaTaquilleros.get(i).getOperativo()) {
				vector[contador] = listaTaquilleros.get(i);
				contador++;
			}
		}
		return vector;
	}

	/**
	 * Devuelve un array de PackagerLockers ordenados por orden de cercania que
	 * estén dentro del randio dado a la ubicación dada.
	 * 
	 * @param ubicacion zona desde la que se genera el radio.
	 * @param radio     distancia desde la ubicación que se quiere abarcar.
	 * @return
	 */
	public PackageLocker[] PackageLockerEnZona(GPSCoordinate ubicacion, double radio) {
		if(listaTaquilleros.size() == 0) {
			throw new IllegalStateException("No hay taquilleros guardados.");
		}
		if(radio < 0) {
			throw new IllegalArgumentException("El radio no puede ser negativo.");
		}
		int contador = 0;
		for (int i = 0; i < listaTaquilleros.size(); i++) {
			double distancia = listaTaquilleros.get(i).getUbicacion().getDistanceTo(ubicacion);
			distancia *= 1000;
			if (distancia < radio) {
				contador++;
			}
		}
		PackageLocker[] vector = new PackageLocker[contador];
		contador = 0;
		for (int i = 0; i < listaTaquilleros.size(); i++) {
			double distancia = listaTaquilleros.get(i).getUbicacion().getDistanceTo(ubicacion);
			distancia *= 1000;
			if (distancia < radio) {
				vector[contador] = listaTaquilleros.get(i);
				contador++;
			}
		}
		return vector;
		
	}

	/**
	 * Devuelve un array de PackageLockers con taquillas vacias.
	 * 
	 * @return array de PackageLockers con taquillas vacias.
	 */
	public PackageLocker[] PackageLockerConTaquillasVacias() {
		if(listaTaquilleros.size() == 0) {
			throw new IllegalStateException("No hay taquilleros guardados.");
		}
		int contador = 0;
		for (int i = 0; i < listaTaquilleros.size(); i++) {
			if (listaTaquilleros.get(i).getNumeroTaquillasVacias() != 0) {
				contador++;
			}
		}
		PackageLocker[] vector = new PackageLocker[contador];
		contador = 0;
		for (int i = 0; i < listaTaquilleros.size(); i++) {
			if (listaTaquilleros.get(i).getNumeroTaquillasVacias() != 0) {
				vector[contador] = listaTaquilleros.get(i);
				contador++;
			}
		}
		return vector;
	}

}
