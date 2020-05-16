package com.dilip.exoplanetcatalogue.models;

import java.util.Map;
import java.util.TreeMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ExoPlanetCatalogue {
	
	private Integer orphanPlanets;
	private String planetOrbitingHotStar;
	@JsonIgnore
	private Double tempHotStar = Double.MIN_VALUE;
	private Map<Integer,YearGroupedPlanets> planetsGrouped;
	
	public ExoPlanetCatalogue() {
		
	}

	public ExoPlanetCatalogue(JSONArray jsonArr) {
		orphanPlanets = 0;
		planetOrbitingHotStar="";
		planetsGrouped = new TreeMap<>();
		Double tempMax = Double.MIN_VALUE;
		jsonArr.forEach(obj->{
			JSONObject jsonObject = (JSONObject)obj; 
			Planet planet = new Planet(jsonObject);
			if(planet.getHostStarMassSlrMass() == 0 &&
					planet.getHostStarRadiusSlrRad() == 0 &&
					planet.getHostStarMetallicity() == 0 &&
					planet.getHostStarTempK() == 0 &&
					planet.getHostStarAgeGyr() == 0)
				orphanPlanets++;
			else if(planet.getHostStarTempK()>tempHotStar) {
				tempHotStar = planet.getHostStarTempK();
				planetOrbitingHotStar = planet.getPlanetIdentifier();
			}
			
			int year = planet.getDiscoveryYear();
			
			YearGroupedPlanets yearGroupPlanet = planetsGrouped.get(year);
			if(yearGroupPlanet == null)
				yearGroupPlanet = new YearGroupedPlanets(year);
			
			if(planet.getRadiusJpt()<1)
				yearGroupPlanet.addSmallPlanets(planet);
			else if(planet.getRadiusJpt()<2) 
				yearGroupPlanet.addMediumPlanets(planet);
			else 
				yearGroupPlanet.addLargePlanets(planet);
			
			planetsGrouped.put(year, yearGroupPlanet);
		});
	}

	public Integer getOrphanPlanets() {
		return orphanPlanets;
	}

	public void setOrphanPlanets(Integer orphanPlanets) {
		this.orphanPlanets = orphanPlanets;
	}

	public String getPlanetOrbitingHotStar() {
		return planetOrbitingHotStar;
	}

	public void setPlanetOrbitingHotStar(String planetOrbitingHotStar) {
		this.planetOrbitingHotStar = planetOrbitingHotStar;
	}

	public Map<Integer, YearGroupedPlanets> getPlanetsGrouped() {
		return planetsGrouped;
	}

	public void setPlanetsGrouped(Map<Integer, YearGroupedPlanets> planetsGrouped) {
		this.planetsGrouped = planetsGrouped;
	}
	
	
	
}
