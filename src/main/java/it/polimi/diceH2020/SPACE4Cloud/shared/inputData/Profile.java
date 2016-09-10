/**
 * Copyright 2015 deib-polimi
 * Contact: deib-polimi <michele.ciavotta@polimi.it>
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package it.polimi.diceH2020.SPACE4Cloud.shared.inputData;

import lombok.Data;

@Data
public class Profile {

	private int cm;
	private int cr;
	private double mavg;
	private double mmax;
	private double ravg;
	private double rmax;
	private double sh1max;
	private double shtypavg;
	private double shtypmax;
	private int nm;
	private int nr;
	private int datasize;

	public boolean validate() {
		return (cm > 0 && cr > 0 && mavg > 0 && mmax > 0 && ravg > 0 && rmax > 0 && sh1max >= 0 && shtypavg >= 0 && shtypmax >= 0 && nm > 0 && nr > 0);
	}
	
}
