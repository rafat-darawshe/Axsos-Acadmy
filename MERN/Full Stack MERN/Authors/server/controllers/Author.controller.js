const { Author } = require('../models/Authors.model');

module.exports.createAuthor = (request, response) => {
    const { name } = request.body;
    Author.create({
        name
    })
        .then(Author => response.json(Author))
        .catch(err => response.status(400).json(err))
        
;
}

module.exports.getAllAuthor = (request, response) => {
    Author.find({})
        .then(authors => response.json(authors))
        .catch(err => response.status(400).json(err))

}

module.exports.getAuthor = (request, response) => {
    Author.findOne({_id:request.params.id})
        .then(Author => response.json(Author))
        .catch(err => response.status(400).json(err))

}

// module.exports.updateAuthor = (request, response) => {
//     Author.findOneAndUpdate({_id: request.params.id}, request.body, {new:true})
//         .then(updatedAuthor => response.json(updatedAuthor))
//         .catch(err => response.status(400).json(err))

// }
module.exports.updateAuthor = (request, response) => {
    console.log("update author method executed");
  
    Author.findOneAndUpdate({ _id: request.params.id }, request.body, {
      new: true,
      runValidators: [true, "{PATH} is required"],
    })
      .then((updatedAuthor) => response.json(updatedAuthor))
      .catch((err) => response.status(400).json(err));
  };


module.exports.deleteAuthor = (req, res) => {
    const { id } = req.params;
    Author.deleteOne({ _id: id })
    .then((deleteConfirm) => res.json(deleteConfirm))
    .catch((err) => res.json(err));
};