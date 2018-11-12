package amazingCo.paquete;

import java.time.LocalTime;
import java.util.ArrayList;
import es.uva.inf.poo.maps.GPSCoordinate;

/**
 * Administra los taquilleros, pudiendo añadirlos o eliminarlos, ver los
 * operativos y fuera de servicio, encontrar los que hay en un radio dado, ver
 * cuales tienen taquillas vacias y cuales están completamente llenos.
 * 
 * @author juaherr
 * @author rebhern
 * @author pedrher
 * 
 */
public class PickingPointsSystem {

	private ArrayList<PackageLocker> listaTaquilleros;

	private ArrayList<PackageLocker> getListaTaquilleros() {
		return listaTaquilleros;
	}

	/**
	 * Inicializa PickingPointsSystem.
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
	 * @throws IllegalArgumentException si uno de los argumentos es null.
	 * @throws IllegalArgumentException si ya existe un taquillero con la id
	 *                                  introducida.
	 */
	public void crearPackageLocker(String id, GPSCoordinate ubicacion, LocalTime[][] horario, int numeroTaquillas,
			boolean operativo) {
		if (id == null || ubicacion == null || horario == null) {
			throw new IllegalArgumentException("Uno de los argumentos es null.");
		}
		for (int i = 0; i < getListaTaquilleros().size(); i++) {
			if (id == getListaTaquilleros().get(i).getId()) {
				throw new IllegalArgumentException("Ya existe un taquillero con la id indicada.");
			}
		}
		PackageLocker taquillero = new PackageLocker(id, ubicacion, horario, numeroTaquillas, operativo);

		getListaTaquilleros().add(taquillero);
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
	 * @throws IllegalArgumentException si uno de los argumentos es null.
	 * @throws IllegalArgumentException si ya existe un taquillero con la id
	 *                                  introducida.
	 */
	public void crearPackageLocker(String id, GPSCoordinate ubicacion, LocalTime[][] horario, int numeroTaquillas) {
		if (id == null || ubicacion == null || horario == null) {
			throw new IllegalArgumentException("Uno de los argumentos es null.");
		}
		for (int i = 0; i < getListaTaquilleros().size(); i++) {
			if (id == getListaTaquilleros().get(i).getId()) {
				throw new IllegalArgumentException("Ya existe un taquillero con la id indicada.");
			}
		}
		PackageLocker taquillero = new PackageLocker(id, ubicacion, horario, numeroTaquillas);

		getListaTaquilleros().add(taquillero);
	}

	/**
	 * Elimina un PackageLocker por id introducida.
	 * 
	 * @param id del PackageLocker a borrar.
	 * @throws IllegalStateException    si no hay ningún taquillero creado.
	 * @throws IllegalStateException    si hay paquetes sin recoger o devolver en el
	 *                                  taquillero.
	 * @throws IllegalArgumentException si no existe ningún taquillero con la id
	 *                                  introducida.
	 */
	public void eliminarPackageLocker(String id) {
		if (getListaTaquilleros().size() == 0) {
			throw new IllegalStateException("No hay taquilleros creado.");
		}
		int i = 0;
		boolean encontrado = false;
		while (i < getListaTaquilleros().size()) {
			PackageLocker taquillero = getListaTaquilleros().get(i);
			if (id == taquillero.getId()) {
				for (int j = 0; j < taquillero.getNumeroTaquillas(); j++) {
					if (taquillero.getTaquillas()[j] != null) {
						throw new IllegalStateException("Todavia hay paquetes en el taquillero.");
					}
				}
				getListaTaquilleros().remove(i);
				i = getListaTaquilleros().size();
				encontrado = true;
			} else {
				i++;

			}
		}
		if (!encontrado) {
			throw new IllegalArgumentException("No existe ningún taquillero con esa id.");

		}
	}

	/**
	 * Devuelve todos los PackageLockers.
	 * 
	 * @return todos los PackageLockers.
	 */
	public PackageLocker[] getTodosPackageLocker() {
		PackageLocker[] vector = new PackageLocker[getListaTaquilleros().size()];
		for (int i = 0; i < getListaTaquilleros().size(); i++) {
			vector[i] = getListaTaquilleros().get(i);
		}
		return vector;
	}

	/**
	 * Devuelve el PackageLocker correspondiente a la id introducida.
	 * 
	 * @param id id del packagelocker que se quiere obtener.
	 * @return packagelocker con la id dada.
	 * @throws IllegalStateException    si no hay taquilleros creados.
	 * @throws IllegalArgumentException si no existe ningún taquillero con la id
	 *                                  introducida.
	 * 
	 */
	public PackageLocker getPackageLocker(String id) {
		if (getListaTaquilleros().size() == 0) {
			throw new IllegalStateException("No hay taquilleros creados.");
		}
		int i = 0;
		PackageLocker taquillero = null;
		while (i < getListaTaquilleros().size()) {
			if (id == getListaTaquilleros().get(i).getId()) {
				taquillero = getListaTaquilleros().get(i);
				i = getListaTaquilleros().size();
			} else {
				i++;

			}
		}
		if (taquillero == null) {
			throw new IllegalArgumentException("No existe ningún taquillero con esa id.");

		} else {
			return taquillero;
		}
	}

	/**
	 * Devuelve todos los PackageLockers operativos.
	 * 
	 * @return PackageLockers operativos.
	 * @throws IllegalStateException si no hay taquilleros creados.
	 * 
	 */
	public PackageLocker[] getPackageLockerOperativos() {
		// recorre dos veces la lista de packageLockers creados. Una para conocer el
		// tamaño del vector que se devulve y otra para rellenarlo.
		if (getListaTaquilleros().size() == 0) {
			throw new IllegalStateException("No hay taquilleros creados.");
		}
		int contador = 0;
		for (int i = 0; i < getListaTaquilleros().size(); i++) {
			if (getListaTaquilleros().get(i).getOperativo()) {
				contador++;
			}
		}
		PackageLocker[] vector = new PackageLocker[contador];
		contador = 0;
		for (int i = 0; i < getListaTaquilleros().size(); i++) {
			if (getListaTaquilleros().get(i).getOperativo()) {
				vector[contador] = getListaTaquilleros().get(i);
				contador++;
			}
		}
		return vector;
	}

	/**
	 * Devuelve todos los PackageLockers fuera de servicio.
	 * 
	 * @return PackageLockers fuera de servicio.
	 * @throws IllegalStateException si no hay taquilleros creados.
	 * 
	 */
	public PackageLocker[] getPackageLockerFueraDeServicio() {
		// recorre dos veces la lista de packageLockers creados. Una para conocer el
		// tamaño del vector que se devulve y otra para rellenarlo.
		if (getListaTaquilleros().size() == 0) {
			throw new IllegalStateException("No hay taquilleros guardados.");
		}
		int contador = 0;
		for (int i = 0; i < getListaTaquilleros().size(); i++) {
			if (!getListaTaquilleros().get(i).getOperativo()) {
				contador++;
			}
		}
		PackageLocker[] vector = new PackageLocker[contador];
		contador = 0;
		for (int i = 0; i < getListaTaquilleros().size(); i++) {
			if (!getListaTaquilleros().get(i).getOperativo()) {
				vector[contador] = getListaTaquilleros().get(i);
				contador++;
			}
		}
		return vector;
	}

	/**
	 * Devuelve los PackagerLockers en radio dado desde una ubicación dada.
	 * 
	 * @param ubicacion zona desde la que se genera el radio.
	 * @param radio     distancia desde la ubicación que se quiere abarcar.
	 * @return todos los taquilleros operativos que están en el radio indicado desde
	 *         la ubicación indicada.
	 * @throws IllegalArgumentException si la ubicaón introducida es nula.
	 * @throws IllegalArgumentException si el radioi dado es negativo.
	 * @throws IllegalStateException    si no hay taquilleros creados.
	 */
	public PackageLocker[] getPackageLockerEnZona(GPSCoordinate ubicacion, double radio) {
		if (ubicacion == null) {
			throw new IllegalArgumentException("La ubicación es nula.");
		}
		if (getListaTaquilleros().size() == 0) {
			throw new IllegalStateException("No hay taquilleros creados.");
		}
		if (radio < 0) {
			throw new IllegalArgumentException("El radio no puede ser negativo.");
		}
		int contador = 0;
		for (int i = 0; i < getListaTaquilleros().size(); i++) {
			double distancia = getListaTaquilleros().get(i).getUbicacion().getDistanceTo(ubicacion);
			distancia *= 1000;
			if (distancia <= radio) {
				contador++;
			}
		}
		PackageLocker[] vector = new PackageLocker[contador];
		contador = 0;
		for (int i = 0; i < getListaTaquilleros().size(); i++) {
			double distancia = getListaTaquilleros().get(i).getUbicacion().getDistanceTo(ubicacion);
			distancia *= 1000;
			if (distancia <= radio) {
				vector[contador] = getListaTaquilleros().get(i);
				contador++;
			}
		}
		return vector;

	}

	/**
	 * Devuelve todos los PackageLockers con alguna taquilla vacia.
	 * 
	 * @return PackageLockers con taquillas vacias.
	 * @throws IllegalStateException si no hay taquilleros creados.
	 */
	public PackageLocker[] getPackageLockerTaquillasVacias() {
		// recorre dos veces la lista de packageLockers creados. Una para conocer el
		// tamaño del vector que se devulve y otra para rellenarlo.
		if (getListaTaquilleros().size() == 0) {
			throw new IllegalStateException("No hay taquilleros creados.");
		}
		int contador = 0;
		for (int i = 0; i < getListaTaquilleros().size(); i++) {
			if (getListaTaquilleros().get(i).getNumeroTaquillasVacias() != 0) {
				contador++;
			}
		}
		PackageLocker[] vector = new PackageLocker[contador];
		contador = 0;
		for (int i = 0; i < getListaTaquilleros().size(); i++) {
			if (getListaTaquilleros().get(i).getNumeroTaquillasVacias() != 0) {
				vector[contador] = getListaTaquilleros().get(i);
				contador++;
			}
		}
		return vector;
	}

	/**
	 * Devuelve todos los PackageLockers operativos con alguna taquilla vacia.
	 * 
	 * @return PackageLockers operativos con taquillas vacias.
	 * @throws IllegalStateException si no hay taquilleros creados.
	 */
	public PackageLocker[] getPackageLockerTaquillasVaciasOperativas() {
		// recorre dos veces la lista de packageLockers creados. Una para conocer el
		// tamaño del vector que se devulve y otra para rellenarlo.
		if (getListaTaquilleros().size() == 0) {
			throw new IllegalStateException("No hay taquilleros creados.");
		}
		int contador = 0;
		for (int i = 0; i < getListaTaquilleros().size(); i++) {
			if (getListaTaquilleros().get(i).getNumeroTaquillasVacias() != 0
					&& getListaTaquilleros().get(i).getOperativo()) {
				contador++;
			}
		}
		PackageLocker[] vector = new PackageLocker[contador];
		contador = 0;
		for (int i = 0; i < getListaTaquilleros().size(); i++) {
			if (getListaTaquilleros().get(i).getNumeroTaquillasVacias() != 0
					&& getListaTaquilleros().get(i).getOperativo()) {
				vector[contador] = getListaTaquilleros().get(i);
				contador++;
			}
		}
		return vector;
	}

}
