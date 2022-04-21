const { Product } = require('../models/products.model');

module.exports.createProduct = (request, response) => {
    const { title, price, description } = request.body;
    Product.create({
        title,
        price,
        description
    })
        .then(Product => response.json(Product))
        .catch(err => response.json(err));
}

module.exports.getAllProduct = (request, response) => {
    Product.find({})
        .then(products => response.json(products))
        .catch(err => response.json(err))
}

module.exports.getProduct = (request, response) => {
    Product.findOne({_id:request.params.id})
        .then(product => response.json(product))
        .catch(err => response.json(err))
}

module.exports.updateProduct = (request, response) => {
    Product.findOneAndUpdate({_id: request.params.id}, request.body, {new:true})
        .then(updatedProduct => response.json(updatedProduct))
        .catch(err => response.json(err))
}


module.exports.deleteProduct = (req, res) => {
    const { id } = req.params;
    Product.deleteOne({ _id: id })
    .then((deleteConfirm) => res.json(deleteConfirm))
    .catch((err) => res.json(err));
};