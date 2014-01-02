/* Copyright 2009 Hochschule Offenburg
 * Klaus Dorer, Mathias Ehret, Stefan Glaser, Thomas Huber,
 * Simon Raffeiner, Srinivasa Ragavan, Thomas Rinklin,
 * Joachim Schilling, Rajit Shahi
 *
 * This file is part of magmaOffenburg.
 *
 * magmaOffenburg is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * magmaOffenburg is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with magmaOffenburg. If not, see <http://www.gnu.org/licenses/>.
 */

package magma.tools.benchmark.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author kdorer
 */
public class TeamResult
{
	private String name;

	private List<SingleRunResult> results;

	/**
	 * @param name
	 */
	public TeamResult(String name)
	{
		this.name = name;
		results = new ArrayList<SingleRunResult>();
	}

	public void addResult(SingleRunResult result)
	{
		results.add(result);
	}

	public float getAverageScore()
	{
		return getAverageSpeed() + getAverageOffGround();
	}

	/**
	 * @return
	 */
	public float getAverageSpeed()
	{
		if (results.isEmpty()) {
			return 0.0f;
		}
		float avg = 0;
		for (SingleRunResult result : results) {
			avg += result.getSpeed();
		}
		return avg / results.size();
	}

	/**
	 * @return
	 */
	public float getAverageOffGround()
	{
		if (results.isEmpty()) {
			return 0.0f;
		}
		float avg = 0;
		for (SingleRunResult result : results) {
			avg += result.getOffGround();
		}
		return avg / results.size();
	}

	public int size()
	{
		return results.size();
	}
}
