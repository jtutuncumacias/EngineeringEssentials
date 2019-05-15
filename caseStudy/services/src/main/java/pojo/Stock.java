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

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.text.SimpleDateFormat;

/**
 * This class will define a company's end-of-day stock price
 * Look at resources/data/historicalStockData.json
 */
public class Stock {

    public static final SimpleDateFormat DATEFORMAT = new SimpleDateFormat("MM-dd-yyyy");

    // TODO - Think back to your modelling session
    // Define the attributes of a stock price based on the
    // provided data in resources/data
    @JsonProperty
    private String name;

    @JsonProperty
    private List<Map<String,Float>> dailyClosePrice;

    // TODO - add getter and setter methods for your attributes
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Map<String,Float>> getDailyClosePrice() {
        return dailyClosePrice;
    }

    public void setDailyClosePrice(List<Map<String,Float>> dailyClosePrice) { this.dailyClosePrice = dailyClosePrice; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Stock)) return false;

        Stock stock = (Stock) o;

        if (getName() != stock.getName()) return false;
        return getDailyClosePrice().equals(stock.getDailyClosePrice());

    }
}
