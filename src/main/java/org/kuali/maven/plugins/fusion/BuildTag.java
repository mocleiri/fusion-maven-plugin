/**
 * Copyright 2011-2014 The Kuali Foundation
 *
 * Licensed under the Educational Community License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.opensource.org/licenses/ecl2.php
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.kuali.maven.plugins.fusion;

import org.eclipse.jgit.lib.ObjectId;

public class BuildTag {

	String sourceUrl;
	long sourceRevision;
	String tagUrl;
	boolean skipped;
	
	String name;
	
	ObjectId commitId;
	

	public String getSourceUrl() {
		return sourceUrl;
	}

	public void setSourceUrl(String sourceUrl) {
		this.sourceUrl = sourceUrl;
	}

	public long getSourceRevision() {
		return sourceRevision;
	}

	public void setSourceRevision(long sourceRevision) {
		this.sourceRevision = sourceRevision;
	}

	public String getTagUrl() {
		return tagUrl;
	}

	public void setTagUrl(String tagUrl) {
		this.tagUrl = tagUrl;
	}

	public boolean isSkipped() {
		return skipped;
	}

	public void setSkipped(boolean skipped) {
		this.skipped = skipped;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the commitId
	 */
	public ObjectId getCommitId() {
		return commitId;
	}

	/**
	 * @param commitId the commitId to set
	 */
	public void setCommitId(ObjectId commitId) {
		this.commitId = commitId;
	}
	
	
}
