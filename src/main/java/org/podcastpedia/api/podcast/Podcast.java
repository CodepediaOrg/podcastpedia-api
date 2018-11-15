package org.podcastpedia.api.podcast;

/**
 * Created by ama on 15.11.18.
 */
public class Podcast {

    private String identifier;

    public Podcast(String identifier) {
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return identifier;
    }
}
