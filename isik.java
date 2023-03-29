class isik {
    private String nimi;
    private int vanus;
    private boolean meeldibKokataJaKoristada;
    private String muusikamaitse;
    private boolean kasMüsliOnSupp;
    private int raudVõiSulg;
    private boolean meeldivadPikadJalutuskäigudRannas;
    private boolean kasAnanassPitsal;
    private String lemmiknumber; //tere

    public isik(String nimi,
                int vanus,
                boolean meeldibKokataJaKoristada,
                String muusikamaitse,
                boolean kasMüsliOnSupp,
                int raudVõiSulg,
                boolean meeldivadPikadJalutuskäigudRannas,
                boolean kasAnanassPitsal,
                String lemmiknumber) {
        this.nimi = nimi;
        this.vanus = vanus;
        this.meeldibKokataJaKoristada = meeldibKokataJaKoristada;
        this.muusikamaitse = muusikamaitse;
        this.kasMüsliOnSupp = kasMüsliOnSupp;
        this.raudVõiSulg = raudVõiSulg;
        this.meeldivadPikadJalutuskäigudRannas = meeldivadPikadJalutuskäigudRannas;
        this.kasAnanassPitsal = kasAnanassPitsal;
        this.lemmiknumber = lemmiknumber;
    }

    public String getNimi() {
        return nimi;
    }

    public int getVanus() {
        return vanus;
    }

    public boolean isMeeldibKokataJaKoristada() {
        return meeldibKokataJaKoristada;
    }

    public String getMuusikamaitse() {
        return muusikamaitse;
    }

    public boolean isKasMüsliOnSupp() {
        return kasMüsliOnSupp;
    }

    public int getRaudVõiSulg() {return raudVõiSulg;}

    public boolean isMeeldivadPikadJalutuskäigudRannas() {
        return meeldivadPikadJalutuskäigudRannas;
    }

    public boolean isKasAnanassPitsal() {
        return kasAnanassPitsal;
    }

    public String getLemmiknumber() {
        return lemmiknumber;
    }

    @Override
    public String toString() {
        return nimi + ", kes on " + vanus + "aastat vana";
    }
}