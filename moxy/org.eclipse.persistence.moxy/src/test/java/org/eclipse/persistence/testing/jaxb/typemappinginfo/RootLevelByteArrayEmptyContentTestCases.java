/*
 * Copyright (c) 1998, 2021 Oracle and/or its affiliates. All rights reserved.
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
//     Matt MacIvor -  January, 2010
package org.eclipse.persistence.testing.jaxb.typemappinginfo;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;
import javax.xml.transform.stream.StreamSource;

import org.eclipse.persistence.jaxb.TypeMappingInfo;
import org.eclipse.persistence.jaxb.TypeMappingInfo.ElementScope;
import org.w3c.dom.Document;

public class RootLevelByteArrayEmptyContentTestCases extends TypeMappingInfoWithJSONTestCases {
    protected final static String XML_RESOURCE = "org/eclipse/persistence/testing/jaxb/typemappinginfo/byteArrayEmptyNoAttachement.xml";
    protected final static String JSON_RESOURCE = "org/eclipse/persistence/testing/jaxb/typemappinginfo/byteArrayEmptyNoAttachement.json";

    public RootLevelByteArrayEmptyContentTestCases(String name) throws Exception {
        super(name);
        init();
    }

    public void init() throws Exception {
        setControlDocument(XML_RESOURCE);
        setControlJSON(JSON_RESOURCE);
        setupParser();

        setTypeMappingInfos(getTypeMappingInfos());
    }

    protected TypeMappingInfo[] getTypeMappingInfos()throws Exception {
        if(typeMappingInfos == null) {
            typeMappingInfos = new TypeMappingInfo[1];
            TypeMappingInfo tpi = new TypeMappingInfo();
            tpi.setXmlTagName(new QName("someUri","testTagname"));
            tpi.setElementScope(ElementScope.Global);

            tpi.setType(byte[].class);
            typeMappingInfos[0] = tpi;
        }
        return typeMappingInfos;
    }

    @Override
    protected Object getControlObject() {

        QName qname = new QName("someUri", "testTagName");
        JAXBElement jaxbElement = new JAXBElement(qname, byte[].class, new byte[0]);

        return jaxbElement;
    }

    protected String getNoXsiTypeControlResourceName() {
        return XML_RESOURCE;
    }


    @Override
    public Map<String, InputStream> getControlSchemaFiles(){
        InputStream instream = ClassLoader.getSystemResourceAsStream("org/eclipse/persistence/testing/jaxb/typemappinginfo/byteArray.xsd");

        Map<String, InputStream> controlSchema = new HashMap<String, InputStream>();
        controlSchema.put("someUri", instream);
        return controlSchema;
    }

}
