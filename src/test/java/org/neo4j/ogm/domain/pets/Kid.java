/*
 * Copyright (c) 2002-2015 "Neo Technology,"
 * Network Engine for Objects in Lund AB [http://neotechnology.com]
 *
 * This product is licensed to you under the Apache License, Version 2.0 (the "License").
 * You may not use this product except in compliance with the License.
 *
 * This product may include a number of subcomponents with
 * separate copyright notices and license terms. Your use of the source
 * code for these subcomponents is subject to the terms and
 * conditions of the subcomponent's license, as noted in the LICENSE file.
 *
 */

package org.neo4j.ogm.domain.pets;

import java.util.HashSet;
import java.util.Set;

import org.neo4j.ogm.annotation.Relationship;

/**
 * @author Luanne Misquitta
 */
public class Kid {

	private Long id;
	private String name;

	@Relationship(type = "HAS_PET")
	private Set<Mammal> pets = new HashSet<>();

	public Kid() {
	}

	public Kid(String name) {
		this.name = name;
	}

	public void hasPet(Mammal mammal) {
		pets.add(mammal);
		mammal.setOwner(this);
	}

	public Set<Mammal> getPets() {
		return pets;
	}
}
