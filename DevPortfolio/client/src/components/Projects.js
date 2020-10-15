import React from 'react';

const Projects = (props) => {
	return (
		<div className="project-container">
			<img alt={props.title} className="project-img" src={props.img} /> <h2>{props.title}</h2>
			<p>{props.description}</p>
			<div className="project-chip">
				<button className="project-btn">
					<a href={props.web}>LOAD</a>
				</button>
			</div>
			<div className="project-chip-stripes" />
		</div>
	);
};

export default Projects;
