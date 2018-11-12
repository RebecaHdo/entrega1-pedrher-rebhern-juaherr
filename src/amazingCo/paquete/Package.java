package amazingCo.paquete;

import java.time.LocalDate;

/**
 * Permite la creación de paquetes, controlar y conocer el estado del paquete,
 * ya sea si este ha sido devuelto o recogido y saber su fecha límite de
 * recogida.
 * 
 * @author juaherr
 * @author rebhern
 * @author pedrher
 * 
 * 
 */
public class Package {

	private static final int DIAS_MAXIMO = 7;
	private String id;
	private LocalDate fechaLimite;
	/*
	 * Estados: 0 para recoger. 1 recogido. 2 devuelto.
	 */
	private int estado;

	/**
	 * Devuelve la fecha límite del paquete.
	 * 
	 * @return fecha límite del paquete.
	 */
	public LocalDate getFecha() {
		return fechaLimite;
	}

	/**
	 * Devuelve estado del paquete.
	 * 
	 * @return estado del paquete.
	 */
	public int getEstado() {
		return estado;
	}

	private void setEstado(int cambio) {
		estado = cambio;
	}

	/**
	 * Devuelve la id del paquete.
	 * 
	 * @return id del paquete.
	 */
	public String getId() {
		return id;
	}

	/**
	 * Inicializa el paquete con la id y fecha límite a partir de la fecha actual.
	 * 
	 * @param id id del paquete siguiendo las restriciones de id: "Debe tener diez
	 *           caracteres, de los cuales los primeros nueve son dígitos y el
	 *           décimo es un dígito resultante del resto de la división entre 10 de
	 *           la suma de los 9 primeros."
	 * @throws IllegalArgumentException si la id es null.
	 * @throws IllegalArgumentException si la longitud de la id es distinta de 10 o
	 *                                  si los caracteres de la id son distintos de
	 *                                  [0,9].
	 * @throws IllegalArgumentException si no se verifica el dígito de condición.
	 */
	public Package(String id) {
		if (id == null) {
			throw new IllegalArgumentException("La id es null.");
		}
		if (id.length() != 10) {
			throw new IllegalArgumentException("La id no tiene no tiene 10 dígitos");
		}
		int acumulado = 0;
		for (int i = 0; i < 9; i++) {
			int digito = id.charAt(i) - '0';

			// Una de las ramas es inaccesible ya que 10 < digito < 1 es imposible.
			if (digito < 10 && digito > -1) {
				acumulado += (digito);
			} else {
				throw new IllegalArgumentException("La id contiene caracteres distintos de [0,9]");
			}
		}
		if (acumulado % 10 == (id.charAt(9) - '0')) {
			this.id = id;
			fechaLimite = LocalDate.now();
			fechaLimite = fechaLimite.plusDays(DIAS_MAXIMO);
		} else {
			throw new IllegalArgumentException("No se verifica el dígito de condición.");
		}
	}

	/**
	 * Dada una fecha indica si la fecha de fin de almacenaje ha caducado.
	 * 
	 * @param fecha fecha con la que se desea comprobar.
	 * @return true si se ha pasado el plazo y false si no.
	 * @throws IllegalArgumentException si la fecha es null.
	 */
	public boolean fechaEnPlazo(LocalDate fecha) {
		if (fecha == null) {
			throw new IllegalArgumentException("La fecha es null.");

		}
		return !fechaLimite.isBefore(fecha);
	}

	/**
	 * Cambia el estado del paquete a recogido en caso de que sea posible.
	 * 
	 * @throws IllegalStateException si el paquete se intenta recoger pero su estado
	 *                               es 1 (recogido) o 2 (devuelto).
	 */
	public void recogido() {
		if (getEstado() == 0) {
			setEstado(1);
		} else if (getEstado() == 1) {
			throw new IllegalStateException("Paquete ya recogido.");
		} else {
			throw new IllegalStateException("Paquete ya devuelto.");

		}
	}

	/**
	 * Cambia el estado del paquete a devuelto en caso de que sea posible.
	 * 
	 * @throws IllegalStateException si el paquete se intenta devolver pero su
	 *                               estado es 1 (recogido) o 2 (devuelto).
	 */
	public void devuelto() {
		if (getEstado() == 0) {
			setEstado(2);
		} else if (getEstado() == 1) {
			throw new IllegalStateException("Paquete ya recogido.");
		} else {
			throw new IllegalStateException("Paquete ya devuelto.");
		}
	}

}