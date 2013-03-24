/**************************************************************************
 * alpha-Flow: distributed case files in form of active documents
 * (supporting knowledge-driven ad-hoc processes in healthcare)
 * ==============================================
 * Copyright (C) 2009-2012 by 
 *   - Christoph P. Neumann (http://www.chr15t0ph.de)
 **************************************************************************
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS, 
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and 
 * limitations under the License.
 **************************************************************************
 * $Id$
 *************************************************************************/
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-257 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.03.31 at 01:24:03 PM MESZ 
//

package alpha.overnet.event;

import javax.xml.bind.annotation.XmlRegistry;

import alpha.model.AlphaCardDescriptor;

/**
 * This object contains factory methods for each Java content interface and Java
 * element interface generated in the generated package.
 * <p>
 * An ObjectFactory allows you to programatically construct new instances of the
 * Java representation for XML content. The Java representation of XML content
 * can consist of schema derived interfaces and classes representing the binding
 * of schema type definitions, element declarations and model groups. Factory
 * methods for each of these are provided in this class.
 * 
 * 
 */
@XmlRegistry
public class ObjectFactory {

	/**
	 * Create a new ObjectFactory that can be used to create new instances of
	 * schema derived classes for package: generated.
	 */
	public ObjectFactory() {
	}

	/**
	 * Creates a new Object object.
	 * 
	 * @return the alpha card descriptor
	 */
	public AlphaCardDescriptor createAlphaCard() {
		return new AlphaCardDescriptor();
	}

	/**
	 * Creates a new Object object.
	 * 
	 * @return the change payload event
	 */
	public ChangePayloadEvent createChangePayloadEvent() {
		return new ChangePayloadEvent();
	}

	/**
	 * Creates a new Object object.
	 * 
	 * @return the adds the alpha card event
	 */
	public AddAlphaCardEvent createAddAlphaCardEvent() {
		return new AddAlphaCardEvent();
	}

	/**
	 * Creates a new Object object.
	 * 
	 * @return the change alpha card descriptor event
	 */
	public ChangeAlphaCardDescriptorEvent createChangeAlphaCardDescriptorEvent() {
		return new ChangeAlphaCardDescriptorEvent();
	}

	/**
	 * Creates a new Object object.
	 * 
	 * @return the participant join event
	 */
	public ParticipantJoinEvent createParticipantJoinEvent() {
		return new ParticipantJoinEvent();
	}

	/**
	 * Creates a new Object object.
	 * 
	 * @return the payload container
	 */
	public PayloadContainer createPayloadContainer() {
		return new PayloadContainer();
	}

}