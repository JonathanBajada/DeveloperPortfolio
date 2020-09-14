//use to gain access to express library
const express = require('express');
const mongoose = require('mongoose');
const keys = require('./config/keys');
require('./models/User.js');
require('./services/passport');
//calling express like a functon generates new application,runnning express app
//app ojbect use to setup information to listen to incoming requests and make responses
mongoose.connect(keys.mongoURI).then((_) => console.log('connected')).catch((e) => console.log(e));

const app = express();

require('./routes/authRoutes')(app);

const PORT = process.env.PORT || 5000;
app.listen(PORT);
