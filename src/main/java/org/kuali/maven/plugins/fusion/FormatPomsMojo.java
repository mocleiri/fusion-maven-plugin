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

import java.io.File;
import java.util.List;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Component;
import org.apache.maven.plugins.annotations.Execute;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

/**
 * Recursively examine the file system for Maven poms starting at <code>basedir</code>. Any pom.xml files located have formatting applied to them.
 * 
 */
@Mojo(name="formatpoms", aggregator=true)
@Execute(goal="formatpoms")
public class FormatPomsMojo extends AbstractMojo {

	MojoHelper helper = MojoHelper.getInstance(this);
	POMUtils pomUtils = new POMUtils();

	/**
	 * The filename to include when examining the file system for Maven pom's
	 * 
	 */
	@Parameter(property=FusionMavenPluginConstants.FUSION_POM, defaultValue=FusionMavenPluginConstants.FUSION_POM_DEFAULT)
	private String pom;

	/**
	 * Directories to ignore when examining the file system
	 * 
	 */
	@Parameter(property=FusionMavenPluginConstants.FUSION_IGNORE_DIRS, defaultValue=FusionMavenPluginConstants.FUSION_IGNORE_DIRS_DEFAULT)
	private String ignoreDirectories;

	/**
	 * The base directory that is recursively scanned for Maven pom's
	 * 
	 */
	@Parameter(property="fusion.basedir", defaultValue="project.basedir")
	private File basedir;

	/**
	 * The Maven project object
	 * 
	 */
	@Component
	private MavenProject project;

	@Override
	public void execute() throws MojoExecutionException {
		List<File> poms = helper.getPoms(basedir, pom, ignoreDirectories);
		int count = 0;
		for (File pom : poms) {
			String xml = helper.read(pom);
			String formattedXML = pomUtils.format(xml);
			if (!xml.equals(formattedXML)) {
				count++;
				helper.write(pom, formattedXML);
				getLog().info("Formatting applied to " + pom.getAbsolutePath());
			}
		}
		getLog().info("Formatted " + count + " poms");
	}

	public String getPom() {
		return pom;
	}

	public void setPom(String pom) {
		this.pom = pom;
	}

	public String getIgnoreDirectories() {
		return ignoreDirectories;
	}

	public void setIgnoreDirectories(String ignoreDirectories) {
		this.ignoreDirectories = ignoreDirectories;
	}

	public MavenProject getProject() {
		return project;
	}

	public File getBasedir() {
		return basedir;
	}

	public void setBasedir(File basedir) {
		this.basedir = basedir;
	}
}
