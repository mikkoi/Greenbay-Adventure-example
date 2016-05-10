package com.greenbayadventure.sites.rest;

import java.util.ArrayList;

/**
 * Build a list of all sites.
 */
public final class Sites {

    /**
     * All sites that will be returned.
     */
    private final ArrayList<Site> sites = new ArrayList<Site>();

    /**
     * constructor.
     * @param sites - The sites that you want to retrieve.
     */
    public Sites(final ArrayList<Site> sites) {
        sites.clear();
        this.sites.addAll(sites);
    }

    /**
     * Get all sites.
     *
     * @return sites
     */
    public ArrayList<Site> getSites() {
        return sites;
    }

}
