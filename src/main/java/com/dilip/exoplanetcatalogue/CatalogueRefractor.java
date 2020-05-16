package com.dilip.exoplanetcatalogue;

import java.io.File;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;

import com.dilip.exoplanetcatalogue.models.ExoPlanetCatalogue;
import com.dilip.exoplanetcatalogue.util.JsonFormatter;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CatalogueRefractor {

	public static void main(String[] args) throws IOException, ParseException {
		JSONArray jsonArr = (JSONArray)JsonFormatter.parseUrl("https://gist.githubusercontent.com/joelbirchler/"
			+ "66cf8045fcbb6515557347c05d789b4a/raw/9a196385b44d4288431eef74896c0512bad3defe/exoplanets");

		ObjectMapper objMapper = new ObjectMapper();
		ExoPlanetCatalogue catalogue = new ExoPlanetCatalogue(jsonArr); 		
		
		System.out.println(objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(catalogue));
		objMapper.writerWithDefaultPrettyPrinter().writeValue(new File("output.json"), catalogue);	}
}
