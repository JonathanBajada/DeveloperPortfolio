const express = require('express');
const passport = require('passport');
const GoogleStrategy = require('passport-google-oauth20').Strategy;

const app = express();

passport.use(new GoogleStrategy());

const PORT = process.env.PORT || 5000;
app.listen(PORT);

// ClientID 750061771212-5115d9v2mncmfn410p8302dje455lcvd.apps.googleusercontent.com

// ClientSecret IkwBeToIZcx_yXa97XwtyhCE
