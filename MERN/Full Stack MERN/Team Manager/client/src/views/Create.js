
import React, { useEffect, useState } from 'react'
import axios from 'axios';
import { useParams,useNavigate } from "react-router-dom";
import PlayerForm from '../components/PlayerForm';
const Create = () => {
    let navigate = useNavigate();
    const createPlayer = player => {
        axios.post('http://localhost:8000/api/player', player)
            .then(res=>{console.log(res);
                ;navigate("/player")})
            
    }
    return (
        <div>
                   <PlayerForm playerProp={createPlayer} initialName=""  />
        </div>
    )}

export default Create