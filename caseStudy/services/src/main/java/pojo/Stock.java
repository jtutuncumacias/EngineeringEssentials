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

import com.fasterxml.jackson.annotation.JsonProperty;

import java.text.ParseException;
import java.util.List;
import java.util.TreeMap;
import java.util.SortedMap;
import java.text.SimpleDateFormat;

/**
 * This class will define a company's end-of-day stock price
 * Look at resources/data/historicalStockData.json
 */
public class Stock {

    public static final SimpleDateFormat INPUTDATEFORMAT = new SimpleDateFormat("MM-dd-yyyy");
    public static final SimpleDateFormat OUTPUTDATEFORMAT = new SimpleDateFormat("M/d/yyyy");

    // TODO - Think back to your modelling session
    // Define the attributes of a stock price based on the
    // provided data in resources/data
    @JsonProperty
    private String name;

    @JsonProperty
    private List<TreeMap<String,Float>> dailyClosePrice;

    // TODO - add getter and setter methods for your attributes
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TreeMap<String,Float>> getDailyClosePrice() {
        return dailyClosePrice;
    }

    public void setDailyClosePrice(List<TreeMap<String,Float>> dailyClosePrice) { this.dailyClosePrice = dailyClosePrice; }

    public void trimDailyClosePrices(String startDateStr, String endDateStr) throws ParseException {
        String newStartDateStr = OUTPUTDATEFORMAT.format(INPUTDATEFORMAT.parse(startDateStr));
        String newEndDateStr = OUTPUTDATEFORMAT.format(INPUTDATEFORMAT.parse(endDateStr));

        System.out.println("startDateStr:" + startDateStr);
        System.out.println("endDateStr:" + endDateStr);
        System.out.println("newStartDateStr:" + newStartDateStr);
        System.out.println("newEndDateStr:" + newEndDateStr);

        SortedMap<String,Float> newDailyClosePrice = this.dailyClosePrice.get(0).subMap(newStartDateStr, newEndDateStr);
        this.dailyClosePrice.set(0, new TreeMap<>(newDailyClosePrice));
        return;
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
