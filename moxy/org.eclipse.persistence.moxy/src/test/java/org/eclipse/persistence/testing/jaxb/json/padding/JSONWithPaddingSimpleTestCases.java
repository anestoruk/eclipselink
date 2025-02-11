/*
 * Copyright (c) 2012, 2021 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0,
 * or the Eclipse Distribution License v. 1.0 which is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * SPDX-License-Identifier: EPL-2.0 OR BSD-3-Clause
 */

// Contributors:
//     Denise Smith - November 2012
package org.eclipse.persistence.testing.jaxb.json.padding;

import org.eclipse.persistence.oxm.JSONWithPadding;
import org.eclipse.persistence.testing.jaxb.JAXBWithJSONTestCases;
import org.eclipse.persistence.testing.jaxb.json.JSONMarshalUnmarshalTestCases;
import org.eclipse.persistence.testing.jaxb.json.numbers.NumberHolder;

public class JSONWithPaddingSimpleTestCases extends JAXBWithJSONTestCases{

    private final static String JSON_RESOURCE = "org/eclipse/persistence/testing/jaxb/json/padding/padding.json";
    private final static String JSON_FORMATTED_RESOURCE = "org/eclipse/persistence/testing/jaxb/json/padding/paddingFormatted.json";
    private final static String XML_RESOURCE = "org/eclipse/persistence/testing/jaxb/json/padding/padding.xml";

    public JSONWithPaddingSimpleTestCases(String name) throws Exception {
        super(name);
        setClasses(new Class<?>[]{Simple.class});
        setControlJSON(JSON_RESOURCE);
        setControlDocument(XML_RESOURCE);
        setWriteControlFormattedJSON(JSON_FORMATTED_RESOURCE);
    }

    @Override
    protected Object getControlObject() {
        Simple sample = new Simple();
        sample.id = "1111";
        sample.name = "theName";

        JSONWithPadding test = new JSONWithPadding(sample, "blah");
        return test;
    }

    @Override
    public boolean shouldRemoveWhitespaceFromControlDocJSON(){
        return false;
    }

    @Override
    public boolean isUnmarshalTest (){
        return false;
    }

    @Override
    public void testJSONMarshalToBuilderResult() throws Exception{
    }

    @Override
    public void testJSONMarshalToGeneratorResult() throws Exception{
    }

}
