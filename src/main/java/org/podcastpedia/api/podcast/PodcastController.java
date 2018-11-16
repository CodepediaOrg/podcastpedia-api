package org.podcastpedia.api.podcast;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    private void podcastNotFoundHandler(PodcastNotFoundException ex){}
}

