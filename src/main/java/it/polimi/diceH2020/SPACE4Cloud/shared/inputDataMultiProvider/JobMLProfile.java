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
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Iterator;
import java.util.Map;

@Data
@NoArgsConstructor
public class JobMLProfile {
	private double b;
	private double mu_t;
	private double sigma_t;
	@JsonUnwrapped private Map<String, SVRFeature> mlFeatures;

	public JobMLProfile (Map<String, SVRFeature> mapClassFeatures, double b, double mu_t, double sigma_t) {
		this.mlFeatures = mapClassFeatures;
		this.b = b;
		this.mu_t = mu_t;
		this.sigma_t = sigma_t;
	}

	public SVRFeature getClassFeature (String featureName) {
		return mlFeatures.get(featureName);
	}

	@JsonIgnore
	public boolean validate () {
		boolean valid = true;

		Iterator<SVRFeature> iterator = mlFeatures.values ().iterator ();
		while (valid && iterator.hasNext ()) {
			SVRFeature feature = iterator.next ();
			valid = feature.validate ();
		}

		return valid && mlFeatures.containsKey ("x") && mlFeatures.containsKey ("h") && mu_t > 0 && sigma_t > 0;
	}
}
