import React, { useEffect, useState } from 'react'
import axios from 'axios';
import { useParams, Link, useNavigate } from "react-router-dom";
    
const Detail = (props) => {
    const [author, setAuthor] = useState({})
    const { id } = useParams();
    // const navigate = useNavigate();
    
    useEffect(() => {
        axios.get('http://localhost:8000/api/author/'+id)
            .then(res => setAuthor(res.data))
            .catch(err => console.error(err));
    }, []);
    
    return (
        <div>
            <p>Name: {author.name}</p>
            <Link to={"/author/" + author._id + "/edit"}>
                Edit
            </Link>
        </div>
    )
}
    
export default Detail;
