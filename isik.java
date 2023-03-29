class isik {
    private String nimi;
    private int vanus;
    private boolean meeldibKokataJaKoristada;
    private String muusikamaitse;
    private boolean kasMüsliOnSupp;
    private boolean meeldivadPikadJalutuskäigudRannas;
    private boolean kasAnanassPitsal;
    private String lemmiknumber;

    public isik(String nimi,
                int vanus,
                boolean meeldibKokataJaKoristada,
                String muusikamaitse,
                boolean kasMüsliOnSupp,
                boolean meeldivadPikadJalutuskäigudRannas,
                boolean kasAnanassPitsal,
                String lemmiknumber) {
        this.nimi = nimi;
        this.vanus = vanus;
        this.meeldibKokataJaKoristada = meeldibKokataJaKoristada;
        this.muusikamaitse = muusikamaitse;
        this.kasMüsliOnSupp = kasMüsliOnSupp;
        this.meeldivadPikadJalutuskäigudRannas = meeldivadPikadJalutuskäigudRannas;
        this.kasAnanassPitsal = kasAnanassPitsal;
        this.lemmiknumber = lemmiknumber;
    }
}