package br.com.brunobs.factory;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.OneToMany;

import br.com.brunobs.modelo.Bairro;
import br.com.brunobs.modelo.Cidade;
import br.com.brunobs.modelo.Encontrista;
import br.com.brunobs.modelo.Grupo;
import br.com.brunobs.modelo.Paroquia;

public abstract class ParoquiaFactory {
	private static long quantidadeRegistro = 10;

	public static List<Paroquia> criar() {
		List<Paroquia> paroquias = new ArrayList<Paroquia>();
		for (int i = 0; i < quantidadeRegistro; i++) {

			Cidade cidade = new Cidade("CIDADE" + i);
			for (int b = 0; b < quantidadeRegistro; b++) {
				cidade.addBairros(new Bairro("Bairro_" + i));
			}
			Paroquia paroquia = new Paroquia("PAROQUIA_" + i, cidade);

			for (int j = 0; j < quantidadeRegistro; j++) {
				Grupo grupo = new Grupo("GRUPO_" + j);
				paroquia.addGrupo(grupo);

				for (int k = 0; k < quantidadeRegistro; k++) {
					Encontrista encontrista = new Encontrista("ENCONTRISTA_" + k, "ENCONTRISTA_" + k + "@EMAIL.COM");
					grupo.addEncontrista(encontrista);
				}
			}
			paroquias.add(paroquia);

		}
		return paroquias;
	}

	public static long getTotalRegistros(Object entidade) throws Exception {
		long valor = 0;
		for (Field field : entidade.getClass().getDeclaredFields()) {
			if (field.isAnnotationPresent(OneToMany.class)) {

				Method mtd = entidade.getClass().getMethod(get(field.getName()));
				List<Object> a = (List<Object>) mtd.invoke(entidade);
				valor += a.size();
				for (Object objeto : a) {
					System.err.println(field.getName() + " - " + a.size());
					valor += getTotalRegistros(objeto);

				}
			}
		}
		return valor;

	}

	private static String get(String propriedade) {
		StringBuffer retorno = new StringBuffer();
		retorno.append("get");
		retorno.append(propriedade.substring(0, 1).toUpperCase());
		retorno.append(propriedade.substring(1, propriedade.length()).toLowerCase());
		return retorno.toString();

	}
}
