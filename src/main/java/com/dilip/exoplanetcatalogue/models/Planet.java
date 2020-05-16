package com.dilip.exoplanetcatalogue.models;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.json.simple.JSONObject;

public class Planet {

	private String PlanetIdentifier;
	private Integer TypeFlag;
	private Double PlanetaryMassJpt;
	private Double RadiusJpt;
	private Double PeriodDays;
	private Double SemiMajorAxisAU;
	private Double Eccentricity;
	private Double PeriastronDeg;
	private Double LongitudeDeg;
	private Double AscendingNodeDeg;
	private Double InclinationDeg;
	private Double SurfaceTempK;
	private Double AgeGyr;
	private String DiscoveryMethod;
	private Integer DiscoveryYear;
	private LocalDate LastUpdated;
	private LocalTime RightAscension;
	private String Declination;
	private Double DistFromSunParsec;
	private Double HostStarMassSlrMass;
	private Double HostStarRadiusSlrRad;
	private Double HostStarMetallicity;
	private Double HostStarTempK;
	private Double HostStarAgeGyr;
	public Planet() {
		super();
	}
	public Planet(String planetIdentifier, Integer typeFlag, Double planetaryMassJpt, Double radiusJpt,
			Double periodDays, Double semiMajorAxisAU, Double eccentricity, Double periastronDeg, Double longitudeDeg,
			Double ascendingNodeDeg, Double inclinationDeg, Double surfaceTempK, Double ageGyr, String discoveryMethod,
			Integer discoveryYear, LocalDate lastUpdated, LocalTime rightAscension, String declination,
			Double distFromSunParsec, Double hostStarMassSlrMass, Double hostStarRadiusSlrRad,
			Double hostStarMetallicity, Double hostStarTempK, Double hostStarAgeGyr) {
		super();
		PlanetIdentifier = planetIdentifier;
		TypeFlag = typeFlag;
		PlanetaryMassJpt = planetaryMassJpt;
		RadiusJpt = radiusJpt;
		PeriodDays = periodDays;
		SemiMajorAxisAU = semiMajorAxisAU;
		Eccentricity = eccentricity;
		PeriastronDeg = periastronDeg;
		LongitudeDeg = longitudeDeg;
		AscendingNodeDeg = ascendingNodeDeg;
		InclinationDeg = inclinationDeg;
		SurfaceTempK = surfaceTempK;
		AgeGyr = ageGyr;
		DiscoveryMethod = discoveryMethod;
		DiscoveryYear = discoveryYear;
		LastUpdated = lastUpdated;
		RightAscension = rightAscension;
		Declination = declination;
		DistFromSunParsec = distFromSunParsec;
		HostStarMassSlrMass = hostStarMassSlrMass;
		HostStarRadiusSlrRad = hostStarRadiusSlrRad;
		HostStarMetallicity = hostStarMetallicity;
		HostStarTempK = hostStarTempK;
		HostStarAgeGyr = hostStarAgeGyr;
	}

	private Double parseToDouble(Object value) {
		if(value == null || value.toString().equals(""))
			return new Double(0);

		return Double.parseDouble(value.toString());
	}
	private Integer parseToInteger(Object value) {
		if(value == null || value.toString().equals(""))
			return 0;

		return Integer.parseInt(value.toString());
	}

	private LocalDate parseToLocalDate(Object value) {
		if(value == null || value.toString().equals(""))
			return null;

		return LocalDate.parse(value.toString(),DateTimeFormatter.ofPattern("yy/MM/dd"));
	}

