package org.podcastpedia.api.podcast;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Created by ama on 15.11.18.
 */
@Service
public class PodcastService {

    private PodcastRepository podcastRepository;

    public PodcastService(PodcastRepository podcastRepository) {
        this.podcastRepository = podcastRepository;
    }

    @Cacheable("podcasts")
    public Podcast getPodcastDetails(String identifier){
        final Podcast podcast = podcastRepository.findByIdentifier(identifier);
        if(podcast == null){
            throw new PodcastNotFoundException();
        }

        return podcast;
    }
}
