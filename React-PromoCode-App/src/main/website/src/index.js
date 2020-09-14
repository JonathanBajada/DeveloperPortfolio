import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import axios from 'axios';
import registerServiceWorker from './registerServiceWorker';

//Shared globally, effects all requests sent from anywhere in the app
axios.interceptors.request.use(request => {
    console.log(request);
    //Edit request config
    return request;
}, error => { //Handler errors here
    console.log(error);
    return Promise.reject(error);

});

ReactDOM.render(<App />, document.getElementById('root'));
registerServiceWorker();
