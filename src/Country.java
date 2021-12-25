public class Country {
    public String country;
    public String region;
    public Integer happinessRank;
    public Float happinessScore;
    public Float standardError;
    public Float economy;
    public Float family;
    public Float health;
    public Float freedom;
    public Float trust;
    public Float generosity;
    public Float dystopiaResidual;

    public Country(String country, String region, Integer happinessRank, Float happinessScore,
                   Float standardError, Float economy, Float family, Float health, Float freedom,
                   Float trust, Float generosity, Float dystopiaResidual) {
        this.country = country;
        this.region = region;
        this.happinessRank = happinessRank;
        this.happinessScore = happinessScore;
        this.standardError = standardError;
        this.economy = economy;
        this.family = family;
        this.health = health;
        this.freedom = freedom;
        this.trust = trust;
        this.generosity = generosity;
        this.dystopiaResidual = dystopiaResidual;
    }

    @Override
    public String toString() {
        return country + " " + region + " " + happinessRank + " " + standardError + " " + economy +
                " " + family + " " + health + " " + freedom + " " + trust + " " + generosity + " " + dystopiaResidual;
    }
}