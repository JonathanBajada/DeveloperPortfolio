import React from 'react';
import { Link } from 'react-router-dom';
import Pdf from '../resume/resume.pdf';
import '../css/nav.css';

const Nav = () => {
	return (
		<div className="nav-container">
			<Link className="nav-item nav-1" to="/">
				Home{' '}
			</Link>

			<Link className="nav-item nav-2" to="/projects">
				Projects{' '}
			</Link>

			<a className="resume-link" href={Pdf} without rel="noopener noreferrer" target="_blank">
				<button className="nav-item nav-3" trailingIcon="picture_as_pdf" label="Resume">
					Resume
				</button>
			</a>
		</div>
	);
};

export default Nav;
