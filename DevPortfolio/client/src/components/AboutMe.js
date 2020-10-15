import React from 'react';
import '../css/about.css';
import github from '../img/github.png';
import linkedIN from '../img/linkedIn.png';

const AboutMe = (props) => {
	return (
		<div className="about-me">
			<div className="profile-image">
				<img className="profilePic" src={require('../img/profile.png')} alt="" />
			</div>

			<div className="about-info">
				<h2 className="h2-about">About Me</h2>
				<div className="about-p">
					<p>Hello! I'm Jonathan, a software engineer based in Toronto, ON.</p>
					<br />
					<p>
						I am a recent graduate from the <span className="text-highlight">Computer Science</span> program
						at
						<span className="text-highlight"> Ryerson University</span>. During my degree I did an
						internship at an online loan lending company called Moneykey. There I did{' '}
						<span className="text-highlight">Full Stack Development</span>, using React.js + Spring Boot in
						my internship at Moneykey. I aim to be a Senior React Developer.
					</p>
				</div>
			</div>
		</div>
	);
};

export default AboutMe;
