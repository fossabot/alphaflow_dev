/**************************************************************************
 * Hydra: multi-headed version control system
 * (originally for the alpha-Flow project)
 * ==============================================
 * Copyright (C) 2009-2012 by 
 *   - Christoph P. Neumann (http://www.chr15t0ph.de)
 *   - Scott Hady
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
 * $Id: LUCmdStash.java 3583 2012-02-16 01:52:45Z cpn $
 *************************************************************************/
package org.hydra.ui.commands;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.hydra.core.LogicalUnit;
import org.hydra.core.Stage;

/**
 * Stashes or saves the current contents of the designated logical unit.
 *
 * @since 0.2
 * @version 0.2
 * @author Scott A. Hady
 */
public class LUCmdStash extends CommandLogicalUnit {

	/** The Constant serialVersionUID. */
	public static final long serialVersionUID = 02L;

	/** The Constant DEFAULT_NAME. */
	public static final String DEFAULT_NAME = "LogicalUnit Stash";

	/** The Constant DEFAULT_ID. */
	public static final String DEFAULT_ID = "LUCmdStash";

	// Regular Expressions
	/** The cmd reg ex. */
	private final String cmdRegEx = "^\\s*(?i:lustash)\\b";

	/** The lu reg ex. */
	private final String luRegEx = "(\\s+(\\S+.*))?\\b\\s*$";

	/** The cmd pattern. */
	private final Pattern cmdPattern = Pattern.compile(this.cmdRegEx);

	/** The complete pattern. */
	private final Pattern completePattern = Pattern.compile(this.cmdRegEx
			+ this.luRegEx);

	/** The GROU p_ logicalunit. */
	private final int GROUP_LOGICALUNIT = 2;

	/**
	 * Specialized Constructor designated which stage's logical unit's to query.
	 *
	 * @param stage
	 *            Stage.
	 */
	public LUCmdStash(final Stage stage) {
		super(LUCmdStash.DEFAULT_NAME, LUCmdStash.DEFAULT_ID, stage);
	}

	/**
	 * Specialized Constructor; which takes the stage and name of the content's
	 * logical unit to store.
	 *
	 * @param stage
	 *            Stage.
	 * @param luName
	 *            String.
	 */
	public LUCmdStash(final Stage stage, final String luName) {
		super(LUCmdStash.DEFAULT_NAME, LUCmdStash.DEFAULT_ID, stage, luName);
	}

	/**
	 * COMMAND METHODS OVERRIDDEN *********************************************.
	 * 
	 * @return the command pattern
	 */

	/**
	 * {@inheritDoc}
	 *
	 * Factory Method - Command Pattern accepts 'lustatus' as the command.
	 */
	@Override
	public Pattern getCommandPattern() {
		return this.cmdPattern;
	}

	/**
	 * {@inheritDoc}
	 *
	 * Factory Method - Complete Pattern accepts 'lustatus {[luname]}'.
	 */
	@Override
	public Pattern getCompletePattern() {
		return this.completePattern;
	}

	/**
	 * {@inheritDoc}
	 *
	 * Template Method - Process the matcher to extract the logical unit.
	 */
	@Override
	public boolean processMatcher(final Matcher matcher) {
		return this.processLogicalUnitName(matcher
				.group(this.GROUP_LOGICALUNIT));
	}

	/**
	 * {@inheritDoc}
	 *
	 * Stash the logical unit's contents.
	 */
	@Override
	public boolean execute() {
		boolean success = false;
		final StringBuilder sb = new StringBuilder("");
		final LogicalUnit lu = this.stage.getLogicalUnit(this.luName);
		if (lu == null) {
			sb.append("FAILURE: Logical Unit [" + this.luName
					+ "] Not Found.\n");
		} else {
			success = lu.recordReferences();
			if (success) {
				sb.append("Logical Unit's [" + this.luName
						+ "] Content has been Stashed.\n");
			} else {
				sb.append("FAILURE: Unable to Stash Logical Unit's ["
						+ this.luName + "] Content.\n");
			}
		}
		this.writer.println(sb.toString(), this.cmdVerbosity);
		return success;
	}

	/**
	 * {@inheritDoc}
	 *
	 * Return a string describing the commands usage.
	 */
	@Override
	public String getUsage() {
		return "luStash {<luName>}\t\t\tStash the Logical Unit's Content.";
	}

}
