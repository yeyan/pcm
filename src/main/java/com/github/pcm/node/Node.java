package com.github.pcm.node;

import org.neo4j.graphdb.Direction;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

import java.nio.file.Path;
import java.util.Set;

/**
 * Created by Ye Yan on 3/11/2015.
 */

@NodeEntity
public class Node {

    @GraphId
    protected Long id;
    protected String name;
    protected Path path;

    @RelatedTo(type = "TAGS", direction = Direction.BOTH)
    protected Set<Tag> tags;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }
}
