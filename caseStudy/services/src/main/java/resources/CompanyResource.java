/**
 * Copyright 2019 Goldman Sachs.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package resources;

import pojo.Company;
import utility.InputValidator;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.List;

// TODO - add your @Path here
@Path("company")
public class CompanyResource {

    // TODO - Add a @GET resource to get company data
    // Your service should return data for a given stock ticker

    @GET
    @Path("/{companySymbol}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDataForCompany(@PathParam("companySymbol") String companySymbol) throws IOException {
        List<Company> companyList = InputValidator.validateCompanyInfo();

        for (Company company: companyList) {
            if (company.getSymbol().equalsIgnoreCase(companySymbol)) {
                return Response.ok().entity(company).build();
            }
        }

        return Response.ok().entity("No matches found for company with symbol " + companySymbol).build();
    }

}
