package br.com.brunobs.json;

import java.io.OutputStreamWriter;
import java.io.Writer;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.stream.XMLStreamWriter;

import org.codehaus.jettison.mapped.MappedNamespaceConvention;
import org.codehaus.jettison.mapped.MappedXMLStreamWriter;

import br.com.brunobs.factory.ParoquiaFactory;
import br.com.brunobs.modelo.Paroquia;

@SuppressWarnings("restriction")
public class JettisonParser {

	public static void main(String[] args) throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(Paroquia.class);
		MappedNamespaceConvention con = new MappedNamespaceConvention();
		Writer writer = new OutputStreamWriter(System.out);
		XMLStreamWriter xmlStreamWriter = new MappedXMLStreamWriter(con, writer);
		Marshaller marshaller = context.createMarshaller();

		for (Paroquia paroquia : ParoquiaFactory.criar()) {
			marshaller.marshal(paroquia, xmlStreamWriter);
		}

	}

}
