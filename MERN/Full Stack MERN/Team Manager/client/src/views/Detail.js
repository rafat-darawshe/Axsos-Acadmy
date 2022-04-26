import React, { useEffect, useState } from 'react'
import axios from 'axios';
import { useParams, Link, useNavigate } from "react-router-dom";
    
const Detail = (props) => {
    const [player, setPlayer] = useState({})
    const { id } = useParams();
    // const navigate = useNavigate();
    
    useEffect(() => {
        axios.get('http://localhost:8000/api/player/'+id)
            .then(res => setPlayer(res.data))
            .catch(err => console.error(err));
    }, []);
    
    return (
        <div>
            <p>Name: {player.name}</p>
            <p>Position: {player.position}</p>
            <Link to={"/player/" + player._id + "/edit"}>
                Edit
            </Link>
        </div>
    )
}
    
export default Detail;
