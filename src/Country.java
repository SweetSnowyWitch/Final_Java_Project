public class Country {
    private final String country;
    private final String region;
    private final Integer happinessRank;
    private final Float happinessScore;
    private final Float standardError;
    private final Float economy;
    private final Float family;
    private final Float health;
    private final Float freedom;
    private final Float trust;
    private final Float generosity;
    private final Float dystopiaResidual;

    public Country(String country, String region, Integer happinessRank, Float happinessScore,
                   Float standardError,Float economy, Float family, Float health, Float freedom,
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

    public String getCountry() {
        return country;
    }

    public String getRegion() {
        return region;
    }

    public Integer getHappinessRank() {
        return happinessRank;
    }

    public Float getHappinessScore() {
        return happinessScore;
    }

    public Float getStandardError() {
        return standardError;
    }

    public Float getEconomy() {
        return economy;
    }

    public Float getFamily() {
        return family;
    }

    public Float getHealth() {
        return health;
    }

    public Float getFreedom() {
        return freedom;
    }

    public Float getTrust() {
        return trust;
    }

    public Float getGenerosity() {
        return generosity;
    }

    public Float getDystopiaResidual() {
        return dystopiaResidual;
    }
}
