/******************************************************************
 * File:        RDFSBRuleReasonerFactory.java
 * Created by:  Dave Reynolds
 * Created on:  12-May-2003
 * 
 * (c) Copyright 2003, Hewlett-Packard Company, all rights reserved.
 * [See end of file]
 * $Id: RDFSBRuleReasonerFactory.java,v 1.1 2003-05-12 15:20:23 der Exp $
 *****************************************************************/
package com.hp.hpl.jena.reasoner.rulesys;

import com.hp.hpl.jena.reasoner.*;
import com.hp.hpl.jena.rdf.model.*;
import com.hp.hpl.jena.vocabulary.*;

/**
 * Factory class for creating blank instances of the backchaining RDFS reasoner. 
 * @author <a href="mailto:der@hplb.hpl.hp.com">Dave Reynolds</a>
 * @version $Revision: 1.1 $ on $Date: 2003-05-12 15:20:23 $
 */
public class RDFSBRuleReasonerFactory implements ReasonerFactory {
    
    /** Single global instance of this factory */
    private static ReasonerFactory theInstance = new RDFSBRuleReasonerFactory();
    
    /** Static URI for this reasoner type */
    public static final String URI = "http://www.hpl.hp.com/semweb/2003/RDFSBRuleReasoner";
    
    /**
     * Return the single global instance of this factory
     */
    public static ReasonerFactory theInstance() {
        return theInstance;
    }
    
    /**
     * Constructor method that builds an instance of the associated Reasoner
     * @param configuration a set of arbitrary configuration information to be 
     * passed the reasoner encoded within an RDF graph, the current implemenation
     * is not configurable and will ignore this parameter.
     */
    public Reasoner create(Model configuration) {
        return new RDFSRuleReasoner();
    }
   
    /**
     * Return a description of the capabilities of this reasoner encoded in
     * RDF. This method is normally called by the ReasonerRegistry which caches
     * the resulting information so dynamically creating here is not really an overhead.
     */
    public Model getCapabilities() {
        Model capabilities = ModelFactory.createDefaultModel();
        Resource base = capabilities.createResource(getURI());
        base.addProperty(ReasonerRegistry.nameP, "RDFS BRule Reasoner")
            .addProperty(ReasonerRegistry.descriptionP, "Complete RDFS implementation supporting metalevel statements.\n"
                                        + "Can separate tbox and abox data if desired to reuse tbox caching or mix them.")
            .addProperty(ReasonerRegistry.supportsP, RDFS.subClassOf)
            .addProperty(ReasonerRegistry.supportsP, RDFS.subPropertyOf)
            .addProperty(ReasonerRegistry.supportsP, RDFS.member)
            .addProperty(ReasonerRegistry.supportsP, RDFS.range)
            .addProperty(ReasonerRegistry.supportsP, RDFS.domain)
            .addProperty(ReasonerRegistry.versionP, "0.1");
        return capabilities;
    }
    
    /**
     * Return the URI labelling this type of reasoner
     */
    public String getURI() {
        return URI;
    }

}


/*
    (c) Copyright Hewlett-Packard Company 2003
    All rights reserved.

    Redistribution and use in source and binary forms, with or without
    modification, are permitted provided that the following conditions
    are met:

    1. Redistributions of source code must retain the above copyright
       notice, this list of conditions and the following disclaimer.

    2. Redistributions in binary form must reproduce the above copyright
       notice, this list of conditions and the following disclaimer in the
       documentation and/or other materials provided with the distribution.

    3. The name of the author may not be used to endorse or promote products
       derived from this software without specific prior written permission.

    THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
    IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
    OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
    IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
    INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
    NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
    DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
    THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
    (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
    THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/