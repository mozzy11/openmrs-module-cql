/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.cql.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.openmrs.module.cql.api.CQLService;
import org.openmrs.module.webservices.rest.web.RestConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/rest/" + RestConstants.VERSION_1 + "/evaluatemeasure")
public class EvaluateMeasureController {

	@Autowired
	private CQLService cqlService;
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Object evaluate(HttpServletRequest request) {
		
		String measureId = request.getParameter("measureid");
		String periodStart = request.getParameter("periodstart");
		String periodEnd = request.getParameter("periodend");
		String reportType = request.getParameter("reporttype");

		return cqlService.evaluateMeasure(measureId, periodStart, periodEnd, reportType);
	}
}
