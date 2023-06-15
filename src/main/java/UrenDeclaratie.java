class UrenDeclaratie {
    private int uren;
    private double uurtarief;
    public Medewerker medewerker;

    public UrenDeclaratie(int uren, Medewerker medewerker) {
        this.uren = uren;
        this.uurtarief = medewerker.getUurTarief();
        this.medewerker = medewerker;
    }

    public int getUren() {
        return uren;
    }

    public double getUurtarief() {
        return uurtarief;
    }
}