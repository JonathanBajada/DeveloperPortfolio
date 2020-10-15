import React from 'react';
import { BrowserRouter, Route, Switch } from 'react-router-dom';
import Projects from './Projects';
import Nav from './Nav';
import About from './AboutMe';
import Resume from '../resume/resume.pdf';
import '../css/app.css';

import todo from '../img/todo.png';
import visible from '../img/visible.png';
import sqlgen from '../img/sqlgen.png';

const showProjects = () => {
	return (
		<div className="project-wrapper">
			<Projects
				title="Visible"
				className="item-1"
				img={visible}
				description="An accessibility app for the seeing impaired, made with Javascript, HTML and CSS. This app allows the user adjust a text file's font size and color, with audio playback."
				web="http://visible.com.s3-website.ca-central-1.amazonaws.com/"
			/>
			<Projects
				title="Todo"
				className="item-2"
				img={todo}
				description="A todo application built with React.js"
				web="http://todo-gen.s3-website.ca-central-1.amazonaws.com/"
			/>

			<Projects
				title="Loan Documents"
				className="item-2"
				img={sqlgen}
				description="An application that updates and creates new loan documents. This app was built with React.js and Spring Boot for my internship"
				web="http://todo-gen.s3-website.ca-central-1.amazonaws.com/"
			/>
		</div>
	);
};

const aboutMe = () => {
	return (
		<div className="about-flex">
			<About />
			<button className="about-button">Get In Touch</button>
		</div>
	);
};

const App = () => {
	return (
		<div className="web-app">
			<Nav />
			<Switch>
				<Route path="/" component={aboutMe} exact />
				<Route path="/projects" component={showProjects} />
				<Route path="/resume" />
				<Route component={Error} />
			</Switch>
		</div>
	);
};

export default App;
