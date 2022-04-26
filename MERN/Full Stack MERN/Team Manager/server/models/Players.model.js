const mongoose = require('mongoose');
const PlayerSchema = new mongoose.Schema({
    name: {
        type: String,
        required: [true, "name is required"],
        minlength: [3, "Name must be at least 3 characters!"],
    },
    position: {
        type: String,
    },

}, { timestamps: true });
module.exports.Player = mongoose.model('Player', PlayerSchema);
