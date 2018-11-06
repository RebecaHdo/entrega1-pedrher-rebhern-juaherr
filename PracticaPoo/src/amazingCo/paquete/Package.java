package amazingCo.paquete;

import java.time.LocalDate;

/**
 * 
 * @author juaherr
 * @author rebhern
 * @author pedrher
 * 
 *         Permite la creación de paquetes y controlar el estado del paquete
 *         ademas de saber su fecha límite de recogida.
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
	 * inicializa el paquete con la id y fecha límite a partir de la actual.
	 * 
	 * @param id id del paquete siguiendo las restriciones de id "Debe tener diez
	 *           caracteres, de los cuales los primeros nueve son dígitos y el
	 *           décimo es un dígito resultante delresto de la división entre 10 de
	 *           la suma de los 9 primeros."
	 * @throws IllegalArgumentException si la id es null o si la longitud de la id
	 *                                  es distinta de 10 o si los caracteres de la
	 *                                  id son distintos de [0,9] o si no se
	 *                                  verifica el dígito de condición.
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
	 * Dada una fecha indica si la fecha de fin de almacenaje se ha pasado.
	 * 
	 * @param fecha fecha con la que comprobar.
	 * @return true si se ha pasado y false si no.
	 * @throws IllegalArgumentException si la fecha es null
	 */
	public boolean fechaEnPlazo(LocalDate fecha) {
		if (fecha == null) {
			throw new IllegalArgumentException("La fecha es null.");

		}
		return !fechaLimite.isBefore(fecha);
	}

	/**
	 * Cambia el estado del paquete a recogido.
	 * 
	 * @throws IllegalStateException si el paquete se intenta recoger o devolver a
	 *                               pesar de que su estado habia sido cambiado a
	 *                               recogido.
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
	 * Cambia el estado del paquete a devuelto.
	 * 
	 * @throws IllegalStateException si el paquete se intenta recoger o devolver a
	 *                               pesar de que su estado habia sido cambiado a
	 *                               devuelto.
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
