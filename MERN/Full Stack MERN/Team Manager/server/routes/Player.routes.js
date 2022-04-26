const PlayerController = require('../controllers/Player.controller');

module.exports = function(app){
    app.post('/api/player', PlayerController.createPlayer);
    app.get('/api/player', PlayerController.getAllPlayer);
    app.get('/api/player/:id', PlayerController.getPlayer);
    app.put('/api/player/:id', PlayerController.updatePlayer);
    app.delete('/api/player/:id', PlayerController.deletePlayer);


}