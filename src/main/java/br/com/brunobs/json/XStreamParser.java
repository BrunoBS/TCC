package br.com.brunobs.json;

import java.util.List;

import br.com.brunobs.factory.ParoquiaFactory;
import br.com.brunobs.modelo.Paroquia;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

public class XStreamParser {
	public static void main(String[] args) {
		List<Paroquia> paroquias = ParoquiaFactory.criar();
		XStream xStream = new XStream(new JettisonMappedXmlDriver());
		System.out.println(xStream.toXML(paroquias));

	}

}
