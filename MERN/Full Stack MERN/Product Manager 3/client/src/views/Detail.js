import React, { useEffect, useState } from 'react'
import axios from 'axios';
import { useParams, Link, useNavigate } from "react-router-dom";
    
const Detail = (props) => {
    const [product, setProduct] = useState({})
    const { id } = useParams();
    // const navigate = useNavigate();
    
    useEffect(() => {
        axios.get('http://localhost:8000/api/product/'+id)
            .then(res => setProduct(res.data))
            .catch(err => console.error(err));
    }, []);
    
    return (
        <div>
            <p>Title: {product.title}</p>
            <p>Price: {product.price}</p>
            <p>Price: {product.description}</p>
            <Link to={"/product/" + product._id + "/edit"}>
                Edit
            </Link>
        </div>
    )
}
    
export default Detail;
