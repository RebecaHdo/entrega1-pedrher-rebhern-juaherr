package amazingCo.paquete;

import es.uva.inf.poo.maps.GPSCoordinate;
import java.time.LocalTime;
import java.time.LocalDate;

/**
 * 
 * @author juaherr
 * @author rebhern
 * @author pedrher
 * 
 *         Permite la creación de taquilleros con su id, horario, ubicación y
 *         número de taquillas, también controlar a los paquetes que tiene dicho
 *         taquillero. Los numeros de las taquillas comienzan en 0.
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
		compruebaGenerador(id, ubicacion, horario, numeroTaquillas);
		this.id = id;
		this.ubicacion = ubicacion;
		this.horario = horario;
		this.numeroTaquillas = numeroTaquillas;
		this.operativo = operativo;
		this.taquillas = new Package[numeroTaquillas];
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
		compruebaGenerador(id, ubicacion, horario, numeroTaquillas);
		this.id = id;
		this.ubicacion = ubicacion;
		this.horario = horario;
		this.numeroTaquillas = numeroTaquillas;
		this.operativo = true;
		this.taquillas = new Package[numeroTaquillas];
	}

	private void compruebaGenerador(String id, GPSCoordinate ubicacion, LocalTime[][] horario, int numeroTaquillas) {
		if (id == null || ubicacion == null || horario == null) {
			throw new IllegalArgumentException("Uno de los argumentos es null.");
		}

		if (horario.length != 7) {
			throw new IllegalArgumentException("Son necesarios los horarios de los 7 dias.");
		}
		for (int i = 0; i < 7; i++) {
			if (horario[i] == null) {
				throw new IllegalArgumentException("Uno de los dias es null.");
			}
			if (horario[i].length != 2) {
				throw new IllegalArgumentException("Cada dia tiene que tener horario de apertura y cierre");

			}
			for (int j = 0; j < 2; j++) {
				if (horario[i][j] == null) {
					throw new IllegalArgumentException("Al menos uno de los horaios no existe");
				}
			}
		}
		if (numeroTaquillas < 1) {
			throw new IllegalArgumentException("Número de taquillas no positivo.");

		}
		for (int i = 0; i < 7; i++) {
			if (horario[i][0].isAfter(horario[i][1])) {
				throw new IllegalArgumentException("Horas mal introducidas. Debe ser Apertura → Cierre");
			}
		}
	}

	private void setOperativo(boolean op) {
		operativo = op;
	}

	private void setOcupadas(int numero) {
		ocupadas = numero;
	}

	private Package[] getTaquillas() {
		return taquillas;
	}

	/**
	 * Cambia el packageLocker a operativo si está fuera de servicio y viceversa.
	 */
	public void operatividad() {
		if (getOperativo()) {
			setOperativo(false);
		} else {
			setOperativo(true);
		}
	}

	/**
	 * Devuelve la id del taquillero.
	 * 
	 * @return id del taquillero.
	 */
	public String getId() {
		return id;
	}

	/**
	 * Devuleve la hora de apertura o cierre de la taquilla de un día especificado.
	 * 
	 * @param dia dia de la semana que se quiere saber el horario.
	 * @return
	 */
	public LocalTime[] getHorarioDia(int dia) {
		return horario[dia];
	}

	/**
	 * Devuelve true si el taquillero está operativo y false en caso contrario.
	 * 
	 * @return boolean true si el taquillero está operativo y false si no lo está.
	 */
	public boolean getOperativo() {
		return operativo;

	}

	/**
	 * Devuelve el número de taquillas que tiene el taquillero.
	 * 
	 * @return número de taquillas.
	 */
	public int getNumeroTaquillas() {
		return numeroTaquillas;
	}

	/**
	 * Devuelve el número de taquillas llenas que tiene el taquillero.
	 * 
	 * @return número de taquillas llenas.
	 */
	public int getNumeroTaquillasLlenas() {
		return ocupadas;
	}

	/**
	 * Devuelve el número de taquillas vacias que tiene el taquillero.
	 * 
	 * @return número de taquillas vacias.
	 */
	public int getNumeroTaquillasVacias() {
		return getNumeroTaquillas() - getNumeroTaquillasLlenas();
	}

	/**
	 * Devuelve la ubicación geográfica del taquillero.
	 * 
	 * @return la ubicación geográfica.
	 */
	public GPSCoordinate getUbicacion() {
		return ubicacion;
	}

	/**
	 * Devuelve el número de taquilla del paquete deseado.
	 * 
	 * @param idPaquete id del paquete.
	 * @return Número de la taquilla en la que está el paquete.
	 * @throws IllegalArgumentException si la id es null o si no existe el paquete
	 *                                  indicado en el taquillero indicado.
	 */
	public int locaclizaPaquete(String idPaquete) {
		if (idPaquete == null) {
			throw new IllegalArgumentException("La id es null.");
		}
		int i = 0;
		int zona = -1;
		while (i < getTaquillas().length) {
			if (idPaquete == getTaquillas()[i].getId()) {
				zona = i;
				i = getTaquillas().length;
			} else {
				i++;
			}
		}
		if (zona == -1) {
			throw new IllegalArgumentException("No existe ese paquete en el taquillero.");
		} else {
			return zona;
		}

	}

	/**
	 * Asigna el paquete dado a una taquilla.
	 * 
	 * @param p el paquete a guardar.
	 * @throws IllegalArgumenException Si el paquete es null.
	 * @throws IllegalStateException   Si el taquillero está lleno o si hay otro
	 *                                 paquete con la misma id.
	 */
	public void asignaPaquete(Package p) {

		if (p == null) {
			throw new IllegalArgumentException("El paquete es null.");
		}
		if (getNumeroTaquillasLlenas() == getNumeroTaquillas()) {
			throw new IllegalStateException("Taquillero lleno.");
		}
		for (int i = 0; i < getNumeroTaquillas(); i++) {
			if (getTaquillas()[i] != null) {
				if (p.getId() == getTaquillas()[i].getId()) {
					throw new IllegalStateException("Hay otro paquete con la misma id");
				}
			}
		}
		int i = 0;
		while (i < getTaquillas().length) {
			if (getTaquillas()[i] == null) {
				getTaquillas()[i] = p;
				i = getTaquillas().length;
			} else {
				i++;
			}
		}
		setOcupadas(getNumeroTaquillasLlenas() + 1);

	}

	/**
	 * Saca el paquete de la taquilla dada.
	 * 
	 * @param idTaquilla Número de la taquilla de la que sacar el paquete.
	 * @throws IllegalArgumentException si el numero de taquilla es erróneo.
	 * @throws IllegalStateException    Si la taquilla está vacia o si la fecha de
	 *                                  entrega ha sido superada.
	 */
	public Package sacaPaquete(int idTaquilla) {
		if (idTaquilla < 0 || idTaquilla > getNumeroTaquillas() - 1) {
			throw new IllegalArgumentException(
					"Número de taquilla erroneo. Debe estar comprendido entre 0 y numero de taquillas -1");
		}
		if (getTaquillas()[idTaquilla] == null) {
			throw new IllegalStateException("Esta taquilla está vacía.");
		} else if (!getTaquillas()[idTaquilla].fechaEnPlazo(LocalDate.now())) {
			throw new IllegalStateException("La fecha de entrega ha sido superada.");

		}
		getTaquillas()[idTaquilla].recogido();
		setOcupadas(getNumeroTaquillasLlenas() - 1);
		Package paquete = getTaquillas()[idTaquilla];
		getTaquillas()[idTaquilla] = null;
		return paquete;
	}

	/**
	 * Devuelve el paquete a fabrica de la taquilla dada.
	 * 
	 * @param idTaquilla Número de la taquilla de la que se devuelve el paquete.
	 * @throws IllegalArgumentException si el numero de taquilla es erróneo.
	 * @throws IllegalStateException    si la taquilla está vacia.
	 */
	public Package devuelvePaquete(int idTaquilla) {
		if (idTaquilla < 0 || idTaquilla > getNumeroTaquillas() - 1) {
			throw new IllegalArgumentException(
					"Número de taquilla erroneo. Debe estar comprendido entre 0 y numero de taquillas -1");
		}
		if (getTaquillas()[idTaquilla] == null) {
			throw new IllegalStateException("Esta taquilla está vacía.");
		}
		getTaquillas()[idTaquilla].devuelto();
		setOcupadas(getNumeroTaquillasLlenas() - 1);
		Package paquete = getTaquillas()[idTaquilla];
		getTaquillas()[idTaquilla] = null;
		return paquete;

	}
}
