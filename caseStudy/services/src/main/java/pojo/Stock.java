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

package pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.Map;

/**
 * This class will define a company's end-of-day stock price
 * Look at resources/data/historicalStockData.json
 */
public class Stock {

    // TODO - Think back to your modelling session
    // Define the attributes of a stock price based on the
    // provided data in resources/data
    @JsonFormat(shape = JsonFormat.Shape.OBJECT, pattern="MM/dd/yyyy", timezone="GMT-5")
    private String name;
    @JsonProperty
    private Map<Date,Float> dailyClosePrice;

    // TODO - add getter and setter methods for your attributes
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<Date,Float> getDailyClosePrice() {
        return dailyClosePrice;
    }

    public void setDailyClosePrice(Map<Date,Float> dailyClosePrice) {
        this.dailyClosePrice = dailyClosePrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Stock)) return false;

        Stock stock = (Stock) o;

        if (getName() != stock.getName()) return false;
        return getDailyClosePrice().equals(stock.getDailyClosePrice());

    }
}
