package com.crio.shorturl;

import java.util.*;

public class XUrlImpl implements XUrl {
    Map<String, String> shortToLongMapping;
    Map<String, String> longToShortMapping;
    Map<String, Integer> hitCountMap;

    SlugGenerator slugGenerator;
    
    private static final String URL = "http://short.url/";

    public XUrlImpl(){
        shortToLongMapping = new HashMap<>();
        longToShortMapping = new HashMap<>();
        slugGenerator = new SlugGenerator();
        hitCountMap = new HashMap<>();
    }



    @Override
    public String registerNewUrl(String longUrl) {
        // if longUrl present in longToShortMapping - return URL + longUrl
        if(longToShortMapping.containsKey(longUrl)){
            return URL + longToShortMapping.get(longUrl);
        }
        // not present
        // create a new slug
        // map longUrl with slug
        // map slug with longUrl
        // return URL + slug
        String slug = slugGenerator.generateRandomSlug();
        longToShortMapping.put(longUrl, slug);
        shortToLongMapping.put(slug, longUrl);
        hitCountMap.put(longUrl, 0);
        return URL + slug;
    }

    @Override
    public String registerNewUrl(String longUrl, String shortUrl) {
        String slug = shortUrl.replace(URL, "");
        if(shortToLongMapping.containsKey(URL)){
            return null;
        }
        shortToLongMapping.put(slug, longUrl);
        longToShortMapping.put(longUrl, slug);
        hitCountMap.put(longUrl,0);
        return URL + slug;
    }

    @Override
    public String getUrl(String shortUrl) {
        String longUrl = shortToLongMapping.get(shortUrl.replace(URL, ""));
        if(longUrl != null){
            hitCountMap.compute(longUrl, (k,v) -> v + 1);
 
        }
        return longUrl;
    }

    @Override
    public Integer getHitCount(String longUrl) {
        return hitCountMap.getOrDefault(longUrl, 0);
    }

    @Override
    public String delete(String longUrl) {
        String slug = longToShortMapping.remove(longUrl);
        shortToLongMapping.remove(slug);
        return URL + slug;
    }
    
}