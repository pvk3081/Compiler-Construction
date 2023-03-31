public class ArgdecList implements Token {

    ArgDec ad;
    ArgdecList ads;
    public ArgdecList(ArgDec ad, ArgdecList ads){
        this.ad = ad;
        this.ads = ads;
    }

    public ArgdecList(ArgDec ad){
        this.ad = ad;
        this.ads = null;
    }

    public String toString(int t){
        if (ad == null && ads == null)
            return "";
        return ad.toString(t) + (ads == null ? "" : ", " + ads.toString(t));
    }

}
