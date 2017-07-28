package tech.saltyegg.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class EncodeAndDecodeTinyURL {

    private final Random rand = new Random();
    private final String x = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    private Map<String, String> encodeMap = new HashMap<>();
    private Map<String, String> decodeMap = new HashMap<>();

    private final String baseUrl = "http://tinyurl.com/";

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if (encodeMap.containsKey(longUrl)) {
            return encodeMap.get(longUrl);
        }

        String tinyPart = getRandomString(6);
        while (decodeMap.containsKey(tinyPart)) {
            tinyPart = getRandomString(6);
        }
        String result = baseUrl + tinyPart;
        encodeMap.put(longUrl, result);
        decodeMap.put(result, longUrl);
        return result;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return decodeMap.get(shortUrl);
    }

    private String getRandomString(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(x.charAt(rand.nextInt(x.length())));
        }
        return sb.toString();
    }
}
