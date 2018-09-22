/**
 * Copyright (c) 2015 hzhou, All rights reserved.
 */
package tech.saltyegg.dp.chain;

/**
 * Description:
 *
 * @author hzhou
 */
public class Women implements IWomen {

    private RequestType type;
    private String request;

    public Women(RequestType type, String request) {
        this.type = type;
        this.request = request;
    }

    public RequestType getType() {
        return this.type;
    }

    public String getRequest() {
        return this.request;
    }
}