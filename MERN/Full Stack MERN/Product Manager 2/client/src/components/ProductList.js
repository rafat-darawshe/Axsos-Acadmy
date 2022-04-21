import React from 'react'
import { Link } from "react-router-dom";

    
const ProductList = (props) => {
    return (
        <div>
            <h1>All Product:</h1>
            {props.product.map( (product, i) =>
                <p key={i}> <Link to={`/product/${product._id}`}>{product.title}</Link></p>
            )}
        </div>
    )
}
    
export default ProductList;
