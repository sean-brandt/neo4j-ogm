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

package org.neo4j.ogm.domain.social;

import java.util.Set;

import org.neo4j.ogm.annotation.Relationship;

/**
 * @author Luanne Misquitta
 */
public class SocialUser {

	private Long id;
	private String name;

	public SocialUser() {
	}

	public SocialUser(String name) {
		this.name = name;
	}

	@Relationship(type = "HAS_AS_FRIEND", direction = Relationship.OUTGOING)
	Set<SocialUser> friends;

	@Relationship(type = "FOLLOWING", direction = Relationship.OUTGOING)
	Set<SocialUser> following;

	@Relationship(type = "IS_FOLLOWED_BY", direction = Relationship.INCOMING)
	Set<SocialUser> followers;

	public Set<SocialUser> getFriends() {
		return friends;
	}

	public void setFriends(Set<SocialUser> friends) {
		this.friends = friends;
	}

	public Set<SocialUser> getFollowing() {
		return following;
	}

	public void setFollowing(Set<SocialUser> following) {
		this.following = following;
	}

	@Relationship(type = "IS_FOLLOWED_BY", direction = Relationship.INCOMING)
	public Set<SocialUser> getFollowers() {
		return followers;
	}

	@Relationship(type = "IS_FOLLOWED_BY", direction = Relationship.INCOMING)
	public void setFollowers(Set<SocialUser> followers) {
		this.followers = followers;
	}

	public Long getId() {
		return id;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		SocialUser that = (SocialUser) o;

		if (id != null ? !id.equals(that.id) : that.id != null) return false;
		if (name != null ? !name.equals(that.name) : that.name != null) return false;
		if (friends != null ? !friends.equals(that.friends) : that.friends != null) return false;
		if (following != null ? !following.equals(that.following) : that.following != null) return false;
		return !(followers != null ? !followers.equals(that.followers) : that.followers != null);
	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (name != null ? name.hashCode() : 0);
		result = 31 * result + (friends != null ? friends.hashCode() : 0);
		result = 31 * result + (following != null ? following.hashCode() : 0);
		result = 31 * result + (followers != null ? followers.hashCode() : 0);
		return result;
	}
}
