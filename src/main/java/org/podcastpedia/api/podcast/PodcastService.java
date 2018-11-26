package org.podcastpedia.api.podcast;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    @HystrixCommand(fallbackMethod = "reliableGetAllPodcasts")
    public List<Podcast> getAllPodcasts() {
        return podcastRepository.findAll();
    }

    public List<Podcast> reliableGetAllPodcasts() {
        Podcast podcast = new Podcast("Mock-podcast-1");
        Podcast podcast2 = new Podcast("Mock-podcast-2");
        List<Podcast> reliablePodcasts = new ArrayList<>();
        reliablePodcasts.add(podcast);
        reliablePodcasts.add(podcast2);

        return reliablePodcasts;
    }
}
