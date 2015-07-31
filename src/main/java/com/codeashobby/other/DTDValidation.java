/**
 * Copyright (c) 2015 Ovitas Inc, All rights reserved.
 */
package com.codeashobby.other;

import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

/**
 * Description:
 *
 * @author hzhou
 */
public final class DTDValidation {

	private DTDValidation() {

	}

	public static boolean validate() throws SAXException, IOException {
		SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.XML_DTD_NS_URI);
		Schema schema = schemaFactory.newSchema(new File("xmlValidate.dtd"));
		Validator validator = schema.newValidator();
		validator.validate(new StreamSource("xmlValidate.xml"));
		return true;
	}

}