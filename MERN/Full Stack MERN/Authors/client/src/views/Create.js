
import React, { useEffect, useState } from 'react'
import axios from 'axios';
import { useParams,useNavigate } from "react-router-dom";
import AuthorForm from '../components/AuthorForm';
const Create = () => {
    let navigate = useNavigate();
    const createAuthor = author => {
        axios.post('http://localhost:8000/api/author', author)
            .then(res=>{console.log(res);
                ;navigate("/author")})
            
    }
    return (
        <div>
                   <AuthorForm authorProp={createAuthor} initialName=""  />
        </div>
    )}

export default Create