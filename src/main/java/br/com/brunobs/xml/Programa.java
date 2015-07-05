package br.com.brunobs.xml;

import br.com.brunobs.factory.ParoquiaFactory;
import br.com.brunobs.modelo.Paroquia;

public class Programa {

	public static void main(String[] args) throws Exception {
		long valor = 0;
		for (Paroquia paroquia : ParoquiaFactory.criar()) {
			valor = ParoquiaFactory.getTotalRegistros(paroquia);
		}
		System.out.println("TOTAL DE REGISTROS ENCONTRADOS: " + valor);
	}
}
