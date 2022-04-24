import React,{useState} from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import axios from "axios";
import { useNavigate, Link } from 'react-router-dom';
import { Button } from 'react-bootstrap';

export default() =>{
    const [name, setName] = useState("");
    const navigate = useNavigate();
    const [errors, setErrors] = useState([]); 
    const onSubmitHandler = e =>{
        e.preventDefault();
        axios.post('http://localhost:8000/api/author', {
            name
        })
        .then(res=>console.log(res))
        .catch(err=>{
            const errorResponse = err.response.data.errors; // Get the errors from err.response.data
            const errorArr = []; // Define a temp error array to push the messages in
            for (const key of Object.keys(errorResponse)) { // Loop through all errors and get the messages
                errorArr.push(errorResponse[key].message)
            }
            // Set Errors
            setErrors(errorArr);
        })            
    }
    return (
        <form onSubmit={onSubmitHandler}>
            <h1>Author</h1>
            {errors.map((err, index) => <p key={index}>{err}</p>)}
            <p>
                <label>Name</label><br/>
                <input type="text" onChange={(e)=>setName(e.target.value)} value={name}/>
            </p>
            <input type="submit"/>
            <Button href={"/author"}>Cancel</Button>
        </form>
    )
}