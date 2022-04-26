import React,{useState} from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import axios from "axios";
import { useNavigate, Link } from 'react-router-dom';
import { Button } from 'react-bootstrap';

export default() =>{
    const [name, setName] = useState("");
    const [position, setPosition] = useState("");
    const navigate = useNavigate();
    const [errors, setErrors] = useState([]); 
    const onSubmitHandler = e =>{
        e.preventDefault();
        axios.post('http://localhost:8000/api/player', {
            name,
            position
        })
        .then((res) => {
            console.log("Response, ", res);
            navigate("/player");
          })
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
            <h1>Add Player</h1>
            {errors.map((err, index) => <p key={index}>{err}</p>)}
            <p>
                <label>Name</label><br/>
                <input type="text" onChange={(e)=>setName(e.target.value)} value={name}/>
            </p>
            <p>
                <label>Position</label><br/>
                <input type="text" onChange={(e)=>setPosition(e.target.value)} value={position}/>
            </p>
            <input type="submit"/>
            <Button href={"/player"}>Cancel</Button>
        </form>
    )
}