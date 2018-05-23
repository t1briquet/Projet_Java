const mongoose = require('mongoose');
const config = require('../config/database');

// User Schema
const MatchSchema = mongoose.Schema({
  player1: {
    type: String
  },
  player2: {
    type: String
  },
  winner: {
    type: String
  },
  tournois: {
    type: String
  },
  ronde: {
    type: Number
  },
  points: [],
  sets: []
});

const Match = module.exports = mongoose.model('Match', MatchSchema);


module.exports.getMatchById = function(id, callback){
  Match.findById(id, callback);
};

module.exports.addMatch = function(newMatch, callback){
  newMatch.save(callback);
};