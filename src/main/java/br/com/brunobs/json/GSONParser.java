package br.com.brunobs.json;

import java.util.List;

import br.com.brunobs.factory.ParoquiaFactory;
import br.com.brunobs.modelo.Paroquia;

import com.google.gson.Gson;

public class GSONParser {

	public static void main(String[] args) {

		List<Paroquia> paroquia = ParoquiaFactory.criar();
		Gson gson = new Gson();
		System.out.println(gson.toJson(paroquia));

	}

}
