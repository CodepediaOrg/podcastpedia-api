package org.podcastpedia.api.podcast;

/**
 * Created by ama on 15.11.18.
 */
public class PodcastService {

    private PodcastRepository podcastRepository;

    public PodcastService(PodcastRepository podcastRepository) {
        this.podcastRepository = podcastRepository;
    }

    public Podcast getPodcastDetails(String identifier){
        final Podcast podcast = podcastRepository.findByIdentifier(identifier);
        if(podcast == null){
            throw new PodcastNotFoundException();
        }

        return podcast;
    }
}
