package com.github.pcm.node;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;

/**
 * Created by Ye Yan on 3/11/2015.
 */

@NodeEntity
public class Tag {

    @GraphId
    protected Long id;
    protected String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
