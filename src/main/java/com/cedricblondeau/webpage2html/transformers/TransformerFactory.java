package com.cedricblondeau.webpage2html.transformers;

import com.cedricblondeau.webpage2html.http.resource.IHttpResource;
import com.cedricblondeau.webpage2html.transformers.assets.BaseTransformer;
import com.cedricblondeau.webpage2html.transformers.assets.CssTransformer;
import com.cedricblondeau.webpage2html.transformers.assets.ITransformer;

public class TransformerFactory {

    /**
     * @param httpResource
     * @return ITransformer
     */
    public ITransformer get(IHttpResource httpResource) {
        try {
            switch (httpResource.getMediaType()) {
                case "text/css":
                    return new CssTransformer(httpResource.getContent(), httpResource.getUrl());
                default:
                    BaseTransformer baseTransformer = new BaseTransformer(httpResource.getMediaType());
                    baseTransformer.setData(httpResource.getData());
                    return baseTransformer;
            }
        } catch (NullPointerException e) {
            return null;
        }
    }

}