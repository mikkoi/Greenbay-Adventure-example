package com.greenbayadventure.sites.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * Control REST endpoint.
 */
@RestController
@RequestMapping("/api/1/sites")
public class SitesController {

    /** Logger. */
    private final Logger logger
            = LoggerFactory.getLogger(SitesController.class);

    /**
     * All sites that will be returned.
     * This is just a temp list for demo purpose.
     * TODO Get rid of this. Use database!
     */
    private final ArrayList<Site> sitesList = new ArrayList<Site>();

    /**
     * sites mapping - get sites.
     * @param page - The page that you want to retrieve.
     * @param perPage - The amount of items that will be retrieved per page.
     * @return Sites - All sites on the server, paged as requested.
     */
    @RequestMapping(
            //path = ".json",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody public final Sites sitesGET(
            @RequestParam(value = "page", defaultValue = "1")
            final int page,
            @RequestParam(value = "per_page", defaultValue = "30")
            final int perPage) {
        logger.debug("Entering function {}().", "sitesGET");
        return new Sites(sitesList);
    }

    /**
     * sites mapping - create a site.
     * @param site - A new site object.
     *
     * @return Site - A new site object with the right siteId.
     */
    @RequestMapping(
            path = "/new.json",
            method = RequestMethod.POST,
            consumes = "application/json",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    @ResponseBody public final
    Site sitePOST(
            @RequestBody final Site site
    ) {
        // TODO Fix this to accept only json like: {site: {...}}
        logger.debug("Entering function {}().", "sitePOST");
        final int siteIdNew = sitesList.size() + 1;
        final Site siteNew = new Site();
        siteNew.setId(siteIdNew);
        siteNew.setName(site.getName());
        siteNew.setAuthor("GreenbayAdventureAPI");
        // TODO Replace with username from service.
        siteNew.setVersion(1);
        sitesList.add(siteNew);
        logger.debug("{}(). Added new site", "sitePOST");
        return siteNew;
    }

    /**
     * site mapping.
     * @param siteId - The page that you want to retrieve.
     * @return Site - The requested site on the server.
     * @throws ResourceNotFoundException - Exception
     */
    @RequestMapping(
            path = "/{siteId}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody public final Site siteGET(
            @PathVariable final String siteId
    ) throws ResourceNotFoundException {
        logger.debug("Entering function {}().", "siteGET");
        for (Site site : sitesList) {
            if (site.getId() == Integer.parseInt(siteId)) {
                return site;
            }
        }
        throw new ResourceNotFoundException("Requested site not found!");
    }

    /**
     * site mapping.
     * @param siteId - The page that you want to retrieve.
     * @return Site - The requested site on the server.
     * @throws ResourceNotFoundException - Exception
     */
    @RequestMapping(path = "/{siteId}",
            method = RequestMethod.PUT,
            consumes = "application/json")
    public final Site sitePUT(
            @PathVariable final String siteId
    ) throws ResourceNotFoundException {
        logger.debug("Entering function {}().", "sitePUT");
        for (Site site : sitesList) {
            if (site.getId() == Integer.parseInt(siteId)) {
                return site;
            }
        }
        throw new ResourceNotFoundException("Requested site not found!");
    }

}
