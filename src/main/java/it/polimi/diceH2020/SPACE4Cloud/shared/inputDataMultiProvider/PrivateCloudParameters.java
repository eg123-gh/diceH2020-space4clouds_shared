/*
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
package it.polimi.diceH2020.SPACE4Cloud.shared.inputDataMultiProvider;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Data;

@Data
public class PrivateCloudParameters {
	@JsonInclude(Include.NON_DEFAULT)
	private double m;  //node RAM capacity
	@JsonInclude(Include.NON_DEFAULT)
	private double v;  //node CPUs capacity
	@JsonInclude(Include.NON_DEFAULT)
	private int n;	   //number of physical nodes
	@JsonInclude(Include.NON_DEFAULT)
	private double e;  //cost of energy to run one physical machine

	public PrivateCloudParameters () {}

	public boolean validate () {
		return (m >= 0 && v >= 0 && n >= 0 && e >= 0);
	}
}
