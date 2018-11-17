package org.podcastpedia.api.podcast;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by ama on 15.11.18.
 */
@Entity
public class Podcast {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String identifier;

    public Podcast() {}

    public Podcast(String identifier) {
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return identifier;
    }
}
