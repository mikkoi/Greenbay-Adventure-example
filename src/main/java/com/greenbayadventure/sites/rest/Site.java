package com.greenbayadventure.sites.rest;

/**
 * A Sporting site.
 */
public final class Site {

    /**
     * Unique identifier.
     */
    private int id;
    /**
     * Name.
     */
    private String name;
    /**
     * Author of this version (i.e. last action to this site.
     */
    private String author;
    /**
     * Current version of this data, i.e. site.
     */
    private int version;

    /**
     * Constructor.
     *
     * @param id         - id.
     * @param name       - name.
     * @param author     - author.
     * @param version    - version.
     */
    public Site(
            final int id,
            final String name,
            final String author,
            final int version
    ) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.version = version;
    }

    /**
     * Constructor.
     */
    public Site() { }

    /**
     * Getter.
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Getter.
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Getter.
     *
     * @return author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Getter.
     *
     * @return version
     */
    public int getVersion() {
        return version;
    }

    /**
     * Setter.
     *
     * @param id - id.
     */
    public void setId(final int id) {
        this.id = id;
    }

    /**
     * Setter.
     *
     * @param name - name.
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * Setter.
     *
     * @param author - author.
     */
    public void setAuthor(final String author) {
        this.author = author;
    }

    /**
     * Setter.
     *
     * @param version - version.
     */
    public void setVersion(final int version) {
        this.version = version;
    }
}
