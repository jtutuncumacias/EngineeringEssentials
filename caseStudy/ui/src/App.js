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
import './style/App.css';
/**
 * TODO:
 * Import your components
 */

 import Charts from './components/Charts';
 import Date from './components/Date';
 //import StockTicker from './components/StockTicker';


class App extends React.Component{
    constructor(props) {
        super(props);
        this.state = {
            /**
             * TODO
             * Add state objects for the user inputs and anything else you may need to render the highchart.
             */
             stockTicker: 'GOOG',
             startDate: '1-1-2019',
             endDate: '6-1-2019'
        };
        this.handleInput = this.handleInput.bind(this);

    }

    handleInput(type,value) {
      this.setState({
        [type]:value
      })
    };


    // handleSubmit = (stockTicker, startDate, endDate) => {
    //   const newCard = {author, text: message, tags, dateStamp};
    //   const cards = [...this.state.cards, newCard];
    //   this.setState({cards: cards});
    // }

    render () {
      return ( 
          <div className="page-display">
              <h1>Stock Visualization App</h1>
              <br/>
                <div className="input">
                {/*<StockTicker inputValue={this.stockTicker} onChange={(value) => {this.handleInput("stockTicker",value)}} />)*/}
                <input type="text" value={this.state.stockTicker} onChange={(value) => {this.handleInput("stockTicker",value)}} />
                {/**
                 * TODO
                 * Render the StockTicker and Date components. You can use the date component twice
                 * for both the start and end dates.
                 * Add onChange props to the StockTicker and both Date components.
                 * These props methods should set state and help determine if the
                 * highchart should be displayed by changing the state of that boolean.
                 * Don't forget to bind these methods!
                 */}
                   <div className="date-range">
                      <Date text={"Start Date"} onChange={(value) => {this.handleInput("startDate",value)}} />
                    </div>
                    <div className="date-range">
                      <Date text={"End Date"} onChange={(value) => {this.handleInput("endDate",value)}} />
                    </div>
                </div>


                 {/**
                   *  TODO
                   *  Create a div element that shows a highchart when the ticker, start date, end date
                   *  states ALL have values and nothing (null) otherwise. You will need to use a conditional here
                   *  to help control rendering and pass these states as props to the component. This conditional can
                   *  be maintained as a state object.
                   *  http://reactpatterns.com/#conditional-rendering
                   */
                 }

                 {((this.state.stockTicker != null) && (this.state.startDate != null) && (this.state.endDate != null)) ? 
                    <Charts 
                        stockTicker={this.state.stockTicker}
                        startDate={this.state.startDate} 
                        endDate={this.state.endDate}
                    /> : null
                  }


          </div>
      );
    }
  }
export default App;
