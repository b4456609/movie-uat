package ntou.soselab.movie.config;


public class ZuulURL {
    static String getURL() {
        return System.getenv("ZUUL_URL");
    }
}
