package br.com.brunobs.json;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.map.AnnotationIntrospector;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.xc.JaxbAnnotationIntrospector;

import br.com.brunobs.factory.ParoquiaFactory;
import br.com.brunobs.modelo.Paroquia;

public class JacksonParser {

	public static void main(String[] args) throws IOException {
		List<Paroquia> paroquia = ParoquiaFactory.criar();
		ObjectMapper objectMapper = new ObjectMapper();

		AnnotationIntrospector annotationIntrospector = new JaxbAnnotationIntrospector();
		objectMapper.setAnnotationIntrospector(annotationIntrospector);
		System.out.println(objectMapper.writeValueAsString(paroquia));

	}

}
