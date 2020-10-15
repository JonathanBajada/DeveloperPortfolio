import React from 'react';
import { BrowserRouter, Route, Switch } from 'react-router-dom';
import ReactDOM from 'react-dom';
import App from './components/App';

ReactDOM.render(
	<BrowserRouter>
		<App />
	</BrowserRouter>,
	document.querySelector('#root')
);