	private LocalTime parseToLocalTime(Object value) {
		if(value == null || value.toString().equals(""))
			return null;

		try { return LocalTime.parse(value.toString(),DateTimeFormatter.
				ofPattern("HH mm ss.SSSSS")); 
		}catch(Exception e) { 
			try { 
				return LocalTime.parse(value.toString(),DateTimeFormatter.ofPattern("HH mm ss.SSSS")); 
			}catch(Exception ex) { 
				try { 
					return LocalTime.parse(value.toString(),DateTimeFormatter.
												ofPattern("HH mm ss.SS")); 
				}catch(Exception exec) { 
					try { 
						return LocalTime.parse(value.toString(),DateTimeFormatter.
																ofPattern("HH mm ss.S")); 
					}catch(Exception exception) { 
						try{
							return LocalTime.parse(value.toString(),DateTimeFormatter.
																			ofPattern("HH mm ss")); 
						}catch(Exception exception1) {
							return null;
										
						} 
					} 
				} 
			} 
		}
	}

	public Planet(JSONObject jsonObject) {
		this.PlanetIdentifier = (String) jsonObject.get("PlanetIdentifier");
		this.TypeFlag = parseToInteger(jsonObject.get("TypeFlag"));
		this.RadiusJpt =  parseToDouble(jsonObject.get("RadiusJpt"));
		this.Eccentricity = parseToDouble(jsonObject.get("Eccentricity"));
		this.AgeGyr = parseToDouble( jsonObject.get("AgeGyr"));
		this.InclinationDeg = parseToDouble( jsonObject.get("InclinationDeg"));
		this.DiscoveryMethod = (String) jsonObject.get("DiscoveryMethod");
		this.HostStarRadiusSlrRad = parseToDouble(jsonObject.get("HostStarRadiusSlrRad"));
		this.HostStarMetallicity = parseToDouble(jsonObject.get("HostStarMetallicity"));
		this.PeriodDays = parseToDouble(jsonObject.get("PeriodDays"));
		this.HostStarMassSlrMass = parseToDouble(jsonObject.get("HostStarMassSlrMass"));
		this.RightAscension = parseToLocalTime(jsonObject.get("RightAscension"));
		this.HostStarTempK = parseToDouble(jsonObject.get("HostStarTempK"));
		this.PlanetIdentifier = (String) jsonObject.get("PlanetIdentifier");
		this.SurfaceTempK = parseToDouble( jsonObject.get("SurfaceTempK"));
		this.PlanetaryMassJpt = parseToDouble(jsonObject.get("PlanetaryMassJpt"));
		this.PeriastronDeg = parseToDouble(jsonObject.get("PeriastronDeg"));
		this.LongitudeDeg = parseToDouble(jsonObject.get("LongitudeDeg"));
		this.DistFromSunParsec = parseToDouble(jsonObject.get("DistFromSunParsec"));
		this.HostStarAgeGyr = parseToDouble(jsonObject.get("HostStarAgeGyr"));
		this.AscendingNodeDeg = parseToDouble(jsonObject.get("AscendingNodeDeg"));
		this.DiscoveryYear = parseToInteger(jsonObject.get("DiscoveryYear"));
		this.Declination = (String) jsonObject.get("Declination");
		this.LastUpdated = parseToLocalDate(jsonObject.get("LastUpdated"));
		this.SemiMajorAxisAU = parseToDouble(jsonObject.get("SemiMajorAxisAU"));
	}

