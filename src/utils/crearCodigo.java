package utils;

public class crearCodigo {

	public static int codigoVerificar() {

		int numero;

		numero = (int) (Math.random() * 999999 + 100000);

		return numero;
	}

}
