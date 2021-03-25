package com.song.api;

import java.net.URI;
import java.util.ArrayList;

public class TVShow {
    private String name;
    private ArrayList<URI> sourceArrayList;

    public TVShow(String name, URI uri) {
        this.name = name;
        setSourceArrayList(new ArrayList<URI>());
        getSourceArrayList().add(uri);
    }

    public TVShow(String name, ArrayList<URI> sourceArrayList) {
        this.name = name;
        this.sourceArrayList = sourceArrayList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<URI> getSourceArrayList() {
        return sourceArrayList;
    }

    public void setSourceArrayList(ArrayList<URI> sourceArrayList) {
        this.sourceArrayList = sourceArrayList;
    }
}