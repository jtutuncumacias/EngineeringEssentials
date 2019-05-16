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

import React from 'react';
import Highcharts from 'highcharts';
import HighchartsReact from 'highcharts-react-official';

class LineChart extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            options:{
                chart: {
                    type: 'spline'
                    },
                title: {
                    text: 'Stock Prices'
                    },
                xAxis: [{
                    title: 'Date',
                    labels: {
                        format: "{value: %b/%e/%Y}"
                    }
                }],
                series: [
                    {
                        name: [],
                        data: []
                    }
                ]
            }
        }
    }

    componentDidMount() {
    }

    compare(a, b) {
      if (a.x < b.x){
        return -1;
      }
      if (a.x > b.x){
        return 1;
      }
      return 0;
    }

    componentWillReceiveProps(props) {
        console.log("New data received to redraw chart.");
        
        /**
         * TODO
         * Parse the data received from props, a Javascript object, to map to a Javascript array
         * required by the type of line chart chosen and set it in the series. Use Date.UTC(..)
         * to create the x-axis.
         */
        
        /**
         * TODO
         * Uncomment the line below to pass the data be displayed to the series
         */

        //this.chart.series[0].setData(data);

        if(props.data){
            let data = []
            Object.entries(props.data.dailyClosePrice[0]).forEach(([key, val]) => {
                data.push({
                    x: Date.parse(key),
                    y: val,
                    name: key,
                    color: "#8eb4ea"
                })
            });
            data = data.sort(this.compare)
            this.setState({
                options:{
                    series: [
                        {
                            name: props.data.name,
                            data: data
                        }
                    ]
                }
            })
       }
        
    }

    componentWillUnmount() {
        //this.state.chart.destroy();
    }


    render() {
        const {options} = this.state
        return (
            <div id='chart'>
                <HighchartsReact 
                    highcharts={Highcharts}
                    options={options}
                />
            </div>
        )
    }
}

// Don't forget to export your component!
export default LineChart;