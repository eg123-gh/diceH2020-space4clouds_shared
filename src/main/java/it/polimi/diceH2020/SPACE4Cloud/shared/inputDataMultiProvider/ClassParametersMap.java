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

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@Data
public class ClassParametersMap {
	private Map<String, ClassParameters> mapClassParameters;

	public ClassParametersMap (Map<String, ClassParameters> mapClassParameters){
		this.mapClassParameters = mapClassParameters;
	}

	ClassParametersMap () {
		mapClassParameters = new HashMap<>();
	}

	@JsonIgnore
	public boolean validate () {
		boolean valid = true;

		Iterator<ClassParameters> iterator = mapClassParameters.values ().iterator ();
		while (valid && iterator.hasNext ()) {
			ClassParameters parameters = iterator.next ();
			valid = parameters.validate ();
		}

		return valid;
	}

	@JsonIgnore
	Set<String> getJobIDs() {
		return mapClassParameters.keySet();
	}
}

