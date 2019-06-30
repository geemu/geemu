package com.chenfangming.gateway.config;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;

/**
 * com.chenfangming.gateway.config
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-06-29 19:38
 */
public class MyFilter extends ZuulFilter {
    /**
     * a "true" return from this method means that the run() method should be invoked
     * @return true if the run() method should be invoked. false will not invoke the run() method
     */
    @Override
    public boolean shouldFilter() {
        return false;
    }

    /**
     * if shouldFilter() is true, this method will be invoked. this method is the core method of a ZuulFilter
     * @return Some arbitrary artifact may be returned. Current implementation ignores it.
     * @throws ZuulException if an error occurs during execution.
     */
    @Override
    public Object run() throws ZuulException {
        return null;
    }

    /**
     * to classify a filter by type. Standard types in Zuul are "pre" for pre-routing filtering,
     * "route" for routing to an origin, "post" for post-routing filters, "error" for error handling.
     * We also support a "static" type for static responses see  StaticResponseFilter.
     * Any filterType made be created or added and run by calling FilterProcessor.runFilters(type)
     * @return A String representing that type
     */
    @Override
    public String filterType() {
        return null;
    }

    /**
     * filterOrder() must also be defined for a filter. Filters may have the same  filterOrder if precedence is not
     * important for a filter. filterOrders do not need to be sequential.
     * @return the int order of a filter
     */
    @Override
    public int filterOrder() {
        return 0;
    }
}
