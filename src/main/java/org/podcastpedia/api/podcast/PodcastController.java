package org.podcastpedia.api.podcast;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ama on 15.11.18.
 */
@RestController
public class PodcastController {

    private PodcastService podcastService;

    public PodcastController(PodcastService podcastService) {
        this.podcastService = podcastService;
    }

    @GetMapping("/podcasts/{identifier}")
    private Podcast getPodcast(@PathVariable String identifier) {
        return podcastService.getPodcastDetails(identifier);
    }
}

