package me.antoniocaccamo.player.rx.service;

import me.antoniocaccamo.player.rx.model.resource.Resource;

import java.util.Map;
import java.util.Optional;

public interface ResourceService {

    Map<String, Resource> getResourceMap();

    Iterable<Resource> getResources();

    Optional<Resource> getResourceByHash(String resourceHash);

    Resource save(Resource resource);

}