	public String getPlanetIdentifier() {
		return PlanetIdentifier;
	}
	public void setPlanetIdentifier(String planetIdentifier) {
		PlanetIdentifier = planetIdentifier;
	}
	public Integer getTypeFlag() {
		return TypeFlag;
	}
	public void setTypeFlag(Integer typeFlag) {
		TypeFlag = typeFlag;
	}
	public Double getPlanetaryMassJpt() {
		return PlanetaryMassJpt;
	}
	public void setPlanetaryMassJpt(Double planetaryMassJpt) {
		PlanetaryMassJpt = planetaryMassJpt;
	}
	public Double getRadiusJpt() {
		return RadiusJpt;
	}
	public void setRadiusJpt(Double radiusJpt) {
		RadiusJpt = radiusJpt;
	}
	public Double getPeriodDays() {
		return PeriodDays;
	}
	public void setPeriodDays(Double periodDays) {
		PeriodDays = periodDays;
	}
	public Double getSemiMajorAxisAU() {
		return SemiMajorAxisAU;
	}
	public void setSemiMajorAxisAU(Double semiMajorAxisAU) {
		SemiMajorAxisAU = semiMajorAxisAU;
	}
	public Double getEccentricity() {
		return Eccentricity;
	}
	public void setEccentricity(Double eccentricity) {
		Eccentricity = eccentricity;
	}
	public Double getPeriastronDeg() {
		return PeriastronDeg;
	}
	public void setPeriastronDeg(Double periastronDeg) {
		PeriastronDeg = periastronDeg;
	}
	public Double getLongitudeDeg() {
		return LongitudeDeg;
	}
	public void setLongitudeDeg(Double longitudeDeg) {
		LongitudeDeg = longitudeDeg;
	}
	public Double getAscendingNodeDeg() {
		return AscendingNodeDeg;
	}
	public void setAscendingNodeDeg(Double ascendingNodeDeg) {
		AscendingNodeDeg = ascendingNodeDeg;
	}
	public Double getInclinationDeg() {
		return InclinationDeg;
	}
	public void setInclinationDeg(Double inclinationDeg) {
		InclinationDeg = inclinationDeg;
	}
	public Double getSurfaceTempK() {
		return SurfaceTempK;
	}
	public void setSurfaceTempK(Double surfaceTempK) {
		SurfaceTempK = surfaceTempK;
	}
	public Double getAgeGyr() {
		return AgeGyr;
	}
	public void setAgeGyr(Double ageGyr) {
		AgeGyr = ageGyr;
	}
	public String getDiscoveryMethod() {
		return DiscoveryMethod;
	}
	public void setDiscoveryMethod(String discoveryMethod) {
		DiscoveryMethod = discoveryMethod;
	}
	public Integer getDiscoveryYear() {
		return DiscoveryYear;
	}
	public void setDiscoveryYear(Integer discoveryYear) {
		DiscoveryYear = discoveryYear;
	}
	public LocalDate getLastUpdated() {
		return LastUpdated;
	}
	public void setLastUpdated(LocalDate lastUpdated) {
		LastUpdated = lastUpdated;
	}
	public LocalTime getRightAscension() {
		return RightAscension;
	}
	public void setRightAscension(LocalTime rightAscension) {
		RightAscension = rightAscension;
	}
	public String getDeclination() {
		return Declination;
	}
	public void setDeclination(String declination) {
		Declination = declination;
	}
	public Double getDistFromSunParsec() {
		return DistFromSunParsec;
	}
	public void setDistFromSunParsec(Double distFromSunParsec) {
		DistFromSunParsec = distFromSunParsec;
	}
	public Double getHostStarMassSlrMass() {
		return HostStarMassSlrMass;
	}
	public void setHostStarMassSlrMass(Double hostStarMassSlrMass) {
		HostStarMassSlrMass = hostStarMassSlrMass;
	}
	public Double getHostStarRadiusSlrRad() {
		return HostStarRadiusSlrRad;
	}
	public void setHostStarRadiusSlrRad(Double hostStarRadiusSlrRad) {
		HostStarRadiusSlrRad = hostStarRadiusSlrRad;
	}
	public Double getHostStarMetallicity() {
		return HostStarMetallicity;
	}
	public void setHostStarMetallicity(Double hostStarMetallicity) {
		HostStarMetallicity = hostStarMetallicity;
	}
	public Double getHostStarTempK() {
		return HostStarTempK;
	}
	public void setHostStarTempK(Double hostStarTempK) {
		HostStarTempK = hostStarTempK;
	}
	public Double getHostStarAgeGyr() {
		return HostStarAgeGyr;
	}
	public void setHostStarAgeGyr(Double hostStarAgeGyr) {
		HostStarAgeGyr = hostStarAgeGyr;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((AgeGyr == null) ? 0 : AgeGyr.hashCode());
		result = prime * result + ((AscendingNodeDeg == null) ? 0 : AscendingNodeDeg.hashCode());
		result = prime * result + ((Declination == null) ? 0 : Declination.hashCode());
		result = prime * result + ((DiscoveryMethod == null) ? 0 : DiscoveryMethod.hashCode());
		result = prime * result + ((DiscoveryYear == null) ? 0 : DiscoveryYear.hashCode());
		result = prime * result + ((DistFromSunParsec == null) ? 0 : DistFromSunParsec.hashCode());
		result = prime * result + ((Eccentricity == null) ? 0 : Eccentricity.hashCode());
		result = prime * result + ((HostStarAgeGyr == null) ? 0 : HostStarAgeGyr.hashCode());
		result = prime * result + ((HostStarMassSlrMass == null) ? 0 : HostStarMassSlrMass.hashCode());
		result = prime * result + ((HostStarMetallicity == null) ? 0 : HostStarMetallicity.hashCode());
		result = prime * result + ((HostStarRadiusSlrRad == null) ? 0 : HostStarRadiusSlrRad.hashCode());
		result = prime * result + ((HostStarTempK == null) ? 0 : HostStarTempK.hashCode());
		result = prime * result + ((InclinationDeg == null) ? 0 : InclinationDeg.hashCode());
		result = prime * result + ((LastUpdated == null) ? 0 : LastUpdated.hashCode());
		result = prime * result + ((LongitudeDeg == null) ? 0 : LongitudeDeg.hashCode());
		result = prime * result + ((PeriastronDeg == null) ? 0 : PeriastronDeg.hashCode());
		result = prime * result + ((PeriodDays == null) ? 0 : PeriodDays.hashCode());
		result = prime * result + ((PlanetIdentifier == null) ? 0 : PlanetIdentifier.hashCode());
		result = prime * result + ((PlanetaryMassJpt == null) ? 0 : PlanetaryMassJpt.hashCode());
		result = prime * result + ((RadiusJpt == null) ? 0 : RadiusJpt.hashCode());
		result = prime * result + ((RightAscension == null) ? 0 : RightAscension.hashCode());
		result = prime * result + ((SemiMajorAxisAU == null) ? 0 : SemiMajorAxisAU.hashCode());
		result = prime * result + ((SurfaceTempK == null) ? 0 : SurfaceTempK.hashCode());
		result = prime * result + ((TypeFlag == null) ? 0 : TypeFlag.hashCode());
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
		Planet other = (Planet) obj;
		if (AgeGyr == null) {
			if (other.AgeGyr != null)
				return false;
		} else if (!AgeGyr.equals(other.AgeGyr))
			return false;
		if (AscendingNodeDeg == null) {
			if (other.AscendingNodeDeg != null)
				return false;
		} else if (!AscendingNodeDeg.equals(other.AscendingNodeDeg))
			return false;
		if (Declination == null) {
			if (other.Declination != null)
				return false;
		} else if (!Declination.equals(other.Declination))
			return false;
		if (DiscoveryMethod == null) {
			if (other.DiscoveryMethod != null)
				return false;
		} else if (!DiscoveryMethod.equals(other.DiscoveryMethod))
			return false;
		if (DiscoveryYear == null) {
			if (other.DiscoveryYear != null)
				return false;
		} else if (!DiscoveryYear.equals(other.DiscoveryYear))
			return false;
		if (DistFromSunParsec == null) {
			if (other.DistFromSunParsec != null)
				return false;
		} else if (!DistFromSunParsec.equals(other.DistFromSunParsec))
			return false;
		if (Eccentricity == null) {
			if (other.Eccentricity != null)
				return false;
		} else if (!Eccentricity.equals(other.Eccentricity))
			return false;
		if (HostStarAgeGyr == null) {
			if (other.HostStarAgeGyr != null)
				return false;
		} else if (!HostStarAgeGyr.equals(other.HostStarAgeGyr))
			return false;
		if (HostStarMassSlrMass == null) {
			if (other.HostStarMassSlrMass != null)
				return false;
		} else if (!HostStarMassSlrMass.equals(other.HostStarMassSlrMass))
			return false;
		if (HostStarMetallicity == null) {
			if (other.HostStarMetallicity != null)
				return false;
		} else if (!HostStarMetallicity.equals(other.HostStarMetallicity))
			return false;
		if (HostStarRadiusSlrRad == null) {
			if (other.HostStarRadiusSlrRad != null)
				return false;
		} else if (!HostStarRadiusSlrRad.equals(other.HostStarRadiusSlrRad))
			return false;
		if (HostStarTempK == null) {
			if (other.HostStarTempK != null)
				return false;
		} else if (!HostStarTempK.equals(other.HostStarTempK))
			return false;
		if (InclinationDeg == null) {
			if (other.InclinationDeg != null)
				return false;
		} else if (!InclinationDeg.equals(other.InclinationDeg))
			return false;
		if (LastUpdated == null) {
			if (other.LastUpdated != null)
				return false;
		} else if (!LastUpdated.equals(other.LastUpdated))
			return false;
		if (LongitudeDeg == null) {
			if (other.LongitudeDeg != null)
				return false;
		} else if (!LongitudeDeg.equals(other.LongitudeDeg))
			return false;
		if (PeriastronDeg == null) {
			if (other.PeriastronDeg != null)
				return false;
		} else if (!PeriastronDeg.equals(other.PeriastronDeg))
			return false;
		if (PeriodDays == null) {
			if (other.PeriodDays != null)
				return false;
		} else if (!PeriodDays.equals(other.PeriodDays))
			return false;
		if (PlanetIdentifier == null) {
			if (other.PlanetIdentifier != null)
				return false;
		} else if (!PlanetIdentifier.equals(other.PlanetIdentifier))
			return false;
		if (PlanetaryMassJpt == null) {
			if (other.PlanetaryMassJpt != null)
				return false;
		} else if (!PlanetaryMassJpt.equals(other.PlanetaryMassJpt))
			return false;
		if (RadiusJpt == null) {
			if (other.RadiusJpt != null)
				return false;
		} else if (!RadiusJpt.equals(other.RadiusJpt))
			return false;
		if (RightAscension == null) {
			if (other.RightAscension != null)
				return false;
		} else if (!RightAscension.equals(other.RightAscension))
			return false;
		if (SemiMajorAxisAU == null) {
			if (other.SemiMajorAxisAU != null)
				return false;
		} else if (!SemiMajorAxisAU.equals(other.SemiMajorAxisAU))
			return false;
		if (SurfaceTempK == null) {
			if (other.SurfaceTempK != null)
				return false;
		} else if (!SurfaceTempK.equals(other.SurfaceTempK))
			return false;
		if (TypeFlag == null) {
			if (other.TypeFlag != null)
				return false;
		} else if (!TypeFlag.equals(other.TypeFlag))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Planet [PlanetIdentifier=" + PlanetIdentifier + ", TypeFlag=" + TypeFlag + ", PlanetaryMassJpt="
				+ PlanetaryMassJpt + ", RadiusJpt=" + RadiusJpt + ", PeriodDays=" + PeriodDays + ", SemiMajorAxisAU="
				+ SemiMajorAxisAU + ", Eccentricity=" + Eccentricity + ", PeriastronDeg=" + PeriastronDeg
				+ ", LongitudeDeg=" + LongitudeDeg + ", AscendingNodeDeg=" + AscendingNodeDeg + ", InclinationDeg="
				+ InclinationDeg + ", SurfaceTempK=" + SurfaceTempK + ", AgeGyr=" + AgeGyr + ", DiscoveryMethod="
				+ DiscoveryMethod + ", DiscoveryYear=" + DiscoveryYear + ", LastUpdated=" + LastUpdated
				+ ", RightAscension=" + RightAscension + ", Declination=" + Declination + ", DistFromSunParsec="
				+ DistFromSunParsec + ", HostStarMassSlrMass=" + HostStarMassSlrMass + ", HostStarRadiusSlrRad="
				+ HostStarRadiusSlrRad + ", HostStarMetallicity=" + HostStarMetallicity + ", HostStarTempK="
				+ HostStarTempK + ", HostStarAgeGyr=" + HostStarAgeGyr + "]";
	}
}
