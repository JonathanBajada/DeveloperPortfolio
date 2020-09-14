import React, { Component } from 'react';
import classes from './App.css';
import PromoCode from './components/PromoCode'

class App extends Component {
  render() {
    return (
      <div className={classes.App}>
        <header className={classes.Appheader}>
          <h1 className={classes.Apptitle}>DM TOOL</h1>
        </header>
        <PromoCode></PromoCode>
      </div>
    );
  }
}

export default App;
