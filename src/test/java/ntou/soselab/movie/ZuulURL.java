package ntou.soselab.movie;


public class ZuulURL {
    static String getURL() {
        return System.getenv("ZUUL_URL");
    }
}
