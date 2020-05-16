package com.dilip.exoplanetcatalogue.models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class YearGroupedPlanets {
	@JsonIgnore
	private Integer year;
	private Integer smallPlanetCount;
	@JsonIgnore
	private List<Planet> smallPlanets;
	private Integer mediumPlanetCount;
	@JsonIgnore
	private List<Planet> mediumPlanets;
	private Integer largePlanetCount;
	@JsonIgnore
	private List<Planet> largePlanets;
	
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	
	
	public Integer getSmallPlanetCount() {
		return smallPlanetCount;
	}
	public void setSmallPlanetCount(Integer smallPlanetCount) {
		this.smallPlanetCount = smallPlanetCount;
	}
	public Integer getMediumPlanetCount() {
		return mediumPlanetCount;
	}
	public void setMediumPlanetCount(Integer mediumPlanetCount) {
		this.mediumPlanetCount = mediumPlanetCount;
	}
	public Integer getLargePlanetCount() {
		return largePlanetCount;
	}
	public void setLargePlanetCount(Integer largePlanetCount) {
		this.largePlanetCount = largePlanetCount;
	}
	public void addLargePlanets(Planet largePlanet) {
		if(this.largePlanets == null)
			this.largePlanets = new ArrayList<Planet>();
		
		this.largePlanets.add(largePlanet);
		this.largePlanetCount++;
	}
	public List<Planet> getSmallPlanets() {
		return smallPlanets;
	}
	public void setSmallPlanets(List<Planet> smallPlanets) {
		this.smallPlanets = smallPlanets;
	}
	public void addSmallPlanets(Planet smallPlanet) {
		if(this.smallPlanets == null)
			this.smallPlanets = new ArrayList<Planet>();
		
		this.smallPlanets.add(smallPlanet);
		this.smallPlanetCount++;
	}
	public List<Planet> getMediumPlanets() {
		return mediumPlanets;
	}
	public void setMediumPlanets(List<Planet> mediumPlanets) {
		this.mediumPlanets = mediumPlanets;
	}
	public void addMediumPlanets(Planet mediumPlanet) {
		if(this.mediumPlanets == null)
			this.mediumPlanets = new ArrayList<Planet>();
		
		this.mediumPlanets.add(mediumPlanet);
		this.mediumPlanetCount++;
	}
	public List<Planet> getLargePlanets() {
		return largePlanets;
	}
	public void setLargePlanets(List<Planet> largePlanets) {
		this.largePlanets = largePlanets;
	}
	public YearGroupedPlanets(){
		
	}
	public YearGroupedPlanets(int year){
		this.year = year;
		this.smallPlanetCount = 0;
		this.mediumPlanetCount = 0;
		this.largePlanetCount = 0;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((largePlanetCount == null) ? 0 : largePlanetCount.hashCode());
		result = prime * result + ((mediumPlanetCount == null) ? 0 : mediumPlanetCount.hashCode());
		result = prime * result + ((smallPlanetCount == null) ? 0 : smallPlanetCount.hashCode());
		result = prime * result + ((year == null) ? 0 : year.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		YearGroupedPlanets other = (YearGroupedPlanets) obj;
		if (largePlanetCount == null) {
			if (other.largePlanetCount != null)
				return false;
		} else if (!largePlanetCount.equals(other.largePlanetCount))
			return false;
		if (mediumPlanetCount == null) {
			if (other.mediumPlanetCount != null)
				return false;
		} else if (!mediumPlanetCount.equals(other.mediumPlanetCount))
			return false;
		if (smallPlanetCount == null) {
			if (other.smallPlanetCount != null)
				return false;
		} else if (!smallPlanetCount.equals(other.smallPlanetCount))
			return false;
		if (year == null) {
			if (other.year != null)
				return false;
		} else if (!year.equals(other.year))
			return false;
		return true;
	}
	
	
}
