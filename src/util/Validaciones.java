package util;

public class Validaciones
{
	public static final String TEXTO = "[a-zA-ZáéíóúñüÁÉÍÓÚÑÜ\\s]{10,100}";
	public static final String ESTADO = "[a-zA-ZáéíóúñüÁÉÍÓÚÑÜ\\s]{6,9}";
	public static final String CELULAR = "\\d{9}";
	public static final String TELEFONO = "\\d{7}";
	public static final String RUC = "\\d{11}";
}
