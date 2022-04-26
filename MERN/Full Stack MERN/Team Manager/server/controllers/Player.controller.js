const { Player } = require('../models/Players.model');

module.exports.createPlayer = (request, response) => {
    const { name, position } = request.body;
    Player.create({
        name,
        position
    })
        .then(Player => response.json(Player))
        .catch(err => response.status(400).json(err))
        
;
}

module.exports.getAllPlayer = (request, response) => {
    Player.find({})
        .then(players => response.json(players))
        .catch(err => response.status(400).json(err))

}

module.exports.getPlayer = (request, response) => {
    Player.findOne({_id:request.params.id})
        .then(Player => response.json(Player))
        .catch(err => response.status(400).json(err))

}

// module.exports.updatePlayer = (request, response) => {
//     Player.findOneAndUpdate({_id: request.params.id}, request.body, {new:true})
//         .then(updatedPlayer => response.json(updatedPlayer))
//         .catch(err => response.status(400).json(err))

// }
module.exports.updatePlayer = (request, response) => {
    console.log("update Player method executed");
  
    Player.findOneAndUpdate({ _id: request.params.id }, request.body, {
      new: true,
      runValidators: [true, "{PATH} is required"],
    })
      .then((updatedPlayer) => response.json(updatedPlayer))
      .catch((err) => response.status(400).json(err));
  };


module.exports.deletePlayer = (req, res) => {
    const { id } = req.params;
    Player.deleteOne({ _id: id })
    .then((deleteConfirm) => res.json(deleteConfirm))
    .catch((err) => res.json(err));
};