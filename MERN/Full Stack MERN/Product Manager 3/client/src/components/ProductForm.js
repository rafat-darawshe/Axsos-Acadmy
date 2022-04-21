import React,{useState} from "react";
import axios from "axios";
import { useNavigate } from 'react-router-dom';
export default() =>{
    const [title, setTitle] = useState("");
    const [price, setPrice] = useState("");
    const [description, setDescription] = useState("");
    const navigate = useNavigate();
    const onSubmitHandler = e =>{
        e.preventDefault();
        axios.post('http://localhost:8000/api/product', {
            title,
            price,
            description
        })
        .then(res=>console.log(res))
        .catch(err=>console.log(err))
    }
    return (
        <form onSubmit={onSubmitHandler}>
            <h1>Product Manager</h1>
            <p>
                <label>Title</label><br/>
                <input type="text" onChange={(e)=>setTitle(e.target.value)} value={title}/>
            </p>
            <p>
                <label>Price</label><br/>
                <input type="text" onChange={(e)=>setPrice(e.target.value)} value={price}/>
            </p>
            <p>
                <label>Description</label><br/>
                <input type="text" onChange={(e)=>setDescription(e.target.value)} value={description}/>
            </p>
            <input type="submit"/>
        </form>
    )
}