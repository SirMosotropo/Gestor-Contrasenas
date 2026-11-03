package gui;

import java.security.SecureRandom;

public enum TipoContrasena {
	Numeros("0123456789"),
	Letras("abcdefghijklmnopqrstuvwxyz"),
	LETRAS("ABCDEFGHIJKLMNOPQRSTUVWXYZ"),
	Caracteres("\"!@#$%&*()-_=+[]{};:,.<>?\"");
	
	private final String conjunto;
	private static final SecureRandom Random=new SecureRandom();
	
	TipoContrasena(String conjunto){
		this.conjunto=conjunto;
		
	}
	public String getConjunto() {
		return conjunto;
	}
			
	public String generar(int longitud ) {
		StringBuilder sb = new StringBuilder();
        for (int i = 0; i < longitud; i++) {
            sb.append(conjunto.charAt(Random.nextInt(conjunto.length())));
        }
        return sb.toString();
    }
	
}

