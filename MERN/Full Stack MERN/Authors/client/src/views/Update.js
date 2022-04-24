import React, { useEffect, useState } from 'react'
import "bootstrap/dist/css/bootstrap.min.css";
import axios from 'axios';
import { useParams } from "react-router-dom";
import { Button } from 'react-bootstrap';
    
const Update = (props) => {
    const { id } = useParams();
    const [name, setName] = useState('');
    
    useEffect(() => {
        axios.get('http://localhost:8000/api/author/' + id)
            .then(res => {
                setName(res.data.name);
            })
    }, []);
    const [errors, setErrors] = useState([]); 
    const updateAuthor = e => {
        e.preventDefault();
        axios.put('http://localhost:8000/api/author/' + id, {
            name
        })
            .then(res => console.log(res))
            .catch((error) => {
                const errorResponse = error.response.data.errors;
        
                const errorArr = [];
                for (const key of Object.keys(errorResponse)) {
                  // Loop through all errors and get the messages
                  errorArr.push(errorResponse[key].message);
                }
                setErrors(errorArr);
              });
   
    }
    
    return (
        <div>
            <h1>Update a Author</h1>
            {errors.map((error, index) => (
            <p className="text-danger" key={index}>
            {error}
            </p>
            ))}
            <form onSubmit={updateAuthor}>
                <p>
                    <label>Name</label><br />
                    <input type="text" 
                    name="name" 
                    value={name} 
                    onChange={(e) => { setName(e.target.value) }} />
                </p>
                <input type="submit" />
                <Button href={"/author"}>Cancel</Button>
            </form>
            {/* { loaded && (
                       <>
                   <AuthorForm authorProp={updateAuthor} initialName={author.name}  />
                   <DeleteButton authorId={author._id} successCallback={()=>navigate("/author")}/></>)} */}
        </div>
    )
}
    
export default Update;
